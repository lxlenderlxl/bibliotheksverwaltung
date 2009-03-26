/**
 * 
 */
package bibliotheksverwaltung.controller;

import java.awt.event.ActionListener;

import bibliotheksverwaltung.model.domain.Exemplar;
import bibliotheksverwaltung.model.logic.BibliotheksVerwalter;

public class BuchHistorieActionListener implements ActionListener
{
	private BibliotheksVerwalter verwalter = null;

	public BuchHistorieActionListener(BibliotheksVerwalter derVerwalter) {
		this.verwalter = derVerwalter;
	}

	public void actionPerformed(java.awt.event.ActionEvent event) {
		if (!verwalter.holeUpdateInfo().holeUpdateSperre())
		{
			verwalter.holeUpdateInfo().setzeUpdateSperre(true);
			verwalter.getHistorienVerwalter().erzeugeLogs(this.verwalter.getMedienVerwalter().getMedium());
			verwalter.holeUpdateInfo().setzeAenderungOk(true);
			verwalter.holeUpdateInfo().setzeUpdateSperre(false);
		}
	}
}
