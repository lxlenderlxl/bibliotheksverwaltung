/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package bibliotheksverwaltung.controller;

import java.awt.event.ActionListener;

import javax.swing.JTextField;

import bibliotheksverwaltung.model.logic.SuchVerwalter;

/**
 *
 * @author Max
 */
public class TestListener implements ActionListener {

	private SuchVerwalter v1 = null;
	private JTextField feld = null;

	public TestListener(SuchVerwalter v1, JTextField suchFeld) {
		this.v1 = v1;
		this.feld = suchFeld;
	}

	public void actionPerformed(java.awt.event.ActionEvent event) {
		if (!v1.holeUpdateInfo().holeUpdateSperre())
		{
			v1.holeUpdateInfo().setzeUpdateSperre(true);
			v1.sucheMedium(feld.getText());
			v1.holeUpdateInfo().setzeÄnderungOk(true);   
			v1.holeUpdateInfo().setzeUpdateSperre(false);
		}
	}
}
