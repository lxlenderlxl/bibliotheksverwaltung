package bibliotheksverwaltung.model.logic;

import java.sql.Date;
import java.util.GregorianCalendar;
import java.util.Observable;

import com.mysql.jdbc.UpdatableResultSet;

import bibliotheksverwaltung.model.domain.Ausleiher;
import bibliotheksverwaltung.model.domain.Exemplar;
import bibliotheksverwaltung.model.domain.Log;
import bibliotheksverwaltung.model.domain.Medium;
import bibliotheksverwaltung.model.domain.Vorgang;
import bibliotheksverwaltung.util.LocalEnvironment;
import bibliotheksverwaltung.util.Message;
import bibliotheksverwaltung.util.UpdateInfo;

public class BibliotheksVerwalter extends Observable {

	private MedienVerwalter medienVerwalter = new MedienVerwalter();
	/**
	 * @return the medienVerwalter
	 */
	public MedienVerwalter getMedienVerwalter()
	{
		return medienVerwalter;
	}

	/**
	 * @param medienVerwalter the medienVerwalter to set
	 */
	public void setMedienVerwalter(MedienVerwalter medienVerwalter)
	{
		this.medienVerwalter = medienVerwalter;
	}

	/**
	 * @return the suchVerwalter
	 */
	public SuchVerwalter getSuchVerwalter()
	{
		return suchVerwalter;
	}

	/**
	 * @param suchVerwalter the suchVerwalter to set
	 */
	public void setSuchVerwalter(SuchVerwalter suchVerwalter)
	{
		this.suchVerwalter = suchVerwalter;
	}

	/**
	 * @return the ausleiherVerwalter
	 */
	public AusleiherVerwalter getAusleiherVerwalter()
	{
		return ausleiherVerwalter;
	}

	/**
	 * @param ausleiherVerwalter the ausleiherVerwalter to set
	 */
	public void setAusleiherVerwalter(AusleiherVerwalter ausleiherVerwalter)
	{
		this.ausleiherVerwalter = ausleiherVerwalter;
	}

	/**
	 * @return the logVerwalter
	 */
	public LogVerwalter getLogVerwalter()
	{
		return logVerwalter;
	}

	/**
	 * @param logVerwalter the logVerwalter to set
	 */
	public void setLogVerwalter(LogVerwalter logVerwalter)
	{
		this.logVerwalter = logVerwalter;
	}

	private SuchVerwalter suchVerwalter = new SuchVerwalter();
	private AusleiherVerwalter ausleiherVerwalter = new AusleiherVerwalter();
	private LogVerwalter logVerwalter = new LogVerwalter();
	
