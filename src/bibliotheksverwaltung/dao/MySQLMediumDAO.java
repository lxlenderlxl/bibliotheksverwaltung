package bibliotheksverwaltung.dao;

import java.sql.*;
import java.util.ArrayList;

import bibliotheksverwaltung.domain.Medium;
import bibliotheksverwaltung.exceptions.DataStoreException;


public class MySQLMediumDAO implements MediumDAO
{
	private Connection connection = null;
	private PreparedStatement statement = null;
	
	public MySQLMediumDAO () 
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

	public void add(Medium dasMedium)
	{
		if (connection != null)
		{
			try
			{
				String dasStatement = "INSERT INTO medium (titel, autorvorname, autornachname, verlag, erscheinungsjahr, isbn, aktiv) VALUES (?, ?, ?, ?, ?, ?, ?)";
				statement = connection.prepareStatement(dasStatement);
				statement.setString(1, dasMedium.getTitel());
				statement.setString(2, dasMedium.getAutorVorname());
				statement.setString(3, dasMedium.getAutorNachname());
				statement.setString(4, dasMedium.getVerlag());
				statement.setInt(5, dasMedium.getErscheinungsJahr());
				statement.setString(6, dasMedium.getIsbn());
				statement.setBoolean(7, dasMedium.isAktiv());
				statement.executeUpdate();
			}
			catch (SQLException e)
			{
				throw new DataStoreException(e);
			}
		}
	}

	public ArrayList<Medium> retrieve()
	{
		ArrayList<Medium> list = new ArrayList<Medium>();
		if (connection != null)
		{
			try
			{
				statement = connection.prepareStatement("SELECT * FROM medium WHERE AKTIV = 1");
				ResultSet rs = statement.executeQuery();
				while (rs.next())
				{
					Medium einMedium = new Medium(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getInt(6), rs.getString(7), rs.getBoolean(8));					
					list.add(einMedium);
				}
			}
			catch (SQLException e)
			{
				e.getMessage();
			}
		}		
		return list;
	}

	public void update(Medium dasMedium)
	{
		if (connection != null)
		{
			try
			{
				String dasStatement = "UPDATE medium SET titel = ?, autorvorname = ?, autornachname = ?, verlag = ?, erscheinungsjahr = ?, isbn = ?, aktiv = ? WHERE id = ?";
				statement = connection.prepareStatement(dasStatement);
				statement.setString(1, dasMedium.getTitel());
				statement.setString(2, dasMedium.getAutorVorname());
				statement.setString(3, dasMedium.getAutorNachname());
				statement.setString(4, dasMedium.getVerlag());
				statement.setInt(5, dasMedium.getErscheinungsJahr());
				statement.setString(6, dasMedium.getIsbn());
				statement.setBoolean(7, dasMedium.isAktiv());
				statement.setInt(8, dasMedium.getId());
				statement.executeUpdate();
			}
			catch (SQLException e)
			{
				throw new DataStoreException(e);
			}
		}		
	}

	public ArrayList<Medium> find(Medium dasMedium)
	{
		ArrayList<Medium> list = new ArrayList<Medium>();
		if (connection != null)
		{
			try
			{
				String dasStatement = "SELECT * FROM medium WHERE autorvorname LIKE ? AND autornachname LIKE ? AND isbn LIKE ? AND titel LIKE ? AND verlag LIKE ? AND AKTIV = ?";
				if (dasMedium.getErscheinungsJahr() != 0)
				{
					dasStatement += " AND erscheinungsjahr = " + new Integer(dasMedium.getErscheinungsJahr()).toString();
				}
				statement = connection.prepareStatement(dasStatement);
				statement.setString(1, stringLikeTransformator(dasMedium.getAutorVorname()));
				statement.setString(2, stringLikeTransformator(dasMedium.getAutorNachname()));
				statement.setString(3, stringLikeTransformator(dasMedium.getIsbn()));
				statement.setString(4, stringLikeTransformator(dasMedium.getTitel()));
				statement.setString(5, stringLikeTransformator(dasMedium.getVerlag()));
				statement.setBoolean(6, dasMedium.isAktiv());
				ResultSet rs = statement.executeQuery();
				while (rs.next())
				{
					Medium einMedium = new Medium(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getInt(6), rs.getString(7), rs.getBoolean(8));					
					list.add(einMedium);
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

	public void delete(Medium dasMedium)
	{
		if (connection != null)
		{
			try
			{
				String dasStatement = "UPDATE medium SET AKTIV = 0 WHERE id = ?";
				statement = connection.prepareStatement(dasStatement);
				statement.setInt(1, dasMedium.getId());
				statement.executeUpdate();
			}
			catch (SQLException e)
			{
				throw new DataStoreException(e);
			}
		}
	}

	public ArrayList<Medium> retrieveAll()
	{
		ArrayList<Medium> list = new ArrayList<Medium>();
		if (connection != null)
		{
			try
			{
				statement = connection.prepareStatement("SELECT * FROM medium");
				ResultSet rs = statement.executeQuery();
				while (rs.next())
				{
					Medium einMedium = new Medium(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getInt(6), rs.getString(7), rs.getBoolean(8));				
					list.add(einMedium);
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
	public void unDelete(Medium dasMedium)
	{
		if (connection != null)
		{
			try
			{
				String dasStatement = "UPDATE medium SET AKTIV = 1 WHERE id = ?";
				statement = connection.prepareStatement(dasStatement);
				statement.setInt(1, dasMedium.getId());
				statement.executeUpdate();
			}
			catch (SQLException e)
			{
				throw new DataStoreException(e);
			}
		}
	}	
}
