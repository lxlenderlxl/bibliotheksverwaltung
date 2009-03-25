/**
 * 
 */
package bibliotheksverwaltung.controller;

import java.awt.event.ActionListener;

import bibliotheksverwaltung.model.domain.Exemplar;
import bibliotheksverwaltung.model.logic.BibliotheksVerwalter;

public class BuchVerlaengernListener implements ActionListener
{
	private BibliotheksVerwalter verwalter = null;
	private Exemplar exemplar = null;

	public BuchVerlaengernListener(BibliotheksVerwalter derVerwalter, Exemplar dasExemplar) {
		this.verwalter = derVerwalter;
		this.exemplar = dasExemplar;
	}

	public void actionPerformed(java.awt.event.ActionEvent event) {
		if (!verwalter.holeUpdateInfo().holeUpdateSperre())
		{
			verwalter.holeUpdateInfo().setzeUpdateSperre(true);
			verwalter.getMedienVerwalter().getExemplarVerwalter().setExemplar(exemplar);
			verwalter.buchVerlaengern();
			verwalter.holeUpdateInfo().setzeAenderungOk(true);   
			verwalter.holeUpdateInfo().setzeUpdateSperre(false);
		}
	}
}
