/**
 *
 */
package bibliotheksverwaltung.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.GregorianCalendar;

import bibliotheksverwaltung.model.domain.Anwender;

/**
 * @author Sven Blaurock 02.03.2009 23:50:10
 *
 */
public class LocalEnvironment
{
	private static Connection dieVerbindung = null;

	private static Anwender anwender = null;

	public static void log(String message) {
		log(message, null);
	}

	/**
	 *
	 */
	public static void log(String message, Object objekt) {

		File file = new File("ErrorLog.txt"); // Pr�ziser Pfad: this.getClass().getResource("/").toString().replace("file:/", "") +
		if(!file.exists()) {
			try {
				file.createNewFile();
			} catch (IOException e) {
				System.out.println("ErrorLog-Datei konnte nicht geschrieben werden.");
			}
		}
		PrintStream stream;
		try {
			stream = new PrintStream(new FileOutputStream(file, true));
			stream.println(new GregorianCalendar().getTime() + "\t" + message + (objekt != null ? "\t in " + objekt.getClass() : ""));
			stream.close();
		} catch (FileNotFoundException e) {
			System.out.println("ErrorLog konnte nicht beschrieben werden.");
		}
	}


	private static void refreshConnection()
	{
		try
		{
			//System.out.println(dieVerbindung.isClosed());
			if (dieVerbindung == null || dieVerbindung.isClosed()) {
				Class.forName("com.mysql.jdbc.Driver").newInstance();
				String[] verbindungsdaten = getConnectionData();
				System.out.println(verbindungsdaten[0] + " " + verbindungsdaten[1]);
				dieVerbindung = DriverManager.getConnection(verbindungsdaten[0], verbindungsdaten[1], "");
			}
		}
		catch (ClassNotFoundException e)
		{
			LocalEnvironment.log(e.getMessage());
		}
		catch (SQLException e)
		{
			LocalEnvironment.log(e.getMessage());
		}
		catch (Exception e)
		{
			LocalEnvironment.log(e.getMessage());
		}
	}


	/**
	 * @return the dieVerbindung
	 */
	public static Connection getConnection()
	{
		LocalEnvironment.refreshConnection();
		return dieVerbindung;
	}

	public static void closeStmt(Statement preparedStatement)
	{
		try
		{
			preparedStatement.close();
		} catch (SQLException e)
		{
			LocalEnvironment.log(e.getMessage());
		}
	}

	/**
	 * Liest die Verbindungsdaten aus der Connection.txt aus und gibt sie zur�ck.
	 * @return die Verbindungsdaten
	 */
	private static String[] getConnectionData() {
		try {
			return new BufferedReader(new FileReader("Connection.txt")).readLine().split(" ");
		} catch (FileNotFoundException e) {
			LocalEnvironment.log(e.getMessage());
		} catch (IOException e) {
			LocalEnvironment.log(e.getMessage());
		}
		return null;
	}

	public static void setAnwender(Anwender derAnwender) {
		anwender = derAnwender;
	}

	public static Anwender getAnwender() {
		return anwender;
	}
}
