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
import bibliotheksverwaltung.util.LocalEnvironment;

public class MySQLKonfigurationDAO implements KonfigurationDAO
{
	private Connection connection = LocalEnvironment.getConnection();
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
			LocalEnvironment.statementChecker(statement, 1, derWert);
			statement.executeUpdate();
		} catch (SQLException e)
		{
			LocalEnvironment.log(e.getMessage(), this);
		} finally
		{
			LocalEnvironment.closeStmt(statement);
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
			LocalEnvironment.log(e.getMessage(), this);
		} finally
		{
			LocalEnvironment.closeStmt(statement);
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
			LocalEnvironment.statementChecker(statement, 1, derName);
			ResultSet rs = statement.executeQuery();
			while (rs.next())
			{
				eineKonfiguration = new Konfiguration(rs.getString(1), rs.getString(2));
			}
		} catch (SQLException e)
		{
			LocalEnvironment.log(e.getMessage(), this);
		} finally
		{
			LocalEnvironment.closeStmt(statement);
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
			LocalEnvironment.statementChecker(statement, 1, derName);
			LocalEnvironment.statementChecker(statement, 2, derWert);
			LocalEnvironment.statementChecker(statement, 3, derName);
			statement.executeUpdate();
		} catch (SQLException e)
		{
			LocalEnvironment.log(e.getMessage(), this);
		} finally
		{
			LocalEnvironment.closeStmt(statement);
		}
	}
}