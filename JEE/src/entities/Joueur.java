package entities;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;

@Entity
public class Joueur implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Column(unique=true, nullable=false)
	@Id
	private String login;
	
	@Column(nullable=false)
	private String password;
	
	@Column(unique=true, nullable=false)
	private String mail;	
	
	@Column(nullable=true)
	private String nom;
	
	@Column(nullable=true)
	private String prenom;
	
	@Column(nullable=true)
	private String region;
	
	@Column(nullable=true)
	private String sexe;
	
	// ensemble des informations pour les achievements
	
	@Column(nullable=false)
	private int nbPoint;
	
	@Column(nullable=false)
	private int nbVictoireTicTacToe;
	
	@Column(nullable=false)
	private int nbVictoireShiFuMi;
	
	//@ManyToOne
	//private Equipe equipe;
	
	//@ManyToMany
	//private List<Partie> partie;
	
	//@ManyToMany
	//private List<Joueur> ami;
	
	//@ManyToMany
	//private List<HautFait> hautFait;
	
	public Joueur() {
	}
		
	public Joueur(String login, String password, String mail) {
		this.setLogin(login);
		this.setPassword(password);
		this.setMail(mail);
		this.setNbPoint(0);
//		this.setPartie(new ArrayList<Partie>());
//		this.setAmi(new ArrayList<Joueur>());
//		this.setHautFait(new ArrayList<HautFait>());
		this.setNbVictoireTicTacToe(0);
		this.setNbVictoireShiFuMi(0);
	}
	
	public String getLogin() {
		return this.login;
	}
	
	public void setLogin(String login) {
		this.login = login;
	}
	
	public String getPassword() {
		return this.password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}

	public String getMail() {
		return this.mail;
	}
	
	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getNom() {
		return this.nom;
	}
	
	public void setNom(String nom) {
		this.nom = nom;
	}
	
	public String getPrenom() {
		return this.prenom;
	}
	
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	
	public String getRegion() {
		return this.region;
	}
	
	public void setRegion(String region) {
		this.region = region;
	}
	
	public String getSexe() {
		return this.sexe;
	}
	
	public void setSexe(String sexe) {
		this.sexe = sexe;
	}
	
	/*public List<Partie> getPartie() {
		return this.partie;
	}
	
	public void setPartie(List<Partie> partie) {
		this.partie = partie;
	}
	
	public void addPartie(Partie partie){
		this.partie.add(partie);
	}
		
	public Equipe getEquipe() {
		return equipe;
	}

	public void setEquipe(Equipe equipe) {
		this.equipe = equipe;
	}

	public List<Joueur> getAmi() {
		return ami;
	}

	public void setAmi(List<Joueur> ami) {
		this.ami = ami;
	}

	public void addAmi(Joueur ami){
		this.ami.add(ami);
	}	
	public List<HautFait> getHautFait() {
		return hautFait;
	}

	public void setHautFait(List<HautFait> hautFait) {
		this.hautFait = hautFait;
	}
	
	public void addHautFait(HautFait hautFait) {
		this.hautFait.add(hautFait);
	}
*/
	public int getNbPoint() {
		return this.nbPoint;
	}
	
	public void addNbPoint(int point) {
		this.nbPoint = this.nbPoint + point;
	}
	
	public void setNbPoint(int nbPoint) {
		this.nbPoint = nbPoint;
	}
	
	public int getNbVictoireTicTacToe() {
		return this.nbVictoireTicTacToe;
	}
	
	public void addNbVictoireTicTacToe() {
		this.nbVictoireTicTacToe = this.nbVictoireTicTacToe + 1;
	}
	
	public void setNbVictoireTicTacToe(int nbVictoireTicTacToe) {
		this.nbVictoireTicTacToe = nbVictoireTicTacToe;
	}
	
	public int getNbVictoireShiFuMi() {
		return this.nbVictoireShiFuMi;
	}
	
	public void addNbVictoireShiFuMi() {
		this.nbVictoireShiFuMi = this.nbVictoireShiFuMi + 1;
	}
	
	public void setNbVictoireShiFuMi(int nbVictoireShiFuMi) {
		this.nbVictoireShiFuMi = nbVictoireShiFuMi;
	}

	@Override
	public String toString() {
		return this.login;
	}
	
	@Override
	public boolean equals(Object other) {
		if (!(other instanceof Joueur)) {
			return false;
		}
		return this.getLogin().equals(((Joueur) other).getLogin());
	}
}

