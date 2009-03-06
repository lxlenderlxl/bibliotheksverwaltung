/**
 *
 */
package bibliotheksverwaltung.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @author Sven Blaurock 02.03.2009 23:50:10
 *
 */
public class MySQLConnection
{
	private Connection dieVerbindung = null;

	public MySQLConnection()
	{
		// TODO evtl *.ini auslesen
		try
		{
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			dieVerbindung = DriverManager.getConnection("jdbc:mysql://localhost:3306/bibliotheksverwaltung","root", "");
		}
		catch (ClassNotFoundException e)
		{
			e.getMessage();
		}
		catch (SQLException e)
		{
			e.getMessage();
		}
		catch (Exception e)
		{
			e.getMessage();
		}
	}

	/**
	 * @return the dieVerbindung
	 */
	public Connection getConnection()
	{
		return dieVerbindung;
	}
}
