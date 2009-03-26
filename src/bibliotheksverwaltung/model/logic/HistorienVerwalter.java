/**
 * 
 */
package bibliotheksverwaltung.model.logic;

import java.util.ArrayList;
import java.util.Observable;

import bibliotheksverwaltung.model.daos.dao.MySQLLogDAO;
import bibliotheksverwaltung.model.domain.Ausleiher;
import bibliotheksverwaltung.model.domain.Log;
import bibliotheksverwaltung.model.domain.Medium;
import bibliotheksverwaltung.util.UpdateInfo;

public class HistorienVerwalter extends Observable
{
	private ArrayList<Log> logs = null;
	private MySQLLogDAO logDAO = new MySQLLogDAO();
	private UpdateInfo updateInfo = new UpdateInfo();
	
	public ArrayList<Log> getLogs()
	{
		return logs;
	}

	public void erzeugeLogs(Object objekt)
	{
		if (objekt instanceof Medium)
		{
			updateInfo.setzeAenderung("HistorieErzeugt");
			Medium medium = (Medium)objekt;
			logs = logDAO.getByMedium(medium.getId());
			setChanged();
			notifyObservers(updateInfo);
		}
		else if (objekt instanceof Ausleiher)
		{
			updateInfo.setzeAenderung("HistorieErzeugt");
			Ausleiher ausleiher = (Ausleiher)objekt;
			logs = logDAO.getByMedium(ausleiher.getId());
			setChanged();
			notifyObservers(updateInfo);
		}
	}
}
