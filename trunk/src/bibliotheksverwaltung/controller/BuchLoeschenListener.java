/**
 * 
 */
package bibliotheksverwaltung.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import bibliotheksverwaltung.model.domain.Exemplar;
import bibliotheksverwaltung.model.logic.MedienVerwalter;

public class BuchLoeschenListener implements ActionListener
{
	private MedienVerwalter v1 = null;
	private Exemplar exemplar = null;

	public BuchLoeschenListener(MedienVerwalter v1, Exemplar dasExemplar) {
		this.v1 = v1;
		this.exemplar = dasExemplar;
	}

	/* (non-Javadoc)
	 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
	@Override
	public void actionPerformed(ActionEvent e)
	{
		if (!v1.holeUpdateInfo().holeUpdateSperre())
		{
			v1.holeUpdateInfo().setzeUpdateSperre(true);
			v1.getExemplarVerwalter().delete(this.exemplar);
			v1.holeUpdateInfo().setzeAenderungOk(true);   
			v1.holeUpdateInfo().setzeUpdateSperre(false);
		}
	}

}
