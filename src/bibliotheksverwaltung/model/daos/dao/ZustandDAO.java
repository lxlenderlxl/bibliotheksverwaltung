package bibliotheksverwaltung.model.daos.dao;

import java.util.ArrayList;

import bibliotheksverwaltung.model.domain.Zustand;

public interface ZustandDAO
{
	public ArrayList<Zustand> get();
	public Zustand get(int dieId);
	public void add(String dieBezeichnung);
	public void update(int dieId, String dieBezeichnung);
}
