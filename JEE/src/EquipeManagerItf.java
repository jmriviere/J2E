import java.util.List;

import entities.Equipe;

public interface EquipeManagerItf {
	public List<Equipe> allEquipes();
	public Equipe getEquipe(String name);
	public boolean addEquipe(Equipe e);
	public boolean isNameTaken(String ename);
}
