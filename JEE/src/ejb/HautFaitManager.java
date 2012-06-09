package ejb;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import entities.HautFait;

@Stateless(name="HautFaitManager")
@Local(HautFaitManagerItf.class)
public class HautFaitManager implements HautFaitManagerItf {
	
	@PersistenceContext
	private EntityManager em;
	
	@Override
	public boolean addHautFait(HautFait f) {
		HautFait tf = em.find(HautFait.class, f.getNom());
		if(tf==null) {
			em.persist(f);
			return true;
		} else {
			System.out.println("Le tournoi existe déjà dans la bdd");
			return false;
		}
	}
	
}
