package bibliotheksverwaltung.model.logic;

import java.util.GregorianCalendar;
import java.sql.Date;
import bibliotheksverwaltung.model.daos.dao.MySQLLogDAO;
import bibliotheksverwaltung.model.domain.Anwender;
import bibliotheksverwaltung.model.domain.Log;
import bibliotheksverwaltung.util.LocalEnvironment;


public class LogVerwalter {

	private static MySQLLogDAO logDAO = new MySQLLogDAO();
	private static Anwender anwender;

	public static void add(Log log) {
		try {
			logDAO.add(
					log.getVorgang(),
					log.getAusleiher(),
					anwender.getAnwenderName(),
					log.getExemplar(),
					(Date) new GregorianCalendar().getTime(),
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
