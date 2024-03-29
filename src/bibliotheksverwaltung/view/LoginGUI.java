/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * LoginGUI.java
 *
 * Created on 26.03.2009, 18:14:52
 */
package bibliotheksverwaltung.view;

import bibliotheksverwaltung.controller.LoginActionListener;
import java.util.Observable;
import java.util.Observer;

import javax.swing.UnsupportedLookAndFeelException;

import bibliotheksverwaltung.model.domain.Anwender;
import bibliotheksverwaltung.model.logic.LoginVerwalter;
import bibliotheksverwaltung.util.LocalEnvironment;
import bibliotheksverwaltung.util.UpdateInfo;
import java.awt.Dimension;
import java.awt.Toolkit;

/**
 * Die LoginGui dient zum authentifiziern von Benutzern um einen geschützten Zugang zum Programm zu gewährleisten
 * 
 * @author Max
 */
@SuppressWarnings("serial")
public class LoginGUI extends javax.swing.JFrame implements Observer {

	/**Bezeichnet den Verwalter*/
	private LoginVerwalter verwalter = new LoginVerwalter();

	/** Erzeugt ein neues LoginPanel */
	public LoginGUI() {
		try {
			javax.swing.UIManager.setLookAndFeel(new com.nilo.plaf.nimrod.NimRODLookAndFeel());
		} catch (UnsupportedLookAndFeelException e) {
			LocalEnvironment.log(e.getMessage(), this);
		}
		initComponents();
		this.loginButton.addActionListener(new LoginActionListener(verwalter, nameField, passwordField));
		verwalter.addObserver(this);
	}

