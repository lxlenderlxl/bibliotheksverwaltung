package bibliotheksverwaltung.domain;

public class Anwender
{
	private String anwenderName = null;
	private String passwort = null;
	private int hierarchieStufe = 0;
	private boolean aktiv = true;
	
	public Anwender(String derName, String dasPasswort, int dieStufe, boolean aktiv)
	{
		anwenderName = derName;
		passwort = dasPasswort;
		hierarchieStufe = dieStufe;
		this.aktiv = aktiv;
	}

	public String getAnwenderName()
	{
		return anwenderName;
	}

	public void setAnwenderName(String anwenderName)
	{
		this.anwenderName = anwenderName;
	}

	public String getPasswort()
	{
		return passwort;
	}

	public void setPasswort(String passwort)
	{
		this.passwort = passwort;
	}

	public int getHierarchieStufe()
	{
		return hierarchieStufe;
	}

	public void setHierarchieStufe(int hierarchieStufe)
	{
		this.hierarchieStufe = hierarchieStufe;
	}

	public boolean isAktiv()
	{
		return aktiv;
	}

	public void setAktiv(boolean aktiv)
	{
		this.aktiv = aktiv;
	}
	
}