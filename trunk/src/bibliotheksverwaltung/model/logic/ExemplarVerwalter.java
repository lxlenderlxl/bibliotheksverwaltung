package bibliotheksverwaltung.model.logic;

import java.util.Observable;

import bibliotheksverwaltung.model.daos.dao.MySQLExemplarDAO;
import bibliotheksverwaltung.model.domain.Exemplar;
import bibliotheksverwaltung.util.LocalEnvironment;
import bibliotheksverwaltung.util.UpdateInfo;


public class ExemplarVerwalter extends Observable implements Verwaltbar {

	private MySQLExemplarDAO exemplarDAO = new MySQLExemplarDAO();
	private UpdateInfo updateInfo = new UpdateInfo();

	/* (non-Javadoc)
	 * @see bibliotheksverwaltung.model.logic.Verwaltbar#add(java.lang.Object)
	 */
	@Override
	public void add(Object objekt)
	{
		updateInfo.setzeAenderung("ExemplarHinzu");
		try
		{
			Exemplar exemplar = (Exemplar) objekt;
			System.out.println(exemplar.getAusleiher());
			exemplarDAO.add(
					exemplar.getZustand(),
					exemplar.getAusleiher(),
					exemplar.getMedium(),
					exemplar.getRueckgabeDatum(),
					exemplar.getVerlaengerung(),
					exemplar.isAktiv()
			);

		} catch (java.lang.ClassCastException e) {
			LocalEnvironment.log(e.getMessage(), this);
		}
		setChanged();
		notifyObservers(updateInfo);
	}

	/* (non-Javadoc)
	 * @see bibliotheksverwaltung.model.logic.Verwaltbar#delete(java.lang.Object)
	 */
	@Override
	public void delete(Object objekt)
	{
		updateInfo.setzeAenderung("ExemplarGeloescht");
		try
		{
			Exemplar exemplar = (Exemplar) objekt;
			exemplarDAO.update(
					exemplar.getId(),
					exemplar.getZustand(),
					exemplar.getAusleiher(),
					exemplar.getMedium(),
					exemplar.getRueckgabeDatum(),
					exemplar.getVerlaengerung(),
					false
					);
		} catch (java.lang.ClassCastException e) {
			LocalEnvironment.log(e.getMessage(), this);
		}
		setChanged();
		notifyObservers(updateInfo);
	}

	/* (non-Javadoc)
	 * @see bibliotheksverwaltung.model.logic.Verwaltbar#update()
	 */
	@Override
	public void update(Object objekt)
	{
		updateInfo.setzeAenderung("ExemplarUpdate");
		try
		{
			Exemplar exemplar = (Exemplar) objekt;
			exemplarDAO.update(
					exemplar.getId(),
					exemplar.getZustand(),
					exemplar.getAusleiher(),
					exemplar.getMedium(),
					exemplar.getRueckgabeDatum(),
					exemplar.getVerlaengerung(),
					exemplar.isAktiv()
					);
		} catch (java.lang.ClassCastException e) {
			LocalEnvironment.log(e.getMessage(), this);
		}
		setChanged();
		notifyObservers(updateInfo);
	}

}
