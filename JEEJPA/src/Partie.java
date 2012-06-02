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
	private Equipe equipe;	
	
	@Column(unique=true, nullable=true)
	private String region;
	
	@OneToMany
	private List<Partie> partie;	

	
	
	public Partie() {
		super();
	}
   
}
