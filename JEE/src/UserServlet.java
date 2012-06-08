

import java.io.IOException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Set;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entities.Equipe;
import entities.Joueur;

/**
 * Servlet implementation class UserServlet
 */
public class UserServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    UserManagerItf um;
    EquipeManagerItf equipeManager;
    /**
     * @throws NamingException 
     * @see HttpServlet#HttpServlet()
     */
    public UserServlet() throws NamingException {
        super();
        InitialContext ic = new InitialContext();
        um = (UserManagerItf) ic.lookup("UserManager1/local");
        equipeManager = (EquipeManagerItf) ic.lookup("EquipeManager/local");
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
        Joueur j_act = (Joueur)request.getSession().getAttribute("JoueurActuel");
        int error = 0;
        /*
         * error masque d'erreur:
         * Mail taken | Username taken | PW missmatch
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

            if (um.isNameTaken(username)) {
                error += 2;
            }

            if (um.isEmailUsed(mail)) {
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
        } else if(action.equals("profil")) {
        	String asked_login = request.getParameter("login");
        	if(j_act!=null) {
        		nextPage = "ProfilJoueur.jsp";        
        		request.setAttribute("asked_player", um.getJoueur(asked_login));
        	} else {
        		nextPage = "Accueil.jsp";
        		request.getSession().setAttribute("ErrorMessage", "On ne peut consulter les pages de membres sans être inscrit.");
        	}
        	
        } else if(action.equals("RajoutAmi")) { 	
        	String asked_login = request.getParameter("joueurCible");
        	Joueur j_asked = um.getJoueur(asked_login);
        	if(j_asked==null) {
        		request.getSession().setAttribute("ErrorMessage", "L'utilisateur de login "+asked_login+" n'existe pas.");
        	} else {
        		um.addAmi(j_act, j_asked , 1);
        	}
        	nextPage="ProfilJoueur.jsp";
        } else if(action.equals("BeginDiscussion")) {
        	System.out.println("Commencer la discussion");
        } else if(action.equals("joinEquipe")) {
        	Equipe e = equipeManager.getEquipe(request.getParameter("ename"));
        	um.setCandidature(j_act, e);
        } else if(action.equals("SupprCandidature")) {
        	String needed_player = request.getParameter("player");
        	if(needed_player==null) {
        		um.setCandidature(j_act, null);
        	} else {
        		um.setCandidature(um.getJoueur(needed_player),null);
        	}
        } else if(action.equals("SupprEquipe")) {
        	String needed_player = request.getParameter("player");
        	if(needed_player==null) {
	        	Equipe e = equipeManager.getEquipe(request.getParameter("ename"));
	        		        	
	        	// dissoudre l'équipe, si le joueur à supprimer est le chef
	        	if(e.getChef().equals(j_act)) {
	        		Set<Joueur> membres = e.getMembre();
	        		Set<Joueur> candidats = e.getCandidats();
	        		equipeManager.setEquipeChef(e, null);
	        		
	        		for (Joueur j : membres) {
	        			um.setEquipe(j, null);
	        		}
	        		for (Joueur j : candidats) {
	        			um.setCandidature(j, null);
	        		}
	        		equipeManager.eraseEquipe(e);
	        		nextPage="Accueil.jsp";
	        		
	        	} else {	        		
	        		um.setEquipe(j_act,null);
	        		nextPage = "ProfilJoueur.jsp";        
	        		request.setAttribute("asked_player", j_act.getLogin());
	        	}
	        		
        	} else {
        		Joueur j_needed = um.getJoueur(needed_player);
        		Equipe e = j_needed.getEquipe();
        		um.setEquipe(j_needed,null);
        		nextPage = "EquipeServlet";
        		request.setAttribute("ename",e.getName());       		
        	}
        } else if(action.equals("AccCandidature")) {
        	String needed_player = request.getParameter("player");
        	if(needed_player!=null) {
        		Joueur j = um.getJoueur(needed_player);
        		Equipe e = j.getCandidature();
        		um.setCandidature(j,null);
        		um.setEquipe(j, e);
        	}
        } else if(action.equals("AccCandidatureAmi")) {
        	String needed_player = request.getParameter("player");
        	if(needed_player!=null) {
        		Joueur j = um.getJoueur(needed_player);
        		um.addAmi(j, j_act,0);
        	}
        } else if(action.equals("SupprCandidatureAmi")) {
        	String needed_player = request.getParameter("player");
        	if(needed_player!=null) {
        		Joueur j = um.getJoueur(needed_player);
        		um.removeAmi(j_act, j);
        	}
        }
        request.getSession().setAttribute("JoueurActuel", um.getJoueur(j_act.getLogin()));
        request.getRequestDispatcher(nextPage).forward(request, response);
    }

}
