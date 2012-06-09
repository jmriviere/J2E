package ejb;

import java.util.ArrayList;
import java.util.List;
import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import entities.Equipe;
import entities.Partie;
import entities.Salon;

@Stateless(name="SalonManager")
@Local(SalonManagerItf.class)
public class SalonManager implements SalonManagerItf{

	@PersistenceContext
	private EntityManager em;
	
	public List<Salon> allSalons() {
		Query qu = em.createQuery("SELECT s.name FROM Salon s");
		List<String> res = (List<String>) qu.getResultList();
		List<Salon> salons = new ArrayList<Salon>();
		for (String sname : res) {
			 salons.add(em.find(Salon.class, sname));
		}
		return salons;
	}
	
	public Salon getSalon(String name){
		return em.find(Salon.class, name);		
	}
	
	public boolean addSalon(Salon s) {
		Salon sexist = em.find(Salon.class, s.getName());
		if(sexist==null) {
			em.persist(s);
			return true;
		} else {
			return false;
		}
	}
	
	public boolean isNameTaken(String newName) {
		Query qu = em.createQuery("SELECT s.name FROM Salon s");
		List<String> res = (List<String>) qu.getResultList();
		for (String sname : res) {
			 if(newName.equals(sname)) {
				 return true;
			 }
		}
		return false;
	}
	
	public void eraseSalon(Salon s) {
		Salon ns = getSalon(s.getName());
		em.remove(ns);
		em.flush();
	}
	
	public void setEquipeSalon(Salon s,Equipe e) {
		s.setEquipe(e);
		em.merge(s);
	}
	
}
