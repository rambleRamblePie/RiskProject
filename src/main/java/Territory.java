import java.util.*;

public class Territory {

	private String name;
	private ArrayList<Territory> adjacentTerritories;
	private Continent continent;
<<<<<<< HEAD
	
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
=======
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
>>>>>>> master
	}

	public void setOccupyingUser(User user) {
<<<<<<< HEAD
		this.occupant = user;
	public void setNumArmies(int armies){
		armyPower = armies;
	}
	public User getOccupyingUser() {
		return occupyingUser;
=======
		this.userControlling = user;
	}
	
	// Need removeOccupyingUser?
	// No. We can just recall setOccupyingUser() to set a new user without deleting original user

	public void setNumArmies(int armies){
		armyPower = armies;
	}

	public User getUser() {
		return userControlling;
>>>>>>> master
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
