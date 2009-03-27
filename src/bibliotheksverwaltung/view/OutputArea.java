/**
 *
 */
package bibliotheksverwaltung.view;

import java.awt.Dimension;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JLabel;
import javax.swing.JPanel;

import bibliotheksverwaltung.controller.BuchAnsichtMouseListener;
import bibliotheksverwaltung.controller.PersonAnsichtMouseListener;
import bibliotheksverwaltung.model.domain.Ausleiher;
import bibliotheksverwaltung.model.domain.Medium;
import bibliotheksverwaltung.model.logic.BibliotheksVerwalter;
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
		verwalter.getAusleiherVerwalter().addObserver(this);
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
			this.verwalter.getDruckVerwalter().clearAll();
			if (updateInfo.holeAenderungOk())
			{
				this.removeAll();
				this.setPreferredSize(new Dimension(563, 245 * ((this.verwalter.getSuchVerwalter().getErgebnisse().size() + 2) / 3)));
				if (this.verwalter.getSuchVerwalter().getErgebnisse().size() == 0)
				{
					this.add(new JLabel("Ihre Mediensuche lieferte leider keine Uebereinstimmungen"));
				}
				else
				{
					for (int i = 0; i < this.verwalter.getSuchVerwalter().getErgebnisse().size(); i++)
					{
						Medium ergebnis = (Medium) this.verwalter.getSuchVerwalter().getErgebnisse().get(i);
						this.verwalter.getMedienVerwalter().setMedium(ergebnis);
						this.verwalter.getDruckVerwalter().fuegeObjektHinzu(ergebnis);
						BuchAnsicht buch = new BuchAnsicht(this.verwalter);
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
			this.verwalter.getDruckVerwalter().clearAll();
			if (updateInfo.holeAenderungOk())
			{
				this.removeAll();
				this.setPreferredSize(new Dimension(563, 245 * ((this.verwalter.getSuchVerwalter().getErgebnisse().size() + 2) / 3)));
				if (this.verwalter.getSuchVerwalter().getErgebnisse().size() == 0)
				{
					this.add(new JLabel("Ihre Ausleihersuche lieferte leider keine Uebereinstimmungen"));
				}
				else
				{
					for (int i = 0; i < this.verwalter.getSuchVerwalter().getErgebnisse().size(); i++)
					{
						Ausleiher ergebnis = (Ausleiher) this.verwalter.getSuchVerwalter().getErgebnisse().get(i);
						this.verwalter.getAusleiherVerwalter().setAusleiher(ergebnis);
						this.verwalter.getDruckVerwalter().fuegeObjektHinzu(ergebnis);
						PersonenAnsicht person = new PersonenAnsicht(this.verwalter);
						this.add(person);
						person.addMouseListener(new PersonAnsichtMouseListener(verwalter, ergebnis));
					}
				}
			}
		}
		else if (updateInfo.holeAenderung().equals("PersonenEinzelAnsicht"))
		{
			if (updateInfo.holeAenderungOk())
			{
				this.removeAll();
				this.setPreferredSize(new Dimension(563, 533));
				PersonEinzelAnsicht personenEinzel = new PersonEinzelAnsicht(verwalter);
				this.add(personenEinzel);
			}
		}
		this.repaint();
		this.revalidate();
	}

}
