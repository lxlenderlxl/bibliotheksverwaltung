package bibliotheksverwaltung.model.logic;

import java.util.ArrayList;

import bibliotheksverwaltung.model.daos.dao.MySQLSuchDAO;
import bibliotheksverwaltung.model.domain.Medium;
import bibliotheksverwaltung.model.domain.Suchergebnis;

/**
 * @deprecated
 */

public class SuchVerwalter {

	private String[] suchworte = null;
	private ArrayList<Suchergebnis> ergebnisListe = null;
	

	public SuchVerwalter() {
		
	}

	public SuchVerwalter(String[] suchworte) {
		this.suchworte = suchworte;
		ergebnisListe = new ArrayList<Suchergebnis>();
	}
	
	public ArrayList<Medium> sucheMedium(String suchString) {
		this.prepareSuchworte(suchString);
		
		return null;
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
