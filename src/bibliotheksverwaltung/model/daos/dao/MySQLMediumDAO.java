package bibliotheksverwaltung.model.daos.dao;

import java.sql.*;
import java.util.ArrayList;

import bibliotheksverwaltung.model.daos.exceptions.DataStoreException;
import bibliotheksverwaltung.model.domain.Medium;
import bibliotheksverwaltung.util.MySQLConnection;


public class MySQLMediumDAO implements MediumDAO
{
	private MySQLConnection connection = null;
	private PreparedStatement statement = null;
	
	public MySQLMediumDAO()
	{
		connection = new MySQLConnection();
		refreshConnection();
	}

	public MySQLMediumDAO(MySQLConnection dieConnection)
	{
		connection = dieConnection;
		refreshConnection();
	}

	public void add(Medium dasMedium)
	{
		refreshConnection();
		try
		{
			String dasStatement = "INSERT INTO medium (titel, autorvorname, autornachname, verlag, erscheinungsjahr, isbn, aktiv) VALUES (?, ?, ?, ?, ?, ?, ?)";
			statement = connection.getConnection().prepareStatement(dasStatement);
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

	public ArrayList<Medium> retrieve()
	{
		ArrayList<Medium> list = new ArrayList<Medium>();
		if (connection.getConnection() != null)
		{
			try
			{
				statement = connection.getConnection().prepareStatement("SELECT * FROM medium WHERE AKTIV = 1");
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
		if (connection.getConnection() != null)
		{
			try
			{
				String dasStatement = "UPDATE medium SET titel = ?, autorvorname = ?, autornachname = ?, verlag = ?, erscheinungsjahr = ?, isbn = ?, aktiv = ? WHERE id = ?";
				statement = connection.getConnection().prepareStatement(dasStatement);
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
		if (connection.getConnection() != null)
		{
			try
			{
				String dasStatement = "SELECT * FROM medium WHERE autorvorname LIKE ? AND autornachname LIKE ? AND isbn LIKE ? AND titel LIKE ? AND verlag LIKE ? AND AKTIV = ?";
				if (dasMedium.getErscheinungsJahr() != 0)
				{
					dasStatement += " AND erscheinungsjahr = " + new Integer(dasMedium.getErscheinungsJahr()).toString();
				}
				statement = connection.getConnection().prepareStatement(dasStatement);
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

	public void deactivate(Medium dasMedium)
	{
		if (connection.getConnection() != null)
		{
			try
			{
				String dasStatement = "UPDATE medium SET AKTIV = 0 WHERE id = ?";
				statement = connection.getConnection().prepareStatement(dasStatement);
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
		if (connection.getConnection() != null)
		{
			try
			{
				statement = connection.getConnection().prepareStatement("SELECT * FROM medium");
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
	public void activate(Medium dasMedium)
	{
		if (connection.getConnection() != null)
		{
			try
			{
				String dasStatement = "UPDATE medium SET AKTIV = 1 WHERE id = ?";
				statement = connection.getConnection().prepareStatement(dasStatement);
				statement.setInt(1, dasMedium.getId());
				statement.executeUpdate();
			}
			catch (SQLException e)
			{
				throw new DataStoreException(e);
			}
		}
	}

	/* (non-Javadoc)
	 * @see bibliotheksverwaltung.model.daos.dao.MediumDAO#findById(int)
	 */
	@Override
	public Medium findById(int dieId)
	{
		Medium einMedium = null;
		if (connection.getConnection() != null)
		{
			try
			{
				statement = connection.getConnection().prepareStatement("SELECT * FROM medium WHERE id = ?");
				statement.setInt(1, dieId);
				ResultSet rs = statement.executeQuery();
				while (rs.next())
				{
					einMedium = new Medium(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getInt(6), rs.getString(7), rs.getBoolean(8));				
				}
			}
			catch (SQLException e)
			{
				e.getMessage();
			}
		}
		
		return einMedium;
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
}
