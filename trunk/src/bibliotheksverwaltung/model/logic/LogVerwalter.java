package bibliotheksverwaltung.model.logic;

import bibliotheksverwaltung.model.daos.dao.MySQLLogDAO;
import bibliotheksverwaltung.model.domain.Log;
import bibliotheksverwaltung.util.LocalLog;


public class LogVerwalter implements Verwaltbar {

	private MySQLLogDAO logDAO = new MySQLLogDAO();

	/* (non-Javadoc)
	 * @see bibliotheksverwaltung.model.logic.Verwaltbar#add(java.lang.Object)
	 */
	@Override
	public void add(Object objekt) {
		try {
			Log log = (Log) objekt;
			logDAO.add(
					log.getVorgang().getId(),
					log.getAusleiher().getId(),
					log.getAnwender().getAnwenderName(),
					log.getExemplar().getId(),
					log.getLogDatum(),
					log.getKommentar()
			);
		} catch (java.lang.ClassCastException e) {
			LocalLog.add(e.getMessage(), this);
		}
	}

	/* (non-Javadoc)
	 * @see bibliotheksverwaltung.model.logic.Verwaltbar#delete(java.lang.Object)
	 */
	@Override
	public void delete(Object objekt)
	{
		// Aus Sicherheitsgründen is ist nicht gestattet, Logs zu löschen.
	}

	/* (non-Javadoc)
	 * @see bibliotheksverwaltung.model.logic.Verwaltbar#update()
	 */
	@Override
	public void update(Object objekt)
	{
		// Aus Sicherheitsgründen is ist nicht gestattet, Logs zu verändern.
	}

}
