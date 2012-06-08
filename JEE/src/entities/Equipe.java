package entities;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.*;

@Entity
public class Equipe implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Column(unique=true, nullable=false)
	@Id
	private String name;
	
	@Column(nullable=false)
	private String slogan;
	
	@ManyToOne
	private Joueur chef;
	
	@OneToMany(mappedBy="equipe", fetch=FetchType.EAGER)
	private Set<Joueur> membre;
	
	@OneToMany(mappedBy="candidature", fetch=FetchType.EAGER)
	private Set<Joueur> candidats;
	
	@OneToOne
	private Salon salon;
	
	@ManyToMany(fetch=FetchType.EAGER)
	private Set<HautFait> hautFait;
		
	public Equipe() {
	}
	
	public Equipe(String name, Joueur createur) {
		this.setName(name);
		this.setChef(createur);
		this.setMembre(new HashSet<Joueur>());
		this.addMembre(createur);
		this.setSalon(null);
		this.setHautFait(new HashSet<HautFait>());
	}
	
	public String getName() {
		return this.name;
	}
	
	public void setName(String name) {
		this.name = name;
	}

	public String getSlogan() {
		return slogan;
	}

	public void setSlogan(String slogan) {
		this.slogan = slogan;
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
	
	public Set<Joueur> getMembre() {
		return this.membre;
	}
	
	public void setMembre(Set<Joueur> membre) {
		this.membre = membre;
	}
	
	public void addMembre(Joueur membre) {
		this.membre.add(membre);
	}
	
	public Set<HautFait> getHautFait() {
		return this.hautFait;
	}
	
	public void setHautFait(Set<HautFait> hautFait) {
		this.hautFait = hautFait;
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

	public void addCandidat(Joueur j) {
		this.candidats.add(j);
	}
	
	public void removeCandidat(Joueur j) {
		candidats.remove(j);
	}
	
	public void removeCandidat(String jname) {
		Joueur Jrem = null;
		for(Joueur j : candidats) {
			if(jname.equals(j.getLogin())) {
				Jrem = j;
			}
		}
		if(Jrem!=null) {
			candidats.remove(Jrem);
		}
	}
	
	public Set<Joueur> getCandidats() {
		return candidats;
	}
	
}

