package servlets;
import java.io.IOException;
import java.util.List;

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
import entities.Tournoi;

/**
 * Servlet implementation class NavigationServlet
 */
public class NavigationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	UserManagerItf userManager;
	EquipeManagerItf equipeManager;
	TournoiManagerItf tournoiManager;

	/**
	 * @throws NamingException 
	 * @see HttpServlet#HttpServlet()
	 */
	public NavigationServlet() throws NamingException {
		super();
		InitialContext ic = new InitialContext();
		userManager = (UserManagerItf) ic.lookup("UserManager1/local");
		equipeManager = (EquipeManagerItf) ic.lookup("EquipeManager/local");
		tournoiManager = (TournoiManagerItf) ic.lookup("TournoiManager/local");
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
		if (action.equals("listeJoueurs")) {
			List<String> allJoueurs = userManager.allPlayers();
			request.setAttribute("ListeJoueurs", allJoueurs);
			nextPage="ListJoueurs.jsp";
			request.setAttribute("page", nextPage);
		} else if(action.equals("listeEquipes")) {
			List<Equipe> listeEquipes = equipeManager.allEquipes();
			request.setAttribute("ListeEquipes",listeEquipes);
			nextPage="ListEquipes.jsp";
			request.setAttribute("page", nextPage);
		} else if(action.equals("creerEquipe")) {
			nextPage="CreationEquipe.jsp";
			request.setAttribute("page", nextPage);
		} else if(action.equals("accueil")) {
			nextPage="Accueil.jsp";
			request.setAttribute("page", nextPage);
		} else if(action.equals("listeJeux")) {
			nextPage="ListJeux.jsp";
			request.setAttribute("page", nextPage);
		} else if(action.equals("listeSalons")) {
			nextPage="ListSalons.jsp";
			request.setAttribute("page", nextPage);
		} else if(action.equals("listeReplays")) {
			nextPage="ListReplays.jsp";
			request.setAttribute("page", nextPage);
		} else if(action.equals("listeTournois")) {
			List<String> listeTournois = tournoiManager.allTournois();
			request.setAttribute("ListeTournois",listeTournois);
			nextPage="ListTournois.jsp";
			request.setAttribute("page", nextPage);
		} else if(action.equals("listeSalons")) {
			nextPage="ListSalons.jsp";
			request.setAttribute("page", nextPage);
		}  else if(action.equals("creationCompte")) {
			nextPage="CreationCompte.jsp";
			request.setAttribute("page", nextPage);
		} 
		request.getRequestDispatcher(nextPage).forward(request, response);
	}

}
