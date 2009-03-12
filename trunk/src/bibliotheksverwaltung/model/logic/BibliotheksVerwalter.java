package bibliotheksverwaltung.model.logic;

import java.sql.Date;
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
			exemplar.setAusleiher(ausleiher.getId());
			exemplar.setRueckgabeDatum((Date) new GregorianCalendar().getTime());
			//TODO neues Ausleihdatum += Verlängerungstage aus Konfiguration
		new ExemplarVerwalter().update(exemplar);
		LogVerwalter.add(new Log(1, exemplar.getAusleiher(), exemplar.getId()));
		}
	}

	public void buchVerlaengern(Exemplar exemplar) {
		int maximaleAnzahlVerlaengerungen = new Integer(new Konfiguration("verlaengerung").getWert());
		// Ist die Anzahl maximalen Verlängerungen laut der Konfiguration überschritten?
		if (exemplar.getVerlaengerung() < maximaleAnzahlVerlaengerungen) {
			new ExemplarVerwalter().update(new Exemplar(
					exemplar.getId(),
					exemplar.getZustand(),
					exemplar.getAusleiher(),
					exemplar.getMedium(),
					new java.sql.Date(new GregorianCalendar().getTimeInMillis()),
					exemplar.getVerlaengerung() + 1, // Erhöht die aktuelle Ausleihzahl um eins
					true)
			);

			LogVerwalter.add(new Log(12, exemplar.getAusleiher(), exemplar.getId()));

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
		if (exemplar.getAusleiher() == 0)
			Message.raise("Dieses Exemplar ist bereits zurück gegeben.", Message.ROT);
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
		LogVerwalter.add(new Log(2, exemplar.getAusleiher(), exemplar.getId()));
		}
	}

	public void buchBearbeiten (Exemplar exemplar) {
		new ExemplarVerwalter().update(exemplar);
		LogVerwalter.add(new Log(10, 0, exemplar.getId()));
	}

	public void buchHinzufuegen(Exemplar exemplar) {
		new ExemplarVerwalter().add(exemplar);
		LogVerwalter.add(new Log(3, 0, exemplar.getId()));
	}

	public void buchEntfernen(Exemplar exemplar) {
		if (exemplar.getAusleiher() != 0) {
			new ExemplarVerwalter().delete(exemplar);
			Log log = new Log(4, 0, exemplar.getId());
			if (!new MedienVerwalter().hasExemplare(exemplar.getMedium())) {
					mediumEntfernen(exemplar.getMedium());
					log.setKommentar("Letztes Exemplar gelöscht - Medium wird deaktiviert.");
			}
			LogVerwalter.add(log);
		}
		else
			Message.raise("Das Buch kann nicht entfernt werden, da es zurzeit ausgeliehen ist.", Message.ROT);
	}

	public void mediumHinzufuegen(Medium medium) {
		new MedienVerwalter().add(medium);
		//TODO Log: Medium wurde hinzugefügt
	}

	public void mediumEntfernen(int mediumID) {
		if (!new MedienVerwalter().hasExemplare(mediumID))
			new MedienVerwalter().delete(new Medium(mediumID));
		else
			LocalEnvironment.log("Medium " + mediumID + " konnte nicht gelöscht werden, " +
					"da noch Exemplare vorhanden sind.", this);
	}


}
