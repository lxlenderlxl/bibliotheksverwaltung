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

import bibliotheksverwaltung.controller.SearchBookListener;
import bibliotheksverwaltung.controller.SearchPersonListener;
import bibliotheksverwaltung.model.logic.BibliotheksVerwalter;
import bibliotheksverwaltung.model.logic.MedienVerwalter;
import bibliotheksverwaltung.model.logic.SuchVerwalter;

/**
 *
 * @author Max
 */
public class SuchPanel extends javax.swing.JPanel implements FocusListener, ActionListener {

	private BibliotheksVerwalter verwalter = null;
  private OutputArea resultArea = null;

	
	/**
	 * @return the resultArea
	 */
	public OutputArea getResultArea()
	{
		return resultArea;
	}

	/**
	 * @param resultArea the resultArea to set
	 */
	public void setResultArea(OutputArea resultArea)
	{
		this.resultArea = resultArea;
	}

	/** Creates new form suchPanel */
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
	
	private void init2nd()
	{
		this.resultArea = new OutputArea(verwalter);
    this.resultArea.setBorder(null);
    this.outputPanel.setBorder(null);
    this.resultArea.setLayout(new FlowLayout());
    this.outputPanel.setViewportView(resultArea);
    this.resultArea.setPreferredSize((new Dimension((int)outputPanel.getSize().getWidth() - 10, (int)outputPanel.getSize().getWidth())));
    //Listener
    this.searchBook.addActionListener(new SearchBookListener(verwalter, searchField));
    this.searchPerson.addActionListener(new SearchPersonListener(verwalter, searchField));
	}

	/** This method is called from within the constructor to
	 * initialize the form.
	 * WARNING: Do NOT modify this code. The content of this method is
	 * always regenerated by the Form Editor.
	 */
	@SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        clearButton = new javax.swing.JButton();
        searchBook = new javax.swing.JButton();
        searchPerson = new javax.swing.JButton();
        searchField = new javax.swing.JTextField();
        outputPanel = new javax.swing.JScrollPane();

        setPreferredSize(new java.awt.Dimension(593, 600));

        clearButton.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        clearButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/bibliotheksverwaltung/view/images/cancel_32.png"))); // NOI18N
        clearButton.setMaximumSize(new java.awt.Dimension(41, 41));
        clearButton.setMinimumSize(new java.awt.Dimension(41, 41));
        clearButton.setPreferredSize(new java.awt.Dimension(41, 41));
        clearButton.addActionListener(this);

        searchBook.setFont(new java.awt.Font("Arial", 1, 14));
        searchBook.setIcon(new javax.swing.ImageIcon(getClass().getResource("/bibliotheksverwaltung/view/images/Book 4.png"))); // NOI18N
        searchBook.setMaximumSize(new java.awt.Dimension(41, 41));
        searchBook.setMinimumSize(new java.awt.Dimension(41, 41));
        searchBook.setPreferredSize(new java.awt.Dimension(41, 41));

        searchPerson.setFont(new java.awt.Font("Arial", 1, 14));
        searchPerson.setIcon(new javax.swing.ImageIcon(getClass().getResource("/bibliotheksverwaltung/view/images/user_32.png"))); // NOI18N

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
                    .addComponent(outputPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 573, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(clearButton, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(searchField, javax.swing.GroupLayout.DEFAULT_SIZE, 399, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(searchBook, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(searchPerson, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(20, 20, 20))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(clearButton, 0, 0, Short.MAX_VALUE)
                    .addComponent(searchPerson, 0, 0, Short.MAX_VALUE)
                    .addComponent(searchBook, 0, 0, Short.MAX_VALUE)
                    .addComponent(searchField, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(outputPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 533, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
    }

    // Code for dispatching events from components to event handlers.

    public void actionPerformed(java.awt.event.ActionEvent evt) {
        if (evt.getSource() == clearButton) {
            SuchPanel.this.clearButtonActionPerformed(evt);
        }
    }

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

	private void clearButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearButtonActionPerformed
		searchField.setForeground(new java.awt.Color(204, 204, 204));
		searchField.setText("Suchworte eingeben...");
		resultArea.removeAll();
		outputPanel.getVerticalScrollBar().hide();
		outputPanel.repaint();
	}//GEN-LAST:event_clearButtonActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton clearButton;
    private javax.swing.JScrollPane outputPanel;
    private javax.swing.JButton searchBook;
    private javax.swing.JTextField searchField;
    private javax.swing.JButton searchPerson;
    // End of variables declaration//GEN-END:variables
}
