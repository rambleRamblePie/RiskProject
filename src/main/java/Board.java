import java.util.ArrayList;
import java.util.HashMap;
import java.util.Arrays;

/**
 * The Board class setups the virtual board used to query actions and Territories
 * @author Aaron Mitchell
 * @version 0.4
 */

public class Board {

    private boolean checkAdjacent;
    private ArrayList<Territory> territoryList;
    private HashMap<String, Territory> territoryContainer;
    private HashMap<String, Continent> continentsContainer;

    public Board() {
        // May add things here later
    }

    /**
     * Setups the board for the game
     */
    public void setupBoard() {
        territoryContainer = new HashMap<String, Territory>();
        continentsContainer = new HashMap<String, Continent>();

        territoryList = new ArrayList<Territory>(); // will hold array to pass to Deck constructor

        // Spawn Territories
        Territory Alaska = new Territory("Alaska");
        Territory Alberta = new Territory("Alberta");
        Territory CentralAmerica = new Territory("CentralAmerica");
        Territory EasternUnitedStates = new Territory("EasternUnitedStates");
        Territory Greenland = new Territory("Greenland");
        Territory NorthwestTerritory = new Territory("NorthwestTerritory");
        Territory Ontario = new Territory("Ontario");
        Territory Quebec = new Territory("Quebec");
        Territory WesternUnitedStates = new Territory("WesternUnitedStates");
        Territory Argentina = new Territory("Argentina");
        Territory Brazil = new Territory("Brazil");
        Territory Venezuela = new Territory("Venezuela");
        Territory GreatBritian = new Territory("GreatBritian");
        Territory Iceland = new Territory("Iceland");
        Territory NorthernEurope = new Territory("NorthernEurope");
        Territory Scandinavia = new Territory("Scandinavia");
        Territory SouthernEurope = new Territory("SouthernEurope");
        Territory Ukraine = new Territory("Ukraine");
        Territory WesternEurope = new Territory("WesternEurope");
        Territory Congo = new Territory("Congo");
        Territory EastAfrica = new Territory("EastAfrica");
        Territory Egypt = new Territory("Egypt");
        Territory Madagascar = new Territory("Madagascar");
        Territory NorthAfrica = new Territory("NorthAfrica");
        Territory SouthAfrica = new Territory("SouthAfrica");
        Territory Afghanistan = new Territory("Afghanistan");
        Territory China = new Territory("China");
        Territory India = new Territory("India");
        Territory Irkutsk = new Territory("Irkutsk");
        Territory Japan = new Territory("Japan");
        Territory Kamchatka = new Territory("Kamchatka");
        Territory MiddleEast = new Territory("MiddleEast");
        Territory Mongolia = new Territory("Mongolia");
        Territory Siam = new Territory("Siam");
        Territory Siberia = new Territory("Siberia");
        Territory Ural = new Territory("Ural");
        Territory Yakutsk = new Territory("Yakutsk");
        Territory EasternAustralia = new Territory("EasternAustralia");
        Territory Indonesia = new Territory("Indonesia");
        Territory Peru = new Territory("Peru");
        Territory NewGuinea = new Territory("NewGuinea");
        Territory WesternAustralia = new Territory("WesternAustralia");

        Territory[] alaskaList = new Territory[]{Alberta, NorthwestTerritory, Kamchatka};
        Territory[] albertaList = new Territory[]{Alaska, NorthwestTerritory, NorthwestTerritory, Ontario, WesternUnitedStates};
        Territory[] centralAmericaList = new Territory[]{WesternUnitedStates, Venezuela};
        Territory[] easternUSList = new Territory[]{WesternUnitedStates, Ontario, Quebec};
        Territory[] greenlandList = new Territory[]{NorthwestTerritory, Ontario, Quebec, Iceland};
        Territory[] NorthwestTerritoryList = new Territory[]{Alaska, Greenland, Ontario, Alberta};
        Territory[] ontarioList = new Territory[]{NorthwestTerritory, Greenland, Quebec, EasternUnitedStates, WesternUnitedStates, Alberta};
        Territory[] quebecList = new Territory[]{Ontario, Greenland, EasternUnitedStates};
        Territory[] westernUSList = new Territory[]{Alberta, Ontario, EasternUnitedStates, CentralAmerica};
        Territory[] argentinaList = new Territory[]{Venezuela, Brazil};
        Territory[] peruList = new Territory[]{Argentina, Brazil, Venezuela};
        Territory[] brazilList = new Territory[]{Venezuela, NorthAfrica, Argentina};
        Territory[] venezuelaList = new Territory[]{CentralAmerica, Brazil, Argentina};
        Territory[] greatBritianList = new Territory[]{Iceland, Scandinavia, NorthernEurope, WesternEurope};
        Territory[] icelandList = new Territory[]{Greenland, GreatBritian};
        Territory[] northernEuropeList = new Territory[]{GreatBritian, Ukraine, SouthernEurope, WesternEurope};
        Territory[] scandinaviaList = new Territory[]{GreatBritian, Ukraine};
        Territory[] southernEuropeList = new Territory[]{WesternEurope, NorthernEurope, Ukraine, Egypt, NorthAfrica};
        Territory[] ukraineList = new Territory[]{Scandinavia, Ural, Afghanistan, MiddleEast, SouthernEurope, NorthernEurope};
        Territory[] westernEuropeList = new Territory[]{GreatBritian, NorthernEurope, SouthernEurope, NorthAfrica};
        Territory[] congoList = new Territory[]{NorthAfrica, Egypt, EastAfrica, SouthAfrica};
        Territory[] eastAfricaList = new Territory[]{Egypt, Madagascar, SouthAfrica, Congo};
        Territory[] egyptList = new Territory[]{SouthernEurope, MiddleEast, EastAfrica, Congo, NorthAfrica};
        Territory[] madagascarList = new Territory[]{EastAfrica, SouthAfrica};
        Territory[] northAfricaList = new Territory[]{WesternEurope, SouthernEurope, Egypt, Congo, Brazil};
        Territory[] southAfricaList = new Territory[]{Congo, EastAfrica, Madagascar};
        Territory[] afghanistanList = new Territory[]{Ukraine, Ural, Siberia, China, India, MiddleEast};
        Territory[] chinaList = new Territory[]{Afghanistan, Siberia, Mongolia, Siam, India};
        Territory[] indiaList = new Territory[]{MiddleEast, Afghanistan, China, Siam};
        Territory[] irkutskList = new Territory[]{Siberia, Yakutsk, Kamchatka, Mongolia};
        Territory[] japanList = new Territory[]{Kamchatka, Mongolia};
        Territory[] kamchatkaList = new Territory[]{Yakutsk, Alaska, Japan, Mongolia, Irkutsk};
        Territory[] middleEastList = new Territory[]{Ukraine, Afghanistan, India, Egypt};
        Territory[] mongoliaList = new Territory[]{Siberia, Irkutsk, Kamchatka, Japan, China};
        Territory[] siamList = new Territory[]{India, China, Indonesia};
        Territory[] siberiaList = new Territory[]{Ural, Yakutsk, Irkutsk, Mongolia, China, Afghanistan};
        Territory[] uralList = new Territory[]{Ukraine, Siberia, Afghanistan};
        Territory[] yakutskList = new Territory[]{Siberia, Kamchatka, Irkutsk};
        Territory[] easternAustraliaList = new Territory[]{NewGuinea, Peru, WesternAustralia};
        Territory[] indonesiaList = new Territory[]{Siam, NewGuinea, WesternAustralia};
        Territory[] newGuineaList = new Territory[]{Indonesia, EasternAustralia, WesternAustralia};
        Territory[] westernAustraliaList = new Territory[]{Indonesia, NewGuinea, EasternAustralia};


        /** Spawn Adjacencies
         * Adjacencies takes the corresponding array above and converts it to a list stored in an ArrayList
         * The ArrayList will be stored in the coressponding territories adjacencies
         **/
        ArrayList<Territory> AlaskaADJ = new ArrayList<Territory>();
        AlaskaADJ.addAll(Arrays.asList(alaskaList));
        Alaska.addAdjacencies(AlaskaADJ);

        ArrayList<Territory> AlbertaADJ = new ArrayList<Territory>();
        AlbertaADJ.addAll(Arrays.asList(albertaList));
        Alberta.addAdjacencies(AlbertaADJ);

        ArrayList<Territory> CentralAmericaADJ = new ArrayList<Territory>();
        CentralAmericaADJ.addAll(Arrays.asList(centralAmericaList));
        CentralAmerica.addAdjacencies(CentralAmericaADJ);

        ArrayList<Territory> EasternUnitedStatesADJ = new ArrayList<Territory>();
        EasternUnitedStatesADJ.addAll(Arrays.asList(easternUSList));
        EasternUnitedStates.addAdjacencies(EasternUnitedStatesADJ);

        ArrayList<Territory> GreenlandADJ = new ArrayList<Territory>();
        GreenlandADJ.addAll(Arrays.asList(greenlandList));
        Greenland.addAdjacencies(GreenlandADJ);

        ArrayList<Territory> NorthwestTerritoryADJ = new ArrayList<Territory>();
        NorthwestTerritoryADJ.addAll(Arrays.asList(NorthwestTerritoryList));
        NorthwestTerritory.addAdjacencies(NorthwestTerritoryADJ);

        ArrayList<Territory> OntarioADJ = new ArrayList<Territory>();
        OntarioADJ.addAll(Arrays.asList(ontarioList));
        Ontario.addAdjacencies(OntarioADJ);

        ArrayList<Territory> QuebecADJ = new ArrayList<Territory>();
        QuebecADJ.addAll(Arrays.asList(quebecList));
        Quebec.addAdjacencies(QuebecADJ);

        ArrayList<Territory> WesternUnitedStatesADJ = new ArrayList<Territory>();
        WesternUnitedStatesADJ.addAll(Arrays.asList(westernUSList));
        WesternUnitedStates.addAdjacencies(WesternUnitedStatesADJ);

        ArrayList<Territory> ArgentinaADJ = new ArrayList<Territory>();
        ArgentinaADJ.addAll(Arrays.asList(argentinaList));
        Argentina.addAdjacencies(ArgentinaADJ);

        ArrayList<Territory> PeruADJ = new ArrayList<Territory>();
        PeruADJ.addAll(Arrays.asList(peruList));
        Peru.addAdjacencies(PeruADJ);

        ArrayList<Territory> BrazilADJ = new ArrayList<Territory>();
        AlaskaADJ.addAll(Arrays.asList(brazilList));
        Brazil.addAdjacencies(BrazilADJ);

        ArrayList<Territory> VenezuelaADJ = new ArrayList<Territory>();
        VenezuelaADJ.addAll(Arrays.asList(venezuelaList));
        Venezuela.addAdjacencies(VenezuelaADJ);

        ArrayList<Territory> GreatBritianADJ = new ArrayList<Territory>();
        GreatBritianADJ.addAll(Arrays.asList(greatBritianList));
        GreatBritian.addAdjacencies(GreatBritianADJ);

        ArrayList<Territory> IcelandADJ = new ArrayList<Territory>();
        IcelandADJ.addAll(Arrays.asList(icelandList));
        Iceland.addAdjacencies(IcelandADJ);

        ArrayList<Territory> NorthernEuropeADJ = new ArrayList<Territory>();
        NorthernEuropeADJ.addAll(Arrays.asList(northernEuropeList));
        NorthernEurope.addAdjacencies(NorthernEuropeADJ);

        ArrayList<Territory> ScandinaviaADJ = new ArrayList<Territory>();
        ScandinaviaADJ.addAll(Arrays.asList(scandinaviaList));
        Scandinavia.addAdjacencies(ScandinaviaADJ);

        ArrayList<Territory> SouthernEuropeADJ = new ArrayList<Territory>();
        SouthernEuropeADJ.addAll(Arrays.asList(southernEuropeList));
        SouthernEurope.addAdjacencies(SouthernEuropeADJ);

        ArrayList<Territory> UkraineADJ = new ArrayList<Territory>();
        UkraineADJ.addAll(Arrays.asList(ukraineList));
        Ukraine.addAdjacencies(UkraineADJ);

        ArrayList<Territory> WesternEuropeADJ = new ArrayList<Territory>();
        WesternEuropeADJ.addAll(Arrays.asList(westernEuropeList));
        WesternEurope.addAdjacencies(WesternEuropeADJ);

        ArrayList<Territory> CongoADJ = new ArrayList<Territory>();
        CongoADJ.addAll(Arrays.asList(congoList));
        Congo.addAdjacencies(CongoADJ);

        ArrayList<Territory> EastAfricaADJ = new ArrayList<Territory>();
        EastAfricaADJ.addAll(Arrays.asList(eastAfricaList));
        EastAfrica.addAdjacencies(EastAfricaADJ);

        ArrayList<Territory> EgyptADJ = new ArrayList<Territory>();
        EgyptADJ.addAll(Arrays.asList(egyptList));
        Egypt.addAdjacencies(EgyptADJ);

        ArrayList<Territory> MadagascarADJ = new ArrayList<Territory>();
        MadagascarADJ.addAll(Arrays.asList(madagascarList));
        Madagascar.addAdjacencies(MadagascarADJ);

        ArrayList<Territory> NorthAfricaADJ = new ArrayList<Territory>();
        NorthAfricaADJ.addAll(Arrays.asList(northAfricaList));
        NorthAfrica.addAdjacencies(NorthAfricaADJ);

        ArrayList<Territory> SouthAfricaADJ = new ArrayList<Territory>();
        SouthAfricaADJ.addAll(Arrays.asList(southAfricaList));
        SouthAfrica.addAdjacencies(SouthAfricaADJ);

        ArrayList<Territory> AfghanistanADJ = new ArrayList<Territory>();
        AfghanistanADJ.addAll(Arrays.asList(afghanistanList));
        Afghanistan.addAdjacencies(AfghanistanADJ);

        ArrayList<Territory> ChinaADJ = new ArrayList<Territory>();
        ChinaADJ.addAll(Arrays.asList(chinaList));
        China.addAdjacencies(ChinaADJ);

        ArrayList<Territory> IndiaADJ = new ArrayList<Territory>();
        IndiaADJ.addAll(Arrays.asList(indiaList));
        India.addAdjacencies(IndiaADJ);

        ArrayList<Territory> IrkutskADJ = new ArrayList<Territory>();
        IrkutskADJ.addAll(Arrays.asList(irkutskList));
        Irkutsk.addAdjacencies(IrkutskADJ);

        ArrayList<Territory> JapanADJ = new ArrayList<Territory>();
        JapanADJ.addAll(Arrays.asList(japanList));
        Japan.addAdjacencies(JapanADJ);

        ArrayList<Territory> KamchatkaADJ = new ArrayList<Territory>();
        KamchatkaADJ.addAll(Arrays.asList(kamchatkaList));
        Kamchatka.addAdjacencies(KamchatkaADJ);

        ArrayList<Territory> MiddleEastADJ = new ArrayList<Territory>();
        MiddleEastADJ.addAll(Arrays.asList(middleEastList));
        MiddleEast.addAdjacencies(MiddleEastADJ);

        ArrayList<Territory> MongoliaADJ = new ArrayList<Territory>();
        MongoliaADJ.addAll(Arrays.asList(mongoliaList));
        Mongolia.addAdjacencies(MongoliaADJ);

        ArrayList<Territory> SiamADJ = new ArrayList<Territory>();
        SiamADJ.addAll(Arrays.asList(siamList));
        Siam.addAdjacencies(SiamADJ);

        ArrayList<Territory> SiberiaADJ = new ArrayList<Territory>();
        SiberiaADJ.addAll(Arrays.asList(siberiaList));
        Siberia.addAdjacencies(SiberiaADJ);

        ArrayList<Territory> UralADJ = new ArrayList<Territory>();
        UralADJ.addAll(Arrays.asList(uralList));
        Ural.addAdjacencies(UralADJ);

        ArrayList<Territory> YakutskADJ = new ArrayList<Territory>();
        YakutskADJ.addAll(Arrays.asList(yakutskList));
        Yakutsk.addAdjacencies(YakutskADJ);

        ArrayList<Territory> EasternAustraliaADJ = new ArrayList<Territory>();
        EasternAustraliaADJ.addAll(Arrays.asList(easternAustraliaList));
        EasternAustralia.addAdjacencies(EasternAustraliaADJ);

        ArrayList<Territory> IndonesiaADJ = new ArrayList<Territory>();
        IndonesiaADJ.addAll(Arrays.asList(indonesiaList));
        Indonesia.addAdjacencies(IndonesiaADJ);

        ArrayList<Territory> NewGuineaADJ = new ArrayList<Territory>();
        NewGuineaADJ.addAll(Arrays.asList(newGuineaList));
        NewGuinea.addAdjacencies(NewGuineaADJ);

        ArrayList<Territory> WesternAustraliaADJ = new ArrayList<Territory>();
        WesternAustraliaADJ.addAll(Arrays.asList(westernAustraliaList));
        WesternAustralia.addAdjacencies(WesternAustraliaADJ);

        // Adding territories to container for main game
        territoryContainer.put(Alaska.getName(), Alaska);
        territoryList.add(Alaska);
        territoryContainer.put(Alberta.getName(), Alberta);
        territoryList.add(Alberta);
        territoryContainer.put(CentralAmerica.getName(), CentralAmerica);
        territoryList.add(CentralAmerica);
        territoryContainer.put(EasternUnitedStates.getName(), EasternUnitedStates);
        territoryList.add(EasternUnitedStates);
        territoryContainer.put(Greenland.getName(), Greenland);
        territoryList.add(Greenland);
        territoryContainer.put(NorthwestTerritory.getName(), NorthwestTerritory);
        territoryList.add(NorthwestTerritory);
        territoryContainer.put(Ontario.getName(), Ontario);
        territoryList.add(Ontario);
        territoryContainer.put(Quebec.getName(), Quebec);
        territoryList.add(Quebec);
        territoryContainer.put(WesternUnitedStates.getName(), WesternUnitedStates);
        territoryList.add(WesternUnitedStates);
        territoryContainer.put(Argentina.getName(), Argentina);
        territoryList.add(Argentina);
        territoryContainer.put(Brazil.getName(), Brazil);
        territoryList.add(Brazil);
        territoryContainer.put(Peru.getName(), Peru);
        territoryList.add(Peru);
        territoryContainer.put(Venezuela.getName(), Venezuela);
        territoryList.add(Venezuela);
        territoryContainer.put(GreatBritian.getName(), GreatBritian);
        territoryList.add(GreatBritian);
        territoryContainer.put(Iceland.getName(), Iceland);
        territoryList.add(Iceland);
        territoryContainer.put(NorthernEurope.getName(), NorthernEurope);
        territoryList.add(NorthernEurope);
        territoryContainer.put(Scandinavia.getName(), Scandinavia);
        territoryList.add(Scandinavia);
        territoryContainer.put(SouthernEurope.getName(), SouthernEurope);
        territoryList.add(SouthernEurope);
        territoryContainer.put(Ukraine.getName(), Ukraine);
        territoryList.add(Ukraine);
        territoryContainer.put(WesternEurope.getName(), WesternEurope);
        territoryList.add(WesternEurope);
        territoryContainer.put(Congo.getName(), Congo);
        territoryList.add(Congo);
        territoryContainer.put(EastAfrica.getName(), EastAfrica);
        territoryList.add(EastAfrica);
        territoryContainer.put(Egypt.getName(), Egypt);
        territoryList.add(Egypt);
        territoryContainer.put(Madagascar.getName(), Madagascar);
        territoryList.add(Madagascar);
        territoryContainer.put(NorthAfrica.getName(), NorthAfrica);
        territoryList.add(NorthAfrica);
        territoryContainer.put(SouthAfrica.getName(), SouthAfrica);
        territoryList.add(SouthAfrica);
        territoryContainer.put(Afghanistan.getName(), Afghanistan);
        territoryList.add(Afghanistan);
        territoryContainer.put(China.getName(), China);
        territoryList.add(China);
        territoryContainer.put(India.getName(), India);
        territoryList.add(India);
        territoryContainer.put(Irkutsk.getName(), Irkutsk);
        territoryList.add(Irkutsk);
        territoryContainer.put(Japan.getName(), Japan);
        territoryList.add(Japan);
        territoryContainer.put(Kamchatka.getName(), Kamchatka);
        territoryList.add(Kamchatka);
        territoryContainer.put(MiddleEast.getName(), MiddleEast);
        territoryList.add(MiddleEast);
        territoryContainer.put(Mongolia.getName(), Mongolia);
        territoryList.add(Mongolia);
        territoryContainer.put(Siam.getName(), Siam);
        territoryList.add(Siam);
        territoryContainer.put(Siberia.getName(), Siberia);
        territoryList.add(Siberia);
        territoryContainer.put(Ural.getName(), Ural);
        territoryList.add(Ural);
        territoryContainer.put(Yakutsk.getName(), Yakutsk);
        territoryList.add(Yakutsk);
        territoryContainer.put(EasternAustralia.getName(), EasternAustralia);
        territoryList.add(EasternAustralia);
        territoryContainer.put(Indonesia.getName(), Indonesia);
        territoryList.add(Indonesia);
        territoryContainer.put(NewGuinea.getName(), NewGuinea);
        territoryList.add(NewGuinea);
        territoryContainer.put(WesternAustralia.getName(), WesternAustralia);
        territoryList.add(WesternAustralia);


        // Creating ArrayLists for Continent Parameters
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


        ArrayList<Territory> southAmericaList = new ArrayList<Territory>();
        southAmericaList.add(Venezuela);
        southAmericaList.add(Peru);
        southAmericaList.add(Brazil);
        southAmericaList.add(Argentina);


        ArrayList<Territory> europeList = new ArrayList<Territory>();
        europeList.add(GreatBritian);
        europeList.add(Iceland);
        europeList.add(NorthernEurope);
        europeList.add(Scandinavia);
        europeList.add(SouthernEurope);
        europeList.add(Ukraine);
        europeList.add(WesternEurope);


        ArrayList<Territory> africaList = new ArrayList<Territory>();
        africaList.add(Congo);
        africaList.add(EastAfrica);
        africaList.add(Egypt);
        africaList.add(Madagascar);
        africaList.add(NorthAfrica);
        africaList.add(SouthAfrica);


        ArrayList<Territory> asiaList = new ArrayList<Territory>();
        asiaList.add(Afghanistan);
        asiaList.add(China);
        asiaList.add(India);
        asiaList.add(Irkutsk);
        asiaList.add(Japan);
        asiaList.add(Kamchatka);
        asiaList.add(MiddleEast);
        asiaList.add(Mongolia);
        asiaList.add(Siam);
        asiaList.add(Siberia);
        asiaList.add(Ural);
        asiaList.add(Yakutsk);


        ArrayList<Territory> australiaList = new ArrayList<Territory>();
        australiaList.add(EasternAustralia);
        australiaList.add(Indonesia);
        australiaList.add(NewGuinea);
        australiaList.add(WesternAustralia);


        // Spawn Continents
        Continent NorthAmerica = new Continent("North America", 5, northAmericaList);
        Continent SouthAmerica = new Continent("South America", 2, southAmericaList);
        Continent Europe = new Continent("Europe", 5, europeList);
        Continent Africa = new Continent("Africa", 3, africaList);
        Continent Asia = new Continent("Asia", 7, asiaList);
        Continent Australia = new Continent("Australia", 2, australiaList);

        // Adding continents to container for main game
        continentsContainer.put("North America", NorthAmerica);
        continentsContainer.put("South America", NorthAmerica);
        continentsContainer.put("Europe", NorthAmerica);
        continentsContainer.put("Africa", NorthAmerica);
        continentsContainer.put("Asia", NorthAmerica);
        continentsContainer.put("Australia", NorthAmerica);

    }

