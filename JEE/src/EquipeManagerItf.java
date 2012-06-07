import java.util.List;

import entities.Equipe;

public interface EquipeManagerItf {
	public List<String> allEquipes();
	public Equipe getEquipe(String name);
	public boolean addEquipe(Equipe e);
}
