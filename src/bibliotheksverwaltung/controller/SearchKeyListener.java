/**
 *
 */
package bibliotheksverwaltung.controller;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JTextField;

import bibliotheksverwaltung.model.logic.BibliotheksVerwalter;

public class SearchKeyListener implements KeyListener {

	private BibliotheksVerwalter verwalter = null;
	private JTextField feld = null;

	public SearchKeyListener(BibliotheksVerwalter derVerwalter, JTextField suchFeld) {
		this.verwalter = derVerwalter;
		this.feld = suchFeld;
	}

	/* (non-Javadoc)
	 * @see java.awt.event.KeyListener#keyPressed(java.awt.event.KeyEvent)
	 */
	@Override
	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == 10 && e.isControlDown())
			new SearchPersonListener(verwalter, feld).actionPerformed(null);
		else if (e.getKeyCode() == 10)
			new SearchBookListener(verwalter, feld).actionPerformed(null);
		//TODO Bereits getätigte Eingabe bereinigen? feld.setText(feld.getText().replace(<alle sonderzeichen>))
	}

	/* (non-Javadoc)
	 * @see java.awt.event.KeyListener#keyReleased(java.awt.event.KeyEvent)
	 */
	@Override
	public void keyReleased(KeyEvent e) {
		// nischt
	}

	/* (non-Javadoc)
	 * @see java.awt.event.KeyListener#keyTyped(java.awt.event.KeyEvent)
	 */
	@Override
	public void keyTyped(KeyEvent e) {
		// nischt
	}

}
