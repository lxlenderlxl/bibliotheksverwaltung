/**
 * 
 */
package bibliotheksverwaltung.model.daos.dao;

import java.sql.Date;
import java.util.ArrayList;
import bibliotheksverwaltung.model.domain.Ausleiher;
import bibliotheksverwaltung.model.domain.Exemplar;
import bibliotheksverwaltung.model.domain.Medium;
import bibliotheksverwaltung.model.domain.Zustand;

/**
 * @author Sven Blaurock 28.02.2009 18:28:58
 *
 */
public interface ExemplarDAO
{
	public ArrayList<Exemplar> retrieve();
	public ArrayList<Exemplar> retrieveOverDue();
	public Exemplar findById(int dieId);
	public ArrayList<Exemplar> findByAusleiher(Ausleiher derAusleiher);
	public ArrayList<Exemplar> findByZustand(Zustand derZustand);
	public ArrayList<Exemplar> findByMedium(Medium dasMedium);
	public ArrayList<Exemplar> findByDatum(Date dasDatum);
	public void add(Exemplar dasExemplar);
	public void update(Exemplar dasExemplar);
	public void deactivate(Exemplar dasExemplar);
	public void activate(Exemplar dasExemplar);
	public boolean isBorrowed(Exemplar dasExemplar);
	
	/**
	 * Testet die optimierte SQL-Anweisung
	 * @return
	 */
	ArrayList<Exemplar> retrieveView();
}
