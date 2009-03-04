package bibliotheksverwaltung.model.daos.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import bibliotheksverwaltung.model.domain.Exemplar;
import bibliotheksverwaltung.model.domain.Zustand;
import bibliotheksverwaltung.util.MySQLConnection;

/**
 * @author Sven Blaurock 03.03.2009 00:27:23
 *
 */
public class MySQLZustandDAO implements ZustandDAO
{
	private MySQLConnection connection = null;
	private PreparedStatement statement = null;

	public MySQLZustandDAO()
	{
		connection = new MySQLConnection();
		refreshConnection();
	}

	public MySQLZustandDAO(MySQLConnection dieConnection)
	{
		connection = dieConnection;
		refreshConnection();
	}

	/* (non-Javadoc)
	 * @see bibliotheksverwaltung.model.daos.dao.ZustandDAO#add(bibliotheksverwaltung.model.domain.Zustand)
	 */
	@Override
	public void add(String dieBezeichnung)
	{
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see bibliotheksverwaltung.model.daos.dao.ZustandDAO#findById(int)
	 */
	@Override
	public Zustand getById(int dieId)
	{
		Zustand einZustand = null;
		if (connection.getConnection() == null)
		{

			try
			{
				statement = connection.getConnection().prepareStatement("SELECT * FROM zustand WHERE id = ?");
				statement.setInt(1, dieId);
				ResultSet rs = statement.executeQuery();
				while (rs.next())
				{
					einZustand = new Zustand(rs.getInt(1), rs.getString(2));
				}
			}
			catch (SQLException e)
			{
				e.getMessage();
			}
		}

		return einZustand;
	}

	/* (non-Javadoc)
	 * @see bibliotheksverwaltung.model.daos.dao.ZustandDAO#retrieve()
	 */
	@Override
	public ArrayList<Zustand> getAll()
	{
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see bibliotheksverwaltung.model.daos.dao.ZustandDAO#update(bibliotheksverwaltung.model.domain.Zustand)
	 */
	@Override
	public void update(int dieId, String dieBezeichnung)
	{
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see bibliotheksverwaltung.model.daos.dao.ZustandDAO#getByBezeichnung(java.lang.String)
	 */
	@Override
	public Zustand getByBezeichnung(String dieBezeichnung)
	{
		// TODO Auto-generated method stub
		return null;
	}

	private void refreshConnection()
	{
		if (connection.getConnection() != null)
			connection = new MySQLConnection();
	}



}
