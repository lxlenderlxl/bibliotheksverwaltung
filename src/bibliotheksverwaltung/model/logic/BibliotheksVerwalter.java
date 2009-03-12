package bibliotheksverwaltung.model.logic;

import java.util.GregorianCalendar;

import bibliotheksverwaltung.model.domain.Ausleiher;
import bibliotheksverwaltung.model.domain.Exemplar;
import bibliotheksverwaltung.model.domain.Konfiguration;
import bibliotheksverwaltung.model.domain.Medium;
import bibliotheksverwaltung.util.LocalEnvironment;
import bibliotheksverwaltung.util.Message;

public class BibliotheksVerwalter {

	/**
	 *
	 */
	public BibliotheksVerwalter() {
		// TODO Braucht die Bibliothek einen Konstruktor?
	}

	public void buchAusleihen(Exemplar exemplar, Ausleiher ausleiher) {
		if (exemplar.getAusleiher() == null)
			Message.raise("Dieses Exemplar ist bereits ausgeliehen.", Message.ROT);
		else {
		new ExemplarVerwalter().update(new Exemplar(
				exemplar.getId(),
				exemplar.getZustand().getId(),
				ausleiher.getId(),
				exemplar.getMedium().getId(),
				new java.sql.Date(new GregorianCalendar().getTimeInMillis()),
				0,
				true)
		);
		//TODO Log-Eintrag: Buch wurde ausgeliehen.
		}
	}

	public void buchVerlaengern(Exemplar exemplar) {
		int maximaleAnzahlVerlaengerungen = new Integer(new Konfiguration("verlaengerung").getWert());
		// Ist die Anzahl maximalen Verlängerungen laut der Konfiguration überschritten?
		if (exemplar.getVerlaengerung() < maximaleAnzahlVerlaengerungen) {
			new ExemplarVerwalter().update(new Exemplar(
					exemplar.getId(),
					exemplar.getZustand().getId(),
					exemplar.getAusleiher().getId(),
					exemplar.getMedium().getId(),
					new java.sql.Date(new GregorianCalendar().getTimeInMillis()),
					exemplar.getVerlaengerung() + 1, // Erhöht die aktuelle Ausleihzahl um eins
					true)
			);

			//TODO Log-Eintrag: Ausleihe wurde verlängert.

			if (exemplar.getVerlaengerung() == maximaleAnzahlVerlaengerungen - 1)
				Message.raise("Ausleihung wurde verlängert.\n" +
						"Achtung: Letzte Mögliche Verlängerung.", Message.GELB);
			else
				Message.raise("Ausleihung wurde verlängert.", Message.GRUEN);
		}
		else
			Message.raise("Verlängerung nicht durchgeführt.\n" +
					"Maximale Anzahl an Verlängerungen erreicht.", Message.ROT);
	}

	public void buchZurueckgeben(Exemplar exemplar) {
		if (exemplar.getAusleiher() == null)
			Message.raise("Dieses Exemplar ist bereits zurück gegeben.", Message.ROT);
		else {
		new ExemplarVerwalter().update(new Exemplar(
				exemplar.getId(),
				exemplar.getZustand().getId(),
				0,
				exemplar.getMedium().getId(),
				null,
				0,
				true)
		);
		//TODO Log-Eintrag: Buch zurück gegeben.
		}
	}

	public void buchBearbeiten (Exemplar exemplar) {
		new ExemplarVerwalter().update(exemplar);
		//TODO Buch-Daten wurden geändert
	}

	public void buchHinzufuegen(Exemplar exemplar) {
		new ExemplarVerwalter().add(exemplar);
		//TODO Log: Buch wurde hinzugefügt
	}

	public void buchEntfernen(Exemplar exemplar) {
		if (exemplar.getAusleiher() != null) {
			new ExemplarVerwalter().delete(exemplar);
			//TODO Log: Exemplar wurde entfernt
			if (!new MedienVerwalter().hasExemplare(exemplar.getMedium())) {
					mediumEntfernen(exemplar.getMedium());
					//TODO Log: Letztes Exemplar wurde entfernt, Medium wird entfernt
			}
		}
		else
			Message.raise("Das Buch kann nicht entfernt werden, da es zurzeit ausgeliehen ist.", Message.ROT);
	}

	public void mediumHinzufuegen(Medium medium) {
		new MedienVerwalter().add(medium);
		//TODO Log: Medium wurde hinzugefügt
	}

	public void mediumEntfernen(Medium medium) {
		if (!new MedienVerwalter().hasExemplare(medium)) {
			new MedienVerwalter().delete(medium);
			//TODO Medium wurde entfernt
		}
		else
			LocalEnvironment.log("Medium " + medium.getId() + " konnte nicht gelöscht werden, " +
					"da noch Exemplare vorhanden sind.", this);
	}


}
