/**
 * 
 */
package bibliotheksverwaltung.model.logic;

import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import bibliotheksverwaltung.model.daos.dao.MySQLExemplarDAO;
import bibliotheksverwaltung.model.domain.Exemplar;
import bibliotheksverwaltung.model.domain.Mahnliste;


/**
 * 
 */
public class MahnlisteVerwalter {

	/**
	 * 
	 */
	private Map<Integer, Mahnliste> mahnlisten;

	/**
	 * 
	 */
	public MahnlisteVerwalter() {
		mahnlisten = new TreeMap<Integer, Mahnliste>();
		
		Set<Integer> ausleiher = new HashSet<Integer>();
		List<Exemplar> l = new MySQLExemplarDAO().fehlt();
		// Alle Ausleiher sammeln.
		for (Exemplar e : l)
			ausleiher.add(e.getAusleiher());
		for (int i : ausleiher)
			mahnlisten.put(i, new Mahnliste(i));
	}
	
	/*
	 * (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		StringBuffer sb = new StringBuffer();
		Iterator<Mahnliste> itr = mahnlisten.values().iterator();
		while (itr.hasNext()) {
			sb.append(itr.next());
			sb.append('\n');
		}
		return sb.toString();
	}
	
	public static void main(String[] args) {
		System.out.println(new MahnlisteVerwalter());
	}
}
