import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Arrays;


public class BoardTest {

    @Before
    public void setup() throws Exception {

    }

    @Test
    public void testHashMap(){
        HashMap<String, Territory> territoryContainer = new HashMap<String, Territory>();
        HashMap<String, Continent> continentsContainer = new HashMap<String, Continent>();

        User Aaron = new User("Aaron", 25);

        // Spawning to test territories
        Territory Alaska = new Territory("Alaska");
        Territory Alberta = new Territory("Alberta");
        Territory NorthwestTerritory = new Territory("NorthwestTerritory");
        Territory Kamchatka = new Territory("Kamchatka");
        Territory[] alaskaList = new Territory[]{Alberta, NorthwestTerritory, Kamchatka};

        ArrayList<Territory> AlaskaADJ = new ArrayList<Territory>();
        AlaskaADJ.addAll(Arrays.asList(alaskaList));
        Alaska.addAdjacencies(AlaskaADJ);

        territoryContainer.put("Alaska", Alaska);

        territoryContainer.get("Alaska").setOccupyingUser(Aaron);

        // Spawning to test continent
        Territory CentralAmerica = new Territory("CentralAmerica");
        Territory EasternUnitedStates = new Territory("EasternUnitedStates");
        Territory Ontario = new Territory("Ontario");
        Territory Greenland = new Territory("Greenland");
        Territory WesternUnitedStates = new Territory("WesternUnitedStates");
        Territory Quebec = new Territory("Quebec");

        ArrayList<Territory> northAmericaList = new ArrayList<Territory>();
        northAmericaList.add(Alaska);
        northAmericaList.add(Alberta);
        northAmericaList.add(CentralAmerica);
        northAmericaList.add(EasternUnitedStates);
        northAmericaList.add(Greenland);
        northAmericaList.add(NorthwestTerritory);
        northAmericaList.add(Ontario);
        northAmericaList.add(Quebec);
        northAmericaList.add(WesternUnitedStates);

        Continent NorthAmerica = new Continent("North America", 5, northAmericaList);
        continentsContainer.put("North America", NorthAmerica);
        Continent test1 = continentsContainer.get("NorthAmerica");
        Territory test2 = territoryContainer.get("Alaska");

        // Testing HashMaps are working correctly/consistently when queried
        Assert.assertEquals(test1, test1);
        Assert.assertEquals(test2, test2);

        // Checking HashMaps have proper size
        Assert.assertEquals(territoryContainer.size(), 1);
        Assert.assertEquals(continentsContainer.size(), 1);

        // Check name is correctly assigned and returned from HashMap
        Assert.assertEquals(territoryContainer.get("Alaska").getUser().getUsername(), "Aaron");

        // Check territory name can be queried from HashMap value
        Assert.assertEquals(territoryContainer.get("Alaska").getTerritory(), "Alaska");
    }

    @Test
    public void testHashMapSizes(){
        // Spawning to test continent
        Territory CentralAmerica = new Territory("CentralAmerica");
        Territory EasternUnitedStates = new Territory("EasternUnitedStates");
        Territory Ontario = new Territory("Ontario");
        Territory Greenland = new Territory("Greenland");
        Territory WesternUnitedStates = new Territory("WesternUnitedStates");
        Territory Quebec = new Territory("Quebec");
        Territory Alaska = new Territory("Alaska");
        Territory Alberta = new Territory("Alberta");
        Territory NorthwestTerritory = new Territory("NorthwestTerritory");
        Territory Kamchatka = new Territory("Kamchatka");

        HashMap<String, Territory> territoryContainer = new HashMap<String, Territory>();

        // Testing various sizes of HashMap, and Territory.getName() function works when storing into HashMap
        territoryContainer.put(CentralAmerica.getName(), CentralAmerica);
        territoryContainer.put(EasternUnitedStates.getName(), EasternUnitedStates);

        Assert.assertEquals(territoryContainer.size(), 2);

        territoryContainer.put(Ontario.getName(), Ontario);
        territoryContainer.put(Greenland.getName(), Greenland);

        Assert.assertEquals(territoryContainer.size(), 4);

        territoryContainer.put(WesternUnitedStates.getName(), WesternUnitedStates);
        territoryContainer.put(Quebec.getName(), Quebec);

        Assert.assertEquals(territoryContainer.size(), 6);

        territoryContainer.put(Alaska.getName(), Alaska);
        territoryContainer.put(Alberta.getName(), Alberta);

        Assert.assertEquals(territoryContainer.size(), 8);

        territoryContainer.put(NorthwestTerritory.getName(), NorthwestTerritory);
        territoryContainer.put(Kamchatka.getName(), Kamchatka);

        Assert.assertEquals(territoryContainer.size(), 10);

        // Removing and testing size. Also passing key in with string value
        territoryContainer.remove("CentralAmerica");
        territoryContainer.remove("Kamchatka");
        Assert.assertEquals(territoryContainer.size(), 8);

        territoryContainer.remove("NorthwestTerritory");
        territoryContainer.remove("Alberta");
        Assert.assertEquals(territoryContainer.size(), 6);

        territoryContainer.remove("Alaska");
        territoryContainer.remove("Quebec");
        Assert.assertEquals(territoryContainer.size(), 4);

        territoryContainer.remove("WesternUnitedStates");
        territoryContainer.remove("Ontario");
        Assert.assertEquals(territoryContainer.size(), 2);

        territoryContainer.remove("Greenland");
        Assert.assertEquals(territoryContainer.size(), 1);
    }
}
