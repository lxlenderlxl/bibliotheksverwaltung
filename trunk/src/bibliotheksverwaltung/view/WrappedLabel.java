/**
 * 
 */
package bibliotheksverwaltung.view;

import javax.swing.JLabel;
import javax.swing.JTextArea;

public class WrappedLabel extends JTextArea
{
	JLabel label = new JLabel();

	public WrappedLabel(String text) {
		super(text);
		this.setEditable(false);
		this.setLineWrap(true);
		this.setWrapStyleWord(true);
		this.setFont(label.getFont());
		this.setOpaque(false);
		//this.setBorder(null);
		this.setSize(200, 200);
	}
}
