import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

@Entity
public class Salon implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Column(unique=true, nullable=false)
	@Id
	private String name;
	
	@Column(nullable=false)
	@OneToOne
	private Joueur chef;
	
	@OneToMany
	private List<Joueur> membre;
	
	@OneToOne
	private Salon salon;
	
	@ManyToMany
	private List<HautFait> hautFait;

	public Salon() {
		super();
	}
   
}
