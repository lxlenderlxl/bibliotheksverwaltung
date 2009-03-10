/**
 *
 */
package bibliotheksverwaltung.util;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import bibliotheksverwaltung.model.domain.Konfiguration;

public class MySQLSuche
{
	private MySQLConnection connection = null;
	private PreparedStatement statement = null;
	private ArrayList<Suchergebnis> suchergebnisListe = null;
	private String[] suchworte = null;
	private String[] suchKategorien = null;
	private Konfiguration tabelle = null;
	private Konfiguration priKey = null;
	private String suchTyp = null;


	public MySQLSuche()
	{
		this.connection = new MySQLConnection();
		this.suchergebnisListe = new ArrayList<Suchergebnis>();
		this.refreshConnection();
	}

	public MySQLSuche(MySQLConnection dieConnection, String suchTyp, String[] dieSuchworte, String[] dieSuchKategorien)
	{
		this.connection = dieConnection;
		this.suchergebnisListe = new ArrayList<Suchergebnis>();
		this.suchworte = dieSuchworte;
		this.suchKategorien = dieSuchKategorien;
		this.suchTyp = suchTyp;
		tabelle = new Konfiguration(this.suchTyp + "_tabelle");
		priKey = new Konfiguration(this.suchTyp + "_priKey");
		this.refreshConnection();
	}

	public ArrayList<Suchergebnis> find()
	{
		this.refreshConnection();
		Suchergebnis neuesElement = null;
		String sqlStmt = null;
		try
		{
			for (int i = 0; i < suchKategorien.length; i++)
			{

				sqlStmt = "SELECT " + this.priKey.getWert() + " FROM " + this.tabelle.getWert()
				+ " WHERE " + suchKategorien[i] + " LIKE ?";

				for (int j = 1; j < suchworte.length; j++)
					sqlStmt += " OR " + suchKategorien[i] + " LIKE ?";

				statement = connection.getConnection().prepareStatement(sqlStmt);

				for (int j = 0; j < suchworte.length; j++)
					statement.setString(j + 1, stringLikeTransformator(suchworte[j]));

				ResultSet rs = statement.executeQuery();
				while (rs.next())
				{
					neuesElement = new Suchergebnis(rs.getInt(1));
					if (suchergebnisListe.contains(neuesElement))
						suchergebnisListe.get(suchergebnisListe.indexOf(neuesElement)).erhoehe();
					else
						suchergebnisListe.add(neuesElement);
				}
			}
		} catch (SQLException e)
		{
			e.getMessage();
			System.out.println(e.getLocalizedMessage());
		} finally
		{
			closeStmt();
		}
		return suchergebnisListe;
	}

	private String stringLikeTransformator(String dasWort)
	{
		return "%" + dasWort + "%";
	}

	private void refreshConnection() {
		try {
			if (connection.getConnection().isClosed())
				connection = new MySQLConnection();
		} catch (SQLException e) {
			new LocalLog(e.getMessage(), this);
		}
	}

	private void closeStmt() {
		try	{
			statement.close();
		} catch (SQLException e) {
			new LocalLog(e.getMessage(), this);
		}
	}
}
