/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * PersonenAnsicht.java
 *
 * Created on 24.03.2009, 23:01:59
 */
package bibliotheksverwaltung.view;

import java.util.Observable;
import java.util.Observer;

import javax.swing.JFrame;

import bibliotheksverwaltung.model.domain.Ausleiher;
import bibliotheksverwaltung.model.logic.BibliotheksVerwalter;
import bibliotheksverwaltung.util.Message;
import bibliotheksverwaltung.util.UpdateInfo;

/**
 *
 * @author Max
 */
public class PersonenAnsicht extends ImagePanel implements Observer {

	private Ausleiher ausleiher = null;
	private BibliotheksVerwalter verwalter = null;
	/** Erzeugt eine neue PersonenAnsicht */
	public PersonenAnsicht(BibliotheksVerwalter derVerwalter) {
		super("Person.png");
		initComponents();
		this.verwalter = derVerwalter;
		this.ausleiher = this.verwalter.getAusleiherVerwalter().getAusleiher();
		initComponents();
		this.setzeInformation();
		verwalter.addObserver(this);
		this.verwalter.fuegeObserverHinzu(this);
		this.setzeStatus();
	}

	private void setzeInformation()
	{
		nameField.setText(this.ausleiher.getJoinedName());
		infoField.setText(this.ausleiher.getJoinedAdress());
	}

	private void setzeStatus()
	{
		this.verwalter.getAusleiherVerwalter().setAusleiher(this.ausleiher);
		this.verwalter.getAusleiherVerwalter().erzeugeAusgelieheneExemplare();
		statusLabel.setText(String.valueOf(this.verwalter.getAusleiherVerwalter().getAnzahlAusgeliehenerExemplare()));
		switch (this.verwalter.getAusleiherVerwalter().getAusleihStatus())
		{
		case Message.GRUEN:
			statusLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/bibliotheksverwaltung/view/images/circle_green_small.png")));
			break;
		case Message.GELB:
			statusLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/bibliotheksverwaltung/view/images/circle_orange_small.png")));
			break;
		case Message.ROT:
			statusLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/bibliotheksverwaltung/view/images/circle_red_small.png")));
			break;    
		}
	}

	/** 
	 * Erzeugt die obigen Komponenten auf dem MainPanel
	 */
	@SuppressWarnings("unchecked")
	private void initComponents() {

		nameField = new javax.swing.JTextArea();
		infoField = new javax.swing.JTextArea();
		statusLabel = new javax.swing.JLabel();

		setMaximumSize(new java.awt.Dimension(182, 240));
		setPreferredSize(new java.awt.Dimension(182, 240));

		nameField.setColumns(20);
		nameField.setEditable(false);
		nameField.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
		nameField.setLineWrap(true);
		nameField.setRows(5);
		nameField.setWrapStyleWord(true);
		nameField.setBorder(null);
		nameField.setOpaque(false);

		infoField.setColumns(20);
		infoField.setEditable(false);
		infoField.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
		infoField.setLineWrap(true);
		infoField.setRows(5);
		infoField.setWrapStyleWord(true);
		infoField.setBorder(null);
		infoField.setOpaque(false);

		statusLabel.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
		statusLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/bibliotheksverwaltung/view/images/circle_red_small.png"))); // NOI18N
		statusLabel.setText("5 Ausleihen");
		statusLabel.setVerticalAlignment(javax.swing.SwingConstants.TOP);

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
		this.setLayout(layout);
		layout.setHorizontalGroup(
				layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(layout.createSequentialGroup()
						.addGap(26, 26, 26)
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addComponent(statusLabel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 149, Short.MAX_VALUE)
								.addComponent(infoField, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 149, Short.MAX_VALUE)
								.addComponent(nameField, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 149, Short.MAX_VALUE))
								.addGap(19, 19, 19))
		);
		layout.setVerticalGroup(
				layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(layout.createSequentialGroup()
						.addContainerGap()
						.addComponent(nameField, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
						.addComponent(infoField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
						.addComponent(statusLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addGap(16, 16, 16))
		);
	}// </editor-fold>//GEN-END:initComponents

	public static void main(String args[]) {
		JFrame jframe = new JFrame();
		jframe.setSize(200, 265);
		//jframe.add(new PersonenAnsicht());
		jframe.setVisible(true);
	}

	/* (non-Javadoc)
	 * @see java.util.Observer#update(java.util.Observable, java.lang.Object)
	 */
	@Override
	public void update(Observable o, Object arg) {
		UpdateInfo updateInfo = (UpdateInfo) arg;
		if (updateInfo.holeAenderung().equals("PersonDatenBearbeitet"))
		{
			if (updateInfo.holeAenderungOk())
			{
				this.ausleiher = this.verwalter.getAusleiherVerwalter().getAusleiher();
				this.setzeInformation();
				this.setzeStatus();
			}
		}
		else if (updateInfo.holeAenderung().equals("ExemplarAusleihen"))
		{
			if (updateInfo.holeAenderungOk())
			{
				this.setzeStatus();
			}
		}
		else if (updateInfo.holeAenderung().equals("ExemplarZurueck"))
		{
			if (updateInfo.holeAenderungOk())
			{
				this.setzeStatus();
			}
		}
		this.repaint();
		this.revalidate();
	}

	// Variables declaration - do not modify//GEN-BEGIN:variables
	private javax.swing.JTextArea infoField;
	private javax.swing.JTextArea nameField;
	private javax.swing.JLabel statusLabel;
	// End of variables declaration//GEN-END:variables
}
