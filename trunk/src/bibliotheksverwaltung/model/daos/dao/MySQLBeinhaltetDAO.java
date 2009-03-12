/**
 * 
 */
package bibliotheksverwaltung.model.daos.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import bibliotheksverwaltung.util.LocalEnvironment;
import bibliotheksverwaltung.util.LocalEnvironment;

public class MySQLBeinhaltetDAO implements BeinhaltetDAO
{
	private Connection connection = LocalEnvironment.getConnection();
	private PreparedStatement statement = null;
	
	public MySQLBeinhaltetDAO()
	{		
	}

	/* (non-Javadoc)
	 * @see bibliotheksverwaltung.model.daos.dao.BeinhaltetDAO#add(int, int)
	 */
	@Override
	public void add(int dieTagId, int dieMedienId)
	{
		try
		{
			statement = connection.prepareStatement("INSERT INTO beinhaltet (tagid, medienid) VALUES (?, ?)");
			statement.setInt(1, dieTagId);
			statement.setInt(2, dieMedienId);
			statement.executeUpdate();
		} catch (SQLException e)
		{
			LocalEnvironment.log(e.getMessage(), this);
		} finally
		{
			LocalEnvironment.closeStmt(statement);
		}
	}

	/* (non-Javadoc)
	 * @see bibliotheksverwaltung.model.daos.dao.BeinhaltetDAO#delete(int, int)
	 */
	@Override
	public void delete(int dieTagId, int dieMedienId)
	{
		try
		{
			statement = connection.prepareStatement("DELETE FROM beinhaltet WHERE tagid = ? AND medienID = ?");
			statement.setInt(1, dieTagId);
			statement.setInt(2, dieMedienId);
			statement.executeUpdate();
		} catch (SQLException e)
		{
			LocalEnvironment.log(e.getMessage(), this);
		} finally
		{
			LocalEnvironment.closeStmt(statement);
		}
	}

	/* (non-Javadoc)
	 * @see bibliotheksverwaltung.model.daos.dao.BeinhaltetDAO#get(int)
	 */
	@Override
	public ArrayList<Integer> get(int medienID)
	{
		ArrayList<Integer> liste = new ArrayList<Integer>();
		try
		{
			statement = connection.prepareStatement(
					"SELECT tagid FROM beinhaltet WHERE medienid = ?");
			statement.setInt(1, medienID);
			ResultSet rs = statement.executeQuery();
			while (rs.next())
			{
				liste.add(rs.getInt(1));
			}
		} catch (SQLException e)
		{
			LocalEnvironment.log(e.getMessage(), this);
		} finally
		{
			LocalEnvironment.closeStmt(statement);
		}
		return liste;
	}
}
