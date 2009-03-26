/**
 *
 */
package bibliotheksverwaltung.model.domain;

public class Login {

	private String name;
	private String passwortHash;

	/**
	 *
	 */
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
