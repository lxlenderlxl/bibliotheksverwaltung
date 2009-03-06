package bibliotheksverwaltung.model.daos.dao;

import java.util.ArrayList;

import bibliotheksverwaltung.model.domain.Zustand;

public interface ZustandDAO
{
	public ArrayList<Zustand> get();
	public ArrayList<Zustand> get(int dieId);
	public ArrayList<Zustand> get(String dieBezeichnung);
	public void add(String dieBezeichnung);
	public void update(int dieId, String dieBezeichnung);
}
