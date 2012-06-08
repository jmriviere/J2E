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
import ejb.UserManagerItf;
import entities.Equipe;

/**
 * Servlet implementation class NavigationServlet
 */
public class NavigationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	UserManagerItf userManager;
	EquipeManagerItf equipeManager;

	/**
	 * @throws NamingException 
	 * @see HttpServlet#HttpServlet()
	 */
	public NavigationServlet() throws NamingException {
		super();
		InitialContext ic = new InitialContext();
		userManager = (UserManagerItf) ic.lookup("UserManager1/local");
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
		// TODO Auto-generated method stub
		String action = request.getParameter("action");

		String nextPage = "";
		if (action.equals("listeJoueurs")) {
			List<String> allJoueurs = userManager.allPlayers();
			request.setAttribute("ListeJoueurs", allJoueurs);
			nextPage="ListJoueurs.jsp";
		} else if(action.equals("listeEquipes")) {
			List<Equipe> listeEquipes = equipeManager.allEquipes();
			request.setAttribute("ListeEquipes",listeEquipes);
			nextPage="ListEquipes.jsp";
		} else if(action.equals("creerEquipe")) {
			nextPage="CreationEquipe.jsp";
		} 
		request.getRequestDispatcher(nextPage).forward(request, response);
	}

}
