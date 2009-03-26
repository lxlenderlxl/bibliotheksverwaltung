/**
 * @author Max Beier, Sven Terzyk, Sven Blaurock
 */
package bibliotheksverwaltung.model.domain;
/**
 * Diese Klasse Realisiert die Suchergebenisse, Sie besitzt eine ID und eine Bewertung.
 */
public class Suchergebnis implements Comparable<Suchergebnis>
{	
	/**
	 * ID
	 */
	private int id = 0;
	/**
	 * Bewertung
	 */
	private int bewertung = 0;
	//Konstruktor
	public Suchergebnis()
	{
		
	}
	//Konstruktor
	public Suchergebnis(int dieId)
	{
		id = dieId;
		bewertung = 1;
	}
	//Konstruktor
	public Suchergebnis(int dieId, int derWert)
	{
		id = dieId;
		bewertung = derWert;
	}
	//Konstruktor
	public int getId()
	{
		return id;
	}
	/**
	 * Gibt die Bewertung zurück.
	 * @return bewertung
	 */
	public int getBewertung()
	{
		return bewertung;
	}
	/**
	 * Erhoeht die Berwertung um einen Wert "derWert".
	 * @param derWert
	 */
	public void erhoehe(int derWert)
	{
		bewertung += derWert;
	}

	/* (non-Javadoc)
	 * @see java.lang.Comparable#compareTo(java.lang.Object)
	 */
	@Override
	public int compareTo(Suchergebnis o)
	{
		return o.getBewertung() - this.bewertung;
	}
	/**
	 * Vergleicht zwei Objekte miteinander.
	 */
	public boolean equals(Object obj) {
    if (!(obj instanceof Suchergebnis)) {
      return false;
    }
    Suchergebnis such = (Suchergebnis) obj;
    return this.id == such.getId();
  }
}
