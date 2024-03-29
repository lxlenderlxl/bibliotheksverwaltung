package bibliotheksverwaltung.model.daos.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import bibliotheksverwaltung.model.domain.Ausleiher;
import bibliotheksverwaltung.util.LocalEnvironment;
import bibliotheksverwaltung.util.Message;

public class MySQLAusleiherDAO implements AusleiherDAO
{	
	private Connection connection = LocalEnvironment.getConnection();
	private PreparedStatement statement = null;
	
	public MySQLAusleiherDAO()
	{

	}

	/* (non-Javadoc)
	 * @see bibliotheksverwaltung.model.daos.dao.AnwenderDAO#add(java.lang.String, int, boolean)
	 */
	@Override
	public void add(String derVorname, String derNachname, String dieStrasse, String dieHausnummer, String diePLZ, String dieStadt, boolean aktiv)
	{
		try
		{
			statement = connection.prepareStatement("INSERT INTO ausleiher (vorname, nachname, strasse, hausnummer, plz, stadt, aktiv) VALUES (?, ?, ?, ?, ?, ?, ?)");
			LocalEnvironment.statementChecker(statement, 1, derVorname);
			LocalEnvironment.statementChecker(statement, 2, derNachname);
			LocalEnvironment.statementChecker(statement, 3, dieStrasse);
			LocalEnvironment.statementChecker(statement, 4, dieHausnummer);
			LocalEnvironment.statementChecker(statement, 5, diePLZ);
			LocalEnvironment.statementChecker(statement, 6, dieStadt);
			statement.setBoolean(7, aktiv);
			statement.executeUpdate();
			Message.raise("Der Ausleiher wurde hinzugefuegt", 1);
		} catch (SQLException e)
		{
			LocalEnvironment.log(e.getMessage(), this);
		} finally
		{
			LocalEnvironment.closeStmt(statement);
		}
	}
	/* (non-Javadoc)
	 * @see bibliotheksverwaltung.model.daos.dao.AnwenderDAO#get()
	 */
	@Override
	public ArrayList<Ausleiher> get(boolean aktiv)
	{
		ArrayList<Ausleiher> liste = new ArrayList<Ausleiher>();;
		try
		{
			statement = connection.prepareStatement(
					"SELECT * FROM ausleiher WHERE aktiv = ?");
			statement.setBoolean(1, aktiv);
			ResultSet rs = statement.executeQuery();
			while (rs.next())
			{
				liste.add(new Ausleiher(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getBoolean(8)));
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
	 * @see bibliotheksverwaltung.model.daos.dao.AnwenderDAO#get(int)
	 */
	@Override
	public Ausleiher get(int dieId)
	{
		Ausleiher einAusleiher = null;
		try
		{
			statement = connection.prepareStatement(
					"SELECT * FROM ausleiher WHERE ausleiherID = ?");
			statement.setInt(1, dieId);
			ResultSet rs = statement.executeQuery();
			while (rs.next())
			{
				einAusleiher = new Ausleiher(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getBoolean(8));
			}
		} catch (SQLException e)
		{
			LocalEnvironment.log(e.getMessage(), this);
		} finally
		{
			LocalEnvironment.closeStmt(statement);
		}
		return einAusleiher;
	}

	/* (non-Javadoc)
	 * @see bibliotheksverwaltung.model.daos.dao.AnwenderDAO#update(int, java.lang.String, int, boolean)
	 */
	@Override
	public void update(int dieId, String derVorname, String derNachname, String dieStrasse, String dieHausnummer, String diePLZ, String dieStadt, boolean aktiv)
	{
		try
		{
			statement = connection.prepareStatement(
					"UPDATE ausleiher SET vorname = ?, nachname = ?, strasse = ?, hausnummer = ?, plz = ?, stadt = ?, aktiv = ? WHERE ausleiherID = ?");
			LocalEnvironment.statementChecker(statement, 1, derVorname);
			LocalEnvironment.statementChecker(statement, 2, derNachname);
			LocalEnvironment.statementChecker(statement, 3, dieStrasse);
			LocalEnvironment.statementChecker(statement, 4, dieHausnummer);
			LocalEnvironment.statementChecker(statement, 5, diePLZ);
			LocalEnvironment.statementChecker(statement, 6, dieStadt);
			statement.setBoolean(7, aktiv);
			LocalEnvironment.statementChecker(statement, 8, dieId);
			statement.executeUpdate();
			Message.raise("Der Ausleiher wurde erfolgreich bearbeitet", 1);
		} catch (SQLException e)
		{
			LocalEnvironment.log(e.getMessage(), this);
		} finally
		{
			LocalEnvironment.closeStmt(statement);
		}
	}
}
