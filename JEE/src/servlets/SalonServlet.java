package servlets;

import java.io.IOException;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ejb.EquipeManagerItf;
import ejb.SalonManagerItf;
import ejb.SalonManager;
import ejb.UserManagerItf;
import entities.Joueur;
import entities.Partie;
import entities.Equipe;
import entities.Salon;

/**
 * Servlet implementation class SalonServlet
 */
public class SalonServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	SalonManagerItf salonManager;
	EquipeManagerItf equipeManager;  
	/**
	 * @throws NamingException 
     * @see HttpServlet#HttpServlet()
     */
    public SalonServlet() throws NamingException {
        super();
        InitialContext ic = new InitialContext();
        salonManager = (SalonManagerItf) ic.lookup("UserManager1/local");
        equipeManager = (EquipeManagerItf) ic.lookup("EquipeManager/local");
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
		
		String action = request.getParameter("action");
		String nextPage = "";
		
        if (action.equals("registerSalon")) {
        	Joueur j_logged = (Joueur)request.getSession().getAttribute("JoueurActuel");
        	if(j_logged==null) {
        		nextPage="Accueil.jsp";
        		request.getSession().setAttribute("ErrorMessage", "On ne peut créer un salon sans être inscrit"); 
        	} else {
        		String sname = request.getParameter("nameRegisterSalon");
        		if(salonManager.isNameTaken(sname)) {
        			nextPage="CreationSalon.jsp";
        			request.setAttribute("sname_taken", new Boolean(true));
        		} else {
        			Salon s = new Salon(sname);
        			nextPage="ProfilSalon.jsp";
        			request.setAttribute("SalonActuel", s);
        			salonManager.addSalon(s);
        			Equipe eSalon = (Equipe) equipeManager.getEquipe((String)request.getAttribute("EquipeActuelle"));
        			if (eSalon!=null) {
        				salonManager.setEquipeSalon(s, eSalon);
        			}
        		}
        	}		 
        } else if (action.equals("profilSalon")) {
			String sname = request.getParameter("sname");
			Salon s = salonManager.getSalon(sname);
			if (s != null) {
				nextPage = "ProfilSalon.jsp";
				request.setAttribute("SalonActuel", s);
			} else {
				nextPage = "Accueil.jsp";
				request.getSession().setAttribute("ErrorMessage","Le salon " + sname + " n'existe pas.");
			}
        }
        request.setAttribute("page", nextPage);
        request.getRequestDispatcher(nextPage).forward(request, response);
	}
}
