import java.io.Serializable;
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
		this.partie = new List<Partie>();
		this.ami = new List<Joueur>();
		this.hautFait = new List<HautFait>();
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

