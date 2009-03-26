package bibliotheksverwaltung.model.logic;

import java.sql.Date;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.Observable;

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

	private SuchVerwalter suchVerwalter = new SuchVerwalter();
	private AusleiherVerwalter ausleiherVerwalter = new AusleiherVerwalter();
	//private LogVerwalter logVerwalter = new LogVerwalter();
	private HistorienVerwalter historienVerwalter = new HistorienVerwalter();
	/**
	 * @return the historienVerwalter
	 */
	public HistorienVerwalter getHistorienVerwalter()
	{
		return historienVerwalter;
	}

	/**
	 * @param historienVerwalter the historienVerwalter to set
	 */
	public void setHistorienVerwalter(HistorienVerwalter historienVerwalter)
	{
		this.historienVerwalter = historienVerwalter;
	}

	private WarenKorbVerwalter warenKorbVerwalter = new WarenKorbVerwalter();
	
	private DruckVerwalter druckVerwalter = new DruckVerwalter();
	
	/**
	 * @return the druckVerwalter
	 */
	public DruckVerwalter getDruckVerwalter()
	{
		return druckVerwalter;
	}

	/**
	 * @param druckVerwalter the druckVerwalter to set
	 */
	public void setDruckVerwalter(DruckVerwalter druckVerwalter)
	{
		this.druckVerwalter = druckVerwalter;
	}

	/**
	 * @return the warenKorbVerwalter
	 */
	public WarenKorbVerwalter getWarenKorbVerwalter()
	{
		return warenKorbVerwalter;
	}

	/**
	 * @param warenKorbVerwalter the warenKorbVerwalter to set
	 */
	public void setWarenKorbVerwalter(WarenKorbVerwalter warenKorbVerwalter)
	{
		this.warenKorbVerwalter = warenKorbVerwalter;
	}

	private UpdateInfo updateInfo = new UpdateInfo();
	
	/**
	 *
	 */
	public BibliotheksVerwalter() {
		super();
	}

	private void buchAusleihen(Exemplar dasExemplar) {
		
		if (dasExemplar.getAusleiher() != 0)
			Message.raise("Das Buch \"" + new Medium(dasExemplar.getMedium()).getTitel() + "\" ist bereits an \"" + new Ausleiher(dasExemplar.getAusleiher()).getName() + "\" ausgeliehen.", Message.ROT);
		else {
			updateInfo.setzeAenderung("ExemplarAusleihen");
			dasExemplar.setAusleiher(this.warenKorbVerwalter.getAusleiher().getId());
			dasExemplar.setRueckgabeDatum(new Date(new GregorianCalendar().getTimeInMillis()+ Long.valueOf(LocalEnvironment.getAusleihdauer().getWert()) * 86400000));
			this.medienVerwalter.getExemplarVerwalter().setExemplar(dasExemplar);
			this.medienVerwalter.getExemplarVerwalter().update();
			LogVerwalter.add(new Log(Vorgang.EXEMPLAR_AUSGELIEHEN, dasExemplar.getAusleiher(), dasExemplar.getId()));
			Message.raise("Das Buch wurde erfolgreich ausgeliehen", Message.GRUEN);
			setChanged();
			notifyObservers(updateInfo);
		}
	}
	
	public void buecherAusleihen()
	{
		ArrayList<Exemplar> auszuleihendeEx = this.warenKorbVerwalter.getWarenKorb();
		for (int i = 0; i < auszuleihendeEx.size(); i++)
		{
			this.buchAusleihen(auszuleihendeEx.get(i));
			updateInfo.setzeAenderung("AktualisiereWarenKorb");
			this.warenKorbVerwalter.entferneExemplar(auszuleihendeEx.get(i));
			setChanged();
			notifyObservers(updateInfo);
		}
		updateInfo.setzeAenderung("WarenKorbReset");
		setChanged();
		notifyObservers(updateInfo);
	}

	public void buchVerlaengern() {
		
		Exemplar dasExemplar = this.medienVerwalter.getExemplarVerwalter().getExemplar();
		// Ist die Anzahl maximalen Verl�ngerungen laut der Konfiguration �berschritten?
		if (dasExemplar.getVerlaengerung() < Integer.valueOf(LocalEnvironment.getMaximaleVerlaengerung().getWert())) {
			updateInfo.setzeAenderung("ExemplarVerlaengern");
			dasExemplar.setRueckgabeDatum(new Date(new GregorianCalendar().getTimeInMillis()+ Long.valueOf(LocalEnvironment.getAusleihdauer().getWert()) * 86400000));
			dasExemplar.setVerlaengerung(dasExemplar.getVerlaengerung() + 1);
			this.medienVerwalter.getExemplarVerwalter().update();

			LogVerwalter.add(new Log(Vorgang.AUSLEIHE_VERLAENGERT, dasExemplar.getAusleiher(), dasExemplar.getId()));

			if (dasExemplar.getVerlaengerung() == Integer.valueOf(LocalEnvironment.getMaximaleVerlaengerung().getWert()))
				Message.raise("Ausleihung wurde verl�ngert.\n" +
						"Achtung: Letzte M�gliche Verl�ngerung.", Message.GELB);
			else
				Message.raise("Ausleihung wurde verl�ngert.", Message.GRUEN);
			setChanged();
			notifyObservers(updateInfo);
		}
		else
			Message.raise("Verl�ngerung nicht durchgef�hrt.\n" +
					"Maximale Anzahl an Verl�ngerungen erreicht.", Message.ROT);
	}

	public void buchZurueckgeben() {
		Exemplar dasExemplar = this.medienVerwalter.getExemplarVerwalter().getExemplar();
		if (dasExemplar.getAusleiher() == 0)
			Message.raise("Dieses Exemplar ist bereits zur�ck gegeben.", Message.ROT);
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

	public void mediumBearbeiten () {
		updateInfo.setzeAenderung("MediumBearbeiten");
		this.medienVerwalter.update();
		setChanged();
		notifyObservers(updateInfo);
	}
	
	public void personBearbeiten () {
		updateInfo.setzeAenderung("PersonDatenBearbeitet");
		this.ausleiherVerwalter.update();
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
				log.setKommentar("Letztes Exemplar gel�scht - Medium wird deaktiviert.");
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
		new MedienVerwalter().add();
		setChanged();
		notifyObservers(updateInfo);
	}

	public void mediumEntfernen() {
		
		if (!new MedienVerwalter().hasExemplare(this.medienVerwalter.getMedium().getId())) {
			updateInfo.setzeAenderung("MediumDelete");
			new MedienVerwalter().delete();
			setChanged();
			notifyObservers(updateInfo);
		}
		else
			LocalEnvironment.log("Medium " + this.medienVerwalter.getMedium().getId() + " konnte nicht gel�scht werden, " +
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