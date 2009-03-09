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
import bibliotheksverwaltung.util.MySQLSuche;
import bibliotheksverwaltung.util.Suchwort;

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
		MySQLSuche suche = new MySQLSuche();
		String[] suchworte = new String[3];
		suchworte[0] = "Katrin";
		suchworte[1] = "Schmoll";
		suchworte[2] = "Ich";
		
		//Benutzereingabe
		String[] suchkat = new String[3];
		suchkat[0] = "titel";
		suchkat[1] = "autornachname";
		suchkat[2] = "autorvorname";
		
		//Suchen
		ArrayList<Suchwort> liste = suche.find("medium", suchworte, suchkat);
		System.out.println(liste.size());
		
		//Ausgabe dient nur zum Test
		for (int i = 0; i < liste.size(); i++)
		{
			System.out.println(liste.get(i).getId());	
			System.out.println(liste.get(i).getFrequenz());
			System.out.println("---------------------------------------------");
		}	
	}

}
