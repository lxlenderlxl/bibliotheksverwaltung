import java.util.ArrayList;
import java.util.Collections;
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
import bibliotheksverwaltung.model.logic.MedienVerwalter;
import bibliotheksverwaltung.util.LocalEnvironment;
import bibliotheksverwaltung.util.LocalEnvironment;
import bibliotheksverwaltung.util.MySQLSuchExperte;
import bibliotheksverwaltung.util.MySQLSuche;
import bibliotheksverwaltung.util.Suchergebnis;

public class DaoTestMain
{

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{

		//		new MedienVerwalter().add(new Medium(200, "testTitel", "testVorname", "testNachname", "testVerlag",
		//				2009, "testISBN", true));
		//		new MedienVerwalter().update(new Medium(197, "testTitel2", "testVorname2", "testNachname2", "testVerlag",
		//				2009, "testISBN", true));
		//		new MedienVerwalter().delete(new Medium(197));

		//AnwenderDAO testDAO = new MySQLAnwenderDAO();
		//Medium suchMedium = new Medium(0,"", "rin", "", "", 0, "",true);
		//Anwender einAnwender = new Anwender("s.blaurock", "");
		//ArrayList<Medium> liste = new MySQLMediumDAO().find(suchMedium);

		//System.out.println(test.getId());
		//System.out.println(new Ausleiher(1).getNachName());

		//Benutzereingabe
		String[] suchworte = new String[3];
		suchworte[0] = "baltisch";
		suchworte[1] = "michael";
		suchworte[2] = "litauen";

		//Benutzereingabe
		String[] suchkat = new String[3];
		suchkat[0] = "titel";
		suchkat[1] = "autorvorname";
		suchkat[2] = "autornachname";

		//Suchen
		//MySQLSuche suche = new MySQLSuche("medium", suchworte, suchkat);
		MySQLSuchExperte suche = new MySQLSuchExperte("medium", suchworte, suchkat);
		ArrayList<Suchergebnis> liste = suche.find();
		Collections.sort(liste);
		System.out.println("Ihre Suche ergab " + liste.size() + " Treffer\n\n");

		//Ausgabe dient nur zum Test
		for (int i = 0; i < liste.size(); i++)
		{
			Medium dasMedium = new Medium(liste.get(i).getId());
			System.out.println("MEDIENID  : " + liste.get(i).getId());
			System.out.println("Häufgikeit: " + liste.get(i).getFrequenz());
			System.out.println("Titel     : " + dasMedium.getTitel());
			System.out.println("Autor     : " + dasMedium.getAutorNachname() + ", " + dasMedium.getAutorVorname());
			System.out.println("---------------------------------------------");
		}

		/*for (int i = 0; i < liste.size(); i++)
		{
			Ausleiher derAusleiher = new Ausleiher(liste.get(i).getId());
			System.out.println("AusleiherID  : " + liste.get(i).getId());
			System.out.println("Häufgikeit   : " + liste.get(i).getFrequenz());
			System.out.println("Vorname      : " + derAusleiher.getVorName());
			System.out.println("Nachname     : " + derAusleiher.getNachName());
			System.out.println("---------------------------------------------");
		}*/
	}

}
