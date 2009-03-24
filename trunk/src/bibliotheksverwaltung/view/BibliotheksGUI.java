/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * BibliotheksGUI.java
 *
 * Created on 17.03.2009, 15:56:45
 */

package bibliotheksverwaltung.view;

import bibliotheksverwaltung.util.LocalEnvironment;
import bibliotheksverwaltung.util.UpdateInfo;
import bibliotheksverwaltung.controller.AddActionListener;
import bibliotheksverwaltung.controller.BuchAnsichtMouseListener;
import bibliotheksverwaltung.controller.ReportActionListener;
import bibliotheksverwaltung.controller.SearchActionListener;
import bibliotheksverwaltung.controller.SearchBookListener;
import bibliotheksverwaltung.controller.TestListener;
import bibliotheksverwaltung.model.domain.Ausleiher;
import bibliotheksverwaltung.model.domain.Medium;
import bibliotheksverwaltung.model.logic.*;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagLayout;
import java.awt.LayoutManager;
import java.awt.event.ActionListener;
import java.awt.event.FocusListener;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.UnsupportedLookAndFeelException;

/**
 *
 * @author Max
 */
public class BibliotheksGUI extends javax.swing.JFrame implements Observer {

	private BibliotheksVerwalter verwalter = new BibliotheksVerwalter();

