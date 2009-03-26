package bibliotheksverwaltung.model.logic;
/**
 * @author Max Beier, Sven Terzyk, Sven Blaurock
 */
import bibliotheksverwaltung.model.daos.dao.MySQLKonfigurationDAO;
import bibliotheksverwaltung.model.domain.Konfiguration;
import bibliotheksverwaltung.util.LocalEnvironment;
/**
 * 
 */
public class KonfigurationsVerwalter implements Verwaltbar {

	private MySQLKonfigurationDAO konfigurationsDAO = new MySQLKonfigurationDAO();

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
			LocalEnvironment.log(e.getMessage(), this);
		}
	}

	/* (non-Javadoc)
	 * @see bibliotheksverwaltung.model.logic.Verwaltbar#add(java.lang.Object)
	 */
	@Override
	public void add(Object objekt) {
		// Konfigurationen k�nnen vorerst nicht vom Programm aus hinzugef�gt werden.
	}

	/* (non-Javadoc)
	 * @see bibliotheksverwaltung.model.logic.Verwaltbar#delete(java.lang.Object)
	 */
	@Override
	public void delete(Object objekt) {
		// Konfigurationen k�nnen voerst nicht im Programm ge�ndert werden.
	}
}
