/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * HinzufuegenPanel.java
 *
 * Created on 24.03.2009, 14:40:10
 */

package bibliotheksverwaltung.view;

import javax.swing.JTextField;

/**
 *
 * @author Max
 */
public class HinzufuegenPanel extends javax.swing.JPanel {

    /** Creates new form HinzufuegenPanel */
    public HinzufuegenPanel() {
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

        buchPanel = new javax.swing.JPanel();
        titelField = new javax.swing.JTextField();
        autorVornameField = new javax.swing.JTextField();
        autorNachnameField = new javax.swing.JTextField();
        verlagField = new javax.swing.JTextField();
        jahrField = new javax.swing.JTextField();
        addBookButton = new javax.swing.JButton();
        isbnField = new javax.swing.JTextField();
        personenPanel = new javax.swing.JPanel();
        vornameField = new javax.swing.JTextField();
        nachnameField = new javax.swing.JTextField();
        strasseField = new javax.swing.JTextField();
        hausnummerField = new javax.swing.JTextField();
        plzField = new javax.swing.JTextField();
        stadtField = new javax.swing.JTextField();
        addButton = new javax.swing.JButton();
        feldSeparator = new javax.swing.JSeparator();

        setPreferredSize(new java.awt.Dimension(593, 600));

        titelField.setFont(new java.awt.Font("Arial", 1, 18));
        titelField.setForeground(new java.awt.Color(204, 204, 204));
        titelField.setText("Buchtitel");
        titelField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                titelFieldFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                titelFieldFocusLost(evt);
            }
        });

        autorVornameField.setFont(new java.awt.Font("Arial", 1, 18));
        autorVornameField.setForeground(new java.awt.Color(204, 204, 204));
        autorVornameField.setText("Autor-Vorname");
        autorVornameField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                autorVornameFieldFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                autorVornameFieldFocusLost(evt);
            }
        });

        autorNachnameField.setFont(new java.awt.Font("Arial", 1, 18));
        autorNachnameField.setForeground(new java.awt.Color(204, 204, 204));
        autorNachnameField.setText("Autor-Nachname");
        autorNachnameField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                autorNachnameFieldFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                autorNachnameFieldFocusLost(evt);
            }
        });

        verlagField.setFont(new java.awt.Font("Arial", 1, 18));
        verlagField.setForeground(new java.awt.Color(204, 204, 204));
        verlagField.setText("Verlag");
        verlagField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                verlagFieldFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                verlagFieldFocusLost(evt);
            }
        });

        jahrField.setFont(new java.awt.Font("Arial", 1, 18));
        jahrField.setForeground(new java.awt.Color(204, 204, 204));
        jahrField.setText("Jahr");
        jahrField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jahrFieldFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                jahrFieldFocusLost(evt);
            }
        });

        addBookButton.setFont(new java.awt.Font("Arial", 1, 18));
        addBookButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/bibliotheksverwaltung/view/images/book_48.png"))); // NOI18N
        addBookButton.setText("<html>Buch<br />hinzufügen");
        addBookButton.setHorizontalAlignment(javax.swing.SwingConstants.LEADING);
        addBookButton.setIconTextGap(10);

        isbnField.setFont(new java.awt.Font("Arial", 1, 18));
        isbnField.setForeground(new java.awt.Color(204, 204, 204));
        isbnField.setText("ISBN");
        isbnField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                isbnFieldFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                isbnFieldFocusLost(evt);
            }
        });

        javax.swing.GroupLayout buchPanelLayout = new javax.swing.GroupLayout(buchPanel);
        buchPanel.setLayout(buchPanelLayout);
        buchPanelLayout.setHorizontalGroup(
            buchPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, buchPanelLayout.createSequentialGroup()
                .addGroup(buchPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(buchPanelLayout.createSequentialGroup()
                        .addComponent(autorVornameField, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(autorNachnameField, javax.swing.GroupLayout.DEFAULT_SIZE, 194, Short.MAX_VALUE))
                    .addComponent(titelField, javax.swing.GroupLayout.DEFAULT_SIZE, 358, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, buchPanelLayout.createSequentialGroup()
                        .addComponent(verlagField, javax.swing.GroupLayout.DEFAULT_SIZE, 266, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jahrField, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(isbnField, javax.swing.GroupLayout.DEFAULT_SIZE, 358, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(addBookButton)
                .addContainerGap())
        );
        buchPanelLayout.setVerticalGroup(
            buchPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(buchPanelLayout.createSequentialGroup()
                .addGroup(buchPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(addBookButton, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(buchPanelLayout.createSequentialGroup()
                        .addComponent(titelField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(buchPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(autorNachnameField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(autorVornameField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(buchPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(verlagField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jahrField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(isbnField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        vornameField.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        vornameField.setForeground(new java.awt.Color(204, 204, 204));
        vornameField.setText("Vorname");
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
        nachnameField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                nachnameFieldFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                nachnameFieldFocusLost(evt);
            }
        });

        strasseField.setFont(new java.awt.Font("Arial", 1, 18));
        strasseField.setForeground(new java.awt.Color(204, 204, 204));
        strasseField.setText("Straße");
        strasseField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                strasseFieldFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                strasseFieldFocusLost(evt);
            }
        });

        hausnummerField.setFont(new java.awt.Font("Arial", 1, 18));
        hausnummerField.setForeground(new java.awt.Color(204, 204, 204));
        hausnummerField.setText("Nummer");
        hausnummerField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                hausnummerFieldFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                hausnummerFieldFocusLost(evt);
            }
        });

        plzField.setFont(new java.awt.Font("Arial", 1, 18));
        plzField.setForeground(new java.awt.Color(204, 204, 204));
        plzField.setText("PLZ");
        plzField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                plzFieldFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                plzFieldFocusLost(evt);
            }
        });

        stadtField.setFont(new java.awt.Font("Arial", 1, 18));
        stadtField.setForeground(new java.awt.Color(204, 204, 204));
        stadtField.setText("Stadt");
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
        addButton.setText("<html>Person<br />hinzufügen");
        addButton.setHorizontalAlignment(javax.swing.SwingConstants.LEADING);
        addButton.setIconTextGap(10);

        javax.swing.GroupLayout personenPanelLayout = new javax.swing.GroupLayout(personenPanel);
        personenPanel.setLayout(personenPanelLayout);
        personenPanelLayout.setHorizontalGroup(
            personenPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(personenPanelLayout.createSequentialGroup()
                .addGroup(personenPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(personenPanelLayout.createSequentialGroup()
                        .addComponent(vornameField, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(nachnameField, javax.swing.GroupLayout.DEFAULT_SIZE, 186, Short.MAX_VALUE))
                    .addGroup(personenPanelLayout.createSequentialGroup()
                        .addComponent(plzField, javax.swing.GroupLayout.DEFAULT_SIZE, 136, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(stadtField, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(personenPanelLayout.createSequentialGroup()
                        .addComponent(strasseField, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(hausnummerField, javax.swing.GroupLayout.DEFAULT_SIZE, 112, Short.MAX_VALUE)))
                .addGap(18, 18, 18)
                .addComponent(addButton)
                .addContainerGap())
        );
        personenPanelLayout.setVerticalGroup(
            personenPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(personenPanelLayout.createSequentialGroup()
                .addGroup(personenPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(vornameField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(nachnameField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(personenPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(strasseField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(hausnummerField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(personenPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(plzField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(stadtField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(26, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, personenPanelLayout.createSequentialGroup()
                .addContainerGap(34, Short.MAX_VALUE)
                .addComponent(addButton, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(feldSeparator, javax.swing.GroupLayout.DEFAULT_SIZE, 573, Short.MAX_VALUE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(buchPanel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(personenPanel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(buchPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(feldSeparator, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15)
                .addComponent(personenPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(290, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void vornameFieldFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_vornameFieldFocusGained
        focusGained(vornameField, "Vorname");
}//GEN-LAST:event_vornameFieldFocusGained

    private void vornameFieldFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_vornameFieldFocusLost
        focusLost(vornameField, "Vorname");
}//GEN-LAST:event_vornameFieldFocusLost

    private void strasseFieldFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_strasseFieldFocusGained
        focusGained(strasseField, "Straße");
}//GEN-LAST:event_strasseFieldFocusGained

    private void strasseFieldFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_strasseFieldFocusLost
        focusLost(strasseField, "Straße");
}//GEN-LAST:event_strasseFieldFocusLost

    private void nachnameFieldFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_nachnameFieldFocusGained
        focusGained(nachnameField, "Nachname");
}//GEN-LAST:event_nachnameFieldFocusGained

    private void nachnameFieldFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_nachnameFieldFocusLost
        focusLost(nachnameField, "Nachname");
}//GEN-LAST:event_nachnameFieldFocusLost

    private void hausnummerFieldFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_hausnummerFieldFocusGained
        focusGained(hausnummerField, "Nummer");
}//GEN-LAST:event_hausnummerFieldFocusGained

    private void hausnummerFieldFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_hausnummerFieldFocusLost
        focusLost(hausnummerField, "Nummer");
}//GEN-LAST:event_hausnummerFieldFocusLost

    private void plzFieldFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_plzFieldFocusGained
        focusGained(plzField, "PLZ");
}//GEN-LAST:event_plzFieldFocusGained

    private void plzFieldFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_plzFieldFocusLost
        focusLost(plzField, "PLZ");
}//GEN-LAST:event_plzFieldFocusLost

    private void stadtFieldFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_stadtFieldFocusGained
        focusGained(stadtField, "Stadt");
}//GEN-LAST:event_stadtFieldFocusGained

    private void stadtFieldFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_stadtFieldFocusLost
        focusLost(stadtField, "Stadt");
}//GEN-LAST:event_stadtFieldFocusLost

    private void autorVornameFieldFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_autorVornameFieldFocusGained
        focusGained(autorVornameField, "Autor-Vorname");
}//GEN-LAST:event_autorVornameFieldFocusGained

    private void autorVornameFieldFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_autorVornameFieldFocusLost
        focusLost(autorVornameField, "Autor-Vorname");
}//GEN-LAST:event_autorVornameFieldFocusLost

    private void autorNachnameFieldFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_autorNachnameFieldFocusGained
        focusGained(autorNachnameField, "Autor-Nachname");
}//GEN-LAST:event_autorNachnameFieldFocusGained

    private void autorNachnameFieldFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_autorNachnameFieldFocusLost
        focusLost(autorNachnameField, "Autor-Nachname");
}//GEN-LAST:event_autorNachnameFieldFocusLost

    private void titelFieldFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_titelFieldFocusGained
        focusGained(titelField, "Buchtitel");
}//GEN-LAST:event_titelFieldFocusGained

    private void titelFieldFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_titelFieldFocusLost
        focusLost(titelField, "Buchtitel");
}//GEN-LAST:event_titelFieldFocusLost

    private void jahrFieldFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jahrFieldFocusGained
        focusGained(jahrField, "Jahr");
}//GEN-LAST:event_jahrFieldFocusGained

    private void jahrFieldFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jahrFieldFocusLost
        focusLost(jahrField, "Jahr");
}//GEN-LAST:event_jahrFieldFocusLost

    private void verlagFieldFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_verlagFieldFocusGained
        focusGained(verlagField, "Verlag");
}//GEN-LAST:event_verlagFieldFocusGained

    private void verlagFieldFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_verlagFieldFocusLost
        focusLost(verlagField, "Verlag");
}//GEN-LAST:event_verlagFieldFocusLost

    private void isbnFieldFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_isbnFieldFocusGained
        focusGained(isbnField, "ISBN");
}//GEN-LAST:event_isbnFieldFocusGained

    private void isbnFieldFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_isbnFieldFocusLost
        focusLost(isbnField, "ISBN");
}//GEN-LAST:event_isbnFieldFocusLost

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
    private javax.swing.JButton addBookButton;
    private javax.swing.JButton addButton;
    private javax.swing.JTextField autorNachnameField;
    private javax.swing.JTextField autorVornameField;
    private javax.swing.JPanel buchPanel;
    private javax.swing.JSeparator feldSeparator;
    private javax.swing.JTextField hausnummerField;
    private javax.swing.JTextField isbnField;
    private javax.swing.JTextField jahrField;
    private javax.swing.JTextField nachnameField;
    private javax.swing.JPanel personenPanel;
    private javax.swing.JTextField plzField;
    private javax.swing.JTextField stadtField;
    private javax.swing.JTextField strasseField;
    private javax.swing.JTextField titelField;
    private javax.swing.JTextField verlagField;
    private javax.swing.JTextField vornameField;
    // End of variables declaration//GEN-END:variables

}
