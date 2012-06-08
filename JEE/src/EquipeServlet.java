
import java.io.IOException;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entities.Equipe;
import entities.Joueur;

/**
 * Servlet implementation class EquipeServlet
 */
public class EquipeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	UserManagerItf userManager;
	EquipeManagerItf equipeManager;  
    /**
     * @throws NamingException 
     * @see HttpServlet#HttpServlet()
     */
    public EquipeServlet() throws NamingException {
        super();
        InitialContext ic = new InitialContext();
        userManager = (UserManagerItf) ic.lookup("UserManager1/local");
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
        if (action.equals("registerEquipe")) {  
             String ename = request.getParameter("equipenamesignup");
             String slogan = request.getParameter("slogansignup");
             if(equipeManager.isNameTaken(ename)) {
            	 nextPage="CreationEquipe.jsp";
            	 request.setAttribute("ename_taken", new Boolean(true));
             } else {
            	 Joueur j_logged = (Joueur)request.getSession().getAttribute("JoueurActuel");
            	 if(j_logged==null) {
            		nextPage="Accueil.jsp";
            		request.getSession().setAttribute("ErrorMessage", "On ne peut créer une équipe sans être inscrit.");         		
            	 } else {
            		 Equipe e = new Equipe(ename,j_logged);
            		 if(slogan!=null) {
            			 e.setSlogan(slogan);          			 
            		 }
            		 equipeManager.addEquipe(e);
            		 userManager.setEquipe(j_logged, e);
            		 nextPage="Accueil.jsp";
            	 }
            	 
			}
		} else if (action.equals("profilEquipe")) {
			String ename = request.getParameter("ename");
			Equipe e = equipeManager.getEquipe(ename);
			if (e != null) {
				nextPage = "ProfilEquipe.jsp";
				request.setAttribute("EquipeActuelle", e);
			} else {
				nextPage = "Accueil.jsp";
				request.getSession().setAttribute("ErrorMessage","L'équipe de nom " + ename + " n'existe pas.");
			}

		}
        request.getRequestDispatcher(nextPage).forward(request, response);
	}

}
