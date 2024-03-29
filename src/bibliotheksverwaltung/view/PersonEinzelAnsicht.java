/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * PersonEinzelAnsicht.java
 *
 * Created on 24.03.2009, 22:32:05
 */

package bibliotheksverwaltung.view;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

import bibliotheksverwaltung.controller.DatenDruckenActionListener;
import bibliotheksverwaltung.controller.PersonDatenBearbeitenActionListener;
import bibliotheksverwaltung.controller.PersonEntfernenActionListener;
import bibliotheksverwaltung.controller.PersonHistorieActionListener;
import bibliotheksverwaltung.model.domain.Exemplar;
import bibliotheksverwaltung.model.domain.Log;
import bibliotheksverwaltung.model.logic.BibliotheksVerwalter;
import bibliotheksverwaltung.util.UpdateInfo;

/**
 * Die Personeinzelansicht stellt eine Person detailliert dar. Unter anderem werden die Ausleihdaten zu jedem aktuell
 * ausgeliehenem Buch dieser Person dargestellt und k�nnen je nach Wunsch bearbeitet werden.
 * 
 * Weiterhin kann diese Person bearbeitet und relevante Daten augedruckt werden.
 * @author Sven
 */
public class PersonEinzelAnsicht extends javax.swing.JPanel implements Observer {

	/**Bezeichnet den HinzufuegenButton*/
	private javax.swing.JButton addButton;
	/**Bezeichnet das ButtonPanel*/
	private javax.swing.JPanel aktionenPanel;
	/**Bezeichnet das scrollbare ausleihPanel*/
	private javax.swing.JScrollPane ausleihPane;
	/**Bezeichnet das AusleiherPanel*/
	private javax.swing.JPanel ausleihPanel;

