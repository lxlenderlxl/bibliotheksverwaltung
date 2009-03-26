package bibliotheksverwaltung.model.domain;
/**
 * @author Sven Terzyk, Max Beier, Sven Blaurock
 */
import bibliotheksverwaltung.model.daos.dao.MySQLAnwenderDAO;
/**
 * Diese Klasse Realisiert ein Anwender, diese besitzt ein Namen, ein Passwort, eine HierarchieStufe. 
 * Die Aktivit�t zeig ob der Anwender gel�scht wurde oder nicht.
 */
public class Anwender
{
	/**
	 * Der Name des Benutzers"
	 */
	private String anwenderName = null;
	/**
	 * Das Passwort des Anweders
	 */
	private String passwort = null;
	/**
	 * Hierachiestufe 
	 */
	private int hierarchieStufe = 0;
	/**
	 * Aktivit�t
	 */
	private boolean aktiv = true;

	public Anwender(String derName, String dasPasswort, int dieStufe, boolean aktiv)
	{
		anwenderName = derName;
		passwort = dasPasswort;
		hierarchieStufe = dieStufe;
		this.aktiv = aktiv;
	}

	public Anwender(String derName)
	{
		Anwender anwender = new MySQLAnwenderDAO().get(derName);
		anwenderName = anwender.anwenderName;
		passwort = anwender.passwort;
		hierarchieStufe = anwender.hierarchieStufe;
		aktiv = anwender.aktiv;
	}
	/**
	 * Gibt den AnwenderNamen zur�ck
	 * @return anwederName
	 */
	public String getAnwenderName()
	{
		return anwenderName;
	}
	/**
	 * Setzt den Anwedernamen
	 * @param anwenderName
	 */
	public void setAnwenderName(String anwenderName)
	{
		this.anwenderName = anwenderName;
	}
	/**
	 * Gibt das Passwort zur�ck
	 * @return
	 */
	public String getPasswort()
	{
		return passwort;
	}
	/**
	 * Setzt das Passwort
	 * @param passwort
	 */
	public void setPasswort(String passwort)
	{
		this.passwort = passwort;
	}
	/**
	 * Gibt die HiearchieStufe zur�ck
	 * @return hierarchieStufe
	 */
	public int getHierarchieStufe()
	{
		return hierarchieStufe;
	}
	/**
	 * Setzt Hierarchie
	 * @param hierarchieStufe
	 */
	public void setHierarchieStufe(int hierarchieStufe)
	{
		this.hierarchieStufe = hierarchieStufe;
	}
	/**
	 * Gibt die Aktivit�t des Anweders wieder.
	 * @return aktiv
	 */
	public boolean isAktiv()
	{
		return aktiv;
	}
	/**
	 * Setzt die Aktivit�t
	 * @param aktiv
	 */
	public void setAktiv(boolean aktiv)
	{
		this.aktiv = aktiv;
	}

}