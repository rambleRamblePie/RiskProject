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
		MOVE, ATTACK, PLACE_ARMY, END_TURN
	}

	private boolean checkOwnership(String territoryName, Board board) {
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
				if(checkOwnership(moveFrom, board)){
					From = board.getCountryByName(moveFrom);
				}
				else{Action(a, board); break;}

				System.out.println("Which territory would you like to move to?");
				String moveTo = sc.nextLine();
				if(checkOwnership(moveTo, board)){
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
				System.out.println(username + " which territory are you attacking from?");
				String attackFrom = sc.nextLine();
				if(checkOwnership(attackFrom, board)){
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


				System.out.println("How many units are you attacking with? You can attack with up to 3.");
				int attackingArmy = sc.nextInt();
				sc.nextLine();
				if(attackingArmy >3){
				    System.out.println("You can only attack with 3 or less units.");
				    Action(a,board);
				    break;
                }
                else {
                    //remove attackingArmy from the total territory armies at the start of the battle, then add it back if there are any left afterwards.
                    From.setArmyPower(From.getArmyPower() - attackingArmy);
                }

				String defenderUsername=To.getUser().username;
				int attackedTerritoryArmyAmount=To.getArmyPower();

				System.out.println(defenderUsername + " how many units would you like to defend with? You have " + attackedTerritoryArmyAmount + ", and you can defend with up to 2 units.");
				int defendingArmy = sc.nextInt();
                if(defendingArmy >2){
                    System.out.println("You can only attack with 3 or less units.");
                    Action(a,board);
                    break;
                }
                To.setArmyPower(To.getArmyPower() - defendingArmy);


				System.out.println(username + " is Attacking " + To.getName() + " from " + From.getName() + " with " + attackingArmy + " units,\n" + defenderUsername + " is defending with " + defendingArmy + ".\n");
				int[] attackerDiceRolls = new int[attackingArmy];
				int[] DefenderDiceRolls = new int[defendingArmy];
				// two sets of dice rolls depending on previous vars
				Dice d = new Dice();
				for(int i=0; i<attackingArmy; i++){
					d.roll();
					attackerDiceRolls[i] = d.getFaceValue();
				}
				for(int i = 0; i< defendingArmy; i++){
					d.roll();
					DefenderDiceRolls[i] = d.getFaceValue();
				}

				Arrays.sort(attackerDiceRolls);
				Arrays.sort(DefenderDiceRolls);
				for(int i = Math.min(defendingArmy, attackingArmy); i > 0; i--){
					if(attackerDiceRolls[attackingArmy - i] > DefenderDiceRolls[defendingArmy - i]) {
						defendingArmy--;
						System.out.println(defenderUsername + " loses a battle, and one unit is destroyed.");
					}
					else {
						attackingArmy--;
						System.out.println(username + " loses a battle, and one unit is destroyed.");
					}
				}
				//System.out.println("\n" + username + " has " + attackingArmy + " attacking units left, and " + (attackingArmy + From.getArmyPower()) + " total units left in " + From.getName() +".");

				if(defendingArmy==0){
					To.setOccupyingUser(this);
					To.setArmyPower(attackingArmy);
					System.out.println(To.getUser().username + " now has control of " + To.getName() + " and moved " + attackingArmy + " units to the new territory.");

				}
				else{
					From.setArmyPower(From.getArmyPower() + attackingArmy);
					System.out.println(username +  " has " + (From.getArmyPower()) + " total units left in " + From.getName() + ".");
					To.setArmyPower(To.getArmyPower() + defendingArmy);
					System.out.println(defenderUsername +  " has " + (To.getArmyPower()) + " total units left in " + To.getName() + ".");
				}
				break;
			case PLACE_ARMY:
				System.out.println("Which territory would you like to place an army at?");
				String placeAtName = sc.nextLine();
				Territory placeAt = board.getCountryByName(placeAtName);
				if(!checkOwnership(placeAtName, board)){ Action(a, board); break; }
				else{
				System.out.println(username + " is placing an army at " + placeAt.getName());
				placeAt.setArmyPower(placeAt.getArmyPower()+1);
				System.out.println(placeAt.getName() + " has " + placeAt.getArmyPower() + " total units.");
			}
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
