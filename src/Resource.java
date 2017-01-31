import java.util.Random;

public enum Resource {
		
		
		
		FOOD(50),
		WOOD(50),
		JEWELS(3),
		SPICE(3),
		LEATHER(3);
	
	private int price;
	public static int i = 0;
	public static int foodMod;
	public static int woodMod;
	public static int jewelMod;
	public static int leatherMod;
	public static int spiceMod;
	
	private Resource(int price){
		this.price = price;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}
	
	
	
	public static void endturn(){
		Random rnd = new Random();
		FOOD.setPrice(FOOD.getPrice() + 1 + i * rnd.nextInt(1) + foodMod);
		WOOD.setPrice(WOOD.getPrice() + 1 * rnd.nextInt(1) + i *rnd.nextInt(1) + woodMod);
		JEWELS.setPrice(JEWELS.getPrice() + 5 + 2*i * rnd.nextInt(4) - i * rnd.nextInt(4) + jewelMod);
		SPICE.setPrice(SPICE.getPrice() + 5 + 2*i * rnd.nextInt(4) - i * rnd.nextInt(4) + spiceMod);
		LEATHER.setPrice(LEATHER.getPrice() + 5 + 2*i * rnd.nextInt(4) - i * rnd.nextInt(4) + leatherMod);
		i++;
	}
	
	}


	

