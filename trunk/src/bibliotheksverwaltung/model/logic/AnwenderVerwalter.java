package bibliotheksverwaltung.model.logic;

import bibliotheksverwaltung.model.daos.dao.MySQLAnwenderDAO;
import bibliotheksverwaltung.model.domain.Anwender;
import bibliotheksverwaltung.util.LocalLog;
import bibliotheksverwaltung.util.MySQLConnection;

public class AnwenderVerwalter implements Verwaltbar {

	private MySQLAnwenderDAO anwenderDAO = null;

	/**
	 *
	 */
	public AnwenderVerwalter(MySQLConnection dieVerbindung) {
		anwenderDAO = new MySQLAnwenderDAO(dieVerbindung);
	}

	/* (non-Javadoc)
	 * @see bibliotheksverwaltung.model.logic.Verwaltbar#add(java.lang.Object)
	 */
	@Override
	public void add(Object objekt) {
		try {
			Anwender anwender = (Anwender) objekt;
			anwenderDAO.add(
					anwender.getAnwenderName(),
					anwender.getPasswort(),
					anwender.getHierarchieStufe(),
					anwender.isAktiv());
		} catch (java.lang.ClassCastException e) {
			new LocalLog(e.getMessage(), this);
		}
	}

	/* (non-Javadoc)
	 * @see bibliotheksverwaltung.model.logic.Verwaltbar#delete(java.lang.Object)
	 */
	@Override
	public void delete(Object objekt)
	{
		try {
			Anwender anwender = (Anwender) objekt;
			anwenderDAO.update(
					anwender.getAnwenderName(),
					anwender.getPasswort(),
					anwender.getHierarchieStufe(),
					false);
		} catch (java.lang.ClassCastException e) {
			new LocalLog(e.getMessage(), this);
		}

	}

	/* (non-Javadoc)
	 * @see bibliotheksverwaltung.model.logic.Verwaltbar#update()
	 */
	@Override
	public void update(Object objekt)
	{
		try {
			Anwender anwender = (Anwender) objekt;
			anwenderDAO.update(
					anwender.getAnwenderName(),
					anwender.getPasswort(),
					anwender.getHierarchieStufe(),
					anwender.isAktiv());
		} catch (java.lang.ClassCastException e) {
			new LocalLog(e.getMessage(), this);
		}
	}

}
