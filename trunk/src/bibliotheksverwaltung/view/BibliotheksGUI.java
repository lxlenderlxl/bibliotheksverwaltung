/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * BibliotheksGUI.java
 *
 * Created on 17.03.2009, 15:56:45
 */
package bibliotheksverwaltung.view;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;
import java.util.Timer;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.UnsupportedLookAndFeelException;

import bibliotheksverwaltung.controller.AddActionListener;
import bibliotheksverwaltung.controller.BuchAnsichtMouseListener;
import bibliotheksverwaltung.controller.PersonAnsichtMouseListener;
import bibliotheksverwaltung.controller.ReportActionListener;
import bibliotheksverwaltung.controller.SearchActionListener;
import bibliotheksverwaltung.model.domain.Ausleiher;
import bibliotheksverwaltung.model.domain.Medium;
import bibliotheksverwaltung.model.logic.BibliotheksVerwalter;
import bibliotheksverwaltung.util.InfoBoxTimer;
import bibliotheksverwaltung.util.LocalEnvironment;
import bibliotheksverwaltung.util.Message;
import bibliotheksverwaltung.util.UpdateInfo;

/**
 *
 * @author Max
 */
@SuppressWarnings("serial")
public class BibliotheksGUI extends javax.swing.JFrame implements Observer, ActionListener {

	private BibliotheksVerwalter verwalter = new BibliotheksVerwalter();

	/** Erzeugt ein neues BibliotheksGUI */
	public BibliotheksGUI() {
		try {
			javax.swing.UIManager.setLookAndFeel(new com.nilo.plaf.nimrod.NimRODLookAndFeel());
		} catch (UnsupportedLookAndFeelException e) {
			LocalEnvironment.log(e.getMessage(), this);
		}
		initComponents();
		Message.setGUI(this);
		setSize(new Dimension(800,600)); // warum auch immer, es geht nur mit
		infoBoxPanel.setVisible(false);
		this.erzeugeWarenKorb();
		verwalter.addObserver(this);
		searchButton.addActionListener(new SearchActionListener(this.verwalter));
		addButton.addActionListener(new AddActionListener(this.verwalter));
		reportButton.addActionListener(new ReportActionListener(this.verwalter));
	}

