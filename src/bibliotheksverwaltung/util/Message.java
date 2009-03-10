/**
 *
 */
package bibliotheksverwaltung.util;

/**
 * @author Sven Blaurock 04.03.2009 13:28:52
 *
 */
public class Message {

	/** Das Nachrichten-Level der Nachricht - 1 = gut, 2 = neutral, 3 = schlecht **/
	private static final int SCHLECHT = 3;

	public static void print(String message) {
		//TODO Fehlernachricht an Fehlermethode in GUI weiterreichen
		// gui.showMessage(message, SCHLECHT);
	}

}
