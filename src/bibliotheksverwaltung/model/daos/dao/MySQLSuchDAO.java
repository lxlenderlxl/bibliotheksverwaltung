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

	//TODO Suche unbeding eingrenzen und optimieren --> Stufenweise die suchergebnisliste füllen (nachpriorität) bis ein bestimmtes maß an medien gefunden wurden
	/*
	 * Z.B. wird zuerst der ganze String gesucht, ob dieser exakt vorkommt ist dies 
	 * nicht der fall so wird der String aufgesplittet und nach exaktem vorkommen der gesplitteten Strings in einem DB-Eintrag gesucht (FULLTEXT-INDIZES)
	 * und dabei priorisiert (nach häufigkeit des vorkommens) weiterhin werden die suchworte mit Platzhalter nach belieben bestückt und wieder in die suchListe aufgenommen und prorisiert
	 * schlagworte bei medien nicht vergessen
	 * Begrenzung über eine Konfiguration realisieren
	 * Suchstring auf operatoren prüfen < > = evtl + -
	 */
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
			System.out.println(e + " bei " + statement.toString());
			LocalEnvironment.log(e.getMessage(), this);
		} finally
		{
			LocalEnvironment.closeStmt(statement);
		}
		Collections.sort(suchergebnisListe);
	}

	private void findMedium()
	{
		String sqlStmt = null;
		try
		{
			for (int i = 0; i < suchKategorien.length; i++)
			{
				for (int j = 0; j < suchworte.length; j++)
				{
					if (suchKategorien[i].equals("erscheinungsjahr") && suchworte[j].contains("<") && j != 0)
					{
						String dasSuchJahr = suchworte[j].substring(1);
						sqlStmt = "SELECT " + this.priKey.getWert() + " FROM " + this.tabelle.getWert()
						+ " WHERE " + suchKategorien[i] + " < ?";
						statement = connection.prepareStatement(sqlStmt);
						statement.setString(1, dasSuchJahr);
						this.processQuery(3 * suchworte[j].length());
					}
					else if (suchKategorien[i].equals("erscheinungsjahr") && suchworte[j].contains(">") && j != 0)
					{
						String dasSuchJahr = suchworte[j].substring(1);
						sqlStmt = "SELECT " + this.priKey.getWert() + " FROM " + this.tabelle.getWert()
						+ " WHERE " + suchKategorien[i] + " > ?";
						statement = connection.prepareStatement(sqlStmt);
						statement.setString(1, dasSuchJahr);
						this.processQuery(3 * suchworte[j].length());
						System.out.println(statement.toString());
					}
					else
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
			}
		} catch (SQLException e)
		{
			System.out.println(e + " bei " + statement.toString());
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
				sqlStmt = "SELECT medienid FROM beinhaltet WHERE tagid IN (SELECT tagid FROM schlagworte WHERE inhalt LIKE ?)";

				statement = connection.prepareStatement(sqlStmt);
				this.optimalLike("%" + suchworte[j] + "%", 1 * suchworte[j].length());
				this.optimalLike("%" + suchworte[j], 2 * suchworte[j].length());
				this.optimalLike(suchworte[j] + "%", 2 * suchworte[j].length());
				this.optimalLike(suchworte[j], 3 * suchworte[j].length());
			}
		} 
		catch (SQLException e)
		{
			System.out.println(e + " bei " + statement.toString());
			LocalEnvironment.log(e.getMessage(), this);
		} finally
		{
			LocalEnvironment.closeStmt(statement);
		}
	}

	public int[] getSuchListe()
	{
		if (this.suchTyp.equals("medium"))
		{
			this.findMedium();
			this.schlagwortFind();
		}
		else
		{
			this.find();
		}
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
		statement.setString(1, dasSuchwort);
		this.processQuery(bewertung);
	}
	
	private void processQuery(int bewertung) throws SQLException
	{
		Suchergebnis neuesElement = null;
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
