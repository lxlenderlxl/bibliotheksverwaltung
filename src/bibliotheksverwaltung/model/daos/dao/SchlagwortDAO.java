/**
 * 
 */
package bibliotheksverwaltung.model.daos.dao;

import java.util.ArrayList;

import bibliotheksverwaltung.model.domain.Schlagwort;

public interface SchlagwortDAO
{
	public ArrayList<Schlagwort> get();
	public Schlagwort get(int dieTagId);
	public void add(String derInhalt);
	public void update(int dieTagID, String derInhalt);
	public void delete(int dieTagID);
}
