/**
 * 
 */
package bibliotheksverwaltung.util;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.TreeSet;

import bibliotheksverwaltung.model.domain.Medium;

public class MySQLSuche
{
	private MySQLConnection connection = null;
	private PreparedStatement statement = null;

	public MySQLSuche()
	{
		connection = new MySQLConnection();
		refreshConnection();
	}

	public MySQLSuche(MySQLConnection dieConnection)
	{
		connection = dieConnection;
		refreshConnection();
	}

	public ArrayList<Suchergebnis> find(String tabelle, String suchworte[], String suchKategorien[])
	{
		this.refreshConnection();
		ArrayList<Suchergebnis> liste = new ArrayList<Suchergebnis>();
		Suchergebnis neuesElement = null;
		try
		{
			for (int i = 0; i < suchKategorien.length; i++)
			{
				statement = connection.getConnection().prepareStatement("SELECT medienid FROM " + tabelle + " WHERE " + suchKategorien[i] + " LIKE ?");		
				for (int j = 0; j < suchworte.length; j++)
				{
					statement.setString(1, stringLikeTransformator(suchworte[j]));
					ResultSet rs = statement.executeQuery();
					System.out.println(statement);
					while (rs.next())
					{
						neuesElement = new Suchergebnis(rs.getInt(1)); 
						if (liste.contains(neuesElement))
							liste.get(liste.indexOf(neuesElement)).erhoehe();
						else
							liste.add(new Suchergebnis(rs.getInt(1)));
					}
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
		Collections.sort(liste);
		//System.out.println(liste);
		return liste;
	}

	private String stringLikeTransformator(String dasWort)
	{
		return "%" + dasWort + "%";
	}

	private void refreshConnection()
	{
		try
		{
			if (connection.getConnection().isClosed())
				connection = new MySQLConnection();
		} catch (SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void closeStmt()
	{
		try
		{
			statement.close();
		} catch (SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
