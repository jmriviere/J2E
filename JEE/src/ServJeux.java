

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ServJeux
 */
public class ServJeux extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ServJeux() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String act = request.getParameter("act");
		if (act.equals("profJoueurPub")) {
			String joueurCible = request.getParameter("joueurCible");
			String page = request.getParameter("page");
			if (page.equals("Hauts faits")) {
				// envoyer les infos necessaires
				request.getRequestDispatcher("hautsFaits.jsp").forward(request,
						response);
			} else if (page.equals("Replays récents")) {
				// envoyer les infos necessaires
				request.getRequestDispatcher("replaysRecents.jsp").forward(
						request, response);
			} else if (page.equals("Equipe")) {
				// envoyer les infos necessaires
				request.getRequestDispatcher("equipe.jsp").forward(request,
						response);
			} else if (page.equals("Rajouter en amis")) {
				// faire le bordel
			} else if (page.equals("Inviter à discuter")) {
				// faire le bordel
			}
		} else if (act.equals("profJoueurPri")) {
			String joueurCible = request.getParameter("joueurCible");
			String page = request.getParameter("page");
			if (page.equals("Hauts faits")) {
				// envoyer les infos necessaires
				request.getRequestDispatcher("hautsFaits.jsp").forward(request,
						response);
			} else if (page.equals("Replays récents")) {
				// envoyer les infos necessaires
				request.getRequestDispatcher("replaysRecents.jsp").forward(
						request, response);
			} else if (page.equals("Equipe")) {
				// envoyer les infos necessaires
				request.getRequestDispatcher("equipe.jsp").forward(request,
						response);
			} else if (page.equals("configuration.jsp")) {
				// envoyer les infos necessaires
				request.getRequestDispatcher("configuration.jsp").forward(request,
						response);
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