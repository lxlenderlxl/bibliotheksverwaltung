/**
 * @author Sven Terzyk, Max Beier, Sven Blaurock
 */
package bibliotheksverwaltung.model.domain;
/**
 * Diese Klasse Realisiert den Login, sie besitzt ein Namen und ein dazugehöriges passwort.
 */
public class Login {
	/**
	 * NAME
	 */
	private String name;
	/**
	 * Passwort
	 */
	private String passwortHash;

	//Konstruktor
	public Login(String name, String passwortHash) {
		this.name = name;
		this.passwortHash = passwortHash;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @return the passwortHash
	 */
	public String getPasswortHash() {
		return passwortHash;
	}

}
