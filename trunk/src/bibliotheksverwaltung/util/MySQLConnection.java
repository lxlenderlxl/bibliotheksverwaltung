/**
 *
 */
package bibliotheksverwaltung.util;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
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
		try
		{
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			String[] verbindungsdaten = getConnectionData();
			System.out.println(verbindungsdaten[0] + " " + verbindungsdaten[1]);
			dieVerbindung = DriverManager.getConnection(verbindungsdaten[0], verbindungsdaten[1], "");
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

	/**
	 * Liest die Verbindungsdaten aus der Connection.txt aus und gibt sie zurück.
	 * @return die Verbindungsdaten
	 */
	private String[] getConnectionData() {
		try {
			return new BufferedReader(new FileReader("Connection.txt")).readLine().split(" ");
		} catch (FileNotFoundException e) {
			new LocalLog(e.getMessage(), this);
		} catch (IOException e) {
			new LocalLog(e.getMessage(), this);
		}
		return null;
	}
}
