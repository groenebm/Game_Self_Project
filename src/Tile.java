import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.Icon;





public class Tile {
	Color clicked2 = new Color(50, 204, 50, 90);
	Color redteam = new Color(200, 20, 20, 90);
	Color blueteam = new Color(50, 50, 204, 90);
	private int x,y, width,height, value;
	private int price;
	private Ownership team;
	private Resource resources;

	private boolean clicked;
	
	public Tile(int xpos, int ypos, int sizex, int sizey, boolean isClicked, Resource goods, Ownership side, int cost){
	setX(xpos);
	setY(ypos);
	setWidth(sizex);
	setHeight(sizey);
	setClicked(isClicked);
	setResources(goods);
	setTeam(side);
	setPrice(cost);
	}
	
	ArrayList<Tile> p1Tiles = new ArrayList<Tile>();
	ArrayList<Tile> p2Tiles = new ArrayList<Tile>();
	
	
	
	
	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public boolean isClicked() {
		return clicked;
	}

	public void setClicked(boolean clicked) {
		this.clicked = clicked;
	}
	
	public void paint(Graphics g) {
		
		
		
		
        g.setColor(Color.BLACK);
        g.drawRect(getX(), getY(),77,77);
        g.setColor(clicked2);
        
          if(getTeam() == Ownership.ONE) {
        	g.setColor(blueteam);
        	g.fillRect(getX(), getY(),77,77);
        }
        if(getTeam() == Ownership.TWO) {
        	g.setColor(redteam);
        	g.fillRect(getX(), getY(),77,77);
        }
        if(isClicked() == true) {
        	g.setColor(clicked2);
        	g.fillRect(getX(), getY(),77,77);
        }
      
        
        
	}
	
	public Ownership getTeam() {
		return team;
	}


	public void setTeam(Ownership team) {
		this.team = team;
	}


	public Resource getResources() {
		return resources;
	}


	public void setResources(Resource resources) {
		this.resources = resources;
	}



	public int getPrice() {
		return price;
	}


	public void setPrice(int price) {
		this.price = price;
	}



	
	
	
	
	
	
}
