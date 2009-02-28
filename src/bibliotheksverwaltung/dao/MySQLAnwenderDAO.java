package bibliotheksverwaltung.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import bibliotheksverwaltung.domain.Anwender;
import bibliotheksverwaltung.exceptions.DataStoreException;


public class MySQLAnwenderDAO implements AnwenderDAO
{
	private Connection connection = null;
	private PreparedStatement statement = null;
	
	public MySQLAnwenderDAO () 
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

	public ArrayList<Anwender> retrieve()
	{
		ArrayList<Anwender> list = new ArrayList<Anwender>();
		if (connection != null)
		{
			try
			{
				statement = connection.prepareStatement("SELECT * FROM anwender WHERE AKTIV = 1");
				ResultSet rs = statement.executeQuery();
				while (rs.next())
				{
					Anwender einAnwender = new Anwender(rs.getString(1), rs.getString(2), rs.getInt(3), rs.getBoolean(4));					
					list.add(einAnwender);
				}
			}
			catch (SQLException e)
			{
				e.getMessage();
			}
		}		
		return list;
	}

	public void update(Anwender derAnwender)
	{
		if (connection != null)
		{
			try
			{
				String dasStatement = "UPDATE anwender SET anwendername = ?, passwort = ?, hierarchiestufe = ?, aktiv = ? WHERE id = ?";
				statement = connection.prepareStatement(dasStatement);
				statement.setString(1, derAnwender.getAnwenderName());
				statement.setString(2, derAnwender.getPasswort());
				statement.setInt(3, derAnwender.getHierarchieStufe());
				statement.setBoolean(4, derAnwender.isAktiv());
				statement.executeUpdate();
			}
			catch (SQLException e)
			{
				throw new DataStoreException(e);
			}
		}		
	}

	public ArrayList<Anwender> find(Anwender derAnwender)
	{
		ArrayList<Anwender> list = new ArrayList<Anwender>();
		if (connection != null)
		{
			try
			{
				String dasStatement = "SELECT * FROM anwender WHERE anwendername LIKE ? AND hierarchiestufe LIKE ? AND aktiv = ?";
				statement = connection.prepareStatement(dasStatement);
				statement.setString(1, stringLikeTransformator(derAnwender.getAnwenderName()));
				statement.setInt(2, derAnwender.getHierarchieStufe());
				statement.setBoolean(3, derAnwender.isAktiv());
				ResultSet rs = statement.executeQuery();
				while (rs.next())
				{
					Anwender einAnwender = new Anwender(rs.getString(1), rs.getString(2), rs.getInt(3), rs.getBoolean(4));					
					list.add(einAnwender);
				}
			}
			catch (SQLException e)
			{
				e.getMessage();
			}
		}
		return list;
	}
	
	private String stringLikeTransformator(String derString)
	{
		return "%" + derString + "%";
	}

	public void delete(Anwender derAnwender)
	{
		if (connection != null)
		{
			try
			{
				String dasStatement = "UPDATE anwender SET AKTIV = 0 WHERE anwendername = ?";
				statement = connection.prepareStatement(dasStatement);
				statement.setString(1, derAnwender.getAnwenderName());
				statement.executeUpdate();
			}
			catch (SQLException e)
			{
				throw new DataStoreException(e);
			}
		}
	}

	public ArrayList<Anwender> retrieveAll()
	{
		ArrayList<Anwender> list = new ArrayList<Anwender>();
		if (connection != null)
		{
			try
			{
				statement = connection.prepareStatement("SELECT * FROM anwender");
				ResultSet rs = statement.executeQuery();
				while (rs.next())
				{
					Anwender einAnwender = new Anwender(rs.getString(1), rs.getString(2), rs.getInt(3), rs.getBoolean(4));					
					list.add(einAnwender);
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
	public void add(Anwender derAnwender)
	{
		if (connection != null)
		{
			try
			{
				String dasStatement = "INSERT INTO anwender (anwendername, passwort, hierarchiestufe, aktiv) VALUES (?, ?, ?, ?)";
				statement = connection.prepareStatement(dasStatement);
				statement.setString(1, derAnwender.getAnwenderName());
				statement.setString(2, derAnwender.getPasswort());
				statement.setInt(3, derAnwender.getHierarchieStufe());
				statement.setBoolean(4, derAnwender.isAktiv());
				statement.executeUpdate();
			}
			catch (SQLException e)
			{
				throw new DataStoreException(e);
			}
		}
	}

	@Override
	public void unDelete(Anwender derAnwender)
	{
		if (connection != null)
		{
			try
			{
				String dasStatement = "UPDATE anwender SET AKTIV = 1 WHERE anwendername = ?";
				statement = connection.prepareStatement(dasStatement);
				statement.setString(1, derAnwender.getAnwenderName());
				statement.executeUpdate();
			}
			catch (SQLException e)
			{
				throw new DataStoreException(e);
			}
		}		
	}
}
