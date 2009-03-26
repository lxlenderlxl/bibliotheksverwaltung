/**
 *
 */
package bibliotheksverwaltung.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;

import bibliotheksverwaltung.model.domain.Login;
import bibliotheksverwaltung.model.logic.LoginVerwalter;
import bibliotheksverwaltung.util.MD5Generator;

public class LoginActionListener implements ActionListener {

	private LoginVerwalter verwalter = null;
	private JTextField nameField;
	private JTextField passwortField;

	/**
	 *
	 */
	public LoginActionListener(LoginVerwalter verwalter, JTextField nameField, JTextField passwortField) {
		this.verwalter = verwalter;
		this.nameField = nameField;
		this.passwortField = passwortField;
	}

	/* (non-Javadoc)
	 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		if (!verwalter.holeUpdateInfo().holeUpdateSperre())
		{
			verwalter.holeUpdateInfo().setzeUpdateSperre(true);
			this.verwalter.pruefeLogin(
					new Login(nameField.getText(),
					MD5Generator.getInstance().hashData(passwortField.getText()))
			);
			verwalter.holeUpdateInfo().setzeAenderungOk(true);
			verwalter.holeUpdateInfo().setzeUpdateSperre(false);
		}
	}

}
