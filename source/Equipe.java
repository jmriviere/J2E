// package ?

import java.util.List;
import javax.persistence.*;

@Entity
public class Equipe {
	
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
		
	public Equipe(String name, Joueur createur) {
		this.name = name;
		this.chef = createur;
		this.membre = new List<Joueur>();
		this.membre.add(createur);
		this.salon = new Salon(); // a voir avec constructeur de Salon
		this.hautFait = new List<HautFait>();
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
	
	public List<Joueur> getMembre() {
		return this.membre;
	}
	
	public void addMembre(Joueur membre) {
		this.membre.add(membre);
	}
	
	public List<HautFait> getHautFait() {
		return this.hautFait;
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

