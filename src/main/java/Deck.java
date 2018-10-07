import java.util.Collections;
import java.util.Arrays;
import java.util.ArrayList;

public class Deck {

    /* need country type and card type (out of 3 types) for each card
    42 cards needed total, will manually create the deck

    The deck will be an array list of cards with the type and country
    Need to spawn the deck, shuffle afterwards

    need a draw function

    need an add function when cards are returned

    need a shuffle function
    */

    // create an arrayList<Card> for the deck

    // constructor populates the list with cards, preferably reading cards from a file
    // constructor makes the list of cards unmodifiable
    // constructor shuffles cards into a stack that cards can be drawn from (aka the drawing pile)
    
    // drawing a card removes it from the stack
    // we shouldn't run out of cards as long as players are forced to turn in a set when they have 6 cards

    // turning in a set places all of those cards in a discard pile
    // when there are no more cards to draw from, the discard pile should be reshuffled back into the drawing pile
    // DO NOT RESHUFFLE CARDS THAT PLAYERS STILL HAVE

    // keep count of how many sets were turned in
}
