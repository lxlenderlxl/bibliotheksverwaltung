/**
 * 
 */
package bibliotheksverwaltung.model.daos.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import bibliotheksverwaltung.model.domain.Anwender;
import bibliotheksverwaltung.model.domain.Schlagwort;
import bibliotheksverwaltung.util.MySQLConnection;

public class MySQLSchlagwortDAO implements SchlagwortDAO
{
	private MySQLConnection connection = null;
	private PreparedStatement statement = null;
	
	public MySQLSchlagwortDAO()
	{
		connection = new MySQLConnection();
		refreshConnection();
	}

	public MySQLSchlagwortDAO(MySQLConnection dieConnection)
	{
		connection = dieConnection;
		refreshConnection();
	}

	/* (non-Javadoc)
	 * @see bibliotheksverwaltung.model.daos.dao.SchlagwortDAO#add(java.lang.String)
	 */
	@Override
	public void add(String derInhalt)
	{
		this.refreshConnection();
		try
		{
			statement = connection.getConnection().prepareStatement("INSERT INTO schlagworte (inhalt) VALUES (?)");
			statement.setString(1, derInhalt);
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
	 * @see bibliotheksverwaltung.model.daos.dao.SchlagwortDAO#get(boolean)
	 */
	@Override
	public ArrayList<Schlagwort> get()
	{
		this.refreshConnection();
		ArrayList<Schlagwort> liste = new ArrayList<Schlagwort>();;
		try
		{
			statement = connection.getConnection().prepareStatement(
					"SELECT * FROM schlagworte");
			ResultSet rs = statement.executeQuery();
			while (rs.next())
			{
				liste.add(new Schlagwort(rs.getInt(1), rs.getString(2)));
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
	 * @see bibliotheksverwaltung.model.daos.dao.SchlagwortDAO#get(java.lang.String)
	 */
	@Override
	public Schlagwort get(int dieTagId)
	{
		Schlagwort einSchlagwort = null;
		this.refreshConnection();
		try
		{
			statement = connection.getConnection().prepareStatement(
					"SELECT * FROM schlagwort WHERE tagid = ?");
			statement.setInt(1, dieTagId);
			ResultSet rs = statement.executeQuery();
			while (rs.next())
			{
				einSchlagwort = new Schlagwort(rs.getInt(1), rs.getString(2));
			}
		} catch (SQLException e)
		{
			e.getMessage();
		} finally
		{
			closeStmt();
		}
		return einSchlagwort;
	}

	/* (non-Javadoc)
	 * @see bibliotheksverwaltung.model.daos.dao.SchlagwortDAO#update(int, java.lang.String)
	 */
	@Override
	public void update(int dieTagID, String derInhalt)
	{
		this.refreshConnection();
		try
		{
			statement = connection.getConnection().prepareStatement(
					"UPDATE schlagwort SET inahlt = ? WHERE tagid = ?");
			statement.setInt(1, dieTagID);
			statement.setString(2, derInhalt);
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
