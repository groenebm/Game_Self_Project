import javax.swing.JPanel;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;

public class dataPanel extends JPanel {
	
	static JLabel lblNewLabel = new JLabel("Price");
	static JLabel lblWood = new JLabel("Resource");
	
	
	
	public dataPanel() {
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{48, 66, 90, 85, 0};
		gridBagLayout.rowHeights = new int[]{28, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		JLabel lblTile = new JLabel("Tile");
		GridBagConstraints gbc_lblTile = new GridBagConstraints();
		gbc_lblTile.insets = new Insets(0, 0, 0, 5);
		gbc_lblTile.gridx = 0;
		gbc_lblTile.gridy = 0;
		add(lblTile, gbc_lblTile);
		
		//JLabel lblWood = new JLabel("Wood");
		GridBagConstraints gbc_lblWood = new GridBagConstraints();
		gbc_lblWood.insets = new Insets(0, 0, 0, 5);
		gbc_lblWood.gridx = 1;
		gbc_lblWood.gridy = 0;
		add(lblWood, gbc_lblWood);
		
		
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.insets = new Insets(0, 0, 0, 5);
		gbc_lblNewLabel.gridx = 2;
		gbc_lblNewLabel.gridy = 0;
		add(lblNewLabel, gbc_lblNewLabel);
		
		JButton btnBuy = new JButton("Buy");
		GridBagConstraints gbc_btnBuy = new GridBagConstraints();
		gbc_btnBuy.anchor = GridBagConstraints.WEST;
		gbc_btnBuy.gridx = 3;
		gbc_btnBuy.gridy = 0;
		add(btnBuy, gbc_btnBuy);
	
		
		btnBuy.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent arg0) {
				System.out.println("Bought");
				
				board.buyTile();
				econPanel.moneyupdate();
			}
		});
		
		
		

	}
	
	
	

}
