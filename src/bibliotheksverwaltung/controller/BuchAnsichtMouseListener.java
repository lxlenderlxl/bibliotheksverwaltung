/**
 * 
 */
package bibliotheksverwaltung.controller;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import bibliotheksverwaltung.model.domain.Medium;
import bibliotheksverwaltung.model.logic.MedienVerwalter;

public class BuchAnsichtMouseListener implements MouseListener
{
	private MedienVerwalter verwalter = null;

	public BuchAnsichtMouseListener(MedienVerwalter derVerwalter, Medium dasMedium)
	{
		this.verwalter = derVerwalter;
		verwalter.setMedium(dasMedium);
	}

	/* (non-Javadoc)
	 * @see java.awt.event.MouseListener#mouseClicked(java.awt.event.MouseEvent)
	 */
	@Override
	public void mouseClicked(MouseEvent e)
	{
		verwalter.holeUpdateInfo().setzeUpdateSperre(true);
		System.out.println("Mouselistener");
		verwalter.erzeugeExemplare(this.verwalter.getMedium());
		verwalter.holeUpdateInfo().setzeAenderungOk(true);   
		verwalter.holeUpdateInfo().setzeUpdateSperre(false);
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
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see java.awt.event.MouseListener#mousePressed(java.awt.event.MouseEvent)
	 */
	@Override
	public void mousePressed(MouseEvent e)
	{
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see java.awt.event.MouseListener#mouseReleased(java.awt.event.MouseEvent)
	 */
	@Override
	public void mouseReleased(MouseEvent e)
	{
		
	}

}
