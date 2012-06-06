

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

import entities.Joueur;

/**
 * Servlet implementation class UserServlet
 */
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    UserManagerItf um;
    /**
     * @throws NamingException 
     * @see HttpServlet#HttpServlet()
     */
    public UserServlet() throws NamingException {
        super();
        InitialContext ic = new InitialContext();
        um = (UserManagerItf) ic.lookup("UserManager1/local");
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		String action = request.getParameter("action");
		int error = 0;
		/*
		 * error masque d'erreur:
		 * Log/PW incorrect | Mail taken | Username taken | PW missmatch
		 */
		String nextPage = "";
		if (action.equals("register")) {
			String hashpass = "";
			String username = request.getParameter("usernamesignup");
			String pass = request.getParameter("passwordsignup");
			String pass_confirm = request.getParameter("passwordconfirmsignup");
			String mail = request.getParameter("emailsignup");
			String name = request.getParameter("namesignup");
			String surname = request.getParameter("snamesignup");
			String sexe = request.getParameter("sexe");
			String region = request.getParameter("region");
			if (pass_confirm.equals(pass)) {
				try {
					MessageDigest md = MessageDigest.getInstance("MD5");
					md.update(pass.getBytes(), 0, pass.length());
					hashpass = new BigInteger(1, md.digest()).toString(16);
					System.out.println(hashpass);
					pass = null;
					pass_confirm = null;
				} catch (NoSuchAlgorithmException e) {
					e.printStackTrace();
				}
			} else {
				error += 1;
			}
			
            if (!um.isNameTaken(username)) {
				//Do something
			} else {
				error += 2;
			}
			
			if (!um.isEmailUsed(mail)) {
				//Do something
			} else {
				error += 4;
			}
		    

			if (error == 0) {
				Joueur j = new Joueur(username, hashpass, mail);
				if (name != null) {
					j.setPrenom(name);
				}
				if (surname != null) {
					j.setNom(surname);
				}
				if (sexe != null) {
					j.setSexe(sexe);
				}
				if (region != null) {
					j.setRegion(region);
				}
				um.addUser(j);
				nextPage ="";
			} else {
				request.setAttribute("error", new Integer(error));
				nextPage = "CreationCompte.jsp";
			}
		}
		request.getRequestDispatcher(nextPage).forward(request, response);
	}

}
