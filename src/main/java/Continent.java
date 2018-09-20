import java.util.*;

class Continent {
	
	private String name;
	// private int ID;
	private ArrayList<Territory> territories;
	private int bonusArmy;
	
	
	Continent(String n, int b) {
		name = n;
		bonusArmy = b;
		// need to add territories, probably from a file
		// group territories by continent in the file
		
		territories.add(new Territory(this, "Texas", 25)); // sample
	}
	
	public String getName() {
		return name;
	}
	
	// this function might only be useful for the UI
	public int getBonusArmyAmount() {
		return bonusArmy;
	}
	
	// returns true if a user received bonus armies, otherwise false
	private boolean calculateBonusArmy() {
		throw new java.lang.UnsupportedOperationException();
		// if a user owns all territories of this continent,
		// add armies to that user (we should be able to do so directly,
		// as the user info is stored in territories of this continent)
	}
	
}