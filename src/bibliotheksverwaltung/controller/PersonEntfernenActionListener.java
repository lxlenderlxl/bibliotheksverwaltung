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

public class PersonEntfernenActionListener implements ActionListener
{
	private BibliotheksVerwalter verwalter = null;

	public PersonEntfernenActionListener(BibliotheksVerwalter derVerwalter) {
		this.verwalter = derVerwalter;
	}

	/* (non-Javadoc)
	 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
	@Override
	public void actionPerformed(ActionEvent e)
	{
		if (!verwalter.holeUpdateInfo().holeUpdateSperre())
		{
			this.verwalter.getAusleiherVerwalter().add();
			this.verwalter.holeUpdateInfo().setzeAenderungOk(true);
			this.verwalter.entferneAusleiher();
			this.verwalter.holeUpdateInfo().setzeUpdateSperre(false);
		}
	}
}
