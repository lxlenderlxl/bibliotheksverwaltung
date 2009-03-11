package bibliotheksverwaltung.model.logic;

import bibliotheksverwaltung.model.daos.dao.MySQLLogDAO;
import bibliotheksverwaltung.model.domain.Log;
import bibliotheksverwaltung.util.LocalLog;


public class LogVerwalter {

	private static MySQLLogDAO logDAO = new MySQLLogDAO();

	public static void add(Log log) {
		//TODO Aktuellen Benutzer holen, Zeitstempel hinzufügen
		try {
			logDAO.add(
					log.getVorgang().getId(),
					log.getAusleiher().getId(),
					log.getAnwender().getAnwenderName(),
					log.getExemplar().getId(),
					log.getLogDatum(),
					log.getKommentar()
			);
		} catch (java.lang.ClassCastException e) {
			LocalLog.add(e.getMessage());
		}
	}

	public static Log getLog(int id) {
		return new Log(id);
	}

}
