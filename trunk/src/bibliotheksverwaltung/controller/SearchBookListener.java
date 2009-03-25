/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package bibliotheksverwaltung.controller;

import java.awt.event.ActionListener;

import javax.swing.JTextField;

import bibliotheksverwaltung.model.logic.BibliotheksVerwalter;

/**
 *
 * @author Max
 */
public class SearchBookListener implements ActionListener {

	private BibliotheksVerwalter verwalter = null;
	private JTextField feld = null;

	public SearchBookListener(BibliotheksVerwalter derVerwalter, JTextField suchFeld) {
		this.verwalter = derVerwalter;
		this.feld = suchFeld;
	}

	public void actionPerformed(java.awt.event.ActionEvent event) {
		if (!verwalter.holeUpdateInfo().holeUpdateSperre())
		{
			verwalter.holeUpdateInfo().setzeUpdateSperre(true);
			verwalter.getSuchVerwalter().sucheMedium(feld.getText());
			verwalter.holeUpdateInfo().setzeAenderungOk(true);   
			verwalter.holeUpdateInfo().setzeUpdateSperre(false);
		}
	}
}
