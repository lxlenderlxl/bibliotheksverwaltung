package bibliotheksverwaltung.model.logic;
/**
 * @author Max Beier, Sven Terzyk, Sven Blaurock
 */
import java.util.Observable;

import bibliotheksverwaltung.model.daos.dao.MySQLExemplarDAO;
import bibliotheksverwaltung.model.domain.Exemplar;
import bibliotheksverwaltung.util.LocalEnvironment;
import bibliotheksverwaltung.util.UpdateInfo;

/**
 * Diese Klasse Realsiert einen ExemplarVerwalter. Sie ist abgeleite von der Klasse Observable. Jeder Exemplarverwalter enthält 
 * eine Updateinformation, und ein Exemplar.
 */
public class ExemplarVerwalter extends Observable {
	
	/**
	 * Ruft die ExemplarDAO auf
	 */
	private MySQLExemplarDAO exemplarDAO = new MySQLExemplarDAO();
	/**
	 * Exemplar
	 */
	private Exemplar exemplar = null;
	/**
	 * updateInfo
	 */
	private UpdateInfo updateInfo = new UpdateInfo();

	/**
	 * Fügt ein Exemplar hinzu.
	 */
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
	 * Gibt Exemplar zurueck.
	 * @return the exemplar
	 */
	public Exemplar getExemplar()
	{
		return exemplar;
	}

	/**
	 * Setzt das Passwort.
	 * @param exemplar the exemplar to set
	 */
	public void setExemplar(Exemplar exemplar)
	{
		this.exemplar = exemplar;
	}
	
	/**
	 * Löscht ein Exemplar
	 */
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

	/**
	 * Update
	 */
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
	/**
	 * Updateinfo
	 * @return updateinfo
	 */
	public UpdateInfo holeUpdateInfo()
	{
		return updateInfo;
	}

}
