/**
 * 
 */
package bibliotheksverwaltung.util;

public class Suchwort implements Comparable<Suchwort>
{
	private int id = 0;
	private int frequenz = 0;
	
	public Suchwort()
	{
		
	}
	
	public Suchwort(int dieId)
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
	public int compareTo(Suchwort o)
	{
		return o.getFrequenz() -this.frequenz;
	}
	
	public boolean equals(Object obj) {
    if (!(obj instanceof Suchwort)) {
      return false;
    }
    Suchwort such = (Suchwort) obj;
    return this.id == such.getId();
  }
}
