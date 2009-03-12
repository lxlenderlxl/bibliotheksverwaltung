package bibliotheksverwaltung.model.daos.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import bibliotheksverwaltung.model.domain.Zustand;
import bibliotheksverwaltung.util.LocalEnvironment;
import bibliotheksverwaltung.util.LocalEnvironment;

/**
 * @author Sven Blaurock 03.03.2009 00:27:23
 * 
 */
public class MySQLZustandDAO implements ZustandDAO
{
	private Connection connection = LocalEnvironment.getConnection();
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
			LocalEnvironment.statementChecker(statement, 1, dieBezeichnung);
			statement.executeUpdate();
		} catch (SQLException e)
		{
			LocalEnvironment.log(e.getMessage(), this);
		} finally
		{
			LocalEnvironment.closeStmt(statement);
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
			LocalEnvironment.statementChecker(statement, 1, dieId);
			ResultSet rs = statement.executeQuery();
			while (rs.next())
			{
				einZustand = new Zustand(rs.getInt(1), rs.getString(2));
			}
		} catch (SQLException e)
		{
			LocalEnvironment.log(e.getMessage(), this);
		} finally
		{
			LocalEnvironment.closeStmt(statement);
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
			LocalEnvironment.statementChecker(statement, 1, dieBezeichnung);
			LocalEnvironment.statementChecker(statement, 2, dieId);
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
			LocalEnvironment.log(e.getMessage(), this);
		} finally
		{
			LocalEnvironment.closeStmt(statement);
		}

		return liste;
	}
}