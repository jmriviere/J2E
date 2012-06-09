package servlets;
import java.io.IOException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ejb.UserManagerItf;
import entities.Joueur;

/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	UserManagerItf um;
       
    /**
     * @throws NamingException 
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() throws NamingException {
        super();
        InitialContext ic = new InitialContext();
        um = (UserManagerItf) ic.lookup("UserManager1/local");
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("");
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		String nextPage="Accueil.jsp";
		if(action.equals("login")) {
			String login = request.getParameter("login");
			String pass = request.getParameter("pass");
			Joueur j = um.getJoueur(login);
			if(j!=null) {
				MessageDigest md=null;
				try {
					md = MessageDigest.getInstance("MD5");
				} catch (NoSuchAlgorithmException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				md.update(pass.getBytes(), 0, pass.length());
				String hashpass = new BigInteger(1, md.digest()).toString(16);
				if(hashpass.equals(j.getPassword())) {
					request.getSession().setAttribute("JoueurActuel", j);
					// logged
				} else {
					request.getSession().setAttribute("ErrorMessage", "Mauvais Password");
					// not logged
				}
			} else {
				request.getSession().setAttribute("ErrorMessage", "	Mauvais Login");
			}
		} else if(action.equals("logout")) {
			request.getSession().removeAttribute("JoueurActuel");
		}
		request.setAttribute("page", nextPage);
		request.getRequestDispatcher(nextPage).forward(request, response);
		// TODO Auto-generated method stub
	}

}