	private UpdateInfo updateInfo = new UpdateInfo();
	
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
			updateInfo.setzeAenderung("ExemplarAusleihen");
			dasExemplar.setAusleiher(this.ausleiherVerwalter.getAusleiher().getId());
			dasExemplar.setRueckgabeDatum(new Date(new GregorianCalendar().getTimeInMillis()+ Long.valueOf(LocalEnvironment.getAusleihdauer().getWert()) * 86400000));
			this.medienVerwalter.getExemplarVerwalter().update();
			LogVerwalter.add(new Log(Vorgang.EXEMPLAR_AUSGELIEHEN, dasExemplar.getAusleiher(), dasExemplar.getId()));
			Message.raise("Das Buch \"" + new Medium(dasExemplar.getMedium()).getTitel() + "\" wurde erfolgreich an \"" + new Ausleiher(dasExemplar.getAusleiher()).getName() + "\" ausgeliehen", Message.GRUEN);
			setChanged();
			notifyObservers(updateInfo);
		}
	}

	public void buchVerlaengern() {
		
		Exemplar dasExemplar = this.medienVerwalter.getExemplarVerwalter().getExemplar();
		// Ist die Anzahl maximalen Verlängerungen laut der Konfiguration überschritten?
		if (dasExemplar.getVerlaengerung() < Integer.valueOf(LocalEnvironment.getMaximaleVerlaengerung().getWert())) {
			updateInfo.setzeAenderung("ExemplarVerlaengern");
			dasExemplar.setRueckgabeDatum(new Date(new GregorianCalendar().getTimeInMillis()+ Long.valueOf(LocalEnvironment.getAusleihdauer().getWert()) * 86400000));
			dasExemplar.setVerlaengerung(dasExemplar.getVerlaengerung() + 1);
			this.medienVerwalter.getExemplarVerwalter().update();

			LogVerwalter.add(new Log(Vorgang.AUSLEIHE_VERLAENGERT, dasExemplar.getAusleiher(), dasExemplar.getId()));

			if (dasExemplar.getVerlaengerung() == Integer.valueOf(LocalEnvironment.getMaximaleVerlaengerung().getWert()) - 1)
				Message.raise("Ausleihung wurde verlängert.\n" +
						"Achtung: Letzte Mögliche Verlängerung.", Message.GELB);
			else
				Message.raise("Ausleihung wurde verlängert.", Message.GRUEN);
			setChanged();
			notifyObservers(updateInfo);
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
			updateInfo.setzeAenderung("ExemplarZurueck");
			LogVerwalter.add(new Log(Vorgang.EXEMPLAR_ZUREUCKGEGEBEN, dasExemplar.getAusleiher(), dasExemplar.getId()));
			dasExemplar.setAusleiher(0);
			dasExemplar.setRueckgabeDatum(null);
			dasExemplar.setVerlaengerung(0);
			this.medienVerwalter.getExemplarVerwalter().update();
			setChanged();
			notifyObservers(updateInfo);
		}
	}

	public void buchBearbeiten () {
		updateInfo.setzeAenderung("BuchBearbeiten");
		this.medienVerwalter.getExemplarVerwalter().update();
		LogVerwalter.add(new Log(Vorgang.EXEMPLAR_BEARBEITET, 0, medienVerwalter.getExemplarVerwalter().getExemplar().getId()));
		setChanged();
		notifyObservers(updateInfo);
	}

	public void buchHinzufuegen() {
		updateInfo.setzeAenderung("ExemplarHinzu");
		this.medienVerwalter.getExemplarVerwalter().add();
		LogVerwalter.add(new Log(Vorgang.EXEMPLAR_HINZUGEFUEGT, 0, this.medienVerwalter.getExemplarVerwalter().getExemplar().getId()));
		setChanged();
		notifyObservers(updateInfo);
	}

	public void buchEntfernen() {
		
		Exemplar dasExemplar = this.medienVerwalter.getExemplarVerwalter().getExemplar();
		if (this.medienVerwalter.getExemplarVerwalter().getExemplar().getAusleiher() == 0) {
			updateInfo.setzeAenderung("ExemplarGeloescht");
			this.medienVerwalter.getExemplarVerwalter().delete();
			Log log = new Log(Vorgang.EXEMPLAR_ENTFERNT, 0, dasExemplar.getId());
			if (!this.medienVerwalter.hasExemplare(dasExemplar.getMedium())) {
				mediumEntfernen();
				log.setKommentar("Letztes Exemplar gelöscht - Medium wird deaktiviert.");
			}
			LogVerwalter.add(log);
			setChanged();
			notifyObservers(updateInfo);
		}
		else
			Message.raise("Das Buch kann nicht entfernt werden, da es zurzeit ausgeliehen ist.", Message.ROT);
	}

	public void mediumHinzufuegen() {
		updateInfo.setzeAenderung("mediumHinzu");
		new MedienVerwalter().add(this.medienVerwalter.getMedium());
		setChanged();
		notifyObservers(updateInfo);
	}

	public void mediumEntfernen() {
		
		if (!new MedienVerwalter().hasExemplare(this.medienVerwalter.getMedium().getId())) {
			updateInfo.setzeAenderung("MediumDelete");
			new MedienVerwalter().delete(new Medium(this.medienVerwalter.getMedium().getId()));
			setChanged();
			notifyObservers(updateInfo);
		}
		else
			LocalEnvironment.log("Medium " + this.medienVerwalter.getMedium().getId() + " konnte nicht gelöscht werden, " +
					"da noch Exemplare vorhanden sind.", this);
	}
	
	public void autoNotify(String message)
	{
		updateInfo.setzeAenderung(message);
		setChanged();
		notifyObservers(updateInfo);
	}
	
	public UpdateInfo holeUpdateInfo()
	{
		return updateInfo;
	}

}