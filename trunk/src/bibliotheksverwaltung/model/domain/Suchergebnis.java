/**
 * 
 */
package bibliotheksverwaltung.model.domain;

import java.text.DecimalFormat;

public class Suchergebnis implements Comparable<Suchergebnis>
{
	private int id = 0;
	private int bewertung = 0;
	
	public Suchergebnis()
	{
		
	}
	
	public Suchergebnis(int dieId)
	{
		id = dieId;
		bewertung = 1;
	}
	
	public Suchergebnis(int dieId, int derWert)
	{
		id = dieId;
		bewertung = derWert;
	}
	
	public int getId()
	{
		return id;
	}
	
	public int getBewertung()
	{
		return bewertung;
	}
	
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
	
	public boolean equals(Object obj) {
    if (!(obj instanceof Suchergebnis)) {
      return false;
    }
    Suchergebnis such = (Suchergebnis) obj;
    return this.id == such.getId();
  }
}
