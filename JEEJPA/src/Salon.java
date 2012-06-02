import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

@Entity
public class Salon implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Column(unique=true, nullable=false)
	@Id
	private String name;
	
	@Column(unique=true, nullable=true)
	private Equipe equipe;	
	
	@OneToMany
	private List<Partie> partie;	

	public Salon() {
		super();
	}
   
}
