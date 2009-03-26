package bibliotheksverwaltung.model.domain;
/**
 * @author Sven Blaurock, Max Beier, Sven Terzyk
 */
import java.sql.SQLException;

import javax.swing.ImageIcon;

import bibliotheksverwaltung.model.daos.dao.MySQLZustandDAO;
import bibliotheksverwaltung.util.LocalEnvironment;

import com.mysql.jdbc.Blob;
/**
 * Diese Klasse Realisiert den Zusand. Jeder Zustand hat eine ID, eine Beschreibung und ein Bild.
 */
public class Zustand
{
	/**
	 * ID
	 */
	private int id = 0;
	/**
	 * Beschreibung
	 */
	private String beschreibung = null;
	/**
	 * Bild
	 */
	private java.sql.Blob bild = null;
	//Konstruktor
	public Zustand(int dieId, String dieBeschreibung, java.sql.Blob blob)
	{
		id = dieId;
		beschreibung = dieBeschreibung;
		bild = blob;
	}

	/**
	 * holt das Bild aus der DB.
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
	/**
	 * Gibt das Bild zurueck.
	 * @return
	 */
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
	//Konstruktor
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
