import java.util.*;

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

	// Returns a list of the continents countries. May not need this
	public ArrayList<Territory> getTerritoriesOfContinent()
	{
		return territories;
	}

}
