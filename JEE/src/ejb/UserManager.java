package ejb;
import java.util.List;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import entities.Equipe;
import entities.Joueur;

@Stateless(name="UserManager1")
@Local(UserManagerItf.class)
public class UserManager implements UserManagerItf {
	
	@PersistenceContext
	private EntityManager em;
	
	@Override
	public boolean addUser(Joueur j) {
		Joueur jexist = em.find(Joueur.class, j.getLogin());
		if(jexist==null) {
			em.persist(j);
			return true;
		} else {
			System.out.println("Le joueur existe déjà dans la bdd");
			return false;
		}
	}
	
	public void addAmi(Joueur j_logged,Joueur j_asked,int ami_type) {
		j_logged=em.find(Joueur.class,j_logged.getLogin());
		j_asked=em.find(Joueur.class, j_asked.getLogin());
		if(ami_type==0) {
			j_logged.addAmi(j_asked,"A");
			j_asked.addAmi(j_logged,"A");
		} else if(ami_type==1) {
			j_logged.addAmi(j_asked,"C");
			j_asked.addAmi(j_logged, "IC");
		} else if(ami_type==2) {
			j_logged.addAmi(j_asked,"IC");
			j_asked.addAmi(j_logged, "C");
		}
		em.merge(j_logged);
		em.merge(j_asked);
		em.flush();
	}
	
	public void removeAmi(Joueur j_logged,Joueur j_asked) {
		j_logged.removeAmi(j_asked);
		j_asked.removeAmi(j_logged);
		em.merge(j_asked);
		em.merge(j_logged);
		em.flush();
	}
	
	public void setEquipe(Joueur j_logged,Equipe e) {
		j_logged.setEquipe(e);
		em.merge(j_logged);
	}
	
	public void setCandidature(Joueur j_logged,Equipe e) {
		j_logged.setCandidature(e);
		em.merge(j_logged);
		em.flush();
	}
	
	public Joueur getJoueur(String login) {
		return em.find(Joueur.class, login);
	}

	@Override
	public boolean isNameTaken(String nick) {
		boolean nameTaken = false;
		Query qu = em.createQuery("SELECT j.login FROM Joueur j");
		List<String> loginList = (List<String>) qu.getResultList();
		for (String s : loginList) {
			if (nick.equals(s)) {
				nameTaken = true;
			}
		}
		return nameTaken;
	}
	
	public List<String> allPlayers() {
		Query qu = em.createQuery("SELECT j.login FROM Joueur j");
		return (List<String>) qu.getResultList();
	}

	@Override
	public boolean isEmailUsed(String mail) {
		boolean mailTaken = false;
		Query qu = em.createQuery("SELECT j.mail FROM Joueur j");
		List<String> mailList = (List<String>) qu.getResultList();
		for(String s : mailList) {
			if (mail.equals(s)) {
				mailTaken = true;
			}
		}
		return mailTaken;
	}
	
}
