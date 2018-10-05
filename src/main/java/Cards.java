// we probably should rename the file to Card.java

class Card {
	
    //we may have to manually make each card and put it in an arraylist. no big deal
    //creates a card for a territory of a certain type
    //will need a deck class that stores the deck, and possibly a hand class, and a hand variable for each player
    private Territory territory;
    private String type;
    
    public Card (String type, Territory territory)
    {
        this.type = type;
        this.territory = territory;
    }
    
    public String getName()
    {
        return territory.getName() + " with type " + type;
    }
    
    public Territory getTerritory()
    {
        return territory;
    }
    
    public String getType()
    {
        return type;
    }
}
