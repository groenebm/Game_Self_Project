import java.io.IOException;

import javax.swing.JFrame;

public class Main {

	public static void main(String[] args) throws IOException {
	JFrame f = new JFrame("Dominion");
	f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
	f.setContentPane(new Gui());
	f.pack();
	f.setLocationRelativeTo(null);
	f.setVisible(true);
	weaponsPanel.endturn();
	
	
	}

}
