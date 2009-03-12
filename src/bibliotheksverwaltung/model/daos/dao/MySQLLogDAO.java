/**
 * 
 */
package bibliotheksverwaltung.model.daos.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import bibliotheksverwaltung.model.domain.Log;
import bibliotheksverwaltung.util.LocalEnvironment;
import bibliotheksverwaltung.util.LocalEnvironment;

public class MySQLLogDAO implements LogDAO
{
	private Connection connection = LocalEnvironment.getConnection();
	private PreparedStatement statement = null;

	public MySQLLogDAO()
	{
	}

	/* (non-Javadoc)
	 * @see bibliotheksverwaltung.model.daos.dao.LogDAO#add(int, int, java.lang.String, int, java.sql.Date, java.lang.String)
	 */
	@Override
	public void add(int vorgangsID, int ausleiherID, String anwenderName,
			int exemplarID, Date logDatum, String kommentar)
	{
		try
		{
			statement = connection.prepareStatement(
			"INSERT INTO log (vorgangsid, ausleiherid, anwendername, exemplarid, logdatum, kommentar) VALUES (?, ?, ?, ?, ?, ?)");
			statement.setInt(1, vorgangsID);
			statement.setInt(2, ausleiherID);
			statement.setString(3, anwenderName);
			statement.setInt(4, exemplarID);
			statement.setDate(5, logDatum);
			statement.setString(6, kommentar);
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
	 * @see bibliotheksverwaltung.model.daos.dao.LogDAO#get()
	 */
	@Override
	public ArrayList<Log> get()
	{
		ArrayList<Log> liste = new ArrayList<Log>();;
		try
		{
			statement = connection.prepareStatement(
			"SELECT * FROM log");
			ResultSet rs = statement.executeQuery();
			while (rs.next())
			{
				liste.add(new Log(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getString(4), rs.getInt(5), rs.getDate(6), rs.getString(7)));
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
	 * @see bibliotheksverwaltung.model.daos.dao.LogDAO#get(int)
	 */
	@Override
	public Log get(int dieId)
	{
		Log einLog = null;
		try
		{
			statement = connection.prepareStatement(
			"SELECT * FROM log WHERE logid = ?");
			statement.setInt(1, dieId);
			ResultSet rs = statement.executeQuery();
			while (rs.next())
			{
				einLog = new Log(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getString(4), rs.getInt(5), rs.getDate(6), rs.getString(7));
			}
		} catch (SQLException e)
		{
			LocalEnvironment.log(e.getMessage(), this);
		} finally
		{
			LocalEnvironment.closeStmt(statement);
		}

		return einLog;
	}
}
