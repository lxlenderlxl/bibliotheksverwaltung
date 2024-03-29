/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * BuchEinzelansichtPanel.java
 *
 * Created on 20.03.2009, 14:10:17
 */
package bibliotheksverwaltung.view;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JFrame;

import bibliotheksverwaltung.controller.BuchDatenBearbeitenActionListener;
import bibliotheksverwaltung.controller.BuchHistorieActionListener;
import bibliotheksverwaltung.controller.ExemplarHinzuListener;
import bibliotheksverwaltung.model.domain.Exemplar;
import bibliotheksverwaltung.model.domain.Log;
import bibliotheksverwaltung.model.domain.Medium;
import bibliotheksverwaltung.model.logic.BibliotheksVerwalter;
import bibliotheksverwaltung.util.UpdateInfo;

/**
 * Die Bucheinzelansicht stellt ein Buch detailliert dar. Unter anderem werden alle verf�gbaren Exemplare zu jedem aktuell
 * ausgeliehenem Buch und dessen Ausleiher dargestellt und k�nnen je nach Wunsch bearbeitet werden.
 * 
 * Weiterhin kann dieses Buch bearbeitet und relevante Daten augedruckt werden.
 * @author Sven
 */
public class BuchEinzelansichtPanel extends javax.swing.JPanel implements Observer {

	/**
	 * Dient nur zum Test um eine Testansicht relevanter Dtane zu erzeugen
	 * @param args Argumente
	 */
	public static void main(String args[]) {
		JFrame jframe = new JFrame();
		jframe.setSize(200, 265);
		Medium einMedium = new Medium(5);
		einMedium.erzeugeExemplare();
		jframe.add(new BuchEinzelansichtPanel(new BibliotheksVerwalter()));
		jframe.setVisible(true);
		jframe.setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
	}

	// Variables declaration - do not modify//GEN-BEGIN:variables
	/**Bezeichnet den Hinzuf�gen Button*/
	private javax.swing.JButton addButton;
	/**Bezeichnet das Auswahlmenue*/
	private javax.swing.JPanel aktionenPanel;
	/**Bezeichnet die detaillierte Buchansicht*/
	private javax.swing.JPanel buchansichtPanel;
	/**Bezeichnet den Bearbeiten Button*/
	private javax.swing.JButton editButton;

	/**Bezeichnet das exemplarPanel*/
	private javax.swing.JPanel exemplarePanel;
	/**Bezeichnet die scrollbare ExemplarPane*/
	private javax.swing.JScrollPane exemplarPane;
	/**Bezeichnet den HistoryButton*/
	private javax.swing.JButton historyButton;
	/**Bezeichnet den DruckButton*/
	private javax.swing.JButton printButton;
	// End of variables declaration//GEN-END:variables

	/**Bezeichnet den Bibliotheksverwalter*/
	private BibliotheksVerwalter verwalter = null;

	/** Erzeugt ein neues BuchEinzelansichtPanel */
	public BuchEinzelansichtPanel(BibliotheksVerwalter derVerwalter) {
		initComponents();
		this.verwalter = derVerwalter;
		this.verwalter.getMedienVerwalter().erzeugeExemplare();
		this.buchansichtPanel.add(new BuchAnsicht(this.verwalter));
		this.erzeugeExemplarAnsichten();
		this.addButton.addActionListener(new ExemplarHinzuListener(verwalter));
		this.editButton.addActionListener(new BuchDatenBearbeitenActionListener(verwalter));
		this.historyButton.addActionListener(new BuchHistorieActionListener(this.verwalter));
		this.verwalter.addObserver(this);
		this.verwalter.getMedienVerwalter().addObserver(this);
		this.verwalter.getMedienVerwalter().getExemplarVerwalter().deleteObservers();
		this.verwalter.getMedienVerwalter().getExemplarVerwalter().addObserver(this);
		this.verwalter.getHistorienVerwalter().addObserver(this);
		this.verwalter.fuegeObserverHinzu(this);
	}
	/*
	 * Erzeugt die detaillierten Ansichten der Exemplare
	 */
	@SuppressWarnings("unchecked")
	private void erzeugeExemplarAnsichten() {
		exemplarePanel.setLayout(new FlowLayout());
		exemplarePanel.setPreferredSize(new Dimension((int)exemplarePanel.getPreferredSize().getWidth(), 26));
		this.verwalter.getDruckVerwalter().fuegeObjekteHinzu((ArrayList<Exemplar>)this.verwalter.getMedienVerwalter().getMedium().getExemplare().clone());
		for (int i = 0; i < this.verwalter.getMedienVerwalter().getMedium().getExemplare().size(); i++) {
			//TODO GridBagLayout entfernen, von Hand gesetzt, da sonst keine Exemplaransichten...            
			exemplarePanel.setPreferredSize(new Dimension((int)exemplarePanel.getPreferredSize().getWidth(), (int)exemplarePanel.getPreferredSize().getHeight() + 26));
			AusleiheEinzelansichtPanel panel = new AusleiheEinzelansichtPanel(this.verwalter, this.verwalter.getMedienVerwalter().getMedium().getExemplare().get(i));
			exemplarePanel.add(panel);
		}
	}

