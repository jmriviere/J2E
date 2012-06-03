import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


@Stateless(name="UserManager")
@Local(UserManagerItf.class)
public class UserManager implements UserManagerItf {
	@PersistenceContext
	private EntityManager em;
	
	public boolean addUser(Joueur j) {
		Joueur jexist = em.find(Joueur.class, j.getLogin());
		if(jexist==null) {
			em.persist(j);
			return true;
		} else {
			return false;
		}
		
	}

}
