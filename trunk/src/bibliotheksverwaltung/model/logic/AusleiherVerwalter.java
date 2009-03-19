package bibliotheksverwaltung.model.logic;

import java.util.Observable;

import bibliotheksverwaltung.model.daos.dao.MySQLAusleiherDAO;
import bibliotheksverwaltung.model.domain.Ausleiher;
import bibliotheksverwaltung.util.LocalEnvironment;

public class AusleiherVerwalter implements Verwaltbar
{
	private MySQLAusleiherDAO ausleiherDAO = new MySQLAusleiherDAO();

	/* (non-Javadoc)
	 * @see bibliotheksverwaltung.model.logic.Verwaltbar#add(java.lang.Object)
	 */
	@Override
	public void add(Object objekt)
	{
		try
		{
			Ausleiher ausleiher = (Ausleiher) objekt;
			ausleiherDAO.add(
					ausleiher.getVorName(),
					ausleiher.getNachName(),
					ausleiher.getStrasse(),
					ausleiher.getHausnummer(),
					ausleiher.getPlz(),
					ausleiher.getStadt(),
					ausleiher.isAktiv());
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
			ausleiherDAO.update(
					ausleiher.getId(),
					ausleiher.getVorName(),
					ausleiher.getNachName(),
					ausleiher.getStrasse(),
					ausleiher.getHausnummer(),
					ausleiher.getPlz(),
					ausleiher.getStadt(),
					false);
		} catch (java.lang.ClassCastException e) {
			LocalEnvironment.log(e.getMessage(), this);
		}
	}

	/* (non-Javadoc)
	 * @see bibliotheksverwaltung.model.logic.Verwaltbar#delete(java.lang.Object)
	 */
	public void unDelete(Object objekt)
	{
		try
		{
			Ausleiher ausleiher = (Ausleiher) objekt;
			ausleiherDAO.update(ausleiher.getId(), ausleiher.getVorName(), ausleiher.getNachName(), ausleiher.getStrasse(), ausleiher.getHausnummer(), ausleiher.getPlz(), ausleiher.getStadt(), true);
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
		try
		{
			Ausleiher ausleiher = (Ausleiher) objekt;
			ausleiherDAO.update(
					ausleiher.getId(),
					ausleiher.getVorName(),
					ausleiher.getNachName(),
					ausleiher.getStrasse(),
					ausleiher.getHausnummer(),
					ausleiher.getPlz(),
					ausleiher.getStadt(),
					ausleiher.isAktiv());
		} catch (java.lang.ClassCastException e) {
			LocalEnvironment.log(e.getMessage(), this);
		}

	}

	/* (non-Javadoc)
	 * @see java.util.Observer#update(java.util.Observable, java.lang.Object)
	 */
	@Override
	public void update(Observable o, Object arg)
	{
		// TODO Auto-generated method stub
		
	}

}
