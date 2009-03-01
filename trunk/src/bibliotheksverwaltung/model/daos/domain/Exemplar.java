package bibliotheksverwaltung.model.daos.domain;

import java.sql.Date;

public class Exemplar
{
	private int id = 0;
	private Zustand zustand = null;
	private Ausleiher ausleiher = null;
	private Medium medium = null;
	private Date rueckgabeDatum = null;
	private int verlaengerung = 0;
	private boolean aktiv;
	
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
	public Zustand getZustand()
	{
		return zustand;
	}
	/**
	 * @param zustand the zustand to set
	 */
	public void setZustand(Zustand zustand)
	{
		this.zustand = zustand;
	}
	/**
	 * @return the ausleiher
	 */
	public Ausleiher getAusleiher()
	{
		return ausleiher;
	}
	/**
	 * @param ausleiher the ausleiher to set
	 */
	public void setAusleiher(Ausleiher ausleiher)
	{
		this.ausleiher = ausleiher;
	}
	/**
	 * @return the medium
	 */
	public Medium getMedium()
	{
		return medium;
	}
	/**
	 * @param medium the medium to set
	 */
	public void setMedium(Medium medium)
	{
		this.medium = medium;
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
