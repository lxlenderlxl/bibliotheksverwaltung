/**
 * 
 */
package bibliotheksverwaltung.model.logic;

import java.util.ArrayList;
import java.util.Observable;

import bibliotheksverwaltung.model.domain.Ausleiher;
import bibliotheksverwaltung.model.domain.Exemplar;
import bibliotheksverwaltung.util.Message;
import bibliotheksverwaltung.util.UpdateInfo;

public class WarenKorbVerwalter extends Observable
{
	private ArrayList<Exemplar> warenKorb = new ArrayList<Exemplar>();
	private Ausleiher ausleiher = null;
	UpdateInfo updateInfo = new UpdateInfo();

	public WarenKorbVerwalter()
	{

	}

	public void leereWarenKorb()
	{
		this.warenKorb.clear();
	}

	public void fuegeExemplarHinzu(Exemplar dasExemplar)
	{
		updateInfo.setzeAenderung("BuchKisteHinzu");
		if (!this.warenKorb.contains(dasExemplar))
			this.warenKorb.add(dasExemplar);
		else
			Message.raise("Exemplar bereits in der Buchkiste", Message.ROT);
		setChanged();
		notifyObservers(updateInfo);
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
	
	public UpdateInfo holeUpdateInfo()
	{
		return updateInfo;
	}

	
	
}
