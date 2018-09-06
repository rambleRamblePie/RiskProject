class User {
	private String username;
	private int turn_position;
	private int score;
	private int numTroops;
	
	public void Action(); // Move, Battle
	//Not exactly sure how this function should look
	// Alex: Maybe use an enum?
	
	public User(String uname, int pos, int ntroops) {
		username = uname;
		turn_position = pos;
		numTroops = ntroops;
	}
	
	
}