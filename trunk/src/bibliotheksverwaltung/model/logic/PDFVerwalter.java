/**
 * 
 */
package bibliotheksverwaltung.model.logic;

import bibliotheksverwaltung.model.domain.Ausleiher;
import bibliotheksverwaltung.model.domain.Exemplar;
import bibliotheksverwaltung.model.domain.Medium;

public class PDFVerwalter {

	/**
	 * 
	 * @param mv
	 */
	public PDFVerwalter(MahnlisteVerwalter mv) {

	}

	public String createMahnliste() {

		Medium m = new Medium(1);
		Ausleiher a = new Ausleiher(1);
		Exemplar e = new Exemplar(1);

		String speicherpfadDerErstelltenPDF = "tmp.pdf";
		return speicherpfadDerErstelltenPDF;

	}

}
