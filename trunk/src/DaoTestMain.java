import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Timer;
import java.util.TreeMap;


import bibliotheksverwaltung.model.daos.dao.AnwenderDAO;
import bibliotheksverwaltung.model.daos.dao.ExemplarDAO;
import bibliotheksverwaltung.model.daos.dao.MySQLAnwenderDAO;
import bibliotheksverwaltung.model.daos.dao.MySQLExemplarDAO;
import bibliotheksverwaltung.model.daos.dao.MySQLMediumDAO;
import bibliotheksverwaltung.model.daos.dao.MySQLSuchDAO;
import bibliotheksverwaltung.model.domain.Anwender;
import bibliotheksverwaltung.model.domain.Ausleiher;
import bibliotheksverwaltung.model.domain.Exemplar;
import bibliotheksverwaltung.model.domain.Medium;
import bibliotheksverwaltung.model.domain.Suchergebnis;
import bibliotheksverwaltung.model.logic.BibliotheksVerwalter;
import bibliotheksverwaltung.model.logic.ExemplarVerwalter;
import bibliotheksverwaltung.model.logic.MedienVerwalter;
import bibliotheksverwaltung.model.logic.SuchVerwalter;
import bibliotheksverwaltung.util.LocalEnvironment;
import bibliotheksverwaltung.util.LocalEnvironment;
import bibliotheksverwaltung.util.MySQLSuche;

public class DaoTestMain
{

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		//TODO Main nur zum Testzweck so voll
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
/*
		//Benutzereingabe
		String[] suchworte = new String[3];
		suchworte[0] = "schatten";
		suchworte[1] = "andrzej";
		suchworte[2] = "1953";

		//Benutzereingabe
		String[] suchkat = new String[6];
		suchkat[0] = "titel";
		suchkat[1] = "autorvorname";
		suchkat[2] = "autornachname";
		suchkat[3] = "verlag";
		suchkat[4] = "erscheinungsjahr";
		suchkat[5] = "isbn";

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
			System.out.println("H�ufgikeit: " + liste.get(i).getBewertung());
			System.out.println("Titel     : " + dasMedium.getTitel());
			System.out.println("Autor     : " + dasMedium.getAutorNachname() + ", " + dasMedium.getAutorVorname());
			System.out.println("---------------------------------------------");
		}

		for (int i = 0; i < liste.size(); i++)
		{
			Ausleiher derAusleiher = new Ausleiher(liste.get(i).getId());
			System.out.println("AusleiherID  : " + liste.get(i).getId());
			System.out.println("H�ufgikeit   : " + liste.get(i).getFrequenz());
			System.out.println("Vorname      : " + derAusleiher.getVorName());
			System.out.println("Nachname     : " + derAusleiher.getNachName());
			System.out.println("---------------------------------------------");
		}

		BibliotheksVerwalter verwalter = new BibliotheksVerwalter();
		verwalter.buchHinzufuegen(new Exemplar(0, 0, 0, null, 0, true));
		System.out.println("Buch erfolgreich hinzugef�gt!");

		ExemplarDAO nnn = new MySQLExemplarDAO();
		Exemplar test = nnn.get(9);
		
		System.out.println("Ausleiherid  : " + test.getAusleiher());
		System.out.println("Exemplarid   : " + test.getId());
		System.out.println("Mediumid     : " + test.getMedium());
		System.out.println("Verl�ngerung : " + test.getVerlaengerung());
		System.out.println("Zustandsid   : " + test.getZustand());
		System.out.println("---------------------------------------------");
		
		BibliotheksVerwalter verwalter = new BibliotheksVerwalter();
		verwalter.buchHinzufuegen(test);
		System.out.println("Buch erfolgreich hinzugef�gt!");		
		
		BibliotheksVerwalter verwalter = new BibliotheksVerwalter();
		verwalter.buchAusleihen(new Exemplar(7), new Ausleiher(1));
		//verwalter.buchZurueckgeben(new Exemplar(7));
		//verwalter.buchVerlaengern(new Exemplar(7));*/
		
		long zstVorher = 0;
		long zstZwischen = 0;
		long zstNachher = 0;

		zstVorher = System.currentTimeMillis();

		SuchVerwalter verwalter = new SuchVerwalter();
		ArrayList<Medium> liste = new ArrayList<Medium>();
		liste = verwalter.sucheMedium("michael litauen lettland garleff");
		zstZwischen = System.currentTimeMillis();
		System.out.println("Ihre Suche ergab " + liste.size() + " Treffer\n\n");
		for (int i = 0; i < liste.size(); i++)
		{
			Medium dasMedium = new Medium(liste.get(i).getId());
			System.out.println("MEDIENID  : " + liste.get(i).getId());
			System.out.println("Titel     : " + dasMedium.getTitel());
			System.out.println("Autor     : " + dasMedium.getAutorNachname() + ", " + dasMedium.getAutorVorname());
			System.out.println("---------------------------------------------");
		}
		
		zstNachher = System.currentTimeMillis();
		System.out.println("Insgesamt ben�tigte Zeit: " + ((zstNachher - zstVorher)) + " ms, davon " + ((zstZwischen - zstVorher)) + " ms f�r Datenbank");
	}

}
