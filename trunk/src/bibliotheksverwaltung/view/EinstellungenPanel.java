/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * EinstellungenPanel.java
 *
 * Created on 20.03.2009, 14:03:27
 */

package bibliotheksverwaltung.view;

import java.awt.Dimension;
import java.util.ArrayList;

import bibliotheksverwaltung.model.daos.dao.MySQLAnwenderDAO;
import bibliotheksverwaltung.model.domain.Anwender;
import bibliotheksverwaltung.util.MD5Generator;

/**
 *
 * @author Max
 */
@SuppressWarnings("serial")
public class EinstellungenPanel extends javax.swing.JPanel {

	/** Erzeugt ein neues EinstellungenPanel */
	public EinstellungenPanel() {
		initComponents();
		addBenutzer();
	}

	/**
	 *
	 */
	private void addBenutzer() {
		anwenderPanel.removeAll();
		ArrayList<Anwender> alleAnwender = new MySQLAnwenderDAO().get(true);
		for (Anwender anwender : alleAnwender) {
			anwenderPanel.add(new BenutzerPanel(anwender.getAnwenderName()));
		}
        anwenderPanel.setPreferredSize(new Dimension(anwenderPanel.getHeight(), alleAnwender.size() * 36));
		this.repaint();
		this.revalidate();
	}

	/**
	 * Erzeugt die obigen Komponenten auf dem MainPanel
	 */
	@SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        ausleihdauerLabel = new javax.swing.JLabel();
        verlaengerungenLabel = new javax.swing.JLabel();
        ausleihdauerField = new javax.swing.JTextField();
        verlaengerungenField = new javax.swing.JTextField();
        ausleihdauerSlider = new javax.swing.JSlider();
        verlaengerungenSlider = new javax.swing.JSlider();
        benutzerPanel = new javax.swing.JPanel();
        nameField = new javax.swing.JTextField();
        passwordField = new javax.swing.JTextField();
        addButton = new javax.swing.JButton();
        benutzerSeparator = new javax.swing.JSeparator();
        anwenderPane = new javax.swing.JScrollPane();
        anwenderPanel = new javax.swing.JPanel();
        cancelButton = new javax.swing.JButton();
        saveButton = new javax.swing.JButton();

        ausleihdauerLabel.setFont(new java.awt.Font("Arial", 1, 14));
        ausleihdauerLabel.setText("maximale Ausleihdauer");

        verlaengerungenLabel.setFont(new java.awt.Font("Arial", 1, 14));
        verlaengerungenLabel.setText("Anzahl der Verlaengerungen");

        ausleihdauerField.setFont(new java.awt.Font("Arial", 1, 18));
        ausleihdauerField.setHorizontalAlignment(javax.swing.JTextField.TRAILING);
        ausleihdauerField.setText("28");

        verlaengerungenField.setFont(new java.awt.Font("Arial", 1, 18));
        verlaengerungenField.setHorizontalAlignment(javax.swing.JTextField.TRAILING);
        verlaengerungenField.setText("2");

