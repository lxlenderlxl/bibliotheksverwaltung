/**
 * 
 */
package bibliotheksverwaltung.model.daos.dao;

import java.sql.Date;
import java.util.ArrayList;

import bibliotheksverwaltung.model.daos.domain.Anwender;
import bibliotheksverwaltung.model.daos.domain.Ausleiher;
import bibliotheksverwaltung.model.daos.domain.Exemplar;
import bibliotheksverwaltung.model.daos.domain.Medium;
import bibliotheksverwaltung.model.daos.domain.Zustand;

/**
 * @author Sven Blaurock 28.02.2009 18:28:58
 *
 */
public interface ExemplarDAO
{
	public ArrayList<Exemplar> retrieve();
	public ArrayList<Exemplar> retrieveOverDue();
	public ArrayList<Exemplar> findById(int dieId);
	public ArrayList<Exemplar> findByAusleiher(Ausleiher derAusleiher);
	public ArrayList<Exemplar> findByZustand(Zustand derZustand);
	public ArrayList<Exemplar> findByMedium(Medium dasMedium);
	public ArrayList<Exemplar> findByDatum(Date dasDatum);
	public void add(Exemplar dasExemplar);
	public void update(Exemplar dasExemplar);
	public void deactivate(Anwender derAnwender);
	public void activate(Anwender derAnwender);
	
	public void borrow(Exemplar dasExemplar, Ausleiher derAusleiher);
	public void passBack(Exemplar dasExemplar);
}
