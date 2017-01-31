import javax.swing.JPanel;
import java.awt.GridBagLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.GridBagConstraints;
import javax.swing.JButton;
import javax.swing.JComboBox;

import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JToolBar;



public class weaponsPanel extends JPanel {

	static int arrowcost = 50;
	static int arrowdamage = 30;
	
	static int catapultcost = 70;
	static int catapultdamage = 60;
	
	static int cannoncost = 80;
	static int cannondamage = 150;
	
	static int rocketcost = 140;
	static int rocketdamage = 200;
	
	static int mortarcost = 200;
	static int mortardamage = 260;
	
	static int airstrikecost = 350;
	static int airstrikedamage = 320;
	
	static int energybombcost = 420;
	static int energybombdamage = 500;
	
	static int nukecost = 700;
	static int nukedamage = 1000;
	
	static int healcost = 400;
	static int healamount = 200;
	
	public static int attackMod;
	static JButton arrowButton = new JButton("Launch");
	static JButton cannonButton = new JButton("Launch");
	static JButton catapultButtonh = new JButton("Launch");
	static JButton rocketButton = new JButton("Launch");
	static JButton mortarButton = new JButton("Launch");
	static JButton airstrikeButton = new JButton("Launch");
	static JButton enerygyBombButton = new JButton("Launch");
	static JButton nukeButton = new JButton("Launch");
	static JButton btnHeal = new JButton("Heal");
	public static void endturn(){
		
		Player.getOtherPlayerTurn();
		if(Player.getBackpack().getGold() < arrowcost) {
			arrowButton.setEnabled(false);
		} else { arrowButton.setEnabled(true); }
		
		if(Player.getBackpack().getGold() < catapultcost) {
			catapultButtonh.setEnabled(false);
		} else { catapultButtonh.setEnabled(true); }
		
		if(Player.getBackpack().getGold() < cannoncost) {
			cannonButton.setEnabled(false);
		} else { cannonButton.setEnabled(true); }
		
		if(Player.getBackpack().getGold() < rocketcost) {
			rocketButton.setEnabled(false);
		} else { rocketButton.setEnabled(true); }
		
		if(Player.getBackpack().getGold() < mortarcost) {
			mortarButton.setEnabled(false);
		} else { mortarButton.setEnabled(true); }
		
		if(Player.getBackpack().getGold() < airstrikecost) {
			airstrikeButton.setEnabled(false);
		} else { airstrikeButton.setEnabled(true); }
		
		if(Player.getBackpack().getGold() < energybombcost) {
			enerygyBombButton.setEnabled(false);
		} else { enerygyBombButton.setEnabled(true); }
		
		if(Player.getBackpack().getGold() < nukecost) {
			nukeButton.setEnabled(false);
		} else { nukeButton.setEnabled(true); }
		
		if(Player.getBackpack().getGold() < nukecost) {
			btnHeal.setEnabled(false);
		} else { btnHeal.setEnabled(true); }
	}
	
	
	public weaponsPanel() {
		
		
		
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 82, 20, 0, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 48, 0, 0, 0, 57, 0, 0, 0, 55, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		JLabel lblArrow = new JLabel("Arrow " + arrowdamage);
		GridBagConstraints gbc_lblArrow = new GridBagConstraints();
		gbc_lblArrow.insets = new Insets(0, 0, 5, 5);
		gbc_lblArrow.gridx = 1;
		gbc_lblArrow.gridy = 0;
		add(lblArrow, gbc_lblArrow);
		
		JLabel lblRaidingParty_1 = new JLabel("Catapult " + catapultdamage);
		GridBagConstraints gbc_lblRaidingParty_1 = new GridBagConstraints();
		gbc_lblRaidingParty_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblRaidingParty_1.gridx = 3;
		gbc_lblRaidingParty_1.gridy = 0;
		add(lblRaidingParty_1, gbc_lblRaidingParty_1);
		
		//JButton arrowButton = new JButton("Launch");
		GridBagConstraints gbc_btnAttack = new GridBagConstraints();
		gbc_btnAttack.insets = new Insets(0, 0, 5, 5);
		gbc_btnAttack.gridx = 1;
		gbc_btnAttack.gridy = 1;
		add(arrowButton, gbc_btnAttack);
		
		arrowButton.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent arg0) {
				if(Player.getBackpack().getGold() > arrowcost) {
				Player.getBackpack().setGold(Player.getBackpack().getGold() - arrowcost);
				Player.getOtherPlayerTurn().setHealth(Player.getOtherPlayerTurn().getHealth()- arrowdamage + modifier());
				econPanel.healthupdate();
				econPanel.moneyupdate();
				//DidItWin();
				if(Player.getOtherPlayerTurn().getHealth() <= 0) {
					infoBox("GAME OVER", "Player " + Player.getPlayerTurnO() + " wins!");
				}
			} else { infoBox("Cannot Fire", "Not enough money"); 
			
			}
				
			}
		});
		
		//JButton catapultButtonh = new JButton("Launch");
		GridBagConstraints gbc_btnLaunch = new GridBagConstraints();
		gbc_btnLaunch.insets = new Insets(0, 0, 5, 5);
		gbc_btnLaunch.gridx = 3;
		gbc_btnLaunch.gridy = 1;
		add(catapultButtonh, gbc_btnLaunch);
		
		catapultButtonh.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent arg0) {
				if(Player.getBackpack().getGold() > catapultcost) {
				Player.getBackpack().setGold(Player.getBackpack().getGold() - catapultcost);
				Player.getOtherPlayerTurn().setHealth(Player.getOtherPlayerTurn().getHealth()- catapultdamage + modifier());
				econPanel.healthupdate();
				econPanel.moneyupdate();
				if(Player.getOtherPlayerTurn().getHealth() <= 0) {
					infoBox("GAME OVER", "Player " + Player.getPlayerTurnO() + " wins!");
				}
			} else { infoBox("Cannot Fire", "Not enough money"); 
			
			}
			}
		});
		
		JLabel lblWood = new JLabel("$" + arrowcost);
		GridBagConstraints gbc_lblWood = new GridBagConstraints();
		gbc_lblWood.insets = new Insets(0, 0, 5, 5);
		gbc_lblWood.gridx = 1;
		gbc_lblWood.gridy = 2;
		add(lblWood, gbc_lblWood);
		
		JLabel label_3 = new JLabel("$" + catapultcost);
		GridBagConstraints gbc_label_3 = new GridBagConstraints();
		gbc_label_3.insets = new Insets(0, 0, 5, 5);
		gbc_label_3.gridx = 3;
		gbc_label_3.gridy = 2;
		add(label_3, gbc_label_3);
		
		JLabel lblRaidingParty = new JLabel("Cannon " + cannondamage);
		GridBagConstraints gbc_lblRaidingParty = new GridBagConstraints();
		gbc_lblRaidingParty.insets = new Insets(0, 0, 5, 5);
		gbc_lblRaidingParty.gridx = 1;
		gbc_lblRaidingParty.gridy = 4;
		add(lblRaidingParty, gbc_lblRaidingParty);
		
		JLabel lblRocket_1 = new JLabel("Rocket " + rocketdamage);
		GridBagConstraints gbc_lblRocket_1 = new GridBagConstraints();
		gbc_lblRocket_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblRocket_1.gridx = 3;
		gbc_lblRocket_1.gridy = 4;
		add(lblRocket_1, gbc_lblRocket_1);
		
		//JButton cannonButton = new JButton("Launch");
		GridBagConstraints gbc_btnAttack_1 = new GridBagConstraints();
		gbc_btnAttack_1.insets = new Insets(0, 0, 5, 5);
		gbc_btnAttack_1.gridx = 1;
		gbc_btnAttack_1.gridy = 5;
		add(cannonButton, gbc_btnAttack_1);
		
		cannonButton.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent arg0) {
				if(Player.getBackpack().getGold() > cannoncost) {
				Player.getBackpack().setGold(Player.getBackpack().getGold() - cannoncost);
				Player.getOtherPlayerTurn().setHealth(Player.getOtherPlayerTurn().getHealth()- cannondamage + modifier());
				econPanel.healthupdate();
				econPanel.moneyupdate();
				if(Player.getOtherPlayerTurn().getHealth() <= 0) {
					infoBox("GAME OVER", "Player " + Player.getPlayerTurnO() + " wins!");
				}
			} else { infoBox("Cannotn Fire", "Not enough money"); 
			
			}
			}
		});
		
		
		GridBagConstraints gbc_btnAttack_4 = new GridBagConstraints();
		gbc_btnAttack_4.insets = new Insets(0, 0, 5, 5);
		gbc_btnAttack_4.gridx = 3;
		gbc_btnAttack_4.gridy = 5;
		add(rocketButton, gbc_btnAttack_4);
		
		rocketButton.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent arg0) {
				if(Player.getBackpack().getGold() > rocketcost) {
				Player.getBackpack().setGold(Player.getBackpack().getGold() - rocketcost);
				Player.getOtherPlayerTurn().setHealth(Player.getOtherPlayerTurn().getHealth()- rocketdamage + modifier());
				econPanel.healthupdate();
				econPanel.moneyupdate();
				if(Player.getOtherPlayerTurn().getHealth() <= 0) {
					infoBox("GAME OVER", "Player " + Player.getPlayerTurnO() + " wins!");
				}
			} else { infoBox("Cannon Fire", "Not enough money"); 
			
			}
			}
		});
		
		JLabel label = new JLabel("$" + cannoncost);
		GridBagConstraints gbc_label = new GridBagConstraints();
		gbc_label.insets = new Insets(0, 0, 5, 5);
		gbc_label.gridx = 1;
		gbc_label.gridy = 6;
		add(label, gbc_label);
		
		JLabel label_4 = new JLabel("$" + rocketcost);
		GridBagConstraints gbc_label_4 = new GridBagConstraints();
		gbc_label_4.insets = new Insets(0, 0, 5, 5);
		gbc_label_4.gridx = 3;
		gbc_label_4.gridy = 6;
		add(label_4, gbc_label_4);
		
