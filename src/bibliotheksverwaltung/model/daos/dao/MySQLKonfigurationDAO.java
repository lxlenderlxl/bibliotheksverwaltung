/**
 *
 */
package bibliotheksverwaltung.model.daos.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import bibliotheksverwaltung.model.domain.Konfiguration;
import bibliotheksverwaltung.util.LocalLog;
import bibliotheksverwaltung.util.MySQLConnection;

public class MySQLKonfigurationDAO implements KonfigurationDAO
{
	private Connection connection = MySQLConnection.getConnection();
	private PreparedStatement statement = null;

	public MySQLKonfigurationDAO()
	{
	}

	/* (non-Javadoc)
	 * @see bibliotheksverwaltung.model.daos.dao.KonfigurationDAO#add(java.lang.String)
	 */
	@Override
	public void add(String derName, String derWert)
	{
		try
		{
			statement = connection.prepareStatement(
			"INSERT INTO konfiguration (wert) VALUES (?)");
			statement.setString(1, derWert);
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
	 * @see bibliotheksverwaltung.model.daos.dao.KonfigurationDAO#get()
	 */
	@Override
	public ArrayList<Konfiguration> get()
	{
		ArrayList<Konfiguration> liste = new ArrayList<Konfiguration>();;
		try
		{
			statement = connection.prepareStatement(
			"SELECT * FROM konfiguration");
			ResultSet rs = statement.executeQuery();
			while (rs.next())
			{
				liste.add(new Konfiguration(rs.getString(1), rs.getString(2)));
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
	 * @see bibliotheksverwaltung.model.daos.dao.KonfigurationDAO#get(java.lang.String)
	 */
	@Override
	public Konfiguration get(String derName)
	{
		Konfiguration eineKonfiguration = null;
		try
		{
			statement = connection.prepareStatement(
			"SELECT * FROM konfiguration WHERE name = ?");
			statement.setString(1, derName);
			ResultSet rs = statement.executeQuery();
			while (rs.next())
			{
				eineKonfiguration = new Konfiguration(rs.getString(1), rs.getString(2));
			}
		} catch (SQLException e)
		{
			LocalLog.add(e.getMessage(), this);
		} finally
		{
			MySQLConnection.closeStmt(statement);
		}

		return eineKonfiguration;
	}
	/* (non-Javadoc)
	 * @see bibliotheksverwaltung.model.daos.dao.KonfigurationDAO#update(java.lang.String, java.lang.String)
	 */
	@Override
	public void update(String derName, String derWert)
	{
		try
		{
			statement = connection.prepareStatement(
			"UPDATE konfiguration SET name = ?, wert = ? WHERE name = ?");
			statement.setString(1, derName);
			statement.setString(2, derWert);
			statement.setString(2, derName);
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