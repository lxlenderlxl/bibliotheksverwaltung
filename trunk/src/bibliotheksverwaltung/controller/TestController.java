/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package bibliotheksverwaltung.controller;

import java.awt.event.ActionListener;
import bibliotheksverwaltung.model.logic.SuchVerwalter;

/**
 *
 * @author Max
 */
public class TestController implements ActionListener {

    private javax.swing.JTextField feld;

    public TestController(javax.swing.JTextField feld) {
        this.feld = feld;
    }

    public void actionPerformed(java.awt.event.ActionEvent evt) {
            SuchVerwalter verwalter = new SuchVerwalter();
            verwalter.sucheMedium(feld.getText());
        }
}
