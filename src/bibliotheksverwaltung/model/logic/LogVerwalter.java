package bibliotheksverwaltung.model.logic;

import java.sql.Date;
import java.util.GregorianCalendar;

import bibliotheksverwaltung.model.daos.dao.MySQLLogDAO;
import bibliotheksverwaltung.model.domain.Log;
import bibliotheksverwaltung.util.LocalEnvironment;


public class LogVerwalter {

	private static MySQLLogDAO logDAO = new MySQLLogDAO();

	public static void add(Log log) {
		try {
			logDAO.add(
					log.getVorgang(),
					log.getAusleiher(),
					LocalEnvironment.getAnwender().getAnwenderName(),
					log.getExemplar(),
					new Date(new GregorianCalendar().getTimeInMillis()),
					log.getKommentar()
			);
		} catch (java.lang.ClassCastException e) {
			LocalEnvironment.log(e.getMessage());
		}
	}

	public static Log getLog(int id) {
		return new Log(id);
	}

}
