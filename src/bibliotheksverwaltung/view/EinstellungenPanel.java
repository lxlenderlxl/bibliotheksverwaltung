/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * EinstellungenPanel.java
 *
 * Created on 20.03.2009, 14:03:27
 */

package bibliotheksverwaltung.view;

/**
 *
 * @author Max
 */
public class EinstellungenPanel extends javax.swing.JPanel {

	/** Erzeugt ein neues EinstellungenPanel */
	public EinstellungenPanel() {
		initComponents();
	}

	/** 
	 * Erzeugt die obigen Komponenten auf dem MainPanel
	 */
	@SuppressWarnings("unchecked")
	private void initComponents() {

		ausleihdauerLabel = new javax.swing.JLabel();
		verlaengerungenLabel = new javax.swing.JLabel();
		ausleihdauerField = new javax.swing.JTextField();
		verlaengerungenField = new javax.swing.JTextField();
		ausleihdauerSlider = new javax.swing.JSlider();
		verlaengerungenSlider = new javax.swing.JSlider();
		benutzerPane = new javax.swing.JScrollPane();
		benutzerPanel = new javax.swing.JPanel();
		nameField = new javax.swing.JTextField();
		passwordField = new javax.swing.JTextField();
		addButton = new javax.swing.JButton();
		benutzerSeparator = new javax.swing.JSeparator();
		cancelButton = new javax.swing.JButton();
		saveButton = new javax.swing.JButton();

		ausleihdauerLabel.setFont(new java.awt.Font("Arial", 1, 14));
		ausleihdauerLabel.setText("maximale Ausleihdauer");

		verlaengerungenLabel.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
		verlaengerungenLabel.setText("Anzahl der Verlaengerungen");

		ausleihdauerField.setFont(new java.awt.Font("Arial", 1, 18));
		ausleihdauerField.setHorizontalAlignment(javax.swing.JTextField.TRAILING);
		ausleihdauerField.setText("28");

		verlaengerungenField.setFont(new java.awt.Font("Arial", 1, 18));
		verlaengerungenField.setHorizontalAlignment(javax.swing.JTextField.TRAILING);
		verlaengerungenField.setText("2");

		ausleihdauerSlider.setMaximum(90);
		ausleihdauerSlider.setMinimum(1);
		ausleihdauerSlider.setMinorTickSpacing(7);
		ausleihdauerSlider.setPaintLabels(true);
		ausleihdauerSlider.setPaintTicks(true);
		ausleihdauerSlider.setSnapToTicks(true);
		ausleihdauerSlider.setValue(28);

		verlaengerungenSlider.setMaximum(5);
		verlaengerungenSlider.setMinorTickSpacing(1);
		verlaengerungenSlider.setPaintLabels(true);
		verlaengerungenSlider.setPaintTicks(true);
		verlaengerungenSlider.setSnapToTicks(true);
		verlaengerungenSlider.setValue(2);

		benutzerPane.setBorder(javax.swing.BorderFactory.createTitledBorder(null, " Benutzer verwalten ", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 11), new java.awt.Color(0, 0, 0))); // NOI18N
		benutzerPane.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		benutzerPane.setOpaque(false);
		benutzerPane.setPreferredSize(new java.awt.Dimension(552, 258));

		benutzerPanel.setOpaque(false);
		benutzerPanel.setPreferredSize(new java.awt.Dimension(552, 258));

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

		addButton.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
		addButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/bibliotheksverwaltung/view/images/user_add_24.png"))); // NOI18N
		addButton.setText("Benutzer hinzufuegen");
		addButton.setHorizontalAlignment(javax.swing.SwingConstants.LEADING);
		addButton.setIconTextGap(10);
		addButton.setPreferredSize(new java.awt.Dimension(183, 28));

