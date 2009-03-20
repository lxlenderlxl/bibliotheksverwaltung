package bibliotheksverwaltung.model.daos.dao;

import java.sql.*;
import java.util.ArrayList;

import bibliotheksverwaltung.model.domain.Medium;
import bibliotheksverwaltung.util.LocalEnvironment;


public class MySQLMediumDAO implements MediumDAO
{
	private Connection connection = LocalEnvironment.getConnection();
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
			LocalEnvironment.statementChecker(statement, 1, derTitel);
			LocalEnvironment.statementChecker(statement, 2, derAutorVorname);
			LocalEnvironment.statementChecker(statement, 3, derAutorNachname);
			LocalEnvironment.statementChecker(statement, 4, derVerlag);
			LocalEnvironment.statementChecker(statement, 5, dasErscheinungsjahr);
			LocalEnvironment.statementChecker(statement, 6, dieISBN);
			statement.setBoolean(7, aktiv);
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
			LocalEnvironment.log(e.getMessage(), this);
		} finally
		{
			LocalEnvironment.closeStmt(statement);
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
			LocalEnvironment.statementChecker(statement, 1, dieId);
			ResultSet rs = statement.executeQuery();
			while (rs.next())
			{
				einMedium = new Medium(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getInt(6), rs.getString(7), rs.getBoolean(8));
			}
		} catch (SQLException e)
		{
			LocalEnvironment.log(e.getMessage(), this);
		} finally
		{
			LocalEnvironment.closeStmt(statement);
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
			LocalEnvironment.statementChecker(statement, 1, derTitel);
			LocalEnvironment.statementChecker(statement, 2, derAutorVorname);
			LocalEnvironment.statementChecker(statement, 3, derAutorNachname);
			LocalEnvironment.statementChecker(statement, 4, derVerlag);
			LocalEnvironment.statementChecker(statement, 5, dasErscheinungsjahr);
			LocalEnvironment.statementChecker(statement, 6, dieISBN);
			statement.setBoolean(7, aktiv);
			LocalEnvironment.statementChecker(statement, 8, dieId);
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
	 * @see bibliotheksverwaltung.model.daos.dao.MediumDAO#getAnzahlExemplare(int)
	 */
	@Override
	public int getAnzahlExemplare(int dieId)
	{
		int anzahl = 0;
		try
		{
			statement = connection.prepareStatement(
			"SELECT count(*) FROM exemplar WHERE medienid = ?");
			statement.setInt(1, dieId);

			ResultSet rs = statement.executeQuery();
			while (rs.next())
			{
				anzahl = rs.getInt(1);
			}
		} catch (SQLException e)
		{
			LocalEnvironment.log(e.getMessage(), this);
		} finally
		{
			LocalEnvironment.closeStmt(statement);
		}
		return anzahl;
	}

	/* (non-Javadoc)
	 * @see bibliotheksverwaltung.model.daos.dao.MediumDAO#getAnzahlAusleihbareExemplare(int)
	 */
	@Override
	public int getExemplareAusgeliehen(int dieId)
	{
		int anzahl = 0;
		try
		{
			statement = connection.prepareStatement(
			"SELECT count(*) FROM exemplar WHERE medienid = ? AND ausleiherid = ?");
			statement.setInt(1, dieId);
			statement.setNull(2, java.sql.Types.NULL);
			System.out.println(statement.toString());

			ResultSet rs = statement.executeQuery();
			while (rs.next())
			{
				anzahl = rs.getInt(1);
			}
		} catch (SQLException e)
		{
			LocalEnvironment.log(e.getMessage(), this);
		} finally
		{
			LocalEnvironment.closeStmt(statement);
		}
		return anzahl;
	}

	/* (non-Javadoc)
	 * @see bibliotheksverwaltung.model.daos.dao.MediumDAO#getExemplare(int)
	 */
	@Override
	public int[] getExemplare(int dieId)
	{
		int[] anzahl = null;
		try
		{
			statement = connection.prepareStatement(
			"SELECT exemplarid FROM exemplar WHERE medienid = ?");
			statement.setInt(1, dieId);

			ResultSet rs = statement.executeQuery();
			anzahl = new int[rs.getMetaData().getColumnCount()];
			for (int i = 0; i < anzahl.length; i++)
			{
				anzahl[i] = rs.getInt(1);
			}
			} catch (SQLException e)
			{
				LocalEnvironment.log(e.getMessage(), this);
			} finally
			{
				LocalEnvironment.closeStmt(statement);
			}
			return anzahl;
		}
}
