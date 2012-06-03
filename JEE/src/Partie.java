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
	
	@Column(nullable=false)
	private Joueur joueur1;	
	
	@Column(nullable=false)
	private Joueur joueur2;

	@Column(nullable=false)
	private String jeu;
	
	@Column(nullable=true)
	private Joueur winner;
	
	@OneToMany
	private List<Coup> coup;	
	
	public Partie() {
		super();
	}
	
	public Partie(int partieId, Joueur joueur1, Joueur joueur2, String jeu) {
		this.partieId = partieId;
		this.joueur1 = joueur1;
		this.joueur2 = joueur2;
		this.coup = new ArrayList<Coup>();
		this.jeu = jeu;
	}
   
	public Integer getPartieId() {
		return this.partieId;
	}
	
	public void setPartieId(Integer partieId) {
		this.partieId = partieId;
	}
	
	public Joueur getJoueur1() {
		return this.joueur1;
	}
	
	public void setJoueur1(Joueur joueur1) {
		this.joueur1 = joueur1;
	}
	
	public Joueur getJoueur2() {
		return this.joueur2;
	}
	
	public void setJoueur2(Joueur joueur2) {
		this.joueur2 = joueur2;
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
	
	public void addCout(Coup coup) {
		this.coup.add(coup);
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
