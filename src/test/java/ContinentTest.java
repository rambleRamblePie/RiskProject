import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import java.util.ArrayList;

public class ContinentTest {

    Territory Alaska;
    Territory Quebec;
    Territory GreatBritian;
    Territory Iceland;
    Territory Scandinavia;
    Continent NorthAmerica;
    Continent Europe;
    ArrayList<Territory> territories = new ArrayList<Territory>();
    ArrayList<Territory> northAmericaList = new ArrayList<Territory>();
    ArrayList<Territory> europeList = new ArrayList<Territory>();
    User Aaron;

    @Before
    public void setup() throws Exception {
        Alaska = new Territory("Alaska");
        Quebec = new Territory("Quebec");
        GreatBritian = new Territory("GreatBritian");

        northAmericaList.add(Alaska);
        northAmericaList.add(Quebec);

        europeList.add(GreatBritian);
        europeList.add(Iceland);
        europeList.add(Scandinavia);

        NorthAmerica = new Continent("NorthAmerica", 5, northAmericaList);
        Europe = new Continent("Europe", 3, europeList);
        Aaron = new User("Aaron", 25);
        Alaska.setOccupyingUser(Aaron);
        Alaska.setArmyPower(50);
    }

    @Test
    public void testGetName(){
        Assert.assertEquals(Europe.getName(), "Europe"); // are names correct?
        Assert.assertEquals(NorthAmerica.getName(), "NorthAmerica");
    }

    @Test
    public void testGetBonusArmy(){
        Assert.assertEquals(Europe.getBonusArmyAmount(), 3); // are bonus armies correct?
        Assert.assertEquals(NorthAmerica.getBonusArmyAmount(), 5);
    }

    @Test
    public void testGetTerritoriesOfContinent(){
        Assert.assertEquals(NorthAmerica.getTerritoriesOfContinent().size(), 2); // are the territories actually being added?
        Assert.assertEquals(Europe.getTerritoriesOfContinent().size(), 3);
    }
}
