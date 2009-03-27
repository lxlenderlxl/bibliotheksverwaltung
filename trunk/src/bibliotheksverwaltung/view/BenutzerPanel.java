/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * BenutzerPanel.java
 *
 * Created on 24.03.2009, 14:20:52
 */

package bibliotheksverwaltung.view;

/**
 *
 * @author Max
 */
public class BenutzerPanel extends javax.swing.JPanel {

	/** Erzeugt ein neues BenutzerPanel */
	public BenutzerPanel(String name) {
		initComponents();
		benutzerLabel.setText(name);
	}

	/**
	 * Erzeugt die obigen Komponenten auf dem MainPanel
	 */
	@SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        deleteButton = new javax.swing.JButton();
        changePasswordButton = new javax.swing.JButton();
        benutzerLabel = new javax.swing.JLabel();

        setPreferredSize(new java.awt.Dimension(500, 30));

        deleteButton.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        deleteButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/bibliotheksverwaltung/view/images/user_delete_24.png"))); // NOI18N
        deleteButton.setText("Benutzer loeschen");
        deleteButton.setActionCommand("Benutzer loeschen");
        deleteButton.setHorizontalAlignment(javax.swing.SwingConstants.LEADING);
        deleteButton.setIconTextGap(10);
        deleteButton.setPreferredSize(new java.awt.Dimension(183, 28));

        changePasswordButton.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        changePasswordButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/bibliotheksverwaltung/view/images/lock_24.png"))); // NOI18N
        changePasswordButton.setText("Passwort aendern");
        changePasswordButton.setHorizontalAlignment(javax.swing.SwingConstants.LEADING);
        changePasswordButton.setIconTextGap(10);
        changePasswordButton.setPreferredSize(new java.awt.Dimension(183, 28));

        benutzerLabel.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        benutzerLabel.setText("Benutzername");
        benutzerLabel.setPreferredSize(new java.awt.Dimension(50, 24));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(benutzerLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 134, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(changePasswordButton, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(deleteButton, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(benutzerLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(deleteButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(changePasswordButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel benutzerLabel;
    private javax.swing.JButton changePasswordButton;
    private javax.swing.JButton deleteButton;
    // End of variables declaration//GEN-END:variables

}
