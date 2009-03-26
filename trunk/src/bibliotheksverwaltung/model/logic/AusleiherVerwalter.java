package bibliotheksverwaltung.model.logic;
/**
 * @author Max Beier, Sven Blaurock, Sven Terzyk
 */
import java.sql.Date;
import java.util.ArrayList;
import java.util.Observable;

import bibliotheksverwaltung.model.daos.dao.MySQLAusleiherDAO;
import bibliotheksverwaltung.model.daos.dao.MySQLExemplarDAO;
import bibliotheksverwaltung.model.domain.Ausleiher;
import bibliotheksverwaltung.model.domain.Exemplar;
import bibliotheksverwaltung.util.LocalEnvironment;
import bibliotheksverwaltung.util.Message;
import bibliotheksverwaltung.util.UpdateInfo;
/**
 * Diese Klasse Realisiert ein AusleihVerwalter. Jeder Ausleihverwalter besteht aus einem ausleiher, einem updateInfo
 * und einem Liste von Exemplaren.
 */
public class AusleiherVerwalter extends Observable
{
	/**
	 * Greif auf die AusleihDao.
	 */
	private MySQLAusleiherDAO ausleiherDAO = new MySQLAusleiherDAO();
	/**
	 * Ausleiher
	 */
	private Ausleiher ausleiher = null;
	/**
	 * Update
	 */
	private UpdateInfo updateInfo = new UpdateInfo();
	/**
	 * Liste von Exemplaren
	 */
	private ArrayList<Exemplar> ausgelieheneExemplare = new ArrayList<Exemplar>();

	/**
	 * Gibt die Ausleiher zurueck.
	 * @return the ausleiher
	 */
	public Ausleiher getAusleiher()
	{
		return ausleiher;
	}

	/**
	 * @param ausleiher the ausleiher to set
	 */
	public void setAusleiher(Ausleiher ausleiher)
	{
		this.ausleiher = ausleiher;
	}
	//Konstruktor
	public AusleiherVerwalter()
	{

	}

	/**
	 * Setzt Ausleiher.
	 * @param derAusleiher
	 */
	public AusleiherVerwalter(Ausleiher derAusleiher)
	{
		this.ausleiher = derAusleiher;
	}
	/**
	 * fügt ein Ausleiher hinzu. Mit ausleiher. Mit einem VorName, NachName,Strasse, Hausnummer, Plz, Stadt, Aktiv.
	 */
	public void add()
	{
		try
		{
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
	/**
	 * Löscht einen Anwender.
	 */
	public void delete()
	{
		try
		{
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
	
	/**
	 * Wiederherstellen von einem Ausleiher.
	 * @param objekt
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
	/**
	 * Update
	 */
	public void update()
	{
		try
		{
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
	
	/**
	 * Erzeugt Ausgeliehene Exemplare
	 */
	public void erzeugeAusgelieheneExemplare()
	{
		updateInfo.setzeAenderung("PersonenExemplareErzeugt");
		this.ausgelieheneExemplare = new MySQLExemplarDAO().getExemplareByAusleiher(this.ausleiher.getId());
		setChanged();
		notifyObservers(updateInfo);
	}
	
	/**
	 * Setzt eine Liste von Exemplaren.
	 * @return
	 */
	public ArrayList<Exemplar> getAusgelieheneExemplare()
	{
		return this.ausgelieheneExemplare;
	}
	/**
	 * Gibt die Anzahl der Ausgeliehenen Exemplare zurück.
	 * @return ausgelieheneExemplare
	 */
	public int getAnzahlAusgeliehenerExemplare()
	{
		return ausgelieheneExemplare.size();
	}
	
	public int getAusleihStatus()
	{
		int rueck = 0;
		if (this.ausgelieheneExemplare.size() == 0)
			rueck = Message.GRUEN;
		else {
			for (int i = 0; i < this.ausgelieheneExemplare.size(); i++)
			{
				if ((this.ausgelieheneExemplare.get(i).getRueckgabeDatum().compareTo(new Date(System.currentTimeMillis()))) > 0)
					rueck = Message.GELB;
				else
					rueck = Message.ROT;
			}
		}
		return rueck;
	}
	
	public void autoNotify(String message)
	{
		updateInfo.setzeAenderung(message);
		setChanged();
		notifyObservers(updateInfo);
	}
	
	public UpdateInfo holeUpdateInfo()
	{
		return updateInfo;
	}
}
