/**
 *@author Sven Blaurock, Sven Terzyk, Max Beier
 */
package bibliotheksverwaltung.model.domain;
/**
 * Diese Klasse Realisiert die Statistik, diese besitzt die eingetragenen Buecher, die eingetragenen Exemplare,
 * die eingetragenen Personen, die verliehen Buecher, die leihende Personen, die bisherigen Ausleihungen.
 */
public class Statistik {
	/**
	 * eingetrageneBuecher
	 */
	private int eingetrageneBuecher = 0;
	/**
	 * eingetragendeExemplare
	 */
	private int eingetragendeExemplare = 0;
	/**
	 * eingetragenePersonen
	 */
	private int eingetragenePersonen = 0;
	/**
	 * verliehenBuecher
	 */
	private int verliehenBuecher = 0;
	/**
	 * leihendePersonen
	 */
	private int leihendePersonen = 0;
	/**
	 * bisherigeAusleihen
	 */
	private int bisherigeAusleihen = 0;

	//Konstruktor
	public Statistik(int eingetrageneBuecher, int eingetragendeExemplare,
			int eingetragenePersonen, int verliehenBuecher,
			int leihendePersonen, int bisherigeAusleihen) {
		this.eingetrageneBuecher = eingetrageneBuecher;
		this.eingetragendeExemplare = eingetragendeExemplare;
		this.eingetragenePersonen = eingetragenePersonen;
		this.verliehenBuecher = verliehenBuecher;
		this.leihendePersonen = leihendePersonen;
		this.bisherigeAusleihen = bisherigeAusleihen;
	}


	/**
	 * @return the eingetrageneBuecher
	 */
	public int getEingetrageneBuecher() {
		return eingetrageneBuecher;
	}

	/**
	 * @return the eingetragendeExemplare
	 */
	public int getEingetragendeExemplare() {
		return eingetragendeExemplare;
	}

	/**
	 * @return the eingetragenePersonen
	 */
	public int getEingetragenePersonen() {
		return eingetragenePersonen;
	}

	/**
	 * @return the verliehenBuecher
	 */
	public int getVerliehenBuecher() {
		return verliehenBuecher;
	}

	/**
	 * @return the leihendePersonen
	 */
	public int getLeihendePersonen() {
		return leihendePersonen;
	}

	/**
	 * @return the bisherigeAusleihen
	 */
	public int getBisherigeAusleihen() {
		return bisherigeAusleihen;
	}

}
