package bibliotheksverwaltung.model.domain;

import java.sql.SQLException;

import javax.swing.ImageIcon;

import com.mysql.jdbc.Blob;

import bibliotheksverwaltung.model.daos.dao.MySQLZustandDAO;
import bibliotheksverwaltung.util.LocalEnvironment;

public class Zustand
{
	private int id = 0;
	private String beschreibung = null;
	private java.sql.Blob bild = null;

	public Zustand(int dieId, String dieBeschreibung, java.sql.Blob blob)
	{
		id = dieId;
		beschreibung = dieBeschreibung;
		bild = blob;
	}

	/**
	 * @return the bild
	 */
	public ImageIcon getBild()
	{
		ImageIcon icon = new ImageIcon();
		try
		{
			icon = new ImageIcon(bild.getBytes(1L, (int) bild.length()));
		} catch (SQLException e)
		{
			LocalEnvironment.log("Zustandsbild nicht geladen", this);
		}
		return icon;
	}
	
	public java.sql.Blob getBlob()
	{
		return this.bild;
	}

	/**
	 * @param bild the bild to set
	 */
	public void setBild(Blob bild)
	{
		this.bild = bild;
	}

	public Zustand(int dieId)
	{
		id = dieId;
		beschreibung = new MySQLZustandDAO().get(id).getBeschreibung();
		bild = new MySQLZustandDAO().get(id).getBlob();
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
