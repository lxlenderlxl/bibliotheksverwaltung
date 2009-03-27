/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * LogAnsichtPanel.java
 *
 * Created on 26.03.2009, 11:29:21
 */
package bibliotheksverwaltung.view;

import javax.swing.JFrame;

import bibliotheksverwaltung.model.domain.Ausleiher;
import bibliotheksverwaltung.model.domain.Exemplar;
import bibliotheksverwaltung.model.domain.Log;
import bibliotheksverwaltung.model.domain.Medium;
import bibliotheksverwaltung.model.domain.Vorgang;

/**
 *
 * @author Max
 */
public class LogAnsichtPanel extends javax.swing.JPanel {

	/** Erzeugt ein neues LogAnsichtPanel */
	public LogAnsichtPanel() {
		initComponents();
	}

	public LogAnsichtPanel(Log log) {
		initComponents();

		datumLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/bibliotheksverwaltung/view/images/" + getIcon(log.getVorgang()))));
		this.datumLabel.setText(log.getLogDatum().toString());
		this.datumLabel.setToolTipText("interne Seriennummer des Logs: " + log.getId());
		this.vorgangLabel.setText(new Vorgang(log.getVorgang()).getInhalt());
		this.vorgangLabel.setToolTipText(new Vorgang(log.getVorgang()).getInhalt());
		this.ausleiherLabel.setText(
				log.getAusleiher() != 0 ? new Ausleiher(log.getAusleiher()).getName() : "");
		this.ausleiherLabel.setToolTipText("interne Seriennummer des Ausleihers: " + log.getAusleiher());
		this.titelLabel.setText(
				log.getExemplar() != 0 ? new Medium(new Exemplar(log.getExemplar()).getMedium()).getTitel() : "");
		this.titelLabel.setToolTipText("interne Seriennummer des Exemplars: " + log.getExemplar());
		this.anwenderLabel.setText(log.getAnwender());
		this.anwenderLabel.setToolTipText(log.getKommentar() != null ? "Kommentar: " + log.getKommentar() : "");
	}

	/** 
	 * Erzeugt die obigen Komponenten auf dem MainPanel
	 */
	@SuppressWarnings("unchecked")
	private void initComponents() {

		datumLabel = new javax.swing.JLabel();
		vorgangLabel = new javax.swing.JLabel();
		ausleiherLabel = new javax.swing.JLabel();
		titelLabel = new javax.swing.JLabel();
		anwenderLabel = new javax.swing.JLabel();

		setOpaque(false);
		setPreferredSize(new java.awt.Dimension(563, 24));

		datumLabel.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
		datumLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/bibliotheksverwaltung/view/images/book_24.png"))); // NOI18N
		datumLabel.setText("Datum");
		datumLabel.setToolTipText("LogID");

		vorgangLabel.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
		vorgangLabel.setText("Vorgang");
		vorgangLabel.setToolTipText("Vorgang");

		ausleiherLabel.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
		ausleiherLabel.setText("AusleiherName");
		ausleiherLabel.setToolTipText("AusleiherID");

		titelLabel.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
		titelLabel.setText("Titel des Buches");
		titelLabel.setToolTipText("ExemplarID");

		anwenderLabel.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
		anwenderLabel.setText("Anwender");
		anwenderLabel.setToolTipText("Kommentar");

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
		this.setLayout(layout);
		layout.setHorizontalGroup(
				layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(layout.createSequentialGroup()
						.addComponent(datumLabel)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
						.addComponent(vorgangLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
						.addComponent(ausleiherLabel)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
						.addComponent(titelLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
						.addComponent(anwenderLabel)
						.addContainerGap())
		);
		layout.setVerticalGroup(
				layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
						.addComponent(datumLabel)
						.addComponent(vorgangLabel)
						.addComponent(anwenderLabel)
						.addComponent(titelLabel)
						.addComponent(ausleiherLabel))
		);
	}// </editor-fold>//GEN-END:initComponents

	public static void main(String args[]) {
		JFrame jframe = new JFrame();
		jframe.setSize(540, 100);
		jframe.add(new LogAnsichtPanel(new Log(50)));
		jframe.add(new LogAnsichtPanel(new Log(30)));
		jframe.add(new LogAnsichtPanel(new Log(40)));
		jframe.setVisible(true);
		jframe.setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
	}

	private String getIcon(int vorgangsID) {
		Vorgang vorgang = new Vorgang(vorgangsID);
		if (vorgang.getInhalt().contains("Exemplar") || vorgang.getInhalt().contains("Ausleihe")) {
			return "book_24.png";

		} else if (vorgang.getInhalt().contains("Person") || vorgang.getInhalt().contains("Benutzer")) {
			return "user_24.png";

		} else {
			return "warning_24.png";

		}
	}

	// Variables declaration - do not modify//GEN-BEGIN:variables
	private javax.swing.JLabel anwenderLabel;
	private javax.swing.JLabel ausleiherLabel;
	private javax.swing.JLabel datumLabel;
	private javax.swing.JLabel titelLabel;
	private javax.swing.JLabel vorgangLabel;
	// End of variables declaration//GEN-END:variables
}
