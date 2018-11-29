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
    HashMap<String, Territory> territoriesHeld;
    HashMap<String, Continent> continentsHeld;

    @Before
    public void setup() {
        user1 = new User("Aaron", 25);
        user2 = new User("Henry", 20);
        Alaska = new Territory("Alaska");
        Quebec = new Territory("Quebec");
        user1.addTerritory(Alaska);
        user2.addTerritory(Quebec);
        user1.setScore(5);
        user1.incrementTwitterCount(5);
        user2.incrementTwitterCount(1);
        user1.incrementCredit();
        user1.incrementCredit();
        user2.incrementCredit();
    }

    @Test
    public void testGetUsername() {
        Assert.assertEquals(user1.getUsername(), "Aaron"); // Are names displaying correctly
        Assert.assertEquals(user2.getUsername(), "Henry");
    }

    @Test
    public void testAddArmyPower() {
        Assert.assertEquals(user1.addArmyPower(20), 45);
        Assert.assertEquals(user2.addArmyPower(5), 25);
    }

    @Test
    public void testRemoveArmyPower() {
        Assert.assertEquals(user1.removeArmyPower(20), 5);
        Assert.assertEquals(user2.removeArmyPower(50), 0); // Is function setting to 0 when p > current Army Power?
    }

    @Test
    public void testGetScore() {
        Assert.assertEquals(user1.getScore(), 5); // Updated score
        Assert.assertEquals(user2.getScore(), 0); // Default score
    }

    @Test
    public void testTwitterCount() {
        Assert.assertEquals(user1.getTwitterCount(), 5); // Updated twitter count
        Assert.assertEquals(user2.getTwitterCount(), 1); // Updated twitter count
        user2.incrementTwitterCount(1);
        Assert.assertEquals(user2.getTwitterCount(), 2); // Is Twitter count increment working?
    }

    @Test
    public void testEnoughCredits() {
        Assert.assertTrue(user1.enoughCredits(2));
        Assert.assertFalse(user2.enoughCredits(2));
    }

    @Test
    public void testCreditIncrement() {
        Assert.assertEquals(user1.incrementCredit(), 3);
        Assert.assertEquals(user2.incrementCredit(), 2);
    }

    @Test
    public void testCreditRemoval() {
        Assert.assertEquals(user1.removeCredit(1), 1);
        Assert.assertEquals(user2.removeCredit(1), 0);
        Assert.assertEquals(user1.removeCredit(5), 0);
    }

    @Test
    public void testCreditTransfer() {
        user1.transferCredits(user1, user2);
        Assert.assertEquals(user1.getCredits(), 0);
        Assert.assertEquals(user2.getCredits(), 3);
    }

    @Test
    public void testGetArmyPower() {
        Assert.assertEquals(user1.getArmyPower(), 25);
        Assert.assertEquals(user2.getArmyPower(), 20);
        // henry
    }


}
