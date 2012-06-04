import javax.ejb.Local;


@Local
public interface UserManagerItf {
	boolean addUser(Joueur j);
	boolean isNameTaken(String nick);
	boolean isEmailUsed(String mail);
}