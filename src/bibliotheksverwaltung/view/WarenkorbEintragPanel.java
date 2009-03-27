/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * WarenkorbEintragPanel.java
 *
 * Created on 24.03.2009, 20:48:00
 */

package bibliotheksverwaltung.view;

import bibliotheksverwaltung.controller.WarenKorbEntfernenActionListener;
import bibliotheksverwaltung.model.domain.Exemplar;
import bibliotheksverwaltung.model.domain.Medium;
import bibliotheksverwaltung.model.logic.BibliotheksVerwalter;

/**
 * Ein Warenkorbeintragpanel repräsentiert genau einen Eintrag  einer Ware in einem Warenkorb. Die 
 * Waren lassen sich über einen Löschen Button aus dem Warenkorb entfernen. Es dient ebenfalls zur Darstellung 
 * von Informationen über die Ware im Warenkorb
 * @author Max
 */
public class WarenkorbEintragPanel extends javax.swing.JPanel {
	// Variables declaration - do not modify//GEN-BEGIN:variables
	/**Bezeichent den Löschenbutton*/
	private javax.swing.JButton deleteButton;
	/**Repräsentiert ein Exemplar als Ware*/
	private Exemplar exemplar = null;
	/**Bezeichnet die Informationen über das Exemplar*/
	private javax.swing.JLabel exemplarLabel;
	// End of variables declaration//GEN-END:variables

	/**Bezeichnet der Verwalter*/
	private BibliotheksVerwalter verwalter = null;


	/** Erzeugt ein neues WarenkorbEintragPanel */
	public WarenkorbEintragPanel(BibliotheksVerwalter derVerwalter, Exemplar dasExemplar) {
		initComponents();
		this.verwalter = derVerwalter;
		this.exemplar = dasExemplar;
		this.exemplarLabel.setText(String.valueOf(this.exemplar.getId()));
		this.setToolTipText(new Medium(this.exemplar.getMedium()).getTitel());
		this.deleteButton.addActionListener(new WarenKorbEntfernenActionListener(this.verwalter, this.exemplar));
	}
	/** 
	 * Erzeugt die obigen Komponenten auf dem MainPanel
	 */
	@SuppressWarnings("unchecked")
	private void initComponents() {

		exemplarLabel = new javax.swing.JLabel();
		deleteButton = new javax.swing.JButton();

		exemplarLabel.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
		exemplarLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/bibliotheksverwaltung/view/images/book_24.png"))); // NOI18N
		exemplarLabel.setText("ExemplarID");
		exemplarLabel.setPreferredSize(new java.awt.Dimension(136, 24));

		deleteButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/bibliotheksverwaltung/view/images/cancel_24.png"))); // NOI18N
		deleteButton.setBorder(null);
		deleteButton.setContentAreaFilled(false);

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
		this.setLayout(layout);
		layout.setHorizontalGroup(
				layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(layout.createSequentialGroup()
						.addComponent(exemplarLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
						.addComponent(deleteButton))
		);
		layout.setVerticalGroup(
				layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
						.addComponent(deleteButton)
						.addComponent(exemplarLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
		);
	}// </editor-fold>//GEN-END:initComponents

}
