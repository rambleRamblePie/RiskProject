import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import java.util.ArrayList;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.*;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.ApiContextInitializer;
/* Needed when running Twitter test case
import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
*/


public class AppTest
{

    User user;
    Dice dice;
    Territory territory;
    Territory territory2;
    Continent continent;
    Card card;
    ArrayList<Territory> territories = new ArrayList<Territory>();
    int testCountForTwitter;
    Deck deck;
    Board board;
    Hand hand;
    TweetPoster tp;
    Update update;

    @Before
    public void setup() throws Exception {
        board = new Board();
        board.setupBoard();
        user = new User("Aaron", 25);
        dice = new Dice();
        territory = new Territory("Brazil");
        territory2 = new Territory("Alaska");
        card = new Card("Infantry", territory);
        continent = new Continent("South America", 2, territories);
        testCountForTwitter = 1;
        deck = new Deck(board.getBoardTerritories());
        hand = new Hand();
        tp = new TweetPoster();
    }

    @BeforeClass
    public static void setupBot(){
        ApiContextInitializer.init();

        TelegramBotsApi telegramBotsApi = new TelegramBotsApi();

        try {
            telegramBotsApi.registerBot(new DadBot());
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testPlayer() {
        Assert.assertEquals(user.getUsername(), "Aaron");
        Assert.assertEquals(user.getTurnPosition(), 0);
    }

    @Test
    public void testContinent() {
        Assert.assertEquals(continent.getName(), "South America");
        Assert.assertEquals(continent.getBonusArmyAmount(), 2);
    }

    @Test
    public void testTerritory() {
        Assert.assertEquals(territory.getName(), "Brazil");
        //Assert.assertEquals(territory.getUser(), false);
        Assert.assertEquals(territory.getArmyPower(), 0);
        Assert.assertEquals(territory2.getName(), "Alaska");
        Assert.assertEquals(territory2.getArmyPower(), 0);
    }

    @Test
    public void testRoll() {
        int result = dice.getFaceValue();
        Assert.assertTrue(1 <= result && result <= 6);
        Assert.assertTrue(result != 0);
    }

    @Test
    public void testCard() {
        Assert.assertEquals(card.getType(), "Infantry");
    }

    @Test
    public void testGetName(){
        Assert.assertEquals(card.getName(), "Brazil");
    }

    @Test // for Hand class
    public void testAdd(){
        hand.add(card);
        Assert.assertTrue(hand.getCardsInHand().size() == 1); // Is hand updating?
    }

    @Test // for Hand class
    public void testGetCardsInHand(){
        Assert.assertTrue(hand.getCardsInHand().size() == 0);
    } // Is hand returning cards?

    @Test // for User class
    public void testAddCard(){
        user.addCard(card);
        Assert.assertTrue(user.getHand().size() == 1); // Is user's hand updating?
    }

    @Test // for User class
    public void testGetHand(){
        Assert.assertTrue(user.getHand().size() == 0); // Is user's hand returning cards?
    }

    @Test
    public void testIncrementCount(){
        tp.incrementCount(1);
        Assert.assertEquals(tp.getCount(), 1);
    }

    @Test
    public void testResetCount(){
        tp.incrementCount(1);
        Assert.assertEquals(tp.resetCount(), 0);
    }

    @Test
    public void testGetCount(){
        tp.incrementCount(2);
        Assert.assertEquals(tp.getCount(), 2);
    }

    @Test
    public void testGetTimedInput(){
        GameTimer gt = new GameTimer();
        gt.getTimedInput();
    }

    @Test
    public void testGetLastInput(){
        GameTimer gt = new GameTimer();
        gt.getLastInput();
    }

    @Test
    public void testGetTimedInputParameter(){
        GameTimer gt = new GameTimer();
        gt.getTimedInput(30);
    }

    @Test
    public void testShuffle(){
        Card firstCard = deck.card_draw();
        deck.addCard(firstCard);
        deck.shuffle();
        Assert.assertTrue(deck.card_draw() != firstCard);
    }

    @Test
    public void testCardDraw(){
        deck.card_draw();
    }

    @Test // Test addCard for Deck class
    public void testAddCardDeck(){
        deck.addCard(card);
    }

    @Test
    public void testOnUpdateReceived(){

    }

    @Test
    public void testSetupTelegramTerritories(){

    }

    @Test
    public void testGetContinents(){
        Assert.assertTrue(board.getContinents().size() == 6);
    }

    @Test
    public void testGetContinentName(){
        Assert.assertEquals(board.getContinentName("North America"), board.getContinentName("North America"));
    }

    @Test
    public void testGetBonusArmies(){
        Assert.assertTrue(board.getContinentName("North America").getBonusArmyAmount() == 5);
    }

    @Test
    public void testGetContainedTerritories(){
        Assert.assertTrue(board.getContinentName("North America").getTerritoriesOfContinent().size() == 9);
    }

    @Test
    public void testSetNumArmies(){
        board.getTerritoryName("Alaska").setNumArmies(100);
        Assert.assertEquals(board.getTerritoryName("Alaska").getArmyPower(), 100);
    }

    @Test
    public void testGetTerritoryName(){
        Territory test = board.getTerritoryName("Alaska");
        Assert.assertEquals(board.getTerritoryName("Alaska"), test);
    }

    @Test
    public void testSetUserOccupant(){
        board.getTerritoryName("Alaska").setOccupyingUser(user);
        Assert.assertEquals(board.getTerritoryName("Alaska").getUser().getUsername(), "Aaron");
    }

    @Test
    public void testGetOccupant(){
        board.getTerritoryName("Alaska").setOccupyingUser(user);
        Assert.assertEquals(board.getTerritoryName("Alaska").getUser(), user);
    }

    @Test
    public void testGetNumArmies(){
        board.getTerritoryName("Alaska").setNumArmies(100);
        Assert.assertEquals(board.getTerritoryName("Alaska").getArmyPower(), 100);
    }

    @Test
    public void testGetAdjacencies(){
        Assert.assertEquals(board.getTerritoryName("Yakutsk").getAdjacentTerritories().size(), 3);
    }

    @Test
    public void testCheckAdjacenciesTrue(){
        Assert.assertTrue(board.checkAdjacencies("Alaska", "Alberta"));
    }

    @Test
    public void testCheckAdjacenciesFalse(){
        Assert.assertFalse(board.checkAdjacencies("Alaska", "Yakutsk"));
    }

    @Test
    public void testUndoFortify(){
        board.getTerritoryName("Greenland").setNumArmies(20);
        board.undoFortify("Greenland", 2);
        Assert.assertEquals(board.getNumArmies("Greenland"), 18);
    }

    @Test
    public void testUndoAttack(){
        board.getTerritoryName("Alberta").setNumArmies(20);
        board.undoAttack("Alberta", 2);
        Assert.assertEquals(board.getNumArmies("Alberta"), 22);
    }



    //@Test
    // If an exception is thrown, change the number being passed to incrementTwitterCount
    /*
    public void testPostingToTwitter() throws TwitterException {
        user.incrementTwitterCount(1);
        Twitter twitter = TwitterFactory.getSingleton();
        String message = "Player " + user.getUsername() + " has conquered " + user.getTwitterCount() + " territories";
        Status status = twitter.updateStatus(message);
        // You can verify the post on Twitter, Team HAL @hal_team
    }
    */

}
