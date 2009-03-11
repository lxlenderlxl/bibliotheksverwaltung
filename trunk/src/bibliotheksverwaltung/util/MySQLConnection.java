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

import com.mysql.jdbc.Statement;

/**
 * @author Sven Blaurock 02.03.2009 23:50:10
 *
 */
public class MySQLConnection
{
	private static Connection dieVerbindung = null;

	private static void refreshConnection()
	{
		try
		{
			if (dieVerbindung.isClosed() || dieVerbindung == null) {
				Class.forName("com.mysql.jdbc.Driver").newInstance();
				String[] verbindungsdaten = getConnectionData();
				System.out.println(verbindungsdaten[0] + " " + verbindungsdaten[1]);
				dieVerbindung = DriverManager.getConnection(verbindungsdaten[0], verbindungsdaten[1], "");
			}
		}
		catch (ClassNotFoundException e)
		{
			new LocalLog(e.getMessage());
		}
		catch (SQLException e)
		{
			new LocalLog(e.getMessage());
		}
		catch (Exception e)
		{
			new LocalLog(e.getMessage());
		}
	}


	/**
	 * @return the dieVerbindung
	 */
	public static Connection getConnection()
	{
		refreshConnection();
		return dieVerbindung;
	}

	public static void closeStmt(Statement stmt)
	{
		try
		{
			stmt.close();
		} catch (SQLException e)
		{
			new LocalLog(e.getMessage());
		}
	}

	/**
	 * Liest die Verbindungsdaten aus der Connection.txt aus und gibt sie zurück.
	 * @return die Verbindungsdaten
	 */
	private static String[] getConnectionData() {
		try {
			return new BufferedReader(new FileReader("Connection.txt")).readLine().split(" ");
		} catch (FileNotFoundException e) {
			new LocalLog(e.getMessage());
		} catch (IOException e) {
			new LocalLog(e.getMessage());
		}
		return null;
	}
}
