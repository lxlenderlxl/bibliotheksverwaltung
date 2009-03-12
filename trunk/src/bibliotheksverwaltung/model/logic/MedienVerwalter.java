package bibliotheksverwaltung.model.logic;

import bibliotheksverwaltung.model.daos.dao.MySQLMediumDAO;
import bibliotheksverwaltung.model.domain.Medium;
import bibliotheksverwaltung.util.LocalEnvironment;

public class MedienVerwalter implements Verwaltbar {

	private MySQLMediumDAO mediumDAO = new MySQLMediumDAO();

	/* (non-Javadoc)
	 * @see bibliotheksverwaltung.model.logic.Verwaltbar#add(java.lang.Object)
	 */
	@Override
	public void add(Object objekt)
	{
		try {
			Medium medium = (Medium) objekt;
			mediumDAO.add(
					medium.getTitel(),
					medium.getAutorVorname(),
					medium.getAutorNachname(),
					medium.getVerlag(),
					medium.getErscheinungsJahr() + "",
					medium.getIsbn(),
					medium.isAktiv());
		} catch (java.lang.ClassCastException e) {
			LocalEnvironment.log(e.getMessage(), this);
		}
	}

	/* (non-Javadoc)
	 * @see bibliotheksverwaltung.model.logic.Verwaltbar#delete(java.lang.Object)
	 */
	@Override
	public void delete(Object objekt)
	{
		try {
			Medium medium = (Medium) objekt;
			mediumDAO.update(
					medium.getId(),
					medium.getTitel(),
					medium.getAutorVorname(),
					medium.getAutorNachname(),
					medium.getVerlag(),
					medium.getErscheinungsJahr() + "",
					medium.getIsbn(),
					false);
		} catch (java.lang.ClassCastException e) {
			LocalEnvironment.log(e.getMessage(), this);
		}
	}

	/* (non-Javadoc)
	 * @see bibliotheksverwaltung.model.logic.Verwaltbar#update()
	 */
	@Override
	public void update(Object objekt)
	{
		try {
			Medium medium = (Medium) objekt;
			mediumDAO.update(
					medium.getId(),
					medium.getTitel(),
					medium.getAutorVorname(),
					medium.getAutorNachname(),
					medium.getVerlag(),
					medium.getErscheinungsJahr() + "",
					medium.getIsbn(),
					medium.isAktiv());
		} catch (java.lang.ClassCastException e) {
			LocalEnvironment.log(e.getMessage(), this);
		}
	}

	/**
	 * @param id
	 * @return
	 */
	public boolean hasExemplare(int id) {
		 return (mediumDAO.getAnzahlExemplare(id) > 0);
	}

	public int getAnzahlExemplare(Medium medium) {
		return mediumDAO.getAnzahlExemplare(medium.getId());
	}

}
