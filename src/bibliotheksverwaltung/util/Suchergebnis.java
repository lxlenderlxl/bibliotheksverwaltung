/**
 * 
 */
package bibliotheksverwaltung.util;

public class Suchergebnis implements Comparable<Suchergebnis>
{
	private int id = 0;
	private int frequenz = 0;
	
	public Suchergebnis()
	{
		
	}
	
	public Suchergebnis(int dieId)
	{
		id = dieId;
		frequenz = 1;
	}
	
	public int getId()
	{
		return id;
	}
	
	public int getFrequenz()
	{
		return frequenz;
	}
	
	public void erhoehe()
	{
		frequenz += 1;
	}

	/* (non-Javadoc)
	 * @see java.lang.Comparable#compareTo(java.lang.Object)
	 */
	@Override
	public int compareTo(Suchergebnis o)
	{
		return o.getFrequenz() -this.frequenz;
	}
	
	public boolean equals(Object obj) {
    if (!(obj instanceof Suchergebnis)) {
      return false;
    }
    Suchergebnis such = (Suchergebnis) obj;
    return this.id == such.getId();
  }
}
