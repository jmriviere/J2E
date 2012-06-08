package entities;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.persistence.*;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import entities.Equipe;
import entities.HautFait;
import entities.Partie;

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
	
	@ManyToOne
	private Equipe equipe;
	
	@ManyToOne
	private Equipe candidature;
	
	@ManyToMany
	private Set<Partie> partie;
	
	@Fetch(FetchMode.JOIN)
	@ElementCollection
    @MapKeyColumn(name="nomAmi")
    @Column(name="value")
    //@CollectionTable(name="example_attributes", joinColumns=@JoinColumn(name="example_id"))
	private Map<Joueur,String> amis;
	
	@ManyToMany
	private Set<HautFait> hautFait;
	
	public Joueur() {
	}
		
	public Joueur(String login, String password, String mail) {
		this.setLogin(login);
		this.setPassword(password);
		this.setMail(mail);
		this.setNbPoint(0);
		this.setEquipe(null);
		this.setCandidature(null);
		this.setPartie(new HashSet<Partie>());
		this.setAmis(new HashMap<Joueur,String>());
		this.setHautFait(new HashSet<HautFait>());
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
	
	public Set<Partie> getPartie() {
		return this.partie;
	}
	
	public void setPartie(HashSet<Partie> hashSet) {
		this.partie = hashSet;
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
	
	public boolean hasEquipe() {
		return !(equipe==null);
	}
    
	public Map<Joueur,String> getAmis() {
		return amis;
	}

	public void setAmis(HashMap<Joueur,String> hashMap) {
		this.amis = hashMap;
	}
	
	public void removeAmi(Joueur j) {
		this.amis.remove(j);
	}
	
	public boolean hasAmi(Joueur j_asked) {
		if(j_asked!=null) {
			for (Joueur j : amis.keySet()) {
				if(j.equals(j_asked)) {
					return true;
				}
			}
			return false;
		} else {
			return false;
		}
	}
	
	public String getAmiType(Joueur ami) {
		return amis.get(ami);
	}

	public void addAmi(Joueur ami,String type){
		this.amis.put(ami,type);
	}	
	
	public Set<HautFait> getHautFait() {
		return hautFait;
	}

	public void setHautFait(Set<HautFait> hautFait) {
		this.hautFait = hautFait;
	}
	
	public void addHautFait(HautFait hautFait) {
		this.hautFait.add(hautFait);
	}
	
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

	public void setCandidature(Equipe e) {		
			candidature=e;
	}
	
	public boolean hasCandidature() {
		return !(candidature==null);
	}
	
	public Equipe getCandidature() {
		return candidature;
	}

}