    /**
     * Returns all continents currently spawned on the board (should be every continent)
     * @return Board's HashMap of continents
     * @see Board
     */
    public ArrayList<Continent> getContinents() {
        return new ArrayList<Continent>(continentsContainer.values());
    }


    /**
     * Returns the continent specified (queries HashMap by String)
     * @param continentName String name of continent to query
     * @return Continent specified by continentName
     * @see Board
     */
    public Continent getContinentName(String continentName) {
        return continentsContainer.get(continentName);
    }


    /**
     * Returns amount of bonus armies from continent specified
     * @return Continent's bonus armies to add
     * @param continentName String name of continent to query for bonus armies
     * @see Board
     */
    public int getBonusArmies(String continentName) {
        return continentsContainer.get(continentName).getBonusArmyAmount();
    }


    /**
     * This will strictly be used to pass into the Deck constructor
     * @return An ArrayList of Territories spawned
     * @see Board
     * @see Deck
     */
    public ArrayList<Territory> getBoardTerritories(){
        return territoryList;
    }



    /**
     * Returns a list of territories in the specified continent
     * @param continentName The String name of the continent you want a list of territories from
     * @return Continent's bonus armies to add
     * @see Board
     */
    public ArrayList<Territory> getContainedTerritories(String continentName) {
        return continentsContainer.get(continentName).getTerritoriesOfContinent();
    }

