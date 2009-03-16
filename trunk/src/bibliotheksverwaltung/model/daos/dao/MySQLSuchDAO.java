/**
 *
 */
package bibliotheksverwaltung.model.daos.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;

import bibliotheksverwaltung.model.domain.Konfiguration;
import bibliotheksverwaltung.model.domain.Suchergebnis;
import bibliotheksverwaltung.util.LocalEnvironment;

public class MySQLSuchDAO
{
	private Connection connection = LocalEnvironment.getConnection();
	private PreparedStatement statement = null;
	private ArrayList<Suchergebnis> suchergebnisListe = null;
	private String[] suchworte = null;
	private String[] suchKategorien = null;
	private Konfiguration tabelle = null;
	private Konfiguration priKey = null;
	private String suchTyp = null;


	public MySQLSuchDAO()
	{
	}

	public MySQLSuchDAO(String suchTyp, String[] dieSuchworte, String[] dieSuchKategorien)
	{
		this.suchergebnisListe = new ArrayList<Suchergebnis>();
		this.suchworte = dieSuchworte;
		this.suchKategorien = dieSuchKategorien;
		this.suchTyp = suchTyp;
		tabelle = new Konfiguration(this.suchTyp + "_tabelle");
		priKey = new Konfiguration(this.suchTyp + "_priKey");
	}

	private void find()
	{
		String sqlStmt = null;
		try
		{
			for (int i = 0; i < suchKategorien.length; i++)
			{
				for (int j = 0; j < suchworte.length; j++)
				{
					sqlStmt = "SELECT " + this.priKey.getWert() + " FROM " + this.tabelle.getWert()
					+ " WHERE " + suchKategorien[i] + " LIKE ?";

					statement = connection.prepareStatement(sqlStmt);
					this.optimalLike("%" + suchworte[j] + "%", 1 * suchworte[j].length());
					this.optimalLike("%" + suchworte[j], 2 * suchworte[j].length());
					this.optimalLike(suchworte[j] + "%", 2 * suchworte[j].length());
					this.optimalLike(suchworte[j], 3 * suchworte[j].length());

				}
			}
		} catch (SQLException e)
		{
			LocalEnvironment.log(e.getMessage(), this);
		} finally
		{
			LocalEnvironment.closeStmt(statement);
		}
		Collections.sort(suchergebnisListe);
	}

	private void schlagwortFind()
	{
		try
		{
			String sqlStmt = null;
			for (int j = 0; j < suchworte.length; j++)
			{
				sqlStmt = "SELECT medienid FROM beinhaltet WHERE tagid IN (SELECT tagid FROM schlagworte WHERE inhalt LIKE ?";

				statement = connection.prepareStatement(sqlStmt);
				this.optimalLike("%" + suchworte[j] + "%", 1 * suchworte[j].length());
				this.optimalLike("%" + suchworte[j], 2 * suchworte[j].length());
				this.optimalLike(suchworte[j] + "%", 2 * suchworte[j].length());
				this.optimalLike(suchworte[j], 3 * suchworte[j].length());

			}
		} 
		catch (SQLException e)
		{
			LocalEnvironment.log(e.getMessage(), this);
		} finally
		{
			LocalEnvironment.closeStmt(statement);
		}
	}

	public int[] getSuchListe()
	{
		this.find();
		if (this.suchTyp.equals("medium"))
			this.schlagwortFind();
		int[] suchListe = new int[suchergebnisListe.size()];
		for (int i = 0; i < suchergebnisListe.size(); i++)
		{
			suchListe[i] = suchergebnisListe.get(i).getId();
		}
		return suchListe;
	}

	public ArrayList<Suchergebnis> getSuchergebnis()
	{
		this.find();
		if (this.suchTyp.equals("medium"))
			this.schlagwortFind();
		return suchergebnisListe;
	}

	private void optimalLike(String dasSuchwort, int bewertung) throws SQLException
	{
		Suchergebnis neuesElement = null;
		statement.setString(1, dasSuchwort);
		ResultSet rs = statement.executeQuery();
		while (rs.next())
		{
			neuesElement = new Suchergebnis(rs.getInt(1), bewertung);
			if (suchergebnisListe.contains(neuesElement))
				suchergebnisListe.get(suchergebnisListe.indexOf(neuesElement)).erhoehe(bewertung);
			else
				suchergebnisListe.add(neuesElement);
		}
	}
}
