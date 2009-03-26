/**
 *
 */
package bibliotheksverwaltung.model.logic;

import java.util.Observable;

import bibliotheksverwaltung.model.daos.dao.MySQLLoginDAO;
import bibliotheksverwaltung.model.domain.Login;
import bibliotheksverwaltung.util.UpdateInfo;

public class LoginVerwalter extends Observable {

	private UpdateInfo updateInfo = new UpdateInfo();
	private boolean loggedIn = false;

	public void pruefeLogin(Login login) {
		updateInfo.setzeAenderung("Login");
		loggedIn = new MySQLLoginDAO().pruefeLogin(login.getName(), login.getPasswortHash());
		this.setChanged();
		this.notifyObservers(updateInfo);
	}

	public UpdateInfo holeUpdateInfo() {
		return updateInfo;
	}

	/**
	 * @return the loggedIn
	 */
	public boolean isLoggedIn() {
		return loggedIn;
	}
}
