package bibliotheksverwaltung.model.daos.dao;

import java.sql.*;
import java.util.ArrayList;

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

	/* (non-Javadoc)
	 * @see bibliotheksverwaltung.model.daos.dao.MediumDAO#add(java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, boolean)
	 */
	@Override
	public void add(String derTitel, String derAutorVorname,
			String derAutorNachname, String derVerlag, String dasErscheinungsjahr,
			String dieISBN, boolean aktiv)
	{
		this.refreshConnection();
		try
		{
			statement = connection.getConnection().prepareStatement("INSERT INTO medium (titel, autorvorname, autornachname, verlag, erscheinungsjahr, isbn, aktiv) VALUES (?, ?, ?, ?, ?, ?, ?)");
			statement.setString(1, derTitel);
			statement.setString(2, derAutorVorname);
			statement.setString(3, derAutorNachname);
			statement.setString(4, derVerlag);
			statement.setString(5, dasErscheinungsjahr);
			statement.setString(6, dieISBN);
			statement.setBoolean(7, aktiv);
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
	 * @see bibliotheksverwaltung.model.daos.dao.MediumDAO#get()
	 */
	@Override
	public ArrayList<Medium> get(boolean aktiv)
	{
		this.refreshConnection();
		ArrayList<Medium> liste = new ArrayList<Medium>();
		try
		{
			statement = connection.getConnection().prepareStatement(
					"SELECT * FROM medium WHERE aktiv = ?");
			statement.setBoolean(1, aktiv);
			ResultSet rs = statement.executeQuery();
			while (rs.next())
			{
				liste.add(new Medium(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getInt(6), rs.getString(7), rs.getBoolean(8)));
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
	 * @see bibliotheksverwaltung.model.daos.dao.MediumDAO#get(int)
	 */
	@Override
	public Medium get(int dieId)
	{
		this.refreshConnection();
		Medium einMedium = null;
		try
		{
			statement = connection.getConnection().prepareStatement(
					"SELECT * FROM medium WHERE mediumid = ?");
			statement.setInt(1, dieId);
			ResultSet rs = statement.executeQuery();
			while (rs.next())
			{
				einMedium = new Medium(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getInt(6), rs.getString(7), rs.getBoolean(8));
			}
		} catch (SQLException e)
		{
			e.getMessage();
		} finally
		{
			closeStmt();
		}
		return einMedium;
	}

	/* (non-Javadoc)
	 * @see bibliotheksverwaltung.model.daos.dao.MediumDAO#update(int, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, boolean)
	 */
	@Override
	public void update(int dieId, String derTitel, String derAutorVorname,
			String derAutorNachname, String derVerlag, String dasErscheinungsjahr,
			String dieISBN, boolean aktiv)
	{
		this.refreshConnection();
		try
		{
			statement = connection.getConnection().prepareStatement(
					"UPDATE medium SET titel = ?, autorvorname = ?, autornachname = ?, verlag = ?, erscheinungsjahr = ?, isbn = ?, aktiv = ? WHERE mediumid = ?");
			statement.setString(1, derTitel);
			statement.setString(2, derAutorVorname);
			statement.setString(3, derAutorNachname);
			statement.setString(4, derVerlag);
			statement.setString(5, dasErscheinungsjahr);
			statement.setString(6, dieISBN);
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
