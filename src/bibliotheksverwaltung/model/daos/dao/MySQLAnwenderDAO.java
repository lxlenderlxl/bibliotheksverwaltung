package bibliotheksverwaltung.model.daos.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import bibliotheksverwaltung.model.domain.Anwender;
import bibliotheksverwaltung.util.MySQLConnection;


public class MySQLAnwenderDAO implements AnwenderDAO
{
	private Connection connection = MySQLConnection.getConnection();
	private PreparedStatement statement = null;

	public MySQLAnwenderDAO()
	{
		
	}

	/* (non-Javadoc)
	 * @see bibliotheksverwaltung.model.daos.dao.AnwenderDAO#add(java.lang.String, int, boolean)
	 */
	@Override
	public void add(String derName, String dasPasswort, int dieHierarchieStufe, boolean aktiv)
	{
		try
		{
			statement = connection.prepareStatement("INSERT INTO anwender (anwendername, passwort, hierarchiestufe, aktiv) VALUES (?, ?, ?, ?)");
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
			MySQLConnection.closeStmt(statement);
		}
	}
	/* (non-Javadoc)
	 * @see bibliotheksverwaltung.model.daos.dao.AnwenderDAO#get()
	 */
	@Override
	public ArrayList<Anwender> get(boolean aktiv)
	{
		ArrayList<Anwender> liste = new ArrayList<Anwender>();;
		try
		{
			statement = connection.prepareStatement(
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
			MySQLConnection.closeStmt(statement);
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
		try
		{
			statement = connection.prepareStatement(
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
			MySQLConnection.closeStmt(statement);
		}
		return einAnwender;
	}
	/* (non-Javadoc)
	 * @see bibliotheksverwaltung.model.daos.dao.AnwenderDAO#update(int, java.lang.String, int, boolean)
	 */
	@Override
	public void update(String derName, String dasPasswort, int dieHierarchieStufe, boolean aktiv)
	{
		try
		{
			statement = connection.prepareStatement(
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
			MySQLConnection.closeStmt(statement);
		}
	}
}
