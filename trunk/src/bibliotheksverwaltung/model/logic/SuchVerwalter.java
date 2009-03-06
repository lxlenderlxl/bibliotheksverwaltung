package bibliotheksverwaltung.model.logic;

public class SuchVerwalter implements Verwaltbar {

	private String tabelle = null;
	private String[] suchworte = null;
	private String[] spalten = null;

	public SuchVerwalter() {

	}

	public SuchVerwalter(String[] suchworte, String[] spalten) {

	}

	public int[] suche() {
		return null;
	}

	public int[] suche(String[] suchworte, String[] spalten) {
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
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see bibliotheksverwaltung.model.logic.Verwaltbar#delete(java.lang.Object)
	 */
	@Override
	public void delete(Object objekt)
	{
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see bibliotheksverwaltung.model.logic.Verwaltbar#get(java.lang.Object)
	 */
	@Override
	public Object get(Object objekt)
	{
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see bibliotheksverwaltung.model.logic.Verwaltbar#update()
	 */
	@Override
	public void update()
	{
		// TODO Auto-generated method stub

	}

}
