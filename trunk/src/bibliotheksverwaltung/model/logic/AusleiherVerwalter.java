package bibliotheksverwaltung.model.logic;

import bibliotheksverwaltung.model.daos.dao.MySQLAusleiherDAO;
import bibliotheksverwaltung.model.domain.Ausleiher;
import bibliotheksverwaltung.model.domain.Medium;

public class AusleiherVerwalter implements Verwaltbar 
{
	private MySQLAusleiherDAO ausleiherDAO = null;
	
	public AusleiherVerwalter()
	{
		ausleiherDAO = new MySQLAusleiherDAO();
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
			new MySQLAusleiherDAO().add(ausleiher.getVorName(), ausleiher.getNachName(), ausleiher.getStrasse(), ausleiher.getHausnummer(), ausleiher.getPlz(), ausleiher.getStadt(), ausleiher.isAktiv());
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
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see bibliotheksverwaltung.model.logic.Verwaltbar#get(java.lang.Object)
	 */
	@Override
	public Object get(Object objekt)
	{
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see bibliotheksverwaltung.model.logic.Verwaltbar#update()
	 */
	@Override
	public void update()
	{
		// TODO Auto-generated method stub

	}

}
