/**
 * 
 */
package bibliotheksverwaltung.controller;

import java.awt.event.ActionListener;

import bibliotheksverwaltung.model.logic.BibliotheksVerwalter;

public class PersonHistorieActionListener implements ActionListener
{
	private BibliotheksVerwalter verwalter = null;

	public PersonHistorieActionListener(BibliotheksVerwalter derVerwalter) {
		this.verwalter = derVerwalter;
	}

	public void actionPerformed(java.awt.event.ActionEvent event) {
		if (!verwalter.holeUpdateInfo().holeUpdateSperre())
		{
			verwalter.holeUpdateInfo().setzeUpdateSperre(true);
			verwalter.getHistorienVerwalter().erzeugeLogs(this.verwalter.getAusleiherVerwalter().getAusleiher());
			verwalter.holeUpdateInfo().setzeAenderungOk(true);
			verwalter.holeUpdateInfo().setzeUpdateSperre(false);
		}
	}
}
