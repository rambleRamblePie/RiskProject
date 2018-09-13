class User {
	private String username;
	private int turnPosition;
	private int score;
	private int armyPower;
	
	public enum Actions {
		MOVE, ATTACK, PLACE_ARMY
	}
	
	public void Action(enum Action, Continent c, Territory t) {
		switch (Actions){
			case MOVE:
				System.out.println(username + " is Moving __ units from __ to __");
			case ATTACK:
				System.out.println(username + " is Attacking __ from __ with __ units");
			case PLACE_ARMY:
				System.out.println(username + " is placing an army at__");


		}
	} // Move, Battle, Place Army
	
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
