package bibliotheksverwaltung.model.logic;

import java.sql.Date;
import java.util.GregorianCalendar;
import java.util.Observable;

import bibliotheksverwaltung.model.domain.Ausleiher;
import bibliotheksverwaltung.model.domain.Exemplar;
import bibliotheksverwaltung.model.domain.Log;
import bibliotheksverwaltung.model.domain.Medium;
import bibliotheksverwaltung.model.domain.Vorgang;
import bibliotheksverwaltung.util.LocalEnvironment;
import bibliotheksverwaltung.util.Message;

public class BibliotheksVerwalter extends Observable {

	private MedienVerwalter medienVerwalter = new MedienVerwalter();
	private SuchVerwalter suchVerwalter = new SuchVerwalter();
	private AusleiherVerwalter ausleiherVerwalter = new AusleiherVerwalter();
	private LogVerwalter logVerwalter = new LogVerwalter();
	
	/**
	 *
	 */
	public BibliotheksVerwalter() {
		super();
	}

	public void buchAusleihen() {
		Exemplar dasExemplar = this.medienVerwalter.getExemplarVerwalter().getExemplar();
		
		if (dasExemplar.getAusleiher() != 0)
			Message.raise("Das Buch \"" + new Medium(dasExemplar.getMedium()).getTitel() + "\" ist bereits an \"" + new Ausleiher(dasExemplar.getAusleiher()).getName() + "\" ausgeliehen.", Message.ROT);
		else {
			dasExemplar.setAusleiher(this.ausleiherVerwalter.getAusleiher().getId());
			dasExemplar.setRueckgabeDatum(new Date(new GregorianCalendar().getTimeInMillis()+ Long.valueOf(LocalEnvironment.getAusleihdauer().getWert()) * 86400000));
			this.medienVerwalter.getExemplarVerwalter().update(dasExemplar);
			LogVerwalter.add(new Log(Vorgang.EXEMPLAR_AUSGELIEHEN, dasExemplar.getAusleiher(), dasExemplar.getId()));
			Message.raise("Das Buch \"" + new Medium(dasExemplar.getMedium()).getTitel() + "\" wurde erfolgreich an \"" + new Ausleiher(dasExemplar.getAusleiher()).getName() + "\" ausgeliehen", Message.GRUEN);
		}
	}

	public void buchVerlaengern() {
		Exemplar dasExemplar = this.medienVerwalter.getExemplarVerwalter().getExemplar();
		// Ist die Anzahl maximalen Verlängerungen laut der Konfiguration überschritten?
		if (dasExemplar.getVerlaengerung() < Integer.valueOf(LocalEnvironment.getMaximaleVerlaengerung().getWert())) {
			dasExemplar.setRueckgabeDatum(new Date(new GregorianCalendar().getTimeInMillis()+ Long.valueOf(LocalEnvironment.getAusleihdauer().getWert()) * 86400000));
			dasExemplar.setVerlaengerung(dasExemplar.getVerlaengerung() + 1);
			this.medienVerwalter.getExemplarVerwalter().update(dasExemplar);

			LogVerwalter.add(new Log(Vorgang.AUSLEIHE_VERLAENGERT, dasExemplar.getAusleiher(), dasExemplar.getId()));

			if (dasExemplar.getVerlaengerung() == Integer.valueOf(LocalEnvironment.getMaximaleVerlaengerung().getWert()) - 1)
				Message.raise("Ausleihung wurde verlängert.\n" +
						"Achtung: Letzte Mögliche Verlängerung.", Message.GELB);
			else
				Message.raise("Ausleihung wurde verlängert.", Message.GRUEN);
		}
		else
			Message.raise("Verlängerung nicht durchgeführt.\n" +
					"Maximale Anzahl an Verlängerungen erreicht.", Message.ROT);
	}

	public void buchZurueckgeben() {
		Exemplar dasExemplar = this.medienVerwalter.getExemplarVerwalter().getExemplar();
		if (dasExemplar.getAusleiher() == 0)
			Message.raise("Dieses Exemplar ist bereits zurück gegeben.", Message.ROT);
		else {
			LogVerwalter.add(new Log(Vorgang.EXEMPLAR_ZUREUCKGEGEBEN, dasExemplar.getAusleiher(), dasExemplar.getId()));
			dasExemplar.setAusleiher(0);
			dasExemplar.setRueckgabeDatum(null);
			dasExemplar.setVerlaengerung(0);
			this.medienVerwalter.getExemplarVerwalter().update(dasExemplar);
		}
	}

	public void buchBearbeiten () {
		this.medienVerwalter.getExemplarVerwalter().update(medienVerwalter.getExemplarVerwalter().getExemplar());
		LogVerwalter.add(new Log(Vorgang.EXEMPLAR_BEARBEITET, 0, medienVerwalter.getExemplarVerwalter().getExemplar().getId()));
	}

	public void buchHinzufuegen() {
		this.medienVerwalter.getExemplarVerwalter().add(this.medienVerwalter.getExemplarVerwalter().getExemplar());
		LogVerwalter.add(new Log(Vorgang.EXEMPLAR_HINZUGEFUEGT, 0, this.medienVerwalter.getExemplarVerwalter().getExemplar().getId()));
	}

	public void buchEntfernen() {
		Exemplar dasExemplar = this.medienVerwalter.getExemplarVerwalter().getExemplar();
		if (this.medienVerwalter.getExemplarVerwalter().getExemplar().getAusleiher() != 0) {
			this.medienVerwalter.getExemplarVerwalter().delete(dasExemplar);
			Log log = new Log(Vorgang.EXEMPLAR_ENTFERNT, 0, dasExemplar.getId());
			if (!new MedienVerwalter().hasExemplare(dasExemplar.getMedium())) {
				mediumEntfernen();
				log.setKommentar("Letztes Exemplar gelöscht - Medium wird deaktiviert.");
			}
			LogVerwalter.add(log);
		}
		else
			Message.raise("Das Buch kann nicht entfernt werden, da es zurzeit ausgeliehen ist.", Message.ROT);
	}

	public void mediumHinzufuegen() {
		new MedienVerwalter().add(this.medienVerwalter.getMedium());
	}

	public void mediumEntfernen() {
		if (!new MedienVerwalter().hasExemplare(this.medienVerwalter.getMedium().getId()))
			new MedienVerwalter().delete(new Medium(this.medienVerwalter.getMedium().getId()));
		else
			LocalEnvironment.log("Medium " + this.medienVerwalter.getMedium().getId() + " konnte nicht gelöscht werden, " +
					"da noch Exemplare vorhanden sind.", this);
	}


}