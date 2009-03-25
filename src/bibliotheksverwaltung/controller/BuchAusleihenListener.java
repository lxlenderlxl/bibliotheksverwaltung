/**
 *
 */
package bibliotheksverwaltung.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import bibliotheksverwaltung.model.domain.Ausleiher;
import bibliotheksverwaltung.model.domain.Exemplar;
import bibliotheksverwaltung.model.logic.BibliotheksVerwalter;

public class BuchAusleihenListener implements ActionListener
{
	private BibliotheksVerwalter verwalter = null;
	private Exemplar exemplar = null;

	public BuchAusleihenListener(BibliotheksVerwalter derVerwalter, Exemplar dasExemplar)
	{
		this.verwalter = derVerwalter;
		this.exemplar = dasExemplar;
	}
	/* (non-Javadoc)
	 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
	@Override
	public void actionPerformed(ActionEvent e)
	{
		//TODO AUSLEIHVORGANG (ausleiher fehlt)	AUSLEIHER ersetzen
		if (!verwalter.holeUpdateInfo().holeUpdateSperre())
		{
			verwalter.holeUpdateInfo().setzeUpdateSperre(true);
			verwalter.getMedienVerwalter().getExemplarVerwalter().setExemplar(exemplar);
			verwalter.getAusleiherVerwalter().setAusleiher(new Ausleiher(2));
			verwalter.buchAusleihen();
			verwalter.holeUpdateInfo().setzeAenderungOk(true);
			verwalter.holeUpdateInfo().setzeUpdateSperre(false);
		}
	}

}
