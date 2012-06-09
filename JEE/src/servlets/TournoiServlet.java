package servlets;

import java.io.IOException;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ejb.EquipeManagerItf;
import ejb.TournoiManagerItf;
import ejb.UserManagerItf;
import entities.Equipe;
import entities.Joueur;
import entities.Tournoi;

public class TournoiServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	UserManagerItf userManager;
	TournoiManagerItf tournoiManager;  
	EquipeManagerItf equipeManager;
	
    /**
     * @throws NamingException 
     * @see HttpServlet#HttpServlet()
     */
    public TournoiServlet() throws NamingException {
        super();
        InitialContext ic = new InitialContext();
        userManager = (UserManagerItf) ic.lookup("UserManager1/local");
        tournoiManager = (TournoiManagerItf) ic.lookup("TournoiManager/local");
        equipeManager = (EquipeManagerItf) ic.lookup("EquipeManager/local");
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String action = request.getParameter("action");
		String nextPage = "";
        if (action.equals("registerTournoi")) {  
             String tname = request.getParameter("tournoinamesignup");
             String nbeq = request.getParameter("nbeqsignup");
             if(tournoiManager.isNameTaken(tname)) {
            	 nextPage="TournoiServlet.jsp";
            	 request.setAttribute("tname_taken", new Boolean(true));
             } else {
            	 Joueur j_logged = (Joueur)request.getSession().getAttribute("JoueurActuel");
            	 if(j_logged==null) {
            		nextPage="Accueil.jsp";
            		request.getSession().setAttribute("ErrorMessage", "On ne peut créer un tournoi sans être inscrit.");         		
            	 } else {
            		 if(j_logged.getEquipe().getChef().equals(j_logged)) {
	            		 Tournoi t = new Tournoi(tname,j_logged);
	            		 if(nbeq!=null) {
	            			 t.setNombre_max_equipes(new Integer(nbeq));          			 
	            		 }
	            		 tournoiManager.addTournoi(t);
	            		 nextPage="Accueil.jsp";
            		 } else {
            			 nextPage="Accueil.jsp";
                 		 request.getSession().setAttribute("ErrorMessage", "On ne peut créer un tournoi sans être chef d'équipe");        
            		 }
            	 }
            	 
			}
		} else if (action.equals("profilTournoi")) {
			String tname = request.getParameter("tname");
			Tournoi t = tournoiManager.getTournoi(tname);
			if (t != null) {
				nextPage = "ProfilTournoi.jsp";
				request.setAttribute("TournoiActuel", t);
			} else {
				nextPage = "Accueil.jsp";
				request.getSession().setAttribute("ErrorMessage","Le tournoi de nom " + tname + " n'existe pas.");
			}
		} else if(action.equals("joindreTournoi")) {
			String ename = request.getParameter("ename");
			Equipe e = equipeManager.getEquipe(ename);
			String tname = request.getParameter("tname");
			Tournoi t = tournoiManager.getTournoi(tname);
			if(t!=null) {
				if(e!=null) {
					if(!tournoiManager.addEquipeTournoi(t, e)) {
						request.getSession().setAttribute("ErrorMessage","Il n'y a plus de places dans ce tournoi");
					}
				} else {
					request.getSession().setAttribute("ErrorMessage","L'équipe de nom " + ename + " n'existe pas.");
				}
			} else {
				request.getSession().setAttribute("ErrorMessage","Le tournoi de nom " + tname + " n'existe pas.");
			}
			nextPage = "Accueil.jsp";
		} else if(action.equals("SupprEquipe")) {
			String ename = request.getParameter("ename");
			Equipe e = equipeManager.getEquipe(ename);
			String tname = request.getParameter("tname");
			Tournoi t = tournoiManager.getTournoi(tname);
			tournoiManager.removeEquipeTournoi(t, e);
		} else if(action.equals("FinirTournoi")) {
			String tname = request.getParameter("tname");
			Tournoi t = tournoiManager.getTournoi(tname);
			
			Equipe e_max_score=null;
			int max_score=-1;
			for(Equipe e : t.getEquipes_participantes().keySet()) {
				if(t.getEquipes_participantes().get(e)>max_score) {
					e_max_score=e;
				}
			}
			//e_max_score a gagné le tournoi.
			
			
			tournoiManager.removeTournoi(t);
			nextPage = "Accueil.jsp";
		}
        request.getRequestDispatcher(nextPage).forward(request, response);
	}
}
