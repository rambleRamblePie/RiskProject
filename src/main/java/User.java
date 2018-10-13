import java.util.Arrays;
import java.util.Scanner;
import java.util.HashMap;
import java.util.ArrayList;

/** The User class contains the information used to setup User objects and
 *  call functions to ensure functionality of the game. These include adding
 *  territories, grabbing the username, setting army power, incrementing User
 *  credits etc.
 * @author Aaron Mitchell
 * @author Alex Milligan
 * @author Luis Florez
 * @version 0.4
 */

public class User {
	private String username;
	private int turnPosition;
	private int score;
	private int armyPower;
	private int twitterCount;
	private int credits;
	private boolean hasCredits;
	private HashMap<String,Territory> territoriesHeld;
	private HashMap<String,Continent> continentsHeld;

	public enum Actions {
		MOVE, ATTACK, PLACE_ARMY, END_TURN
	}

	private boolean checkOwnership(String territoryName, Board board) {
		if(board.getTerritoryName(territoryName) == null){
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
					From = board.getTerritoryName(moveFrom);
				}
				else{Action(a, board); break;}

				System.out.println("Which territory would you like to move to?");
				String moveTo = sc.nextLine();
				if(checkOwnership(moveTo, board)){
					if(!board.checkAdjacencies(moveFrom, moveTo)) {
						System.out.println("These territories are not adjacent, please try again");
						Action(a, board);
						break;
					}
					else
						To = board.getTerritoryName(moveTo);
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
				    From = board.getTerritoryName(attackFrom);
                }
                else {Action(a, board); break;}


				System.out.println("Which territory are you attacking?");
                String attackTo = sc.nextLine();
                if(board.getTerritoryName(attackTo) == null){
                    System.out.println("That territory doesn't exist, try again.");
                    Action(a, board); break;
                }
                else if(!board.checkAdjacencies(attackFrom, attackTo)) {
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
                    To = board.getTerritoryName(attackTo);
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
				Territory placeAt = board.getTerritoryName(placeAtName);
				if(!checkOwnership(placeAtName, board)){ Action(a, board); break; }
				else{
					System.out.println(username + " is placing an army at " + placeAt.getName());
					placeAt.setArmyPower(placeAt.getArmyPower()+1);
					System.out.println(placeAt.getName() + " has " + placeAt.getArmyPower() + " total units.");
				}
				break;
			case END_TURN:
				break;


		}
	} // Move, Battle, Place Army

	public User(String name, int startingArmy) {
		this.username = name;
		this.armyPower = startingArmy;
		score = 0;
		this.twitterCount = 0;
		this.credits = 0;

		territoriesHeld = new HashMap<String,Territory>();
		continentsHeld = new HashMap<String,Continent>();
	}

	/**
	 * Sets the User's turn position
	 * @param position Specifies the User's turn position
	 * @see User
	 */
	public void setTurnPosition(int position) {
		turnPosition = position;
	}


	/**
	 * Returns the turn position
	 * @return User's turn position
	 * @see User
	 */
	public int getTurnPosition() {
		return turnPosition;
	}

	/**
	 * Adds to the user's army power
	 * @param p The power to add to the User's army power
	 * @return User's updated army power
	 * @throws IllegalArgumentException if number entered is negative
	 * @see User
	 */
	public int addArmyPower(int p) {
		if (p < 0)
			throw new java.lang.IllegalArgumentException();

		armyPower = armyPower + p;
		return armyPower;
	}


	/**
	 * Keeps track of User's total conquered territories over the course of the game
	 * @param increase The amount to add to User's total conquered territories
	 * @return User's updated conquered territory total
	 * @see User
	 * @see TweetPoster
	 */
	public int incrementTwitterCount(int increase){
	    twitterCount = twitterCount + increase;

	    return twitterCount;
    }


	/**
	 * Returns User's current count of conquered territories in the game so far
	 * @return User's current conquered territory amount
	 * @see User
	 * @see TweetPoster
	 */
    public int getTwitterCount(){
		return twitterCount;
	}

	/**
	 * Removes army power if User has been attacked and lost the duel
	 * @param p The power to remove from the User's army power
	 * @return User's updated total number of armies
	 * @throws IllegalArgumentException if the number entered is negative
	 * @see User
	 */
	public int removeArmyPower(int p) {
		if (p < 0)
			throw new java.lang.IllegalArgumentException();

		if (p > armyPower)
			armyPower = 0;

		else
			armyPower = armyPower - p;

		return armyPower;
	}


