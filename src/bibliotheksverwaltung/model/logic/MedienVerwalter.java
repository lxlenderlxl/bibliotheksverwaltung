package bibliotheksverwaltung.model.logic;

import java.util.ArrayList;
import java.util.Observable;

import bibliotheksverwaltung.model.daos.dao.MySQLMediumDAO;
import bibliotheksverwaltung.model.domain.Exemplar;
import bibliotheksverwaltung.model.domain.Medium;
import bibliotheksverwaltung.util.LocalEnvironment;
import bibliotheksverwaltung.util.UpdateInfo;

public class MedienVerwalter extends Observable {

	private MySQLMediumDAO mediumDAO = new MySQLMediumDAO();
	private Medium medium = null;
	private ExemplarVerwalter exemplarVerwalter = new ExemplarVerwalter();
	private UpdateInfo updateInfo = new UpdateInfo();
	
	public MedienVerwalter()
	{
		super();	
	}
	
	public MedienVerwalter(Medium dasMedium)
	{
		super();
		this.medium = dasMedium;
	}

	/**
	 * @return the medium
	 */
	public Medium getMedium()
	{
		return medium;
	}

	/**
	 * @param medium the medium to set
	 */
	public void setMedium(Medium medium)
	{
		this.medium = medium;
	}

	public void add()
	{
		updateInfo.setzeAenderung("MediumHinzu");
		try {
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

	public void delete()
	{
		updateInfo.setzeAenderung("MediumDelete");
		try {
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

	public void update()
	{
		try {
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
		return (mediumDAO.getAnzahlVerfuegbareExemplare(id) > 0);
	}

	public int getAnzahlExemplare(Medium medium) {
		return mediumDAO.getAnzahlExemplare(medium.getId());
	}
	
	public UpdateInfo holeUpdateInfo()
	{
		return updateInfo;
	}
	
	public void erzeugeExemplare()
	{
		updateInfo.setzeAenderung("ExemplareErzeugt");
		this.medium.erzeugeExemplare();		
		setChanged();
		notifyObservers(updateInfo);
	}
	
	public void autoNotify(String message)
	{
		updateInfo.setzeAenderung(message);
		setChanged();
		notifyObservers(updateInfo);
	}
	
	public ArrayList<Exemplar> getExemplare(Medium dasMedium)
	{
		return dasMedium.getExemplare();
	}
	
	/**
	 * @return the exemplarVerwalter
	 */
	public ExemplarVerwalter getExemplarVerwalter()
	{
		return exemplarVerwalter;
	}

	/**
	 * @param exemplarVerwalter the exemplarVerwalter to set
	 */
	public void setExemplarVerwalter(ExemplarVerwalter exemplarVerwalter)
	{
		this.exemplarVerwalter = exemplarVerwalter;
	}

}
