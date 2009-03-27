/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * WarenkorbPanel.java
 *
 * Created on 24.03.2009, 20:11:57
 */

package bibliotheksverwaltung.view;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.Observable;
import java.util.Observer;

import bibliotheksverwaltung.controller.AusleiherWahlenActionListener;
import bibliotheksverwaltung.controller.WarenKorbAusleihenActionListener;
import bibliotheksverwaltung.model.logic.BibliotheksVerwalter;
import bibliotheksverwaltung.util.UpdateInfo;

/**
 * Das Warenkorbpanel beinhaltet temporär alle auszuleihenden Bücher und bildet die Schnittstelle zwischen 
 * Exemplar und Ausleiher. Mit einem Klick auf den Ausleih-Button werden alle Bücher, die sich derzeitig 
 * im Warenkorb befinden an den entsprechnden AUsleiher ausgeliehen.
 * @author Max
 */
public class WarenkorbPanel extends javax.swing.JPanel implements Observer {
	// Variables declaration - do not modify//GEN-BEGIN:variables
	/**Bezeichnet den Ausleiher Button*/
	private javax.swing.JButton ausleiherButton;
	/**Bezeichnet das AnzeigePanel*/
	private javax.swing.JPanel eintraegePanel;
	// End of variables declaration//GEN-END:variables
	/**Bezeichnet den Verwalter*/
	private BibliotheksVerwalter verwalter = null;


	/** Erzeugt ein neues WarenkorbPanel */
	public WarenkorbPanel(BibliotheksVerwalter derVerwalter) {
		initComponents();
		this.verwalter = derVerwalter;
		this.verwalter.addObserver(this);
		this.verwalter.getMedienVerwalter().addObserver(this);
		this.verwalter.getMedienVerwalter().getExemplarVerwalter().addObserver(this);
		this.verwalter.getWarenKorbVerwalter().addObserver(this);
		this.verwalter.getAusleiherVerwalter().addObserver(this);
		this.ausleiherButton.addActionListener(new AusleiherWahlenActionListener(this.verwalter));
	}
	/** 
	 * Erzeugt die obigen Komponenten auf dem MainPanel
	 */
	@SuppressWarnings("unchecked")
	private void initComponents() {

		ausleiherButton = new javax.swing.JButton();
		eintraegePanel = new javax.swing.JPanel();

		setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Buchkiste", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 0, 12), new java.awt.Color(0, 0, 0))); // NOI18N
		setMaximumSize(new java.awt.Dimension(181, 219));
		setOpaque(false);
		setPreferredSize(new java.awt.Dimension(181, 219));

		ausleiherButton.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
		ausleiherButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/bibliotheksverwaltung/view/images/user_24.png"))); // NOI18N
		ausleiherButton.setText("Ausleiher waehlen");
		ausleiherButton.setHorizontalAlignment(javax.swing.SwingConstants.LEADING);
		ausleiherButton.setMargin(new java.awt.Insets(2, 2, 2, 2));

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
		this.setLayout(layout);
		layout.setHorizontalGroup(
				layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addComponent(ausleiherButton, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
				.addComponent(eintraegePanel, javax.swing.GroupLayout.DEFAULT_SIZE, 165, Short.MAX_VALUE)
		);
		layout.setVerticalGroup(
				layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(layout.createSequentialGroup()
						.addComponent(ausleiherButton)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
						.addComponent(eintraegePanel, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE))
		);
	}// </editor-fold>//GEN-END:initComponents


	/*
	 * Versetzt den Warenkorb in seinen Ursprungszustand
	 */
	public void resetWarenkorb()
	{
		this.eintraegePanel.removeAll();
		this.verwalter.getWarenKorbVerwalter().leereWarenKorb();
		this.ausleiherButton.setText("Ausleiher Waehlen");
		this.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Buchkiste", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 0, 12), new java.awt.Color(0, 0, 0)));
		ausleiherButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/bibliotheksverwaltung/view/images/user_24.png"))); // NOI18N
		this.ausleiherButton.addActionListener(new AusleiherWahlenActionListener(this.verwalter));
		//		this.ausleiherButton.addActionListener(new AusleiherWahlenActionListener());
	}

	/* (non-Javadoc)
	 * @see java.util.Observer#update(java.util.Observable, java.lang.Object)
	 */
	@Override
	public void update(Observable o, Object arg)
	{
		UpdateInfo updateInfo = (UpdateInfo) arg;
		System.out.println(updateInfo.holeAenderung());
		if (updateInfo.holeAenderung().equals("AktualisiereWarenkorb"))
		{
			if (updateInfo.holeAenderungOk())
			{
				this.eintraegePanel.removeAll();
				this.setPreferredSize(new Dimension(165, 149));
				for (int i = 0; i < this.verwalter.getWarenKorbVerwalter().getWarenKorb().size(); i++)
				{
					this.eintraegePanel.setLayout(new GridLayout(i+1,1));
					WarenkorbEintragPanel eintrag = new WarenkorbEintragPanel(this.verwalter, this.verwalter.getWarenKorbVerwalter().getWarenKorb().get(i));
					this.eintraegePanel.add(eintrag);
				}
				if (this.verwalter.getWarenKorbVerwalter().getAusleiher() != null)
				{
					this.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Buchkiste fuer " + this.verwalter.getAusleiherVerwalter().getAusleiher().getJoinedName(), javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 0, 12), new java.awt.Color(0, 0, 0)));
					this.ausleiherButton.setText("Ausleihen");
					this.verwalter.getWarenKorbVerwalter().setAusleiher(this.verwalter.getAusleiherVerwalter().getAusleiher());					
					this.ausleiherButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/bibliotheksverwaltung/view/images/arrow_right_green_24.png")));
					this.ausleiherButton.addActionListener(new WarenKorbAusleihenActionListener(this.verwalter));
				}
			}
		}
		else if (updateInfo.holeAenderung().equals("BuchKistePerson") || updateInfo.holeAenderung().equals("PersonDatenBearbeitet"))
		{
			if (updateInfo.holeAenderungOk())
			{
				this.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Buchkiste fuer " + this.verwalter.getAusleiherVerwalter().getAusleiher().getJoinedName(), javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 0, 12), new java.awt.Color(0, 0, 0)));
				this.ausleiherButton.setText("Ausleihen");
				this.verwalter.getWarenKorbVerwalter().setAusleiher(this.verwalter.getAusleiherVerwalter().getAusleiher());
				this.ausleiherButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/bibliotheksverwaltung/view/images/arrow_right_green_24.png")));
				this.ausleiherButton.addActionListener(new WarenKorbAusleihenActionListener(this.verwalter));
			}
		}
		else if (updateInfo.holeAenderung().equals("WarenKorbReset"))
		{
			if (updateInfo.holeAenderungOk())
			{
				this.resetWarenkorb();
			}
		}
		this.repaint();
		this.revalidate();
	}

}
