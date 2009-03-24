/**
 *
 */
package bibliotheksverwaltung.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagLayout;
import java.awt.FlowLayout;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import bibliotheksverwaltung.controller.BuchAnsichtMouseListener;
import bibliotheksverwaltung.controller.TestListener;
import bibliotheksverwaltung.model.domain.Ausleiher;
import bibliotheksverwaltung.model.domain.Exemplar;
import bibliotheksverwaltung.model.domain.Medium;
import bibliotheksverwaltung.model.logic.BibliotheksVerwalter;
import bibliotheksverwaltung.model.logic.MedienVerwalter;
import bibliotheksverwaltung.model.logic.SuchVerwalter;
import bibliotheksverwaltung.util.UpdateInfo;

public class OutputArea extends JPanel implements Observer
{
	private BibliotheksVerwalter verwalter = null;

	public OutputArea(BibliotheksVerwalter derVerwalter)
	{
		super();
		this.verwalter = derVerwalter;
		//v1 --> Suchverwwalter
		verwalter.getSuchVerwalter().addObserver(this);
		//v2 --> Medienverwalter
		verwalter.getMedienVerwalter().addObserver(this);
	}

	/* (non-Javadoc)
	 * @see java.util.Observer#update(java.util.Observable, java.lang.Object)
	 */
	@Override
	public void update(Observable o, Object arg)
	{
		UpdateInfo updateInfo = (UpdateInfo) arg;
		String ausgabe = "";
		if (updateInfo.holeAenderung().equals("Mediumsuche"))
		{
			if (updateInfo.holeAenderungOk())
			{
				this.removeAll();
				this.setPreferredSize(new Dimension(563, 245 * ((this.verwalter.getSuchVerwalter().getErgebnisse().size() + 2) / 3)));
				if (this.verwalter.getSuchVerwalter().getErgebnisse().size() == 0)
				{
					this.add(new JLabel("Ihre Mediensuche lieferte leider keine Übereinstimmungen"));
				}
				else
				{
					for (int i = 0; i < this.verwalter.getSuchVerwalter().getErgebnisse().size(); i++)
					{
						Medium ergebnis = (Medium) this.verwalter.getSuchVerwalter().getErgebnisse().get(i);
						BuchAnsicht buch = new BuchAnsicht(ergebnis);
						this.add(buch);
						buch.addMouseListener(new BuchAnsichtMouseListener(verwalter, ergebnis));
						//buch.addMouseListener(new TestMouseListener(v2));
					}
				}
			}
		}
		else if (updateInfo.holeAenderung().equals("BuchEinzelAnsicht"))
		{
			if (updateInfo.holeAenderungOk())
			{
				this.removeAll();
				this.setPreferredSize(new Dimension(563, 533));
				BuchEinzelansichtPanel buchEinzel = new BuchEinzelansichtPanel(verwalter);
				this.add(buchEinzel);
			}
		}
		else if (updateInfo.holeAenderung().equals("Ausleihersuche"))
		{
			if (updateInfo.holeAenderungOk())
			{
				this.removeAll();
				this.setPreferredSize(new Dimension(563, 245 * ((this.verwalter.getSuchVerwalter().getErgebnisse().size() + 2) / 3)));
				if (this.verwalter.getSuchVerwalter().getErgebnisse().size() == 0)
				{
					this.add(new JLabel("Ihre Ausleihersuche lieferte leider keine Übereinstimmungen"));
				}
				else
				{
					for (int i = 0; i < this.verwalter.getSuchVerwalter().getErgebnisse().size(); i++)
					{
						Ausleiher ergebnis = (Ausleiher) this.verwalter.getSuchVerwalter().getErgebnisse().get(i);
						this.add(new JButton(ergebnis.getNachName()));
					}
				}
			}
		}
		this.repaint();
		this.revalidate();
	}

}
