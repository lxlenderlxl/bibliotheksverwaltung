/**
 * 
 */
package bibliotheksverwaltung.model.logic;

import java.util.ArrayList;
import java.util.List;

import bibliotheksverwaltung.model.domain.Ausleiher;
import bibliotheksverwaltung.model.domain.Exemplar;

public class PDFVerwalter {

	/**
	 * 
	 * @param mv
	 */
	public PDFVerwalter(MahnlisteVerwalter mv) {

	}

	public String createMahnliste() {

		Ausleiher a = new Ausleiher(1);
		List<Exemplar> le = new ArrayList<Exemplar>();
		
		// Medium m = new Medium(le.get(idx).getMedium());
		// für jedes exemplar das medium holen nacheinander von mir aus.
		
		String speicherpfadDerErstelltenPDF = "tmp.pdf";
		return speicherpfadDerErstelltenPDF;

	}

}