	/**Bezeichnet den Bearbeiten-Button*/
	private javax.swing.JButton editButton;
	/**Bezeichnet dden History Button*/
	private javax.swing.JButton historyButton;
	/**Bezeichnet das AusleiherPanel*/
	private javax.swing.JPanel personenansichtPanel;
	/**Bezeichnet den Drucken Button*/
	private javax.swing.JButton printButton;
	// End of variables declaration//GEN-END:variables
	/**Bezeichnet den Verwaltet*/
	private BibliotheksVerwalter verwalter = null;
	/** Erzeugt eine neue PersonEinzelAnsicht */
	public PersonEinzelAnsicht(BibliotheksVerwalter derVerwalter) {
		initComponents();
		this.verwalter = derVerwalter;
		this.personenansichtPanel.add(new PersonenAnsicht(this.verwalter));		
		erzeugeAusleihAnsichten();
		this.editButton.addActionListener(new PersonDatenBearbeitenActionListener(verwalter));
		this.historyButton.addActionListener(new PersonHistorieActionListener(this.verwalter));
    this.printButton.addActionListener(new DatenDruckenActionListener(this.verwalter));
    this.addButton.addActionListener(new PersonEntfernenActionListener(this.verwalter));
		this.verwalter.addObserver(this);
		this.verwalter.getAusleiherVerwalter().addObserver(this);
		this.verwalter.getHistorienVerwalter().addObserver(this);
		this.verwalter.fuegeObserverHinzu(this);
	}
	/**
	 * Erzeugt die Ansicht der aktuellen Ausleihen eines Ausleihers
	 */
	@SuppressWarnings("unchecked")
	private void erzeugeAusleihAnsichten() {
		this.verwalter.getDruckVerwalter().clearAll();
		this.ausleihPanel.setLayout(new FlowLayout());
		ausleihPanel.setPreferredSize(new Dimension((int)ausleihPanel.getPreferredSize().getWidth(), 26));
		ArrayList<Exemplar> gelieheneExemplare = this.verwalter.getAusleiherVerwalter().getAusgelieheneExemplare();
		this.verwalter.getDruckVerwalter().fuegeObjekteHinzu((ArrayList<Exemplar>)gelieheneExemplare.clone());
		for (int i = 0; i < gelieheneExemplare.size(); i++) {
			//TODO GridBagLayout entfernen, von Hand gesetzt, da sonst keine Exemplaransichten...            
			ausleihPanel.setPreferredSize(new Dimension((int)ausleihPanel.getPreferredSize().getWidth(), (int)ausleihPanel.getPreferredSize().getHeight() + 26));
			AusleiheEinzelansichtPanel panel = new AusleiheEinzelansichtPanel(this.verwalter, gelieheneExemplare.get(i));
			ausleihPanel.add(panel);
		}
	}
	/** 
	 * Erzeugt die obigen Komponenten auf dem MainPanel
	 */
	@SuppressWarnings("unchecked")
	// <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
	private void initComponents() {

		personenansichtPanel = new javax.swing.JPanel();
		aktionenPanel = new javax.swing.JPanel();
		addButton = new javax.swing.JButton();
		editButton = new javax.swing.JButton();
		historyButton = new javax.swing.JButton();
		printButton = new javax.swing.JButton();
		ausleihPane = new javax.swing.JScrollPane();
		ausleihPanel = new javax.swing.JPanel();

		setPreferredSize(new java.awt.Dimension(573, 533));

		personenansichtPanel.setOpaque(false);

		javax.swing.GroupLayout personenansichtPanelLayout = new javax.swing.GroupLayout(personenansichtPanel);
		personenansichtPanel.setLayout(personenansichtPanelLayout);
		personenansichtPanelLayout.setHorizontalGroup(
				personenansichtPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGap(0, 308, Short.MAX_VALUE)
		);
		personenansichtPanelLayout.setVerticalGroup(
				personenansichtPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGap(0, 245, Short.MAX_VALUE)
		);

		aktionenPanel.setOpaque(false);

		addButton.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
		addButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/bibliotheksverwaltung/view/images/cancel_48.png"))); // NOI18N
		addButton.setText("Person entfernen");
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
								.addComponent(printButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 239, Short.MAX_VALUE)
								.addComponent(historyButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 239, Short.MAX_VALUE)
								.addComponent(editButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 239, Short.MAX_VALUE)
								.addComponent(addButton, javax.swing.GroupLayout.DEFAULT_SIZE, 239, Short.MAX_VALUE)))
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

		ausleihPane.setBorder(null);
		ausleihPane.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		ausleihPane.setPreferredSize(new java.awt.Dimension(573, 258));

		ausleihPanel.setOpaque(false);
		ausleihPanel.setPreferredSize(new java.awt.Dimension(573, 258));
		ausleihPanel.setLayout(new java.awt.GridLayout());
		ausleihPane.setViewportView(ausleihPanel);

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
		this.setLayout(layout);
		layout.setHorizontalGroup(
				layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGap(0, 573, Short.MAX_VALUE)
				.addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
						.addContainerGap()
						.addComponent(personenansichtPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
						.addComponent(aktionenPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
						.addComponent(ausleihPane, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
		);
		layout.setVerticalGroup(
				layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGap(0, 533, Short.MAX_VALUE)
				.addGroup(layout.createSequentialGroup()
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addComponent(aktionenPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addGroup(layout.createSequentialGroup()
										.addGap(11, 11, 11)
										.addComponent(personenansichtPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
										.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
										.addComponent(ausleihPane, javax.swing.GroupLayout.DEFAULT_SIZE, 270, Short.MAX_VALUE))
		);
	}// </editor-fold>//GEN-END:initComponents

	/**
	 * Bezeichnet die Update-Methode f�r MVC-Pattern zum Aktualisieren der View
	 * @param o Das Observable Objekt
	 * @param arg das aktualisierungsobjekt
	 */
	public void update(Observable o, Object arg) {
		UpdateInfo updateInfo = (UpdateInfo) arg;
		System.out.println(updateInfo.holeAenderung());
		if (updateInfo.holeAenderung().equals("PersonDatenBearbeiten"))
		{
			this.verwalter.getDruckVerwalter().clearAll();
			if (updateInfo.holeAenderungOk())
			{
				this.ausleihPanel.removeAll();
				this.ausleihPanel.setPreferredSize(new Dimension(573,258));
				PersonHinzufuegenPanel hinzuPanel = new PersonHinzufuegenPanel(this.verwalter,true);
				hinzuPanel.setSize(this.ausleihPanel.getSize());
				this.ausleihPanel.add(hinzuPanel);
			}
		}
		else if (updateInfo.holeAenderung().equals("PersonDatenBearbeitet"))
		{
			if (updateInfo.holeAenderungOk())
			{
				this.ausleihPanel.removeAll();
				this.verwalter.getAusleiherVerwalter().erzeugeAusgelieheneExemplare();
			}
		}
		else if (updateInfo.holeAenderung().equals("PersonenExemplareErzeugt"))
		{
			if (updateInfo.holeAenderungOk())
			{
				this.ausleihPanel.removeAll();
				this.erzeugeAusleihAnsichten();
			}
		}
		else if (updateInfo.holeAenderung().equals("ExemplarZurueck"))
		{
			this.verwalter.getDruckVerwalter().clearAll();
			if (updateInfo.holeAenderungOk())
			{
				this.ausleihPanel.removeAll();
				this.verwalter.getAusleiherVerwalter().erzeugeAusgelieheneExemplare();
			}
		}
		else if (updateInfo.holeAenderung().equals("ExemplarVerlaengern"))
		{
			if (updateInfo.holeAenderungOk())
			{
				this.ausleihPanel.removeAll();
				this.verwalter.getAusleiherVerwalter().erzeugeAusgelieheneExemplare();
			}
		}
		else if (updateInfo.holeAenderung().equals("HistorieErzeugt"))
		{
			if (updateInfo.holeAenderungOk())
			{
				this.ausleihPanel.removeAll();
				this.ausleihPanel.setPreferredSize(new Dimension(573,26));
				ArrayList<Log> logs = this.verwalter.getHistorienVerwalter().getLogs();
				this.verwalter.getDruckVerwalter().fuegeObjekteHinzu(logs);
				for (int i = 0; i < logs.size(); i++)
				{
					this.ausleihPanel.setPreferredSize(new Dimension(573, i*26));
					this.ausleihPanel.add(new LogAnsichtPanel(logs.get(i)));
				}
			}
		}
		else if (updateInfo.holeAenderung().equals("BuchKistePerson"))
		{
			if (updateInfo.holeAenderungOk())
			{
				this.ausleihPanel.removeAll();
				this.erzeugeAusleihAnsichten();
			}
		}
		else if (updateInfo.holeAenderung().equals("PersonAbbrechen"))
		{
			if (updateInfo.holeAenderungOk())
			{
				this.ausleihPanel.removeAll();
				this.erzeugeAusleihAnsichten();
			}
		}
		this.repaint();
		this.revalidate();
	}

}
