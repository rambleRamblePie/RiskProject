import java.util.*;

/**
 * The Hand class contains the details about the Hand object each
 * User has. The hand is made up of Card objects. There are functions
 * to check whether a User has to turn in cards, if the cards turned
 * in are all the same type, or all different, and adding cards to the
 * hand itself
 * @author Aaron Mitchell
 * @version 0.4
 */

public class Hand {

    private ArrayList<Card> user_hand;
    private boolean checkHand;

    /**
     * Constructor for the User's hand
     * @see Deck
     * @see Card
     * @see User
     */
    public Hand() {

        user_hand = new ArrayList<Card>();
    }

    /**
     * Adds a card to the User's hand
     * @param cardToAdd The card that is first drawn from the deck. Will store in a variable and then
     *                  call this function and pass the variable name of the card drawn
     * @see Deck
     * @see Hand
     * @see Card
     */
    public void add(Card cardToAdd) {

        user_hand.add(cardToAdd);
    }

    /**
     * Returns the ArrayList of cards in the User's hand
     * @return User's hand
     * @see Deck
     * @see Hand
     * @see Card
     */
    public ArrayList<Card> getCardsInHand() {
        return user_hand;
    }
}
