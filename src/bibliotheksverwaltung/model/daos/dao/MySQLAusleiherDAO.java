package bibliotheksverwaltung.model.daos.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import bibliotheksverwaltung.model.daos.domain.Ausleiher;
import bibliotheksverwaltung.model.daos.domain.Medium;
import bibliotheksverwaltung.model.daos.exceptions.DataStoreException;


public class MySQLAusleiherDAO implements AusleiherDAO
{	
	private Connection connection = null;
	private PreparedStatement statement = null;
	
	public MySQLAusleiherDAO () 
	{
		try 
		{
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/bibliotheksverwaltung","root", "");
		}
		catch (ClassNotFoundException e)
		{
			e.getMessage();
		}
		catch (SQLException e)
		{
			e.getMessage();
		}
		catch (Exception e)
		{
			e.getMessage();
		}
	}

	@Override
	public void add(Ausleiher derAusleiher)
	{
		if (connection != null)
		{
			try
			{
				String dasStatement = "INSERT INTO ausleiher (vorname, nachname, strasse, hausnummer, plz, stadt, aktiv) VALUES (?, ?, ?, ?, ?, ?, ?)";
				statement = connection.prepareStatement(dasStatement);
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
				statement = connection.prepareStatement(dasStatement);
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
				statement = connection.prepareStatement("SELECT * FROM ausleiher WHERE AKTIV = 1");
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
				statement = connection.prepareStatement("SELECT * FROM ausleiher");
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
				statement = connection.prepareStatement(dasStatement);
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

}
