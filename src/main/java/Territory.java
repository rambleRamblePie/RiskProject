import java.util.*;

class Territory {
	
	private String name;
	private ArrayList<String> adjacentTerritories;
	private Continent continent;
	private boolean occupied;
	private User occupant;
	private int armyPower;
	private boolean hasUser;
	
	
	Territory(String name) {
		this.name = name;
		hasUser = false;
		armyPower = 0;
	}

	// Used when spawning territories
	public void addAdjacencies(ArrayList<String> adjacencies) {

		this.adjacentTerritories = adjacencies;
	}

	// Checking if we can attack
	public ArrayList<String> getAdjacentTerritories() {
		return adjacentTerritories;
	}
	
	public void setOccupyingUser(User user) {
		this.occupant = user;
		hasUser = true;
	}

	// Need removeOccupyingUser?
    // No. We can just recall setOccupyingUser() to set a new user without deleting original user

	public void setNumArmies(int armies){
		armyPower = armies;
	}

	public User getUser() {
		return occupant;
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
