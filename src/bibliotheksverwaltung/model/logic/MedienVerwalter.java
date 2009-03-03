/**
 * 
 */
package bibliotheksverwaltung.model.logic;

import java.sql.Connection;

import bibliotheksverwaltung.model.daos.dao.ExemplarDAO;
import bibliotheksverwaltung.model.daos.dao.MediumDAO;
import bibliotheksverwaltung.model.daos.dao.MySQLExemplarDAO;
import bibliotheksverwaltung.model.daos.dao.MySQLMediumDAO;
import bibliotheksverwaltung.model.domain.Ausleiher;
import bibliotheksverwaltung.model.domain.Exemplar;
import bibliotheksverwaltung.model.domain.Medium;
import bibliotheksverwaltung.util.MySQLConnection;

/**
 * @author Sven Blaurock 02.03.2009 23:39:45
 *
 */
public class MedienVerwalter
{
	private MediumDAO mediumDAO = null;
	private ExemplarDAO exemplarDAO = null;
	
	public MedienVerwalter()
	{
		mediumDAO = new MySQLMediumDAO();
		exemplarDAO = new MySQLExemplarDAO();
	}
	
	public MedienVerwalter(MySQLConnection dieConnection)
	{
		mediumDAO = new MySQLMediumDAO(dieConnection);
		exemplarDAO = new MySQLExemplarDAO(dieConnection);
	}
	
	public boolean borrow(Exemplar dasExemplar, Ausleiher derAusleiher)
	{
		return false;
	}
	
	public boolean passBack()
	{
		return false;
	}
	
	public boolean verlaengern()
	{
		return false;
	}
}
