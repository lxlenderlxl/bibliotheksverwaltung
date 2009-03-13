package bibliotheksverwaltung.model.logic;

import java.sql.Date;
import java.util.GregorianCalendar;

import bibliotheksverwaltung.model.domain.Ausleiher;
import bibliotheksverwaltung.model.domain.Exemplar;
import bibliotheksverwaltung.model.domain.Log;
import bibliotheksverwaltung.model.domain.Medium;
import bibliotheksverwaltung.model.domain.Vorgang;
import bibliotheksverwaltung.util.LocalEnvironment;
import bibliotheksverwaltung.util.Message;

public class BibliotheksVerwalter {

	/**
	 *
	 */
	public BibliotheksVerwalter() {
	
	}

	public void buchAusleihen(Exemplar exemplar, Ausleiher ausleiher) {
		if (exemplar.getAusleiher() != 0)
			Message.raise("Das Buch \"" + new Medium(exemplar.getMedium()).getTitel() + "\" ist bereits an \"" + new Ausleiher(exemplar.getAusleiher()).getName() + "\" ausgeliehen.", Message.ROT);
		else {
			exemplar.setAusleiher(ausleiher.getId());
			exemplar.setRueckgabeDatum(new Date(new GregorianCalendar().getTimeInMillis()+ Long.valueOf(LocalEnvironment.getAusleihdauer().getWert()) * 86400000));
			new ExemplarVerwalter().update(exemplar);
			LogVerwalter.add(new Log(Vorgang.EXEMPLAR_AUSGELIEHEN, exemplar.getAusleiher(), exemplar.getId()));
			Message.raise("Das Buch \"" + new Medium(exemplar.getMedium()).getTitel() + "\" wurde erfolgreich an \"" + new Ausleiher(exemplar.getAusleiher()).getName() + "\" ausgeliehen", Message.GRUEN);
		}
	}

	public void buchVerlaengern(Exemplar exemplar) {
		// Ist die Anzahl maximalen Verlängerungen laut der Konfiguration überschritten?
		if (exemplar.getVerlaengerung() < Integer.valueOf(LocalEnvironment.getMaximaleVerlaengerung().getWert())) {
			exemplar.setRueckgabeDatum(new Date(new GregorianCalendar().getTimeInMillis()+ Long.valueOf(LocalEnvironment.getAusleihdauer().getWert()) * 86400000));
			exemplar.setVerlaengerung(exemplar.getVerlaengerung() + 1);
			new ExemplarVerwalter().update(exemplar);

			LogVerwalter.add(new Log(Vorgang.AUSLEIHE_VERLAENGERT, exemplar.getAusleiher(), exemplar.getId()));

			if (exemplar.getVerlaengerung() == Integer.valueOf(LocalEnvironment.getMaximaleVerlaengerung().getWert()) - 1)
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
			LogVerwalter.add(new Log(Vorgang.EXEMPLAR_ZUREUCKGEGEBEN, exemplar.getAusleiher(), exemplar.getId()));
			exemplar.setAusleiher(0);
			exemplar.setRueckgabeDatum(null);
			exemplar.setVerlaengerung(0);
			new ExemplarVerwalter().update(exemplar);
		}
	}

	public void buchBearbeiten (Exemplar exemplar) {
		new ExemplarVerwalter().update(exemplar);
		LogVerwalter.add(new Log(Vorgang.EXEMPLAR_BEARBEITET, 0, exemplar.getId()));
	}

	public void buchHinzufuegen(Exemplar exemplar) {
		new ExemplarVerwalter().add(exemplar);
		LogVerwalter.add(new Log(Vorgang.EXEMPLAR_HINZUGEFUEGT, 0, exemplar.getId()));
	}

	public void buchEntfernen(Exemplar exemplar) {
		if (exemplar.getAusleiher() != 0) {
			new ExemplarVerwalter().delete(exemplar);
			Log log = new Log(Vorgang.EXEMPLAR_ENTFERNT, 0, exemplar.getId());
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
	}

	public void mediumEntfernen(int mediumID) {
		if (!new MedienVerwalter().hasExemplare(mediumID))
			new MedienVerwalter().delete(new Medium(mediumID));
		else
			LocalEnvironment.log("Medium " + mediumID + " konnte nicht gelöscht werden, " +
					"da noch Exemplare vorhanden sind.", this);
	}


}