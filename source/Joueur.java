// package ?

import java.util.List;
import javax.persistence.*;

@Entity
public class Joueur {
	
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
		
	public Joueur(String login, String password, String mail) {
		this.login = login;
		this.password = password;
		this.mail = mail;
	}
	
	public String getLogin() {
		return this.login;
	}
	
	public void setLogin(String login) {
		this.login = login;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}

	public boolean equalsPassword(String password) {
		return this.password.equals(password);
	}
	
	public String getMail() {
		return this.mail;
	}
	
	public void setMail(String mail) {
		this.mail = mail;
	}
	
	@Override
	public String toString() {
		return this.login;
	}
	
	@Override
	public boolean equals(Object other) {
		if (!(other instanceof Joueur))
			return false;
		
		return this.getLogin().equals(((Joueur) other).getLogin());
	}
	
}

