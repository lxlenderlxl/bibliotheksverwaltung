package bibliotheksverwaltung.model.daos.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import bibliotheksverwaltung.model.domain.Ausleiher;
import bibliotheksverwaltung.util.MySQLConnection;

public class MySQLAusleiherDAO implements AusleiherDAO
{	
	private MySQLConnection connection = null;
	private PreparedStatement statement = null;
	
	public MySQLAusleiherDAO()
	{
		connection = new MySQLConnection();
		refreshConnection();
	}

	public MySQLAusleiherDAO(MySQLConnection dieConnection)
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
	public ArrayList<Ausleiher> get(boolean aktiv)
	{
		this.refreshConnection();
		ArrayList<Ausleiher> liste = new ArrayList<Ausleiher>();;
		try
		{
			statement = connection.getConnection().prepareStatement(
					"SELECT * FROM zustand WHERE aktiv = ?");
			statement.setBoolean(1, aktiv);
			ResultSet rs = statement.executeQuery();
			while (rs.next())
			{
				liste.add(new Ausleiher(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getBoolean(8)));
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
	public Ausleiher get(int dieId)
	{
		Ausleiher einAusleiher = null;
		this.refreshConnection();
		try
		{
			statement = connection.getConnection().prepareStatement(
					"SELECT * FROM zustand WHERE id = ?");
			statement.setInt(1, dieId);
			ResultSet rs = statement.executeQuery();
			while (rs.next())
			{
				einAusleiher = new Ausleiher(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getBoolean(8));
			}
		} catch (SQLException e)
		{
			e.getMessage();
		} finally
		{
			closeStmt();
		}
		return einAusleiher;
	}

	/* (non-Javadoc)
	 * @see bibliotheksverwaltung.model.daos.dao.AnwenderDAO#update(int, java.lang.String, int, boolean)
	 */
	@Override
	public void update(int dieId, String derVorname, String derNachname, String dieStrasse, String dieHausnummer, String diePLZ, String dieStadt, boolean aktiv)
	{
		this.refreshConnection();
		try
		{
			statement = connection.getConnection().prepareStatement(
					"UPDATE ausleiher SET vorname = ?, nachname = ?, strasse = ?, hausnummer = ?, plz = ?, stadt = ?, aktiv = ? WHERE id = ?");
			statement.setString(1, derVorname);
			statement.setString(2, derNachname);
			statement.setString(3, dieStrasse);
			statement.setString(4, dieHausnummer);
			statement.setString(5, diePLZ);
			statement.setString(6, dieStadt);
			statement.setBoolean(7, aktiv);
			statement.setInt(8, dieId);
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
