/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * AusleiheEinzelansichtPanel.java
 *
 * Created on 20.03.2009, 14:40:56
 */

package bibliotheksverwaltung.view;

import javax.swing.JFrame;

import bibliotheksverwaltung.controller.BuchAusleihenListener;
import bibliotheksverwaltung.controller.BuchLoeschenListener;
import bibliotheksverwaltung.model.domain.Ausleiher;
import bibliotheksverwaltung.model.domain.Exemplar;
import bibliotheksverwaltung.model.domain.Medium;
import bibliotheksverwaltung.model.domain.Zustand;
import bibliotheksverwaltung.model.logic.BibliotheksVerwalter;
import bibliotheksverwaltung.model.logic.MedienVerwalter;

/**
 *
 * @author Max
 */
public class AusleiheEinzelansichtPanel extends javax.swing.JPanel {
	
	private Exemplar exemplar = null;
	private Zustand zustand = null;
	private Ausleiher ausleiher = null;
	private MedienVerwalter medienVerwalter = null;
	
//TODO Wenn Buch ausgeliehen, muss auch ein Button f�r verl�ngern vorhanden sein (z.Zt. nur Zur�cknehmen und Ausleihen
	/** Creates new form AusleiheEinzelansichtPanel */
	public AusleiheEinzelansichtPanel(MedienVerwalter derMedienVerwalter, Exemplar dasExemplar) {
		this.exemplar = dasExemplar;
		this.medienVerwalter = derMedienVerwalter;
		initComponents();
		exemplarLabel.setText(String.valueOf(this.exemplar.getId()));
		zustand = new Zustand(exemplar.getZustand());
		exemplarLabel.setIcon(zustand.getBild());
		exemplarLabel.setToolTipText(zustand.getBeschreibung());
		
		if (this.exemplar.isAusleihBar())
		{			
			jLabel2.setText("");
			jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/bibliotheksverwaltung/view/images/arrow_right_green_24.png")));
			jButton1.setText("Ausleihen");
			jButton1.addActionListener(new BuchAusleihenListener(medienVerwalter, exemplar));
			jButton2.addActionListener(new BuchLoeschenListener(this.medienVerwalter, this.exemplar));
			jLabel3.setText("");
			jLabel4.setText("");
		}
		else
		{
			ausleiher = new Ausleiher(this.exemplar.getAusleiher());
			jLabel2.setText(ausleiher.getName());
			jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/bibliotheksverwaltung/view/images/arrow_left_green_24.png")));
			jButton1.setText("Zur�cknehmen");
			jLabel3.setText(String.valueOf(exemplar.getFormattedDate()));
			jLabel4.setText(String.valueOf(exemplar.getVerlaengerung()));
			jButton2.addActionListener(new BuchLoeschenListener(this.medienVerwalter, this.exemplar));
		}
	}

	/** This method is called from within the constructor to
	 * initialize the form.
	 * WARNING: Do NOT modify this code. The content of this method is
	 * always regenerated by the Form Editor.
	 */
	@SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        exemplarLabel = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();

        setMaximumSize(new java.awt.Dimension(563, 28));
        setMinimumSize(new java.awt.Dimension(563, 28));
        setOpaque(false);
        setPreferredSize(new java.awt.Dimension(563, 28));
        setRequestFocusEnabled(false);

        exemplarLabel.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        exemplarLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/bibliotheksverwaltung/view/images/circle_red_small.png"))); // NOI18N
        exemplarLabel.setText("ExemplarID");

        jLabel2.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel2.setText("Ausleiher");

        jButton1.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/bibliotheksverwaltung/view/images/arrow_right_green_24.png"))); // NOI18N
        jButton1.setText("Text");
        jButton1.setHorizontalAlignment(javax.swing.SwingConstants.LEADING);
        jButton1.setMaximumSize(new java.awt.Dimension(217, 24));

        jLabel3.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel3.setText("xx.xx.xxxx");

        jLabel4.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel4.setText("xx.xx.xxxx");

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/bibliotheksverwaltung/view/images/cancel_24.png"))); // NOI18N
        jButton2.setBorder(null);
        jButton2.setContentAreaFilled(false);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(exemplarLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 190, Short.MAX_VALUE)
                .addComponent(jButton2)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(exemplarLabel)
                        .addComponent(jLabel2)
                        .addComponent(jLabel3)
                        .addComponent(jLabel4)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jButton2))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

	public static void main(String args[]) {
		JFrame jframe = new JFrame();
		jframe.setSize(200,265);
		jframe.add(new AusleiheEinzelansichtPanel(new MedienVerwalter(), new Exemplar(2)));
		jframe.setVisible(true);
		jframe.setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
	}


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel exemplarLabel;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    // End of variables declaration//GEN-END:variables

}
