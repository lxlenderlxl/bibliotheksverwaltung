package bibliotheksverwaltung.model.daos.dao;

import java.util.ArrayList;

import bibliotheksverwaltung.model.domain.Anwender;
import bibliotheksverwaltung.model.domain.Zustand;


public interface AnwenderDAO
{
	public ArrayList<Anwender> get(boolean aktiv);
	public Anwender get(int dieId);
	public void add(String derName, String dasPasswort, int dieHierarchieStufe, boolean aktiv);
	public void update(int dieId, String derName, String dasPasswort, int dieHierarchieStufe, boolean aktiv);
}
