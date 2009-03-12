package bibliotheksverwaltung.model.logic;

import java.util.GregorianCalendar;

import bibliotheksverwaltung.model.domain.Ausleiher;
import bibliotheksverwaltung.model.domain.Exemplar;
import bibliotheksverwaltung.model.domain.Konfiguration;
import bibliotheksverwaltung.model.domain.Log;
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
		if (exemplar.getAusleiher() == 0)
			Message.raise("Dieses Exemplar ist bereits ausgeliehen.", Message.ROT);
		else {
		new ExemplarVerwalter().update(new Exemplar(
				exemplar.getId(),
				exemplar.getZustand(),
				ausleiher.getId(),
				exemplar.getMedium(),
				new java.sql.Date(new GregorianCalendar().getTimeInMillis()),
				0,
				true)
		);
		//TODO Log-Eintrag: Buch wurde ausgeliehen.
		}
	}

	public void buchVerlaengern(Exemplar exemplar) {
		int maximaleAnzahlVerlaengerungen = new Integer(new Konfiguration("verlaengerung").getWert());
		// Ist die Anzahl maximalen Verl�ngerungen laut der Konfiguration �berschritten?
		if (exemplar.getVerlaengerung() < maximaleAnzahlVerlaengerungen) {
			new ExemplarVerwalter().update(new Exemplar(
					exemplar.getId(),
					exemplar.getZustand(),
					exemplar.getAusleiher(),
					exemplar.getMedium(),
					new java.sql.Date(new GregorianCalendar().getTimeInMillis()),
					exemplar.getVerlaengerung() + 1, // Erh�ht die aktuelle Ausleihzahl um eins
					true)
			);

			//TODO Log-Eintrag: Ausleihe wurde verl�ngert.

			if (exemplar.getVerlaengerung() == maximaleAnzahlVerlaengerungen - 1)
				Message.raise("Ausleihung wurde verl�ngert.\n" +
						"Achtung: Letzte M�gliche Verl�ngerung.", Message.GELB);
			else
				Message.raise("Ausleihung wurde verl�ngert.", Message.GRUEN);
		}
		else
			Message.raise("Verl�ngerung nicht durchgef�hrt.\n" +
					"Maximale Anzahl an Verl�ngerungen erreicht.", Message.ROT);
	}

	public void buchZurueckgeben(Exemplar exemplar) {
		if (exemplar.getAusleiher() == 0)
			Message.raise("Dieses Exemplar ist bereits zur�ck gegeben.", Message.ROT);
		else {
		new ExemplarVerwalter().update(new Exemplar(
				exemplar.getId(),
				exemplar.getZustand(),
				0,
				exemplar.getMedium(),
				null,
				0,
				true)
		);
		//TODO Log-Eintrag: Buch zur�ck gegeben.
		}
	}

	public void buchBearbeiten (Exemplar exemplar) {
		new ExemplarVerwalter().update(exemplar);
		//TODO Buch-Daten wurden ge�ndert
	}

	public void buchHinzufuegen(Exemplar exemplar) {
		new ExemplarVerwalter().add(exemplar);
		//TODO Log: Buch wurde hinzugef�gt
	}

	public void buchEntfernen(Exemplar exemplar) {
		if (exemplar.getAusleiher() != 0) {
			new ExemplarVerwalter().delete(exemplar);
			Log log = new Log(4, 0, exemplar.getId());
			if (!new MedienVerwalter().hasExemplare(exemplar.getMedium())) {
					mediumEntfernen(exemplar.getMedium());
					log.setKommentar("Letztes Exemplar gel�scht - Medium wird deaktiviert.");
			}
		}
		else
			Message.raise("Das Buch kann nicht entfernt werden, da es zurzeit ausgeliehen ist.", Message.ROT);
	}

	public void mediumHinzufuegen(Medium medium) {
		new MedienVerwalter().add(medium);
		//TODO Log: Medium wurde hinzugef�gt
	}

	public void mediumEntfernen(int mediumID) {
		if (!new MedienVerwalter().hasExemplare(mediumID))
			new MedienVerwalter().delete(new Medium(mediumID));
		else
			LocalEnvironment.log("Medium " + mediumID + " konnte nicht gel�scht werden, " +
					"da noch Exemplare vorhanden sind.", this);
	}


}
