/**
 * 
 */
package bibliotheksverwaltung.model.daos.dao;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import bibliotheksverwaltung.model.domain.Exemplar;
import bibliotheksverwaltung.model.domain.Medium;
import bibliotheksverwaltung.util.MySQLConnection;

/**
 * @author Sven Blaurock 28.02.2009 18:28:58
 *
 */
public class MySQLExemplarDAO implements ExemplarDAO
{
	private MySQLConnection connection = null;
	private PreparedStatement statement = null;
	
	public MySQLExemplarDAO()
	{
		connection = new MySQLConnection();
		refreshConnection();
	}

	public MySQLExemplarDAO(MySQLConnection dieConnection)
	{
		connection = dieConnection;
		refreshConnection();
	}
	
	/* (non-Javadoc)
	 * @see bibliotheksverwaltung.model.daos.dao.ExemplarDAO#add(java.lang.String, java.lang.String, int, boolean)
	 */
	@Override
	public void add(int zustandsid, int benutzerid, int medienid, Date rueckgabedatum, int verlaengerung, boolean aktiv)
	{
		this.refreshConnection();
		try
		{
			statement = connection.getConnection().prepareStatement("INSERT INTO exemplar (zustandsid, benutzerid, medienid, rueckgabedatum, verlaengerung, aktiv) VALUES (?, ?, ?, ?, ?, ?)");
			statement.setInt(1, zustandsid);
			statement.setInt(2, benutzerid);
			statement.setInt(3, medienid);
			statement.setDate(4, rueckgabedatum);
			statement.setInt(5, verlaengerung);
			statement.setBoolean(6, aktiv);
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
	 * @see bibliotheksverwaltung.model.daos.dao.ExemplarDAO#get(boolean)
	 */
	@Override
	public ArrayList<Exemplar> get(boolean aktiv)
	{
		this.refreshConnection();
		ArrayList<Exemplar> liste = new ArrayList<Exemplar>();
		try
		{
			statement = connection.getConnection().prepareStatement(
					"SELECT * FROM exemplar WHERE aktiv = ?");
			statement.setBoolean(1, aktiv);
			ResultSet rs = statement.executeQuery();
			while (rs.next())
			{
				liste.add(new Exemplar(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getInt(4), rs.getDate(5), rs.getInt(6), rs.getBoolean(7)));
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
	 * @see bibliotheksverwaltung.model.daos.dao.ExemplarDAO#get(int)
	 */
	@Override
	public Exemplar get(int dieId)
	{
		this.refreshConnection();
		Exemplar einExemplar = null;
		try
		{
			statement = connection.getConnection().prepareStatement(
					"SELECT * FROM exemplar WHERE exemplarid = ?");
			statement.setInt(1, dieId);
			ResultSet rs = statement.executeQuery();
			while (rs.next())
			{
				einExemplar = new Exemplar(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getInt(4), rs.getDate(5), rs.getInt(6), rs.getBoolean(7));
			}
		} catch (SQLException e)
		{
			e.getMessage();
		} finally
		{
			closeStmt();
		}
		return einExemplar;
	}
	
	/* (non-Javadoc)
	 * @see bibliotheksverwaltung.model.daos.dao.ExemplarDAO#update(int, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, boolean)
	 */
	@Override
	public void update(int dieId, int zustandsid, int benutzerid, int medienid, Date rueckgabedatum, int verlaengerung, boolean aktiv)
	{
		this.refreshConnection();
		try
		{
			statement = connection.getConnection().prepareStatement(
					"UPDATE exemplar SET zustandsid = ?, benutzerid = ?, medienid = ?, rueckgabedatum = ?, verlaengerung = ?, aktiv = ? WHERE exemplarid = ?");
			statement.setInt(1, zustandsid);
			statement.setInt(2, benutzerid);
			statement.setInt(3, medienid);
			statement.setDate(4, rueckgabedatum);
			statement.setInt(5, verlaengerung);
			statement.setBoolean(6, aktiv);
			statement.setInt(7, dieId);
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
