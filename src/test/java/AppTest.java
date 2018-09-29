//package com.TeamHAL.Risk;


/**
 * Unit test for simple App.
 */
//public class AppTest
//extends TestCase
//{
/**
 * Create the test case
 *
 * @param testName name of the test case
 */
//public AppTest( String testName ) {super( testName ); }

/**
 * @return the suite of tests being tested
 */
//public static Test suite(){return new TestSuite( AppTest.class ); }

/**
 * Rigourous Test :-)
 */
//public void testApp(){assertTrue( true );}

//}
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import java.util.ArrayList;

public class AppTest
{

    User user;
    Dice dice;
    Territory territory;
    Territory territory2;
    Continent continent;
    Card card;
    ArrayList<Territory> territories = new ArrayList<Territory>();

    @Before
    public void setup() throws Exception {
        user = new User("Aaron", 25);
        dice = new Dice();
        territory = new Territory("Brazil");
        territory2 = new Territory("Alaska");
        card = new Card("Infantry", territory);
        continent = new Continent("South America", 2, territories);
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

}
