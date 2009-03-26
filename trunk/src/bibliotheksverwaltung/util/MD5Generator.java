/**
 *
 */
package bibliotheksverwaltung.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MD5Generator
{

	private MessageDigest md = null;
	static private MD5Generator md5 = null;
	private static final char[] hexChars ={'0','1','2','3','4','5','6','7','8','9','A','B','C','D','E','F'};

	/**
	 * Constructor is private so you must use the getInstance method
	 */
	private MD5Generator() {
		try {
			md = MessageDigest.getInstance("MD5");
		} catch (NoSuchAlgorithmException e) {
			LocalEnvironment.log("Fehler beim Erzeugen des MD5-Hashs.");
		}
	}

	/**
	 * This returns the singleton instance
	 */
	public static MD5Generator getInstance() {
		if (md5 == null)
			md5 = new MD5Generator();

		return (md5);
	}


	public String hashData(String dataToHash) {
		return hashData(dataToHash.getBytes());
	}

	public String hashData(byte[] dataToHash) {
		return hexStringFromBytes((calculateHash(dataToHash)));
	}

	private byte[] calculateHash(byte[] dataToHash) {
		md.update(dataToHash, 0, dataToHash.length);

		return (md.digest());
	}

	public String hexStringFromBytes(byte[] b) {
		String hex = "";
		int msb;
		int lsb = 0;
		int i;

		// MSB maps to idx 0
		for (i = 0; i < b.length; i++) {
			msb = ((int)b[i] & 0x000000FF) / 16;

			lsb = ((int)b[i] & 0x000000FF) % 16;
			hex = hex + hexChars[msb] + hexChars[lsb];
		}
		return(hex);
	}
}
