import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;



public class Gui extends JPanel {
	
	static econPanel e = new econPanel();
	static boolean i = true;
	public Gui() throws IOException {
		JLayeredPane gamePanel = new JLayeredPane();
		//gamePanel.setBackground(Color.NONE);
		gamePanel.setPreferredSize(new Dimension(924,924));
		mapPanel m = new mapPanel();
		
		
		
		
		board test = new board();
		
		
		//test.setPreferredSize(new Dimension(924,924));
		
		//gamePanel.setComponentZOrder(m, 2);
		////gamePanel.setComponentZOrder(test, 1);
		
		
		
		m.setBounds(-10, 0, 943, 943);
		test.setBounds(-1, 4, 943, 943);
		gamePanel.add(m,1,0);
		gamePanel.add(test,2,0);
		
		
		JPanel infoPanel = new JPanel();
		infoPanel.setBackground(Color.PINK);
		
		
		
		weaponsPanel w = new weaponsPanel();
		dataPanel d = new dataPanel();
		EndTurn g = new EndTurn();
		
		infoPanel.setLayout(new BoxLayout(infoPanel, BoxLayout.Y_AXIS));
		infoPanel.setPreferredSize(new Dimension(300,850));
		infoPanel.add(d);
		infoPanel.add(e);
		infoPanel.add(w);
		infoPanel.add(g);
		
		
		add(gamePanel, BorderLayout.CENTER);
		add(infoPanel, BorderLayout.EAST);
	}

	public static void endturns(){
		
		
			
			
		if(i == true) {
		e.setBackground(new Color(255,106,106));
		
		}
		if(i == false) {
		e.setBackground(new Color(72,118,255));
			
		}
		i = !i;
		}
	}


	



