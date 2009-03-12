/**
 *
 */
package bibliotheksverwaltung.util;

/**
 * @author Sven Blaurock 04.03.2009 13:28:52
 *
 */
public class Message {

	public static final int GRUEN = 1;
	public static final int GELB = 2;
	public static final int ROT = 3;

	/**
	 *
	 */
	public static void raise(String message, int level) {
		//TODO Fehlernachricht an Fehlermethode in GUI weiterreichen
		System.out.println("Message: " + message + " - Level: " + level);
	}

}
