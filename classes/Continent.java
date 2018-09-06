import java.util.*;

class Continent {
	
	private String name;
	// private int ID;
	private ArrayList<Territory> territories;
	private int bonusArmy;
	
	
	Continent(String n, int b = 5) {
		name = n;
		bonusArmy = b;
		// need to add territories, probably from a file
	}
	
	public String getName() {
		return name;
	}
	
	public int getBonusArmyAmount() {
		return bonusArmy;
	}
	
	// should return the index of the user, otherwise returns -1
	private int isOccupiedByOneUser(ArrayList<User> users) {
		throw java.lang.UnsupportedOperationException();
		// add armies to that user
	}
	
}