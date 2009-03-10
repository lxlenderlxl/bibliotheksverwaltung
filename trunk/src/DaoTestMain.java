import java.util.ArrayList;
import java.util.HashMap;
import java.util.TreeMap;


import bibliotheksverwaltung.model.daos.dao.AnwenderDAO;
import bibliotheksverwaltung.model.daos.dao.MySQLAnwenderDAO;
import bibliotheksverwaltung.model.daos.dao.MySQLExemplarDAO;
import bibliotheksverwaltung.model.daos.dao.MySQLMediumDAO;
import bibliotheksverwaltung.model.domain.Anwender;
import bibliotheksverwaltung.model.domain.Ausleiher;
import bibliotheksverwaltung.model.domain.Exemplar;
import bibliotheksverwaltung.model.domain.Medium;
import bibliotheksverwaltung.util.MySQLConnection;
import bibliotheksverwaltung.util.MySQLSuche;
import bibliotheksverwaltung.util.Suchergebnis;

public class DaoTestMain
{

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		//AnwenderDAO testDAO = new MySQLAnwenderDAO();		
		//Medium suchMedium = new Medium(0,"", "rin", "", "", 0, "",true);
		//Anwender einAnwender = new Anwender("s.blaurock", "");
		//ArrayList<Medium> liste = new MySQLMediumDAO().find(suchMedium);
		
		//System.out.println(test.getId());
		//System.out.println(new Ausleiher(1).getNachName());
		
		//Benutzereingabe
		String[] suchworte = new String[3];
		suchworte[0] = "e";
		suchworte[1] = "a";
		suchworte[2] = "s";
		
		//Benutzereingabe
		String[] suchkat = new String[3];
		suchkat[0] = "vorname";
		suchkat[1] = "nachname";
		suchkat[2] = "plz";
		
		//Suchen
		MySQLSuche suche = new MySQLSuche(new MySQLConnection(), "medium", suchworte, suchkat);
		ArrayList<Suchergebnis> liste = suche.find();
		System.out.println("Ihre Suche ergab " + liste.size() + " Treffer\n\n");
		
		/*//Ausgabe dient nur zum Test
		for (int i = 0; i < liste.size(); i++)
		{
			Medium dasMedium = new Medium(liste.get(i).getId());
			System.out.println("MEDIENID  : " + liste.get(i).getId());	
			System.out.println("Häufgikeit: " + liste.get(i).getFrequenz());
			System.out.println("Titel     : " + dasMedium.getTitel());
			System.out.println("Autor     : " + dasMedium.getAutorNachname() + ", " + dasMedium.getAutorVorname());
			System.out.println("---------------------------------------------");
		}*/
		
		for (int i = 0; i < liste.size(); i++)
		{
			Ausleiher derAusleiher = new Ausleiher(liste.get(i).getId());
			System.out.println("AusleiherID  : " + liste.get(i).getId());	
			System.out.println("Häufgikeit   : " + liste.get(i).getFrequenz());
			System.out.println("Vorname      : " + derAusleiher.getVorName());
			System.out.println("Nachname     : " + derAusleiher.getNachName());
			System.out.println("---------------------------------------------");
		}	
	}

}
