package bibliotheksverwaltung.model.domain;

import bibliotheksverwaltung.model.daos.dao.MySQLZustandDAO;

public class Zustand
{
	private int id = 0;
	private String beschreibung = null;

	public Zustand(int dieId, String dieBeschreibung)
	{
		id = dieId;
		beschreibung = dieBeschreibung;
	}

	public Zustand(int dieId)
	{
		id = dieId;
		beschreibung = new MySQLZustandDAO().get(id).getBeschreibung();
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
	 * @return the beschreibung
	 */
	public String getBeschreibung()
	{
		return beschreibung;
	}

	/**
	 * @param beschreibung the beschreibung to set
	 */
	public void setBeschreibung(String beschreibung)
	{
		this.beschreibung = beschreibung;
	}
}