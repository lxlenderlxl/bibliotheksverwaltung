/**
 * 
 */
package bibliotheksverwaltung.model.daos.dao;

import java.util.ArrayList;

import bibliotheksverwaltung.model.domain.Vorgang;

public interface VorgangDAO
{
	public ArrayList<Vorgang> get();
	public Vorgang get(int dieVorgangsID);
	public void add(String derInhalt);
	public void update(int dieVorgangsID, String derInhalt);
}
