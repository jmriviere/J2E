import java.io.Serializable;
import java.util.List;
import javax.persistence.*;

@Entity

public class Partie implements Serializable {

	private static final long serialVersionUID = 1L;

	@Column(unique=true, nullable=false)
	@Id
	private int partieId;
	
	@Column(nullable=false)
	private Joueur joueur1;	
	
	@Column(nullable=false)
	private Joueur joueur2;
	
	@OneToMany
	private List<Coup> coup;	
	
	public Partie() {
		super();
	}
	
	
   
}
