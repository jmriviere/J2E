package entities;
import java.io.Serializable;
import javax.persistence.*;

@Entity
public class HautFait implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Column(unique=true, nullable=false)
	@Id
	private String nom_tournoi_gagne;
	
	private Integer score;
	
	public HautFait() {
		this.setNom("");
		this.setScore(0);
	}
	
	public HautFait(String tournoi,Integer superscore) {
		this.nom_tournoi_gagne=tournoi;
		this.score=superscore;
	}
	
	public String getNom() {
		return nom_tournoi_gagne;
	}

	public void setNom(String nom_tournoi_gagne) {
		this.nom_tournoi_gagne = nom_tournoi_gagne;
	}

	public Integer getScore() {
		return score;
	}

	public void setScore(Integer score) {
		this.score = score;
	}

}
