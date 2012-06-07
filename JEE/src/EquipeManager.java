import java.util.List;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import entities.Equipe;

@Stateless(name="EquipeManager")
@Local(EquipeManagerItf.class)
public class EquipeManager implements EquipeManagerItf{

	@PersistenceContext
	private EntityManager em;
	
	public List<String> allEquipes() {
		Query qu = em.createQuery("SELECT e.name FROM Equipe e");
		return (List<String>) qu.getResultList();
	}
	
	public Equipe getEquipe(String name) {
		return em.find(Equipe.class, name);
	}
	
	public boolean addEquipe(Equipe e) {
		Equipe eexist = em.find(Equipe.class, e.getName());
		if(eexist==null) {
			em.persist(e);
			return true;
		} else {
			return false;
		}
	}
	
}
