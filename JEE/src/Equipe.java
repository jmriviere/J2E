import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;

@Entity
public class Equipe implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Column(unique=true, nullable=false)
	@Id
	private String name;
	
	@OneToOne
	private Joueur chef;
	
	@OneToMany
	private List<Joueur> membre;
	
	@OneToOne
	private Salon salon;
	
	@ManyToMany
	private List<HautFait> hautFait;
		
	public Equipe() {
	}
	
	public Equipe(String name, Joueur createur) {
		this.setName(name);
		this.setChef(createur);
		this.setMembre(new ArrayList<Joueur>());
		this.addMembre(createur);
		this.setSalon(new Salon(name));
		this.setHautFait(new ArrayList<HautFait>());
	}
	
	public String getName() {
		return this.name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public Joueur getChef() {
		return this.chef;
	}
	
	public void setChef(Joueur chef) {
		this.chef = chef;
	}
	
	public Salon getSalon() {
		return this.salon;
	}
	
	public void setSalon(Salon salon) {
		this.salon = salon;
	}
	
	public List<Joueur> getMembre() {
		return this.membre;
	}
	
	public void setMembre(List<Joueur> membre) {
		this.membre.addAll(membre);
	}
	
	public void addMembre(Joueur membre) {
		this.membre.add(membre);
	}
	
	public List<HautFait> getHautFait() {
		return this.hautFait;
	}
	
	public void setHautFait(List<HautFait> hautFait) {
		this.hautFait.addAll(hautFait);
	}
	
	public void addHautFait(HautFait hautFait) {
		this.hautFait.add(hautFait);
	}
	
	@Override
	public String toString() {
		return this.name;
	}
	
	@Override
	public boolean equals(Object other) {
		if (!(other instanceof Equipe)) {
			return false;
		}
		return this.getName().equals(((Equipe) other).getName());
	}
	
}

