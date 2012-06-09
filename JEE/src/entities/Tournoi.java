package entities;
import java.util.HashMap;
import java.util.Map;

import javax.persistence.*;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

@Entity
public class Tournoi {

	private static final long serialVersionUID = 1L;
	
	@Column(unique=true, nullable=false)
	@Id
	private String nom_tournoi;
	
	@Fetch(FetchMode.JOIN)
	@ElementCollection
    @MapKeyColumn(name="nomEquipe")
    @Column(name="points")
	private Map<Equipe,Integer> equipes_participantes;
	
	private Integer nombre_max_equipes;
	
	@ManyToOne
	private Joueur manager;	

	public Tournoi() {
		this.setNom("");
		this.setEquipes_participantes(new HashMap<Equipe,Integer>());
		this.setNombre_max_equipes(-1);
		this.setManager(null);
	}
	
	public Tournoi(String nom_tournoi,Joueur j) {
		this.setNom(nom_tournoi);
		this.setEquipes_participantes(new HashMap<Equipe,Integer>());
		this.setNombre_max_equipes(-1);
		this.setManager(j);
		this.addEquipe(j.getEquipe());
	}
	
	public Integer getNombre_max_equipes() {
		return nombre_max_equipes;
	}

	public void setNombre_max_equipes(Integer nombre_max_equipes) {
		this.nombre_max_equipes = nombre_max_equipes;
	}
	
	public String getNom() {
		return nom_tournoi;
	}

	public void setNom(String nom_tournoi) {
		this.nom_tournoi = nom_tournoi;
	}

	public Map<Equipe, Integer> getEquipes_participantes() {
		return equipes_participantes;
	}

	public void setEquipes_participantes(Map<Equipe, Integer> equipes_participantes) {
		this.equipes_participantes = equipes_participantes;
	}
	
	public boolean addEquipe(Equipe e) {
		if(nombre_max_equipes==-1 || equipes_participantes.size()<nombre_max_equipes) {
			equipes_participantes.put(e, new Integer(0));
			return true;
		} else {
			return false;
		}
	}
	
	public void removeEquipe(Equipe e) {
		for (Equipe e2 : equipes_participantes.keySet()) {
			if(e2.equals(e)) {
				equipes_participantes.remove(e2);
				break;
			}
		}
	}
	
	public int nombreEquipes() {
		return equipes_participantes.size();
	}

	public Joueur getManager() {
		return manager;
	}

	public void setManager(Joueur manager) {
		this.manager = manager;
	}

}
