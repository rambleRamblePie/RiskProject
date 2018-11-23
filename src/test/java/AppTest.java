import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import java.util.ArrayList;
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

    @Before
    public void setup() throws Exception {
        user = new User("Aaron", 25);
        dice = new Dice();
        territory = new Territory("Brazil");
        territory2 = new Territory("Alaska");
        card = new Card("Infantry", territory);
        continent = new Continent("South America", 2, territories);
        testCountForTwitter = 1;

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
