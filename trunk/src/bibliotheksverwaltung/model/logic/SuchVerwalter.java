package bibliotheksverwaltung.model.logic;

import java.util.ArrayList;

import bibliotheksverwaltung.model.daos.dao.MySQLSuchDAO;
import bibliotheksverwaltung.model.domain.Ausleiher;
import bibliotheksverwaltung.model.domain.Medium;
import bibliotheksverwaltung.util.LocalEnvironment;

/**
 * 
 */

public class SuchVerwalter {

	private MySQLSuchDAO suche = new MySQLSuchDAO();

	public SuchVerwalter() {
	}
	
	public ArrayList<Medium> sucheMedium(String suchString) {
		ArrayList<Medium> ergebnisse = new ArrayList<Medium>();
		suche = new MySQLSuchDAO("medium", this.prepareSuchworte(suchString), LocalEnvironment.mediumKategorien);
		int[] suchListe = suche.getSuchListe();
		for (int i = 0; i < suchListe.length; i++)
		{
			ergebnisse.add(new Medium(suchListe[i]));
		}
		return ergebnisse;
	}
	
	public ArrayList<Ausleiher> sucheAusleiher(String suchString) {
		ArrayList<Ausleiher> ergebnisse = new ArrayList<Ausleiher>();
		suche = new MySQLSuchDAO("ausleiher", this.prepareSuchworte(suchString), LocalEnvironment.ausleiherKategorien);
		int[] suchListe = suche.getSuchListe();
		for (int i = 0; i < suchListe.length; i++)
		{
			ergebnisse.add(new Ausleiher(suchListe[i]));
		}
		return ergebnisse;
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
