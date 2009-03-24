/**
 * 
 */
package bibliotheksverwaltung.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import bibliotheksverwaltung.model.logic.BibliotheksVerwalter;

public class SearchActionListener implements ActionListener
{
	private BibliotheksVerwalter verwalter = null;
	
	public SearchActionListener(BibliotheksVerwalter derVerwalter)
	{
		this.verwalter = derVerwalter;
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
			this.verwalter.autoNotify("Suche");
			verwalter.holeUpdateInfo().setzeAenderungOk(true);   
			verwalter.holeUpdateInfo().setzeUpdateSperre(false);
		}
	}

}
