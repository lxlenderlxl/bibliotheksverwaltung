/**
 * 
 */
package bibliotheksverwaltung.view;

import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JTextArea;

import bibliotheksverwaltung.model.domain.Medium;
import bibliotheksverwaltung.model.logic.SuchVerwalter;
import bibliotheksverwaltung.util.UpdateInfo;

public class OutputArea extends JTextArea implements Observer
{
	private SuchVerwalter v1 = null;
	public OutputArea(SuchVerwalter v1)
	{
		this.v1 = v1;
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
		if (updateInfo.holeAenderung().equals("Mediumsuche"))
		{
			if (updateInfo.holeAenderungOk())
			{
				ausgabe += "Ihre Suche ergab " + v1.getErgebnisse().size() + " Treffer\n\n";
				for (int i = 0; i < v1.getErgebnisse().size(); i++)
				{
					Medium ergebnis = (Medium) v1.getErgebnisse().get(i);
					ausgabe += "ID: " + ergebnis.getId() + "\n";
					ausgabe += "Titel: " + ergebnis.getTitel() + "\n";
					ausgabe += "Autor: " + ergebnis.getAutorNachname() + ", "+ ergebnis.getAutorVorname() + "\n";
					ausgabe += "E-Jahr: " + ergebnis.getErscheinungsJahr() + "\n";
					ausgabe += "----------------------------------------------------------------\n";
				}
				this.setText(ausgabe);
			}
			else
			{
				
			}
		}
	}

}
