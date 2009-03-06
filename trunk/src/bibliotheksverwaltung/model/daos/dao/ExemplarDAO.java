/**
 * 
 */
package bibliotheksverwaltung.model.daos.dao;

import java.sql.Date;
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
	public void add(int zustandsid, int benutzerid, int medienid, Date rueckgabedatum, int verlaengerung, boolean aktiv);
	public void update(int dieId, int zustandsid, int benutzerid, int medienid, Date rueckgabedatum, int verlaengerung, boolean aktiv);
}
