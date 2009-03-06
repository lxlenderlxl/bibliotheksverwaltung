/**
 * 
 */
package bibliotheksverwaltung.model.daos.dao;

import java.sql.Date;
import java.util.ArrayList;

import bibliotheksverwaltung.model.domain.Log;

public interface LogDAO
{
	public ArrayList<Log> get();
	public Log get(int dieId);
	public void add(int vorgangsID, int ausleiherID, String anwenderName, int exemplarID, Date logDatum, String kommentar);
}
