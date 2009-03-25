/**
 *
 */
package bibliotheksverwaltung.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import bibliotheksverwaltung.model.domain.Exemplar;
import bibliotheksverwaltung.model.logic.BibliotheksVerwalter;

public class BuchLoeschenListener implements ActionListener
{
	private BibliotheksVerwalter verwalter = null;
	private Exemplar exemplar = null;

	public BuchLoeschenListener(BibliotheksVerwalter derVerwalter, Exemplar dasExemplar) {
		this.verwalter = derVerwalter;
		this.exemplar = dasExemplar;
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
			verwalter.getMedienVerwalter().getExemplarVerwalter().setExemplar(exemplar);
			verwalter.buchEntfernen();
			verwalter.holeUpdateInfo().setzeAenderungOk(true);
			verwalter.holeUpdateInfo().setzeUpdateSperre(false);
		}
	}

}
