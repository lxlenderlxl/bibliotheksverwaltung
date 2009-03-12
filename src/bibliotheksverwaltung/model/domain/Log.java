package bibliotheksverwaltung.model.domain;

import java.sql.Date;

import bibliotheksverwaltung.model.daos.dao.MySQLLogDAO;

public class Log {

	private int id;
	private int vorgangsID;
	private int ausleiherID;
	private String anwender;
	private int exemplarID;
	private Date logDatum;
	private String kommentar;

	/**
	 *
	 */
	public Log(int id) {
		Log log = new MySQLLogDAO().get(id);
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
	public Log(int dieID, int dieVorgangsID, int dieAusleiherID, String derAnwender, int dieExemplarID, Date dasLogDatum, String dasKommentar) {
		this.id = dieID;
		this.vorgangsID = dieVorgangsID;
		this.ausleiherID = dieAusleiherID;
		this.anwender = derAnwender;
		this.exemplarID = dieExemplarID;
		this.logDatum = dasLogDatum;
		this.kommentar = dasKommentar;
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
	 * @return the vorgang
	 */
	public Vorgang getVorgang() {
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
	 * @param ausleiher the ausleiherID to set
	 */
	public void setAusleiher(Ausleiher ausleiher) {
		this.ausleiherID = ausleiher.getId();
	}

	/**
	 * @return the anwender
	 */
	public Anwender getAnwender() {
		return new Anwender(anwender);
	}

	/**
	 * @param anwender the anwender to set
	 */
	public void setAnwender(Anwender anwender) {
		this.anwender = anwender.getAnwenderName();
	}

	/**
	 * @return the exemplar
	 */
	public Exemplar getExemplar() {
		return new Exemplar(exemplarID);
	}

	/**
	 * @param exemplar the exemplarID to set
	 */
	public void setExemplarID(Exemplar exemplar) {
		this.exemplarID = exemplar.getId();
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