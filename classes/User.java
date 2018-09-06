class User {
	private String username;
	private int turnPosition;
	private int score;
	private int armyPower;
	
	public void Action(); // Move, Battle
	//Not exactly sure how this function should look
	// Maybe use an enum as an argument to select different actions?
	
	public User(String n, int startingArmy) {
		username = n;
		armyPower = startingArmy;
		turnPosition = 0;
		score = 0;
	}
	
	public void setTurnPosition(int pos) {
		turnPosition = pos;
	}
	public int getTurnPosition() {
		return turnPosition;
	}
	
	public int addArmyPower(int p) {
		if (p < 0)
			throw new java.lang.IllegalArgumentException();
		
		armyPower += p;
		return armyPower;
	}
	public int removeArmyPower(int p) {
		if (p < 0)
			throw new java.lang.IllegalArgumentException();
		
		if (p > armyPower)
			armyPower = 0;
		else
			armyPower -= p;
		return armyPower;
	}
}