class GameSetup {
	
	private int numPlayers;
	private int startingArmyPowerPerPlayer;
	
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
			default: // throw invalid input error
		}
		
		// unfinished
	}
	
	
}