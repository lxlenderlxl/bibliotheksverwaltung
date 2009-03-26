/**
 * 
 */
package bibliotheksverwaltung.model.logic;

import java.io.BufferedOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;

import bibliotheksverwaltung.model.domain.Ausleiher;
import bibliotheksverwaltung.model.domain.Exemplar;
import bibliotheksverwaltung.model.domain.Mahnliste;
import bibliotheksverwaltung.model.domain.Medium;

import com.lowagie.text.Chunk;
import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Font;
import com.lowagie.text.FontFactory;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfWriter;

public class PDFVerwalter {

	/*
	 * Zum Speichern der PDF
	 */
	private String resultPath = "";
	private String resultName = "tmp.pdf";

	/*
	 * Irgendwo müssen die Infos ja herkommen.
	 */
	private MahnlisteVerwalter mahnlistenVerwalter;

	/**
	 * 
	 */
	public PDFVerwalter() {
		mahnlistenVerwalter = new MahnlisteVerwalter();
	}

	/**
	 * @throws DocumentException
	 * @throws FileNotFoundException
	 * 
	 */
	public void saveMahnlisten() {

		List<Mahnliste> l = new ArrayList<Mahnliste>();
		l.addAll(mahnlistenVerwalter.getMahnlisten());

		Document document = new Document();
		PdfWriter pdf = null;
		try {
			//
			// PDF anlegen.
			pdf = PdfWriter.getInstance(document, new BufferedOutputStream(new FileOutputStream(resultPath + '/' + resultName)));
			//
			// Für jede Mahnliste ein Seite reinschreiben.
			document.open();
			for (Mahnliste m : l)
				writeMahnliste(pdf, document, m);
			//
			//
		} catch (FileNotFoundException e) {
		} catch (DocumentException e) {
		} finally {
			document.close();
			pdf.close();
		}

	}

	/**
	 * 
	 * @param d
	 * @param m
	 * @throws DocumentException
	 */
	private void writeMahnliste(PdfWriter pw, Document d, Mahnliste m)
			throws DocumentException {
		d.newPage();
		// ab hier inhalt rein
		//
		Ausleiher a = m.getAusleiher();
		// Text für den Ausleiher.
		//
		final String mahnungstext = "Die Leihfrist fuer das/die von Ihnen entliehene/n Medium/Medien ist ueberschritten. Wir bitten um sofortige Rueckgabe oder Fristverlaengerung. Die Mahngebuehren (0,50 EUR pro Medieneinheit und 0,20 EUR pro Oeffnungstag)  zzgl. 0,55 EUR Portokosten sind umgehend in der Ausleihe zu begleichen. Die Portokosten fuer e-mails entfallen.";
		Font headerueberschrift_font = FontFactory.getFont(FontFactory.HELVETICA_BOLD, 14);
		Chunk headerueberschrift = new Chunk("Bibliothek", headerueberschrift_font);
		d.add(headerueberschrift);
		d.add(new Paragraph("\nTel: (030) 5019-2240\nFax: (030) 5019-2397                                                               mail: Ausleihe-KH@fhtw-berlin.de FHTW, Treskowallee 8, 10313 Berlin ______________________________________________________________________________"));
		d.add(new Paragraph("\nAn                                                                                  " + "         Benutzernummer: " + a.getId() + "\n" + a.getName() + " " + a.getNachName() + "\n" + a.getStrasse() + " " + a.getHausnummer() + "\n" + a.getPlz() + " " + a.getStadt() + "\n\n\n"));
		d.add(new Paragraph(" "));
		//
		//
		for (Exemplar e : m.getExemplare()) {
			// Text für jedes Exemplar (e) und seinem Medium (med) schreiben.
			//
			Medium med = new Medium(e.getMedium());
		}
		d.add(Chunk.NEXTPAGE);
	}

	public static void main(String args[]) {
		PDFVerwalter a = new PDFVerwalter();
		a.saveMahnlisten();
	}

}