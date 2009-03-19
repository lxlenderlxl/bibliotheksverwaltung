package bibliotheksverwaltung.model.logic;

import java.util.Observable;

import bibliotheksverwaltung.model.daos.dao.MySQLAnwenderDAO;
import bibliotheksverwaltung.model.domain.Anwender;
import bibliotheksverwaltung.util.LocalEnvironment;

public class AnwenderVerwalter implements Verwaltbar {

	private MySQLAnwenderDAO anwenderDAO = new MySQLAnwenderDAO();

	/* (non-Javadoc)
	 * @see bibliotheksverwaltung.model.logic.Verwaltbar#add(java.lang.Object)
	 */
	@Override
	public void add(Object objekt) {
		try {
			Anwender anwender = (Anwender) objekt;
			anwenderDAO.add(
					anwender.getAnwenderName(),
					anwender.getPasswort(),
					anwender.getHierarchieStufe(),
					anwender.isAktiv());
		} catch (java.lang.ClassCastException e) {
			LocalEnvironment.log(e.getMessage(), this);
		}
	}

	/* (non-Javadoc)
	 * @see bibliotheksverwaltung.model.logic.Verwaltbar#delete(java.lang.Object)
	 */
	@Override
	public void delete(Object objekt)
	{
		try {
			Anwender anwender = (Anwender) objekt;
			anwenderDAO.update(
					anwender.getAnwenderName(),
					anwender.getPasswort(),
					anwender.getHierarchieStufe(),
					false);
		} catch (java.lang.ClassCastException e) {
			LocalEnvironment.log(e.getMessage(), this);
		}

	}

	/* (non-Javadoc)
	 * @see bibliotheksverwaltung.model.logic.Verwaltbar#update()
	 */
	@Override
	public void update(Object objekt)
	{
		try {
			Anwender anwender = (Anwender) objekt;
			anwenderDAO.update(
					anwender.getAnwenderName(),
					anwender.getPasswort(),
					anwender.getHierarchieStufe(),
					anwender.isAktiv());
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
