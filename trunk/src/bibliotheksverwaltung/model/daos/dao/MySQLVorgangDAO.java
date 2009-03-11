/**
 * 
 */
package bibliotheksverwaltung.model.daos.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import bibliotheksverwaltung.model.domain.Vorgang;
import bibliotheksverwaltung.util.LocalLog;
import bibliotheksverwaltung.util.MySQLConnection;

public class MySQLVorgangDAO implements VorgangDAO
{
	private Connection connection = MySQLConnection.getConnection();
	private PreparedStatement statement = null;

	public MySQLVorgangDAO()
	{
	}

	/* (non-Javadoc)
	 * @see bibliotheksverwaltung.model.daos.dao.VorgangDAO#add(java.lang.String)
	 */
	@Override
	public void add(String derInhalt)
	{
		try
		{
			statement = connection.prepareStatement("INSERT INTO vorgang (inhalt) VALUES (?)");
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
	 * @see bibliotheksverwaltung.model.daos.dao.VorgangDAO#get()
	 */
	@Override
	public ArrayList<Vorgang> get()
	{
		ArrayList<Vorgang> liste = new ArrayList<Vorgang>();;
		try
		{
			statement = connection.prepareStatement(
			"SELECT * FROM vorgang");
			ResultSet rs = statement.executeQuery();
			while (rs.next())
			{
				liste.add(new Vorgang(rs.getInt(1), rs.getString(2)));
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
	 * @see bibliotheksverwaltung.model.daos.dao.VorgangDAO#get(int)
	 */
	@Override
	public Vorgang get(int dieVorgangsID)
	{
		Vorgang einVorgang = null;
		try
		{
			statement = connection.prepareStatement(
			"SELECT * FROM vorgang WHERE vorgangsid = ?");
			statement.setInt(1, dieVorgangsID);
			ResultSet rs = statement.executeQuery();
			while (rs.next())
			{
				einVorgang = new Vorgang(rs.getInt(1), rs.getString(2));
			}
		} catch (SQLException e)
		{
			LocalLog.add(e.getMessage(), this);
		} finally
		{
			MySQLConnection.closeStmt(statement);
		}
		return einVorgang;
	}

	/* (non-Javadoc)
	 * @see bibliotheksverwaltung.model.daos.dao.VorgangDAO#update(int, java.lang.String)
	 */
	@Override
	public void update(int dieVorgangsID, String derInhalt)
	{
		try
		{
			statement = connection.prepareStatement(
			"UPDATE vorgang SET inhalt = ? WHERE vorgangsid = ?");
			statement.setInt(1, dieVorgangsID);
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