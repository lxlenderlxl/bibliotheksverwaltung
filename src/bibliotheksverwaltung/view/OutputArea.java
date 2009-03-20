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
		this.setPreferredSize(new Dimension(563, 252 * ((v1.getErgebnisse().size() + 1) / 2)));
		if (updateInfo.holeAenderung().equals("Mediumsuche"))
		{
			if (updateInfo.holeAenderungOk())
			{
				//ausgabe += "Ihre Suche ergab " + v1.getErgebnisse().size() + " Treffer\n\n";
				for (int i = 0; i < v1.getErgebnisse().size(); i++)
				{
					Medium ergebnis = (Medium) v1.getErgebnisse().get(i);
					BuchAnsicht buch = new BuchAnsicht(ergebnis);
					buch.addMouseListener(new BuchAnsichtMouseListener(v2));
					this.add(buch);
				}
			}
			this.doLayout();
			this.revalidate();
		}
	}

}
