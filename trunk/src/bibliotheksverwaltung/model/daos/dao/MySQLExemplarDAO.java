/**
 * 
 */
package bibliotheksverwaltung.model.daos.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import bibliotheksverwaltung.model.daos.exceptions.DataStoreException;
import bibliotheksverwaltung.model.domain.Ausleiher;
import bibliotheksverwaltung.model.domain.Exemplar;
import bibliotheksverwaltung.model.domain.Medium;
import bibliotheksverwaltung.model.domain.Zustand;
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
	}
	
	public MySQLExemplarDAO(MySQLConnection dieConnection) 
	{
		connection = dieConnection;
	}

	/* (non-Javadoc)
	 * @see bibliotheksverwaltung.model.daos.dao.ExemplarDAO#activate(bibliotheksverwaltung.model.domain.Exemplar)
	 */
	@Override
	public void activate(Exemplar dasExemplar)
	{
		if (connection.getConnection() != null)
		{
			try
			{
				String dasStatement = "UPDATE exemplar SET AKTIV = 1 WHERE id = ?";
				statement = connection.getConnection().prepareStatement(dasStatement);
				statement.setInt(1, dasExemplar.getId());
				statement.executeUpdate();
			}
			catch (SQLException e)
			{
				throw new DataStoreException(e);
			}
		}
	}

	/* (non-Javadoc)
	 * @see bibliotheksverwaltung.model.daos.dao.ExemplarDAO#add(bibliotheksverwaltung.model.domain.Exemplar)
	 */
	@Override
	public void add(Exemplar dasExemplar)
	{
		if (connection.getConnection() != null)
		{
			try
			{
				String dasStatement = "INSERT INTO Exemplar (zustandsid, benutzerid, medienid, rueckgabedatum, verlaengerung, aktiv) VALUES (?, ?, ?, ?, ?, ?)";
				statement = connection.getConnection().prepareStatement(dasStatement);
				statement.setInt(1, dasExemplar.getZustand().getId());
				statement.setInt(2, dasExemplar.getAusleiher().getId());
				statement.setInt(3, dasExemplar.getMedium().getId());
				statement.setDate(4, dasExemplar.getRueckgabeDatum());
				statement.setInt(5, dasExemplar.getVerlaengerung());
				statement.setBoolean(6, dasExemplar.isAktiv());
				statement.executeUpdate();
			}
			catch (SQLException e)
			{
				throw new DataStoreException(e);
			}
		}
	}

	/* (non-Javadoc)
	 * @see bibliotheksverwaltung.model.daos.dao.ExemplarDAO#deactivate(bibliotheksverwaltung.model.domain.Exemplar)
	 */
	@Override
	public void deactivate(Exemplar dasExemplar)
	{
		if (connection.getConnection() != null)
		{
			try
			{
				String dasStatement = "UPDATE exemplar SET AKTIV = 0 WHERE id = ?";
				statement = connection.getConnection().prepareStatement(dasStatement);
				statement.setInt(1, dasExemplar.getId());
				statement.executeUpdate();
			}
			catch (SQLException e)
			{
				throw new DataStoreException(e);
			}
		}
	}

	/* (non-Javadoc)
	 * @see bibliotheksverwaltung.model.daos.dao.ExemplarDAO#findByAusleiher(bibliotheksverwaltung.model.domain.Ausleiher)
	 */
	@Override
	public ArrayList<Exemplar> findByAusleiher(Ausleiher derAusleiher)
	{
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see bibliotheksverwaltung.model.daos.dao.ExemplarDAO#findByDatum(java.sql.Date)
	 */
	@Override
	public ArrayList<Exemplar> findByDatum(Date dasDatum)
	{
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see bibliotheksverwaltung.model.daos.dao.ExemplarDAO#findById(int)
	 */
	@Override
	public Exemplar findById(int dieId)
	{
		Exemplar einExemplar = null;
		if (connection.getConnection() != null)
		{
			try
			{
				statement = connection.getConnection().prepareStatement("SELECT * FROM exemplar WHERE id = ?");
				statement.setInt(1, dieId);
				ResultSet rs = statement.executeQuery();
				while (rs.next())
				{
					einExemplar = new Exemplar(rs.getInt(1), new MySQLZustandDAO(connection).findById(rs.getInt(2)), new MySQLAusleiherDAO(connection).findById(rs.getInt(3)), new MySQLMediumDAO(connection).findById(rs.getInt(4)), rs.getDate(5), rs.getInt(6), rs.getBoolean(7));				
				}
			}
			catch (SQLException e)
			{
				e.getMessage();
			}
		}
		
		if (einExemplar == null)
			throw new DataStoreException();
		
		return einExemplar;
	}

	/* (non-Javadoc)
	 * @see bibliotheksverwaltung.model.daos.dao.ExemplarDAO#findByMedium(bibliotheksverwaltung.model.domain.Medium)
	 */
	@Override
	public ArrayList<Exemplar> findByMedium(Medium dasMedium)
	{
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see bibliotheksverwaltung.model.daos.dao.ExemplarDAO#findByZustand(bibliotheksverwaltung.model.domain.Zustand)
	 */
	@Override
	public ArrayList<Exemplar> findByZustand(Zustand derZustand)
	{
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see bibliotheksverwaltung.model.daos.dao.ExemplarDAO#retrieve()
	 */
	@Override
	public ArrayList<Exemplar> retrieve()
	{
		ArrayList<Exemplar> list = new ArrayList<Exemplar>();
		if (connection.getConnection() != null)
		{
			try
			{
				statement = connection.getConnection().prepareStatement("SELECT * FROM exemplar WHERE AKTIV = 1");
				ResultSet rs = statement.executeQuery();
				while (rs.next())
				{
					Exemplar einExemplar = new Exemplar(rs.getInt(1), new MySQLZustandDAO(connection).findById(rs.getInt(2)), new MySQLAusleiherDAO(connection).findById(rs.getInt(3)), new MySQLMediumDAO(connection).findById(rs.getInt(4)), rs.getDate(5), rs.getInt(6), rs.getBoolean(7));				
					list.add(einExemplar);
				}
			}
			catch (SQLException e)
			{
				e.getMessage();
			}
		}		
		return list;
	}
	
	/* (non-Javadoc)
	 * @see bibliotheksverwaltung.model.daos.dao.ExemplarDAO#retrieve()
	 */
	@Override
	public ArrayList<Exemplar> retrieveView()
	{
		ArrayList<Exemplar> list = new ArrayList<Exemplar>();
		if (connection.getConnection() != null)
		{
			try
			{
				statement = connection.getConnection().prepareStatement("SELECT * FROM exemplar_retrieve WHERE EXEMPLAR_AKTIV = 1");
				ResultSet rs = statement.executeQuery();
				while (rs.next())
				{
					Exemplar einExemplar = new Exemplar(rs.getInt(1), new Zustand(rs.getInt(2), rs.getString(3)), new Ausleiher(rs.getInt(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getInt(9), rs.getString(10), rs.getBoolean(11)), new Medium(), rs.getDate(5), rs.getInt(6), rs.getBoolean(7));				
					list.add(einExemplar);
				}
			}
			catch (SQLException e)
			{
				e.getMessage();
			}
		}		
		return list;
	}

	/* (non-Javadoc)
	 * @see bibliotheksverwaltung.model.daos.dao.ExemplarDAO#retrieveOverDue()
	 */
	@Override
	public ArrayList<Exemplar> retrieveOverDue()
	{
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see bibliotheksverwaltung.model.daos.dao.ExemplarDAO#update(bibliotheksverwaltung.model.domain.Exemplar)
	 */
	@Override
	public void update(Exemplar dasExemplar)
	{
		// TODO Auto-generated method stub
		
	}

	/* (non-Javadoc)
	 * @see bibliotheksverwaltung.model.daos.dao.ExemplarDAO#isBorrowed(bibliotheksverwaltung.model.domain.Exemplar)
	 */
	@Override
	public boolean isBorrowed(Exemplar dasExemplar)
	{
		// TODO Auto-generated method stub
		return false;
	}

}
