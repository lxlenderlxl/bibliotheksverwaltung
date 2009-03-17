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
	private ArrayList<Medium> mediumErgebnisse = new ArrayList<Medium>();
	private ArrayList<Ausleiher> ausleiherErgebnisse = new ArrayList<Ausleiher>();

	public SuchVerwalter() {
	}
	
	public void sucheMedium(String suchString) {
		updateInfo.setzeÄnderung("Mediumsuche");
		mediumErgebnisse.clear();
		suche = new MySQLSuchDAO("medium", this.prepareSuchworte(suchString), LocalEnvironment.mediumKategorien);
		int[] suchListe = suche.getSuchListe();
		for (int i = 0; i < suchListe.length; i++)
		{
			mediumErgebnisse.add(new Medium(suchListe[i]));
		}
		setChanged();
		notifyObservers(updateInfo);
	}
	
	public void sucheAusleiher(String suchString) {
		updateInfo.setzeÄnderung("Ausleihersuche");
		ausleiherErgebnisse.clear();
		suche = new MySQLSuchDAO("ausleiher", this.prepareSuchworte(suchString), LocalEnvironment.ausleiherKategorien);
		int[] suchListe = suche.getSuchListe();
		for (int i = 0; i < suchListe.length; i++)
		{
			ausleiherErgebnisse.add(new Ausleiher(suchListe[i]));
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
}
