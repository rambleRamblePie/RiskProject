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
	private Hand playingHand;
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
		score = 0;
		this.twitterCount = 0;
		this.credits = 0;

		territoriesHeld = new HashMap<String,Territory>();
		continentsHeld = new HashMap<String,Continent>();
		playingHand = new Hand();
	}

	public void addCard(Card drawnCard) {

		playingHand.add(drawnCard);
	}

	public ArrayList<Card> getHand() {

		return playingHand.getCardsInHand();
	}

	public Hand getHandClass() {

		return playingHand;
	}

	/**
	 * Sets the User's turn position
	 * @param position Specifies the User's turn position
	 * @see User
	 */
	public void setTurnPosition(int position) {
		turnPosition = position;
	}

	public void removeCards(int[] cardsTurnedInIndex) {

		playingHand.deleteCardsFromHand(cardsTurnedInIndex[0], cardsTurnedInIndex[1], cardsTurnedInIndex[2]);
	}

	public boolean hasToTurnInCards() {

		return playingHand.hasToTurnInCards();
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
		user2.credits += user1.credits;
		user1.credits = 0;
	}

	/**
	 * Returns the User's number of credits
	 * @return User's credit amount
	 * @see User
	 */

	public int getCredits(){
		return credits;
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