	/**  
	 * Erzeugt die obigen Komponenten auf dem MainPanel
	 */
	@SuppressWarnings("unchecked")
	private void initComponents() {

		containerPanel = new javax.swing.JPanel();
		menuPanel = new javax.swing.JPanel();
		searchButton = new javax.swing.JButton();
		addButton = new javax.swing.JButton();
		reportButton = new javax.swing.JButton();
		configButton = new javax.swing.JButton();
		infoBoxPanel = new javax.swing.JPanel();
		infoBoxArea = new javax.swing.JTextArea();
		closeInfoBox = new javax.swing.JButton();
		warenkorbPanel = new javax.swing.JPanel();
		mainPanel = new javax.swing.JPanel();

		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
		setTitle("Bibliotheksverwaltung");
		setResizable(false);

		containerPanel.setMaximumSize(new java.awt.Dimension(800, 600));
		containerPanel.setMinimumSize(new java.awt.Dimension(800, 600));
		containerPanel.setPreferredSize(new java.awt.Dimension(800, 600));

		menuPanel.setOpaque(false);

		searchButton.setFont(new java.awt.Font("Arial", 1, 14));
		searchButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/bibliotheksverwaltung/view/images/search_48.png"))); // NOI18N
		searchButton.setText("Suchen");
		searchButton.setHorizontalAlignment(javax.swing.SwingConstants.LEADING);

		addButton.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
		addButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/bibliotheksverwaltung/view/images/add_48.png"))); // NOI18N
		addButton.setText("Hinzufuegen");
		addButton.setHorizontalAlignment(javax.swing.SwingConstants.LEADING);

		reportButton.setFont(new java.awt.Font("Arial", 1, 14));
		reportButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/bibliotheksverwaltung/view/images/pie_chart_48.png"))); // NOI18N
		reportButton.setText("Berichte");
		reportButton.setHorizontalAlignment(javax.swing.SwingConstants.LEADING);

		configButton.setFont(new java.awt.Font("Arial", 1, 14));
		configButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/bibliotheksverwaltung/view/images/spanner_48.png"))); // NOI18N
		configButton.setText("Einstellungen");
		configButton.setHorizontalAlignment(javax.swing.SwingConstants.LEADING);

		infoBoxPanel.setBackground(new java.awt.Color(252, 98, 98));
		infoBoxPanel.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 0, 0), 2, true));
		infoBoxPanel.setMaximumSize(new java.awt.Dimension(181, 87));
		infoBoxPanel.setMinimumSize(new java.awt.Dimension(181, 87));
		infoBoxPanel.setPreferredSize(new java.awt.Dimension(181, 87));

		infoBoxArea.setEditable(false);
		infoBoxArea.setFont(new java.awt.Font("Arial", 1, 12));
		infoBoxArea.setLineWrap(true);
		infoBoxArea.setRows(3);
		infoBoxArea.setText("Das gewuenschte Buch wurde erfolgreich zur Liste hinzugefuegt.");
		infoBoxArea.setWrapStyleWord(true);
		infoBoxArea.setBorder(null);
		infoBoxArea.setMaximumSize(new java.awt.Dimension(157, 61));
		infoBoxArea.setMinimumSize(new java.awt.Dimension(157, 61));
		infoBoxArea.setOpaque(false);
		infoBoxArea.setPreferredSize(new java.awt.Dimension(157, 61));

		closeInfoBox.setIcon(new javax.swing.ImageIcon(getClass().getResource("/bibliotheksverwaltung/view/images/cancel_16.png"))); // NOI18N
		closeInfoBox.setToolTipText("Informationsfenster schließen");
		closeInfoBox.setBorder(null);
		closeInfoBox.setBorderPainted(false);
		closeInfoBox.setContentAreaFilled(false);
		closeInfoBox.setMargin(new java.awt.Insets(0, 0, 0, 0));
		closeInfoBox.setMaximumSize(new java.awt.Dimension(16, 16));
		closeInfoBox.setMinimumSize(new java.awt.Dimension(16, 16));
		closeInfoBox.setPreferredSize(new java.awt.Dimension(16, 16));
		closeInfoBox.addActionListener(this);

		javax.swing.GroupLayout infoBoxPanelLayout = new javax.swing.GroupLayout(infoBoxPanel);
		infoBoxPanel.setLayout(infoBoxPanelLayout);
		infoBoxPanelLayout.setHorizontalGroup(
				infoBoxPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(javax.swing.GroupLayout.Alignment.TRAILING, infoBoxPanelLayout.createSequentialGroup()
						.addContainerGap()
						.addComponent(infoBoxArea, javax.swing.GroupLayout.PREFERRED_SIZE, 147, Short.MAX_VALUE)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
						.addComponent(closeInfoBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
						.addContainerGap())
		);
		infoBoxPanelLayout.setVerticalGroup(
				infoBoxPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(infoBoxPanelLayout.createSequentialGroup()
						.addGroup(infoBoxPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addComponent(closeInfoBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addGroup(infoBoxPanelLayout.createSequentialGroup()
										.addGap(11, 11, 11)
										.addComponent(infoBoxArea, javax.swing.GroupLayout.DEFAULT_SIZE, 61, Short.MAX_VALUE)))
										.addContainerGap())
		);

		warenkorbPanel.setMaximumSize(new java.awt.Dimension(181, 219));
		warenkorbPanel.setMinimumSize(new java.awt.Dimension(181, 219));
		warenkorbPanel.setPreferredSize(new java.awt.Dimension(181, 219));

		javax.swing.GroupLayout warenkorbPanelLayout = new javax.swing.GroupLayout(warenkorbPanel);
		warenkorbPanel.setLayout(warenkorbPanelLayout);
		warenkorbPanelLayout.setHorizontalGroup(
				warenkorbPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGap(0, 181, Short.MAX_VALUE)
		);
		warenkorbPanelLayout.setVerticalGroup(
				warenkorbPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGap(0, 219, Short.MAX_VALUE)
		);

		javax.swing.GroupLayout menuPanelLayout = new javax.swing.GroupLayout(menuPanel);
		menuPanel.setLayout(menuPanelLayout);
		menuPanelLayout.setHorizontalGroup(
				menuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(menuPanelLayout.createSequentialGroup()
						.addContainerGap()
						.addGroup(menuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addComponent(configButton, javax.swing.GroupLayout.DEFAULT_SIZE, 181, Short.MAX_VALUE)
								.addComponent(searchButton, javax.swing.GroupLayout.DEFAULT_SIZE, 181, Short.MAX_VALUE)
								.addComponent(addButton, javax.swing.GroupLayout.DEFAULT_SIZE, 181, Short.MAX_VALUE)
								.addComponent(reportButton, javax.swing.GroupLayout.DEFAULT_SIZE, 181, Short.MAX_VALUE)
								.addComponent(infoBoxPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(warenkorbPanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
								.addContainerGap())
		);
		menuPanelLayout.setVerticalGroup(
				menuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(menuPanelLayout.createSequentialGroup()
						.addContainerGap()
						.addComponent(searchButton)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
						.addComponent(addButton)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
						.addComponent(reportButton)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
						.addComponent(configButton)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
						.addComponent(warenkorbPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 7, Short.MAX_VALUE)
						.addComponent(infoBoxPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
						.addContainerGap())
		);

		mainPanel.setMaximumSize(new java.awt.Dimension(597, 600));
		mainPanel.setMinimumSize(new java.awt.Dimension(597, 600));
		mainPanel.setOpaque(false);
		mainPanel.setPreferredSize(new java.awt.Dimension(597, 600));

		javax.swing.GroupLayout mainPanelLayout = new javax.swing.GroupLayout(mainPanel);
		mainPanel.setLayout(mainPanelLayout);
		mainPanelLayout.setHorizontalGroup(
				mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGap(0, 597, Short.MAX_VALUE)
		);
		mainPanelLayout.setVerticalGroup(
				mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGap(0, 600, Short.MAX_VALUE)
		);

		javax.swing.GroupLayout containerPanelLayout = new javax.swing.GroupLayout(containerPanel);
		containerPanel.setLayout(containerPanelLayout);
		containerPanelLayout.setHorizontalGroup(
				containerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(containerPanelLayout.createSequentialGroup()
						.addComponent(menuPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
						.addComponent(mainPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
						.addGap(4, 4, 4))
		);
		containerPanelLayout.setVerticalGroup(
				containerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(containerPanelLayout.createSequentialGroup()
						.addGroup(containerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addComponent(menuPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(mainPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
								.addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(
				layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addComponent(containerPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
		);
		layout.setVerticalGroup(
				layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(layout.createSequentialGroup()
						.addComponent(containerPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
						.addContainerGap())
		);

		pack();
	}

	// Code for dispatching events from components to event handlers.

	public void actionPerformed(java.awt.event.ActionEvent evt) {
		if (evt.getSource() == closeInfoBox) {
			BibliotheksGUI.this.closeInfoBoxActionPerformed(evt);
		}
	}// </editor-fold>//GEN-END:initComponents

	private void closeInfoBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_closeInfoBoxActionPerformed
		showInfoBox(0, "");
	}//GEN-LAST:event_closeInfoBoxActionPerformed

	/**
	 * @param args the command line arguments
	 */
	public static void main(String args[]) {
		java.awt.EventQueue.invokeLater(new Runnable() {

			public void run() {
				new BibliotheksGUI().setVisible(true);
			}
		});
	}

	// Variables declaration - do not modify//GEN-BEGIN:variables
	private javax.swing.JButton addButton;
	private javax.swing.JButton closeInfoBox;
	private javax.swing.JButton configButton;
	private javax.swing.JPanel containerPanel;
	private javax.swing.JTextArea infoBoxArea;
	private javax.swing.JPanel infoBoxPanel;
	private javax.swing.JPanel mainPanel;
	private javax.swing.JPanel menuPanel;
	private javax.swing.JButton reportButton;
	private javax.swing.JButton searchButton;
	private javax.swing.JPanel warenkorbPanel;
	// End of variables declaration//GEN-END:variables

	public void showInfoBox(int level, String text) {
		// Level: 0: Ausblenden, 1: Grün, 2: Gelb, 3: Rot
		switch (level) {
		case 1:
			infoBoxPanel.setBackground(new java.awt.Color(173, 250, 102));
			infoBoxPanel.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(51, 153, 0), 2, true));
			break;
		case 2:
			infoBoxPanel.setBackground(new java.awt.Color(255, 255, 102));
			infoBoxPanel.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 0), 2, true));
			break;
		case 3:
			infoBoxPanel.setBackground(new java.awt.Color(252, 98, 98));
			infoBoxPanel.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 0, 0), 2, true));
		}
		infoBoxArea.setText(text);
		infoBoxPanel.setVisible(level > 0);
		if (level > 0)
			new Timer().schedule(new InfoBoxTimer(this), 7000);
	}


	/* (non-Javadoc)
	 * @see java.util.Observer#update(java.util.Observable, java.lang.Object)
	 */
	@Override
	public void update(Observable o, Object arg) {
		UpdateInfo updateInfo = (UpdateInfo) arg;
		String ausgabe = "";
		if (updateInfo.holeAenderung().equals("Suche")) {
			if (updateInfo.holeAenderungOk()) {
				mainPanel.removeAll();
				SuchPanel suchPanel = new SuchPanel(this.verwalter, true, true);
				suchPanel.setSize(mainPanel.getSize());
				mainPanel.add(suchPanel);
			}
		} else if (updateInfo.holeAenderung().equals("Hinzufuegen")) {
			if (updateInfo.holeAenderungOk()) {
				mainPanel.removeAll();
				JPanel hinzuPanel = new JPanel();

				hinzuPanel.setLayout(new GridLayout(2, 1));
				hinzuPanel.setSize(mainPanel.getPreferredSize());
				PersonHinzufuegenPanel persoPanel = new PersonHinzufuegenPanel(this.verwalter, false);
				BuchHinzufuegenPanel buchPanel = new BuchHinzufuegenPanel(this.verwalter, false);
				hinzuPanel.add(persoPanel);
				hinzuPanel.add(buchPanel);
				SuchPanel suchPanel = new SuchPanel(this.verwalter, true, true);
				suchPanel.setSize(mainPanel.getSize());
				suchPanel.getResultArea().add(hinzuPanel);
				mainPanel.add(suchPanel);
			}
		} 
		else if (updateInfo.holeAenderung().equals("Report")) {
			if (updateInfo.holeAenderungOk()) {
				mainPanel.removeAll();
				ReportPanel reportPanel = new ReportPanel();
				reportPanel.setSize(mainPanel.getSize());
				mainPanel.add(reportPanel);
			}
		}
		
		this.mainPanel.repaint();
		this.mainPanel.revalidate();
	}

	private void erzeugeWarenKorb()
	{
		warenkorbPanel.removeAll();
		WarenkorbPanel warenkorb = new WarenkorbPanel(this.verwalter);
		warenkorb.setSize(this.warenkorbPanel.getPreferredSize());
		warenkorbPanel.add(warenkorb);
	}
}
