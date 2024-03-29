/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * BuchHinzufuegenPanel.java
 *
 * Created on 24.03.2009, 21:04:29
 */

package bibliotheksverwaltung.view;

import javax.swing.JTextField;

import bibliotheksverwaltung.controller.BuchAenderungenSpeichernListener;
import bibliotheksverwaltung.controller.BuchDatenBearbeitenAbbrechenListener;
import bibliotheksverwaltung.controller.BuchHinzuActionListener;
import bibliotheksverwaltung.controller.PersonHinzuActionListener;
import bibliotheksverwaltung.model.logic.BibliotheksVerwalter;

/**
 *
 * @author Max
 */
public class BuchHinzufuegenPanel extends javax.swing.JPanel {

	private BibliotheksVerwalter verwalter = null;

	/** Erzeugt ein neues BuchHinzufuegenPanel */
	public BuchHinzufuegenPanel(BibliotheksVerwalter derVerwalter, boolean mediumAuflisten) {
		initComponents();
		this.verwalter = derVerwalter;
		this.cancelButton.addActionListener(new BuchDatenBearbeitenAbbrechenListener(this.verwalter));
		if (mediumAuflisten)
		{
			this.titelField.setText(this.verwalter.getMedienVerwalter().getMedium().getTitel());
			this.vornameField.setText(this.verwalter.getMedienVerwalter().getMedium().getAutorVorname());
			this.nachnameField.setText(this.verwalter.getMedienVerwalter().getMedium().getAutorNachname());
			this.verlagField.setText(this.verwalter.getMedienVerwalter().getMedium().getVerlag());
			this.jahrField.setText(String.valueOf(this.verwalter.getMedienVerwalter().getMedium().getErscheinungsJahr()));
			this.isbnField.setText(this.verwalter.getMedienVerwalter().getMedium().getIsbn());
			//this.tagsField.setText(this.verwalter.getMedienVerwalter().getMedium().gett);
			this.addButton.setText("<html>�nderungen<br />speichern</html>");
			this.addButton.addActionListener(new BuchAenderungenSpeichernListener(this.verwalter, this));
		}
		else
			this.addButton.addActionListener(new BuchHinzuActionListener(this.verwalter, this));
	}

	/**
	 * @return the isbnField
	 */
	public javax.swing.JTextField getIsbnField()
	{
		return isbnField;
	}

	/**
	 * @param isbnField the isbnField to set
	 */
	public void setIsbnField(javax.swing.JTextField isbnField)
	{
		this.isbnField = isbnField;
	}

	/**
	 * @return the jahrField
	 */
	public javax.swing.JTextField getJahrField()
	{
		return jahrField;
	}

	/**
	 * @param jahrField the jahrField to set
	 */
	public void setJahrField(javax.swing.JTextField jahrField)
	{
		this.jahrField = jahrField;
	}

	/**
	 * @return the nachnameField
	 */
	public javax.swing.JTextField getNachnameField()
	{
		return nachnameField;
	}

	/**
	 * @param nachnameField the nachnameField to set
	 */
	public void setNachnameField(javax.swing.JTextField nachnameField)
	{
		this.nachnameField = nachnameField;
	}

	/**
	 * @return the tagsField
	 */
	public javax.swing.JTextField getTagsField()
	{
		return tagsField;
	}

	/**
	 * @param tagsField the tagsField to set
	 */
	public void setTagsField(javax.swing.JTextField tagsField)
	{
		this.tagsField = tagsField;
	}

	/**
	 * @return the titelField
	 */
	public javax.swing.JTextField getTitelField()
	{
		return titelField;
	}

	/**
	 * @param titelField the titelField to set
	 */
	public void setTitelField(javax.swing.JTextField titelField)
	{
		this.titelField = titelField;
	}

	/**
	 * @return the verlagField
	 */
	public javax.swing.JTextField getVerlagField()
	{
		return verlagField;
	}

	/**
	 * @param verlagField the verlagField to set
	 */
	public void setVerlagField(javax.swing.JTextField verlagField)
	{
		this.verlagField = verlagField;
	}

	/**
	 * @return the vornameField
	 */
	public javax.swing.JTextField getVornameField()
	{
		return vornameField;
	}

	/**
	 * @param vornameField the vornameField to set
	 */
	public void setVornameField(javax.swing.JTextField vornameField)
	{
		this.vornameField = vornameField;
	}

