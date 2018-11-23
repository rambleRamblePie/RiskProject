import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import java.util.ArrayList;
import java.util.HashMap;

public class UserTest {

    User user1;
    User user2;
    Territory Alaska;
    Territory Quebec;
    Continent NorthAmerica;
    HashMap<String,Territory> territoriesHeld;
    HashMap<String,Continent> continentsHeld;
    ArrayList<Territory> territories = new ArrayList<Territory>();

    @Before
    public void setup() throws Exception {
        user1 = new User("Aaron", 25);
        user2 = new User("Henry", 20);
        Alaska = new Territory("Alaska");
        Quebec = new Territory("Quebec");
        NorthAmerica = new Continent("NorthAmerica", 5, territories);
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
    public void testTwitterCount(){
        Assert.assertEquals(user1.getTwitterCount(), 5); // Updated twitter count
        Assert.assertEquals(user2.getTwitterCount(), 1); // Updated twitter count
        user2.incrementTwitterCount(1);
        Assert.assertEquals(user2.getTwitterCount(), 2); // Is Twitter count increment working?
    }

    @Test
    public void testEnoughCredits(){
        Assert.assertTrue(user1.enoughCredits(2));
        Assert.assertFalse(user2.enoughCredits(2));
    }

    @Test
    public void testCreditIncrement(){
        Assert.assertEquals(user1.incrementCredit(), 3);
        Assert.assertEquals(user2.incrementCredit(), 2);
    }

    @Test
    public void testCreditRemoval(){
        Assert.assertEquals(user1.removeCredit(1), 1);
        Assert.assertEquals(user2.removeCredit(1), 0);
        Assert.assertEquals(user1.removeCredit(5), 0);
    }

    @Test
    public void testCreditTransfer(){
        user1.transferCredits(user1, user2);
        Assert.assertEquals(user1.getCredits(), 0);
        Assert.assertEquals(user2.getCredits(), 3);
    }

    @Test
    public void testDeleteTerritory(){
        user1.deleteTerritory("Alaska");
        Assert.assertTrue(user1.getUserTerritories().size() == 0); // Is territory being removed?
    }

    @Test
    public void testRemoveArmyPowerException(){
        boolean thrown = false;
        try {
            user1.removeArmyPower(-2);
        } catch (IllegalArgumentException e) {
            thrown = true;
        }
        Assert.assertTrue(thrown); // Is illegal argument exception being thrown?
    }

    @Test
    public void testAddArmyPowerException(){
        boolean thrown = false;
        try {
            user1.addArmyPower(-2);
        } catch (IllegalArgumentException e) {
            thrown = true;
        }
        Assert.assertTrue(thrown); // Is illegal argument exception being thrown?
    }

    @Test
    public void testSetTurnPosition(){
        user1.setTurnPosition(5);
        Assert.assertEquals(user1.getTurnPosition(), 5); // Is turn position setting correctly?
    }

    @Test
    public void testNumArmiesAdded(){
        Assert.assertEquals(user1.numArmiesAdded(), 3);
    }

    @Test
    public void testGetUserTerritories(){
        Assert.assertEquals(user1.getUserTerritories().get(0).getName(), "Alaska");
    }

    @Test
    public void testGetArmyPower(){
        user1.addArmyPower(50);
        Assert.assertEquals(user1.getArmyPower(), 75);
    }

    @Test
    public void testAddContinent(){
        user1.addContinent(NorthAmerica);
    }

    @Test
    public void testDeleteContinent(){
        user1.addContinent(NorthAmerica);
        user1.deleteContinent("NorthAmerica");
    }

    @Test
    public void testAlertUser(){
        user1.alertUser(user1);
    }

    @Test
    public void testCheckPurchaseTransferTrue(){
        user1.incrementCredit();
        user1.incrementCredit();
        user1.incrementCredit();
        user1.incrementCredit();
        user1.incrementCredit();
        user1.incrementCredit();
        user1.incrementCredit();
        user1.incrementCredit();
        Assert.assertTrue(user1.checkPurchaseTransfer());
    }

    @Test
    public void testCheckPurchaseTransferFalse(){
        Assert.assertFalse(user1.checkPurchaseTransfer());
    }

    @Test
    public void testCheckPurchaseCardTrue(){
        user1.incrementCredit();
        user1.incrementCredit();
        user1.incrementCredit();
        user1.incrementCredit();
        user1.incrementCredit();
        user1.incrementCredit();
        user1.incrementCredit();
        user1.incrementCredit();
        Assert.assertTrue(user1.checkPurchaseCard());
    }

    @Test
    public void testCheckPurchaseCardFalse(){
        Assert.assertFalse(user1.checkPurchaseCard());
    }

    @Test
    public void testCheckPurchaseUndoTrue(){
        user1.incrementCredit();
        user1.incrementCredit();
        user1.incrementCredit();
        user1.incrementCredit();
        user1.incrementCredit();
        user1.incrementCredit();
        user1.incrementCredit();
        user1.incrementCredit();
        Assert.assertTrue(user1.checkPurchaseUndo());
    }

    @Test
    public void testCheckPurchaseUndoFalse(){
        Assert.assertFalse(user1.checkPurchaseUndo());
    }

    @Test
    public void testGetHandClass(){
        user1.getHandClass();
    }
}
