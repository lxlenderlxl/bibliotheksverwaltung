/**
 * 
 */
package bibliotheksverwaltung.model.logic;

import java.util.ArrayList;

public class DruckVerwalter
{
	private ArrayList<Object> liste = new ArrayList<Object>();
	
	public DruckVerwalter()
	{
		
	}
	
	public void fuegeObjektHinzu(Object objekt)
	{
		this.liste.add(objekt);
	}
	
	public void fuegeObjekteHinzu(ArrayList objekte)
	{
		this.liste = objekte;
	}
	
	public void clearAll()
	{
		this.liste.clear();
	}
	
	public void drucke()
	{
		//TODO auf SVEN Terzyk warten
	}
}
