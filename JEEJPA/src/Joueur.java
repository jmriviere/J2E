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
	
	@ManyToOne
	private Equipe equipe;
	
	@ManyToMany
	private List<Partie> partie;
	
	@ManyToMany
	private List<Joueur> ami;
	
	@ManyToMany
	private List<HautFait> hautFait;
	
	public Joueur() {
		super();
	}
		
	public Joueur(String login, String password, String mail) {
		this.login = login;
		this.password = password;
		this.mail = mail;
		this.partie = new ArrayList<Partie>();
		this.ami = new ArrayList<Joueur>();
		this.hautFait = new ArrayList<HautFait>();
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
	
	public Equipe getEquipe() {
		return this.equipe;
	}

	public void setEquipe(Equipe equipe) {
		this.equipe = equipe;	
	}

	public List<Partie> getPartie() {
		return this.partie;
	}
	
	public void addPartie(Partie partie) {
		this.partie.add(partie);
	}
	
	public List<Joueur> getAmi() {
		return this.ami;
	}
	
	public void addAmi(Joueur ami) {
		this.ami.add(ami);
	}
	
	public List<HautFait> getHautFait() {
		return this.hautFait;
	}
	
	public void addHautFait(HautFait hautFait) {
		this.hautFait.add(hautFait);
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

