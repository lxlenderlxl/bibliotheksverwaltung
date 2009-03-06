package bibliotheksverwaltung.model.daos.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import bibliotheksverwaltung.model.domain.Anwender;
import bibliotheksverwaltung.util.MySQLConnection;


public class MySQLAnwenderDAO implements AnwenderDAO
{
	private MySQLConnection connection = null;
	private PreparedStatement statement = null;

	public MySQLAnwenderDAO()
	{
		connection = new MySQLConnection();
		refreshConnection();
	}

	public MySQLAnwenderDAO(MySQLConnection dieConnection)
	{
		connection = dieConnection;
		refreshConnection();
	}

	/* (non-Javadoc)
	 * @see bibliotheksverwaltung.model.daos.dao.AnwenderDAO#add(java.lang.String, int, boolean)
	 */
	@Override
	public void add(String derName, String dasPasswort, int dieHierarchieStufe, boolean aktiv)
	{
		this.refreshConnection();
		try
		{
			statement = connection.getConnection().prepareStatement("INSERT INTO anwender (anwendername, passwort, hierarchiestufe, aktiv) VALUES (?, ?, ?, ?)");
			statement.setString(1, derName);
			statement.setString(2, dasPasswort);
			statement.setInt(3, dieHierarchieStufe);
			statement.setBoolean(4, aktiv);
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
	 * @see bibliotheksverwaltung.model.daos.dao.AnwenderDAO#get()
	 */
	@Override
	public ArrayList<Anwender> get(boolean aktiv)
	{
		this.refreshConnection();
		ArrayList<Anwender> liste = new ArrayList<Anwender>();;
		try
		{
			statement = connection.getConnection().prepareStatement(
					"SELECT * FROM anwender WHERE aktiv = ?");
			statement.setBoolean(1, aktiv);
			ResultSet rs = statement.executeQuery();
			while (rs.next())
			{
				liste.add(new Anwender(rs.getString(1), rs.getString(2), rs.getInt(3), rs.getBoolean(4)));
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
	 * @see bibliotheksverwaltung.model.daos.dao.AnwenderDAO#get(int)
	 */
	@Override
	public Anwender get(String anwenderName)
	{
		Anwender einAnwender = null;
		this.refreshConnection();
		try
		{
			statement = connection.getConnection().prepareStatement(
					"SELECT * FROM anwender WHERE anwendername = ?");
			statement.setString(1, anwenderName);
			ResultSet rs = statement.executeQuery();
			while (rs.next())
			{
				einAnwender = new Anwender(rs.getString(1), rs.getString(2), rs.getInt(3), rs.getBoolean(4));
			}
		} catch (SQLException e)
		{
			e.getMessage();
		} finally
		{
			closeStmt();
		}
		return einAnwender;
	}
	/* (non-Javadoc)
	 * @see bibliotheksverwaltung.model.daos.dao.AnwenderDAO#update(int, java.lang.String, int, boolean)
	 */
	@Override
	public void update(String derName, String dasPasswort, int dieHierarchieStufe, boolean aktiv)
	{
		this.refreshConnection();
		try
		{
			statement = connection.getConnection().prepareStatement(
					"UPDATE anwender SET anwendername = ?, passwort = ?, hierarchiestufe = ?, aktiv = ? WHERE anwendername = ?");
			statement.setString(1, derName);
			statement.setString(2, dasPasswort);
			statement.setInt(3, dieHierarchieStufe);
			statement.setBoolean(4, aktiv);
			statement.setString(4, derName);
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
