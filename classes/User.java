class User {
	private String username;
	private int turnPosition;
	private int score;
	private int armyPower;
	
	public void Action(); // Move, Battle
	//Not exactly sure how this function should look
	// Alex: Maybe use an enum?
	
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
}