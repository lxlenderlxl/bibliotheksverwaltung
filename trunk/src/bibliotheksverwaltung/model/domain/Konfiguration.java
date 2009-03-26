package bibliotheksverwaltung.model.domain;
/**
 * @author Sven Terzyk, Max Beier, Sven Blaurock
 */
import bibliotheksverwaltung.model.daos.dao.MySQLKonfigurationDAO;
/**
 * Diese Klasse realisiert eine Konfiguration. 
 */
public class Konfiguration {

	private String name;
	private String wert;

	/**
	 *
	 */
	public Konfiguration(String name) {
		this.name = name;
		this.wert = new MySQLKonfigurationDAO().get(name).getWert();
	}

	/**
	 * @param name
	 * @param wert
	 */
	public Konfiguration(String name, String wert) {
		this.name = name;
		this.wert = wert;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the wert
	 */
	public String getWert() {
		return wert;
	}

	/**
	 * @param wert the wert to set
	 */
	public void setWert(String wert) {
		this.wert = wert;
	}

}
