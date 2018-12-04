import java.lang.reflect.Array;
import java.util.*;

/**
 * The Deck class creates and stores the cards that User's will be drawing from
 * at the beginning of each turn. The card types will be "Tank", "Horse", and
 * "Cannon". The deck will be shuffled at the end of each turn, and each User
 * will draw a card from the deck at the beginning of their turn
 * @author Aaron Mitchell
 * @version 0.4
 */

public class Deck {

    private Card draw;
    private ArrayList<Card> card_deck;

    // Types will be Cannon, Horse, and Tank

    /**
     * Spawns the deck. The territoriesList variable from the Board class will be passed in as the
     * parameter for the deck, so we can create one card for each Territory. Types are assigned
     * automatically
     * @param territories The territoriesList variable from the Board class
     * @see Deck
     */
    public Deck(ArrayList<Territory> territories){

        // Initialize card_deck
        card_deck = new ArrayList<Card>();

        // Type of cards in deck
        String[] cardDeck = {"Cannon", "Horse", "Tank"};

        // Spawn and add the 42 cards to the card_deck using while loop.
        int i = 0;
        int j = 0;
        while (i <= 41) {
            if (j == 3) {
                j = 0;
                card_deck.add(new Card(cardDeck[j], territories.get(i)));
            }
            i++;
            j++;
            System.out.println("i :" + i + "j: " + j);
        }

//        card_deck.add(new Card("Cannon", territories.get(0)));
//        card_deck.add(new Card("Horse", territories.get(1)));
//        card_deck.add(new Card("Tank", territories.get(2)));
//        card_deck.add(new Card("Cannon", territories.get(3)));
//        card_deck.add(new Card("Horse", territories.get(4)));
//        card_deck.add(new Card("Tank", territories.get(5)));
//        card_deck.add(new Card("Cannon", territories.get(6)));
//        card_deck.add(new Card("Horse", territories.get(7)));
//        card_deck.add(new Card("Tank", territories.get(8)));
//        card_deck.add(new Card("Cannon", territories.get(9)));
//        card_deck.add(new Card("Horse", territories.get(10)));
//        card_deck.add(new Card("Tank", territories.get(11)));
//        card_deck.add(new Card("Cannon", territories.get(12)));
//        card_deck.add(new Card("Horse", territories.get(13)));
//        card_deck.add(new Card("Tank", territories.get(14)));
//        card_deck.add(new Card("Cannon", territories.get(15)));
//        card_deck.add(new Card("Horse", territories.get(16)));
//        card_deck.add(new Card("Tank", territories.get(17)));
//        card_deck.add(new Card("Cannon", territories.get(18)));
//        card_deck.add(new Card("Horse", territories.get(19)));
//        card_deck.add(new Card("Tank", territories.get(20)));
//        card_deck.add(new Card("Cannon", territories.get(21)));
//        card_deck.add(new Card("Horse", territories.get(22)));
//        card_deck.add(new Card("Tank", territories.get(23)));
//        card_deck.add(new Card("Cannon", territories.get(24)));
//        card_deck.add(new Card("Horse", territories.get(25)));
//        card_deck.add(new Card("Tank", territories.get(26)));
//        card_deck.add(new Card("Cannon", territories.get(27)));
//        card_deck.add(new Card("Horse", territories.get(28)));
//        card_deck.add(new Card("Tank", territories.get(29)));
//        card_deck.add(new Card("Cannon", territories.get(30)));
//        card_deck.add(new Card("Horse", territories.get(31)));
//        card_deck.add(new Card("Tank", territories.get(32)));
//        card_deck.add(new Card("Cannon", territories.get(33)));
//        card_deck.add(new Card("Horse", territories.get(34)));
//        card_deck.add(new Card("Tank", territories.get(35)));
//        card_deck.add(new Card("Cannon", territories.get(36)));
//        card_deck.add(new Card("Horse", territories.get(37)));
//        card_deck.add(new Card("Tank", territories.get(38)));
//        card_deck.add(new Card("Cannon", territories.get(39)));
//        card_deck.add(new Card("Horse", territories.get(40)));
//        card_deck.add(new Card("Tank", territories.get(41)));


        /* Testing
        System.out.println(card_deck.get(0).getType());
        System.out.println(card_deck.get(0).getName());
        */

        // Shuffle the card_deck
        Collections.shuffle(card_deck);
    }

    /**
     * Shuffles the deck of cards since User's will turn cards in periodically, the deck should be
     * shuffled at the end of each turn in the main loop
     * @see Deck
     */
    public void shuffle(){
        Collections.shuffle(card_deck);
    }

    /**
     * Allows the deck to have cards taken from it. Takes the top card to place into a User's hand,
     * then removes that card from the deck
     * @return Card drawn from the deck
     * @see Deck
     */
    public Card card_draw(){
        draw = card_deck.get(0);
        card_deck.remove(0);

        return draw;
    }

    /**
     * Adds a card to the deck (from a User's hand when they turn in cards)
     * @param card The card to be added to the deck. Should be an index such as: hand[0] for the first card in the User's hand
     * @see Deck
     */
    public void addCard(Card card){
        card_deck.add(card);
    }

}
