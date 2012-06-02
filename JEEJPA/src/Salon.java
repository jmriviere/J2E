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
	
	@Column(unique=true, nullable=true)
	private String region;
	
	@OneToMany
	private List<Partie> partie;	

	public Salon() {
		super();
	}
	
	public Salon(String name) {
		this.name = name;
	}
	
	public String getName() {
		return this.name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public Equipe getEquipe() {
		return this.equipe;
	}
	
	public void setEquipe(Equipe equipe) {
		this.equipe = equipe;
	}
	
	public String getRegion() {
		return this.region;
	}
	
	public void setRegion(String region) {
		this.region = region;
	}

	public List<Partie> getPartie() {
		return this.partie;
	}
	
	public void addPartie(Partie partie) {
		this.partie.add(partie);
	}

	@Override
	public String toString() {
		return this.name;
	}
	
	@Override
	public boolean equals(Object other) {
		if (!(other instanceof Salon)) {
			return false;
		}
		return this.getName().equals(((Salon) other).getName());
	}
}
