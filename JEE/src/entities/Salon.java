package entities;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

@Entity
public class Salon implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Column(unique=true, nullable=false)
	@Id
	private String name;
	
	@OneToOne
	private Equipe equipe;	
	
	@OneToMany
	private Set<Partie> partie;	

	public Salon() {
	}
	
	public Salon(String name) {
		this.setName(name);
		this.setPartie(new HashSet<Partie>());
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
	
	public Set<Partie> getPartie() {
		return this.partie;
	}
	
	public void setPartie(Set<Partie> partie) {
		this.partie = partie;
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
