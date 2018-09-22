import java.util.*;

class Territory {
	
	private String name;
	private ArrayList<String> adjacentTerritories;
	// private int ID;
	private Continent continent;
	
	private User occupyingUser;
	private int armyPower;
	
	
	Territory(String n) {
		this.name = n;
		occupyingUser = null;
		armyPower = 0;
	}

	public void addAdjacencies(ArrayList<String> adjacencies) {

		this.adjacentTerritories = adjacencies;
	}
	
	// public int getID () { return ID; }
	
	public ArrayList<String> getAdjacentTerritories() {
		return adjacentTerritories;
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
	
	
	//added for Card class
	public String getTerritory(){
		return name;
	}
	
	public Continent getContinent() {
		return continent;
	}
	
	public String getName() {
		return name;
	}
}
