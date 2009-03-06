package bibliotheksverwaltung.model.domain;

import bibliotheksverwaltung.model.daos.dao.MySQLMediumDAO;

public class Medium
{
	private int id = 0;
	private String titel = null;
	private String autorVorname = null;
	private String autorNachname = null;
	private String verlag = null;
	private int erscheinungsJahr = 0;
	private String isbn = null;
	private boolean aktiv = true;

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

}
