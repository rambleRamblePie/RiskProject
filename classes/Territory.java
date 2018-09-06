import java.util.*;

class Territory {
	
	private String name;
	private mapDataTypePlaceholder<Territory> adjacentTerritories;
	// private int ID;
	private int continent;
	
	private User occupyingUser;
	private int armyPower;
	
	
	Territory(Continent c, String n, int line) {
		continent = c;
		name = n;
		
		// read in adjacentTerritories from the specified line in the adjacentTerritories data file
		
		occupyingUser = null;
		armyPower = 0;
	}
	
	
	public int getID () { return ID; }
	
	public ArrayList<Territory> getAdjacentTerritories() {
		throw new java.lang.UnsupportedOperationException();
		return null;
	}
	
	public void setOccupyingUser(User user) {
		occupyingUser = user;
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