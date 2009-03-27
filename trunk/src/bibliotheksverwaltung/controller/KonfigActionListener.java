/**
 *
 */
package bibliotheksverwaltung.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import bibliotheksverwaltung.model.logic.BibliotheksVerwalter;

public class KonfigActionListener implements ActionListener {

	BibliotheksVerwalter verwalter = null;

	/**
	 *
	 */
	public KonfigActionListener(BibliotheksVerwalter verwalter) {
		this.verwalter = verwalter;
	}

	/* (non-Javadoc)
	 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		if (!verwalter.holeUpdateInfo().holeUpdateSperre()) {
			verwalter.holeUpdateInfo().setzeUpdateSperre(true);
			this.verwalter.autoNotify("Konfiguration");
			verwalter.holeUpdateInfo().setzeAenderungOk(true);
			verwalter.holeUpdateInfo().setzeUpdateSperre(false);
		}
	}

}
