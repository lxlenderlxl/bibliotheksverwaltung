package bibliotheksverwaltung.model.domain;

import bibliotheksverwaltung.model.daos.dao.MySQLAusleiherDAO;

public class Schlagwort {

	private int id = 0;
	private String bezeichnung = null;

	/**
	 *
	 */
	public Schlagwort(int id, String bezeichnung) {
		this.id = id;
		this.bezeichnung = bezeichnung;
	}

	/**
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
