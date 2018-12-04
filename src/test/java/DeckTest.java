import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import java.util.ArrayList;
import java.util.HashMap;

public class DeckTest {
    Deck deck1;
    Card card1;
    Card card2;
    Board board1;
    //    String[] cardDeck = {"Cannon", "Horse", "Tank"};
    private ArrayList<Territory> territoryList;
    private HashMap<String, Territory> territoryContainer;
    private HashMap<String, Continent> continentsContainer;

    @Before
    public void setup() {
        board1 = new Board();
        board1.setupBoard();

        territoryContainer = new HashMap<String, Territory>();
        continentsContainer = new HashMap<String, Continent>();

        territoryList = new ArrayList<Territory>(); // will hold array to pass to Deck constructor


        deck1 = new Deck(board1.getBoardTerritories());


    }

    @Test
    public void testCard_Draw() {
        setup();
        String cardDraw = deck1.card_draw().getType();

        if (cardDraw.equals("Cannon")) {
            Assert.assertEquals(cardDraw, "Cannon");
        } else if (cardDraw.equals("Horse")) {
            Assert.assertEquals(cardDraw, "Horse");
        } else {
            // Tank, else not equal
            Assert.assertEquals(cardDraw, "Tank");
        }
    }


}
