import javax.ejb.Local;


@Local
public interface UserManagerItf {
	boolean addUser(Joueur j);
}
