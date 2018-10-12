import java.util.*;

/**
 * The Territory class contains information about the Territories used
 * in the game including the army power, the User who has control of
 * it and the adjacent territories. You can easily access the User's name,
 * the Territories army count, and modify the army power with the provided
 * functions
 * @author Aaron Mitchell
 * @author Alex Milligan
 * @author Luis Florez
 * @version 0.4
 */

public class Territory {

	private String name;
	private ArrayList<Territory> adjacentTerritories;
	private Continent continent;
	private User userControlling;
	private int armyPower;


	Territory(String name) {
		this.name = name;
		armyPower = 0;
	}

	/**
	 * Adds adjacencies to the spawned territory
	 * @see Territory
	 */
	public void addAdjacencies(ArrayList<Territory> adjacencies) {

		this.adjacentTerritories = adjacencies;
	}

	/**
	 * Grabs the adjacent territories
	 * @see Territory
	 */
	public ArrayList<Territory> getAdjacentTerritories() {
		return adjacentTerritories;
	}

	/**
	 * Sets the controlling User of the Territory
	 * @param user The User who will be set as the controller of the territory
	 * @see Territory
	 */
	public void setOccupyingUser(User user) {
		this.userControlling = user;
	}
	
	// Need removeOccupyingUser?
	// No. We can just recall setOccupyingUser() to set a new user without deleting original user

	/**
	 * Sets the number of armies for the Territory
	 * @param armies The number of armies the Territory should have
	 * @see Territory
	 */
	public void setNumArmies(int armies){
		armyPower = armies;
	}

	/**
	 * Returns the User object who is controlling the territory
	 * @see Territory
	 */
	public User getUser() {
		return userControlling;
	}

	/**
	 * Sets the number of armies for the Territory
	 * @param n The number of armies the Territory should have
	 * @see Territory
	 */
	public void setArmyPower(int n) {
		armyPower = n;
	}

	/**
	 * Returns the currenty army power of the Territory
	 * @return The current army power of the Territory
	 * @see Territory
	 */
	public int getArmyPower() {
		return armyPower;
	}

	/**
	 * Increments the army power. Added to simplify the undo feature
	 * @param addedArmies The number of armies to add to the territory
	 * @see Territory
	 */
	public void incrementArmies(int addedArmies) {
		armyPower = armyPower + addedArmies;
	}

	/**
	 * Decrements the army power. Added to simplify the undo feature
	 * @param lostArmies The number of armies the Territory will lose
	 * @see Territory
	 */
	public void decrementArmies(int lostArmies) {

		if(lostArmies > armyPower){
			armyPower = 0;
		}

		else {
			armyPower = armyPower - lostArmies;
		}
	}

	/**
	 * Grabs the Territory's name
	 * @return The name of the Territory
	 * @see Territory
	 */
	public String getTerritory(){
		return name;
	}

	/**
	 * Grabs the continent the territory belongs to
	 * @return The continent the territory belongs to
	 * @see Territory
	 */
	public Continent getContinent() {
		return continent;
	}

	/**
	 * Grabs the name of the Territory
	 * @return The name of the Territory
	 * @see Territory
	 */
	public String getName() {
		return name;
	}
}
