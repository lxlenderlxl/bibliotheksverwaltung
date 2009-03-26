package bibliotheksverwaltung.model.domain;
/**
 * @author Sven Terzyk, Sven Blaurock, Max Beier
 */
import bibliotheksverwaltung.model.daos.dao.MySQLVorgangDAO;

/**
 * Dies Kalsse Realisiert ein Vorgang. Jeder Vorgang hat eine ID und ein Inhalt.
 */
public class Vorgang {
	/**
	 * ID
	 */
	private int id;
	/**
	 * Inhalt
	 */
	private String inhalt;
	/**
	 * EXEMPLAR_AUSGELIEHEN
	 */
	public static final int EXEMPLAR_AUSGELIEHEN = 1;
	/**
	 * EXEMPLAR_ZUREUCKGEGEBEN
	 */
	public static final int EXEMPLAR_ZUREUCKGEGEBEN = 2;
	/**
	 * EXEMPLAR_HINZUGEFUEGT
	 */
	public static final int EXEMPLAR_HINZUGEFUEGT = 3;
	/**
	 * EXEMPLAR_ENTFERNT
	 */
	public static final int EXEMPLAR_ENTFERNT = 4;
	/**
	 * PERSON_HINZUGEFUEGT
	 */
	public static final int PERSON_HINZUGEFUEGT = 5;
	/**
	 * PERSON_ENTFERNT
	 */
	public static final int PERSON_ENTFERNT = 6;
	/**
	 * PERSON_ABGEMAHNT
	 */
	public static final int PERSON_ABGEMAHNT = 7;
	/**
	 * BENUTZER_HINZUGEFUEGT
	 */
	public static final int BENUTZER_HINZUGEFUEGT = 8;
	/**
	 * BENUTZER_GELOESCHT
	 */
	public static final int BENUTZER_GELOESCHT = 9;
	/**
	 * EXEMPLAR_BEARBEITET
	 */
	public static final int EXEMPLAR_BEARBEITET = 10;
	/**
	 * EXEMPLAR_BEARBEITET
	 */
	public static final int AUSLEIHE_VERLAENGERT = 11;

	//Konstruktor
	public Vorgang(int id) {
		this.id = id;
		inhalt = new MySQLVorgangDAO().get(id).inhalt;
	}

	//Konstruktor
	public Vorgang(int id, String inhalt) {
		this.id = id;
		this.inhalt = inhalt;
	}

	/**
	 * Gibt die ID zurück.
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * Setzt die ID.
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * Gibt den Inahlt wieder.
	 * @return the inhalt
	 */
	public String getInhalt() {
		return inhalt;
	}

	/**
	 * Setzt den Inhalt.
	 * @param inhalt the inhalt to set
	 */
	public void setInhalt(String inhalt) {
		this.inhalt = inhalt;
	}
}
