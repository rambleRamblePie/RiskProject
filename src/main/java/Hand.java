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

    /**
     * Sets the flag for if a User can turn cards in. If they have 3 or more cards
     * and they are all the same type, or all different types, the flag is set
     * to true. Otherwise the flag stays false and the User is unable to turn in any
     * cards
     * @param position1 Index position of the first card
     * @param position2 Index position of the second card
     * @param position3 Index position of the third card
     * @return The checkHand flag, either True or False
     * @see Deck
     * @see Hand
     * @see Card
     */
    public boolean turnCardsIn(int position1, int position2, int position3) {

        checkHand = false;

        if (user_hand.size() >= 3) {
            if (user_hand.get(position1).getType().equals(user_hand.get(position2).getType()) && user_hand.get(position1).getType().equals(user_hand.get(position3).getType())) {
                checkHand = true;

            } else if (
                    !user_hand.get(position1).getType().equals(user_hand.get(position2).getType()) && !user_hand.get(position1).getType().equals(user_hand.get(position3).getType()) && !user_hand.get(position2).getType().equals(user_hand.get(position3).getType())) {
                //If all three cards have different types
                checkHand = true;
            }
        }
        return checkHand;
    }

    /**
     * Checks to see if a User can turn in cards, then removes them from the hand based on index position
     * @param position1 Index position of the first card
     * @param position2 Index position of the second card
     * @param position3 Index position of the third card
     * @see Deck
     * @see Hand
     * @see Card
     */
    public void deleteCardsFromHand(int position1, int position2, int position3) {

        if (turnCardsIn(position1, position2, position3) == true) {
            user_hand.remove(position3);
            user_hand.remove(position2);
            user_hand.remove(position1);
        } else {
            System.out.println("Turning in cards requires 3 cards of the same type, or each card of a different type");
        }
    }

    /**
     * Checks to see if a User must turn in cards. If hand size is greater than or equal to 5,
     * the User either has 3 of a different type, or 3 of one type
     * @return Returns true or false depending on User's hand size
     * @see Deck
     * @see Hand
     * @see Card
     */
    public boolean hasToTurnInCards() {
        checkHand = false;
        if (user_hand.size() >= 5) {
            checkHand = true;
        }
        return checkHand;
    }
}
