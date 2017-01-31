import javax.swing.JPanel;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.border.LineBorder;
import java.awt.Color;

public class econPanel extends JPanel {
	static JLabel label = new JLabel("food");
	static JLabel label_1 = new JLabel("wood");
	static JLabel label_2 = new JLabel("jewels");
	static JLabel label_3 = new JLabel("spices");
	static JLabel label_4 = new JLabel("leather");
	static JLabel lblPlayergethealth = new JLabel("Enemy HP: ");
	static JLabel lblHealth = new JLabel("HP:" + Player.getPlayerTurn().getHealth());
	
	static JLabel lblResourcegetfoodprice = new JLabel("$"    +  Resource.FOOD.getPrice());
	static JLabel lblResourcegetwoodprice = new JLabel("$"    +  Resource.WOOD.getPrice());
	static JLabel lblResourcegetjewelprice = new JLabel("$"   +  Resource.JEWELS.getPrice());
	static JLabel lblResourcegetspiceprice = new JLabel("$"   +  Resource.SPICE.getPrice());
	static JLabel lblResourcegetleatherprice = new JLabel("$" +  Resource.LEATHER.getPrice());
	
	static JLabel lblPlayergetmoney = new JLabel("$" + Player.getBackpack().getGold());
	
	static String numbers = "";
	static int number= 0;
	
	public static void endturn(){
		
		label.setText(""   + Player.getBackpack().getFood());
		label_1.setText("" + Player.getBackpack().getWood());
		label_2.setText("" + Player.getBackpack().getGems());
		label_3.setText("" + Player.getBackpack().getSpices());
		label_4.setText("" + Player.getBackpack().getLeather());
		lblHealth.setText("HP: " + Player.getPlayerTurn().getHealth());
		lblPlayergethealth.setText("Enemy HP: " + Player.getOtherPlayerTurn().getHealth());
		lblResourcegetfoodprice.setText("$"    + Resource.FOOD.getPrice());
		lblResourcegetwoodprice.setText("$"    + Resource.WOOD.getPrice());
		lblResourcegetjewelprice.setText("$"   + Resource.JEWELS.getPrice());
		lblResourcegetspiceprice.setText("$"   + Resource.SPICE.getPrice());
		lblResourcegetleatherprice.setText("$" + Resource.LEATHER.getPrice());
		lblPlayergetmoney.setText("$"+Player.getBackpack().getGold());
		
	}
	
	public static void moneyupdate(){
		
		System.out.println("update");
		lblPlayergetmoney.setText("$" + Player.getBackpack().getGold());
		weaponupdate();
	}
	
public static void healthupdate(){
		
		System.out.println("update");
		lblPlayergethealth.setText("Enemy Health: " + Player.getOtherPlayerTurn().getHealth());
	}

public static void weaponupdate(){
	
	weaponsPanel.endturn();
}
	
