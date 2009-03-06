package bibliotheksverwaltung.model.domain;

import java.sql.Date;

public class Exemplar
{
	private int id = 0;
	private int zustandsId = 0;
	private int ausleiherId = 0;
	private int mediumId = 0;
	private Date rueckgabeDatum = null;
	private int verlaengerung = 0;
	private boolean aktiv = true;
	
	public Exemplar(int dieId, int derZustand, int derAusleiher, int dasMedium, Date dasDatum, int dieVerlaengerung, boolean aktiv)
	{
		id = dieId;
		zustandsId = derZustand;
		ausleiherId = derAusleiher;
		mediumId = dasMedium;
		rueckgabeDatum = dasDatum;
		verlaengerung = dieVerlaengerung;
		this.aktiv = aktiv;
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
		return ausleiherId;
	}
	/**
	 * @param ausleiher the ausleiher to set
	 */
	public void setAusleiher(int ausleiher)
	{
		this.ausleiherId = ausleiher;
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
	
	
}
