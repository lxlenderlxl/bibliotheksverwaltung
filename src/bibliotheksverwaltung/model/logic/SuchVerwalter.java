package bibliotheksverwaltung.model.logic;

/**
 * @deprecated
 */

public class SuchVerwalter implements Verwaltbar {

	private String tabelle = null;
	private String[] suchworte = null;
	private String[] spalten = null;

	public SuchVerwalter() {

	}

	public SuchVerwalter(String tabelle, String[] suchworte, String[] spalten) {
		this.tabelle = tabelle;
		this.suchworte = suchworte;
		this.spalten = spalten;
	}

	public int[] suche() {
		return null;
	}

	public int[] suche(String tabelle, String[] suchworte, String[] spalten) {
		return null;
	}

	private int[] ranker(int[] idListe) {
		return null;
	}

	/* (non-Javadoc)
	 * @see bibliotheksverwaltung.model.logic.Verwaltbar#add(java.lang.Object)
	 */
	@Override
	public void add(Object objekt)
	{
		// Kein Hinzufügen von Suchen erforderlich.

	}

	/* (non-Javadoc)
	 * @see bibliotheksverwaltung.model.logic.Verwaltbar#delete(java.lang.Object)
	 */
	@Override
	public void delete(Object objekt)
	{
		// Kein Löschen von Suchen erforderlich.
	}

	/* (non-Javadoc)
	 * @see bibliotheksverwaltung.model.logic.Verwaltbar#update()
	 */
	@Override
	public void update(Object objekt)
	{
		// Kein Updaten von Suchen erforderlich.
	}

}
