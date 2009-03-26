/**
 *
 */
package bibliotheksverwaltung.model.domain;

public class Statistik {

	private int eingetrageneBuecher = 0;

	private int eingetragendeExemplare = 0;

	private int eingetragenePersonen = 0;

	private int verliehenBuecher = 0;

	private int leihendePersonen = 0;

	private int bisherigeAusleihen = 0;


	/**
	 *
	 */
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
