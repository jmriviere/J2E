package entities;
import java.io.Serializable;

import javax.persistence.*;

@Entity
public class HautFait implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Column(unique=true, nullable=false)
	@Id
	private String name;
	
	private String description;
	
	@Column(nullable=false)
	private int nbPoint;
	
	@Column(nullable=false)
	private int nbVictoireTicTacToe;
	
	@Column(nullable=false)
	private int nbVictoireShiFuMi;
	
	public HautFait() {
	}
   
	public HautFait(String name, String description, int nbPoint, int nbVictoireTicTacToe, int nbVictoireShiFuMi) {
		this.setName(name);
		this.setDescription(description);
		this.setNbVictoireShiFuMi(nbVictoireShiFuMi);
		this.setNbPoint(nbPoint);
		this.setNbVictoireTicTacToe(nbVictoireTicTacToe);
	}
	
	public String getName() {
		return this.name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getDescription() {
		return this.description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	public int getNbPoint() {
		return this.nbPoint;
	}
	
	public void setNbPoint(int point) {
		this.nbPoint = point;
	}
	
	public int getNbVictoireTicTacToe() {
		return this.nbVictoireTicTacToe;
	}
	
	public void setNbVictoireTicTacToe(int nbVictoireTicTacToe) {
		this.nbVictoireTicTacToe = nbVictoireTicTacToe;
	}
	
	public int getNbVictoireShiFuMi() {
		return this.nbVictoireShiFuMi;
	}
	
	public void setNbVictoireShiFuMi(int nbVictoireShiFuMi) {
		this.nbVictoireShiFuMi = nbVictoireShiFuMi;
	}
	
	@Override
	public String toString() {
		return this.name;
	}
	
	@Override
	public boolean equals(Object other) {
		if (!(other instanceof HautFait)) {
			return false;
		}
		return this.getName().equals(((HautFait) other).getName());
	}
	
}
