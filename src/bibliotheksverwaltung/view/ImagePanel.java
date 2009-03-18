package bibliotheksverwaltung.view;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.JPanel;

class ImagePanel extends JPanel {
    //    ImagePanel panel = new ImagePanel(new ImageIcon("images/background.png").getImage());

  private Image img;

  public ImagePanel(String datei) {
     this.img = new javax.swing.ImageIcon(this.getClass().getResource("/bibliotheksverwaltung/view/images/" + datei)).getImage(); // NOI18N
    Dimension size = new Dimension(img.getWidth(null), img.getHeight(null));
    setPreferredSize(size);
    setMinimumSize(size);
    setMaximumSize(size);
    setSize(size);
    setLayout(null);
  }

    @Override
  public void paintComponent(Graphics g) {
    g.drawImage(img, 0, 0, null);
  }

}