	/** 
	 * Erzeugt die obigen Komponenten auf dem MainPanel
	 */
	@SuppressWarnings("unchecked")
	private void initComponents() {

		buchansichtPanel = new javax.swing.JPanel();
		aktionenPanel = new javax.swing.JPanel();
		addButton = new javax.swing.JButton();
		editButton = new javax.swing.JButton();
		historyButton = new javax.swing.JButton();
		printButton = new javax.swing.JButton();
		exemplarPane = new javax.swing.JScrollPane();
		exemplarePanel = new javax.swing.JPanel();

		setPreferredSize(new java.awt.Dimension(573, 533));

		buchansichtPanel.setOpaque(false);

		javax.swing.GroupLayout buchansichtPanelLayout = new javax.swing.GroupLayout(buchansichtPanel);
		buchansichtPanel.setLayout(buchansichtPanelLayout);
		buchansichtPanelLayout.setHorizontalGroup(
				buchansichtPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGap(0, 300, Short.MAX_VALUE)
		);
		buchansichtPanelLayout.setVerticalGroup(
				buchansichtPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGap(0, 245, Short.MAX_VALUE)
		);

		aktionenPanel.setOpaque(false);

		addButton.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
		addButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/bibliotheksverwaltung/view/images/add_48.png"))); // NOI18N
		addButton.setText("Exemplar hinzufuegen");
		addButton.setHorizontalAlignment(javax.swing.SwingConstants.LEADING);
		addButton.setIconTextGap(10);

		editButton.setFont(new java.awt.Font("Arial", 0, 14));
		editButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/bibliotheksverwaltung/view/images/pencil_48.png"))); // NOI18N
		editButton.setText("Daten bearbeiten");
		editButton.setHorizontalAlignment(javax.swing.SwingConstants.LEADING);
		editButton.setIconTextGap(10);

		historyButton.setFont(new java.awt.Font("Arial", 0, 14));
		historyButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/bibliotheksverwaltung/view/images/clock_48.png"))); // NOI18N
		historyButton.setText("Historie anzeigen");
		historyButton.setHorizontalAlignment(javax.swing.SwingConstants.LEADING);
		historyButton.setIconTextGap(10);

		printButton.setFont(new java.awt.Font("Arial", 0, 14));
		printButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/bibliotheksverwaltung/view/images/printer_48.png"))); // NOI18N
		printButton.setText("Daten drucken");
		printButton.setHorizontalAlignment(javax.swing.SwingConstants.LEADING);
		printButton.setIconTextGap(10);

		javax.swing.GroupLayout aktionenPanelLayout = new javax.swing.GroupLayout(aktionenPanel);
		aktionenPanel.setLayout(aktionenPanelLayout);
		aktionenPanelLayout.setHorizontalGroup(
				aktionenPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(aktionenPanelLayout.createSequentialGroup()
						.addContainerGap()
						.addGroup(aktionenPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addComponent(printButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 247, Short.MAX_VALUE)
								.addComponent(historyButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 247, Short.MAX_VALUE)
								.addComponent(editButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 247, Short.MAX_VALUE)
								.addComponent(addButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
		);
		aktionenPanelLayout.setVerticalGroup(
				aktionenPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(javax.swing.GroupLayout.Alignment.TRAILING, aktionenPanelLayout.createSequentialGroup()
						.addContainerGap()
						.addComponent(addButton)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(editButton)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
						.addComponent(historyButton)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
						.addComponent(printButton))
		);

		exemplarPane.setBorder(null);
		exemplarPane.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		exemplarPane.setPreferredSize(new java.awt.Dimension(573, 258));

		exemplarePanel.setOpaque(false);
		exemplarePanel.setPreferredSize(new java.awt.Dimension(573, 258));
		exemplarePanel.setLayout(new java.awt.GridLayout(1, 0));
		exemplarPane.setViewportView(exemplarePanel);

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
		this.setLayout(layout);
		layout.setHorizontalGroup(
				layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
						.addContainerGap()
						.addComponent(buchansichtPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
						.addComponent(aktionenPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
						.addComponent(exemplarPane, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
		);
		layout.setVerticalGroup(
				layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(layout.createSequentialGroup()
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addComponent(aktionenPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addGroup(layout.createSequentialGroup()
										.addGap(11, 11, 11)
										.addComponent(buchansichtPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
										.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
										.addComponent(exemplarPane, javax.swing.GroupLayout.DEFAULT_SIZE, 270, Short.MAX_VALUE))
		);
	}// </editor-fold>//GEN-END:initComponents

	/* (non-Javadoc)
	 * @see java.util.Observer#update(java.util.Observable, java.lang.Object)
	 */
	@Override
	public void update(Observable o, Object arg) {
		UpdateInfo updateInfo = (UpdateInfo) arg;
		if (updateInfo.holeAenderung().equals("ExemplarHinzu"))
		{
			if (updateInfo.holeAenderungOk())
			{
				this.exemplarePanel.removeAll();
				this.verwalter.getMedienVerwalter().erzeugeExemplare();
			}
		}
		else if (updateInfo.holeAenderung().equals("ExemplarGeloescht"))
		{
			if (updateInfo.holeAenderungOk())
			{
				this.exemplarePanel.removeAll();
				this.verwalter.getMedienVerwalter().erzeugeExemplare();
			}
		}
		else if (updateInfo.holeAenderung().equals("ExemplarAusleihen"))
		{
			if (updateInfo.holeAenderungOk())
			{
				this.exemplarePanel.removeAll();
				this.verwalter.getMedienVerwalter().erzeugeExemplare();
			}
		}
		else if (updateInfo.holeAenderung().equals("ExemplarZurueck"))
		{
			if (updateInfo.holeAenderungOk())
			{
				this.exemplarePanel.removeAll();
				this.verwalter.getMedienVerwalter().erzeugeExemplare();
			}
		}
		else if (updateInfo.holeAenderung().equals("ExemplarVerlaengern"))
		{
			if (updateInfo.holeAenderungOk())
			{
				this.exemplarePanel.removeAll();
				this.verwalter.getMedienVerwalter().erzeugeExemplare();
			}
		}
		else if (updateInfo.holeAenderung().equals("Abbrechen"))
		{
			if (updateInfo.holeAenderungOk())
			{
				this.exemplarePanel.removeAll();
				this.verwalter.getMedienVerwalter().erzeugeExemplare();
			}
		}
		else if (updateInfo.holeAenderung().equals("MediumBearbeiten"))
		{
			if (updateInfo.holeAenderungOk())
			{
				this.exemplarePanel.removeAll();
				this.verwalter.getMedienVerwalter().erzeugeExemplare();
			}
		}
		else if (updateInfo.holeAenderung().equals("ExemplareErzeugt"))
		{
			if (updateInfo.holeAenderungOk())
			{
				this.exemplarePanel.removeAll();
				this.erzeugeExemplarAnsichten();
			}
		}
		else if (updateInfo.holeAenderung().equals("DatenBearbeiten"))
		{
			if (updateInfo.holeAenderungOk())
			{
				this.exemplarePanel.removeAll();
				this.exemplarePanel.setPreferredSize(new Dimension(573,258));
				BuchHinzufuegenPanel hinzuPanel = new BuchHinzufuegenPanel(this.verwalter,true);
				hinzuPanel.setSize(this.exemplarePanel.getSize());
				this.exemplarePanel.add(hinzuPanel);
			}
		}
		else if (updateInfo.holeAenderung().equals("HistorieErzeugt"))
		{
			if (updateInfo.holeAenderungOk())
			{
				this.exemplarePanel.removeAll();
				this.exemplarePanel.setPreferredSize(new Dimension(573,26));
				ArrayList<Log> logs = this.verwalter.getHistorienVerwalter().getLogs();
				this.verwalter.getDruckVerwalter().fuegeObjekteHinzu(logs);
				for (int i = 0; i < logs.size(); i++)
				{
					this.exemplarePanel.setPreferredSize(new Dimension(573, i*26));
					this.exemplarePanel.add(new LogAnsichtPanel(logs.get(i)));
				}
			}
		}
		this.repaint();
		this.revalidate();
	}
}
