/**
 *
 */
package bibliotheksverwaltung.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import bibliotheksverwaltung.model.logic.BibliotheksVerwalter;
import bibliotheksverwaltung.util.Message;
import bibliotheksverwaltung.view.BuchHinzufuegenPanel;
import bibliotheksverwaltung.view.PersonHinzufuegenPanel;

public class PersonAenderungenSpeichernListener implements ActionListener
{
	private BibliotheksVerwalter verwalter = null;
	private PersonHinzufuegenPanel hinzuPanel = null;

	public PersonAenderungenSpeichernListener(BibliotheksVerwalter derVerwalter, PersonHinzufuegenPanel dasHinzuPanel) {
		this.verwalter = derVerwalter;
		this.hinzuPanel = dasHinzuPanel;
	}

	/* (non-Javadoc)
	 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
	@Override
	public void actionPerformed(ActionEvent e)
	{
		if (!verwalter.holeUpdateInfo().holeUpdateSperre())
		{
			boolean eingabeOK = true;
			this.verwalter.holeUpdateInfo().setzeUpdateSperre(true);
			try {
				this.verwalter.getAusleiherVerwalter().getAusleiher().setVorName(this.hinzuPanel.getVornameField().getText());
			} catch (Exception ex)
			{
				Message.raise("Bitte prüfen Sie den Autor-Nachnamen", Message.ROT);
				eingabeOK = false;
			}
			try {
				this.verwalter.getAusleiherVerwalter().getAusleiher().setNachName(this.hinzuPanel.getNachnameField().getText());
			} catch (Exception ex)
			{
				Message.raise("Bitte prüfen Sie den Autor-Vornamen", Message.ROT);
				eingabeOK = false;
			}
			try {
				this.verwalter.getAusleiherVerwalter().getAusleiher().setStrasse(this.hinzuPanel.getStrasseField().getText());
			} catch (Exception ex)
			{
				Message.raise("Bitte prüfen Sie das Erscheinungsjahr", Message.ROT);
				eingabeOK = false;
			}
			try {
				this.verwalter.getAusleiherVerwalter().getAusleiher().setHausnummer(this.hinzuPanel.getHausnummerField().getText());
			} catch (Exception ex)
			{
				Message.raise("Bitte prüfen Sie die ISBN", Message.ROT);
				eingabeOK = false;
			}
			try {
				this.verwalter.getAusleiherVerwalter().getAusleiher().setPlz(this.hinzuPanel.getPlzField().getText());
			} catch (Exception ex)
			{
				Message.raise("Bitte prüfen Sie den Titel", Message.ROT);
				eingabeOK = false;
			}
			try {
				this.verwalter.getAusleiherVerwalter().getAusleiher().setStadt(this.hinzuPanel.getStadtField().getText());
			} catch (Exception ex)
			{
				Message.raise("Bitte prüfen Sie den Verlag", Message.ROT);
				eingabeOK = false;
			}

			if (eingabeOK) {
				this.verwalter.personBearbeiten();
				this.verwalter.holeUpdateInfo().setzeAenderungOk(true);
			}
			this.verwalter.holeUpdateInfo().setzeUpdateSperre(false);

		}
	}
}
