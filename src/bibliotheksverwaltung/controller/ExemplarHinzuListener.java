/**
 * 
 */
package bibliotheksverwaltung.controller;

import java.awt.event.ActionListener;


import bibliotheksverwaltung.model.domain.Exemplar;
import bibliotheksverwaltung.model.logic.MedienVerwalter;

public class ExemplarHinzuListener implements ActionListener
{
	private MedienVerwalter v1 = null;

	public ExemplarHinzuListener(MedienVerwalter v1) {
		this.v1 = v1;
	}

	public void actionPerformed(java.awt.event.ActionEvent event) {
		if (!v1.holeUpdateInfo().holeUpdateSperre())
		{
			v1.holeUpdateInfo().setzeUpdateSperre(true);
			v1.getExemplarVerwalter().add(new Exemplar(1,v1.getMedium().getId()));
			v1.holeUpdateInfo().setzeAenderungOk(true);   
			v1.holeUpdateInfo().setzeUpdateSperre(false);
		}
	}
}