    /**
     * Sets the number of armies for the Territory object on the board
     * @param territoryName The String name of the territory you want to modify the army power for
     * @param numberArmies The number of armies you want to add to the territory's army power
     * @see Board
     */
    public void setNumArmies(String territoryName, int numberArmies) {
        territoryContainer.get(territoryName).setNumArmies(numberArmies);
    }

    /**
     * Grabs the territory object by querying the HashMap with the String provided
     * @param territoryName The String name of the Territory object you want passed back to you
     * @return Returns the territory object queried by the String provided
     * @see Board
     */
    public Territory getTerritoryName(String territoryName) {
        return territoryContainer.get(territoryName);
    }


    /**
     * Sets the User provided as the controller of that territory in the Board HashMap
     * @param territoryName The String name of the Territory object you want passed back to you
     * @param occupant The User who you wish to set as the controller of the territory
     * @see Board
     */
    public void setUserOccupant(String territoryName, User occupant) {
        territoryContainer.get(territoryName).setOccupyingUser(occupant);
    }


    /**
     * Grabs the User by querying the HashMap with the String name provided
     * @param territoryName String name of the territory to query
     * @return Returns the controlling User of the territory object queried by the String provided
     * @see Board
     */
    public User getOccupant(String territoryName) {
        return territoryContainer.get(territoryName).getUser();
    }


