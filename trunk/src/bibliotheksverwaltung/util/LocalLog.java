/**
 *
 */
package bibliotheksverwaltung.util;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.GregorianCalendar;

public class LocalLog {


	/**
	 *
	 */
	public static void add(String message) {
		add(message, null);
	}

	/**
	 *
	 */
	public static void add(String message, Object objekt) {

		File file = new File("ErrorLog.txt"); // Präziser Pfad: this.getClass().getResource("/").toString().replace("file:/", "") +
		if(!file.exists()) {
			try {
				file.createNewFile();
			} catch (IOException e) {
				System.out.println("ErrorLog-Datei konnte nicht geschrieben werden.");
			}
		}
		PrintStream stream;
		try {
			stream = new PrintStream(new FileOutputStream(file, true));
			stream.println(new GregorianCalendar().getTime() + "\t" + message + (objekt != null ? "\t in " + objekt.getClass() : ""));
			stream.close();
		} catch (FileNotFoundException e) {
			System.out.println("ErrorLog konnte nicht beschrieben werden.");
		}
	}

}
