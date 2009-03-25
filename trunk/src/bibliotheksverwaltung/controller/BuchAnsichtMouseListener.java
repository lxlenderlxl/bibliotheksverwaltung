/**
 *
 */
package bibliotheksverwaltung.controller;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import bibliotheksverwaltung.model.domain.Medium;
import bibliotheksverwaltung.model.logic.BibliotheksVerwalter;

public class BuchAnsichtMouseListener implements MouseListener
{
	private BibliotheksVerwalter verwalter = null;
	private Medium medium = null;

	public BuchAnsichtMouseListener(BibliotheksVerwalter derVerwalter, Medium dasMedium)
	{
		this.verwalter = derVerwalter;
		medium = dasMedium;
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
			verwalter.getMedienVerwalter().holeUpdateInfo().setzeUpdateSperre(true);
			verwalter.getMedienVerwalter().setMedium(this.medium);
			verwalter.getMedienVerwalter().autoNotify("BuchEinzelAnsicht");
			verwalter.getMedienVerwalter().holeUpdateInfo().setzeAenderungOk(true);
			verwalter.getMedienVerwalter().holeUpdateInfo().setzeUpdateSperre(false);
		}
	}

}
