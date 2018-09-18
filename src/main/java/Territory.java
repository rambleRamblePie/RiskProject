import java.util.*;

class Territory {
	
	private String name;
	private ArrayList<Territory> adjacentTerritories;
	// private int ID;
	private Continent continent;
	
	private User occupyingUser;
	private int armyPower;
	
	
	Territory(Continent c, String n, int line) {
		continent = c;
		name = n;
		
		// read in adjacentTerritories from the specified line in the adjacentTerritories data file
		
		occupyingUser = null;
		armyPower = 0;
	}
	
	
	// public int getID () { return ID; }
	
	public ArrayList<Territory> getAdjacentTerritories() {
		throw new java.lang.UnsupportedOperationException();
	}
	
	public void setOccupyingUser(User user, int power) {
		occupyingUser = user;
		armyPower = power;
	}
	public User getOccupyingUser() {
		return occupyingUser;
	}
	
	public void setArmyPower(int n) {
		armyPower = n;
	}
	public int getArmyPower() {
		return armyPower;
	}
	
	public Continent getContinent() {
		return continent;
	}
}