package bibliotheksverwaltung.model.logic;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Observable;

import com.sun.xml.internal.bind.v2.runtime.unmarshaller.XsiNilLoader.Array;

import bibliotheksverwaltung.model.daos.dao.MySQLAusleiherDAO;
import bibliotheksverwaltung.model.daos.dao.MySQLExemplarDAO;
import bibliotheksverwaltung.model.domain.Ausleiher;
import bibliotheksverwaltung.model.domain.Exemplar;
import bibliotheksverwaltung.util.LocalEnvironment;
import bibliotheksverwaltung.util.Message;
import bibliotheksverwaltung.util.UpdateInfo;

public class AusleiherVerwalter extends Observable
{
	private MySQLAusleiherDAO ausleiherDAO = new MySQLAusleiherDAO();
	private Ausleiher ausleiher = null;
	private UpdateInfo updateInfo = new UpdateInfo();
	private ArrayList<Exemplar> ausgelieheneExemplare = new ArrayList<Exemplar>();

	/**
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

	public AusleiherVerwalter()
	{

	}

	public AusleiherVerwalter(Ausleiher derAusleiher)
	{
		this.ausleiher = derAusleiher;
	}

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

	public void update()
	{
		System.out.println(this.ausleiher.getJoinedName());
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
	
	public void erzeugeAusgelieheneExemplare()
	{
		updateInfo.setzeAenderung("PersonenExemplareErzeugt");
		this.ausgelieheneExemplare = new MySQLExemplarDAO().getExemplareByAusleiher(this.ausleiher.getId());
		setChanged();
		notifyObservers(updateInfo);
	}
	
	public ArrayList<Exemplar> getAusgelieheneExemplare()
	{
		return this.ausgelieheneExemplare;
	}
	
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