	/** 
	 * Erzeugt die obigen Komponenten auf dem MainPanel
	 */
	@SuppressWarnings("unchecked")
	private void initComponents() {

		loginPanel = new javax.swing.JPanel();
		infoLabel = new javax.swing.JLabel();
		nameField = new javax.swing.JTextField();
		passwordField = new javax.swing.JPasswordField();
		loginButton = new javax.swing.JButton();
		loginButton1 = new javax.swing.JButton();

		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
		setTitle("Bibliotheksverwaltung");
		setResizable(false);
		setUndecorated(true);

		loginPanel.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(102, 102, 102), 3, true));

		infoLabel.setBackground(new java.awt.Color(173, 250, 102));
		infoLabel.setFont(new java.awt.Font("Arial", 0, 14));
		infoLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/bibliotheksverwaltung/view/images/comment_48.png"))); // NOI18N
		infoLabel.setText("Herzlich Willkommen.");
		infoLabel.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(51, 153, 0), 2, true));
		infoLabel.setOpaque(true);

		nameField.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
		nameField.setForeground(new java.awt.Color(204, 204, 204));
		nameField.setText("Name");
		nameField.addFocusListener(new java.awt.event.FocusAdapter() {
			public void focusGained(java.awt.event.FocusEvent evt) {
				nameFieldFocusGained(evt);
			}
			public void focusLost(java.awt.event.FocusEvent evt) {
				nameFieldFocusLost(evt);
			}
		});

		passwordField.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
		passwordField.setForeground(new java.awt.Color(204, 204, 204));
		passwordField.setText("Passwort");
		passwordField.addFocusListener(new java.awt.event.FocusAdapter() {
			public void focusGained(java.awt.event.FocusEvent evt) {
				passwordFieldFocusGained(evt);
			}
			public void focusLost(java.awt.event.FocusEvent evt) {
				passwordFieldFocusLost(evt);
			}
		});

		loginButton.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
		loginButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/bibliotheksverwaltung/view/images/lock_48.png"))); // NOI18N
		loginButton.setText("Einloggen");
		loginButton.setHorizontalAlignment(javax.swing.SwingConstants.LEADING);
		loginButton.setIconTextGap(10);
		loginButton.setMargin(new java.awt.Insets(2, 5, 2, 5));

		loginButton1.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
		loginButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/bibliotheksverwaltung/view/images/cancel_48.png"))); // NOI18N
		loginButton1.setContentAreaFilled(false);
		loginButton1.setHorizontalAlignment(javax.swing.SwingConstants.LEADING);
		loginButton1.setIconTextGap(10);
		loginButton1.setMargin(new java.awt.Insets(2, 2, 2, 2));
		loginButton1.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				loginButton1ActionPerformed(evt);
			}
		});

		javax.swing.GroupLayout loginPanelLayout = new javax.swing.GroupLayout(loginPanel);
		loginPanel.setLayout(loginPanelLayout);
		loginPanelLayout.setHorizontalGroup(
				loginPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(loginPanelLayout.createSequentialGroup()
						.addContainerGap()
						.addGroup(loginPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addComponent(passwordField, javax.swing.GroupLayout.DEFAULT_SIZE, 236, Short.MAX_VALUE)
								.addComponent(nameField, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 236, Short.MAX_VALUE)
								.addComponent(infoLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 236, Short.MAX_VALUE)
								.addGroup(loginPanelLayout.createSequentialGroup()
										.addComponent(loginButton, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
										.addComponent(loginButton1)))
										.addContainerGap())
		);
		loginPanelLayout.setVerticalGroup(
				loginPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(loginPanelLayout.createSequentialGroup()
						.addContainerGap()
						.addComponent(infoLabel)
						.addGap(18, 18, 18)
						.addComponent(nameField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
						.addGap(18, 18, 18)
						.addComponent(passwordField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
						.addGap(18, 18, 18)
						.addGroup(loginPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
								.addComponent(loginButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(loginButton))
								.addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(
				layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addComponent(loginPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
		);
		layout.setVerticalGroup(
				layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addComponent(loginPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
		);

		pack();
	}// </editor-fold>//GEN-END:initComponents

	private void nameFieldFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_nameFieldFocusGained
		if (nameField.getText().equals("Name")) {
			nameField.setText("");
			nameField.setForeground(new java.awt.Color(0, 0, 0));
		}
	}//GEN-LAST:event_nameFieldFocusGained

	private void nameFieldFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_nameFieldFocusLost
		if (nameField.getText().isEmpty()) {
			nameField.setForeground(new java.awt.Color(204, 204, 204));
			nameField.setText("Name");
		}
	}//GEN-LAST:event_nameFieldFocusLost

	private void loginButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loginButton1ActionPerformed
		this.dispose();
	}//GEN-LAST:event_loginButton1ActionPerformed

	private void passwordFieldFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_passwordFieldFocusGained
		if (passwordField.getText().equals("Passwort")) {
			passwordField.setText("");
			passwordField.setForeground(new java.awt.Color(0, 0, 0));
		}
	}//GEN-LAST:event_passwordFieldFocusGained

	private void passwordFieldFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_passwordFieldFocusLost
		if (passwordField.getPassword().length == 0) {
			passwordField.setForeground(new java.awt.Color(204, 204, 204));
			passwordField.setText("Passwort");
		}
	}//GEN-LAST:event_passwordFieldFocusLost

	/**
	 * Erzeugt die Ansicht
	 * @param args the command line arguments
	 */
	public static void main(String args[]) {
		java.awt.EventQueue.invokeLater(new Runnable() {

			public void run() {
				LoginGUI gui = new LoginGUI();
				Dimension ss = Toolkit.getDefaultToolkit().getScreenSize();
				gui.setLocation(ss.width / 2 - gui.getWidth() / 2, ss.height / 2 - gui.getHeight() / 2);
				gui.setVisible(true);
			}
		});
	}

	// Variables declaration - do not modify//GEN-BEGIN:variables
	private javax.swing.JLabel infoLabel;
	private javax.swing.JButton loginButton;
	private javax.swing.JButton loginButton1;
	private javax.swing.JPanel loginPanel;
	private javax.swing.JTextField nameField;
	private javax.swing.JPasswordField passwordField;
	// End of variables declaration//GEN-END:variables

	/* (non-Javadoc)
	 * @see java.util.Observer#update(java.util.Observable, java.lang.Object)
	 */
	@Override
	public void update(Observable arg0, Object arg1) {
		UpdateInfo updateInfo = (UpdateInfo) arg1;
		if (updateInfo.holeAenderung().equals("Login")) {
			if (updateInfo.holeAenderungOk()) {
				if (this.verwalter.isLoggedIn()) {
					this.dispose();
					LocalEnvironment.setAnwender(new Anwender(nameField.getText()));
					BibliotheksGUI gui = new BibliotheksGUI();
					Dimension ss = Toolkit.getDefaultToolkit().getScreenSize();
					gui.setLocation(ss.width / 2 - gui.getWidth() / 2, ss.height / 2 - gui.getHeight() / 2);
					gui.setVisible(true);
				} else {
					infoLabel.setText("<html>Zugriff verweigert.<br />Pruefen Sie Ihre Eingabe.");
					infoLabel.setBackground(new java.awt.Color(252, 98, 98));
					infoLabel.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 0, 0), 2, true));
					infoLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/bibliotheksverwaltung/view/images/warning_48.png")));
				}
			}

		}
	}
}
