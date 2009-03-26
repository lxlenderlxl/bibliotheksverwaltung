package bibliotheksverwaltung.model.domain;
/**
 * @author Sven Terzyk, Max Beier, Sven Blaurock
 */
import java.sql.Date;

import bibliotheksverwaltung.model.daos.dao.MySQLExemplarDAO;
/**
 * Diese Klasse Realisiert ein Exmplar in unserer Bibliothek. Das Exemplar besitzt eine ID, eine Zustands-ID, eine Medium-ID, 
 * eine rueckgabeDatum und wie oft das Exemplar schon Verlängert wurde.
 *  
 */
public class Exemplar
{
	/**
	 * ID
	 */
	private int id = 0;
	/**
	 * zustandsID
	 */
	private int zustandsId = 0;
	/**
	 * AusleiherID
	 */
	private int ausleiherID = 0;
	/**
	 * MediumID
	 */
	private int mediumId = 0;
	/**
	 * Rueckgabe Datum
	 */
	private Date rueckgabeDatum = null;
	/**
	 * Verlängerung
	 */
	private int verlaengerung = 0;
	/**
	 * Aktiv
	 */
	private boolean aktiv = true;
	//Konstruktor
	public Exemplar(int dieId, int derZustand, int derAusleiher, int dasMedium, Date dasDatum, int dieVerlaengerung, boolean aktiv)
	{
		this.id = dieId;
		this.zustandsId = derZustand;
		this.ausleiherID = derAusleiher;
		this.mediumId = dasMedium;
		this.rueckgabeDatum = dasDatum;
		this.verlaengerung = dieVerlaengerung;
		this.aktiv = aktiv;
	}
	//Konstruktor
	public Exemplar(int derZustand, int derAusleiher, int dasMedium, Date dasDatum, int dieVerlaengerung, boolean aktiv)
	{
		this.zustandsId = derZustand;
		this.ausleiherID = derAusleiher;
		this.mediumId = dasMedium;
		this.rueckgabeDatum = dasDatum;
		this.verlaengerung = dieVerlaengerung;
		this.aktiv = aktiv;
	}
	//Konstruktor
	
	public Exemplar(int dieId) {
		Exemplar exemplar = new MySQLExemplarDAO().get(dieId);
		this.id = exemplar.id;
		this.zustandsId = exemplar.zustandsId;
		this.ausleiherID = exemplar.ausleiherID;
		this.mediumId = exemplar.mediumId;
		this.rueckgabeDatum = exemplar.rueckgabeDatum;
		this.verlaengerung = exemplar.verlaengerung;
		this.aktiv = exemplar.aktiv;
	}
	//Konstruktor
	/**
	 *
	 * @param derZustand
	 * @param dasMedium
	 */
	public Exemplar(int derZustand, int dasMedium)
	{
		this.zustandsId = derZustand;
		this.mediumId = dasMedium;
		this.aktiv = true;
	}

	/**
	 * @return the id
	 */
	public int getId()
	{
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(int id)
	{
		this.id = id;
	}
	/**
	 * @return the zustand
	 */
	public int getZustand()
	{
		return zustandsId;
	}
	/**
	 * @param zustand the zustand to set
	 */
	public void setZustand(int zustand)
	{
		this.zustandsId = zustand;
	}
	/**
	 * @return the ausleiher
	 */
	public int getAusleiher()
	{
		return ausleiherID;
	}
	/**
	 * @param ausleiher the ausleiher to set
	 */
	public void setAusleiher(int ausleiher)
	{
		this.ausleiherID = ausleiher;
	}

	/**
	 * @return the medium
	 */
	public int getMedium()
	{
		return mediumId;
	}
	/**
	 * @param medium the medium to set
	 */
	public void setMedium(int medium)
	{
		this.mediumId = medium;
	}
	/**
	 * @return the rueckgabeDatum
	 */
	public Date getRueckgabeDatum()
	{
		return rueckgabeDatum;
	}
	/**
	 * @return the rueckgabeDatum
	 */
	public String getFormattedDate()
	{
		return rueckgabeDatum.toLocaleString();
	}
	/**
	 * @param rueckgabeDatum the rueckgabeDatum to set
	 */
	public void setRueckgabeDatum(Date rueckgabeDatum)
	{
		this.rueckgabeDatum = rueckgabeDatum;
	}
	/**
	 * @return the verlaengerung
	 */
	public int getVerlaengerung()
	{
		return verlaengerung;
	}
	/**
	 * @param verlaengerung the verlaengerung to set
	 */
	public void setVerlaengerung(int verlaengerung)
	{
		this.verlaengerung = verlaengerung;
	}
	/**
	 * @return the aktiv
	 */
	public boolean isAktiv()
	{
		return aktiv;
	}
	/**
	 * @param aktiv the aktiv to set
	 */
	public void setAktiv(boolean aktiv)
	{
		this.aktiv = aktiv;
	}
	/**
	 * Gibt zurück ob das Exemplar ausleihbar ist
	 * @return ausleihbar
	 */
	public boolean isAusleihBar()
	{
		boolean ausleihbar = false;
		if (this.ausleiherID == 0)
			ausleihbar = true;
		
		return ausleihbar;
	}


}
