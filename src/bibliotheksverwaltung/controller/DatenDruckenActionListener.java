/**
 * 
 */
package bibliotheksverwaltung.controller;

import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JPanel;

import bibliotheksverwaltung.model.domain.Medium;
import bibliotheksverwaltung.model.logic.BibliotheksVerwalter;
import bibliotheksverwaltung.view.BuchAnsicht;
import bibliotheksverwaltung.view.OutputArea;

public class DatenDruckenActionListener implements ActionListener
{
	private BibliotheksVerwalter verwalter = null;

	public DatenDruckenActionListener(BibliotheksVerwalter derVerwalter) {
		this.verwalter = derVerwalter;
	}

	public void actionPerformed(java.awt.event.ActionEvent event) {
//		if (!verwalter.holeUpdateInfo().holeUpdateSperre())
//		{
//			verwalter.holeUpdateInfo().setzeUpdateSperre(true);
//			verwalter.getHistorienVerwalter().erzeugeLogs(this.verwalter.getMedienVerwalter().getMedium());
//			verwalter.holeUpdateInfo().setzeAenderungOk(true);
//			verwalter.holeUpdateInfo().setzeUpdateSperre(false);
//		}
		
	}
}
