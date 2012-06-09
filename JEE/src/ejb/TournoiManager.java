package ejb;

import java.util.List;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import entities.Equipe;
import entities.Tournoi;

@Stateless(name="TournoiManager")
@Local(TournoiManagerItf.class)
public class TournoiManager implements TournoiManagerItf {
	@PersistenceContext
	private EntityManager em;
	
	@Override
	public boolean addTournoi(Tournoi t) {
		Tournoi tf = em.find(Tournoi.class, t.getNom());
		if(tf==null) {
			em.persist(t);
			return true;
		} else {
			System.out.println("Le tournoi existe déjà dans la bdd");
			return false;
		}
	}
	
	public boolean addEquipeTournoi(Tournoi t,Equipe e) {
		boolean ret = t.addEquipe(e);
		if(ret) {
			em.merge(t);
		}
		return ret;
	}
	
	public List<String> allTournois() {
		Query qu = em.createQuery("SELECT t.nom_tournoi FROM Tournoi t");
		return (List<String>) qu.getResultList();
	}
	
	public boolean isNameTaken(String name) {
		Query qu = em.createQuery("SELECT t.nom_tournoi FROM Tournoi t");
		List<String> listeTournois = (List<String>) qu.getResultList();
		return listeTournois.contains(name);
	}
	
	public Tournoi getTournoi(String nom_tournoi) {
		return em.find(Tournoi.class, nom_tournoi);
	}
	
	public void removeEquipeTournoi(Tournoi t, Equipe e) {
		t  = getTournoi(t.getNom());
		t.removeEquipe(e);
		em.merge(t);
	}
	
	public void removeTournoi(Tournoi t) {
		t = getTournoi(t.getNom());
		em.remove(t);
		em.flush();
	}
}
