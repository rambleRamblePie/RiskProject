import java.util.*;

/**
 * The Continent class is used to spawn the continents with parameters such as
 * their bonus army amount, their name, and a list of territories that each continent
 * holds. These continent objects can then be queried and modified and used to
 * calculate bonus army amounts at the beginning of the turn, and added to User's
 * HashMaps when that User has control of all the territories that make up the
 * continent
 * @author Aaron Mitchell
 * @author Alex Milligan
 * @author Luis Florez
 * @version 0.4
 */

public class Continent {

	private String name;
	private ArrayList<Territory> territories;
	private int bonusArmy;


	Continent(String name, int bonusAmount, ArrayList<Territory> territoriesOfContinent) {
		this.name = name;
		this.bonusArmy = bonusAmount;
		territories = territoriesOfContinent;

		// Printing for testing purposes right now
		System.out.println("Continent " + name + " has been created");
	}

	/**
	 * Returns the continent name
	 * @return Continent specified by continentName
	 * @see Continent
	 */
	public String getName() {
		return name;
	}

	/**
	 * Returns the bonus army amount of the continent
	 * @return Bonus army amount
	 * @see Continent
	 */
	public int getBonusArmyAmount() {
		return bonusArmy;
	}

	/**
	 * Returns a list of the territories that the continent
	 * @return ArrayList of Territories that the continent contains
	 * @see Continent
	 */
	public ArrayList<Territory> getTerritoriesOfContinent()
	{
		return territories;
	}

}
