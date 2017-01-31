import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;

public class mapPanel extends JPanel {

Dimension d = new Dimension(943,943);

Graphics g;	


		
	mapPanel() {
		
		BufferedImage wPic = null;
		try {
			wPic = ImageIO.read(this.getClass().getResource("squaremap.jpg"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		JLabel wIcon = new JLabel(new ImageIcon(wPic));
		
		
		add(wIcon);
		
		
		
		
		
		
		
		
	}
	

        
        
        
        
    }



