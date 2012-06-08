import java.util.List;

import javax.ejb.Local;

import entities.Equipe;
import entities.Joueur;


@Local
public interface UserManagerItf {
	boolean addUser(Joueur j);
	boolean isNameTaken(String nick);
	boolean isEmailUsed(String mail);
	Joueur getJoueur(String login);
	void addAmi(Joueur j_logged, Joueur j_act);
	public void setEquipe(Joueur j_logged,Equipe e);
	public void setCandidature(Joueur j_logged,Equipe e);
	public List<String> allPlayers();
	public void addIncomingCandidatAmi(Joueur j_act,Joueur j_candidat);
	public void removeIncomingCandidatAmi(Joueur j_act,Joueur j_candidat);
}
