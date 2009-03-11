/**
 * 
 */
package bibliotheksverwaltung.model.daos.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import bibliotheksverwaltung.model.domain.Schlagwort;
import bibliotheksverwaltung.util.LocalLog;
import bibliotheksverwaltung.util.MySQLConnection;

public class MySQLSchlagwortDAO implements SchlagwortDAO
{
	private Connection connection = MySQLConnection.getConnection();
	private PreparedStatement statement = null;

	public MySQLSchlagwortDAO()
	{
	}

	/* (non-Javadoc)
	 * @see bibliotheksverwaltung.model.daos.dao.SchlagwortDAO#add(java.lang.String)
	 */
	@Override
	public void add(String derInhalt)
	{
		try
		{
			statement = connection.prepareStatement("INSERT INTO schlagworte (inhalt) VALUES (?)");
			statement.setString(1, derInhalt);
			statement.executeUpdate();
		} catch (SQLException e)
		{
			LocalLog.add(e.getMessage(), this);
		} finally
		{
			MySQLConnection.closeStmt(statement);
		}
	}

	/* (non-Javadoc)
	 * @see bibliotheksverwaltung.model.daos.dao.SchlagwortDAO#get(boolean)
	 */
	@Override
	public ArrayList<Schlagwort> get()
	{
		ArrayList<Schlagwort> liste = new ArrayList<Schlagwort>();;
		try
		{
			statement = connection.prepareStatement(
			"SELECT * FROM schlagworte");
			ResultSet rs = statement.executeQuery();
			while (rs.next())
			{
				liste.add(new Schlagwort(rs.getInt(1), rs.getString(2)));
			}
		} catch (SQLException e)
		{
			LocalLog.add(e.getMessage(), this);
		} finally
		{
			MySQLConnection.closeStmt(statement);
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
		try
		{
			statement = connection.prepareStatement(
			"SELECT * FROM schlagwort WHERE tagid = ?");
			statement.setInt(1, dieTagId);
			ResultSet rs = statement.executeQuery();
			while (rs.next())
			{
				einSchlagwort = new Schlagwort(rs.getInt(1), rs.getString(2));
			}
		} catch (SQLException e)
		{
			LocalLog.add(e.getMessage(), this);
		} finally
		{
			MySQLConnection.closeStmt(statement);
		}
		return einSchlagwort;
	}

	/* (non-Javadoc)
	 * @see bibliotheksverwaltung.model.daos.dao.SchlagwortDAO#update(int, java.lang.String)
	 */
	@Override
	public void update(int dieTagID, String derInhalt)
	{
		try
		{
			statement = connection.prepareStatement(
			"UPDATE schlagwort SET inhalt = ? WHERE tagid = ?");
			statement.setInt(1, dieTagID);
			statement.setString(2, derInhalt);
			statement.executeUpdate();
		} catch (SQLException e)
		{
			LocalLog.add(e.getMessage(), this);
		} finally
		{
			MySQLConnection.closeStmt(statement);
		}
	}
}