package ejb;

import java.util.List;

import javax.ejb.Local;

import entities.Equipe;
import entities.Tournoi;

@Local
public interface TournoiManagerItf {

	boolean addTournoi(Tournoi t);
	public boolean addEquipeTournoi(Tournoi t,Equipe e);
	public List<String> allTournois();
	public Tournoi getTournoi(String nom_tournoi);
	public boolean isNameTaken(String name);
	public void removeEquipeTournoi(Tournoi t, Equipe e);
	public void removeTournoi(Tournoi t);

}
