import java.util.List;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

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