		javax.swing.GroupLayout benutzerPanelLayout = new javax.swing.GroupLayout(benutzerPanel);
		benutzerPanel.setLayout(benutzerPanelLayout);
		benutzerPanelLayout.setHorizontalGroup(
				benutzerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(benutzerPanelLayout.createSequentialGroup()
						.addContainerGap()
						.addGroup(benutzerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
								.addComponent(benutzerSeparator, javax.swing.GroupLayout.Alignment.LEADING)
								.addGroup(javax.swing.GroupLayout.Alignment.LEADING, benutzerPanelLayout.createSequentialGroup()
										.addComponent(nameField, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
										.addComponent(passwordField, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
										.addComponent(addButton, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)))
										.addContainerGap(40, Short.MAX_VALUE))
		);
		benutzerPanelLayout.setVerticalGroup(
				benutzerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(benutzerPanelLayout.createSequentialGroup()
						.addGroup(benutzerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(nameField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(passwordField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(addButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
								.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
								.addComponent(benutzerSeparator, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addContainerGap(213, Short.MAX_VALUE))
		);

		benutzerPane.setViewportView(benutzerPanel);

		cancelButton.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
		cancelButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/bibliotheksverwaltung/view/images/cancel_48.png"))); // NOI18N
		cancelButton.setText("Abbrechen");
		cancelButton.setHorizontalAlignment(javax.swing.SwingConstants.LEADING);
		cancelButton.setIconTextGap(10);

		saveButton.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
		saveButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/bibliotheksverwaltung/view/images/accepted_48.png"))); // NOI18N
		saveButton.setText("Aenderungen speichern");
		saveButton.setHorizontalAlignment(javax.swing.SwingConstants.LEADING);
		saveButton.setIconTextGap(10);

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
		this.setLayout(layout);
		layout.setHorizontalGroup(
				layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(layout.createSequentialGroup()
						.addGap(20, 20, 20)
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
								.addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
										.addComponent(verlaengerungenLabel)
										.addGap(18, 18, 18)
										.addComponent(verlaengerungenField, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 10, Short.MAX_VALUE)
										.addComponent(verlaengerungenSlider, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
										.addGroup(layout.createSequentialGroup()
												.addComponent(ausleihdauerLabel)
												.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 60, Short.MAX_VALUE)
												.addComponent(ausleihdauerField, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
												.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
												.addComponent(ausleihdauerSlider, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)))
												.addGap(114, 114, 114))
												.addGroup(layout.createSequentialGroup()
														.addContainerGap()
														.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
																.addComponent(benutzerPane, javax.swing.GroupLayout.PREFERRED_SIZE, 552, javax.swing.GroupLayout.PREFERRED_SIZE)
																.addGroup(layout.createSequentialGroup()
																		.addComponent(cancelButton)
																		.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 132, Short.MAX_VALUE)
																		.addComponent(saveButton)))
																		.addContainerGap())
		);
		layout.setVerticalGroup(
				layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(layout.createSequentialGroup()
						.addGap(17, 17, 17)
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
								.addGroup(layout.createSequentialGroup()
										.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
												.addComponent(ausleihdauerField)
												.addComponent(ausleihdauerSlider, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
												.addGap(36, 36, 36))
												.addGroup(layout.createSequentialGroup()
														.addComponent(ausleihdauerLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
														.addGap(39, 39, 39)))
														.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
																.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
																		.addComponent(verlaengerungenField, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
																		.addComponent(verlaengerungenLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
																		.addComponent(verlaengerungenSlider, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
																		.addGap(18, 18, 18)
																		.addComponent(benutzerPane, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE)
																		.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
																		.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
																				.addComponent(cancelButton)
																				.addComponent(saveButton))
																				.addGap(17, 17, 17))
		);
	}// </editor-fold>//GEN-END:initComponents

	private void nameFieldFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_nameFieldFocusGained
		if (ausleihdauerField.getText().equals("Name")) {
			ausleihdauerField.setText("");
			ausleihdauerField.setForeground(new java.awt.Color(0, 0, 0));
		}
	}//GEN-LAST:event_nameFieldFocusGained

	private void nameFieldFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_nameFieldFocusLost
		if (ausleihdauerField.getText().isEmpty()) {
			ausleihdauerField.setForeground(new java.awt.Color(204, 204, 204));
			ausleihdauerField.setText("Name");
		}
	}//GEN-LAST:event_nameFieldFocusLost

	private void passwordFieldFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_passwordFieldFocusGained
		if (passwordField.getText().equals("Passwort")) {
			passwordField.setText("");
			passwordField.setForeground(new java.awt.Color(0, 0, 0));
		}
	}//GEN-LAST:event_passwordFieldFocusGained

	private void passwordFieldFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_passwordFieldFocusLost
		if (passwordField.getText().isEmpty()) {
			passwordField.setForeground(new java.awt.Color(204, 204, 204));
			passwordField.setText("Passwort");
		}
	}//GEN-LAST:event_passwordFieldFocusLost


	// Variables declaration - do not modify//GEN-BEGIN:variables
	private javax.swing.JButton addButton;
	private javax.swing.JTextField ausleihdauerField;
	private javax.swing.JLabel ausleihdauerLabel;
	private javax.swing.JSlider ausleihdauerSlider;
	private javax.swing.JScrollPane benutzerPane;
	private javax.swing.JPanel benutzerPanel;
	private javax.swing.JSeparator benutzerSeparator;
	private javax.swing.JButton cancelButton;
	private javax.swing.JTextField nameField;
	private javax.swing.JTextField passwordField;
	private javax.swing.JButton saveButton;
	private javax.swing.JTextField verlaengerungenField;
	private javax.swing.JLabel verlaengerungenLabel;
	private javax.swing.JSlider verlaengerungenSlider;
	// End of variables declaration//GEN-END:variables

}
