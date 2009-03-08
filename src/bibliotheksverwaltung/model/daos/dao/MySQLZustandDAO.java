package bibliotheksverwaltung.model.daos.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import bibliotheksverwaltung.model.domain.Zustand;
import bibliotheksverwaltung.util.MySQLConnection;

/**
 * @author Sven Blaurock 03.03.2009 00:27:23
 * 
 */
public class MySQLZustandDAO implements ZustandDAO
{
	private MySQLConnection connection = null;
	private PreparedStatement statement = null;

	public MySQLZustandDAO()
	{
		connection = new MySQLConnection();
		refreshConnection();
	}

	public MySQLZustandDAO(MySQLConnection dieConnection)
	{
		connection = dieConnection;
		refreshConnection();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * bibliotheksverwaltung.model.daos.dao.ZustandDAO#add(bibliotheksverwaltung
	 * .model.domain.Zustand)
	 */
	@Override
	public void add(String dieBezeichnung)
	{
		this.refreshConnection();
		try
		{
			statement = connection.getConnection().prepareStatement(
					"INSERT INTO zustand (inhalt) VALUES (?)");
			statement.setString(1, dieBezeichnung);
			statement.executeUpdate();
		} catch (SQLException e)
		{
			e.getMessage();
		} finally
		{
			closeStmt();
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see bibliotheksverwaltung.model.daos.dao.ZustandDAO#findById(int)
	 */
	@Override
	public Zustand get(int dieId)
	{
		Zustand einZustand = null;
		this.refreshConnection();

		try
		{
			statement = connection.getConnection().prepareStatement(
					"SELECT * FROM zustand WHERE zustandsid = ?");
			statement.setInt(1, dieId);
			ResultSet rs = statement.executeQuery();
			while (rs.next())
			{
				einZustand = new Zustand(rs.getInt(1), rs.getString(2));
			}
		} catch (SQLException e)
		{
			e.getMessage();
		} finally
		{
			closeStmt();
		}

		return einZustand;
	}


	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * bibliotheksverwaltung.model.daos.dao.ZustandDAO#update(bibliotheksverwaltung
	 * .model.domain.Zustand)
	 */
	@Override
	public void update(int dieId, String dieBezeichnung)
	{
		this.refreshConnection();
		try
		{
			statement = connection.getConnection().prepareStatement(
					"UPDATE zustand SET bezeichnung = ? WHERE zustandsid = ?");
			statement.setString(1, dieBezeichnung);
			statement.setInt(2, dieId);
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
	 * @see bibliotheksverwaltung.model.daos.dao.ZustandDAO#get()
	 */
	@Override
	public ArrayList<Zustand> get()
	{
		this.refreshConnection();
		ArrayList<Zustand> liste = new ArrayList<Zustand>();;
		try
		{
			statement = connection.getConnection().prepareStatement(
					"SELECT * FROM zustand");
			ResultSet rs = statement.executeQuery();
			while (rs.next())
			{
				liste.add(new Zustand(rs.getInt(1), rs.getString(2)));
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
