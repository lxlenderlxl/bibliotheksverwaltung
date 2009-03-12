package bibliotheksverwaltung.model.logic;

import java.util.ArrayList;

import bibliotheksverwaltung.model.daos.dao.BeinhaltetDAO;
import bibliotheksverwaltung.model.daos.dao.MySQLBeinhaltetDAO;
import bibliotheksverwaltung.model.daos.dao.MySQLSchlagwortDAO;
import bibliotheksverwaltung.model.domain.Exemplar;
import bibliotheksverwaltung.model.domain.Medium;
import bibliotheksverwaltung.model.domain.Schlagwort;
import bibliotheksverwaltung.util.LocalEnvironment;


public class SchlagwortVerwalter implements Verwaltbar {

	private MySQLSchlagwortDAO schlagwortDAO = new MySQLSchlagwortDAO();


	public void connect(Medium dasMedium, Schlagwort dasSchlagwort) {
		//TODO Wenn BeinhaltetDAO fertig --> .add()
		MySQLBeinhaltetDAO beinhaltet = new MySQLBeinhaltetDAO();
		
	}

	public void unconnect(int mediumID, int schlagwortID) {
		//TODO Wenn BeinhaltetDAO fertig --> .delete()
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
