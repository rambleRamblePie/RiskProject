import java.util.Arrays;
import java.util.Scanner;
import java.util.HashMap;
import java.util.ArrayList;

class User {
	private String username;
	private int turnPosition;
	private int score;
	private int armyPower;
	private HashMap<String,Territory> territoriesHeld;
	private HashMap<String,Continent> continentsHeld;
	/*
	public enum Actions {
		MOVE, ATTACK, PLACE_ARMY
	}
	
	public void Action(Actions a) {
		Scanner sc = new Scanner(System.in);
		switch (a){
			case MOVE:
				System.out.println("Which territory would you like to move from?");
				//This should actually point to the territory object that matches the input string
				String moveFrom = sc.nextLine();
				//Check if territory belongs to user. else...
				System.out.println("Which territory would you like to move to?");
				//Check if territory belongs to user, else...
				String moveTo = sc.nextLine();
				System.out.println("How many armies?");
				//Check actual amount of armies on both territories before changing.
				int amt = sc.nextInt();
				sc.nextLine();

				System.out.println(username + " is Moving __ units from __ to __");

				//from.armyPower - amt
				//to.armyPower
				break;
			case ATTACK:
				System.out.println("Which territory are you attacking from?");
				String attackFrom = sc.nextLine();
				System.out.println("Which territory are you attacking?");
				String attackTo = sc.nextLine();
				System.out.println("How many units are you attacking with?");
				int attackingArmy = sc.nextInt();
				sc.nextLine();
				//remove attackingArmy from the total territory armies at the start of the battle, then add it back if there are any left afterwards.

				String attackedUsername="";
				int attackedTerritoryArmyAmount=0;

				System.out.println(attackedUsername + " how many units would you like to defend with? You have " + attackedTerritoryArmyAmount);
				int defendingArmy = sc.nextInt();

				System.out.println(username + " is Attacking __ from __ with __ units\n" + attackedUsername + " is defending with " + defendingArmy);
				int[] p1DiceRolls = new int[attackingArmy];
				int[] p2DiceRolls = new int[defendingArmy];
				// two sets of dice rolls depending on previous vars
				Dice d = new Dice();
				for(int i=0; i<attackingArmy; i++){
					d.roll();
					p1DiceRolls[i] = d.getFaceValue();
				}
				for(int i = 0; i< defendingArmy; i++){
					d.roll();
					p2DiceRolls[i] = d.getFaceValue();
				}

				Arrays.sort(p1DiceRolls);
				Arrays.sort(p2DiceRolls);
				if(attackingArmy>defendingArmy || attackingArmy == defendingArmy){
					for(int i=defendingArmy; i>=0; i--){
						if(p1DiceRolls[i] > p2DiceRolls[i])
							defendingArmy--;
						else
							attackingArmy--;
					}
				}
				else{

				}
				//add back attackingArmy and defendingArmy to the territories, then change territory ownership accordingly
				break;
			case PLACE_ARMY:
				System.out.println(username + " is placing an army at__");
				//this is a comment
				break;


		}
	} // Move, Battle, Place Army
	*/
	public User(String name, int startingArmy) {
		this.username = name;
		this.armyPower = startingArmy;
		turnPosition = 0;
		score = 0;

		territoriesHeld = new HashMap<String,Territory>();
		continentsHeld = new HashMap<String,Continent>();
	}
	
	public void setTurnPosition(int position) {
		turnPosition = position;
	}
	public int getTurnPosition() {
		return turnPosition;
	}
	
	public int addArmyPower(int p) {
		if (p < 0)
			throw new java.lang.IllegalArgumentException();
		
		armyPower = armyPower + p;
		return armyPower;
	}

	public int removeArmyPower(int p) {
		if (p < 0)
			throw new java.lang.IllegalArgumentException();
		
		if (p > armyPower)
			armyPower = 0;

		else
			armyPower = armyPower - p;

		return armyPower;
	}

	public String getUsername() {
		return username;
	}

	public void addTerritory(Territory territory) {

		System.out.println(username + " now occupies " + territory.getName() + "!");
		territoriesHeld.put(territory.getName(), territory);
	}

	public void deleteTerritory(String territoryName)
	{
		System.out.println(username + " has lost control of " + territoryName);
		territoriesHeld.remove(territoryName);
	}

	/*
	May need to adjust HashMap for this function

	public ArrayList<String> getUserCountries()
	{
		return ArrayList<String>(territoriesHeld) // Trying to get keys, may need to change to objects
	}

	*/

	public void addContinent(Continent continent)
	{
		System.out.println(username + " is dominating the continent of " + continent);
		continentsHeld.put(continent.getName(), continent);
	}

	public void deleteContinent(String continentName)
	{
		System.out.println(username + " is no longer dominating the continent of " + continentName);
		continentsHeld.remove(continentName);
	}
}
