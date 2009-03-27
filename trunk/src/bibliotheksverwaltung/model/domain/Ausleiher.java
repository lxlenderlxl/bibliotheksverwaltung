package bibliotheksverwaltung.model.domain;
/**
 * @author Sven Terzyk, Max Beier, Sven Blaurock
 */
import bibliotheksverwaltung.model.daos.dao.MySQLAusleiherDAO;
/**
 * Diese Klasse Realisiert einen Ausleiher dieser hat eine ID, einen Vor- und Nachnamen und eine Adresse. Die Adresse besteht aus
 * der Strass, der Hausnummer, der Postleitzahl und der Stadt.
 */
public class Ausleiher implements Schreibbar
{
	/**
	 * Identit‰t des Anwenders
	 */
	private int id = 0;
	/**
	 * Vorname des Anwenders
	 */
	private String vorName = null;
	/**
	 * Nachname des Anwenders
	 */
	private String nachName = null;
	/**
	 * Straﬂe des Anwenders
	 */
	private String strasse = null;
	/**
	 * Hausnummer des Anwenders
	 */
	private String hausnummer = null;
	/**
	 * Postleitzahl des Anwenders
	 */
	private String plz = null;
	/**
	 * Stadt des Anwenders
	 */
	private String stadt = null;
	/**
	 * Aktivit‰t
	 */
	private boolean aktiv = true;

	//Konstruktor
	public Ausleiher(int dieId, String derVorname, String derNachname, String dieStrasse, String dieHausnummer, String diePLZ, String dieStadt, boolean aktiv)
	{
		id = dieId;
		vorName = derVorname;
		nachName = derNachname;
		strasse = dieStrasse;
		hausnummer = dieHausnummer;
		plz = diePLZ;
		stadt = dieStadt;
		this.aktiv = aktiv;
	}
	public Ausleiher()
	{
		id = 0;
	}
	//2.Konstruktor
	public Ausleiher(int dieId)
	{
		Ausleiher ausleiher = new MySQLAusleiherDAO().get(dieId);
		id = ausleiher.id;
		vorName = ausleiher.vorName;
		nachName = ausleiher.nachName;
		strasse = ausleiher.strasse;
		hausnummer = ausleiher.hausnummer;
		plz = ausleiher.plz;
		stadt = ausleiher.stadt;
		this.aktiv = ausleiher.aktiv;
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
	 * @return the vorName
	 */
	public String getVorName()
	{
		return vorName;
	}

	/**
	 * @param vorName the vorName to set
	 */
	public void setVorName(String vorName)
	{
		this.vorName = vorName;
	}

	/**
	 * @return the nachName
	 */
	public String getNachName()
	{
		return nachName;
	}

	/**
	 * @param nachName the nachName to set
	 */
	public void setNachName(String nachName)
	{
		this.nachName = nachName;
	}

	/**
	 * @return the strasse
	 */
	public String getStrasse()
	{
		return strasse;
	}

	/**
	 * @param strasse the strasse to set
	 */
	public void setStrasse(String strasse)
	{
		this.strasse = strasse;
	}

	/**
	 * @return the hausnummer
	 */
	public String getHausnummer()
	{
		return hausnummer;
	}

	/**
	 * @param hausnummer the hausnummer to set
	 */
	public void setHausnummer(String hausnummer)
	{
		this.hausnummer = hausnummer;
	}

	/**
	 * @return the plz
	 */
	public String getPlz()
	{
		return plz;
	}
	
	/**
	 * @return the plz
	 */
	public String getName()
	{
		return this.vorName + " " + this.nachName;
	}

	/**
	 * @param plz the plz to set
	 */
	public void setPlz(String plz)
	{
		this.plz = plz;
	}

	/**
	 * @return the stadt
	 */
	public String getStadt()
	{
		return stadt;
	}

	/**
	 * @param stadt the stadt to set
	 */
	public void setStadt(String stadt)
	{
		this.stadt = stadt;
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
	
	public String getJoinedName()
	{
		return this.vorName + " " + this.nachName;
	}
	
	public String getJoinedAdress()
	{
		return this.strasse + " " + this.hausnummer + "\n" + this.plz + " " + this.stadt;
	}

	/* (non-Javadoc)
	 * @see bibliotheksverwaltung.model.domain.Schreibbar#getBeschreibung()
	 */
	@Override
	public String getBeschreibung()
	{
		return "<td>" + this.id + "</td><td>" + this.vorName + "</td><td>" + this.nachName + "</td><td>" + this.strasse + "</td><td>" + this.hausnummer + "</td><td>" + this.plz + "</td><td>" + this.stadt + "</td>";
	}

}
