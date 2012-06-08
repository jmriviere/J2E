package entities;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.*;

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
	
	@ManyToMany(fetch=FetchType.EAGER)
	private Set<Joueur> amis;
	
	@ManyToMany(fetch=FetchType.EAGER)
	private Set<Joueur> incoming_candidatures_ami;
	
	@ManyToMany(fetch=FetchType.EAGER, mappedBy="incoming_candidatures_ami")
	private Set<Joueur> candidatures_ami;
	
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
		this.setAmi(new HashSet<Joueur>());
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
    
	public Set<Joueur> getAmis() {
		return amis;
	}

	public void setAmi(Set<Joueur> ami) {
		this.amis = ami;
	}
	
	public boolean hasAmi(Joueur j_asked) {
		if(j_asked!=null) {
			for (Joueur j : amis) {
				if(j.getLogin().equals(j_asked.getLogin())) {
					return true;
				}
			}
			return false;
		} else {
			return false;
		}
	}

	public void addAmi(Joueur ami){
		boolean present=this.hasAmi(ami);
		if(!present) {
			this.amis.add(ami);
		}
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
	
	public Set<Joueur> getIncomingCandidaturesAmi() {
		return this.incoming_candidatures_ami;
	}
	
	public void setIncomingCandidaturesAmi(Set<Joueur> ica) {
		this.incoming_candidatures_ami = ica;
	}
	
	public void addIncomingCandidatureAmi(Joueur j) {
		incoming_candidatures_ami.add(j);
	}
	
	public void removeIncomingCandidatureAmi(Joueur j) {
		incoming_candidatures_ami.remove(j);
	}
	
	public Set<Joueur> getCandidaturesAmi() {
		return this.candidatures_ami;
	}
	
	public void setCandidaturesAmi(Set<Joueur> ica) {
		this.candidatures_ami = ica;
	}
	
	public void addCandidatureAmi(Joueur j) {
		candidatures_ami.add(j);
	}
	
	public void removeCandidatureAmi(Joueur j) {
		candidatures_ami.remove(j);
	}
}

