import javax.swing.JPanel;
import javax.swing.JSplitPane;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.JButton;
import javax.swing.JLabel;

public class EndTurn extends JPanel {

	Dimension d = new Dimension(200,100);
	Dimension e = new Dimension(100,50);
	public EndTurn() {
		
		
		
		JSplitPane splitPane = new JSplitPane();
		splitPane.setMinimumSize(d);
		splitPane.setPreferredSize(d);
		add(splitPane);
		
		JButton btnNewButton = new JButton("End Turn");
		splitPane.setRightComponent(btnNewButton);
		
		JLabel lblPlayer = new JLabel("Turn");
		splitPane.setLeftComponent(lblPlayer);
		lblPlayer.setPreferredSize(e);
		
		
		
		btnNewButton.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent arg0) {
				try {
					PlayBell();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				Player.endturn();
				
				Gui.endturns();
				Resource.endturn();
				
				
				Player.p1.setTurn(!Player.p1.isTurn());
				Player.p2.setTurn(!Player.p2.isTurn());
				lblPlayer.setText("Turn: Player " + Player.getPlayerTurnO());
				econPanel.endturn();
				board.priceAdjust();
				weaponsPanel.endturn();
				
			}
		});

		
		
	}
	
	public static void PlayBell() throws Exception{
		
		Clip clip;
		File sound = new File("turnend.wav");
		clip = AudioSystem.getClip();
		
		AudioInputStream ais = AudioSystem.getAudioInputStream(sound);
		clip.open(ais);
		clip.start();
		 
		
		
		}

}
