import java.util.*;

public class Territory {

	private String name;
	private ArrayList<Territory> adjacentTerritories;
	private Continent continent;
	private boolean occupied;
	private User userControlling;
	private int armyPower;


	Territory(String name) {
		this.name = name;
		armyPower = 0;
	}

	// Used when spawning territories
	public void addAdjacencies(ArrayList<Territory> adjacencies) {

		this.adjacentTerritories = adjacencies;
	}

	// Checking if we can attack
	public ArrayList<Territory> getAdjacentTerritories() {
		return adjacentTerritories;
	}

	public void setOccupyingUser(User user) {
		this.userControlling = user;
	}
	
	// Need removeOccupyingUser?
	// No. We can just recall setOccupyingUser() to set a new user without deleting original user

	public void setNumArmies(int armies){
		armyPower = armies;
	}

	public User getUser() {
		return userControlling;
	}

	public void setArmyPower(int n) {
		armyPower = n;
	}

	public int getArmyPower() {
		return armyPower;
	}

	// Adding explicity increment and decrement for undo function
	public void incrementArmies(int addedArmies) {
		armyPower = armyPower + addedArmies;
	}

	public void decrementArmies(int lostArmies) {

		if(lostArmies > armyPower){
			armyPower = 0;
		}

		else {
			armyPower = armyPower - lostArmies;
		}
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
