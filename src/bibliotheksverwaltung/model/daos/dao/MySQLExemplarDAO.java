/**
 * 
 */
package bibliotheksverwaltung.model.daos.dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

import bibliotheksverwaltung.model.domain.Exemplar;
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
	public void add(String derName, String dasPasswort, int dieHierarchieStufe,
			boolean aktiv)
	{
		this.refreshConnection();
		try
		{
			statement = connection.getConnection().prepareStatement("INSERT INTO Exemplar (titel, autorvorname, autornachname, verlag, erscheinungsjahr, isbn, aktiv) VALUES (?, ?, ?, ?, ?, ?, ?)");
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
	 * @see bibliotheksverwaltung.model.daos.dao.ExemplarDAO#get(boolean)
	 */
	@Override
	public ArrayList<Exemplar> get(boolean aktiv)
	{
		// TODO Auto-generated method stub
		return null;
	}
	/* (non-Javadoc)
	 * @see bibliotheksverwaltung.model.daos.dao.ExemplarDAO#get(int)
	 */
	@Override
	public Exemplar get(int dieId)
	{
		// TODO Auto-generated method stub
		return null;
	}
	/* (non-Javadoc)
	 * @see bibliotheksverwaltung.model.daos.dao.ExemplarDAO#update(int, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, boolean)
	 */
	@Override
	public void update(int dieId, String derVorname, String derNachname,
			String dieStrasse, String dieHausnummer, String diePLZ, String dieStadt,
			boolean aktiv)
	{
		// TODO Auto-generated method stub
		
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
