import java.util.ArrayList;

public class Backpack
{
  private int food, wood, gems, spices, leather, gold;
  
  public Backpack(int golds, int foods, int woods, int gem, int spice, int leathers, ArrayList<Powers> pow)
  {
    setFood(foods);
    setWood(woods);
    setGems(gem);
    setSpices(spice);
    setLeather(leathers);
    setGold(golds);
    
  }
public int getFood() {
	return food;
}
public void setFood(int food) {
	this.food = food;
}
public int getWood() {
	return wood;
}
public void setWood(int wood) {
	this.wood = wood;
}
public int getGems() {
	return gems;
}
public void setGems(int gem) {
	this.gems = gem;
}
public int getSpices() {
	return spices;
}
public void setSpices(int spice) {
	this.spices = spice;
}
public int getLeather() {
	return leather;
}
public void setLeather(int leather) {
	this.leather = leather;
}
public int getGold() {
	return gold;
}
public void setGold(int gold) {
	this.gold = gold;
}
  
  
  
}
