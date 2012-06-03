import java.io.IOException;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ServJeux
 */
public class ServJeux extends HttpServlet {
	private static final long serialVersionUID = 1L;
	EntityManager em;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ServJeux() {
		super();
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("PostgresDSjeeux");
		em = emf.createEntityManager();
		em.getTransaction().begin();
		Joueur j = new Joueur("derp","derpyderp","derp@j2esucks.com");
		em.persist(j);
		System.out.println("EntityManager : " + emf.isOpen());
		emf.close();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		System.out.println("bouh!!");
		// TODO Auto-generated method stub
		String act = request.getParameter("act");
		if (act.equals("profJoueurPub")) {
			String joueurCible = request.getParameter("joueurCible");
			String page = request.getParameter("page");
			if (page.equals("Rajouter en amis")) {
				// faire le bordel
			} else if (page.equals("Inviter à discuter")) {
				// faire le bordel
			} else {
				//erreur
			}
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}