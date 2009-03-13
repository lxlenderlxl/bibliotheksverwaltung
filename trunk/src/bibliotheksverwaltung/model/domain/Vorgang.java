package bibliotheksverwaltung.model.domain;

import bibliotheksverwaltung.model.daos.dao.MySQLVorgangDAO;

public class Vorgang {

	private int id;
	private String inhalt;
	
	public static final int EXEMPLAR_AUSGELIEHEN = 1;
	public static final int EXEMPLAR_ZUREUCKGEGEBEN = 2;
	public static final int EXEMPLAR_HINZUGEFUEGT = 3;
	public static final int EXEMPLAR_ENTFERNT = 4;
	public static final int PERSON_HINZUGEFUEGT = 5;
	public static final int PERSON_ENTFERNT = 6;
	public static final int PERSON_ABGEMAHNT = 7;
	public static final int BENUTZER_HINZUGEFUEGT = 8;
	public static final int BENUTZER_GELOESCHT = 9;
	public static final int EXEMPLAR_BEARBEITET = 10;
	public static final int AUSLEIHE_VERLAENGERT = 11;

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
