import java.util.ArrayList;

import javax.swing.JOptionPane;

public class Player
{
  private int number, money, health;
  private String name;
  private boolean turn;
  private Backpack backpack;
  
  
  static ArrayList<Powers> m1 = new ArrayList<Powers>();
  static ArrayList<Powers> m2 = new ArrayList<Powers>();
  static Backpack b1 = new Backpack(70, 0, 0, 0, 0, 0, m1);
  static Backpack b2 = new Backpack(70, 0, 0, 0, 0, 0, m2);
  
  static Player p1 = new Player(1, "player1", 600, b1, true);
  static Player p2 = new Player(1, "player2", 600, b2, false);
  
  public Player(int numberv, String namev, int healthv, Backpack backpack, boolean turn)
  {
    setNumber(numberv);
    setName(namev);
    setHealth(healthv);
    setTurn(turn);
  }
  
  
  
public int getNumber() {
	return number;
}
public void setNumber(int number) {
	this.number = number;
}
public int getMoney() {
	return money;
}
public void setMoney(int money) {
	this.money = money;
}
public int getHealth() {
	return health;
}
public void setHealth(int health) {
	this.health = health;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}



public boolean isTurn() {
	return turn;
}

public void setTurn(boolean turn) {
	this.turn = turn;
}

public static Ownership getPlayerTurnO() {
	if (p1.isTurn() == true) {
		return Ownership.ONE;
		}
	if (p2.isTurn() == true) {
		return Ownership.TWO;
		}
	else return Ownership.NONE;
}

public static Player getPlayerTurn() {
	if (p1.isTurn() == true) {
		return p1;
		}
	if (p2.isTurn() == true) {
		return p2;
		}
	else return null;
}

public static Player getOtherPlayerTurn() {
	if (p1.isTurn() == true) {
		return p2;
		}
	if (p2.isTurn() == true) {
		return p1;
		}
	else return null;
}



public static Backpack getBackpack() {
	
	if(getPlayerTurnO() == Ownership.ONE ){ 
		return b1;
	}
	if(getPlayerTurnO() == Ownership.TWO ) {
		return b2;
	}
	else return null;
}



public static void endturn(){
	getPlayerTurn(); //QUESTION
	
	ArrayList<Tile> tiles = new ArrayList<Tile>();
	
	if(getPlayerTurn() == p1){
		
	tiles = board.getp1Tiles();
	}
	if(getPlayerTurn() == p2){
		
	tiles = board.getp2Tiles();
	}
	
	
		for(Tile t : tiles) {
			if(t.getResources() == Resource.FOOD){
				
				Player.getBackpack().setFood(Player.getBackpack().getFood() + 1);
			}
			if(t.getResources() == Resource.WOOD){
				Player.getBackpack().setWood(Player.getBackpack().getWood() + 1);
			}
			if(t.getResources() == Resource.JEWELS){
				Player.getBackpack().setGems(Player.getBackpack().getGems() + 1);
			}
			if(t.getResources() == Resource.SPICE){
				Player.getBackpack().setSpices(Player.getBackpack().getSpices() + 1);
			}
			if(t.getResources() == Resource.LEATHER){
				Player.getBackpack().setLeather(Player.getBackpack().getLeather() + 1);
			}
		}
	}
	
	
public static void infoBox(String infoMessage, String titleBar)
{
    JOptionPane.showMessageDialog(null, infoMessage, "InfoBox: " + titleBar, JOptionPane.INFORMATION_MESSAGE);
}	



public void setBackpack(Backpack backpack) {
	this.backpack = backpack;
}
}