    /** Creates new form BibliotheksGUI */
	//TODO Message Panel
    public BibliotheksGUI() {
        try {
            javax.swing.UIManager.setLookAndFeel(new com.nilo.plaf.nimrod.NimRODLookAndFeel());
        } catch (UnsupportedLookAndFeelException e) {
            LocalEnvironment.log(e.getMessage(), this);
        }
        initComponents();
        verwalter.addObserver(this);
        searchButton.addActionListener(new SearchActionListener(this.verwalter));
        addButton.addActionListener(new AddActionListener(this.verwalter));
        reportButton.addActionListener(new ReportActionListener(this.verwalter));
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        containerPanel = new javax.swing.JPanel();
        menuPanel = new javax.swing.JPanel();
        searchButton = new javax.swing.JButton();
        addButton = new javax.swing.JButton();
        reportButton = new javax.swing.JButton();
        configButton = new javax.swing.JButton();
        warenkorbPanel = new javax.swing.JPanel();
        mainPanel = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Bibliotheksverwaltung");
        setResizable(false);

        containerPanel.setPreferredSize(new java.awt.Dimension(800, 600));

        menuPanel.setOpaque(false);

        searchButton.setFont(new java.awt.Font("Arial", 1, 14));
        searchButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/bibliotheksverwaltung/view/images/search_48.png"))); // NOI18N
        searchButton.setText("Suchen");
        searchButton.setHorizontalAlignment(javax.swing.SwingConstants.LEADING);

        addButton.setFont(new java.awt.Font("Arial", 1, 14));
        addButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/bibliotheksverwaltung/view/images/add_48.png"))); // NOI18N
        addButton.setText("Hinzufügen");
        addButton.setHorizontalAlignment(javax.swing.SwingConstants.LEADING);

        reportButton.setFont(new java.awt.Font("Arial", 1, 14));
        reportButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/bibliotheksverwaltung/view/images/pie_chart_48.png"))); // NOI18N
        reportButton.setText("Berichte");
        reportButton.setHorizontalAlignment(javax.swing.SwingConstants.LEADING);

        configButton.setFont(new java.awt.Font("Arial", 1, 14));
        configButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/bibliotheksverwaltung/view/images/spanner_48.png"))); // NOI18N
        configButton.setText("Einstellungen");
        configButton.setHorizontalAlignment(javax.swing.SwingConstants.LEADING);

        warenkorbPanel.setMaximumSize(new java.awt.Dimension(181, 250));
        warenkorbPanel.setMinimumSize(new java.awt.Dimension(181, 250));
        warenkorbPanel.setPreferredSize(new java.awt.Dimension(181, 250));

        javax.swing.GroupLayout warenkorbPanelLayout = new javax.swing.GroupLayout(warenkorbPanel);
        warenkorbPanel.setLayout(warenkorbPanelLayout);
        warenkorbPanelLayout.setHorizontalGroup(
            warenkorbPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 181, Short.MAX_VALUE)
        );
        warenkorbPanelLayout.setVerticalGroup(
            warenkorbPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 250, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout menuPanelLayout = new javax.swing.GroupLayout(menuPanel);
        menuPanel.setLayout(menuPanelLayout);
        menuPanelLayout.setHorizontalGroup(
            menuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(menuPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(menuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(menuPanelLayout.createSequentialGroup()
                        .addComponent(configButton, javax.swing.GroupLayout.DEFAULT_SIZE, 185, Short.MAX_VALUE)
                        .addGap(6, 6, 6))
                    .addGroup(menuPanelLayout.createSequentialGroup()
                        .addGroup(menuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(addButton, javax.swing.GroupLayout.DEFAULT_SIZE, 181, Short.MAX_VALUE)
                            .addComponent(reportButton, javax.swing.GroupLayout.DEFAULT_SIZE, 181, Short.MAX_VALUE)
                            .addComponent(searchButton, javax.swing.GroupLayout.DEFAULT_SIZE, 181, Short.MAX_VALUE))
                        .addContainerGap())
                    .addGroup(menuPanelLayout.createSequentialGroup()
                        .addComponent(warenkorbPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        menuPanelLayout.setVerticalGroup(
            menuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, menuPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(searchButton)
                .addGap(18, 18, 18)
                .addComponent(addButton)
                .addGap(18, 18, 18)
                .addComponent(reportButton)
                .addGap(18, 18, 18)
                .addComponent(warenkorbPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 46, Short.MAX_VALUE)
                .addComponent(configButton)
                .addGap(22, 22, 22))
        );

        mainPanel.setMaximumSize(new java.awt.Dimension(597, 600));
        mainPanel.setMinimumSize(new java.awt.Dimension(597, 600));
        mainPanel.setOpaque(false);

        javax.swing.GroupLayout mainPanelLayout = new javax.swing.GroupLayout(mainPanel);
        mainPanel.setLayout(mainPanelLayout);
        mainPanelLayout.setHorizontalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 597, Short.MAX_VALUE)
        );
        mainPanelLayout.setVerticalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 600, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout containerPanelLayout = new javax.swing.GroupLayout(containerPanel);
        containerPanel.setLayout(containerPanelLayout);
        containerPanelLayout.setHorizontalGroup(
            containerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(containerPanelLayout.createSequentialGroup()
                .addComponent(menuPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(mainPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        containerPanelLayout.setVerticalGroup(
            containerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(menuPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(containerPanelLayout.createSequentialGroup()
                .addComponent(mainPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(containerPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 814, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(containerPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 611, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    /**
    * @param args the command line arguments
    */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new BibliotheksGUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addButton;
    private javax.swing.JButton configButton;
    private javax.swing.JPanel containerPanel;
    private javax.swing.JPanel mainPanel;
    private javax.swing.JPanel menuPanel;
    private javax.swing.JButton reportButton;
    private javax.swing.JButton searchButton;
    private javax.swing.JPanel warenkorbPanel;
    // End of variables declaration//GEN-END:variables

		/* (non-Javadoc)
		 * @see java.util.Observer#update(java.util.Observable, java.lang.Object)
		 */
		@Override
		public void update(Observable o, Object arg)
		{
			UpdateInfo updateInfo = (UpdateInfo) arg;
			String ausgabe = "";
			if (updateInfo.holeAenderung().equals("Suche"))
			{
				if (updateInfo.holeAenderungOk())
				{
					mainPanel.removeAll();
	        SuchPanel suchPanel = new SuchPanel(this.verwalter, true,true);
	        suchPanel.setSize(mainPanel.getSize());
	        mainPanel.add(suchPanel);
				}
			}
			else if (updateInfo.holeAenderung().equals("Hinzufuegen"))
			{
				if (updateInfo.holeAenderungOk())
				{
					mainPanel.removeAll();
					mainPanel.setLayout(new FlowLayout());
	        PersonHinzufuegenPanel persoPanel = new PersonHinzufuegenPanel();
	        BuchHinzufuegenPanel buchPanel = new BuchHinzufuegenPanel();
	        persoPanel.setSize(mainPanel.getSize());
	        buchPanel.setSize(mainPanel.getSize());
	        mainPanel.add(persoPanel);
	        mainPanel.add(buchPanel);
				}
			}
			else if (updateInfo.holeAenderung().equals("Report"))
			{
				if (updateInfo.holeAenderungOk())
				{
					mainPanel.removeAll();
//					HinzufuegenPanel hinzuPanel = new HinzufuegenPanel();
//					hinzuPanel.setSize(mainPanel.getSize());
//					mainPanel.add(hinzuPanel);
					System.out.println("Report Knopf gedr�ckt");
				}
			}
			this.mainPanel.repaint();
			this.mainPanel.revalidate();
		}

}
