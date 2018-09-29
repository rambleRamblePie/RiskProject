import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Arrays;


public class UserTest {

    User user1;
    User user2;
    Territory Alaska;
    Territory Quebec;
    HashMap<String,Territory> territoriesHeld;
    HashMap<String,Continent> continentsHeld;

    @Before
    public void setup() throws Exception {
        user1 = new User("Aaron", 25);
        user2 = new User("Henry", 20);
        Alaska = new Territory("Alaska");
        Quebec = new Territory("Quebec");
        user1.addTerritory(Alaska);
        user2.addTerritory(Quebec);
        user2.setTurnPosition(2);
        user1.setScore(5);
    }

    @Test
    public void testGetUsername(){
        Assert.assertEquals(user1.getUsername(), "Aaron"); // Are names displaying correctly
        Assert.assertEquals(user2.getUsername(), "Henry");
    }

    @Test
    public void testAddArmyPower(){
        Assert.assertEquals(user1.addArmyPower(20), 45);
        Assert.assertEquals(user2.addArmyPower(5), 25);
    }

    @Test
    public void testRemoveArmyPower(){
        Assert.assertEquals(user1.removeArmyPower(20), 5);
        Assert.assertEquals(user2.removeArmyPower(50), 0); // Is function setting to 0 when p > current Army Power?
    }

    @Test
    public void testGetScore(){
        Assert.assertEquals(user1.getScore(), 5); // Updated score
        Assert.assertEquals(user2.getScore(), 0); // Default score
    }

    @Test
    public void testGetTurnPosition(){
        Assert.assertEquals(user1.getTurnPosition(), 0); // Is default working correctly?
        Assert.assertEquals(user2.getTurnPosition(), 2); // Is updated turn position working?
    }
}
