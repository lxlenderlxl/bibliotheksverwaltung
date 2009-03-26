/**
 *
 */
package bibliotheksverwaltung.model.daos.dao;

public interface LoginDAO {

	public boolean pruefeLogin(String name, String passwortHash);

}
