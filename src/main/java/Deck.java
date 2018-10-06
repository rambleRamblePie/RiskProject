import java.util.*;

public class Deck {

    private Card draw;
    private ArrayList<Card> card_deck;

    // Types will be Cannon, Horse, and Tank

    public Deck(ArrayList<Territory> territories){

        // Initialize card_deck
        card_deck = new ArrayList<Card>();

        // Spawn and add the 42 cards to the card_deck
        card_deck.add(new Card("Cannon", territories.get(0)));
        card_deck.add(new Card("Horse", territories.get(1)));
        card_deck.add(new Card("Tank", territories.get(2)));
        card_deck.add(new Card("Cannon", territories.get(3)));
        card_deck.add(new Card("Horse", territories.get(4)));
        card_deck.add(new Card("Tank", territories.get(5)));
        card_deck.add(new Card("Cannon", territories.get(6)));
        card_deck.add(new Card("Horse", territories.get(7)));
        card_deck.add(new Card("Tank", territories.get(8)));
        card_deck.add(new Card("Cannon", territories.get(9)));
        card_deck.add(new Card("Horse", territories.get(10)));
        card_deck.add(new Card("Tank", territories.get(11)));
        card_deck.add(new Card("Cannon", territories.get(12)));
        card_deck.add(new Card("Horse", territories.get(13)));
        card_deck.add(new Card("Tank", territories.get(14)));
        card_deck.add(new Card("Cannon", territories.get(15)));
        card_deck.add(new Card("Horse", territories.get(16)));
        card_deck.add(new Card("Tank", territories.get(17)));
        card_deck.add(new Card("Cannon", territories.get(18)));
        card_deck.add(new Card("Horse", territories.get(19)));
        card_deck.add(new Card("Tank", territories.get(20)));
        card_deck.add(new Card("Cannon", territories.get(21)));
        card_deck.add(new Card("Horse", territories.get(22)));
        card_deck.add(new Card("Tank", territories.get(23)));
        card_deck.add(new Card("Cannon", territories.get(24)));
        card_deck.add(new Card("Horse", territories.get(25)));
        card_deck.add(new Card("Tank", territories.get(26)));
        card_deck.add(new Card("Cannon", territories.get(27)));
        card_deck.add(new Card("Horse", territories.get(28)));
        card_deck.add(new Card("Tank", territories.get(29)));
        card_deck.add(new Card("Cannon", territories.get(30)));
        card_deck.add(new Card("Horse", territories.get(31)));
        card_deck.add(new Card("Tank", territories.get(32)));
        card_deck.add(new Card("Cannon", territories.get(33)));
        card_deck.add(new Card("Horse", territories.get(34)));
        card_deck.add(new Card("Tank", territories.get(35)));
        card_deck.add(new Card("Cannon", territories.get(36)));
        card_deck.add(new Card("Horse", territories.get(37)));
        card_deck.add(new Card("Tank", territories.get(38)));
        card_deck.add(new Card("Cannon", territories.get(39)));
        card_deck.add(new Card("Horse", territories.get(40)));
        card_deck.add(new Card("Tank", territories.get(41)));
        
        // Shuffle the card_deck
        Collections.shuffle(card_deck);
    }

    public void shuffle(){
        Collections.shuffle(card_deck);
    }

    public Card card_draw(){
        draw = card_deck.get(0);
        card_deck.remove(0);

        return draw;
    }

    public void addCard(Card card){
        card_deck.add(card);
    }
    
}
