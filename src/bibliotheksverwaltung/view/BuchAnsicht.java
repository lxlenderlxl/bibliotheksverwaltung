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
import java.util.Observable;
import java.util.Observer;

import bibliotheksverwaltung.controller.BuchAnsichtMouseListener;
import bibliotheksverwaltung.model.domain.Medium;
import bibliotheksverwaltung.model.logic.MedienVerwalter;
import bibliotheksverwaltung.util.UpdateInfo;

import javax.swing.JFrame;

/**
 *
 * @author Max
 */
public class BuchAnsicht extends ImagePanel implements Observer {

	private Medium medium;
	private MedienVerwalter verwalter = new MedienVerwalter();

	/** Creates new form BuchAnsicht */
	public BuchAnsicht(Medium dasMedium) {
		super("Book.png");
		this.medium = dasMedium;
		initComponents();
		this.addMouseListener(new BuchAnsichtMouseListener(verwalter, dasMedium));
		titleField.setText(medium.getTitel());
		infoField.setText(dasMedium.getMediumText());
		this.setzeStatus();
	}

	private void setzeStatus()
	{
		if (!verwalter.hasAusleihbareExemplare(medium.getId()))
		{
			statusLabel.setText("Nicht Verfuegbar");
			statusLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/bibliotheksverwaltung/view/images/circle_red_small.png")));
		}
		else
		{
			statusLabel.setText("Verfuegbar");
			statusLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/bibliotheksverwaltung/view/images/circle_green_small.png")));
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

        titleField = new javax.swing.JTextArea();
        infoField = new javax.swing.JTextArea();
        statusLabel = new javax.swing.JLabel();

        setMaximumSize(new java.awt.Dimension(186, 240));
        setPreferredSize(new java.awt.Dimension(182, 240));

        titleField.setColumns(20);
        titleField.setEditable(false);
        titleField.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        titleField.setLineWrap(true);
        titleField.setRows(5);
        titleField.setWrapStyleWord(true);
        titleField.setBorder(null);
        titleField.setOpaque(false);

        infoField.setColumns(20);
        infoField.setEditable(false);
        infoField.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        infoField.setLineWrap(true);
        infoField.setRows(5);
        infoField.setWrapStyleWord(true);
        infoField.setBorder(null);
        infoField.setOpaque(false);

        statusLabel.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        statusLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/bibliotheksverwaltung/view/images/circle_red_small.png"))); // NOI18N
        statusLabel.setText("nicht verfügbar");
        statusLabel.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(statusLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 148, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(titleField, javax.swing.GroupLayout.DEFAULT_SIZE, 137, Short.MAX_VALUE)
                            .addComponent(infoField, javax.swing.GroupLayout.DEFAULT_SIZE, 137, Short.MAX_VALUE))
                        .addGap(21, 21, 21))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(titleField, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(infoField, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(statusLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(20, 20, 20))
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
    private javax.swing.JTextArea infoField;
    private javax.swing.JLabel statusLabel;
    private javax.swing.JTextArea titleField;
    // End of variables declaration//GEN-END:variables

		/* (non-Javadoc)
		 * @see java.util.Observer#update(java.util.Observable, java.lang.Object)
		 */
		@Override
		public void update(Observable o, Object arg)
		{
			UpdateInfo updateInfo = (UpdateInfo) arg;
			this.removeAll();
			if (updateInfo.holeAenderung().equals("DatenBearbeiten"))
			{
				if (updateInfo.holeAenderungOk())
				{
					this.titleField.setEditable(true);
					this.infoField.setEditable(true);
				}
			}			
		}

}
