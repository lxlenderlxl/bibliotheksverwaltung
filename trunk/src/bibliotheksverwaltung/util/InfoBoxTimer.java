/**
 *
 */
package bibliotheksverwaltung.util;

import java.util.TimerTask;

import bibliotheksverwaltung.view.BibliotheksGUI;

public class InfoBoxTimer extends TimerTask {

	private BibliotheksGUI gui;

	/**
	 *
	 */
	public InfoBoxTimer(BibliotheksGUI gui) {
		this.gui = gui;
	}

	/* (non-Javadoc)
	 * @see java.util.TimerTask#run()
	 */
	@Override
	public void run() {
		gui.showInfoBox(0, "");
	}


}
