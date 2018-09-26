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

	public enum Actions {
		MOVE, ATTACK, PLACE_ARMY
	}

	private boolean checkInput(String territoryName, Board board) {
		if(board.getCountryByName(territoryName) == null){
			System.out.println("That territory doesn't exist, try again.");
			return false;
		}
		else if(board.getOccupant(territoryName).username != username){
			System.out.println("That territory doesn't belong to you, try again.");
			return false;
		}
		else
			return true;

	}
	
	public void Action(Actions a, Board board) {
		Scanner sc = new Scanner(System.in);
		switch (a){
			case MOVE:
				Territory From;
				Territory To;
				System.out.println( username + " which territory would you like to move from?");
				String moveFrom = sc.nextLine();
				if(checkInput(moveFrom, board)){
					From = board.getCountryByName(moveFrom);
				}
				else{Action(a, board); break;}

				System.out.println("Which territory would you like to move to?");
				String moveTo = sc.nextLine();
				if(checkInput(moveTo, board)){
					if(!board.checkAdjacency(moveFrom, moveTo)) {
						System.out.println("These territories are not adjacent, please try again");
						Action(a, board);
						break;
					}
					else
						To = board.getCountryByName(moveTo);
				}
				else {Action(a, board); break;}

				System.out.println("How many armies?");
				int movingArmy = sc.nextInt();
				sc.nextLine();
				if(From.getArmyPower() > 1 && (From.getArmyPower()-movingArmy>=1)){
					From.setArmyPower(From.getArmyPower() - movingArmy);
					To.setArmyPower(To.getArmyPower() + movingArmy);
					System.out.println(username + " is Moving " + movingArmy + " units from " + From.getName() + " to " + To.getName());
				}
				else{
					System.out.println(moveFrom + " doesn't have enough units to move " + movingArmy + " units to another territory. You must leave at least one behind.");
					Action(a, board);
					break;
				}
				break;

			case ATTACK:
				System.out.println("Which territory are you attacking from?");
				String attackFrom = sc.nextLine();
				if(checkInput(attackFrom, board)){
				    From = board.getCountryByName(attackFrom);
                }
                else {Action(a, board); break;}


				System.out.println("Which territory are you attacking?");
                String attackTo = sc.nextLine();
                if(board.getCountryByName(attackTo) == null){
                    System.out.println("That territory doesn't exist, try again.");
                    Action(a, board); break;
                }
                else if(!board.checkAdjacency(attackFrom, attackTo)) {
                    System.out.println("These territories are not adjacent, please try again");
                    Action(a, board);
                    break;
                }
                else if(board.getOccupant(attackTo).username == username){
                    System.out.println("That territory belongs to you, you can't attack it, try again.");
                    Action(a, board);
                    break;
                }
                else{
                    To = board.getCountryByName(attackTo);
                }


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
					for(int i=defendingArmy-1; i>=0; i--){
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
