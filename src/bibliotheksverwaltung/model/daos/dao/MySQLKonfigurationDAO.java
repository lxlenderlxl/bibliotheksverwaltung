/**
 * 
 */
package bibliotheksverwaltung.model.daos.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import bibliotheksverwaltung.model.domain.Konfiguration;
import bibliotheksverwaltung.model.domain.Zustand;
import bibliotheksverwaltung.util.MySQLConnection;

public class MySQLKonfigurationDAO implements KonfigurationDAO
{
	private MySQLConnection connection = null;
	private PreparedStatement statement = null;
	
	public MySQLKonfigurationDAO()
	{
		connection = new MySQLConnection();
		refreshConnection();
	}

	public MySQLKonfigurationDAO(MySQLConnection dieConnection)
	{
		connection = dieConnection;
		refreshConnection();
	}
	
	/* (non-Javadoc)
	 * @see bibliotheksverwaltung.model.daos.dao.KonfigurationDAO#add(java.lang.String)
	 */
	@Override
	public void add(String derWert)
	{
		this.refreshConnection();
		try
		{
			statement = connection.getConnection().prepareStatement(
					"INSERT INTO konfiguration (wert) VALUES (?)");
			statement.setString(1, derWert);
			statement.executeUpdate();
		} catch (SQLException e)
		{
			e.getMessage();
		} finally
		{
			closeStmt();
		}
	}
	/* (non-Javadoc)
	 * @see bibliotheksverwaltung.model.daos.dao.KonfigurationDAO#get()
	 */
	@Override
	public ArrayList<Konfiguration> get()
	{
		this.refreshConnection();
		ArrayList<Konfiguration> liste = new ArrayList<Konfiguration>();;
		try
		{
			statement = connection.getConnection().prepareStatement(
					"SELECT * FROM konfiguration");
			ResultSet rs = statement.executeQuery();
			while (rs.next())
			{
				liste.add(new Konfiguration(rs.getString(1), rs.getString(2)));
			}
		} catch (SQLException e)
		{
			e.getMessage();
		} finally
		{
			closeStmt();
		}

		return liste;
	}
	/* (non-Javadoc)
	 * @see bibliotheksverwaltung.model.daos.dao.KonfigurationDAO#get(java.lang.String)
	 */
	@Override
	public Konfiguration get(String derName)
	{
		Konfiguration eineKonfiguration = null;
		this.refreshConnection();

		try
		{
			statement = connection.getConnection().prepareStatement(
					"SELECT * FROM konfiguration WHERE name = ?");
			statement.setString(1, derName);
			ResultSet rs = statement.executeQuery();
			while (rs.next())
			{
				eineKonfiguration = new Konfiguration(rs.getString(1), rs.getString(2));
			}
		} catch (SQLException e)
		{
			e.getMessage();
		} finally
		{
			closeStmt();
		}

		return eineKonfiguration;
	}
	/* (non-Javadoc)
	 * @see bibliotheksverwaltung.model.daos.dao.KonfigurationDAO#update(java.lang.String, java.lang.String)
	 */
	@Override
	public void update(String derName, String derWert)
	{
		this.refreshConnection();
		try
		{
			statement = connection.getConnection().prepareStatement(
					"UPDATE konfiguration SET name = ?, wert = ? WHERE name = ?");
			statement.setString(1, derName);
			statement.setString(2, derWert);
			statement.setString(2, derName);
			statement.executeUpdate();
		} catch (SQLException e)
		{
			e.getMessage();
		} finally
		{
			closeStmt();
		}
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
