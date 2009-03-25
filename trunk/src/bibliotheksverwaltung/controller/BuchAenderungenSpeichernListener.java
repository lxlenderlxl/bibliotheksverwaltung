/**
 * 
 */
package bibliotheksverwaltung.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import bibliotheksverwaltung.model.domain.Exemplar;
import bibliotheksverwaltung.model.domain.Medium;
import bibliotheksverwaltung.model.logic.BibliotheksVerwalter;
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
			this.verwalter.holeUpdateInfo().setzeUpdateSperre(true);
			this.verwalter.mediumBearbeiten();
			this.verwalter.holeUpdateInfo().setzeAenderungOk(true);   
			this.verwalter.holeUpdateInfo().setzeUpdateSperre(false);
		}
	}
}
