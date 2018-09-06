import java.util.*

class GameSetup {
	
	private int numPlayers;
	private int startingArmyPowerPerPlayer;
	private ArrayList<User> players;
	
	GameSetup(int nPlayers) {
		if (nPlayers)
		
		numPlayers = nPlayers;
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
			default: // throw invalid input error (because nPlayers should already be checked in the calling class)
		}
		
		players = new ArrayList<User>();
		for (int i = 0; i < numPlayers; i++) {
			players.add(new User("placeholder name", startingArmyPowerPerPlayer));
			// need to prompt for name...
			// need to determine player positions by dice roll
		}
		
		// take turns placing armies on the board
		
	}
	
	
}