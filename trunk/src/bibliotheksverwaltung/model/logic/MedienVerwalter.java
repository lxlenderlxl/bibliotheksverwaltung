package bibliotheksverwaltung.model.logic;

import java.util.ArrayList;
import java.util.Observable;

import bibliotheksverwaltung.model.daos.dao.MySQLMediumDAO;
import bibliotheksverwaltung.model.domain.Exemplar;
import bibliotheksverwaltung.model.domain.Medium;
import bibliotheksverwaltung.util.LocalEnvironment;
import bibliotheksverwaltung.util.UpdateInfo;

public class MedienVerwalter extends Observable implements Verwaltbar {

	private MySQLMediumDAO mediumDAO = new MySQLMediumDAO();
	private ArrayList<Exemplar> exemplare = new ArrayList<Exemplar>();
	private UpdateInfo updateInfo = new UpdateInfo();
	
	public MedienVerwalter()
	{
		super();	
	}

	/* (non-Javadoc)
	 * @see bibliotheksverwaltung.model.logic.Verwaltbar#add(java.lang.Object)
	 */
	@Override
	public void add(Object objekt)
	{
		updateInfo.setzeAenderung("MediumHinzu");
		try {
			Medium medium = (Medium) objekt;
			mediumDAO.add(
					medium.getTitel(),
					medium.getAutorVorname(),
					medium.getAutorNachname(),
					medium.getVerlag(),
					medium.getErscheinungsJahr() + "",
					medium.getIsbn(),
					medium.isAktiv());
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
		updateInfo.setzeAenderung("MediumDelete");
		try {
			Medium medium = (Medium) objekt;
			mediumDAO.update(
					medium.getId(),
					medium.getTitel(),
					medium.getAutorVorname(),
					medium.getAutorNachname(),
					medium.getVerlag(),
					medium.getErscheinungsJahr() + "",
					medium.getIsbn(),
					false);
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
		updateInfo.setzeAenderung("MediumUpdate");
		try {
			Medium medium = (Medium) objekt;
			mediumDAO.update(
					medium.getId(),
					medium.getTitel(),
					medium.getAutorVorname(),
					medium.getAutorNachname(),
					medium.getVerlag(),
					medium.getErscheinungsJahr() + "",
					medium.getIsbn(),
					medium.isAktiv());
		} catch (java.lang.ClassCastException e) {
			LocalEnvironment.log(e.getMessage(), this);
		}
		setChanged();
		notifyObservers(updateInfo);
	}

	/**
	 * @param id
	 * @return
	 */
	public boolean hasExemplare(int id) {
		 return (mediumDAO.getAnzahlExemplare(id) > 0);
	}
	
	public boolean hasAusleihbareExemplare(int id)
	{
		return (mediumDAO.getExemplareAusgeliehen(id) == 0);
	}

	public int getAnzahlExemplare(Medium medium) {
		return mediumDAO.getAnzahlExemplare(medium.getId());
	}
	
	public UpdateInfo holeUpdateInfo()
	{
		return updateInfo;
	}
	
	public void erzeugeExemplare(int dieId)
	{
		int[] exemplarids = new MySQLMediumDAO().getExemplare(dieId);
		updateInfo.setzeAenderung("ExemplareErzeugt");
		for (int i = 0; i < exemplarids.length; i++)
		{
			exemplare.add(new Exemplar(exemplarids[i]));
		}
		setChanged();
		notifyObservers(updateInfo);
	}
	
	public ArrayList<Exemplar> getExemplare()
	{
		return exemplare;
	}

}
