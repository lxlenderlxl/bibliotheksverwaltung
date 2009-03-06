package bibliotheksverwaltung.model.domain;

import bibliotheksverwaltung.model.daos.dao.MySQLMediumDAO;

public class Vorgang {

	private int id;
	private String inhalt;

	/**
	 *
	 */
	public Vorgang(int id) {
		this.id = id;
		inhalt = new MySQLVorgangDAO().get(id).inhalt;
	}

	/**
	 * @param id
	 * @param inhalt
	 */
	public Vorgang(int id, String inhalt) {
		this.id = id;
		this.inhalt = inhalt;
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
	 * @return the inhalt
	 */
	public String getInhalt() {
		return inhalt;
	}

	/**
	 * @param inhalt the inhalt to set
	 */
	public void setInhalt(String inhalt) {
		this.inhalt = inhalt;
	}
}
