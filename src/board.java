
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.List;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

import java.util.Random;

import javax.imageio.ImageIO;
import javax.sound.sampled.*;
import javax.swing.JOptionPane;
import javax.swing.*;
import javax.swing.JPanel;
import javax.swing.event.MouseInputListener;




public class board extends JPanel implements MouseInputListener {
	static ArrayList<Tile> p1Tiles = new ArrayList<Tile>();
	static ArrayList<Tile> p2Tiles = new ArrayList<Tile>();
	static ArrayList<Tile> tiles = new ArrayList<Tile>();
	Dimension d = new Dimension(943,943);
	static Random rnd = new Random();
	public static int i = 0;
	
	
	

	
	public board() {

		setPreferredSize(d);
		setOpaque(false);
		setFocusable(true);
		addMouseListener(this);

		tiles.add(new Tile(0*77,  0*77 + 1, 77, 77, false, Resource.FOOD, Ownership.NONE, 50 + priceAdjust()));
		tiles.add(new Tile(1*77,  0*77 + 1, 77, 77, false, Resource.WOOD, Ownership.NONE, 50 + priceAdjust()));
		tiles.add(new Tile(2*77,  0*77 + 1, 77, 77, false, Resource.WOOD, Ownership.NONE, 50 + priceAdjust()));
		tiles.add(new Tile(3*77,  0*77 + 1, 77, 77, false, Resource.WOOD, Ownership.NONE, 50 + priceAdjust()));
		tiles.add(new Tile(4*77,  0*77 + 1, 77, 77, false, Resource.WOOD, Ownership.NONE, 100 + priceAdjust()));
		tiles.add(new Tile(5*77,  0*77 + 1, 77, 77, false, Resource.WOOD, Ownership.TWO,  50 + priceAdjust()));
		tiles.add(new Tile(6*77,  0*77 + 1, 77, 77, false, Resource.FOOD, Ownership.TWO,  50 + priceAdjust()));
		tiles.add(new Tile(7*77,  0*77 + 1, 77, 77, false, Resource.FOOD, Ownership.NONE, 50 + priceAdjust()));
		tiles.add(new Tile(8*77,  0*77 + 1, 77, 77, false, Resource.FOOD, Ownership.NONE, 50 + priceAdjust()));
		tiles.add(new Tile(9*77,  0*77 + 1, 77, 77, false, Resource.FOOD, Ownership.NONE, 50 + priceAdjust()));
		tiles.add(new Tile(10*77, 0*77 + 1, 77, 77, false, Resource.FOOD, Ownership.NONE, 50 + priceAdjust()));
		tiles.add(new Tile(11*77, 0*77 + 1, 77, 77, false, Resource.FOOD, Ownership.NONE, 50 + priceAdjust()));


		tiles.add(new Tile(0*77,  1*77 + 1, 77, 77, false, Resource.WOOD, Ownership.NONE, 130 + priceAdjust()));
		tiles.add(new Tile(1*77,  1*77 + 1, 77, 77, false, Resource.WOOD, Ownership.NONE, 130 + priceAdjust()));
		tiles.add(new Tile(2*77,  1*77 + 1, 77, 77, false, Resource.WOOD, Ownership.NONE, 130 + priceAdjust()));
		tiles.add(new Tile(3*77,  1*77 + 1, 77, 77, false, Resource.WOOD, Ownership.NONE, 130 + priceAdjust()));
		tiles.add(new Tile(4*77,  1*77 + 1, 77, 77, false, Resource.FOOD, Ownership.NONE, 130 + priceAdjust()));
		tiles.add(new Tile(5*77,  1*77 + 1, 77, 77, false, Resource.FOOD, Ownership.NONE, 130 + priceAdjust()));
		tiles.add(new Tile(6*77,  1*77 + 1, 77, 77, false, Resource.FOOD, Ownership.NONE, 130 + priceAdjust()));
		tiles.add(new Tile(7*77,  1*77 + 1, 77, 77, false, Resource.FOOD, Ownership.NONE, 130 + priceAdjust()));
		tiles.add(new Tile(8*77,  1*77 + 1, 77, 77, false, Resource.FOOD, Ownership.NONE, 5000 + priceAdjust()));
		tiles.add(new Tile(9*77,  1*77 + 1, 77, 77, false, Resource.FOOD, Ownership.NONE, 130 + priceAdjust()));
		tiles.add(new Tile(10*77, 1*77 + 1, 77, 77, false, Resource.WOOD, Ownership.NONE, 130 + priceAdjust()));
		tiles.add(new Tile(11*77, 1*77 + 1, 77, 77, false, Resource.WOOD, Ownership.NONE, 130 + priceAdjust()));

		tiles.add(new Tile(0*77,  2*77 + 1, 77, 77, false, Resource.FOOD, Ownership.NONE, 150 + priceAdjust()));
		tiles.add(new Tile(1*77,  2*77 + 1, 77, 77, false, Resource.FOOD, Ownership.NONE, 150 + priceAdjust()));
		tiles.add(new Tile(2*77,  2*77 + 1, 77, 77, false, Resource.WOOD, Ownership.NONE, 150 + priceAdjust()));
		tiles.add(new Tile(3*77,  2*77 + 1, 77, 77, false, Resource.JEWELS, Ownership.NONE, 260 + priceAdjust()));
		tiles.add(new Tile(4*77,  2*77 + 1, 77, 77, false, Resource.FOOD, Ownership.NONE, 150 + priceAdjust()));
		tiles.add(new Tile(5*77,  2*77 + 1, 77, 77, false, Resource.FOOD, Ownership.NONE, 150 + priceAdjust()));
		tiles.add(new Tile(6*77,  2*77 + 1, 77, 77, false, Resource.SPICE, Ownership.NONE, 290 + priceAdjust()));
		tiles.add(new Tile(7*77,  2*77 + 1, 77, 77, false, Resource.FOOD, Ownership.NONE, 150 + priceAdjust()));
		tiles.add(new Tile(8*77,  2*77 + 1, 77, 77, false, Resource.WOOD, Ownership.NONE, 150 + priceAdjust()));
		tiles.add(new Tile(9*77,  2*77 + 1, 77, 77, false, Resource.FOOD, Ownership.NONE, 150 + priceAdjust()));
		tiles.add(new Tile(10*77, 2*77 + 1, 77, 77, false, Resource.LEATHER, Ownership.NONE, 150 + priceAdjust()));
		tiles.add(new Tile(11*77, 2*77 + 1, 77, 77, false, Resource.WOOD, Ownership.NONE, 150 + priceAdjust()));

		tiles.add(new Tile(0*77,  3*77 + 1, 77, 77, false, Resource.FOOD, Ownership.NONE, 210   + priceAdjust()));
		tiles.add(new Tile(1*77,  3*77 + 1, 77, 77, false, Resource.FOOD, Ownership.NONE, 210   + priceAdjust()));
		tiles.add(new Tile(2*77,  3*77 + 1, 77, 77, false, Resource.FOOD,   Ownership.NONE, 210 + priceAdjust()));
		tiles.add(new Tile(3*77,  3*77 + 1, 77, 77, false, Resource.FOOD,   Ownership.NONE, 210 + priceAdjust()));
		tiles.add(new Tile(4*77,  3*77 + 1, 77, 77, false, Resource.LEATHER, Ownership.NONE, 300+ priceAdjust()));
		tiles.add(new Tile(5*77,  3*77 + 1, 77, 77, false, Resource.FOOD, Ownership.NONE, 210   + priceAdjust()));
		tiles.add(new Tile(6*77,  3*77 + 1, 77, 77, false, Resource.FOOD, Ownership.NONE, 210   + priceAdjust()));
		tiles.add(new Tile(7*77,  3*77 + 1, 77, 77, false, Resource.WOOD, Ownership.NONE, 210   + priceAdjust()));
		tiles.add(new Tile(8*77,  3*77 + 1, 77, 77, false, Resource.WOOD, Ownership.NONE, 210   + priceAdjust()));
		tiles.add(new Tile(9*77,  3*77 + 1, 77, 77, false, Resource.JEWELS, Ownership.NONE, 300 + priceAdjust()));
		tiles.add(new Tile(10*77, 3*77 + 1, 77, 77, false, Resource.FOOD, Ownership.NONE, 210   + priceAdjust()));
		tiles.add(new Tile(11*77, 3*77 + 1, 77, 77, false, Resource.FOOD, Ownership.NONE, 210   + priceAdjust()));

		tiles.add(new Tile(0*77,  4*77 + 1, 77, 77, false, Resource.JEWELS, Ownership.NONE, 300 + priceAdjust()));
		tiles.add(new Tile(1*77,  4*77 + 1, 77, 77, false, Resource.FOOD, Ownership.NONE, 300 + priceAdjust()));
		tiles.add(new Tile(2*77,  4*77 + 1, 77, 77, false, Resource.JEWELS, Ownership.NONE, 400 + priceAdjust()));
		tiles.add(new Tile(3*77,  4*77 + 1, 77, 77, false, Resource.SPICE, Ownership.NONE, 400 + priceAdjust()));
		tiles.add(new Tile(4*77,  4*77 + 1, 77, 77, false, Resource.FOOD, Ownership.NONE, 10 + priceAdjust()));
		tiles.add(new Tile(5*77,  4*77 + 1, 77, 77, false, Resource.LEATHER, Ownership.NONE, 410 + priceAdjust()));
		tiles.add(new Tile(6*77,  4*77 + 1, 77, 77, false, Resource.WOOD, Ownership.NONE, 300 + priceAdjust()));
		tiles.add(new Tile(7*77,  4*77 + 1, 77, 77, false, Resource.FOOD, Ownership.NONE, 300 + priceAdjust()));
		tiles.add(new Tile(8*77,  4*77 + 1, 77, 77, false, Resource.WOOD, Ownership.NONE, 300 + priceAdjust()));
		tiles.add(new Tile(9*77,  4*77 + 1, 77, 77, false, Resource.WOOD, Ownership.NONE, 300 + priceAdjust()));
		tiles.add(new Tile(10*77, 4*77 + 1, 77, 77, false, Resource.FOOD, Ownership.NONE, 300 + priceAdjust()));
		tiles.add(new Tile(11*77, 4*77 + 1, 77, 77, false, Resource.LEATHER, Ownership.NONE, 300 + priceAdjust()));

		tiles.add(new Tile(0*77,  5*77 + 1, 77, 77, false, Resource.FOOD, Ownership.NONE, 410 + priceAdjust()));
		tiles.add(new Tile(1*77,  5*77 + 1, 77, 77, false, Resource.FOOD, Ownership.NONE, 410 + priceAdjust()));
		tiles.add(new Tile(2*77,  5*77 + 1, 77, 77, false, Resource.FOOD, Ownership.NONE, 410 + priceAdjust()));
		tiles.add(new Tile(3*77,  5*77 + 1, 77, 77, false, Resource.FOOD, Ownership.NONE, 410 + priceAdjust()));
		tiles.add(new Tile(4*77,  5*77 + 1, 77, 77, false, Resource.FOOD, Ownership.NONE, 410 + priceAdjust()));
		tiles.add(new Tile(5*77,  5*77 + 1, 77, 77, false, Resource.FOOD, Ownership.NONE, 410 + priceAdjust()));
		tiles.add(new Tile(6*77,  5*77 + 1, 77, 77, false, Resource.SPICE, Ownership.NONE, 560 + priceAdjust()));
		tiles.add(new Tile(7*77,  5*77 + 1, 77, 77, false, Resource.FOOD, Ownership.NONE, 410 + priceAdjust()));
		tiles.add(new Tile(8*77,  5*77 + 1, 77, 77, false, Resource.WOOD, Ownership.NONE, 410 + priceAdjust()));
		tiles.add(new Tile(9*77,  5*77 + 1, 77, 77, false, Resource.WOOD, Ownership.NONE, 410 + priceAdjust()));
		tiles.add(new Tile(10*77, 5*77 + 1, 77, 77, false, Resource.WOOD, Ownership.NONE, 410 + priceAdjust()));
		tiles.add(new Tile(11*77, 5*77 + 1, 77, 77, false, Resource.WOOD, Ownership.NONE, 410 + priceAdjust()));

		tiles.add(new Tile(0*77,  6*77 + 1, 77, 77, false, Resource.FOOD, Ownership.NONE, 410 + priceAdjust()));
		tiles.add(new Tile(1*77,  6*77 + 1, 77, 77, false, Resource.JEWELS, Ownership.NONE, 500 + priceAdjust()));
		tiles.add(new Tile(2*77,  6*77 + 1, 77, 77, false, Resource.FOOD, Ownership.NONE, 410 + priceAdjust()));
		tiles.add(new Tile(3*77,  6*77 + 1, 77, 77, false, Resource.LEATHER, Ownership.NONE, 500 + priceAdjust()));
		tiles.add(new Tile(4*77,  6*77 + 1, 77, 77, false, Resource.FOOD, Ownership.NONE, 410 + priceAdjust()));
		tiles.add(new Tile(5*77,  6*77 + 1, 77, 77, false, Resource.FOOD, Ownership.NONE, 410 + priceAdjust()));
		tiles.add(new Tile(6*77,  6*77 + 1, 77, 77, false, Resource.WOOD, Ownership.NONE, 410 + priceAdjust()));
		tiles.add(new Tile(7*77,  6*77 + 1, 77, 77, false, Resource.WOOD, Ownership.NONE, 410 + priceAdjust()));
		tiles.add(new Tile(8*77,  6*77 + 1, 77, 77, false, Resource.WOOD, Ownership.NONE, 410 + priceAdjust()));
		tiles.add(new Tile(9*77,  6*77 + 1, 77, 77, false, Resource.FOOD, Ownership.NONE, 410 + priceAdjust()));
		tiles.add(new Tile(10*77, 6*77 + 1, 77, 77, false, Resource.FOOD, Ownership.NONE, 410 + priceAdjust()));
		tiles.add(new Tile(11*77, 6*77 + 1, 77, 77, false, Resource.FOOD, Ownership.NONE, 410 + priceAdjust()));


		tiles.add(new Tile(0*77,  7*77 + 1, 77, 77, false, Resource.FOOD, Ownership.NONE, 300 + priceAdjust()));
		tiles.add(new Tile(1*77,  7*77 + 1, 77, 77, false, Resource.FOOD, Ownership.NONE, 300 + priceAdjust()));
		tiles.add(new Tile(2*77,  7*77 + 1, 77, 77, false, Resource.FOOD, Ownership.NONE, 300 + priceAdjust()));
		tiles.add(new Tile(3*77,  7*77 + 1, 77, 77, false, Resource.FOOD, Ownership.NONE, 300 + priceAdjust()));
		tiles.add(new Tile(4*77,  7*77 + 1, 77, 77, false, Resource.SPICE, Ownership.NONE, 500 + priceAdjust()));
		tiles.add(new Tile(5*77,  7*77 + 1, 77, 77, false, Resource.FOOD, Ownership.NONE, 300 + priceAdjust()));
		tiles.add(new Tile(6*77,  7*77 + 1, 77, 77, false, Resource.WOOD, Ownership.NONE, 300 + priceAdjust()));
		tiles.add(new Tile(7*77,  7*77 + 1, 77, 77, false, Resource.WOOD, Ownership.NONE, 300 + priceAdjust()));
		tiles.add(new Tile(8*77,  7*77 + 1, 77, 77, false, Resource.WOOD, Ownership.NONE, 300 + priceAdjust()));
		tiles.add(new Tile(9*77,  7*77 + 1, 77, 77, false, Resource.FOOD, Ownership.NONE, 300 + priceAdjust()));
		tiles.add(new Tile(10*77, 7*77 + 1, 77, 77, false, Resource.FOOD, Ownership.NONE, 300 + priceAdjust()));
		tiles.add(new Tile(11*77, 7*77 + 1, 77, 77, false, Resource.FOOD, Ownership.NONE, 300 + priceAdjust()));

		tiles.add(new Tile(0*77,  8*77 + 1, 77, 77, false, Resource.JEWELS, Ownership.NONE, 300 + priceAdjust()));
		tiles.add(new Tile(1*77,  8*77 + 1, 77, 77, false, Resource.FOOD, Ownership.NONE, 210 + priceAdjust()));
		tiles.add(new Tile(2*77,  8*77 + 1, 77, 77, false, Resource.FOOD, Ownership.NONE, 210 + priceAdjust()));
		tiles.add(new Tile(3*77,  8*77 + 1, 77, 77, false, Resource.FOOD, Ownership.NONE, 210 + priceAdjust()));
		tiles.add(new Tile(4*77,  8*77 + 1, 77, 77, false, Resource.FOOD, Ownership.NONE, 210 + priceAdjust()));
		tiles.add(new Tile(5*77,  8*77 + 1, 77, 77, false, Resource.FOOD, Ownership.NONE, 210 + priceAdjust()));
		tiles.add(new Tile(6*77,  8*77 + 1, 77, 77, false, Resource.SPICE, Ownership.NONE, 300 + priceAdjust()));
		tiles.add(new Tile(7*77,  8*77 + 1, 77, 77, false, Resource.FOOD, Ownership.NONE, 210 + priceAdjust()));
		tiles.add(new Tile(8*77,  8*77 + 1, 77, 77, false, Resource.LEATHER, Ownership.NONE, 300 + priceAdjust()));
		tiles.add(new Tile(9*77,  8*77 + 1, 77, 77, false, Resource.FOOD, Ownership.NONE, 210 + priceAdjust()));
		tiles.add(new Tile(10*77, 8*77 + 1, 77, 77, false, Resource.SPICE, Ownership.NONE, 300 + priceAdjust()));
		tiles.add(new Tile(11*77, 8*77 + 1, 77, 77, false, Resource.WOOD, Ownership.NONE, 210 + priceAdjust()));


		tiles.add(new Tile(0*77,  9*77 + 1, 77, 77, false, Resource.FOOD, Ownership.NONE, 150 + priceAdjust()));
		tiles.add(new Tile(1*77,  9*77 + 1, 77, 77, false, Resource.WOOD, Ownership.NONE, 150 + priceAdjust()));
		tiles.add(new Tile(2*77,  9*77 + 1, 77, 77, false, Resource.JEWELS, Ownership.NONE, 100 + priceAdjust()));
		tiles.add(new Tile(3*77,  9*77 + 1, 77, 77, false, Resource.FOOD, Ownership.NONE, 150 + priceAdjust()));
		tiles.add(new Tile(4*77,  9*77 + 1, 77, 77, false, Resource.SPICE, Ownership.NONE, 100 + priceAdjust()));
		tiles.add(new Tile(5*77,  9*77 + 1, 77, 77, false, Resource.FOOD, Ownership.NONE, 150 + priceAdjust()));
		tiles.add(new Tile(6*77,  9*77 + 1, 77, 77, false, Resource.FOOD, Ownership.NONE, 150 + priceAdjust()));
		tiles.add(new Tile(7*77,  9*77 + 1, 77, 77, false, Resource.FOOD, Ownership.NONE, 150 + priceAdjust()));
		tiles.add(new Tile(8*77,  9*77 + 1, 77, 77, false, Resource.FOOD, Ownership.NONE, 150 + priceAdjust()));
		tiles.add(new Tile(9*77,  9*77 + 1, 77, 77, false, Resource.LEATHER, Ownership.NONE, 150 + priceAdjust()));
		tiles.add(new Tile(10*77, 9*77 + 1, 77, 77, false, Resource.FOOD, Ownership.NONE, 150 + priceAdjust()));
		tiles.add(new Tile(11*77, 9*77 + 1, 77, 77, false, Resource.WOOD, Ownership.NONE, 150 + priceAdjust()));

		tiles.add(new Tile(0*77,  10*77 + 1, 77, 77, false, Resource.FOOD, Ownership.NONE, 130 + priceAdjust()));
		tiles.add(new Tile(1*77,  10*77 + 1, 77, 77, false, Resource.FOOD, Ownership.NONE, 130 + priceAdjust()));
		tiles.add(new Tile(2*77,  10*77 + 1, 77, 77, false, Resource.FOOD, Ownership.NONE, 130 + priceAdjust()));
		tiles.add(new Tile(3*77,  10*77 + 1, 77, 77, false, Resource.FOOD, Ownership.NONE, 130 + priceAdjust()));
		tiles.add(new Tile(4*77,  10*77 + 1, 77, 77, false, Resource.FOOD, Ownership.NONE, 130 + priceAdjust()));
		tiles.add(new Tile(5*77,  10*77 + 1, 77, 77, false, Resource.FOOD, Ownership.NONE, 130 + priceAdjust()));
		tiles.add(new Tile(6*77,  10*77 + 1, 77, 77, false, Resource.FOOD, Ownership.NONE, 130 + priceAdjust()));
		tiles.add(new Tile(7*77,  10*77 + 1, 77, 77, false, Resource.FOOD, Ownership.NONE, 130 + priceAdjust()));
		tiles.add(new Tile(8*77,  10*77 + 1, 77, 77, false, Resource.FOOD, Ownership.NONE, 130 + priceAdjust()));
		tiles.add(new Tile(9*77,  10*77 + 1, 77, 77, false, Resource.FOOD, Ownership.NONE, 130 + priceAdjust()));
		tiles.add(new Tile(10*77, 10*77 + 1, 77, 77, false, Resource.WOOD, Ownership.NONE, 130 + priceAdjust()));
		tiles.add(new Tile(11*77, 10*77 + 1, 77, 77, false, Resource.WOOD, Ownership.NONE, 5000 + priceAdjust()));


		tiles.add(new Tile(0*77,  11*77 + 1, 77, 77, false, Resource.WOOD, Ownership.NONE, 50 + priceAdjust()));
		tiles.add(new Tile(1*77,  11*77 + 1, 77, 77, false, Resource.FOOD, Ownership.NONE, 50 + priceAdjust()));
		tiles.add(new Tile(2*77,  11*77 + 1, 77, 77, false, Resource.FOOD, Ownership.NONE, 50 + priceAdjust()));
		tiles.add(new Tile(3*77,  11*77 + 1, 77, 77, false, Resource.FOOD, Ownership.NONE, 50 + priceAdjust()));
		tiles.add(new Tile(4*77,  11*77 + 1, 77, 77, false, Resource.FOOD, Ownership.NONE, 50 + priceAdjust()));
		tiles.add(new Tile(5*77,  11*77 + 1, 77, 77, false, Resource.FOOD, Ownership.ONE,  50 + priceAdjust()));
		tiles.add(new Tile(6*77,  11*77 + 1, 77, 77, false, Resource.FOOD, Ownership.ONE,  50 + priceAdjust()));
		tiles.add(new Tile(7*77,  11*77 + 1, 77, 77, false, Resource.FOOD, Ownership.NONE, 50 + priceAdjust()));
		tiles.add(new Tile(8*77,  11*77 + 1, 77, 77, false, Resource.FOOD, Ownership.NONE, 50 + priceAdjust()));
		tiles.add(new Tile(9*77,  11*77 + 1, 77, 77, false, Resource.FOOD, Ownership.NONE, 50 + priceAdjust()));
		tiles.add(new Tile(10*77, 11*77 + 1, 77, 77, false, Resource.WOOD, Ownership.NONE, 50 + priceAdjust()));
		tiles.add(new Tile(11*77, 11*77 + 1, 77, 77, false, Resource.WOOD, Ownership.NONE, 50 + priceAdjust()));



	}
	static public Tile getSelected() {
		for (Tile t : tiles) {
			if (t.isClicked() == true) return t;
			else{ System.out.println("nothing clicked");
			return null;}
		}
		return null;
	}



