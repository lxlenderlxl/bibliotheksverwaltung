/**
 * 
 */
package bibliotheksverwaltung.model.daos.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import bibliotheksverwaltung.model.domain.Vorgang;
import bibliotheksverwaltung.util.MySQLConnection;

public class MySQLVorgangDAO implements VorgangDAO
{
	private MySQLConnection connection = null;
	private PreparedStatement statement = null;
	
	public MySQLVorgangDAO()
	{
		connection = new MySQLConnection();
		refreshConnection();
	}

	public MySQLVorgangDAO(MySQLConnection dieConnection)
	{
		connection = dieConnection;
		refreshConnection();
	}

	/* (non-Javadoc)
	 * @see bibliotheksverwaltung.model.daos.dao.VorgangDAO#add(java.lang.String)
	 */
	@Override
	public void add(String derInhalt)
	{
		this.refreshConnection();
		try
		{
			statement = connection.getConnection().prepareStatement("INSERT INTO vorgang (inhalt) VALUES (?)");
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
	 * @see bibliotheksverwaltung.model.daos.dao.VorgangDAO#get()
	 */
	@Override
	public ArrayList<Vorgang> get()
	{
		this.refreshConnection();
		ArrayList<Vorgang> liste = new ArrayList<Vorgang>();;
		try
		{
			statement = connection.getConnection().prepareStatement(
					"SELECT * FROM vorgang");
			ResultSet rs = statement.executeQuery();
			while (rs.next())
			{
				liste.add(new Vorgang(rs.getInt(1), rs.getString(2)));
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
	 * @see bibliotheksverwaltung.model.daos.dao.VorgangDAO#get(int)
	 */
	@Override
	public Vorgang get(int dieVorgangsID)
	{
		Vorgang einVorgang = null;
		this.refreshConnection();
		try
		{
			statement = connection.getConnection().prepareStatement(
					"SELECT * FROM vorgang WHERE vorgangsid = ?");
			statement.setInt(1, dieVorgangsID);
			ResultSet rs = statement.executeQuery();
			while (rs.next())
			{
				einVorgang = new Vorgang(rs.getInt(1), rs.getString(2));
			}
		} catch (SQLException e)
		{
			e.getMessage();
		} finally
		{
			closeStmt();
		}
		return einVorgang;
	}

	/* (non-Javadoc)
	 * @see bibliotheksverwaltung.model.daos.dao.VorgangDAO#update(int, java.lang.String)
	 */
	@Override
	public void update(int dieVorgangsID, String derInhalt)
	{
		this.refreshConnection();
		try
		{
			statement = connection.getConnection().prepareStatement(
					"UPDATE vorgang SET inhalt = ? WHERE vorgangsid = ?");
			statement.setInt(1, dieVorgangsID);
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
			e.printStackTrace();
		}
	}
}
