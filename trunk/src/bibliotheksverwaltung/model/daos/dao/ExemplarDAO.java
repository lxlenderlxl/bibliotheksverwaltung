/**
 * 
 */
package bibliotheksverwaltung.model.daos.dao;

import java.util.ArrayList;
import bibliotheksverwaltung.model.domain.Exemplar;

/**
 * @author Sven Blaurock 28.02.2009 18:28:58
 *
 */
public interface ExemplarDAO
{
	public ArrayList<Exemplar> get(boolean aktiv);
	public Exemplar get(int dieId);
	public void add(String derName, String dasPasswort, int dieHierarchieStufe, boolean aktiv);
	public void update(int dieId, String derVorname, String derNachname, String dieStrasse, String dieHausnummer, String diePLZ, String dieStadt, boolean aktiv);
}
