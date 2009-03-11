package bibliotheksverwaltung.model.logic;

import java.util.GregorianCalendar;

import bibliotheksverwaltung.model.domain.Ausleiher;
import bibliotheksverwaltung.model.domain.Exemplar;
import bibliotheksverwaltung.model.domain.Konfiguration;
import bibliotheksverwaltung.util.Message;

public class BibliotheksVerwalter {

	/**
	 *
	 */
	public BibliotheksVerwalter() {
		// TODO Braucht die Bibliothek einen Konstruktor?
	}

	public void buchAusleihen(Exemplar exemplar, Ausleiher ausleiher) {
		new ExemplarVerwalter().update(new Exemplar(
				exemplar.getId(),
				exemplar.getZustand().getId(),
				ausleiher.getId(),
				exemplar.getMedium().getId(),
				new java.sql.Date(new GregorianCalendar().getTimeInMillis()),
				0,
				true)
		);
	}

	public void buchVerlaengern(Exemplar exemplar) {
		// Ist die Anzahl maximalen Verlängerungen laut der Konfiguration überschritten?
		if (exemplar.getVerlaengerung() > new Integer(new Konfiguration("verlaengerung").getWert())) {
			new ExemplarVerwalter().update(new Exemplar(
					exemplar.getId(),
					exemplar.getZustand().getId(),
					exemplar.getAusleiher().getId(),
					exemplar.getMedium().getId(),
					new java.sql.Date(new GregorianCalendar().getTimeInMillis()),
					exemplar.getVerlaengerung() + 1, // Erhöht die aktuelle Ausleihzahl um eins
					true)
			);
		}

	}


}
