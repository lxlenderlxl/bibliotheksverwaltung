package bibliotheksverwaltung.model.daos.dao;

import java.util.ArrayList;

import bibliotheksverwaltung.model.domain.Zustand;

public interface ZustandDAO
{
	public ArrayList<Zustand> getAll();
	public Zustand getById(int dieId);
	public Zustand getByBezeichnung(String dieBezeichnung);
	public void add(String dieBezeichnung);
	public void update(int dieId, String dieBezeichnung);
}
