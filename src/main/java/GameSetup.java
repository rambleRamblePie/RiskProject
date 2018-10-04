import java.util.*;

class GameSetup {
	
	private World world;
	private int numPlayers;
	private int startingArmyPowerPerPlayer;
	private ArrayList<User> players;
	
	GameSetup(int nPlayers, String[] names) {
		world = new World();
		numPlayers = nPlayers;
		int armyLeftToPlaceTotal;
		switch(numPlayers) {
			case 2:
				startingArmyPowerPerPlayer = 40;
				break;
			case 3:
				startingArmyPowerPerPlayer = 35;
				break;
			case 4:
				startingArmyPowerPerPlayer = 30;
				break;
			case 5:
				startingArmyPowerPerPlayer = 25;
				break;
			case 6:
				startingArmyPowerPerPlayer = 20;
				break;
			default: // throw invalid input error (because nPlayers should already be checked in the calling function)
		}
		
		armyLeftToPlaceTotal = numPlayers * startingArmyPowerPerPlayer;
		
		// create players
		players = new ArrayList<User>();
		for (int i = 0; i < numPlayers; i++) {
			players.add(new User(names[i], startingArmyPowerPerPlayer));
		}
		
		determineTurns();
		placeBeginningArmies();
	}
	
	public World getWorldInstance() {
		return world;
	}
	
	private void determineTurns() {
		// determine turn positions of players
		/*
		ArrayList<Dice> die = new ArrayList<Dice>();
		for (int i = 0; i < numPlayers; i++) {
			die.add(new Dice());
		}
		for (int i = 0; i < numPlayers - 1; i++) {
			boolean foundNextTurn = false;
			while (!foundNextTurn) {
				// roll dice for each player
				// whoever gets highest roll gets next turn
				// reroll if there is a tie
				die.roll();
				
			}
			die.remove();
		}
		*/
		// instead, player 1 goes first
	}
	
	private void placeBeginningArmies() {
		// take turns placing armies on the board
		int turn = 0;
		boolean successfulArmyPlacement = false;
		Territory selectedTerritory;
		User currentPlayer;
		int armyLeftToPlaceTotal = numPlayers * startingArmyPowerPerPlayer;
		while(armyLeftToPlaceTotal > 0) {
			currentPlayer = players.get(turn);
			// give player a list of territories that are available
			// (use a function)
			// player can enter in a number instead of typing the territory name
			
			//selectedTerritory = world.getTerritory(ui.prompt(currentPlayer.getUsername()));
			selectedTerritory = null;
			// world has empty territories
			/*if () {
				
			} else */if (selectedTerritory.getUser() != currentPlayer) {
				// display territory occupied
				successfulArmyPlacement = false;
			}/* else if () // ??? */
			
			if (!successfulArmyPlacement) {
				continue;
			}
			
			// set occupying user of selectedTerritory to the currentPlayer
			// set army to 1 if unoccipied, else army++
			
			turn += 1;
			turn %= numPlayers;
			armyLeftToPlaceTotal--;
		}
	}
	
	public World getWorld() {
		return world;
	}
	
	// need a function to add cards to a deck
	// and store deck in this class
	
}
