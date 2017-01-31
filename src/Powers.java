import javax.swing.JOptionPane;

public class Powers {
	String choice;
	public void LuxuryRush() {
		
		choice = JOptionPane.showInputDialog("Which Resource will the people demand? Enter 'spice', 'jewels' or 'leather'.");
		
		if(choice == "spice") {
		Resource.spiceMod = 50;
		}
		if(choice == "leather") {
			Resource.leatherMod = 50;
		}
		if(choice == "jewels") {
			Resource.jewelMod = 50;
		}
		
	}
     public void LuxuryRushEnd() {
		
		
		if(choice == "spice") {
		Resource.spiceMod = 0;
		}
		if(choice == "leather") {
			Resource.leatherMod = 0;
		}
		if(choice == "jewels") {
			Resource.jewelMod = 0;
		}
		
	}

}
