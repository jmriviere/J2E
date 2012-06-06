

import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class MorpionServlet
 */
public class MorpionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private String coupCourant;
    
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MorpionServlet() {
        super();
        this.coupCourant = "-1";
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println(this.coupCourant);
		String coup = request.getParameter("coup");
		//if (coup.equals("jeu")) {
			try {
				response.setContentType("application/x-java-serialized-object");
			
				String msg = "fail";
				while (msg.equals("fail")) {
					try {
						InputStream ins = request.getInputStream();
						ObjectInputStream inputFromApplet = new ObjectInputStream(
								ins);
						msg = (String) inputFromApplet.readObject();
					} catch (EOFException eofe) {
						//e.printStackTrace();
						msg = "fail";
						System.out.println(msg);
					}
				}
				System.out.println(msg);
				OutputStream outs = response.getOutputStream();
				ObjectOutputStream oos = new ObjectOutputStream(outs);
				
				if (msg.equals("attente")) {
					oos.writeObject(this.coupCourant);
					oos.flush();
					oos.close();
				} else {
					this.coupCourant = msg;
					System.out.println("coup joue: " + this.coupCourant);
					oos.writeObject("hack");
					oos.flush();
					oos.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		/*} else if (coup.equals("attente")) {
			try {
				response.setContentType("application/x-java-serialized-object");
				OutputStream outs = response.getOutputStream();
				ObjectOutputStream oos = new ObjectOutputStream(outs);
				oos.writeObject(this.coupCourant);
				oos.flush();
				oos.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		*/
	}

}
