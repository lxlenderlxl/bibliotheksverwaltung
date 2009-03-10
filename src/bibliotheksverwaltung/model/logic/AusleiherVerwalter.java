package bibliotheksverwaltung.model.logic;

import bibliotheksverwaltung.model.daos.dao.MySQLAusleiherDAO;
import bibliotheksverwaltung.model.domain.Ausleiher;
import bibliotheksverwaltung.model.domain.Medium;
import bibliotheksverwaltung.util.MySQLConnection;

public class AusleiherVerwalter implements Verwaltbar
{
	private MySQLAusleiherDAO ausleiherDAO = null;

	public AusleiherVerwalter(MySQLConnection dieVerbindung)
	{
		ausleiherDAO = new MySQLAusleiherDAO(dieVerbindung);
	}

	/* (non-Javadoc)
	 * @see bibliotheksverwaltung.model.logic.Verwaltbar#add(java.lang.Object)
	 */
	@Override
	public void add(Object objekt)
	{
		try
		{
			Ausleiher ausleiher = (Ausleiher) objekt;
			ausleiherDAO.add(ausleiher.getVorName(), ausleiher.getNachName(), ausleiher.getStrasse(), ausleiher.getHausnummer(), ausleiher.getPlz(), ausleiher.getStadt(), ausleiher.isAktiv());
		}
		catch (java.lang.ClassCastException e)
		{

		}
	}

	/* (non-Javadoc)
	 * @see bibliotheksverwaltung.model.logic.Verwaltbar#delete(java.lang.Object)
	 */
	@Override
	public void delete(Object objekt)
	{
		try 
		{
			Ausleiher ausleiher = (Ausleiher) objekt;
			ausleiherDAO.update(ausleiher.getId(), ausleiher.getVorName(), ausleiher.getNachName(), ausleiher.getStrasse(), ausleiher.getHausnummer(), ausleiher.getPlz(), ausleiher.getStadt(), false);
		} 
		catch (java.lang.ClassCastException e) 
		{

		}
	}

	/* (non-Javadoc)
	 * @see bibliotheksverwaltung.model.logic.Verwaltbar#update()
	 */
	@Override
	public void update(Object objekt)
	{
		// TODO Auto-generated method stub

	}

}
