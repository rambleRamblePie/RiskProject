import java.util.*;

class GameSetup {
	
	private int numPlayers;
	private int startingArmyPowerPerPlayer;
	private ArrayList<User> players;
	
	GameSetup(int nPlayers, ArrayList<String> names) {
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
		
		// determine turn positions of players
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
		
		// take turns placing armies on the board
		while(armyLeftToPlaceTotal > 0) {
			
		}
		
	}
	
	
}