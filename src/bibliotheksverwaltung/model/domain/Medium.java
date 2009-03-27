package bibliotheksverwaltung.model.domain;
/**
 * @author Max Beier, Sven Blaurock und Sven Terzyk
 */
import java.util.ArrayList;

import bibliotheksverwaltung.model.daos.dao.MySQLMediumDAO;
/**
 * Diese Klasse Realisiert ein Medium, diese besitzt eine ID, ein Titel, eine Autor Vor- Nachnamen, einen Verlag,
 * ein Erscheinungsjahr, eine ISBN und die Aktivität.
 */
public class Medium implements Schreibbar
{
	/**
	 * ID
	 */
	private int id = 0;
	/**
	 * titel
	 */
	private String titel = "";
	/**
	 * autorVorname
	 */
	private String autorVorname = "";
	/**
	 * autorNachname
	 */
	private String autorNachname = "";
	/**
	 * Verlag
	 */
	private String verlag = "";
	/**
	 * erscheinungsJahr
	 */
	private int erscheinungsJahr = 0;
	/**
	 * isbn
	 */
	private String isbn = "";
	/**
	 * Aktiv
	 */
	private boolean aktiv = true;
	/**
	 * Exemplar
	 */
	private ArrayList<Exemplar> exemplare = new ArrayList<Exemplar>();
	
	//Konstruktor
	public Medium(int dieId)
	{
		Medium medium = new MySQLMediumDAO().get(dieId);
		id = medium.id;
		titel = medium.titel;
		autorVorname = medium.autorVorname;
		autorNachname = medium.autorNachname;
		verlag = medium.verlag;
		erscheinungsJahr = medium.erscheinungsJahr;
		isbn = medium.isbn;
		aktiv = medium.aktiv;
	}
	
	public Medium()
	{
		this.id = 0;
	}
	/**
	 * Konstruktor, setzt Id, Titel, Vorname, Nachname, Verlag, Jahr, ISBN, erscheinungsJahr, ISBN auf die Daten.
	 * @param dieId
	 * @param derTitel
	 * @param derVorname
	 * @param derNachname
	 * @param derVerlag
	 * @param dasJahr
	 * @param dieISBN
	 * @param aktiv
	 */
	public Medium(int dieId, String derTitel, String derVorname, String derNachname, String derVerlag, int dasJahr, String dieISBN, boolean aktiv)
	{
		id = dieId;
		titel = derTitel;
		autorVorname = derVorname;
		autorNachname = derNachname;
		verlag = derVerlag;
		erscheinungsJahr = dasJahr;
		isbn = dieISBN;
		this.aktiv = aktiv;
	}
	
	public Medium(String derTitel, String derVorname, String derNachname, String derVerlag, int dasJahr, String dieISBN)
	{
		titel = derTitel;
		autorVorname = derVorname;
		autorNachname = derNachname;
		verlag = derVerlag;
		erscheinungsJahr = dasJahr;
		isbn = dieISBN;
		this.aktiv = true;
	}

	public int getId()
	{
		return id;
	}

	public void setId(int id)
	{
		this.id = id;
	}

	public String getTitel()
	{
		return titel;
	}

	public void setTitel(String titel)
	{
		this.titel = titel;
	}

	public String getAutorVorname()
	{
		return autorVorname;
	}

	public void setAutorVorname(String autorVorname)
	{
		this.autorVorname = autorVorname;
	}

	public String getAutorNachname()
	{
		return autorNachname;
	}

	public void setAutorNachname(String autorNachname)
	{
		this.autorNachname = autorNachname;
	}

	public String getVerlag()
	{
		return verlag;
	}

	public void setVerlag(String verlag)
	{
		this.verlag = verlag;
	}

	public int getErscheinungsJahr()
	{
		return erscheinungsJahr;
	}

	public void setErscheinungsJahr(int erscheinungsJahr)
	{
		this.erscheinungsJahr = erscheinungsJahr;
	}

	public String getIsbn()
	{
		return isbn;
	}

	public void setIsbn(String isbn)
	{
		this.isbn = isbn;
	}

	public boolean isAktiv()
	{
		return aktiv;
	}

	public void setAktiv(boolean aktiv)
	{
		this.aktiv = aktiv;
	}
	/**
	 * Erzeugt ein neues Exemplar
	 */
	public void erzeugeExemplare()
	{
		int[] exemplarIds = new MySQLMediumDAO().getExemplare(this.id);
		exemplare.clear();
		for (int i = 0; i < exemplarIds.length; i++)
		{
			exemplare.add(new Exemplar(exemplarIds[i]));
		}
	}
	/**
	 * Liste von Exemplaren
	 * @return
	 */
	public ArrayList<Exemplar> getExemplare()
	{
		return exemplare;
	}
	/**
	 * Gibt eine Medium Text wieder.
	 * @return
	 */
	public String getMediumText()
	{
		return "Autor: " + this.autorNachname + ", " + this.autorVorname + "\n\nVerlag: " + this.verlag + "\nISBN: " + this.isbn + "\nErsch.Jahr: " + this.erscheinungsJahr;
	}

	/* (non-Javadoc)
	 * @see bibliotheksverwaltung.model.domain.Schreibbar#getBeschreibung()
	 */
	@Override
	public String getBeschreibung()
	{
		return "<td>" + this.id + "</td><td>" + this.titel + "</td><td>" + this.autorVorname + "</td><td>" + this.autorNachname + "</td><td>" + this.erscheinungsJahr + "</td><td>" + this.verlag + "</td>";
	}

}
