/**
 * @author Sven Terzyk, Max Beier, Sven Blaurock
 */
package bibliotheksverwaltung.model.logic;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.sql.Date;
import java.util.ArrayList;

import bibliotheksverwaltung.model.domain.Schreibbar;
import bibliotheksverwaltung.util.LocalEnvironment;

import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Element;
import com.lowagie.text.Paragraph;
import com.lowagie.text.html.HtmlWriter;
import com.lowagie.text.html.simpleparser.HTMLWorker;
import com.lowagie.text.html.simpleparser.StyleSheet;
import com.lowagie.text.pdf.PdfWriter;

/**
 * Diese Klasse Realisiert DruckVerwalter. 
 */
public class DruckVerwalter
{
	/**
	 * Liste von Objekten
	 */
	private ArrayList<Object> liste = new ArrayList<Object>();
	/**
	 * Erstellt ein neues File
	 */
	private File temp = null;
	//Konstruktor
	public DruckVerwalter()
	{

	}
	
	/**
	 * fuegt ein Objekt hinzu.
	 * @param objekt
	 */
	public void fuegeObjektHinzu(Object objekt)
	{
		this.liste.add(objekt);
	}
	
	/**
	 * fuegt ein Objekt hinzu.
	 * @param objekte
	 */
	public void fuegeObjekteHinzu(ArrayList objekte)
	{
		this.liste = objekte;
	}
	
	/**
	 * Löscht die Liste von Objekten
	 */
	public void clearAll()
	{
		this.liste.clear();
	}

	/**
	 * Druckt die Liste
	 */
	public void drucke()
	{
		Document document = new Document();
		this.createTempFile();
		try
		{
			HtmlWriter.getInstance(document, new FileOutputStream(temp));
			document.open();
			String dokumentText = this.erzeugeText();
			document.add(new Paragraph(dokumentText));
		} catch (FileNotFoundException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (DocumentException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			document.close();
		}
		this.openDocument();
	}

	private void createTempFile()
	{
		// Create temp file.
		try
		{
			temp = File.createTempFile("tmp_" + LocalEnvironment.getFormattedDateTime(), ".pdf");
			// Delete temp file when program exits.
			temp.deleteOnExit();
		} catch (IOException e)
		{

		}
	}

	/**
	 * Oeffnet das Dokument
	 */
	private void openDocument()
	{
		try
		{
			new ProcessBuilder( "cmd", "/c", temp.getAbsolutePath()).start();
		}
		catch (Exception exp)
		{
			LocalEnvironment.log("Konnte Datei nicht öffnen " + temp.getAbsolutePath(), this);
		}
	}

	/**
	 * Erzeugt einen Text in html.
	 * @return rueck.
	 */
	private String erzeugeText()
	{
		String rueck = "<html><body><table>";
		for (int i = 0; i < liste.size(); i++)
		{
			Schreibbar element = (Schreibbar) liste.get(i);
			if (i % 2 == 0)
				rueck += "<tr>";
			else
				rueck += "<tr bgcolor=\"#cccccc\">";
			rueck += element.getBeschreibung();
		}
		rueck += "</table></body></html>";
		System.out.println(rueck);
		return rueck;
	}

	/**
	 * Druck Test
	 */
	public void druckTest()
	{
		Document document = new Document();
		//reader auf HTML-"inhalt"
		Reader htmlreader = new StringReader(this.erzeugeText());
		this.createTempFile();
		try
		{
			// OutputStream - enhält nachher geparste daten
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			PdfWriter.getInstance(document, baos);
			//Style
			StyleSheet styles = new StyleSheet();
			styles.loadTagStyle("body", "font", "Arial");
			styles.loadTagStyle("body", "size", "12px");
			styles.loadTagStyle("table", "border", "1");
			styles.loadTagStyle(".grey", "background-color", "#cccccc");

			document.open();

			ArrayList p = HTMLWorker.parseToList(htmlreader, styles);
			for (int k = 0; k < p.size(); ++k) {
				Element e = (Element) p.get(k);
				document.add(e);
			}
			document.close();

			byte[] bs = baos.toByteArray();

			FileOutputStream out = new FileOutputStream(this.temp);
			out.write(bs);
			out.close();
		} catch (FileNotFoundException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (DocumentException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.openDocument();
	}
}
