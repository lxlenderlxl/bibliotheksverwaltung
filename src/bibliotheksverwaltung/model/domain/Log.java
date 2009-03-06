package bibliotheksverwaltung.model.domain;

import java.sql.Date;

import bibliotheksverwaltung.model.daos.dao.MySQLMediumDAO;

public class Log {

	private int id;
	private int vorgangsID;
	private int ausleiherID;
	private String anwender;
	private int exemplarID;
	private java.sql.Date logDatum;
	private String kommentar;

	/**
	 *
	 */
	public Log(int id) {
		Log log = new MySQLogDAO().get(id);
		this.id = log.id;
		this.anwender = log.anwender;
		this.ausleiherID = log.ausleiherID;
		this.exemplarID = log.exemplarID;
		this.kommentar = log.kommentar;
		this.logDatum = log.logDatum;
		this.vorgangsID = log.vorgangsID;
	}

	/**
	 * @param anwender
	 * @param ausleiderID
	 * @param exemplarID
	 * @param id
	 * @param kommentar
	 * @param logDatum
	 * @param vorgangsID
	 */
	public Log(String anwender, int ausleiherID, int exemplarID, int id,
			String kommentar, Date logDatum, int vorgangsID) {
		this.anwender = anwender;
		this.ausleiherID = ausleiherID;
		this.exemplarID = exemplarID;
		this.id = id;
		this.kommentar = kommentar;
		this.logDatum = logDatum;
		this.vorgangsID = vorgangsID;
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
	 * @return the vorgangs
	 */
	public Vorgang getVorgangs() {
		return new Vorgang(vorgangsID);
	}

	/**
	 * @param vorgang the vorgangsID to set
	 */
	public void setVorgangs(Vorgang vorgang) {
		this.vorgangsID = vorgang.getId();
	}

	/**
	 * @return the ausleiher
	 */
	public Ausleiher getAusleiher() {
		return new Ausleiher(ausleiherID);
	}

	/**
	 * @param benutzerID the benutzerID to set
	 */
	public void setBenutzerID(int benutzerID) {
		this.ausleiherID = benutzerID;
	}

	/**
	 * @return the anwender
	 */
	public String getAnwender() {
		return anwender;
	}

	/**
	 * @param anwender the anwender to set
	 */
	public void setAnwender(String anwender) {
		this.anwender = anwender;
	}

	/**
	 * @return the exemplarID
	 */
	public int getExemplarID() {
		return exemplarID;
	}

	/**
	 * @param exemplarID the exemplarID to set
	 */
	public void setExemplarID(int exemplarID) {
		this.exemplarID = exemplarID;
	}

	/**
	 * @return the logDatum
	 */
	public java.sql.Date getLogDatum() {
		return logDatum;
	}

	/**
	 * @param logDatum the logDatum to set
	 */
	public void setLogDatum(java.sql.Date logDatum) {
		this.logDatum = logDatum;
	}

	/**
	 * @return the kommentar
	 */
	public String getKommentar() {
		return kommentar;
	}

	/**
	 * @param kommentar the kommentar to set
	 */
	public void setKommentar(String kommentar) {
		this.kommentar = kommentar;
	}

}
