package bibliotheksverwaltung.model.daos.dao;
import java.util.ArrayList;

import bibliotheksverwaltung.model.domain.Medium;
import bibliotheksverwaltung.model.domain.Zustand;



public interface MediumDAO
{
	public ArrayList<Medium> getAll();
	public Medium getById(int dieId);
	public ArrayList<Medium> find(String);
	public void add();
	public void update(int dieId, String dieBezeichnung);
}
