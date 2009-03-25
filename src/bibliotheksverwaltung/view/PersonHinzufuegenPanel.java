/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * PersonHinzufuegenPanel.java
 *
 * Created on 24.03.2009, 20:37:04
 */

package bibliotheksverwaltung.view;

import javax.swing.JTextField;

/**
 *
 * @author Max
 */
public class PersonHinzufuegenPanel extends javax.swing.JPanel {

    /** Creates new form PersonHinzufuegenPanel */
    public PersonHinzufuegenPanel() {
        initComponents();
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        vornameField = new javax.swing.JTextField();
        nachnameField = new javax.swing.JTextField();
        strasseField = new javax.swing.JTextField();
        hausnummerField = new javax.swing.JTextField();
        plzField = new javax.swing.JTextField();
        stadtField = new javax.swing.JTextField();
        addButton = new javax.swing.JButton();
        cancelButton = new javax.swing.JButton();

        setMaximumSize(new java.awt.Dimension(558, 122));
        setMinimumSize(new java.awt.Dimension(558, 122));
        setPreferredSize(new java.awt.Dimension(558, 122));

        vornameField.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        vornameField.setForeground(new java.awt.Color(204, 204, 204));
        vornameField.setText("Vorname");
        vornameField.setToolTipText("Der Vorname der Person");
        vornameField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                vornameFieldFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                vornameFieldFocusLost(evt);
            }
        });

        nachnameField.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        nachnameField.setForeground(new java.awt.Color(204, 204, 204));
        nachnameField.setText("Nachname");
        nachnameField.setToolTipText("Der Nachname der Person");
        nachnameField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                nachnameFieldFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                nachnameFieldFocusLost(evt);
            }
        });

        strasseField.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        strasseField.setForeground(new java.awt.Color(204, 204, 204));
        strasseField.setText("Straße");
        strasseField.setToolTipText("Die Straße, in der die Person wohnt");
        strasseField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                strasseFieldFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                strasseFieldFocusLost(evt);
            }
        });

        hausnummerField.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        hausnummerField.setForeground(new java.awt.Color(204, 204, 204));
        hausnummerField.setText("Nummer");
        hausnummerField.setToolTipText("Die Nummer des Hauses, in der die Person wohnt");
        hausnummerField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                hausnummerFieldFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                hausnummerFieldFocusLost(evt);
            }
        });

        plzField.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        plzField.setForeground(new java.awt.Color(204, 204, 204));
        plzField.setText("PLZ");
        plzField.setToolTipText("Die Postleitzahl");
        plzField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                plzFieldFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                plzFieldFocusLost(evt);
            }
        });

        stadtField.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        stadtField.setForeground(new java.awt.Color(204, 204, 204));
        stadtField.setText("Stadt");
        stadtField.setToolTipText("Die Stadt, in der die Person wohnt");
        stadtField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                stadtFieldFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                stadtFieldFocusLost(evt);
            }
        });

        addButton.setFont(new java.awt.Font("Arial", 1, 18));
        addButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/bibliotheksverwaltung/view/images/user_add_48.png"))); // NOI18N
        addButton.setText("<html>Person<br/>hinzufügen");
        addButton.setHorizontalAlignment(javax.swing.SwingConstants.LEADING);
        addButton.setIconTextGap(10);

        cancelButton.setFont(new java.awt.Font("Arial", 0, 18));
        cancelButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/bibliotheksverwaltung/view/images/cancel_24.png"))); // NOI18N
        cancelButton.setText("Abbrechen");
        cancelButton.setHorizontalAlignment(javax.swing.SwingConstants.LEADING);
        cancelButton.setIconTextGap(10);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(plzField, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(stadtField, javax.swing.GroupLayout.DEFAULT_SIZE, 256, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(vornameField, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(nachnameField, javax.swing.GroupLayout.DEFAULT_SIZE, 179, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(strasseField, javax.swing.GroupLayout.DEFAULT_SIZE, 259, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(hausnummerField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(cancelButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(addButton))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(vornameField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(nachnameField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(strasseField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(hausnummerField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(plzField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(stadtField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(78, 78, 78)
                        .addComponent(cancelButton))
                    .addComponent(addButton))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void vornameFieldFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_vornameFieldFocusGained
        focusGained(vornameField, "Vorname");
}//GEN-LAST:event_vornameFieldFocusGained

    private void vornameFieldFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_vornameFieldFocusLost
        focusLost(vornameField, "Vorname");
}//GEN-LAST:event_vornameFieldFocusLost

    private void nachnameFieldFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_nachnameFieldFocusGained
        focusGained(nachnameField, "Nachname");
}//GEN-LAST:event_nachnameFieldFocusGained

    private void nachnameFieldFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_nachnameFieldFocusLost
        focusLost(nachnameField, "Nachname");
}//GEN-LAST:event_nachnameFieldFocusLost

    private void strasseFieldFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_strasseFieldFocusGained
        focusGained(strasseField, "Straße");
}//GEN-LAST:event_strasseFieldFocusGained

    private void strasseFieldFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_strasseFieldFocusLost
        focusLost(strasseField, "Straße");
}//GEN-LAST:event_strasseFieldFocusLost

    private void plzFieldFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_plzFieldFocusGained
        focusGained(plzField, "PLZ");
}//GEN-LAST:event_plzFieldFocusGained

    private void plzFieldFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_plzFieldFocusLost
        focusLost(plzField, "PLZ");
}//GEN-LAST:event_plzFieldFocusLost

    private void hausnummerFieldFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_hausnummerFieldFocusGained
        focusGained(hausnummerField, "Nummer");
}//GEN-LAST:event_hausnummerFieldFocusGained

    private void hausnummerFieldFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_hausnummerFieldFocusLost
        focusLost(hausnummerField, "Nummer");
}//GEN-LAST:event_hausnummerFieldFocusLost

    private void stadtFieldFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_stadtFieldFocusGained
        focusGained(stadtField, "Stadt");
}//GEN-LAST:event_stadtFieldFocusGained

    private void stadtFieldFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_stadtFieldFocusLost
        focusLost(stadtField, "Stadt");
}//GEN-LAST:event_stadtFieldFocusLost

    private void focusGained(JTextField field, String match) {
        if (field.getText().equals(match)) {
            field.setText("");
            field.setForeground(new java.awt.Color(0, 0, 0));
        }
    }

    private void focusLost(JTextField field, String content) {
        if (field.getText().isEmpty()) {
            field.setForeground(new java.awt.Color(204, 204, 204));
            field.setText(content);
        }
        if (field.getText().equals(content))
            field.setForeground(new java.awt.Color(255, 0, 0));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addButton;
    private javax.swing.JButton cancelButton;
    private javax.swing.JTextField hausnummerField;
    private javax.swing.JTextField nachnameField;
    private javax.swing.JTextField plzField;
    private javax.swing.JTextField stadtField;
    private javax.swing.JTextField strasseField;
    private javax.swing.JTextField vornameField;
    // End of variables declaration//GEN-END:variables

}