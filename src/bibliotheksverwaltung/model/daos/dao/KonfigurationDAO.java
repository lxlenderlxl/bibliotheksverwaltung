/**
 * 
 */
package bibliotheksverwaltung.model.daos.dao;

import java.util.ArrayList;

import bibliotheksverwaltung.model.domain.Konfiguration;

public interface KonfigurationDAO
{
	public ArrayList<Konfiguration> get();
	public Konfiguration get(String derName);
	public void add(String derName, String derWert);
	public void update(String derName, String derWert);
}
