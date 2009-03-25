package bibliotheksverwaltung.model.logic;

import java.util.Observable;

import bibliotheksverwaltung.model.daos.dao.MySQLExemplarDAO;
import bibliotheksverwaltung.model.domain.Exemplar;
import bibliotheksverwaltung.util.LocalEnvironment;
import bibliotheksverwaltung.util.UpdateInfo;


public class ExemplarVerwalter extends Observable {

	private MySQLExemplarDAO exemplarDAO = new MySQLExemplarDAO();
	private Exemplar exemplar = null;
	private UpdateInfo updateInfo = new UpdateInfo();


	public void add()
	{
		try
		{
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
	}

	/**
	 * @return the exemplar
	 */
	public Exemplar getExemplar()
	{
		return exemplar;
	}

	/**
	 * @param exemplar the exemplar to set
	 */
	public void setExemplar(Exemplar exemplar)
	{
		this.exemplar = exemplar;
	}

	public void delete()
	{
		try
		{
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
	}

	public void update()
	{
		try
		{
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
	}

}
