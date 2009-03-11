/**
 *
 */
package bibliotheksverwaltung.util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import bibliotheksverwaltung.model.domain.Konfiguration;

public class MySQLSuchExperte
{
	private Connection connection = MySQLConnection.getConnection();
	private PreparedStatement statement = null;
	private ArrayList<Suchergebnis> suchergebnisListe = null;
	private String[] suchworte = null;
	private String[] suchKategorien = null;
	private Konfiguration tabelle = null;
	private Konfiguration priKey = null;
	private String suchTyp = null;


	public MySQLSuchExperte()
	{
		this.suchergebnisListe = new ArrayList<Suchergebnis>();
	}

	public MySQLSuchExperte(String suchTyp, String[] dieSuchworte, String[] dieSuchKategorien)
	{
		this.suchergebnisListe = new ArrayList<Suchergebnis>();
		this.suchworte = dieSuchworte;
		this.suchKategorien = dieSuchKategorien;
		this.suchTyp = suchTyp;
		tabelle = new Konfiguration(this.suchTyp + "_tabelle");
		priKey = new Konfiguration(this.suchTyp + "_priKey");
	}

	public ArrayList<Suchergebnis> find()
	{
		String sqlStmt = null;
		try
		{
			for (int i = 0; i < suchKategorien.length; i++)
			{
				for (int j = 1; j < suchworte.length; j++)
				{
					sqlStmt = "SELECT " + this.priKey.getWert() + " FROM " + this.tabelle.getWert()
					+ " WHERE " + suchKategorien[i] + " LIKE ?";
					
					statement = connection.prepareStatement(sqlStmt);
					this.optimalLike("%" + suchworte[j] + "%");
					this.optimalLike("%" + suchworte[j]);
					this.optimalLike(suchworte[j] + "%");
					this.optimalLike(suchworte[j]);
					
				}
			}
		} catch (SQLException e)
		{
			LocalLog.add(e.getMessage(), this);
		} finally
		{
			MySQLConnection.closeStmt(statement);
		}
		return suchergebnisListe;
	}

	private void optimalLike(String dasSuchwort) throws SQLException
	{
		Suchergebnis neuesElement = null;
		statement.setString(1, dasSuchwort);
		System.out.println(statement.toString());

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
}
