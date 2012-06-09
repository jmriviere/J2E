package ejb;

import java.util.List;
import entities.Equipe;
import entities.Salon;

public interface SalonManagerItf {
	public List<Salon> allSalons();
	public Salon getSalon(String name);
	public boolean addSalon(Salon s);
	public boolean isNameTaken(String sname);
	public void eraseSalon(Salon s);
	public void setEquipeSalon(Salon s,Equipe e);
}
