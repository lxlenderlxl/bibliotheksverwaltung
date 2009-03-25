/**
 * 
 */
package bibliotheksverwaltung.model.daos.dao;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import bibliotheksverwaltung.model.domain.Exemplar;

/**
 * @author Sven Blaurock 28.02.2009 18:28:58
 * 
 */
public interface ExemplarDAO {
	
	List<Exemplar> fehlt();
	List<Exemplar> fehlt(int ausleiherID);

	public ArrayList<Exemplar> get(boolean aktiv);

	public Exemplar get(int dieId);

	public void add(int zustandsid, int ausleiherID, int medienid,
			Date rueckgabedatum, int verlaengerung, boolean aktiv);

	public void update(int dieId, int zustandsid, int ausleiherID, int medienid,
			Date rueckgabedatum, int verlaengerung, boolean aktiv);
}
