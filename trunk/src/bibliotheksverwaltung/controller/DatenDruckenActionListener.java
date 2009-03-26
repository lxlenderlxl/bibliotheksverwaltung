/**
 * 
 */
package bibliotheksverwaltung.controller;

import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JPanel;

import com.lowagie.text.DocumentException;

import bibliotheksverwaltung.model.domain.Medium;
import bibliotheksverwaltung.model.logic.BibliotheksVerwalter;
import bibliotheksverwaltung.view.BuchAnsicht;
import bibliotheksverwaltung.view.OutputArea;

public class DatenDruckenActionListener implements ActionListener
{
	private BibliotheksVerwalter verwalter = null;

	public DatenDruckenActionListener(BibliotheksVerwalter derVerwalter) {
		this.verwalter = derVerwalter;
	}

	public void actionPerformed(java.awt.event.ActionEvent event) {
		this.verwalter.getDruckVerwalter().druckTest();		
	}
}