	public static void buyTile() {
		for (Tile t : tiles) {
			Player.getPlayerTurn();

			if (t.isClicked() == true) {
				if (t.getTeam() != Ownership.NONE){ 
					infoBox("already bought", "owned by other player");
					break;
					}
				if (Player.getBackpack().getGold() < t.getPrice()){ 
					infoBox("Not enough money", "Not enough gold");
					break;
				}
//				if (isAdjacent(t) == false){
//					infoBox("Adjacent", "Cannot buy");
//					break;
//				}
			t.setTeam(Player.getPlayerTurnO());
			if(Player.getPlayerTurnO() == Ownership.ONE){
				p1Tiles.add(t);
				Player.b1.setGold(Player.b1.getGold() - t.getPrice());
			}
			if(Player.getPlayerTurnO() == Ownership.TWO){
				p2Tiles.add(t);
				Player.b2.setGold(Player.b2.getGold() - t.getPrice());
			}
			try {
				PlayBuy();
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			System.out.println("Bought Tile");
		}

		

	}
	}

	public static void infoBox(String infoMessage, String titleBar)
	{
		JOptionPane.showMessageDialog(null, infoMessage, "InfoBox: " + titleBar, JOptionPane.INFORMATION_MESSAGE);
	}

	public static ArrayList<Tile> getp1Tiles(){
		return p1Tiles;
	}
	public static ArrayList<Tile> getp2Tiles(){
		return p2Tiles;
	}

	public static int priceAdjust(){
		
	
		
		return 5+15*i;
	}
	
	public static void endturn(){
		
		for(Tile t : tiles){
			t.setPrice(t.getPrice() + 30);
		}
		i++;
	}
	public void mouseClicked(MouseEvent e) {
		for(Tile t : tiles) {
			t.setClicked(false);

		}


		for(Tile t : tiles) {
			if (e.getX() - t.getX() > 0 && e.getX() - t.getX() < 77 && e.getY() - t.getY() > 0 && e.getY() - t.getY() < 77 ) {
				t.setClicked(true);
				//System.out.println("resource=" + t.getResources());
				//System.out.println("Ownership = " + t.getTeam());
				//dataPanel.displayInfo();
				
				try {
					PlayClick();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				dataPanel.lblNewLabel.setText("Price: $"+t.getPrice());
				dataPanel.lblWood.setText("Resource: "+ t.getResources());
			}
			
		}
		
		repaint();
	}




//	public static boolean isAdjacent(Tile q){
//		if(Player.getPlayerTurnO() == Ownership.ONE){
//		for(Tile t : p1Tiles){
//			if(t.getX() - q.getX() < 144)
//			{	
//				return true;	
//			}
//			
//		}
//		}
//		if(Player.getPlayerTurnO() == Ownership.TWO){
//			for(Tile t : p2Tiles){
//				if(t.getX() - q.getX() < 0)
//				{	
//					return true;	
//				}
//				if(t.getY() - q.getY() < 0)
//				{	
//					return true;	
//				}
//				if(q.getX() - t.getX() + 144 < 0)
//				{	
//					return true;	
//				}
//				if(q.getY() - t.getY() + 144 < 0)
//				{	
//					return true;	
//				}
//			}
//			}
//		return false;
//	}


	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);

		for (Tile t : tiles) {

			t.paint(g);


		}

	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseDragged(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseMoved(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}
	
	public static void PlayClick() throws Exception{
		
		Clip clip;
		File sound = new File("boardclick.wav");
		clip = AudioSystem.getClip();
		
		AudioInputStream ais = AudioSystem.getAudioInputStream(sound);
		clip.open(ais);
		clip.start();
		 
		
		
		}
	
public static void PlayBuy() throws Exception{
		
		Clip clip;
		File sound = new File("tilebuy.wav");
		clip = AudioSystem.getClip();
		
		AudioInputStream ais = AudioSystem.getAudioInputStream(sound);
		clip.open(ais);
		clip.start();
		 
		
		
		}

}


