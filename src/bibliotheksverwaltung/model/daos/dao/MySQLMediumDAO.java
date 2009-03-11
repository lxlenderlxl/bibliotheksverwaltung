package bibliotheksverwaltung.model.daos.dao;

import java.sql.*;
import java.util.ArrayList;

import bibliotheksverwaltung.model.domain.Medium;
import bibliotheksverwaltung.util.LocalLog;
import bibliotheksverwaltung.util.MySQLConnection;


public class MySQLMediumDAO implements MediumDAO
{
	private Connection connection = MySQLConnection.getConnection();
	private PreparedStatement statement = null;
	
	public MySQLMediumDAO()
	{		
	}

	/* (non-Javadoc)
	 * @see bibliotheksverwaltung.model.daos.dao.MediumDAO#add(java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, boolean)
	 */
	@Override
	public void add(String derTitel, String derAutorVorname,
			String derAutorNachname, String derVerlag, String dasErscheinungsjahr,
			String dieISBN, boolean aktiv)
	{
		try
		{
			statement = connection.prepareStatement("INSERT INTO medium (titel, autorvorname, autornachname, verlag, erscheinungsjahr, isbn, aktiv) VALUES (?, ?, ?, ?, ?, ?, ?)");
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
			LocalLog.add(e.getMessage(), this);
		} finally
		{
			MySQLConnection.closeStmt(statement);
		}
	}

	/* (non-Javadoc)
	 * @see bibliotheksverwaltung.model.daos.dao.MediumDAO#get()
	 */
	@Override
	public ArrayList<Medium> get(boolean aktiv)
	{
		ArrayList<Medium> liste = new ArrayList<Medium>();
		try
		{
			statement = connection.prepareStatement(
					"SELECT * FROM medium WHERE aktiv = ?");
			statement.setBoolean(1, aktiv);
			ResultSet rs = statement.executeQuery();
			while (rs.next())
			{
				liste.add(new Medium(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getInt(6), rs.getString(7), rs.getBoolean(8)));
			}
		} catch (SQLException e)
		{
			LocalLog.add(e.getMessage(), this);
		} finally
		{
			MySQLConnection.closeStmt(statement);
		}
		return liste;
	}

	/* (non-Javadoc)
	 * @see bibliotheksverwaltung.model.daos.dao.MediumDAO#get(int)
	 */
	@Override
	public Medium get(int dieId)
	{
		Medium einMedium = null;
		try
		{
			statement = connection.prepareStatement(
					"SELECT * FROM medium WHERE medienid = ?");
			statement.setInt(1, dieId);
			ResultSet rs = statement.executeQuery();
			while (rs.next())
			{
				einMedium = new Medium(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getInt(6), rs.getString(7), rs.getBoolean(8));
			}
		} catch (SQLException e)
		{
			LocalLog.add(e.getMessage(), this);
		} finally
		{
			MySQLConnection.closeStmt(statement);
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
		try
		{
			statement = connection.prepareStatement(
					"UPDATE medium SET titel = ?, autorvorname = ?, autornachname = ?, verlag = ?, erscheinungsjahr = ?, isbn = ?, aktiv = ? WHERE medienid = ?");
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
			LocalLog.add(e.getMessage(), this);
		} finally
		{
			MySQLConnection.closeStmt(statement);
		}
	}
}
