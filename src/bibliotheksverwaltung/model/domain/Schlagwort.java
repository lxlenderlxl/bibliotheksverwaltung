package bibliotheksverwaltung.model.domain;
/**
 * @author Sven Blaurock, Max Beier, Sven Terzyk
 */
import bibliotheksverwaltung.model.daos.dao.MySQLSchlagwortDAO;
/**
 * Realisiert ein Schlagwort, Sie enthält eine ID und eine Bezeichnung.
 */
public class Schlagwort {
	/**
	 * ID
	 */
	private int id = 0;
	/**
	 * Bezeichnung
	 */
	private String bezeichnung = null;
	//Konstruktor
	/**
	 *	Setzt ID,Bezeichnung auf id und bezeichnung.
	 */
	public Schlagwort(int id, String bezeichnung) {
		this.id = id;
		this.bezeichnung = bezeichnung;
	}

	/**Setzte Setzt ID,MySQLSchlagwort auf id und bezeichnung.
	 * @param bezeichnung
	 * @param id
	 */
	public Schlagwort(int id) {
		this.id = id;
		this.bezeichnung = new MySQLSchlagwortDAO().get(id).bezeichnung;
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the bezeichnung
	 */
	public String getBezeichnung() {
		return bezeichnung;
	}

	/**
	 * @param bezeichnung the bezeichnung to set
	 */
	public void setBezeichnung(String bezeichnung) {
		this.bezeichnung = bezeichnung;
	}

}
