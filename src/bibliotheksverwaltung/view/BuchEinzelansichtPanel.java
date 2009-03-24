/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * BuchEinzelansichtPanel.java
 *
 * Created on 20.03.2009, 14:10:17
 */
package bibliotheksverwaltung.view;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.util.Observable;
import java.util.Observer;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.border.Border;

import bibliotheksverwaltung.controller.BuchAnsichtMouseListener;
import bibliotheksverwaltung.controller.ExemplarHinzuListener;
import bibliotheksverwaltung.model.domain.Medium;
import bibliotheksverwaltung.model.logic.ExemplarVerwalter;
import bibliotheksverwaltung.model.logic.MedienVerwalter;
import bibliotheksverwaltung.util.UpdateInfo;

import java.awt.Dimension;

/**
 *
 * @author Max
 */
public class BuchEinzelansichtPanel extends javax.swing.JPanel implements Observer {

    private MedienVerwalter medienVerwalter = null;

    //TODO Scrollpane unter dem exemplarpanel, da sonst nur begrenzte anzahl an exemplaren geben kann
    /** Creates new form BuchEinzelansichtPanel */
    public BuchEinzelansichtPanel(MedienVerwalter derVerwalter) {
        initComponents();
        this.medienVerwalter = derVerwalter;
        this.medienVerwalter.erzeugeExemplare();
        this.buchansichtPanel.add(new BuchAnsicht(this.medienVerwalter.getMedium()));
        this.erzeugeExemplarAnsichten();
        this.addButton.addActionListener(new ExemplarHinzuListener(medienVerwalter));
        medienVerwalter.addObserver(this);
        medienVerwalter.getExemplarVerwalter().addObserver(this);

    }

