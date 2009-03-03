package bibliotheksverwaltung.model.daos.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import bibliotheksverwaltung.model.daos.exceptions.DataStoreException;
import bibliotheksverwaltung.model.domain.Ausleiher;
import bibliotheksverwaltung.model.domain.Medium;
import bibliotheksverwaltung.util.MySQLConnection;

public class MySQLAusleiherDAO implements AusleiherDAO
{	
	private MySQLConnection connection = null;
	private PreparedStatement statement = null;
	
	public MySQLAusleiherDAO () 
	{
		connection = new MySQLConnection();
	}
	
	public MySQLAusleiherDAO(MySQLConnection dieConnection) 
	{
		connection = dieConnection;
	}

	@Override
	public void add(Ausleiher derAusleiher)
	{
		if (connection != null)
		{
			try
			{
				String dasStatement = "INSERT INTO ausleiher (vorname, nachname, strasse, hausnummer, plz, stadt, aktiv) VALUES (?, ?, ?, ?, ?, ?, ?)";
				statement = connection.getConnection().prepareStatement(dasStatement);
				statement.setString(1, derAusleiher.getVorName());
				statement.setString(2, derAusleiher.getNachName());
				statement.setString(3, derAusleiher.getStrasse());
				statement.setString(4, derAusleiher.getHausnummer());
				statement.setInt(5, derAusleiher.getPlz());
				statement.setString(6, derAusleiher.getStadt());
				statement.setBoolean(7, derAusleiher.isAktiv());
				statement.executeUpdate();
			}
			catch (SQLException e)
			{
				throw new DataStoreException(e);
			}
		}
	}

	@Override
	public void deactivate(Ausleiher derAusleiher)
	{
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void activate(Ausleiher derAusleiher)
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public ArrayList<Ausleiher> find(Ausleiher derAusleiher)
	{
		ArrayList<Ausleiher> list = new ArrayList<Ausleiher>();
		if (connection != null)
		{
			try
			{
				String dasStatement = "SELECT * FROM ausleiher WHERE vorname LIKE ? AND nachname LIKE ? AND strasse LIKE ? AND hausnummer LIKE ? AND plz LIKE ? AND stadt LIKE ? AND aktiv =";
				statement = connection.getConnection().prepareStatement(dasStatement);
				statement.setString(1, stringLikeTransformator(derAusleiher.getVorName()));
				statement.setString(2, stringLikeTransformator(derAusleiher.getNachName()));
				statement.setString(3, stringLikeTransformator(derAusleiher.getStrasse()));
				statement.setString(4, stringLikeTransformator(derAusleiher.getHausnummer()));
				statement.setInt(5, derAusleiher.getPlz());
				statement.setString(6, stringLikeTransformator(derAusleiher.getStadt()));
				statement.setBoolean(7, derAusleiher.isAktiv());
				ResultSet rs = statement.executeQuery();
				while (rs.next())
				{
					Ausleiher einAusleiher = new Ausleiher(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getInt(6), rs.getString(7), rs.getBoolean(8));					
					list.add(einAusleiher);
				}
			}
			catch (SQLException e)
			{
				e.getMessage();
			}
		}
		return list;
	}

	@Override
	public ArrayList<Ausleiher> retrieve()
	{
		ArrayList<Ausleiher> list = new ArrayList<Ausleiher>();
		if (connection != null)
		{
			try
			{
				statement = connection.getConnection().prepareStatement("SELECT * FROM ausleiher WHERE AKTIV = 1");
				ResultSet rs = statement.executeQuery();
				while (rs.next())
				{
					Ausleiher einAusleiher = new Ausleiher(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getInt(6), rs.getString(7), rs.getBoolean(8));					
					list.add(einAusleiher);
				}
			}
			catch (SQLException e)
			{
				e.getMessage();
			}
		}		
		return list;
	}

	@Override
	public ArrayList<Ausleiher> retrieveAll()
	{
		ArrayList<Ausleiher> list = new ArrayList<Ausleiher>();
		if (connection != null)
		{
			try
			{
				statement = connection.getConnection().prepareStatement("SELECT * FROM ausleiher");
				ResultSet rs = statement.executeQuery();
				while (rs.next())
				{
					Ausleiher einAusleiher = new Ausleiher(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getInt(6), rs.getString(7), rs.getBoolean(8));					
					list.add(einAusleiher);
				}
			}
			catch (SQLException e)
			{
				e.getMessage();
			}
		}		
		return list;
	}

	@Override
	public void update(Ausleiher derAusleiher)
	{
		if (connection != null)
		{
			try
			{
				String dasStatement = "UPDATE ausleiher SET vorname = ?, nachname = ?, strasse = ?, hausnummer = ?, plz = ?, stadt = ?, aktiv = ? WHERE id = ?";
				statement = connection.getConnection().prepareStatement(dasStatement);
				statement.setString(1, derAusleiher.getVorName());
				statement.setString(2, derAusleiher.getNachName());
				statement.setString(3, derAusleiher.getStrasse());
				statement.setString(4, derAusleiher.getHausnummer());
				statement.setInt(5, derAusleiher.getPlz());
				statement.setString(6, derAusleiher.getStadt());
				statement.setBoolean(7, derAusleiher.isAktiv());
				statement.setInt(8, derAusleiher.getId());
				statement.executeUpdate();
			}
			catch (SQLException e)
			{
				throw new DataStoreException(e);
			}
		}
	}
	
	private String stringLikeTransformator(String derString)
	{
		return "%" + derString + "%";
	}

	/* (non-Javadoc)
	 * @see bibliotheksverwaltung.model.daos.dao.AusleiherDAO#findById(int)
	 */
	@Override
	public Ausleiher findById(int dieId)
	{
		Ausleiher einAusleiher = null;
		if (connection != null)
		{
			try
			{
				statement = connection.getConnection().prepareStatement("SELECT * FROM ausleiher WHERE id = ?");
				statement.setInt(1, dieId);
				ResultSet rs = statement.executeQuery();
				while (rs.next())
				{
					einAusleiher = new Ausleiher(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getInt(6), rs.getString(7), rs.getBoolean(8));					
				}
			}
			catch (SQLException e)
			{
				e.getMessage();
			}
		}
		
		return einAusleiher;
	}

}
