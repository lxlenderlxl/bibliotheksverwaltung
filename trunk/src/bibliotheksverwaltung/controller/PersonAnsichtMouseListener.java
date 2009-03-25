/**
 * 
 */
package bibliotheksverwaltung.controller;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import bibliotheksverwaltung.model.domain.Ausleiher;
import bibliotheksverwaltung.model.domain.Medium;
import bibliotheksverwaltung.model.logic.BibliotheksVerwalter;

public class PersonAnsichtMouseListener implements MouseListener
{
	private BibliotheksVerwalter verwalter = null;
	private Ausleiher ausleiher = null;

	public PersonAnsichtMouseListener(BibliotheksVerwalter derVerwalter, Ausleiher derAusleiher)
	{
		this.verwalter = derVerwalter;
		this.ausleiher = derAusleiher;
	}

	/* (non-Javadoc)
	 * @see java.awt.event.MouseListener#mouseClicked(java.awt.event.MouseEvent)
	 */
	@Override
	public void mouseClicked(MouseEvent e)
	{

	}

	/* (non-Javadoc)
	 * @see java.awt.event.MouseListener#mouseEntered(java.awt.event.MouseEvent)
	 */
	@Override
	public void mouseEntered(MouseEvent e)
	{

	}

	/* (non-Javadoc)
	 * @see java.awt.event.MouseListener#mouseExited(java.awt.event.MouseEvent)
	 */
	@Override
	public void mouseExited(MouseEvent e)
	{
		
	}

	/* (non-Javadoc)
	 * @see java.awt.event.MouseListener#mousePressed(java.awt.event.MouseEvent)
	 */
	@Override
	public void mousePressed(MouseEvent e)
	{
		
	}

	/* (non-Javadoc)
	 * @see java.awt.event.MouseListener#mouseReleased(java.awt.event.MouseEvent)
	 */
	@Override
	public void mouseReleased(MouseEvent e)
	{
		if (!verwalter.getMedienVerwalter().holeUpdateInfo().holeUpdateSperre())
		{
			verwalter.getAusleiherVerwalter().holeUpdateInfo().setzeUpdateSperre(true);
			verwalter.getAusleiherVerwalter().setAusleiher(this.ausleiher);
			verwalter.getAusleiherVerwalter().autoNotify("PersonenEinzelAnsicht");
			verwalter.getAusleiherVerwalter().holeUpdateInfo().setzeAenderungOk(true);   
			verwalter.getAusleiherVerwalter().holeUpdateInfo().setzeUpdateSperre(false);
		}	
	}
}
