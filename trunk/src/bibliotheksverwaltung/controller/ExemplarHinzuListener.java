/**
 * 
 */
package bibliotheksverwaltung.controller;

import java.awt.event.ActionListener;


import bibliotheksverwaltung.model.domain.Exemplar;
import bibliotheksverwaltung.model.logic.BibliotheksVerwalter;
import bibliotheksverwaltung.model.logic.MedienVerwalter;

public class ExemplarHinzuListener implements ActionListener
{
	private BibliotheksVerwalter verwalter = null;

	public ExemplarHinzuListener(BibliotheksVerwalter derVerwalter) {
		this.verwalter = derVerwalter;
	}

	public void actionPerformed(java.awt.event.ActionEvent event) {
		if (!verwalter.holeUpdateInfo().holeUpdateSperre())
		{
			verwalter.holeUpdateInfo().setzeUpdateSperre(true);
			verwalter.getMedienVerwalter().getExemplarVerwalter().setExemplar(new Exemplar(1, verwalter.getMedienVerwalter().getMedium().getId()));
			verwalter.buchHinzufuegen();
			verwalter.holeUpdateInfo().setzeAenderungOk(true);   
			verwalter.holeUpdateInfo().setzeUpdateSperre(false);
		}
	}
}
