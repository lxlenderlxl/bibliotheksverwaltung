import java.util.ArrayList;


import bibliotheksverwaltung.model.daos.dao.AnwenderDAO;
import bibliotheksverwaltung.model.daos.dao.MySQLAnwenderDAO;
import bibliotheksverwaltung.model.daos.dao.MySQLMediumDAO;
import bibliotheksverwaltung.model.daos.domain.Anwender;
import bibliotheksverwaltung.model.daos.domain.Medium;

public class DaoTestMain
{

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		//AnwenderDAO testDAO = new MySQLAnwenderDAO();		
		Medium suchMedium = new Medium(0,"", "rin", "", "", 0, "",true);
		//Anwender einAnwender = new Anwender("s.blaurock", "");
		ArrayList<Medium> liste = new MySQLMediumDAO().find(suchMedium);
		
		for (int i = 0; i < liste.size(); i++)
		{
			System.out.println(liste.get(i).getTitel());
			System.out.println(liste.get(i).getAutorVorname());
			System.out.println(liste.get(i).getAutorNachname());
		}
		
		
	}

}
