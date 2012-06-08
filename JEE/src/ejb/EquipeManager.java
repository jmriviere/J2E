package ejb;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import entities.Equipe;
import entities.Joueur;

@Stateless(name="EquipeManager")
@Local(EquipeManagerItf.class)
public class EquipeManager implements EquipeManagerItf{

	@PersistenceContext
	private EntityManager em;
	
	public List<Equipe> allEquipes() {
		Query qu = em.createQuery("SELECT e.name FROM Equipe e");
		List<String> res = (List<String>) qu.getResultList();
		List<Equipe> equipes = new ArrayList<Equipe>();
		for (String ename : res) {
			 equipes.add(em.find(Equipe.class, ename));
		}
		return equipes;
	}
	
	public void eraseEquipe(Equipe e) {
		Equipe ne = getEquipe(e.getName());
		em.remove(ne);
		em.flush();
	}
	
	public void setEquipeChef(Equipe e,Joueur j) {
		e.setChef(j);
		em.merge(e);
	}
	
	public void addCandidature(Equipe e,Joueur j) {
		e.addCandidat(j);
		j.setCandidature(e);
		em.merge(e);
		em.merge(j);
	}
	
	public Equipe getEquipe(String name) {
		return em.find(Equipe.class, name);
	}
	
	public boolean isNameTaken(String nick) {
		Query qu = em.createQuery("SELECT e.name FROM Equipe e");
		List<String> res = (List<String>) qu.getResultList();
		for (String ename : res) {
			 if(nick.equals(ename)) {
				 return true;
			 }
		}
		return false;
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
