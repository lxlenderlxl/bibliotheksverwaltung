package bibliotheksverwaltung.model.logic;

import bibliotheksverwaltung.model.daos.dao.MySQLKonfigurationDAO;
import bibliotheksverwaltung.util.MySQLConnection;

public class KonfigurationsVerwalter implements Verwaltbar {

	private MySQLKonfigurationDAO konfigurationsDAO = null;

	/**
	 *
	 */
	public KonfigurationsVerwalter(MySQLConnection connection) {
		konfigurationsDAO = new MySQLKonfigurationDAO(connection);
	}

	/* (non-Javadoc)
	 * @see bibliotheksverwaltung.model.logic.Verwaltbar#add(java.lang.Object)
	 */
	@Override
	public void add(Object objekt) {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see bibliotheksverwaltung.model.logic.Verwaltbar#delete(java.lang.Object)
	 */
	@Override
	public void delete(Object objekt) {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see bibliotheksverwaltung.model.logic.Verwaltbar#update()
	 */
	@Override
	public void update(Object objekt) {
		// TODO Auto-generated method stub

	}

}
