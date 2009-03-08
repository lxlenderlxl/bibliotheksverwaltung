/**
 * 
 */
package bibliotheksverwaltung.model.daos.dao;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import bibliotheksverwaltung.model.domain.Log;
import bibliotheksverwaltung.util.MySQLConnection;

public class MySQLLogDAO implements LogDAO
{
	private MySQLConnection connection = null;
	private PreparedStatement statement = null;

	public MySQLLogDAO()
	{
		connection = new MySQLConnection();
		refreshConnection();
	}

	public MySQLLogDAO(MySQLConnection dieConnection)
	{
		connection = dieConnection;
		refreshConnection();
	}

	/* (non-Javadoc)
	 * @see bibliotheksverwaltung.model.daos.dao.LogDAO#add(int, int, java.lang.String, int, java.sql.Date, java.lang.String)
	 */
	@Override
	public void add(int vorgangsID, int ausleiherID, String anwenderName,
			int exemplarID, Date logDatum, String kommentar)
	{
		this.refreshConnection();
		try
		{
			statement = connection.getConnection().prepareStatement(
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
			e.getMessage();
		} finally
		{
			closeStmt();
		}
	}

	/* (non-Javadoc)
	 * @see bibliotheksverwaltung.model.daos.dao.LogDAO#get()
	 */
	@Override
	public ArrayList<Log> get()
	{
		this.refreshConnection();
		ArrayList<Log> liste = new ArrayList<Log>();;
		try
		{
			statement = connection.getConnection().prepareStatement(
					"SELECT * FROM log");
			ResultSet rs = statement.executeQuery();
			while (rs.next())
			{
				liste.add(new Log(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getString(4), rs.getInt(5), rs.getDate(6), rs.getString(7)));
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
	 * @see bibliotheksverwaltung.model.daos.dao.LogDAO#get(int)
	 */
	@Override
	public Log get(int dieId)
	{
		Log einLog = null;
		this.refreshConnection();

		try
		{
			statement = connection.getConnection().prepareStatement(
					"SELECT * FROM log WHERE logid = ?");
			statement.setInt(1, dieId);
			ResultSet rs = statement.executeQuery();
			while (rs.next())
			{
				einLog = new Log(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getString(4), rs.getInt(5), rs.getDate(6), rs.getString(7));
			}
		} catch (SQLException e)
		{
			e.getMessage();
		} finally
		{
			closeStmt();
		}

		return einLog;
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
