package bibliotheksverwaltung.model.daos.dao;

import java.util.ArrayList;

import bibliotheksverwaltung.model.domain.Zustand;

public interface ZustandDAO
{
	public ArrayList<Zustand> retrieve();
	public Zustand findById(int dieId);
	public void add(Zustand derZustand);
	public void update(Zustand derZustand);
}
