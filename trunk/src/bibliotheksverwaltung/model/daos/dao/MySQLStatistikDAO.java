/**
 *
 */
package bibliotheksverwaltung.model.daos.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import bibliotheksverwaltung.model.domain.Statistik;
import bibliotheksverwaltung.util.LocalEnvironment;

public class MySQLStatistikDAO implements StatistikDAO {

	private Connection connection = LocalEnvironment.getConnection();
	private PreparedStatement statement = null;



	/* (non-Javadoc)
	 * @see bibliotheksverwaltung.model.daos.dao.StatistikDAO#getStatistik()
	 */
	@Override
	public Statistik getStatistik() {
		return new Statistik(
				getEingetrageneBuecher(),
				getEingetragendeExemplare(),
				getEingetragenePersonen(),
				getVerliehenBuecher(),
				getLeihendePersonen(),
				getBisherigeAusleihen()
		);
	}

	private int executeSQL(String sqlCode) {
		try {
			statement = connection.prepareStatement(sqlCode);
			ResultSet rs = statement.executeQuery();

			if (rs.next())
				return rs.getInt(1);

		} catch (SQLException e) {
			LocalEnvironment.log(e.getMessage(), this);
		} finally {
			LocalEnvironment.closeStmt(statement);
		}
		return 0;
	}


	/**
	 * @return the eingetrageneBuecher
	 */
	private int getEingetrageneBuecher() {
		return executeSQL("select count(*) from medium");
	}


	/**
	 * @return the eingetragendeExemplare
	 */
	private int getEingetragendeExemplare() {
		return executeSQL("select count(*) from exemplar");
	}


	/**
	 * @return the eingetragenePersonen
	 */
	private int getEingetragenePersonen() {
		return executeSQL("select count(*) from ausleiher");
	}


	/**
	 * @return the verliehenBuecher
	 */
	private int getVerliehenBuecher() {
		return executeSQL("select count(*) from exemplar where AUSLEIHERID is not null");
	}


	/**
	 * @return the leihendePersonen
	 */
	private int getLeihendePersonen() {
		return executeSQL("select count(distinct AUSLEIHERID) from exemplar where AUSLEIHERID is not null");
	}


	/**
	 * @return the bisherigeAusleihen
	 */
	private int getBisherigeAusleihen() {
		return executeSQL("SELECT count(*) from log where VORGANGSID = 1");
	}
}
