import java.util.*;

class World {
	
	private ArrayList<Continent> continents;
	
	World() {
		// maybe read continents from a file instead
		continents.add(new Continent("North America", 5));
		continents.add(new Continent("South America", 2));
		continents.add(new Continent("Europe", 5));
		continents.add(new Continent("Asia", 7));
		continents.add(new Continent("Africa", 3));
		continents.add(new Continent("Austrailia", 2));
	}
	
	public Continent getContinentByIndex(int i) {
		//throw if not a valid index? handle it later
		return continents.get(i);
	}
	
	public boolean checkForGameEnd() {
		// game ends when only one player has armies on the board
		throw new java.lang.UnsupportedOperationException();
	}
}