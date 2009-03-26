package bibliotheksverwaltung.model.domain;

import java.util.List;

import bibliotheksverwaltung.model.daos.dao.MySQLAusleiherDAO;
import bibliotheksverwaltung.model.daos.dao.MySQLExemplarDAO;

/**
 * @author dBi
 */
public class Mahnliste {

	/**
	 * Jede Mahnliste ist einem Ausleiher zugeordnet.
	 */
	private Ausleiher ausleiher;

	/**
	 * Die Liste der zurückgehaltenen Exemplare.
	 */
	private List<Exemplar> fehlListe;

	/**
	 * 
	 * @param ausleiherID
	 */
	public Mahnliste(int ausleiherID) {
		ausleiher = new MySQLAusleiherDAO().get(ausleiherID);
		fehlListe = new MySQLExemplarDAO().fehlt(ausleiher.getId());
	}

	/**
	 * 
	 * @param a
	 */
	public Mahnliste(Ausleiher a) {
		ausleiher = a;
	}

	/**
	 * 
	 * @return
	 */
	public Ausleiher getAusleiher() {
		return ausleiher;
	}
	
	/**
	 * 
	 * @return
	 */
	public List<Exemplar> getExemplare() {
		return fehlListe;
	}
	
	/*
	 * (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		StringBuffer sb = new StringBuffer();
		sb.append("Für Ausleiher mit der ID ");
		sb.append(ausleiher.getId());
		sb.append(" fehlen folgende Exemplare: ");
		for (Exemplar e : fehlListe) {
			sb.append(' ');
			sb.append(e.getMedium());
		}
		return sb.toString();
	}
	public static void main (String args[]) {
		Mahnliste m = new Mahnliste(2);
		System.out.println(m.toString());
	}
}