	/** 
	 * Erzeugt die obigen Komponenten auf dem MainPanel
	 */
	@SuppressWarnings("unchecked")
	private void initComponents() {

		titelField = new javax.swing.JTextField();
		vornameField = new javax.swing.JTextField();
		nachnameField = new javax.swing.JTextField();
		verlagField = new javax.swing.JTextField();
		jahrField = new javax.swing.JTextField();
		isbnField = new javax.swing.JTextField();
		tagsField = new javax.swing.JTextField();
		addButton = new javax.swing.JButton();
		cancelButton = new javax.swing.JButton();

		setMaximumSize(new java.awt.Dimension(558, 164));
		setMinimumSize(new java.awt.Dimension(558, 164));
		setPreferredSize(new java.awt.Dimension(558, 164));

		titelField.setFont(new java.awt.Font("Arial", 1, 18));
		titelField.setForeground(new java.awt.Color(204, 204, 204));
		titelField.setText("Buchtitel");
		titelField.setToolTipText("Der Titel des Buches");
		titelField.addFocusListener(new java.awt.event.FocusAdapter() {
			public void focusGained(java.awt.event.FocusEvent evt) {
				titelFieldFocusGained(evt);
			}
			public void focusLost(java.awt.event.FocusEvent evt) {
				titelFieldFocusLost(evt);
			}
		});

		vornameField.setFont(new java.awt.Font("Arial", 1, 18));
		vornameField.setForeground(new java.awt.Color(204, 204, 204));
		vornameField.setText("Autor-Vorname");
		vornameField.setToolTipText("Der Vorname des Buchautors");
		vornameField.addFocusListener(new java.awt.event.FocusAdapter() {
			public void focusGained(java.awt.event.FocusEvent evt) {
				vornameFieldFocusGained(evt);
			}
			public void focusLost(java.awt.event.FocusEvent evt) {
				vornameFieldFocusLost(evt);
			}
		});

		nachnameField.setFont(new java.awt.Font("Arial", 1, 18));
		nachnameField.setForeground(new java.awt.Color(204, 204, 204));
		nachnameField.setText("Autor-Nachname");
		nachnameField.setToolTipText("Der Nachname des Buchautors");
		nachnameField.addFocusListener(new java.awt.event.FocusAdapter() {
			public void focusGained(java.awt.event.FocusEvent evt) {
				nachnameFieldFocusGained(evt);
			}
			public void focusLost(java.awt.event.FocusEvent evt) {
				nachnameFieldFocusLost(evt);
			}
		});

		verlagField.setFont(new java.awt.Font("Arial", 1, 18));
		verlagField.setForeground(new java.awt.Color(204, 204, 204));
		verlagField.setText("Verlag");
		verlagField.setToolTipText("Der herausgebende Verlag des Buches");
		verlagField.addFocusListener(new java.awt.event.FocusAdapter() {
			public void focusGained(java.awt.event.FocusEvent evt) {
				verlagFieldFocusGained(evt);
			}
			public void focusLost(java.awt.event.FocusEvent evt) {
				verlagFieldFocusLost(evt);
			}
		});

		jahrField.setFont(new java.awt.Font("Arial", 1, 18));
		jahrField.setForeground(new java.awt.Color(204, 204, 204));
		jahrField.setText("Jahr");
		jahrField.setToolTipText("Das Erscheinungsjahr des Buches");
		jahrField.addFocusListener(new java.awt.event.FocusAdapter() {
			public void focusGained(java.awt.event.FocusEvent evt) {
				jahrFieldFocusGained(evt);
			}
			public void focusLost(java.awt.event.FocusEvent evt) {
				jahrFieldFocusLost(evt);
			}
		});

		isbnField.setFont(new java.awt.Font("Arial", 1, 18));
		isbnField.setForeground(new java.awt.Color(204, 204, 204));
		isbnField.setText("ISBN");
		isbnField.setToolTipText("Die Internationale Standardbuchnummer des Buches");
		isbnField.addFocusListener(new java.awt.event.FocusAdapter() {
			public void focusGained(java.awt.event.FocusEvent evt) {
				isbnFieldFocusGained(evt);
			}
			public void focusLost(java.awt.event.FocusEvent evt) {
				isbnFieldFocusLost(evt);
			}
		});

		tagsField.setFont(new java.awt.Font("Arial", 1, 18));
		tagsField.setForeground(new java.awt.Color(204, 204, 204));
		tagsField.setText("Tags");
		tagsField.setToolTipText("Schlagwörter, die auf das Buch zutreffen");
		tagsField.addFocusListener(new java.awt.event.FocusAdapter() {
			public void focusGained(java.awt.event.FocusEvent evt) {
				tagsFieldFocusGained(evt);
			}
			public void focusLost(java.awt.event.FocusEvent evt) {
				tagsFieldFocusLost(evt);
			}
		});

		addButton.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
		addButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/bibliotheksverwaltung/view/images/book_48.png"))); // NOI18N
		addButton.setText("<html>Buch<br /> hinzufuegen");
		addButton.setHorizontalAlignment(javax.swing.SwingConstants.LEADING);
		addButton.setIconTextGap(10);

		cancelButton.setFont(new java.awt.Font("Arial", 0, 18));
		cancelButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/bibliotheksverwaltung/view/images/cancel_24.png"))); // NOI18N
		cancelButton.setText("Abbrechen");
		cancelButton.setHorizontalAlignment(javax.swing.SwingConstants.LEADING);
		cancelButton.setIconTextGap(10);

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
		this.setLayout(layout);
		layout.setHorizontalGroup(
				layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(layout.createSequentialGroup()
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addGroup(layout.createSequentialGroup()
										.addComponent(titelField, javax.swing.GroupLayout.DEFAULT_SIZE, 348, Short.MAX_VALUE)
										.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
										.addComponent(tagsField, javax.swing.GroupLayout.DEFAULT_SIZE, 194, Short.MAX_VALUE))
										.addGroup(layout.createSequentialGroup()
												.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
														.addComponent(isbnField, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 343, Short.MAX_VALUE)
														.addGroup(layout.createSequentialGroup()
																.addComponent(verlagField, javax.swing.GroupLayout.DEFAULT_SIZE, 277, Short.MAX_VALUE)
																.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
																.addComponent(jahrField, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE))
																.addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
																		.addComponent(vornameField, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
																		.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
																		.addComponent(nachnameField, javax.swing.GroupLayout.DEFAULT_SIZE, 179, Short.MAX_VALUE)))
																		.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																		.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
																				.addComponent(addButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
																				.addComponent(cancelButton, javax.swing.GroupLayout.DEFAULT_SIZE, 199, Short.MAX_VALUE))))
																				.addContainerGap())
		);
		layout.setVerticalGroup(
				layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(layout.createSequentialGroup()
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(titelField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(tagsField, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
								.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
								.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
										.addGroup(layout.createSequentialGroup()
												.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
														.addComponent(vornameField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
														.addComponent(nachnameField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
														.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
														.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
																.addComponent(verlagField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
																.addComponent(jahrField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
																.addComponent(addButton, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE))
																.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
																		.addComponent(isbnField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
																		.addComponent(cancelButton))
																		.addContainerGap(17, Short.MAX_VALUE))
		);
	}// </editor-fold>//GEN-END:initComponents

	private void vornameFieldFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_vornameFieldFocusGained
		focusGained(vornameField, "Autor-Vorname");
	}//GEN-LAST:event_vornameFieldFocusGained

	private void vornameFieldFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_vornameFieldFocusLost
		focusLost(vornameField, "Autor-Vorname");
	}//GEN-LAST:event_vornameFieldFocusLost

	private void nachnameFieldFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_nachnameFieldFocusGained
		focusGained(nachnameField, "Autor-Nachname");
	}//GEN-LAST:event_nachnameFieldFocusGained

	private void nachnameFieldFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_nachnameFieldFocusLost
		focusLost(nachnameField, "Autor-Nachname");
	}//GEN-LAST:event_nachnameFieldFocusLost

	private void titelFieldFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_titelFieldFocusGained
		focusGained(titelField, "Buchtitel");
	}//GEN-LAST:event_titelFieldFocusGained

	private void titelFieldFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_titelFieldFocusLost
		focusLost(titelField, "Buchtitel");
	}//GEN-LAST:event_titelFieldFocusLost

	private void verlagFieldFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_verlagFieldFocusGained
		focusGained(verlagField, "Verlag");
	}//GEN-LAST:event_verlagFieldFocusGained

	private void verlagFieldFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_verlagFieldFocusLost
		focusLost(verlagField, "Verlag");
	}//GEN-LAST:event_verlagFieldFocusLost

	private void jahrFieldFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jahrFieldFocusGained
		focusGained(jahrField, "Jahr");
	}//GEN-LAST:event_jahrFieldFocusGained

	private void jahrFieldFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jahrFieldFocusLost
		focusLost(jahrField, "Jahr");
	}//GEN-LAST:event_jahrFieldFocusLost

	private void isbnFieldFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_isbnFieldFocusGained
		focusGained(isbnField, "ISBN");
	}//GEN-LAST:event_isbnFieldFocusGained

	private void isbnFieldFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_isbnFieldFocusLost
		focusLost(isbnField, "ISBN");
	}//GEN-LAST:event_isbnFieldFocusLost

	private void tagsFieldFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tagsFieldFocusGained
		focusGained(tagsField, "Tags");
	}//GEN-LAST:event_tagsFieldFocusGained

	private void tagsFieldFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tagsFieldFocusLost
		focusLost(tagsField, "Tags");
	}//GEN-LAST:event_tagsFieldFocusLost

	private void focusGained(JTextField field, String match) {
		if (field.getText().equals(match)) {
			field.setText("");
			field.setForeground(new java.awt.Color(0, 0, 0));
		}
	}

	private void focusLost(JTextField field, String content) {
		if (field.getText().isEmpty()) {
			field.setForeground(new java.awt.Color(204, 204, 204));
			field.setText(content);
		}
		if (field.getText().equals(content))
			field.setForeground(new java.awt.Color(255, 0, 0));
	}

	// Variables declaration - do not modify//GEN-BEGIN:variables
	private javax.swing.JButton addButton;
	private javax.swing.JButton cancelButton;
	private javax.swing.JTextField isbnField;
	private javax.swing.JTextField jahrField;
	private javax.swing.JTextField nachnameField;
	private javax.swing.JTextField tagsField;
	private javax.swing.JTextField titelField;
	private javax.swing.JTextField verlagField;
	private javax.swing.JTextField vornameField;
	// End of variables declaration//GEN-END:variables

}
