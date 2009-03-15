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
import bibliotheksverwaltung.model.domain.Suchergebnis;

/**
 * @deprecated
 */
public class MySQLSuche
{
	private Connection connection = LocalEnvironment.getConnection();
	private PreparedStatement statement = null;
	private ArrayList<Suchergebnis> suchergebnisListe = null;
	private String[] suchworte = null;
	private String[] suchKategorien = null;
	private Konfiguration tabelle = null;
	private Konfiguration priKey = null;
	private String suchTyp = null;


	public MySQLSuche()
	{
		this.suchergebnisListe = new ArrayList<Suchergebnis>();
	}

	public MySQLSuche(String suchTyp, String[] dieSuchworte, String[] dieSuchKategorien)
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

				statement = connection.prepareStatement(sqlStmt);

				for (int j = 0; j < suchworte.length; j++)
					statement.setString(j + 1, fullLike(suchworte[j]));

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
			LocalEnvironment.log(e.getMessage(), this);
		} finally
		{
			LocalEnvironment.closeStmt(statement);
		}
		return suchergebnisListe;
	}

	private String fullLike(String dasWort)
	{
		return "%" + dasWort + "%";
	}
}