//		JToolBar toolBar = new JToolBar();
//		GridBagConstraints gbc_toolBar = new GridBagConstraints();
//		gbc_toolBar.insets = new Insets(0, 0, 5, 0);
//		gbc_toolBar.gridx = 4;
//		gbc_toolBar.gridy = 7;
//		add(toolBar, gbc_toolBar);
//		toolBar.add(new JComboBox(new String[]{"A","B","C"}));
		
		JLabel lblCannon = new JLabel("Mortars " + mortardamage);
		GridBagConstraints gbc_lblCannon = new GridBagConstraints();
		gbc_lblCannon.insets = new Insets(0, 0, 5, 5);
		gbc_lblCannon.gridx = 1;
		gbc_lblCannon.gridy = 8;
		add(lblCannon, gbc_lblCannon);
		
		JLabel lblAirstrike = new JLabel("Airstrike " + airstrikedamage);
		GridBagConstraints gbc_lblAirstrike = new GridBagConstraints();
		gbc_lblAirstrike.insets = new Insets(0, 0, 5, 5);
		gbc_lblAirstrike.gridx = 3;
		gbc_lblAirstrike.gridy = 8;
		add(lblAirstrike, gbc_lblAirstrike);
		
		
		GridBagConstraints gbc_btnAttack_2 = new GridBagConstraints();
		gbc_btnAttack_2.insets = new Insets(0, 0, 5, 5);
		gbc_btnAttack_2.gridx = 1;
		gbc_btnAttack_2.gridy = 9;
		add(mortarButton, gbc_btnAttack_2);
		
		mortarButton.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent arg0) {
				if(Player.getBackpack().getGold() > mortarcost) {
				Player.getBackpack().setGold(Player.getBackpack().getGold() - mortarcost);
				Player.getOtherPlayerTurn().setHealth(Player.getOtherPlayerTurn().getHealth()- mortardamage + modifier());
				econPanel.healthupdate();
				econPanel.moneyupdate();
				if(Player.getOtherPlayerTurn().getHealth() <= 0) {
					infoBox("GAME OVER", "Player " + Player.getPlayerTurnO() + " wins!");
				}
			} else { infoBox("Cannon Fire", "Not enough money"); 
			
			}
			}
		});
		
		
		GridBagConstraints gbc_btnAttack_5 = new GridBagConstraints();
		gbc_btnAttack_5.insets = new Insets(0, 0, 5, 5);
		gbc_btnAttack_5.gridx = 3;
		gbc_btnAttack_5.gridy = 9;
		add(airstrikeButton, gbc_btnAttack_5);
		
		airstrikeButton.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent arg0) {
				if(Player.getBackpack().getGold() > airstrikecost) {
				Player.getBackpack().setGold(Player.getBackpack().getGold() - airstrikecost);
				Player.getOtherPlayerTurn().setHealth(Player.getOtherPlayerTurn().getHealth()- airstrikedamage + modifier());
				econPanel.healthupdate();
				econPanel.moneyupdate();
				if(Player.getOtherPlayerTurn().getHealth() <= 0) {
					infoBox("GAME OVER", "Player " + Player.getPlayerTurnO() + " wins!");
				}
			} else { infoBox("Cannon Fire", "Not enough money"); 
			
			}
			}
		});
		
		JLabel label_1 = new JLabel("$" + mortarcost);
		GridBagConstraints gbc_label_1 = new GridBagConstraints();
		gbc_label_1.insets = new Insets(0, 0, 5, 5);
		gbc_label_1.gridx = 1;
		gbc_label_1.gridy = 10;
		add(label_1, gbc_label_1);
		
		JLabel label_5 = new JLabel("$" + airstrikecost);
		GridBagConstraints gbc_label_5 = new GridBagConstraints();
		gbc_label_5.insets = new Insets(0, 0, 5, 5);
		gbc_label_5.gridx = 3;
		gbc_label_5.gridy = 10;
		add(label_5, gbc_label_5);
		
		JLabel lblRocket = new JLabel("Energy Bomb " + energybombdamage);
		GridBagConstraints gbc_lblRocket = new GridBagConstraints();
		gbc_lblRocket.insets = new Insets(0, 0, 5, 5);
		gbc_lblRocket.gridx = 1;
		gbc_lblRocket.gridy = 12;
		add(lblRocket, gbc_lblRocket);
		
		JLabel lblNewLabel = new JLabel("Nuke " + nukedamage);
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 3;
		gbc_lblNewLabel.gridy = 12;
		add(lblNewLabel, gbc_lblNewLabel);
		
		
		GridBagConstraints gbc_btnAttack_3 = new GridBagConstraints();
		gbc_btnAttack_3.insets = new Insets(0, 0, 5, 5);
		gbc_btnAttack_3.gridx = 1;
		gbc_btnAttack_3.gridy = 13;
		add(enerygyBombButton, gbc_btnAttack_3);
		
		enerygyBombButton.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent arg0) {
				if(Player.getBackpack().getGold() > energybombcost) {
				Player.getBackpack().setGold(Player.getBackpack().getGold() - energybombcost);
				Player.getOtherPlayerTurn().setHealth(Player.getOtherPlayerTurn().getHealth()- energybombdamage + modifier());
				econPanel.healthupdate();
				econPanel.moneyupdate();
				if(Player.getOtherPlayerTurn().getHealth() < 0) {
					infoBox("GAME OVER", "Player " + Player.getPlayerTurnO() + " wins!");
				}
			} else { infoBox("Cannon Fire", "Not enough money"); 
			
			}
			}
		});
		
		
		GridBagConstraints gbc_btnAttack_6 = new GridBagConstraints();
		gbc_btnAttack_6.insets = new Insets(0, 0, 5, 5);
		gbc_btnAttack_6.gridx = 3;
		gbc_btnAttack_6.gridy = 13;
		add(nukeButton, gbc_btnAttack_6);
		
		nukeButton.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent arg0) {
				if(Player.getBackpack().getGold() > nukecost) {
				Player.getBackpack().setGold(Player.getBackpack().getGold() - nukecost);
				Player.getOtherPlayerTurn().setHealth(Player.getOtherPlayerTurn().getHealth()- nukedamage + modifier());
				econPanel.healthupdate();
				econPanel.moneyupdate();
				if(Player.getOtherPlayerTurn().getHealth() <= 0) {
					infoBox("GAME OVER", "Player " + Player.getPlayerTurnO() + " wins!");
				}
			} else { infoBox("Cannon Fire", "Not enough money"); 
			
			}
			}
		});
		
		JLabel label_2 = new JLabel("$" + energybombcost);
		GridBagConstraints gbc_label_2 = new GridBagConstraints();
		gbc_label_2.insets = new Insets(0, 0, 5, 5);
		gbc_label_2.gridx = 1;
		gbc_label_2.gridy = 14;
		add(label_2, gbc_label_2);
		
		JLabel label_6 = new JLabel("$ " + nukecost);
		GridBagConstraints gbc_label_6 = new GridBagConstraints();
		gbc_label_6.insets = new Insets(0, 0, 5, 5);
		gbc_label_6.gridx = 3;
		gbc_label_6.gridy = 14;
		add(label_6, gbc_label_6);
		
		
		GridBagConstraints gbc_btnHeal = new GridBagConstraints();
		gbc_btnHeal.insets = new Insets(0, 0, 5, 5);
		gbc_btnHeal.gridx = 3;
		gbc_btnHeal.gridy = 16;
		add(btnHeal, gbc_btnHeal);
		btnHeal.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent arg0) {
				if(Player.getBackpack().getGold() > healcost) {
				Player.getBackpack().setGold(Player.getBackpack().getGold() - healcost);
				Player.getPlayerTurn().setHealth(Player.getPlayerTurn().getHealth() + healamount + modifier() + Resource.i * 10);
				econPanel.healthupdate();
				econPanel.moneyupdate();
				if(Player.getOtherPlayerTurn().getHealth() < 0) {
					infoBox("GAME OVER", "Player " + Player.getPlayerTurnO() + " wins!");
				}
			} else { infoBox("Cannot Heal", "Not enough money"); 
			
			}
			}
		});
		JLabel lblheal = new JLabel("$" + healcost);
		GridBagConstraints gbc_lblheal = new GridBagConstraints();
		gbc_lblheal.insets = new Insets(0, 0, 0, 5);
		gbc_lblheal.gridx = 3;
		gbc_lblheal.gridy = 17;
		add(lblheal, gbc_lblheal);
		
		
		

	}
	
	public static int modifier(){
		return attackMod;
	}
	
	public static void infoBox(String infoMessage, String titleBar)
    {
        JOptionPane.showMessageDialog(null, infoMessage, "InfoBox: " + titleBar, JOptionPane.INFORMATION_MESSAGE);
    }
}
