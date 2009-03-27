/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * suchPanel.java
 *
 * Created on 19.03.2009, 10:36:08
 */
package bibliotheksverwaltung.view;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.awt.event.FocusListener;

import bibliotheksverwaltung.controller.DatenDruckenActionListener;
import bibliotheksverwaltung.controller.SearchBookListener;
import bibliotheksverwaltung.controller.SearchKeyListener;
import bibliotheksverwaltung.controller.SearchPersonListener;
import bibliotheksverwaltung.model.logic.BibliotheksVerwalter;

/**
 * Das Suchpanel bietet ein Suchfeld mit der Option zur Suche von Büchern oder Ausleihern. Ferner 
 * lassen sich die Suchergebnisse ausdrucken. 
 * Bei der Suche handelt es sich um eine Alternativsuche, die bei keinem, einen oder mehreren Treffern trotzdem 
 * Alternativen anbietet.
 * @author Max
 */
@SuppressWarnings("serial")
public class SuchPanel extends javax.swing.JPanel implements FocusListener, ActionListener {

	// Variables declaration - do not modify//GEN-BEGIN:variables
	/**Bezeichnet den LöschenButton*/
	private javax.swing.JButton clearButton;
	/**Bezeichnet die outputPane*/
	private javax.swing.JScrollPane outputPanel;
	/**Bezeichnet den DruckenButton*/
	private javax.swing.JButton printButton;
	/**Bezeichnet den Bereich auf dem die SUchergebnisse ausgegeben werden*/
	private OutputArea resultArea = null;
	/**Bezeichnet das SucheButton*/
	private javax.swing.JButton searchBook;
	/**Bezeichnet das Suchfeld*/
	private javax.swing.JTextField searchField;
	/**Bezeichnet den suchebutton*/
	private javax.swing.JButton searchPerson;
	// End of variables declaration//GEN-END:variables
	/**Bezeichnet den Verwalter*/
	private BibliotheksVerwalter verwalter = null;

	// Code for dispatching events from components to event handlers.

	/** Erzeugt ein neues suchPanel */
	public SuchPanel() {
		initComponents();
		this.verwalter = new BibliotheksVerwalter();
		this.init2nd();
	}

	public SuchPanel(BibliotheksVerwalter derVerwalter, boolean personButtonAnzeigen, boolean buchButtonAnzeigen) {
		initComponents();
		this.verwalter = derVerwalter;
		searchPerson.setVisible(personButtonAnzeigen);
		searchBook.setVisible(buchButtonAnzeigen);
		this.init2nd();
	}

	public void actionPerformed(java.awt.event.ActionEvent evt) {
		if (evt.getSource() == clearButton) {
			SuchPanel.this.clearButtonActionPerformed(evt);
		}
	}

