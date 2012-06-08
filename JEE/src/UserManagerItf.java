import java.util.List;
import java.util.Map;

import javax.ejb.Local;

import entities.Equipe;
import entities.Joueur;


@Local
public interface UserManagerItf {
	boolean addUser(Joueur j);
	boolean isNameTaken(String nick);
	boolean isEmailUsed(String mail);
	Joueur getJoueur(String login);
	void addAmi(Joueur j_logged, Joueur j_act,int ami_type);
	public void removeAmi(Joueur j_logged,Joueur j_asked);
	public void setEquipe(Joueur j_logged,Equipe e);
	public void setCandidature(Joueur j_logged,Equipe e);
	public List<String> allPlayers();
}
