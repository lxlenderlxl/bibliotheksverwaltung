package bibliotheksverwaltung.model.logic;

import java.util.ArrayList;
import java.util.Observable;

import bibliotheksverwaltung.model.daos.dao.MySQLSuchDAO;
import bibliotheksverwaltung.model.domain.Ausleiher;
import bibliotheksverwaltung.model.domain.Medium;
import bibliotheksverwaltung.util.LocalEnvironment;
import bibliotheksverwaltung.util.UpdateInfo;

/**
 * 
 */

public class SuchVerwalter extends Observable {

	private MySQLSuchDAO suche = new MySQLSuchDAO();
	private UpdateInfo updateInfo = new UpdateInfo();
	private ArrayList<Object> ergebnisse = new ArrayList<Object>();

	public SuchVerwalter() {
		super();
	}

	public void sucheMedium(String suchString) {
		updateInfo.setzeAenderung("Mediumsuche");
		ergebnisse.clear();
		suche = new MySQLSuchDAO("medium", this.prepareSuchworte(suchString), LocalEnvironment.mediumKategorien);
		int[] suchListe = suche.getSuchListe();
		for (int i = 0; i < suchListe.length; i++)
		{
			ergebnisse.add(new Medium(suchListe[i]));
		}
		setChanged();
		notifyObservers(updateInfo);
	}

	public void sucheAusleiher(String suchString) {
		updateInfo.setzeAenderung("Ausleihersuche");
		ergebnisse.clear();
		suche = new MySQLSuchDAO("ausleiher", this.prepareSuchworte(suchString), LocalEnvironment.ausleiherKategorien);
		int[] suchListe = suche.getSuchListe();
		for (int i = 0; i < suchListe.length; i++)
		{
			ergebnisse.add(new Ausleiher(suchListe[i]));
		}
		setChanged();
		notifyObservers(updateInfo);
	}

	private String[] prepareSuchworte(String derSuchString)
	{
		String[] suchString = derSuchString.split(" ");
		String[] suchworte = new String[suchString.length + 1];
		suchworte[0] = derSuchString;
		for (int i = 1; i < suchworte.length; i++)
		{
			suchworte[i] = suchString[i - 1];
		}
		return suchworte;
	}

	public UpdateInfo holeUpdateInfo()
	{
		return updateInfo;
	}
	
	public ArrayList<Object> getErgebnisse()
	{
		return this.ergebnisse;
	}
}