	private void clearButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearButtonActionPerformed
		searchField.setForeground(new java.awt.Color(204, 204, 204));
		searchField.setText("Suchworte eingeben...");
		resultArea.removeAll();
		verwalter.autoNotify("WarenKorbReset");        
		this.resultArea.setPreferredSize((new Dimension((int) outputPanel.getSize().getWidth() - 10, (int) outputPanel.getSize().getWidth())));
		outputPanel.repaint();
	}//GEN-LAST:event_clearButtonActionPerformed

	public void focusGained(java.awt.event.FocusEvent evt) {
		if (evt.getSource() == searchField) {
			SuchPanel.this.searchFieldFocusGained(evt);
		}
	}

	public void focusLost(java.awt.event.FocusEvent evt) {
		if (evt.getSource() == searchField) {
			SuchPanel.this.searchFieldFocusLost(evt);
		}
	}// </editor-fold>//GEN-END:initComponents

	/**
	 * @return the resultArea
	 */
	public OutputArea getResultArea() {
		return resultArea;
	}
	private void init2nd() {
		this.resultArea = new OutputArea(verwalter);
		this.resultArea.setBorder(null);
		this.outputPanel.setBorder(null);
		this.resultArea.setLayout(new FlowLayout());
		this.outputPanel.setViewportView(resultArea);
		this.resultArea.setPreferredSize((new Dimension((int) outputPanel.getSize().getWidth() - 10, (int) outputPanel.getSize().getWidth())));
		//Listener
		this.searchBook.addActionListener(new SearchBookListener(verwalter, searchField));
		this.searchPerson.addActionListener(new SearchPersonListener(verwalter, searchField));
		this.searchField.addKeyListener(new SearchKeyListener(verwalter, searchField));
		this.printButton.addActionListener(new DatenDruckenActionListener(this.verwalter));
	}
	/** 
	 * Erzeugt die obigen Komponenten auf dem MainPanel
	 */
	@SuppressWarnings("unchecked")
	private void initComponents() {

		clearButton = new javax.swing.JButton();
		searchBook = new javax.swing.JButton();
		searchPerson = new javax.swing.JButton();
		printButton = new javax.swing.JButton();
		searchField = new javax.swing.JTextField();
		outputPanel = new javax.swing.JScrollPane();

		setPreferredSize(new java.awt.Dimension(593, 600));

		clearButton.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
		clearButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/bibliotheksverwaltung/view/images/cancel_32.png"))); // NOI18N
		clearButton.setToolTipText("Suchfeld leeren");
		clearButton.setMaximumSize(new java.awt.Dimension(41, 41));
		clearButton.setMinimumSize(new java.awt.Dimension(41, 41));
		clearButton.setPreferredSize(new java.awt.Dimension(41, 41));
		clearButton.addActionListener(this);

		searchBook.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
		searchBook.setIcon(new javax.swing.ImageIcon(getClass().getResource("/bibliotheksverwaltung/view/images/Book 4.png"))); // NOI18N
		searchBook.setToolTipText("Nach BÃ¼chern suchen (Enter)");
		searchBook.setMargin(new java.awt.Insets(2, 5, 2, 5));
		searchBook.setMaximumSize(new java.awt.Dimension(41, 41));
		searchBook.setMinimumSize(new java.awt.Dimension(41, 41));
		searchBook.setPreferredSize(new java.awt.Dimension(41, 41));

		searchPerson.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
		searchPerson.setIcon(new javax.swing.ImageIcon(getClass().getResource("/bibliotheksverwaltung/view/images/user_32.png"))); // NOI18N
		searchPerson.setToolTipText("Nach Personen suchen (Strg + Enter)");
		searchPerson.setMargin(new java.awt.Insets(2, 5, 2, 5));

		printButton.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
		printButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/bibliotheksverwaltung/view/images/printer_32.png"))); // NOI18N
		printButton.setToolTipText("Aktuelle Ausgabe drucken");
		printButton.setMargin(new java.awt.Insets(2, 5, 2, 5));

		searchField.setFont(new java.awt.Font("Arial", 1, 18));
		searchField.setForeground(new java.awt.Color(204, 204, 204));
		searchField.setText("Suchworte eingeben...");
		searchField.addFocusListener(this);

		outputPanel.setBorder(null);
		outputPanel.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		outputPanel.setMaximumSize(new java.awt.Dimension(573, 533));
		outputPanel.setMinimumSize(new java.awt.Dimension(573, 533));
		outputPanel.setPreferredSize(new java.awt.Dimension(573, 533));

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
		this.setLayout(layout);
		layout.setHorizontalGroup(
				layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(layout.createSequentialGroup()
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addComponent(outputPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addGroup(layout.createSequentialGroup()
										.addComponent(clearButton, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
										.addComponent(searchField, javax.swing.GroupLayout.DEFAULT_SIZE, 364, Short.MAX_VALUE)
										.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
										.addComponent(searchBook, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
										.addComponent(searchPerson)
										.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
										.addComponent(printButton)
										.addGap(1, 1, 1)))
										.addGap(20, 20, 20))
		);
		layout.setVerticalGroup(
				layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
						.addContainerGap()
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addComponent(searchPerson, 0, 0, Short.MAX_VALUE)
								.addComponent(clearButton, 0, 0, Short.MAX_VALUE)
								.addComponent(searchBook, 0, 0, Short.MAX_VALUE)
								.addComponent(searchField, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(printButton, 0, 0, Short.MAX_VALUE))
								.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
								.addComponent(outputPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 533, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addContainerGap())
		);
	}
	private void searchFieldFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_searchFieldFocusGained
		if (searchField.getText().equals("Suchworte eingeben...")) {
			searchField.setText("");
			searchField.setForeground(new java.awt.Color(0, 0, 0));
		}
	}//GEN-LAST:event_searchFieldFocusGained
	private void searchFieldFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_searchFieldFocusLost
		if (searchField.getText().isEmpty()) {
			searchField.setForeground(new java.awt.Color(204, 204, 204));
			searchField.setText("Suchworte eingeben...");
		}
	}//GEN-LAST:event_searchFieldFocusLost
	/**
	 * @param resultArea the resultArea to set
	 */
	public void setResultArea(OutputArea resultArea) {
		this.resultArea = resultArea;
	}
}
