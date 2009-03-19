package bibliotheksverwaltung.model.logic;

import java.util.Observable;

import bibliotheksverwaltung.model.daos.dao.MySQLBeinhaltetDAO;
import bibliotheksverwaltung.model.daos.dao.MySQLSchlagwortDAO;
import bibliotheksverwaltung.model.domain.Medium;
import bibliotheksverwaltung.model.domain.Schlagwort;
import bibliotheksverwaltung.util.LocalEnvironment;


public class SchlagwortVerwalter implements Verwaltbar {

	private MySQLSchlagwortDAO schlagwortDAO = new MySQLSchlagwortDAO();

	/**
	 * Weist genau einem Medium genau ein Schlagwort hinzu (Zugriff auf die Datenbanktabelle "beinhaltet"
	 * @param dasSchlagwort Das Schlagwort
	 * @param dasMedium Das Medium
	 */
	public void connect(Schlagwort dasSchlagwort, Medium dasMedium) {
		MySQLBeinhaltetDAO beinhaltet = new MySQLBeinhaltetDAO();
		beinhaltet.add(dasSchlagwort.getId(), dasMedium.getId());
	}

	/**
	 * Entfernt genau ein Schlagwort aus genau einem Medium (Zugriff auf die Datenbanktabelle "beinhaltet"
	 * @param dasSchlagwort Das Schlagwort
	 * @param dasMedium Das Medium
	 */
	public void unconnect(Schlagwort dasSchlagwort, Medium dasMedium) {
		MySQLBeinhaltetDAO beinhaltet = new MySQLBeinhaltetDAO();
		beinhaltet.delete(dasSchlagwort.getId(), dasMedium.getId());
	}

	/**
	 * Fügt ein Schlagwort dem Bestand hinzu.
	 * @param objekt Das Schlagwort
	 */
	public void add(Object objekt) {
		try {
			Schlagwort schlagwort = (Schlagwort) objekt;
			schlagwortDAO.add(schlagwort.getBezeichnung());
		} catch (java.lang.ClassCastException e) {
			LocalEnvironment.log(e.getMessage(), this);
		}
	}

	/* (non-Javadoc)
	 * @see bibliotheksverwaltung.model.logic.Verwaltbar#delete(java.lang.Object)
	 */
	@Override
	public void delete(Object objekt)
	{
		try {
			Schlagwort schlagwort = (Schlagwort) objekt;
			schlagwortDAO.delete(schlagwort.getId());
		} catch (java.lang.ClassCastException e) {
			LocalEnvironment.log(e.getMessage(), this);
		}
	}

	/* (non-Javadoc)
	 * @see bibliotheksverwaltung.model.logic.Verwaltbar#update()
	 */
	@Override
	public void update(Object objekt)
	{
		try {
			Schlagwort schlagwort = (Schlagwort) objekt;
			schlagwortDAO.update(
					schlagwort.getId(),
					schlagwort.getBezeichnung());
		} catch (java.lang.ClassCastException e) {
			LocalEnvironment.log(e.getMessage(), this);
		}
	}
}
