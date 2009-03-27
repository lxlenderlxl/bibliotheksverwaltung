/**
 * 
 */
package bibliotheksverwaltung.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import bibliotheksverwaltung.model.domain.Ausleiher;
import bibliotheksverwaltung.model.logic.BibliotheksVerwalter;
import bibliotheksverwaltung.util.Message;
import bibliotheksverwaltung.view.PersonHinzufuegenPanel;

public class PersonHinzuActionListener implements ActionListener
{
	private BibliotheksVerwalter verwalter = null;
	private PersonHinzufuegenPanel hinzuPanel = null;

	public PersonHinzuActionListener(BibliotheksVerwalter derVerwalter, PersonHinzufuegenPanel dasHinzuPanel) {
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
			this.verwalter.getAusleiherVerwalter().setAusleiher(new Ausleiher());
			this.verwalter.holeUpdateInfo().setzeUpdateSperre(true);
			try {
				this.verwalter.getAusleiherVerwalter().getAusleiher().setVorName(this.hinzuPanel.getVornameField().getText());
			} catch (Exception ex)
			{
				Message.raise("Bitte pruefen Sie den Vornamen", Message.ROT);
				eingabeOK = false;
			}
			try {
				this.verwalter.getAusleiherVerwalter().getAusleiher().setNachName(this.hinzuPanel.getNachnameField().getText());
			} catch (Exception ex)
			{
				Message.raise("Bitte pruefen Sie den Nachnamen", Message.ROT);
				eingabeOK = false;
			}
			try {
				this.verwalter.getAusleiherVerwalter().getAusleiher().setStrasse(this.hinzuPanel.getStrasseField().getText());
			} catch (Exception ex)
			{
				Message.raise("Bitte pruefen Sie die Strasse", Message.ROT);
				eingabeOK = false;
			}
			try {
				this.verwalter.getAusleiherVerwalter().getAusleiher().setHausnummer(this.hinzuPanel.getHausnummerField().getText());
			} catch (Exception ex)
			{
				Message.raise("Bitte pruefen Sie die Hausnummer", Message.ROT);
				eingabeOK = false;
			}
			try {
				this.verwalter.getAusleiherVerwalter().getAusleiher().setPlz(this.hinzuPanel.getPlzField().getText());
			} catch (Exception ex)
			{
				Message.raise("Bitte pruefen Sie die PLZ", Message.ROT);
				eingabeOK = false;
			}
			try {
				this.verwalter.getAusleiherVerwalter().getAusleiher().setStadt(this.hinzuPanel.getStadtField().getText());
			} catch (Exception ex)
			{
				Message.raise("Bitte pruefen Sie die Stadt", Message.ROT);
				eingabeOK = false;
			}

			if (eingabeOK) {
				this.verwalter.getAusleiherVerwalter().add();
				this.verwalter.holeUpdateInfo().setzeAenderungOk(true);
			}
			this.verwalter.holeUpdateInfo().setzeUpdateSperre(false);

		}
	}
}
