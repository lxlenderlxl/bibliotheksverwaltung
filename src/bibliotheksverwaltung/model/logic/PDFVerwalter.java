/**
 * 
 */
package bibliotheksverwaltung.model.logic;

import java.io.BufferedOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
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
import com.lowagie.text.PageSize;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfWriter;

public class PDFVerwalter {

	private String resultPath = "";
	private String resultName = "tmp.pdf";

	private MahnlisteVerwalter mahnlistenVerwalter;

	String Mahnungstext = "Die Leihfrist fuer das/die von Ihnen entliehene/n Medium/Medien ist ueberschritten. Wir bitten um sofortige Rueckgabe "
			+ "oder Fristverlaengerung. Die Mahngebuehren (0,50 EUR pro Medieneinheit und 0,20 EUR pro Oeffnungstag)  zzgl. 0,55 EUR Portokosten sind umgehend "
			+ "in der Ausleihe zu begleichen. Die Portokosten fuer e-mails entfallen.";

	public PDFVerwalter() {
		mahnlistenVerwalter = new MahnlisteVerwalter();
	}

	public PDFVerwalter(MahnlisteVerwalter mv) {

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
			pdf = PdfWriter.getInstance(document, new BufferedOutputStream(
					new FileOutputStream(resultPath + '/' + resultName)));
			//
			// Für jede Mahnliste ein Seite reinschreiben.
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
		for (Exemplar e : m.getExemplare()) {
			// Text für jedes Exemplar (e) und seinem Medium (med) schreiben.
			//
			Medium med = new Medium(e.getMedium());
		}
		d.add(Chunk.NEXTPAGE);
	}

	/**
	 * 
	 * @return
	 */
	public String createMahnliste() {
		int ausleiher = 1;
		Ausleiher a = new Ausleiher(ausleiher);
		List<Exemplar> le = new ArrayList<Exemplar>();
		Mahnliste m = new Mahnliste(ausleiher);

		Document d = new Document(PageSize.A4);

		for (int i = 1; i < 5; i++) {
			try {
				PdfWriter.getInstance(d, new FileOutputStream("Brief.pdf"));

				// open
				d.open();
				// schreiben

				// Header
				Font headerueberschrift_font = FontFactory.getFont(
						FontFactory.HELVETICA_BOLD, 14);
				Chunk headerueberschrift = new Chunk("Bibliothek",
						headerueberschrift_font);
				d.add(headerueberschrift);
				// HEAD-Anschrift
				d
						.add(new Paragraph(
								"\nTel: (030) 5019-2240\n"
										+ "Fax: (030) 5019-2397 "
										+ "                              "
										+ "                                 mail: Ausleihe-KH@fhtw-berlin.de "
										+ "FHTW, Treskowallee 8, 10313 Berlin ______________________________________________________________________________"));

				d
						.add(new Paragraph(
								"\nAn                                                                                            "
										+ "         Benutzernummer: "
										+ a.getId()
										+ "\n"
										+ a.getName()
										+ " "
										+ a.getNachName()
										+ "\n"
										+ a.getStrasse()
										+ " "
										+ a.getHausnummer()
										+ "\n"
										+ a.getPlz() + " " + a.getStadt() + "\n\n\n"));

				d.add(new Paragraph(" "));

			} catch (DocumentException de) {
				System.err.println(de.getMessage());
			} catch (IOException ioe) {
				System.err.println(ioe.getMessage());
			}

			// step 5: we close the document

			// Medium m = new Medium(le.get(idx).getMedium());
			// für jedes exemplar das medium holen nacheinander von mir aus.
			ausleiher++;
		}
		d.close();
		String speicherpfadDerErstelltenPDF = "Brief.pdf";
		return speicherpfadDerErstelltenPDF;

	}

	public static void main(String args[]) {
		PDFVerwalter a = new PDFVerwalter();
		a.saveMahnlisten();
	}

}