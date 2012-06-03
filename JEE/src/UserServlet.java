

import java.io.IOException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class UserServlet
 */
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    UserManagerItf um;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserServlet() {
        super();
        this.um = new UserManager();
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
		String nextPage = "";
		if (action.equals("register")) {
			String hashpass = "";
			String username = request.getParameter("usernamesignup");
			String pass = request.getParameter("passwordsignup");
			String pass_confirm = request.getParameter("passwordconfirmsignup");
			String mail = request.getParameter("emailsignup");
			String name = request.getParameter("namesignup");
			String surname = request.getParameter("snamesignup");
			String sexe = request.getParameter("sexsignup");
			String region = request.getParameter("regionsignup");
			if (pass_confirm.equals(pass)) {
				try {
					MessageDigest md = MessageDigest.getInstance("MD5");
					md.update(pass.getBytes(), 0, pass.length());
					hashpass = new BigInteger(1, md.digest()).toString(16);
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
				nextPage = "CreationCompte.jsp";
			}
		}
		request.setAttribute("error", new Integer(error));
		request.getRequestDispatcher(nextPage).forward(request, response);
	}

}
