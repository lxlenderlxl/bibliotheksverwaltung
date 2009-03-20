/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * BuchAnsicht.java
 *
 * Created on 18.03.2009, 15:22:59
 */

package bibliotheksverwaltung.view;

import java.awt.Dimension;

import bibliotheksverwaltung.controller.BuchAnsichtMouseListener;
import bibliotheksverwaltung.model.domain.Medium;
import bibliotheksverwaltung.model.logic.MedienVerwalter;

import javax.swing.JFrame;

/**
 *
 * @author Max
 */
public class BuchAnsicht extends ImagePanel {

    private Medium medium;
    private MedienVerwalter verwalter = new MedienVerwalter();

    /** Creates new form BuchAnsicht */
    public BuchAnsicht(Medium dasMedium) {
        super("Book.png");
        this.medium = dasMedium;
        initComponents();
        jLabel1.setText(medium.getTitel());
        this.addMouseListener(new BuchAnsichtMouseListener(verwalter));
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new WrappedLabel("Buchtitel");

        setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        setPreferredSize(new java.awt.Dimension(200, 265));

        jLabel1.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        //jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Ein sehr langer Buchtitel kann aus sehr vielen Zeichen bestehen");
        jLabel1.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 174, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(51, 51, 51)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(106, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    /**
    * @param args the command line arguments
    */
    public static void main(String args[]) {
        JFrame jframe = new JFrame();
        jframe.setSize(200,265);
        jframe.add(new BuchAnsicht(new Medium(190)));
        jframe.setVisible(true);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private WrappedLabel jLabel1;
    // End of variables declaration//GEN-END:variables

}
