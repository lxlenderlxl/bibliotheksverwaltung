/*
 * ReportPanel.java
 *
 * Created on 25.03.2009, 16:14:50
 */

package bibliotheksverwaltung.view;

import bibliotheksverwaltung.model.daos.dao.MySQLStatistikDAO;
import bibliotheksverwaltung.model.domain.Statistik;
import bibliotheksverwaltung.model.logic.PDFVerwalter;

/**
 *
 * @author Max
 */
@SuppressWarnings("serial")
public class ReportPanel extends javax.swing.JPanel {

	/** Erzeugt ein neues ReportPanel */
	public ReportPanel() {
		initComponents();
		fuelleFelder();
	}

	private void fuelleFelder() {
		Statistik statistik = new MySQLStatistikDAO().getStatistik();

		buecherField.setText("" + statistik.getEingetrageneBuecher());
		exemplareField.setText("" + statistik.getEingetragendeExemplare());
		personenField.setText("" + statistik.getEingetragenePersonen());
		leihenField.setText("" + statistik.getVerliehenBuecher());
		ausleiherField.setText("" + statistik.getLeihendePersonen());
		ausleihenGesamtField.setText("" + statistik.getBisherigeAusleihen());
	}

	/** 
	 * Erzeugt die obigen Komponenten auf dem MainPanel
	 */
	@SuppressWarnings("unchecked")
	private void initComponents() {

		statistikPanel = new javax.swing.JPanel();
		buecherLabel = new javax.swing.JLabel();
		buecherField = new javax.swing.JTextField();
		exemplareLabel = new javax.swing.JLabel();
		exemplareField = new javax.swing.JTextField();
		personenLabel = new javax.swing.JLabel();
		personenField = new javax.swing.JTextField();
		leihenLabel = new javax.swing.JLabel();
		leihenField = new javax.swing.JTextField();
		ausleiherLabel = new javax.swing.JLabel();
		ausleiherField = new javax.swing.JTextField();
		ausleihenGesamtLabel = new javax.swing.JLabel();
		ausleihenGesamtField = new javax.swing.JTextField();
		mahnBriefeButton = new javax.swing.JButton();
		mahnButton1 = new javax.swing.JButton();

		setPreferredSize(new java.awt.Dimension(593, 600));

		statistikPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(null, " Statistik ", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 0, 12), new java.awt.Color(0, 0, 0))); // NOI18N

		buecherLabel.setFont(new java.awt.Font("Arial", 1, 14));
		buecherLabel.setText("eingetragene Buecher");

		buecherField.setEditable(false);
		buecherField.setFont(new java.awt.Font("Arial", 1, 18));
		buecherField.setHorizontalAlignment(javax.swing.JTextField.TRAILING);

		exemplareLabel.setFont(new java.awt.Font("Arial", 1, 14));
		exemplareLabel.setText("eingetragene Exemplare");

		exemplareField.setEditable(false);
		exemplareField.setFont(new java.awt.Font("Arial", 1, 18));
		exemplareField.setHorizontalAlignment(javax.swing.JTextField.TRAILING);

		personenLabel.setFont(new java.awt.Font("Arial", 1, 14));
		personenLabel.setText("eingetragene Personen");

		personenField.setEditable(false);
		personenField.setFont(new java.awt.Font("Arial", 1, 18));
		personenField.setHorizontalAlignment(javax.swing.JTextField.TRAILING);

		leihenLabel.setFont(new java.awt.Font("Arial", 1, 14));
		leihenLabel.setText("verliehene Buecher");

		leihenField.setEditable(false);
		leihenField.setFont(new java.awt.Font("Arial", 1, 18));
		leihenField.setHorizontalAlignment(javax.swing.JTextField.TRAILING);

		ausleiherLabel.setFont(new java.awt.Font("Arial", 1, 14));
		ausleiherLabel.setText("leihende Personen");

		ausleiherField.setEditable(false);
		ausleiherField.setFont(new java.awt.Font("Arial", 1, 18));
		ausleiherField.setHorizontalAlignment(javax.swing.JTextField.TRAILING);

		ausleihenGesamtLabel.setFont(new java.awt.Font("Arial", 1, 14));
		ausleihenGesamtLabel.setText("bisherige Ausleihen");

		ausleihenGesamtField.setEditable(false);
		ausleihenGesamtField.setFont(new java.awt.Font("Arial", 1, 18));
		ausleihenGesamtField.setHorizontalAlignment(javax.swing.JTextField.TRAILING);

		javax.swing.GroupLayout statistikPanelLayout = new javax.swing.GroupLayout(statistikPanel);
		statistikPanel.setLayout(statistikPanelLayout);
		statistikPanelLayout.setHorizontalGroup(
				statistikPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(statistikPanelLayout.createSequentialGroup()
						.addContainerGap()
						.addGroup(statistikPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addComponent(buecherLabel)
								.addComponent(exemplareLabel)
								.addComponent(ausleiherLabel)
								.addComponent(leihenLabel)
								.addComponent(ausleihenGesamtLabel)
								.addComponent(personenLabel))
								.addGap(35, 35, 35)
								.addGroup(statistikPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
										.addComponent(personenField)
										.addComponent(exemplareField)
										.addComponent(ausleiherField)
										.addComponent(leihenField)
										.addComponent(ausleihenGesamtField, javax.swing.GroupLayout.Alignment.TRAILING)
										.addComponent(buecherField, javax.swing.GroupLayout.DEFAULT_SIZE, 85, Short.MAX_VALUE))
										.addContainerGap(227, Short.MAX_VALUE))
		);
		statistikPanelLayout.setVerticalGroup(
				statistikPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(statistikPanelLayout.createSequentialGroup()
						.addContainerGap()
						.addGroup(statistikPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(buecherLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(buecherField))
								.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
								.addGroup(statistikPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
										.addComponent(exemplareLabel)
										.addComponent(exemplareField))
										.addGap(7, 7, 7)
										.addGroup(statistikPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
												.addComponent(personenField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
												.addComponent(personenLabel))
												.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
												.addGroup(statistikPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
														.addComponent(leihenLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
														.addComponent(leihenField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
														.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
														.addGroup(statistikPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
																.addComponent(ausleiherLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
																.addComponent(ausleiherField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
																.addGap(11, 11, 11)
																.addGroup(statistikPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
																		.addComponent(ausleihenGesamtLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
																		.addComponent(ausleihenGesamtField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
																		.addGap(26, 26, 26))
		);

		mahnBriefeButton.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
		mahnBriefeButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/bibliotheksverwaltung/view/images/mail_48.png"))); // NOI18N
		mahnBriefeButton.setText("Mahnbriefe erstellen");
		mahnBriefeButton.setHorizontalAlignment(javax.swing.SwingConstants.LEADING);
		mahnBriefeButton.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				mahnBriefeButtonActionPerformed(evt);
			}
		});

		mahnButton1.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
		mahnButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/bibliotheksverwaltung/view/images/table_green_48.png"))); // NOI18N
		mahnButton1.setText("Mahnliste erstellen");
		mahnButton1.setHorizontalAlignment(javax.swing.SwingConstants.LEADING);
		mahnButton1.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				mahnButton1ActionPerformed(evt);
			}
		});

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
		this.setLayout(layout);
		layout.setHorizontalGroup(
				layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(layout.createSequentialGroup()
						.addContainerGap()
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addComponent(statistikPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addGroup(layout.createSequentialGroup()
										.addComponent(mahnBriefeButton)
										.addGap(18, 18, 18)
										.addComponent(mahnButton1, javax.swing.GroupLayout.DEFAULT_SIZE, 263, Short.MAX_VALUE)))
										.addContainerGap(37, javax.swing.GroupLayout.PREFERRED_SIZE))
		);
		layout.setVerticalGroup(
				layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(layout.createSequentialGroup()
						.addGap(50, 50, 50)
						.addComponent(statistikPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
						.addGap(45, 45, 45)
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(mahnBriefeButton)
								.addComponent(mahnButton1))
								.addContainerGap(167, Short.MAX_VALUE))
		);
	}// </editor-fold>//GEN-END:initComponents

	private void mahnBriefeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mahnBriefeButtonActionPerformed
		new PDFVerwalter().saveMahnlisten();
	}//GEN-LAST:event_mahnBriefeButtonActionPerformed

	private void mahnButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mahnButton1ActionPerformed
		new PDFVerwalter().saveMahnlist2();
	}//GEN-LAST:event_mahnButton1ActionPerformed


	// Variables declaration - do not modify//GEN-BEGIN:variables
	private javax.swing.JTextField ausleihenGesamtField;
	private javax.swing.JLabel ausleihenGesamtLabel;
	private javax.swing.JTextField ausleiherField;
	private javax.swing.JLabel ausleiherLabel;
	private javax.swing.JTextField buecherField;
	private javax.swing.JLabel buecherLabel;
	private javax.swing.JTextField exemplareField;
	private javax.swing.JLabel exemplareLabel;
	private javax.swing.JTextField leihenField;
	private javax.swing.JLabel leihenLabel;
	private javax.swing.JButton mahnBriefeButton;
	private javax.swing.JButton mahnButton1;
	private javax.swing.JTextField personenField;
	private javax.swing.JLabel personenLabel;
	private javax.swing.JPanel statistikPanel;
	// End of variables declaration//GEN-END:variables

}
