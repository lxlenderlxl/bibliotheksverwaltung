/**
 *
 */
package bibliotheksverwaltung.view;

import java.awt.Dimension;
import java.awt.GridBagLayout;
import java.awt.FlowLayout;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import bibliotheksverwaltung.controller.BuchAnsichtMouseListener;
import bibliotheksverwaltung.model.domain.Exemplar;
import bibliotheksverwaltung.model.domain.Medium;
import bibliotheksverwaltung.model.logic.MedienVerwalter;
import bibliotheksverwaltung.model.logic.SuchVerwalter;
import bibliotheksverwaltung.util.UpdateInfo;

public class OutputArea extends JPanel implements Observer
{
	private SuchVerwalter v1 = null;
	private MedienVerwalter v2 = null;

	public OutputArea(SuchVerwalter v1, MedienVerwalter v2)
	{
		super();
		this.v1 = v1;
		this.v2 = v2;
		v1.addObserver(this);
		v2.addObserver(this);
	}

	/* (non-Javadoc)
	 * @see java.util.Observer#update(java.util.Observable, java.lang.Object)
	 */
	@Override
	public void update(Observable o, Object arg)
	{
		UpdateInfo updateInfo = (UpdateInfo) arg;
		String ausgabe = "";
		this.removeAll();
		if (updateInfo.holeAenderung().equals("Mediumsuche"))
		{
			if (updateInfo.holeAenderungOk())
			{
				this.setPreferredSize(new Dimension(563, 245 * ((v1.getErgebnisse().size() + 2) / 3)));
				for (int i = 0; i < v1.getErgebnisse().size(); i++)
				{
					Medium ergebnis = (Medium) v1.getErgebnisse().get(i);
					BuchAnsicht buch = new BuchAnsicht(ergebnis);
					buch.addMouseListener(new BuchAnsichtMouseListener(v2, ergebnis));
					this.add(buch);
				}
			}
		}
		else if (updateInfo.holeAenderung().equals("ExemplareErzeugt"))
		{
			if (updateInfo.holeAenderungOk())
			{
				this.setPreferredSize(new Dimension(563, 533));
				BuchEinzelansichtPanel buchAnsicht = new BuchEinzelansichtPanel(this.v2);
				this.add(buchAnsicht);
			}
		}
		this.doLayout();
		this.revalidate();
	}

}