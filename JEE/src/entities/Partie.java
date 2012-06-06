package entities;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@Entity

public class Partie implements Serializable {

	private static final long serialVersionUID = 1L;

	@Column(unique=true, nullable=false)
	@Id
	private Integer partieId;
	
	@ManyToMany(mappedBy="partie")
	private List<Joueur> joueurs;	

	@Column(nullable=false)
	private String jeu;
	
	@ManyToOne
	private Joueur winner;
	
	@OneToMany
	private List<Coup> coup;	
	
	public Partie() {
	}
	
	public Partie(int partieId, Joueur joueur1, Joueur joueur2, String jeu) {
		this.setPartieId(partieId);
		this.setListeJoueur(new ArrayList<Joueur>());
		this.addJoueur(joueur1);
		this.addJoueur(joueur2);
		this.setCoup(new ArrayList<Coup>());
		this.setJeu(jeu);
	}
   
	public Integer getPartieId() {
		return this.partieId;
	}
	
	public void setPartieId(Integer partieId) {
		this.partieId = partieId;
	}
	
	public void setListeJoueur(List<Joueur> j) {
		this.joueurs=j;
	}
	
	public void addJoueur(Joueur j) {
		this.joueurs.add(j);
	}
	
	public String getJeu() {
		return this.jeu;
	}
	
	public void setJeu(String jeu) {
		this.jeu = jeu;
	}
	
	public Joueur getWinner() {
		return this.winner;
	}
	
	public void setWinner(Joueur winner) {
		this.winner = winner;
	}
	
	public List<Coup> getCoup() {
		return this.coup;
	}
	
	public void addCoup(Coup coup) {
		this.coup.add(coup);
	}
	
	public void setCoup(List<Coup> coup) {
		this.coup = coup;
	}
	
	@Override
	public String toString() {
		return this.partieId.toString();
	}
	
	@Override
	public boolean equals(Object other) {
		if (!(other instanceof Partie)) {
			return false;
		}
		return this.getPartieId().equals(((Partie) other).getPartieId());
	}
	
}