        ausleihdauerSlider.setMaximum(90);
        ausleihdauerSlider.setMinimum(1);
        ausleihdauerSlider.setMinorTickSpacing(7);
        ausleihdauerSlider.setPaintLabels(true);
        ausleihdauerSlider.setPaintTicks(true);
        ausleihdauerSlider.setValue(28);
        ausleihdauerSlider.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                ausleihdauerSliderStateChanged(evt);
            }
        });

        verlaengerungenSlider.setMaximum(5);
        verlaengerungenSlider.setMinorTickSpacing(1);
        verlaengerungenSlider.setPaintLabels(true);
        verlaengerungenSlider.setPaintTicks(true);
        verlaengerungenSlider.setSnapToTicks(true);
        verlaengerungenSlider.setValue(2);
        verlaengerungenSlider.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                verlaengerungenSliderStateChanged(evt);
            }
        });

        benutzerPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Anwender", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 0, 12), new java.awt.Color(0, 0, 0))); // NOI18N
        benutzerPanel.setOpaque(false);
        benutzerPanel.setPreferredSize(new java.awt.Dimension(552, 258));

        nameField.setFont(new java.awt.Font("Arial", 1, 18));
        nameField.setForeground(new java.awt.Color(204, 204, 204));
        nameField.setText("Name");
        nameField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                nameFieldFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                nameFieldFocusLost(evt);
            }
        });

        passwordField.setFont(new java.awt.Font("Arial", 1, 18));
        passwordField.setForeground(new java.awt.Color(204, 204, 204));
        passwordField.setText("Passwort");
        passwordField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                passwordFieldFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                passwordFieldFocusLost(evt);
            }
        });

        addButton.setFont(new java.awt.Font("Arial", 1, 12));
        addButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/bibliotheksverwaltung/view/images/user_add_24.png"))); // NOI18N
        addButton.setText("Benutzer hinzufuegen");
        addButton.setHorizontalAlignment(javax.swing.SwingConstants.LEADING);
        addButton.setIconTextGap(10);
        addButton.setPreferredSize(new java.awt.Dimension(183, 28));
        addButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addButtonActionPerformed(evt);
            }
        });

        anwenderPane.setBorder(null);
        anwenderPane.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        anwenderPane.setPreferredSize(new java.awt.Dimension(516, 165));

        anwenderPanel.setPreferredSize(new java.awt.Dimension(516, 150));
        anwenderPane.setViewportView(anwenderPanel);

        javax.swing.GroupLayout benutzerPanelLayout = new javax.swing.GroupLayout(benutzerPanel);
        benutzerPanel.setLayout(benutzerPanelLayout);
        benutzerPanelLayout.setHorizontalGroup(
            benutzerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(benutzerPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(benutzerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, benutzerPanelLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 325, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(addButton, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(benutzerSeparator, javax.swing.GroupLayout.DEFAULT_SIZE, 516, Short.MAX_VALUE)
                    .addGroup(benutzerPanelLayout.createSequentialGroup()
                        .addComponent(nameField, javax.swing.GroupLayout.DEFAULT_SIZE, 144, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(passwordField, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(207, 207, 207))
                    .addComponent(anwenderPane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        benutzerPanelLayout.setVerticalGroup(
            benutzerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(benutzerPanelLayout.createSequentialGroup()
                .addGroup(benutzerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(addButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(passwordField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(nameField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(benutzerSeparator, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(anwenderPane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        cancelButton.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        cancelButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/bibliotheksverwaltung/view/images/cancel_48.png"))); // NOI18N
        cancelButton.setText("Abbrechen");
        cancelButton.setHorizontalAlignment(javax.swing.SwingConstants.LEADING);
        cancelButton.setIconTextGap(10);

        saveButton.setFont(new java.awt.Font("Arial", 1, 14));
        saveButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/bibliotheksverwaltung/view/images/accepted_48.png"))); // NOI18N
        saveButton.setText("Aenderungen speichern");
        saveButton.setHorizontalAlignment(javax.swing.SwingConstants.LEADING);
        saveButton.setIconTextGap(10);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(verlaengerungenLabel)
                        .addGap(341, 341, 341))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(ausleihdauerLabel)
                        .addGap(84, 84, 84)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(ausleihdauerField, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 35, Short.MAX_VALUE)
                                .addComponent(ausleihdauerSlider, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(verlaengerungenField, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 35, Short.MAX_VALUE)
                                .addComponent(verlaengerungenSlider, javax.swing.GroupLayout.DEFAULT_SIZE, 229, Short.MAX_VALUE)))))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(cancelButton, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 108, Short.MAX_VALUE)
                .addComponent(saveButton)
                .addGap(20, 20, 20))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(benutzerPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(ausleihdauerSlider, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(ausleihdauerLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(ausleihdauerField)))
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(verlaengerungenLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(verlaengerungenField, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(2, 2, 2))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(verlaengerungenSlider, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(36, 36, 36)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cancelButton)
                    .addComponent(saveButton))
                .addGap(63, 63, 63)
                .addComponent(benutzerPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

	private void nameFieldFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_nameFieldFocusGained
		if (nameField.getText().equals("Name")) {
			nameField.setText("");
			nameField.setForeground(new java.awt.Color(0, 0, 0));
		}
	}//GEN-LAST:event_nameFieldFocusGained

	private void nameFieldFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_nameFieldFocusLost
		if (nameField.getText().isEmpty()) {
			nameField.setForeground(new java.awt.Color(204, 204, 204));
			nameField.setText("Name");
		}
	}//GEN-LAST:event_nameFieldFocusLost

	private void passwordFieldFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_passwordFieldFocusGained
		if (passwordField.getText().equals("Passwort")) {
			passwordField.setText("");
			passwordField.setForeground(new java.awt.Color(0, 0, 0));
		}
	}//GEN-LAST:event_passwordFieldFocusGained

	private void passwordFieldFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_passwordFieldFocusLost
		if (passwordField.getText().isEmpty()) {
			passwordField.setForeground(new java.awt.Color(204, 204, 204));
			passwordField.setText("Passwort");
		}
	}//GEN-LAST:event_passwordFieldFocusLost

    private void ausleihdauerSliderStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_ausleihdauerSliderStateChanged
        ausleihdauerField.setText(new Integer(ausleihdauerSlider.getValue()).toString());
    }//GEN-LAST:event_ausleihdauerSliderStateChanged

    private void verlaengerungenSliderStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_verlaengerungenSliderStateChanged
        verlaengerungenField.setText(new Integer(verlaengerungenSlider.getValue()).toString());
    }//GEN-LAST:event_verlaengerungenSliderStateChanged

    private void addButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addButtonActionPerformed
        new MySQLAnwenderDAO().add(nameField.getText(),
                MD5Generator.getInstance().hashData(passwordField.getText()), 1, true);
        addBenutzer();
    }//GEN-LAST:event_addButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addButton;
    private javax.swing.JScrollPane anwenderPane;
    private javax.swing.JPanel anwenderPanel;
    private javax.swing.JTextField ausleihdauerField;
    private javax.swing.JLabel ausleihdauerLabel;
    private javax.swing.JSlider ausleihdauerSlider;
    private javax.swing.JPanel benutzerPanel;
    private javax.swing.JSeparator benutzerSeparator;
    private javax.swing.JButton cancelButton;
    private javax.swing.JTextField nameField;
    private javax.swing.JTextField passwordField;
    private javax.swing.JButton saveButton;
    private javax.swing.JTextField verlaengerungenField;
    private javax.swing.JLabel verlaengerungenLabel;
    private javax.swing.JSlider verlaengerungenSlider;
    // End of variables declaration//GEN-END:variables

}
