package bibliotheksverwaltung.model.logic;

import bibliotheksverwaltung.model.daos.dao.MySQLKonfigurationDAO;
import bibliotheksverwaltung.model.domain.Konfiguration;
import bibliotheksverwaltung.util.LocalLog;
import bibliotheksverwaltung.util.MySQLConnection;

public class KonfigurationsVerwalter implements Verwaltbar {

	private MySQLKonfigurationDAO konfigurationsDAO = MySQLKonfigurationDAO();

	/* (non-Javadoc)
	 * @see bibliotheksverwaltung.model.logic.Verwaltbar#add(java.lang.Object)
	 */
	@Override
	public void add(Object objekt) {
		// Konfigurationen können nicht vom Programm aus hinzugefügt werden.
	}

	/* (non-Javadoc)
	 * @see bibliotheksverwaltung.model.logic.Verwaltbar#delete(java.lang.Object)
	 */
	@Override
	public void delete(Object objekt) {
		// Konfigurationen können nicht im Programm geändert werden.
	}

	/* (non-Javadoc)
	 * @see bibliotheksverwaltung.model.logic.Verwaltbar#update()
	 */
	@Override
	public void update(Object objekt) {
		try {
			Konfiguration konfiguration = (Konfiguration) objekt;
			konfigurationsDAO.update(
					konfiguration.getName(),
					konfiguration.getWert()
			);
		} catch (java.lang.ClassCastException e) {
			LocalLog.add(e.getMessage(), this);
		}
	}

}