	/**
	 * Keeps track of User's total win amount
	 * @param newScore The value to update score to
	 * @see User
	 */
	public void setScore(int newScore){
		score = newScore;
	}

	/**
	 * Grabs User's total win amount
	 * @return User's current win amount
	 * @see User
	 */
	public int getScore(){
		return score;
	}


	/**
	 * Grabs User's username they chose at the beginning of the game
	 * @return User's name
	 * @see User
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * Adds specified territory to User's HashMap. Each user will have a HashMap to keep track
	 * @param territory The territory to add to User's HashMap
	 * of their conquered territories
	 * @see User
	 * @see Territory
	 */
	public void addTerritory(Territory territory) {

		System.out.println(username + " now occupies " + territory.getName() + "!");
		territoriesHeld.put(territory.getName(), territory);
	}

	/**
	 * Deletes specified territory from User's HashMap. Each user will have a HashMap to keep track
	 * of their conquered territories
	 * @param territoryName The territory name to remove from User's HashMap
	 * @see User
	 * @see Territory
	 */
	public void deleteTerritory(String territoryName)
	{
		System.out.println(username + " has lost control of " + territoryName);
		territoriesHeld.remove(territoryName);
	}

	/**
	 * Increments User's current amount of credits. Each User will gain 1 credit per turn.
	 * Credit can be used to buy cards, purchase an undo feature, buy armies or transfer
	 * their credits to another player
	 * @return User's credits
	 * @see User
	 */
	public int incrementCredit(){
		credits = credits + 1;
		return credits;
	}


	/**
	 * Used to figure out how many armies to give a User at the beginning of their turn
	 * @return Number of armies to give to User
	 * @see User
	 */
	public int numArmiesAdded(){
		int add = territoriesHeld.size() / 3;

		if(add < 3){
			add = 3;
		}

		return add;
	}

	/**
	 * Decrements User's current amount of credits. Each User will gain 1 credit per turn.
	 * Credit can be used to buy cards, purchase an undo feature, buy armies or transfer
	 * their credits to another player
	 * @param creditAmount The amount of credit to remove from User's credits
	 * @return User's credits
	 * @see User
	 */
	public int removeCredit(int creditAmount){
		if((credits - creditAmount) < 0)
		{
			credits = 0;
		}
		else {
			credits = credits - creditAmount;
		}
		return credits;
	}

	/**
	 * Used to check whether a User is allowed to purchase things with their credits
	 * @param numRequiredCredits The amount of credits required for the User to buy what they are requesting
	 * @return True if they have enough credits, False if they do not
	 * @see User
	 */
	public boolean enoughCredits(int numRequiredCredits){
		int remainingCredits = credits - numRequiredCredits;

		if(remainingCredits < 0){
			hasCredits = false;
		}
		else{
			hasCredits = true;
			credits = remainingCredits;
		}
		return hasCredits;
	}

	/**
	 * Transfers credits between players
	 * @param user1 The User who is transfering the credits
	 * @param user2 The User who is receiving the credits
	 * @see User
	 */
	public void transferCredits(User user1, User user2){
		// will display names of all users in userList in loop
		// grab input of name from player transferring credit (input being string of the name)
		// add user1's credits to user2
		// set user1's credits to 0
	}

	/**
	 * Returns all the territories a User has control of
	 * @return All territories occupied by User
	 * @see User
	 * @see Territory
	 */
	public ArrayList<Territory> getUserTerritories()
	{
		return new ArrayList<Territory>(territoriesHeld.values());
	}


	/**
	 * Returns User's total army power
	 * @return User's total number of armies
	 * @see User
	 */
	public int getArmyPower(){
		return armyPower;
	}

	/**
	 * Add continent to User's continent HashMap. Each user has a continent HashMap
	 * that is used to store their controlled continents
	 * @param continent The continent to add to User's HashMap
	 * @see User
	 * @see Continent
	 */
	public void addContinent(Continent continent)
	{
		System.out.println(username + " is dominating the continent of " + continent);
		continentsHeld.put(continent.getName(), continent);
	}

	/**
	 * Delete continent from User's continent HashMap. Each user has a continent HashMap
	 * that is used to store their controlled continents
	 * @param continentName The continent name to query to add to User's HashMap
	 * @see User
	 * @see Territory
	 */
	public void deleteContinent(String continentName)
	{
		System.out.println(username + " is no longer dominating the continent of " + continentName);
		continentsHeld.remove(continentName);
	}
}
