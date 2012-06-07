import javax.ejb.Local;

import entities.Joueur;


@Local
public interface UserManagerItf {
	boolean addUser(Joueur j);
	boolean isNameTaken(String nick);
	boolean isEmailUsed(String mail);
	Joueur getJoueur(String login);
	void addAmi(Joueur j_logged, Joueur j_act);
}
