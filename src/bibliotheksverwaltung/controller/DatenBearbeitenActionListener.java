/**
 * 
 */
package bibliotheksverwaltung.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import bibliotheksverwaltung.model.domain.Ausleiher;
import bibliotheksverwaltung.model.domain.Exemplar;
import bibliotheksverwaltung.model.logic.BibliotheksVerwalter;

public class DatenBearbeitenActionListener implements ActionListener
{
	private BibliotheksVerwalter verwalter = null;
	
	public DatenBearbeitenActionListener(BibliotheksVerwalter derVerwalter)
	{
		this.verwalter = derVerwalter;
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
			verwalter.autoNotify("DatenBearbeiten");
			verwalter.holeUpdateInfo().setzeAenderungOk(true);   
			verwalter.holeUpdateInfo().setzeUpdateSperre(false);
		}
	}
}
