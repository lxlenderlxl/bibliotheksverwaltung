package bibliotheksverwaltung.model.domain;

import java.sql.Date;

public class Log {

	private int id;
	private int vorgangsID;
	private int benutzerID;
	private String anwender;
	private int exemplarID;
	private java.sql.Date logDatum;
	private String kommentar;

	/**
	 *
	 */
	public Log(int id) {
		this.id = id;
	}

	/**
	 * @param anwender
	 * @param benutzerID
	 * @param exemplarID
	 * @param id
	 * @param kommentar
	 * @param logDatum
	 * @param vorgangsID
	 */
	public Log(String anwender, int benutzerID, int exemplarID, int id,
			String kommentar, Date logDatum, int vorgangsID) {
		this.anwender = anwender;
		this.benutzerID = benutzerID;
		this.exemplarID = exemplarID;
		this.id = id;
		this.kommentar = kommentar;
		this.logDatum = logDatum;
		this.vorgangsID = vorgangsID;
	}



}
