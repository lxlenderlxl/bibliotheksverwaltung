/**
 *
 */
package bibliotheksverwaltung.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import bibliotheksverwaltung.model.logic.BibliotheksVerwalter;
import bibliotheksverwaltung.util.Message;
import bibliotheksverwaltung.view.BuchHinzufuegenPanel;

public class BuchAenderungenSpeichernListener implements ActionListener
{
	private BibliotheksVerwalter verwalter = null;
	private BuchHinzufuegenPanel hinzuPanel = null;

	public BuchAenderungenSpeichernListener(BibliotheksVerwalter derVerwalter, BuchHinzufuegenPanel dasHinzuPanel) {
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
				this.verwalter.getMedienVerwalter().getMedium().setAutorNachname(this.hinzuPanel.getNachnameField().getText());
			} catch (Exception ex)
			{
				Message.raise("Bitte pr�fen Sie den Autor-Nachnamen", Message.ROT);
				eingabeOK = false;
			}
			try {
				this.verwalter.getMedienVerwalter().getMedium().setAutorVorname(this.hinzuPanel.getVornameField().getText());
			} catch (Exception ex)
			{
				Message.raise("Bitte pr�fen Sie den Autor-Vornamen", Message.ROT);
				eingabeOK = false;
			}
			try {
				this.verwalter.getMedienVerwalter().getMedium().setErscheinungsJahr(Integer.valueOf(this.hinzuPanel.getJahrField().getText()));
			} catch (Exception ex)
			{
				Message.raise("Bitte pr�fen Sie das Erscheinungsjahr", Message.ROT);
				eingabeOK = false;
			}
			try {
				this.verwalter.getMedienVerwalter().getMedium().setIsbn(this.hinzuPanel.getIsbnField().getText());
			} catch (Exception ex)
			{
				Message.raise("Bitte pr�fen Sie die ISBN", Message.ROT);
				eingabeOK = false;
			}
			try {
				this.verwalter.getMedienVerwalter().getMedium().setTitel(this.hinzuPanel.getTitelField().getText());
			} catch (Exception ex)
			{
				Message.raise("Bitte pr�fen Sie den Titel", Message.ROT);
				eingabeOK = false;
			}
			try {
				this.verwalter.getMedienVerwalter().getMedium().setVerlag(this.hinzuPanel.getVerlagField().getText());
			} catch (Exception ex)
			{
				Message.raise("Bitte pr�fen Sie den Verlag", Message.ROT);
				eingabeOK = false;
			}

			if (eingabeOK) {
				this.verwalter.mediumBearbeiten();
				this.verwalter.holeUpdateInfo().setzeAenderungOk(true);
			}
			this.verwalter.holeUpdateInfo().setzeUpdateSperre(false);

		}
	}
}
