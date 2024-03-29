/**
 *
 */
package bibliotheksverwaltung.model.daos.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import bibliotheksverwaltung.model.domain.Exemplar;
import bibliotheksverwaltung.util.LocalEnvironment;

/**
 * @author Sven Blaurock 28.02.2009 18:28:58
 * 
 */
public class MySQLExemplarDAO implements ExemplarDAO {
	private Connection connection = LocalEnvironment.getConnection();
	private PreparedStatement statement = null;

	public MySQLExemplarDAO() {
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see bibliotheksverwaltung.model.daos.dao.ExemplarDAO#add(java.lang.String,
	 * java.lang.String, int, boolean)
	 */
	@Override
	public void add(int zustandsid, int ausleiherID, int medienid,
			Date rueckgabedatum, int verlaengerung, boolean aktiv) {
		try {
			statement = connection
					.prepareStatement("INSERT INTO exemplar (zustandsid, ausleiherID, medienid, rueckgabedatum, verlaengerung, aktiv) VALUES (?, ?, ?, ?, ?, ?)");
			LocalEnvironment.statementChecker(statement, 1, zustandsid);
			LocalEnvironment.statementChecker(statement, 2, ausleiherID);
			LocalEnvironment.statementChecker(statement, 3, medienid);
			LocalEnvironment.statementChecker(statement, 4, rueckgabedatum);
			LocalEnvironment.statementChecker(statement, 5, verlaengerung);
			statement.setBoolean(6, aktiv);
			statement.executeUpdate();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			LocalEnvironment.log(e.getMessage(), this);
		} finally {
			LocalEnvironment.closeStmt(statement);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see bibliotheksverwaltung.model.daos.dao.ExemplarDAO#get(boolean)
	 */
	@Override
	public ArrayList<Exemplar> get(boolean aktiv) {
		ArrayList<Exemplar> liste = new ArrayList<Exemplar>();
		try {
			statement = connection
					.prepareStatement("SELECT * FROM exemplar WHERE aktiv = ?");
			statement.setBoolean(1, aktiv);
			ResultSet rs = statement.executeQuery();
			while (rs.next()) {
				liste.add(new Exemplar(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs
						.getInt(4), rs.getDate(5), rs.getInt(6), rs.getBoolean(7)));
			}
		} catch (SQLException e) {
			LocalEnvironment.log(e.getMessage(), this);
		} finally {
			LocalEnvironment.closeStmt(statement);
		}
		return liste;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see bibliotheksverwaltung.model.daos.dao.ExemplarDAO#get(int)
	 */
	@Override
	public Exemplar get(int dieId) {
		Exemplar einExemplar = null;
		try {
			statement = connection
					.prepareStatement("SELECT * FROM exemplar WHERE exemplarid = ?");
			statement.setInt(1, dieId);
			ResultSet rs = statement.executeQuery();
			while (rs.next()) {
				einExemplar = new Exemplar(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs
						.getInt(4), rs.getDate(5), rs.getInt(6), rs.getBoolean(7));
			}
		} catch (SQLException e) {
			LocalEnvironment.log(e.getMessage(), this);
		} finally {
			LocalEnvironment.closeStmt(statement);
		}
		return einExemplar;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see bibliotheksverwaltung.model.daos.dao.ExemplarDAO#update(int,
	 * java.lang.String, java.lang.String, java.lang.String, java.lang.String,
	 * java.lang.String, java.lang.String, boolean)
	 */
	@Override
	public void update(int dieId, int zustandsid, int ausleiherID, int medienid,
			Date rueckgabedatum, int verlaengerung, boolean aktiv) {
		try {
			statement = connection
					.prepareStatement("UPDATE exemplar SET zustandsid = ?, ausleiherID = ?, medienid = ?, rueckgabedatum = ?, verlaengerung = ?, aktiv = ? WHERE exemplarid = ?");
			LocalEnvironment.statementChecker(statement, 1, zustandsid);
			LocalEnvironment.statementChecker(statement, 2, ausleiherID);
			LocalEnvironment.statementChecker(statement, 3, medienid);
			LocalEnvironment.statementChecker(statement, 4, rueckgabedatum);
			LocalEnvironment.statementChecker(statement, 5, verlaengerung);
			statement.setBoolean(6, aktiv);
			LocalEnvironment.statementChecker(statement, 7, dieId);
			statement.executeUpdate();
		} catch (SQLException e) {
			LocalEnvironment.log(e.getMessage(), this);
		} finally {
			LocalEnvironment.closeStmt(statement);
		}
	}

	public ArrayList<Exemplar> getExemplareByAusleiher(int ausleiherId) {
		ArrayList<Exemplar> liste = new ArrayList<Exemplar>();
		try {
			statement = connection
					.prepareStatement("SELECT * FROM exemplar WHERE ausleiherid = ?");
			LocalEnvironment.statementChecker(statement, 1, ausleiherId);
			ResultSet rs = statement.executeQuery();
			while (rs.next()) {
				liste.add(new Exemplar(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs
						.getInt(4), rs.getDate(5), rs.getInt(6), rs.getBoolean(7)));
			}
		} catch (SQLException e) {
			LocalEnvironment.log(e.getMessage(), this);
		} finally {
			LocalEnvironment.closeStmt(statement);
		}
		return liste;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see bibliotheksverwaltung.model.daos.dao.ExemplarDAO#fehlt()
	 */
	@Override
	public List<Exemplar> fehlt(int ausleiherID) {
		List<Exemplar> ret = new ArrayList<Exemplar>();
		
		StringBuffer sb = new StringBuffer();
		sb.append("select exemplarid\n");
		sb.append("from exemplar\n");
		sb.append("where rueckgabedatum < ?\n");
		sb.append("	and ausleiherid = ?\n");

		try {
			statement = connection.prepareStatement(sb.toString());
			LocalEnvironment.statementChecker(statement, 1, new Date(System.currentTimeMillis()));
			LocalEnvironment.statementChecker(statement, 2, ausleiherID);
			ResultSet rs = statement.executeQuery();
			if (rs != null)
				while (rs.next()) {
					ret.add(new Exemplar(rs.getInt(1)));
				}
		} catch (SQLException e) {
			LocalEnvironment.log(e.getMessage(), this);
		} finally {
			LocalEnvironment.closeStmt(statement);
		}

		return ret;
	}

	/* (non-Javadoc)
	 * @see bibliotheksverwaltung.model.daos.dao.ExemplarDAO#fehlt()
	 */
	@Override
	public List<Exemplar> fehlt() {
		List<Exemplar> ret = new ArrayList<Exemplar>();
		
		StringBuffer sb = new StringBuffer();
		sb.append("select exemplarid\n");
		sb.append("from exemplar\n");
		sb.append("where rueckgabedatum < ?");
		sb.append(" and ausleiherid is not null");

		try {
			statement = connection.prepareStatement(sb.toString());
			LocalEnvironment.statementChecker(statement, 1, new Date(System.currentTimeMillis()));
			ResultSet rs = statement.executeQuery();
			if (rs != null)
				while (rs.next()) {
					ret.add(new Exemplar(rs.getInt(1)));
				}
		} catch (SQLException e) {
			LocalEnvironment.log(e.getMessage(), this);
		} finally {
			LocalEnvironment.closeStmt(statement);
		}

		return ret;
	}
}