    /**
     * Grabs the number of armies in the territory requested
     * @param territoryName The String name of the Territory whose army power you want
     * @return Returns the army power of the Territory requested
     * @see Board
     */
    public int getNumArmies(String territoryName) {
        return territoryContainer.get(territoryName).getArmyPower();
    }

    /**
     * Grabs the adjacencies of the Territory requested
     * @param territoryName The String name of the Territory whose adjacencies you want
     * @return Returns the Territory's adjacencies
     * @see Board
     */
    public ArrayList<Territory> getAdjacencies(String territoryName) {
        return territoryContainer.get(territoryName).getAdjacentTerritories();
    }

    /**
     * Undoes the User's fortify step
     * @param territory The territory of choice
     * @param armyAmount The amount of armies to take away
     * @see Board
     */
    public void undoFortify(String territory, int armyAmount){
        territoryContainer.get(territory).decrementArmies(armyAmount);
    }

    /**
     * Undoes the User's attack step
     * @param territory The territory of choice
     * @param armyAmount The amount of armies to add back
     * @see Board
     */
    public void undoAttack(String territory, int armyAmount){
        territoryContainer.get(territory).incrementArmies(armyAmount);
    }

    /**
     * Checks if the attacking territory is adjacent to the attacked territory
     * @param territory1 The String name of the Territory who is attacking
     * @param territory2 The String name of the Territory being attacked
     * @return Returns True if the two Territories are adjacent, false if they are not
     * @see Board
     */
    public boolean checkAdjacencies(String territory1, String territory2) {

        if (territoryContainer.get(territory1).getAdjacentTerritories().contains(territoryContainer.get(territory2))) {
            checkAdjacent = true;
        }

        else {
            checkAdjacent = false;
        }

        return checkAdjacent;
    }
}
