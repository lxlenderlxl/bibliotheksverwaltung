package bibliotheksverwaltung.model.domain;
/**
 * @author Sven Terzyk, Max Beier, Sven Blaurock
 */
import java.sql.Date;

import bibliotheksverwaltung.model.daos.dao.MySQLLogDAO;
/**
 * Diese Klasse Realisiert die Logdaten. Sie besitzt eine ID, eine Vorgangs-ID, eine Ausleiher-ID, einen Anwender, eine 
 * Exemplar-ID, ein logDatum und ein Kommentar
 * 
 */
public class Log implements Schreibbar {
	/**
	 * ID
	 */
	private int id;
	/**
	 * vorgangsID
	 */
	private int vorgangsID;
	/**
	 * ausleiherID
	 */
	private int ausleiherID;
	/**
	 * anwender
	 */
	private String anwender;
	/**
	 * 	exemplarID
	 */
	private int exemplarID;
	/**
	 * logDatum
	 */
	private Date logDatum;
	/**
	 * kommentar
	 */
	private String kommentar;

	/**
	 *
	 * @param id
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
	 *
	 * @param dieVorgangsID
	 * @param dieAusleiherID
	 * @param dieExemplarID
	 * @param dasKommentar
	 */
	public Log(int dieVorgangsID, int dieAusleiherID, int dieExemplarID, String dasKommentar) {
		this.vorgangsID = dieVorgangsID;
		this.ausleiherID = dieAusleiherID;
		this.exemplarID = dieExemplarID;
		this.kommentar = dasKommentar;
	}

	/**
	 *
	 * @param dieVorgangsID
	 * @param dieAusleiherID
	 * @param dieExemplarID
	 */
	public Log(int dieVorgangsID, int dieAusleiherID, int dieExemplarID) {
		this.vorgangsID = dieVorgangsID;
		this.ausleiherID = dieAusleiherID;
		this.exemplarID = dieExemplarID;
	}

	/**
	 *
	 * @param dieID
	 * @param dieVorgangsID
	 * @param dieAusleiherID
	 * @param derAnwender
	 * @param dieExemplarID
	 * @param dasLogDatum
	 * @param dasKommentar
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
	public int getVorgang() {
		return vorgangsID;
	}

	/**
	 * @param vorgang the vorgangsID to set
	 */
	public void setVorgangs(int vorgangsID) {
		this.vorgangsID = vorgangsID;
	}

	/**
	 * @return the ausleiher
	 */
	public int getAusleiher() {
		return ausleiherID;
	}

	/**
	 * @param ausleiher the ausleiherID to set
	 */
	public void setAusleiher(int ausleiherID) {
		this.ausleiherID = ausleiherID;
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
	 * @return the exemplar
	 */
	public int getExemplar() {
		return exemplarID;
	}

	/**
	 * @param exemplar the exemplarID to set
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

	/* (non-Javadoc)
	 * @see bibliotheksverwaltung.model.domain.Schreibbar#getBeschreibung()
	 */
	@Override
	public String getBeschreibung()
	{
		return "<td>" + this.id + "</td><td>" + (this.vorgangsID == 0 ? "" : new Vorgang(this.vorgangsID).getInhalt()) + "</td><td>" + (this.ausleiherID == 0 ? "" : new Ausleiher(this.ausleiherID).getJoinedName()) + "</td><td>" + this.anwender + "</td>"+  "</td><td>" + (this.exemplarID == 0 ? "" : new Medium(new Exemplar(this.exemplarID).getMedium()).getTitel()) + "</td>" + "</td><td>" + this.exemplarID + "</td>"+ "</td>";
	}

}
