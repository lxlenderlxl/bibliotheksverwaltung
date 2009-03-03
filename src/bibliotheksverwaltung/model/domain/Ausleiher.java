package bibliotheksverwaltung.model.domain;

public class Ausleiher
{
	private int id = 0;
	private String vorName = null;
	private String nachName = null;
	private String strasse = null;
	private String hausnummer = null;
	private int plz = 0;
	private String stadt = null;
	private boolean aktiv = true;
	
	public Ausleiher(int dieId, String derVorname, String derNachname, String dieStrasse, String dieHausnummer, int diePLZ, String dieStadt, boolean aktiv)
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
	public int getPlz()
	{
		return plz;
	}

	/**
	 * @param plz the plz to set
	 */
	public void setPlz(int plz)
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
	
	
}
