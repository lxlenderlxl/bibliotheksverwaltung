/**
 * 
 */
package bibliotheksverwaltung.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import bibliotheksverwaltung.model.domain.Exemplar;
import bibliotheksverwaltung.model.logic.BibliotheksVerwalter;
import bibliotheksverwaltung.model.logic.MedienVerwalter;

public class BuchAusleihenListener implements ActionListener
{
	private Exemplar exemplar = null;
	
	public BuchAusleihenListener(MedienVerwalter derVerwalter, Exemplar dasExemplar)
	{
		this.exemplar = dasExemplar;
	}
	/* (non-Javadoc)
	 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
	@Override
	public void actionPerformed(ActionEvent e)
	{
		//TODO AUSLEIHVORGANG (ausleiher fehlt)	
	}

}