    private void erzeugeExemplarAnsichten() {
    	exemplarePanel.setLayout(new FlowLayout());
    	exemplarePanel.setPreferredSize(new Dimension((int)exemplarePanel.getPreferredSize().getWidth(), 26));
          	for (int i = 0; i < this.medienVerwalter.getMedium().getExemplare().size(); i++) {
            //TODO GridBagLayout entfernen, von Hand gesetzt, da sonst keine Exemplaransichten...            
            exemplarePanel.setPreferredSize(new Dimension((int)exemplarePanel.getPreferredSize().getWidth(), (int)exemplarePanel.getPreferredSize().getHeight() + 26));
            AusleiheEinzelansichtPanel panel = new AusleiheEinzelansichtPanel(medienVerwalter, this.medienVerwalter.getMedium().getExemplare().get(i));
            exemplarePanel.add(panel);
        }
//        this.validate();
//        this.repaint();
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buchansichtPanel = new javax.swing.JPanel();
        aktionenPanel = new javax.swing.JPanel();
        addButton = new javax.swing.JButton();
        editButton = new javax.swing.JButton();
        historyButton = new javax.swing.JButton();
        printButton = new javax.swing.JButton();
        exemplarPane = new javax.swing.JScrollPane();
        exemplarePanel = new javax.swing.JPanel();

        setPreferredSize(new java.awt.Dimension(573, 533));

        buchansichtPanel.setOpaque(false);

        javax.swing.GroupLayout buchansichtPanelLayout = new javax.swing.GroupLayout(buchansichtPanel);
        buchansichtPanel.setLayout(buchansichtPanelLayout);
        buchansichtPanelLayout.setHorizontalGroup(
            buchansichtPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 250, Short.MAX_VALUE)
        );
        buchansichtPanelLayout.setVerticalGroup(
            buchansichtPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 258, Short.MAX_VALUE)
        );

        aktionenPanel.setOpaque(false);

        addButton.setFont(new java.awt.Font("Arial", 1, 14));
        addButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/bibliotheksverwaltung/view/images/add_48.png"))); // NOI18N
        addButton.setText("Exemplar hinzufügen");
        addButton.setHorizontalAlignment(javax.swing.SwingConstants.LEADING);
        addButton.setIconTextGap(10);

        editButton.setFont(new java.awt.Font("Arial", 0, 14));
        editButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/bibliotheksverwaltung/view/images/pencil_48.png"))); // NOI18N
        editButton.setText("Daten bearbeiten");
        editButton.setHorizontalAlignment(javax.swing.SwingConstants.LEADING);
        editButton.setIconTextGap(10);

        historyButton.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        historyButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/bibliotheksverwaltung/view/images/clock_48.png"))); // NOI18N
        historyButton.setText("Historie anzeigen");
        historyButton.setHorizontalAlignment(javax.swing.SwingConstants.LEADING);
        historyButton.setIconTextGap(10);

        printButton.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        printButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/bibliotheksverwaltung/view/images/printer_48.png"))); // NOI18N
        printButton.setText("Daten drucken");
        printButton.setHorizontalAlignment(javax.swing.SwingConstants.LEADING);
        printButton.setIconTextGap(10);

        javax.swing.GroupLayout aktionenPanelLayout = new javax.swing.GroupLayout(aktionenPanel);
        aktionenPanel.setLayout(aktionenPanelLayout);
        aktionenPanelLayout.setHorizontalGroup(
            aktionenPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(aktionenPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(aktionenPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(addButton, javax.swing.GroupLayout.DEFAULT_SIZE, 273, Short.MAX_VALUE)
                    .addComponent(editButton, javax.swing.GroupLayout.DEFAULT_SIZE, 273, Short.MAX_VALUE)
                    .addComponent(historyButton, javax.swing.GroupLayout.DEFAULT_SIZE, 273, Short.MAX_VALUE)
                    .addComponent(printButton, javax.swing.GroupLayout.DEFAULT_SIZE, 273, Short.MAX_VALUE))
                .addContainerGap())
        );
        aktionenPanelLayout.setVerticalGroup(
            aktionenPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(aktionenPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(addButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(editButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(historyButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(printButton)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        exemplarPane.setBorder(null);
        exemplarPane.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        exemplarPane.setPreferredSize(new java.awt.Dimension(573, 258));

        exemplarePanel.setOpaque(false);
        exemplarePanel.setPreferredSize(new java.awt.Dimension(573, 258));
        exemplarePanel.setLayout(new java.awt.GridLayout(1, 0));
        exemplarPane.setViewportView(exemplarePanel);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(buchansichtPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(aktionenPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2))
            .addComponent(exemplarPane, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(aktionenPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(11, 11, 11)
                        .addComponent(buchansichtPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(exemplarPane, javax.swing.GroupLayout.DEFAULT_SIZE, 258, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    public static void main(String args[]) {
        JFrame jframe = new JFrame();
        jframe.setSize(200, 265);
        Medium einMedium = new Medium(5);
        einMedium.erzeugeExemplare();
        jframe.add(new BuchEinzelansichtPanel(new MedienVerwalter(einMedium)));
        jframe.setVisible(true);
        jframe.setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addButton;
    private javax.swing.JPanel aktionenPanel;
    private javax.swing.JPanel buchansichtPanel;
    private javax.swing.JButton editButton;
    private javax.swing.JScrollPane exemplarPane;
    private javax.swing.JPanel exemplarePanel;
    private javax.swing.JButton historyButton;
    private javax.swing.JButton printButton;
    // End of variables declaration//GEN-END:variables
	/* (non-Javadoc)
     * @see java.util.Observer#update(java.util.Observable, java.lang.Object)
     */

    @Override
    public void update(Observable o, Object arg) {
    	UpdateInfo updateInfo = (UpdateInfo) arg;
  		if (updateInfo.holeAenderung().equals("ExemplarHinzu"))
  		{
  			if (updateInfo.holeAenderungOk())
  			{
  				this.exemplarePanel.removeAll();
  				this.medienVerwalter.erzeugeExemplare();
  			}
  		}
  		else if (updateInfo.holeAenderung().equals("ExemplarGeloescht"))
  		{
  			if (updateInfo.holeAenderungOk())
  			{
  				this.exemplarePanel.removeAll();
  				this.medienVerwalter.erzeugeExemplare();
  			}
  		}
  		else if (updateInfo.holeAenderung().equals("ExemplareErzeugt"))
  		{
  			if (updateInfo.holeAenderungOk())
  			{
  				this.exemplarePanel.removeAll();
  				this.erzeugeExemplarAnsichten();
  			}
  		}
  		this.repaint();
  		this.revalidate();
    }
}
