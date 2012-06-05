import java.io.Serializable;
import javax.persistence.*;

@Entity

public class Coup implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Column(unique=true, nullable=false)
	@Id
	private String name;
	
	@Column(nullable=false)
	private String jeu;

	public Coup() {
	}
	
	public Coup(String name, String jeu) {
		this.setName(name);
		this.setJeu(jeu);
	}
	
	public String getName() {
		return this.name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getJeu() {
		return this.jeu;
	}
	
	public void setJeu(String jeu) {
		this.jeu = jeu;
	}
   
}
