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
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.GregorianCalendar;

import bibliotheksverwaltung.model.domain.Anwender;
import bibliotheksverwaltung.model.domain.Konfiguration;

/**
 * @author Sven Blaurock 02.03.2009 23:50:10
 *
 */
public class LocalEnvironment
{
	/**
	 * Beschreibt die Verbindung zur Datenbank
	 */
	private static Connection dieVerbindung = null;

	private static Anwender anwender = new Anwender("test");
	
	private static Konfiguration maximaleVerlaengerung = new Konfiguration("verlaengerung");
	private static Konfiguration ausleihdauer = new Konfiguration("ausleihdauer");
	
	/**
	 * Beschreibt die vorhandenen Spalten der Tabelle Medium in der Datenbank
	 */
	public static final String[] mediumKategorien = new String[]{"titel", "autorvorname","autornachname","verlag", "erscheinungsjahr", "isbn"};
	/**
	 * Beschreibt die vorhandenen Spalten der Tabelle Ausleiher in der Datenbank
	 */
	public static final String[] ausleiherKategorien = new String[]{"titel", "autorvorname","autornachname","verlag", "erscheinungsjahr", "isbn"};

	/**
	 * Liefert die Konfiguration der maximalen Ausleihdauer
	 * @return die Konfiguration der maximalen Ausleihdauer
	 */
	public static Konfiguration getMaximaleVerlaengerung()
	{
		return maximaleVerlaengerung;
	}

	/**
	 * Liefert die Konfiguration der Ausleihdauer
	 * @return die Konfiguration der Ausleihdauer
	 */
	public static Konfiguration getAusleihdauer()
	{
		return ausleihdauer;
	}

	/**
	 * Erzeugt einen lokalen Log in der Textdatei ErrorLog.txt mit einer individuellen Nachricht
	 * @param message die Nachricht
	 */
	public static void log(String message) {
		log(message, null);
	}

	/**
	 * Erzeugt einen lokalen Log in der Textdatei ErrorLog.txt mit einer individuellen Nachricht und 
	 * der Objektherkunft dieser Nachricht
	 * @param message die Nachricht
	 * @param objekt das Objekt
	 */
	public static void log(String message, Object objekt) {

		File file = new File("ErrorLog.txt"); // Präziser Pfad: this.getClass().getResource("/").toString().replace("file:/", "") +
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
	
	/**
	 * Prüft ein Integer auf 0 und setzt dieses an eine bestimmte Stelle in einem SQL-Statement
	 * @param dasStatement das SQL-Statement
	 * @param dieStelle die Position des Integers im Statement 
	 * @param derWert das Integer
	 * @throws SQLException bei Fehlzuweisung
	 */
	public static void statementChecker(java.sql.PreparedStatement statement, int dieStelle, int derWert) throws SQLException
	{
		if (derWert == 0)
			statement.setNull(dieStelle, java.sql.Types.NULL);
		else
			statement.setInt(dieStelle, derWert);
	}
	
	/**
	 * Prüft ein String auf NULL und setzt dieses an eine bestimmte Stelle in einem SQL-Statement
	 * @param dasStatement das SQL-Statement
	 * @param dieStelle die Position des Strings im Statement 
	 * @param derWert der String
	 * @throws SQLException bei Fehlzuweisung
	 */
	public static void statementChecker(java.sql.PreparedStatement dasStatement, int dieStelle, String derWert) throws SQLException
	{
		if (derWert == null)
			dasStatement.setNull(dieStelle, java.sql.Types.NULL);
		else
			dasStatement.setString(dieStelle, derWert);
	}
	
	/**
	 * Prüft ein Datum auf NULL und setzt dieses an eine bestimmte Stelle in einem SQL-Statement
	 * @param dasStatement das SQL-Statement
	 * @param dieStelle die Position des Datums im Statement 
	 * @param derWert das Datum
	 * @throws SQLException bei Fehlzuweisung
	 */
	public static void statementChecker(java.sql.PreparedStatement dasStatement, int dieStelle, Date derWert) throws SQLException
	{
		if (derWert == null)
			dasStatement.setNull(dieStelle, java.sql.Types.NULL);
		else
			dasStatement.setDate(dieStelle, derWert);
	}

	/**
	 * Erneuert die Verbindung zur Datenbank
	 */
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
	 * Liefert eine Verbindung zur MySQL Datenbank
	 * @return die Verbindung
	 */
	public static Connection getConnection()
	{
		LocalEnvironment.refreshConnection();
		return dieVerbindung;
	}

	/**
	 * Schließt eine Verbindung zur Datenbank
	 * @param preparedStatement die Verbindung
	 */
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
	 * Liest die Verbindungsdaten aus der Connection.txt aus und gibt sie zurück.
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
