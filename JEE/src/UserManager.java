

import java.io.IOException;

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
public class UserManager extends HttpServlet {
	private static final long serialVersionUID = 1L;
	EntityManager em;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserManager() {
        super();
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("PostgresDSjeeux");
		em = emf.createEntityManager();
		em.getTransaction().begin();
		System.out.println("EntityManager : " + emf.isOpen());
		emf.close();
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
		
	}

}
