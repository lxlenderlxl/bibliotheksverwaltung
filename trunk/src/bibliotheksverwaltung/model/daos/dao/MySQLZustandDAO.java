package bibliotheksverwaltung.model.daos.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import bibliotheksverwaltung.model.domain.Zustand;
import bibliotheksverwaltung.util.LocalLog;
import bibliotheksverwaltung.util.MySQLConnection;

/**
 * @author Sven Blaurock 03.03.2009 00:27:23
 * 
 */
public class MySQLZustandDAO implements ZustandDAO
{
	private Connection connection = MySQLConnection.getConnection();
	private PreparedStatement statement = null;

	public MySQLZustandDAO()
	{
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
		try
		{
			statement = connection.prepareStatement(
					"INSERT INTO zustand (inhalt) VALUES (?)");
			statement.setString(1, dieBezeichnung);
			statement.executeUpdate();
		} catch (SQLException e)
		{
			LocalLog.add(e.getMessage(), this);
		} finally
		{
			MySQLConnection.closeStmt(statement);
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
		try
		{
			statement = connection.prepareStatement(
					"SELECT * FROM zustand WHERE zustandsid = ?");
			statement.setInt(1, dieId);
			ResultSet rs = statement.executeQuery();
			while (rs.next())
			{
				einZustand = new Zustand(rs.getInt(1), rs.getString(2));
			}
		} catch (SQLException e)
		{
			LocalLog.add(e.getMessage(), this);
		} finally
		{
			MySQLConnection.closeStmt(statement);
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
		try
		{
			statement = connection.prepareStatement(
					"UPDATE zustand SET bezeichnung = ? WHERE zustandsid = ?");
			statement.setString(1, dieBezeichnung);
			statement.setInt(2, dieId);
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
	 * @see bibliotheksverwaltung.model.daos.dao.ZustandDAO#get()
	 */
	@Override
	public ArrayList<Zustand> get()
	{
		ArrayList<Zustand> liste = new ArrayList<Zustand>();;
		try
		{
			statement = connection.prepareStatement(
					"SELECT * FROM zustand");
			ResultSet rs = statement.executeQuery();
			while (rs.next())
			{
				liste.add(new Zustand(rs.getInt(1), rs.getString(2)));
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
}