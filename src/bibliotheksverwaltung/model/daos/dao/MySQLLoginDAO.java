/**
 *
 */
package bibliotheksverwaltung.model.daos.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import bibliotheksverwaltung.util.LocalEnvironment;

public class MySQLLoginDAO implements LoginDAO {

	private Connection connection = LocalEnvironment.getConnection();
	private PreparedStatement statement = null;

	/* (non-Javadoc)
	 * @see bibliotheksverwaltung.model.daos.dao.LoginDAO#pruefeLogin(java.lang.String)
	 */
	@Override
	public boolean pruefeLogin(String name, String passwortHash) {
		try
		{
			statement = connection.prepareStatement(
			"select count(*) from anwender where ANWENDERNAME = ? and PASSWORT = ?");
			LocalEnvironment.statementChecker(statement, 1, name);
			LocalEnvironment.statementChecker(statement, 2, passwortHash);
			ResultSet rs = statement.executeQuery();

			if (rs.next())
				return rs.getInt(1) == 1;

		} catch (SQLException e) {
			LocalEnvironment.log(e.getMessage(), this);
		} finally {
			LocalEnvironment.closeStmt(statement);
		}
		return false;
	}

}
