/**
 *
 */
package bibliotheksverwaltung.util;

import bibliotheksverwaltung.view.BibliotheksGUI;

/**
 * @author Sven Blaurock 04.03.2009 13:28:52
 *
 */
public class Message {

	public static final int GRUEN = 1;
	public static final int GELB = 2;
	public static final int ROT = 3;

	private static BibliotheksGUI gui;

	/**
	 *
	 */
	public static void raise(String message, int level) {
		if (gui != null)
			gui.showInfoBox(level, message);
	}

	public static void setGUI(BibliotheksGUI dieGui) {
		if (gui == null)
			gui = dieGui;
	}

}
