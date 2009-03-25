/**
 *
 */
package bibliotheksverwaltung.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import bibliotheksverwaltung.model.logic.BibliotheksVerwalter;

public class DatenBearbeitenAbbrechenListener implements ActionListener
{
	private BibliotheksVerwalter verwalter = null;

	public DatenBearbeitenAbbrechenListener(BibliotheksVerwalter derVerwalter) {
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
			verwalter.holeUpdateInfo().setzeUpdateSperre(true);
			verwalter.autoNotify("Abbrechen");
			verwalter.holeUpdateInfo().setzeAenderungOk(true);
			verwalter.holeUpdateInfo().setzeUpdateSperre(false);
		}
	}
}
