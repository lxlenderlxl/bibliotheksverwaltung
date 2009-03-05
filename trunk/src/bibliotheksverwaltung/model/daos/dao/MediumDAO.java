package bibliotheksverwaltung.model.daos.dao;
import java.util.ArrayList;

import bibliotheksverwaltung.model.domain.Medium;
import bibliotheksverwaltung.model.domain.Zustand;



public interface MediumDAO
{
	public ArrayList<Medium> getAll();
	public Medium getById(int dieId);
	public ArrayList<Medium> find(String derTitel);
	public void add(String derTitel, String derAutorVorname, String derAutorNachname, String derVerlag, String dasErscheinungsjahr, String dieISBN, boolean aktiv);
	public void update(int dieId, String dieBezeichnung);
}
