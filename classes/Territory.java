class Territory {
	
	private String name;
	private mapDataTypePlaceholder<Territory> adjacentTerritories;
	private int ID;
	private int continent; // the continent ID that this territory belongs to
		// or maybe use a function continentInstance.getParentContinent()?
	
	private User occupyingUser;
	private int armyPower;
	
	
	
	public int getID () { return ID; }
	
	public listTypePlaceholder getAdjacentTerritories() {
		throw java.lang.UnsupportedOperationException;
		return null;
	}
	
	// missing more methods
	
}