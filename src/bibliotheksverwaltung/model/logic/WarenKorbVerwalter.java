/**
 * 
 */
package bibliotheksverwaltung.model.logic;

import java.util.ArrayList;

import bibliotheksverwaltung.model.domain.Ausleiher;
import bibliotheksverwaltung.model.domain.Exemplar;

public class WarenKorbVerwalter
{
	private ArrayList<Exemplar> warenKorb = new ArrayList<Exemplar>();
	private Ausleiher ausleiher = null;

	public WarenKorbVerwalter()
	{

	}

	public void leereWarenKorb()
	{
		this.warenKorb.clear();
	}

	public void fuegeExemplarHinzu(Exemplar dasExemplar)
	{
		this.warenKorb.add(dasExemplar);
	}

	public void entferneExemplar(Exemplar dasExemplar)
	{
		this.warenKorb.remove(dasExemplar);
	}
	
	/**
	 * @return the ausleiher
	 */
	public Ausleiher getAusleiher()
	{
		return ausleiher;
	}

	/**
	 * @param ausleiher the ausleiher to set
	 */
	public void setAusleiher(Ausleiher ausleiher)
	{
		this.ausleiher = ausleiher;
	}

	/**
	 * @return the warenKorb
	 */
	public ArrayList<Exemplar> getWarenKorb()
	{
		return warenKorb;
	}

	/**
	 * @param warenKorb the warenKorb to set
	 */
	public void setWarenKorb(ArrayList<Exemplar> warenKorb)
	{
		this.warenKorb = warenKorb;
	}
	
	
}