	public econPanel() {
	
		
		
		setBorder(new LineBorder(new Color(0, 0, 0)));
		setLayout(null);
		label.setBounds(100, 5, 25, 16);
		add(label);
		//label.setText("" + Player.getBackpack().getFood());
		
		JLabel lblFood = new JLabel("Food");
		lblFood.setBounds(138, 5, 28, 16);
		add(lblFood);
		
		JButton btnSell_1 = new JButton("Sell Food");
		btnSell_1.setBounds(221, 1, 85, 25);
		add(btnSell_1);
		
		btnSell_1.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent arg0) {
				numbers = JOptionPane.showInputDialog("Number to sell");
				number = Integer.parseInt(numbers);
				for(int i = 0; i < number; i++) {
				if(Player.getBackpack().getFood() <= 0){ 
					infoBox("No Food", "Not enough resources");
					break;
				}
				System.out.println("Food Sold");
				Player.getBackpack().setFood(Player.getBackpack().getFood()- 1);
				Player.getBackpack().setGold(Player.getBackpack().getGold() + Resource.FOOD.getPrice());
				label.setText(""   + Player.getBackpack().getFood());
				try {
					PlaySell();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				moneyupdate();
			}
			}
		});
		lblResourcegetfoodprice.setBounds(319, 5, 21, 16);
		add(lblResourcegetfoodprice);
		label_1.setBounds(97, 35, 31, 16);
		add(label_1);
		//label_1.setText("" + Player.getBackpack().getWood());
		
		JLabel lblWood = new JLabel("Wood");
		lblWood.setBounds(138, 35, 33, 16);
		add(lblWood);
		
		JButton btnSell = new JButton("Sell Wood");
		btnSell.setBounds(218, 31, 91, 25);
		add(btnSell);
		
		btnSell.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent arg0) {
				numbers = JOptionPane.showInputDialog("Number to sell");
				number = Integer.parseInt(numbers);
				for(int i = 0; i < number; i++) {
				if(Player.getBackpack().getWood() <= 0){ 
					infoBox("No Wood", "Not enough resources");
					break;
				}
				System.out.println("Wood Sold");
				Player.getBackpack().setWood(Player.getBackpack().getWood()- 1);
				Player.getBackpack().setGold(Player.getBackpack().getGold() + Resource.WOOD.getPrice());
				label_1.setText(""   + Player.getBackpack().getWood());
				try {
					PlaySell();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				moneyupdate();
			}
			}
		});
		lblResourcegetwoodprice.setBounds(319, 35, 21, 16);
		add(lblResourcegetwoodprice);
		label_2.setBounds(94, 95, 37, 16);
		add(label_2);
		//label_2.setText("" + Player.getBackpack().getGems());
		
		JLabel lblJewels = new JLabel("Jewels");
		lblJewels.setBounds(138, 95, 38, 16);
		add(lblJewels);
		
		JButton btnNewButton = new JButton("Sell Jewels");
		btnNewButton.setBounds(211, 91, 95, 25);
		add(btnNewButton);
		
		btnNewButton.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent arg0) {
				numbers = JOptionPane.showInputDialog("Number to sell");
				number = Integer.parseInt(numbers);
				for(int i = 0; i < number; i++) {
				if(Player.getBackpack().getGems() <= 0){ 
					infoBox("No Gems", "Not enough resources");
					break;
				}
				System.out.println("Gems Sold");
				Player.getBackpack().setGems(Player.getBackpack().getGems()- 1);
				Player.getBackpack().setGold(Player.getBackpack().getGold() + Resource.JEWELS.getPrice());
				label_2.setText(""   + Player.getBackpack().getGems());
				try {
					PlaySell();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				moneyupdate();
			}
			}
		});
		lblResourcegetjewelprice.setBounds(319, 95, 14, 16);
		add(lblResourcegetjewelprice);
		label_3.setBounds(95, 125, 35, 16);
		add(label_3);
		//label_3.setText("" + Player.getBackpack().getSpices());
		
		JLabel lblSpice = new JLabel("Spice");
		lblSpice.setBounds(138, 125, 31, 16);
		add(lblSpice);
		
		JButton btnNewButton_1 = new JButton("Sell Spice");
		btnNewButton_1.setBounds(219, 121, 89, 25);
		add(btnNewButton_1);
		
		btnNewButton_1.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent arg0) {
				numbers = JOptionPane.showInputDialog("Number to sell");
				number = Integer.parseInt(numbers);
				for(int i = 0; i < number; i++) {
				if(Player.getBackpack().getSpices() <= 0){ 
					infoBox("No spice left", "Not enough resources");
					break;
				}
				System.out.println("Spice Sold");
				Player.getBackpack().setSpices(Player.getBackpack().getSpices()- 1);
				Player.getBackpack().setGold(Player.getBackpack().getGold() + Resource.SPICE.getPrice());
				label_3.setText(""   + Player.getBackpack().getSpices());
				try {
					PlaySell();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				moneyupdate();
				
			}
			}
		});
		lblResourcegetspiceprice.setBounds(319, 125, 14, 16);
		add(lblResourcegetspiceprice);
		label_4.setBounds(92, 155, 40, 16);
		add(label_4);
		//label_4.setText("" + Player.getBackpack().getLeather());
		
		JLabel lblLeather = new JLabel("Leather");
		lblLeather.setBounds(138, 155, 43, 16);
		add(lblLeather);
		
		JButton btnNewButton_2 = new JButton("Sell Leather");
		btnNewButton_2.setBounds(213, 151, 101, 25);
		add(btnNewButton_2);
		
		btnNewButton_2.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent arg0) {
				numbers = JOptionPane.showInputDialog("Number to sell");
				number = Integer.parseInt(numbers);
				for(int i = 0; i < number; i++) {
				if(Player.getBackpack().getLeather() <= 0){ 
					infoBox("No leather left", "Not enough resources");
					break;
				}
				System.out.println("Leather Sold");
				Player.getBackpack().setLeather(Player.getBackpack().getLeather()- 1);
				Player.getBackpack().setGold(Player.getBackpack().getGold() + Resource.LEATHER.getPrice());
				label_4.setText(""   + Player.getBackpack().getLeather());
				try {
					PlaySell();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				moneyupdate();
			}
			}
		});
		lblResourcegetleatherprice.setBounds(319, 155, 14, 16);
		add(lblResourcegetleatherprice);
		
		JLabel lblTotalMoney = new JLabel("Total Money");
		lblTotalMoney.setBounds(138, 211, 70, 16);
		add(lblTotalMoney);
		lblPlayergetmoney.setBounds(253, 211, 21, 16);
		add(lblPlayergetmoney);
		
		//lblPlayergetmoney.setText("" + Player.getBackpack().getGold());
		
		setBackground(Color.WHITE);
		lblHealth.setBounds(92, 262, 41, 16);
		add(lblHealth);
		lblPlayergethealth.setBounds(230, 262, 66, 16);
		add(lblPlayergethealth);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 450, 88);
		add(panel);
		//lblHealth.setText("Your Health: " + Player.getPlayerTurn().getHealth());
		
		
		//lblPlayergethealth.setText("Enemy Health: " + Player.getOtherPlayerTurn().getHealth());
		
		
	}
	
	public static void infoBox(String infoMessage, String titleBar)
    {
        JOptionPane.showMessageDialog(null, infoMessage, "InfoBox: " + titleBar, JOptionPane.INFORMATION_MESSAGE);
    }
	
public static void PlaySell() throws Exception{
		
		Clip clip;
		File sound = new File("goldbuy.wav");
		clip = AudioSystem.getClip();
		
		AudioInputStream ais = AudioSystem.getAudioInputStream(sound);
		clip.open(ais);
		clip.start();
		 
		
		
		}

	private void setPreferredSize(int i, int j) {
		// TODO Auto-generated method stub
		
	}
}
