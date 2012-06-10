package servlets;

import java.io.IOException;
import java.io.InputStream;
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
        this.coupCourant = "-2";
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
        // TODO implement
        System.out.println(this.coupCourant);
        String coup = request.getParameter("coup");
        System.out.println("parameter coup:" + coup);
        byte[] buf = new byte[32];
        if (coup.equals("jeu")) {
            try {
                int len = 0;
                response.setContentType("application/x-java-serialized-object");
                InputStream ins = request.getInputStream();
                while(len == 0) {
                	 len = ins.read(buf);
                }
                System.out.println(len);
                String sbuf = new String(buf);
                this.coupCourant = sbuf;
                System.out.println("coup joue: " + this.coupCourant);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (coup.equals("attente")) {
            try {
                response.setContentType("application/x-java-serialized-object");
                OutputStream outs = response.getOutputStream();
                buf = this.coupCourant.getBytes();
                outs.write(buf);
                outs.flush();
                outs.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
