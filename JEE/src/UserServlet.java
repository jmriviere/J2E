

import java.io.IOException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class UserManager
 */
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	//EntityManager em;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserServlet() {
        super();
//      EntityManagerFactory emf = Persistence.createEntityManagerFactory("PostgresDSjeeux");
//		em = emf.createEntityManager();
//		em.getTransaction().begin();
//		System.out.println("EntityManager : " + emf.isOpen());
//		emf.close();
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
		if (action.equals("register")) {
			String username = request.getParameter("usernamesignup");
			String pass = request.getParameter("passwordsignup");
			String pass_confirm = request.getParameter("passwordconfirmsignup");
			String mail = request.getParameter("emailsignup");
			String name = request.getParameter("namesignup");
			String surname = request.getParameter("snamesignup");
			String sexe = request.getParameter("sexsignup");
			String region = request.getParameter("regionsignup");
			if(pass_confirm.equals(pass)) {
				try {
					MessageDigest md = MessageDigest.getInstance("MD5");
					md.update(pass.getBytes(), 0, pass.length());
					String hashpass = new BigInteger(1, md.digest()).toString(16);
					System.out.println(hashpass);
				} catch (NoSuchAlgorithmException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}

}
