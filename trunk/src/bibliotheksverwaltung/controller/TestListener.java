/**
 *
 */
package bibliotheksverwaltung.controller;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JFileChooser;

import bibliotheksverwaltung.model.domain.Medium;
import bibliotheksverwaltung.model.logic.MedienVerwalter;

public class TestListener implements MouseListener
{
	/* (non-Javadoc)
	 * @see java.awt.event.MouseListener#mouseClicked(java.awt.event.MouseEvent)
	 */
	@Override
	public void mouseClicked(MouseEvent e)
	{

	}

	/* (non-Javadoc)
	 * @see java.awt.event.MouseListener#mouseEntered(java.awt.event.MouseEvent)
	 */
	@Override
	public void mouseEntered(MouseEvent e)
	{
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see java.awt.event.MouseListener#mouseExited(java.awt.event.MouseEvent)
	 */
	@Override
	public void mouseExited(MouseEvent e)
	{
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see java.awt.event.MouseListener#mousePressed(java.awt.event.MouseEvent)
	 */
	@Override
	public void mousePressed(MouseEvent e)
	{
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see java.awt.event.MouseListener#mouseReleased(java.awt.event.MouseEvent)
	 */
	@Override
	public void mouseReleased(MouseEvent e)
	{
		Document doc = new Document();
		try
		{
			String pdfName = String.valueOf(System.currentTimeMillis());
		// Create temp file.
      File temp = File.createTempFile(pdfName, ".pdf");
  
      // Delete temp file when program exits.
      temp.deleteOnExit();
  
//      // Write to temp file
//      BufferedWriter out = new BufferedWriter(new FileWriter(temp));
//      out.write("aString");
//      out.close();
      
			PdfWriter.getInstance(doc, new FileOutputStream(pdfName));
			doc.open();
			doc.add(new Paragraph("Hello World"));
			doc.close();
			System.out.println("Bericht wurde geschrieben");
			Process p = Runtime.getRuntime().exec("rundll32 url.dll,FileProtocolHandler " + pdfName);
			p.waitFor();

		} catch (FileNotFoundException e1)
		{
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (DocumentException e1)
		{
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e1)
		{
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (InterruptedException e1)
		{
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

	}

}
