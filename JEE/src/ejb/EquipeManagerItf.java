package ejb;
import java.util.List;

import entities.Equipe;
import entities.HautFait;
import entities.Joueur;

public interface EquipeManagerItf {
	public List<Equipe> allEquipes();
	public Equipe getEquipe(String name);
	public boolean addEquipe(Equipe e);
	public boolean isNameTaken(String ename);
	public void eraseEquipe(Equipe e);
	public void setEquipeChef(Equipe e,Joueur j);
	public void addHautFaitEquipe(Equipe e, HautFait f);
}
