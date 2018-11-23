import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import java.util.ArrayList;

public class TerritoryTest {

    Territory Alaska;
    Territory Quebec;
    Continent NorthAmerica;
    Continent Europe;
    ArrayList<Territory> territories = new ArrayList<Territory>();
    User Aaron;

    @Before
    public void setup() throws Exception {
        territories.add(Quebec);
        Alaska = new Territory("Alaska");
        Quebec = new Territory("Quebec");
        NorthAmerica = new Continent("NorthAmerica", 5, territories);
        Aaron = new User("Aaron", 25);
        Alaska.setOccupyingUser(Aaron);
        Alaska.setArmyPower(50);
        Alaska.addAdjacencies(territories);
    }

    @Test
    public void testHasOccupant(){
        Assert.assertEquals(Alaska.getUser().getUsername(), "Aaron"); // Is name assigning correctly?
    }

    @Test
    public void testGetTerritory(){
        Assert.assertEquals(Alaska.getTerritory(), "Alaska"); // Is name working properly on spawn?
    }

    @Test
    public void testSetArmyPower(){
        Alaska.setArmyPower(20);
        Assert.assertEquals(Alaska.getArmyPower(), 20); // Did it change from previous assigned Army Power?
    }

    @Test
    public void testIncrementArmies(){
        Alaska.incrementArmies(20);
        Assert.assertEquals(Alaska.getArmyPower(), 70); // Is incrementing working?
    }

    @Test
    public void testDecrementArmies(){
        Alaska.decrementArmies(10);
        Assert.assertEquals(Alaska.getArmyPower(), 40); // Is decrementing working?

        Alaska.decrementArmies(100);
        Assert.assertEquals(Alaska.getArmyPower(), 0); // Is check working to set to 0?
    }

    @Test
    public void testGetName(){
        Assert.assertEquals(Alaska.getName(), "Alaska"); // Is name assigning correctly?
    }

    @Test
    public void testSetNumArmies(){
        Alaska.setNumArmies(100);
        Assert.assertEquals(Alaska.getArmyPower(), 100); // Is the army count being updated properly?
    }

    @Test
    public void testGetAdjacentTerritories(){
        Assert.assertEquals(Alaska.getAdjacentTerritories().size(), 1); // Are adjacencies actually being added?
    }

    @Test
    public void testGetContinent() {
        Alaska.getContinent();
    }
}
