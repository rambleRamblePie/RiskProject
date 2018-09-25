import java.util.Scanner;
import java.util.*;
import java.io.PrintWriter;
import java.io.File;

public class Main {
    public static void main(String[] args) {
        User[] userList;
        Scanner sc = new Scanner(System.in);

        // Grab the number of players
        System.out.println("How many people are playing?");
        int numPlayers = sc.nextInt();
        sc.nextLine();

        // Grab the players names
        String[] playerNames = new String[numPlayers];
        for(int i=0; i<numPlayers; i++) {
            System.out.println("What is Player " + (i+1) + "'s name? The player who enters their name first will go first and so on");
            playerNames[i] = sc.nextLine();
        }

        // Array that will hold users
        userList = new User[numPlayers];

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

        // List Adjacencies to Store
        String[] alaskaList = new String[] {"Alberta", "NorthwestTerritory","Kamchatka"};
        String[] albertaList = new String[] {"Alaska", "NorthwestTerritory","NorthwestTerritory","Ontario","WesternUnitedStates"};
        String[] centralAmericaList = new String[] {"WesternUnitedStates","Venezuela"};
        String[] easternUSList = new String[] {"WesternUnitedStates","Ontario","Quebec"};
        String[] greenlandList = new String[] {"NorthwestTerritory","Ontario","Quebec","Iceland"};
        String[] northWestTerritoryList = new String[] {"Alaska","Greenland","Ontario","Alberta"};
        String[] ontarioList = new String[] {"NorthwestTerritory","Greenland","Quebec","EasternUnitedStates","WesternUnitedStates","Alberta"};
        String[] quebecList = new String[] {"Ontario","Greenland","EasternUnitedStates"};
        String[] westernUSList = new String[] {"Alberta","Ontario","EasternUnitedStates","CentralAmerica"};
        String[] argentinaList = new String[] {"Venezuela","Brazil"};
        String[] peruList = new String[] {"Argentina", "Brazil", "Venezuela"};
        String[] brazilList = new String[] {"Venezuela","NorthAfrica","Argentina"};
        String[] venezuelaList = new String[] {"CentralAmerica","Brazil","Argentina"};
        String[] greatBritianList = new String[] {"Iceland","Scandinavia","NorthernEurope","WesternEurope"};
        String[] icelandList = new String[] {"Greenland","GreatBritian"};
        String[] northernEuropeList = new String[] {"GreatBritian","Ukraine","SouthernEurope","WesternEurope"};
        String[] scandinaviaList = new String[] {"GreatBritian","Ukraine"};
        String[] southernEuropeList = new String[] {"WesternEurope","NorthernEurope","Ukraine","Egypt","NorthAfrica"};
        String[] ukraineList = new String[] {"Scandinavia","Ural","Afghanistan","MiddleEast","SouthernEurope","NorthernEurope"};
        String[] westernEuropeList = new String[] {"GreatBritian","NorthernEurope","SouthernEurope","NorthAfrica"};
        String[] congoList = new String[] {"NorthAfrica","Egypt","EastAfrica","SouthAfrica"};
        String[] eastAfricaList = new String[] {"Egypt","Madagascar","SouthAfrica","Congo"};
        String[] egyptList = new String[] {"SouthernEurope","MiddleEast","EastAfrica","Congo","NorthAfrica"};
        String[] madagascarList = new String[] {"EastAfrica","SouthAfrica"};
        String[] northAfricaList = new String[] {"WesternEurope","SouthernEurope","Egypt","Congo","Brazil"};
        String[] southAfricaList = new String[] {"Congo","EastAfrica","Madagascar"};
        String[] afghanistanList = new String[] {"Ukraine","Ural","Siberia","China","India","MiddleEast"};
        String[] chinaList = new String[] {"Afghanistan","Siberia","Mongolia","Siam","India"};
        String[] indiaList = new String[] {"MiddleEast","Afghanistan","China","Siam"};
        String[] irkutskList = new String[] {"Siberia","Yakutsk","Kamchatka","Mongolia"};
        String[] japanList = new String[] {"Kamchatka","Mongolia"};
        String[] kamchatkaList = new String[] {"Yakutsk","Alaska","Japan","Mongolia","Irkutsk"};
        String[] middleEastList = new String[] {"Ukraine","Afghanistan","India","Egypt"};
        String[] mongoliaList = new String[] {"Siberia","Irkutsk","Kamchatka","Japan","China"};
        String[] siamList = new String[] {"India","China","Indonesia"};
        String[] siberiaList = new String[] {"Ural","Yakutsk","Irkutsk","Mongolia","China","Afghanistan"};
        String[] uralList = new String[] {"Ukraine","Siberia","Afghanistan"};
        String[] yakutskList = new String[] {"Siberia","Kamchatka","Irkutsk"};
        String[] easternAustraliaList = new String[] {"NewGuinea","Peru","WesternAustralia"};
        String[] indonesiaList = new String[] {"Siam","NewGuinea","WesternAustralia"};
        String[] newGuineaList = new String[] {"Indonesia","EasternAustralia","WesternAustralia"};
        String[] westernAustraliaList = new String[] {"Indonesia","NewGuinea","EasternAustralia"};


        /** Spawn Adjacencies
         * Adjacencies takes the corresponding array above and converts it to a list stored in an ArrayList
         * The ArrayList will be stored in the coressponding territories adjacencies
        **/
        ArrayList<String> AlaskaADJ = new ArrayList<String>();
        AlaskaADJ.addAll(Arrays.asList(alaskaList));
        Alaska.addAdjacencies(AlaskaADJ);

        ArrayList<String> AlbertaADJ = new ArrayList<String>();
        AlbertaADJ.addAll(Arrays.asList(albertaList));
        Alberta.addAdjacencies(AlbertaADJ);

        ArrayList<String> CentralAmericaADJ = new ArrayList<String>();
        CentralAmericaADJ.addAll(Arrays.asList(centralAmericaList));
        CentralAmerica.addAdjacencies(CentralAmericaADJ);

        ArrayList<String> EasternUnitedStatesADJ = new ArrayList<String>();
        EasternUnitedStatesADJ.addAll(Arrays.asList(easternUSList));
        EasternUnitedStates.addAdjacencies(EasternUnitedStatesADJ);

        ArrayList<String> GreenlandADJ = new ArrayList<String>();
        GreenlandADJ.addAll(Arrays.asList(greenlandList));
        Greenland.addAdjacencies(GreenlandADJ);

        ArrayList<String> NorthwestTerritoryADJ = new ArrayList<String>();
        NorthwestTerritoryADJ.addAll(Arrays.asList(northWestTerritoryList));
        NorthwestTerritory.addAdjacencies(NorthwestTerritoryADJ);

        ArrayList<String> OntarioADJ = new ArrayList<String>();
        OntarioADJ.addAll(Arrays.asList(ontarioList));
        Ontario.addAdjacencies(OntarioADJ);

        ArrayList<String> QuebecADJ = new ArrayList<String>();
        QuebecADJ.addAll(Arrays.asList(quebecList));
        Quebec.addAdjacencies(QuebecADJ);

        ArrayList<String> WesternUnitedStatesADJ = new ArrayList<String>();
        WesternUnitedStatesADJ.addAll(Arrays.asList(westernUSList));
        WesternUnitedStates.addAdjacencies(WesternUnitedStatesADJ);

        ArrayList<String> ArgentinaADJ = new ArrayList<String>();
        ArgentinaADJ.addAll(Arrays.asList(argentinaList));
        Argentina.addAdjacencies(ArgentinaADJ);

        ArrayList<String> PeruADJ = new ArrayList<String>();
        PeruADJ.addAll(Arrays.asList(peruList));
        Peru.addAdjacencies(PeruADJ);

        ArrayList<String> BrazilADJ = new ArrayList<String>();
        AlaskaADJ.addAll(Arrays.asList(brazilList));
        Brazil.addAdjacencies(BrazilADJ);

        ArrayList<String> VenezuelaADJ = new ArrayList<String>();
        VenezuelaADJ.addAll(Arrays.asList(venezuelaList));
        Venezuela.addAdjacencies(VenezuelaADJ);

        ArrayList<String> GreatBritianADJ = new ArrayList<String>();
        GreatBritianADJ.addAll(Arrays.asList(greatBritianList));
        GreatBritian.addAdjacencies(GreatBritianADJ);

        ArrayList<String> IcelandADJ = new ArrayList<String>();
        IcelandADJ.addAll(Arrays.asList(icelandList));
        Iceland.addAdjacencies(IcelandADJ);

        ArrayList<String> NorthernEuropeADJ = new ArrayList<String>();
        NorthernEuropeADJ.addAll(Arrays.asList(northernEuropeList));
        NorthernEurope.addAdjacencies(NorthernEuropeADJ);

        ArrayList<String> ScandinaviaADJ = new ArrayList<String>();
        ScandinaviaADJ.addAll(Arrays.asList(scandinaviaList));
        Scandinavia.addAdjacencies(ScandinaviaADJ);

        ArrayList<String> SouthernEuropeADJ = new ArrayList<String>();
        SouthernEuropeADJ.addAll(Arrays.asList(southernEuropeList));
        SouthernEurope.addAdjacencies(SouthernEuropeADJ);

        ArrayList<String> UkraineADJ = new ArrayList<String>();
        UkraineADJ.addAll(Arrays.asList(ukraineList));
        Ukraine.addAdjacencies(UkraineADJ);

        ArrayList<String> WesternEuropeADJ = new ArrayList<String>();
        WesternEuropeADJ.addAll(Arrays.asList(westernEuropeList));
        WesternEurope.addAdjacencies(WesternEuropeADJ);

        ArrayList<String> CongoADJ = new ArrayList<String>();
        CongoADJ.addAll(Arrays.asList(congoList));
        Congo.addAdjacencies(CongoADJ);

        ArrayList<String> EastAfricaADJ = new ArrayList<String>();
        EastAfricaADJ.addAll(Arrays.asList(eastAfricaList));
        EastAfrica.addAdjacencies(EastAfricaADJ);

        ArrayList<String> EgyptADJ = new ArrayList<String>();
        EgyptADJ.addAll(Arrays.asList(egyptList));
        Egypt.addAdjacencies(EgyptADJ);

        ArrayList<String> MadagascarADJ = new ArrayList<String>();
        MadagascarADJ.addAll(Arrays.asList(madagascarList));
        Madagascar.addAdjacencies(MadagascarADJ);

        ArrayList<String> NorthAfricaADJ = new ArrayList<String>();
        NorthAfricaADJ.addAll(Arrays.asList(northAfricaList));
        NorthAfrica.addAdjacencies(NorthAfricaADJ);

        ArrayList<String> SouthAfricaADJ = new ArrayList<String>();
        SouthAfricaADJ.addAll(Arrays.asList(southAfricaList));
        SouthAfrica.addAdjacencies(SouthAfricaADJ);

        ArrayList<String> AfghanistanADJ = new ArrayList<String>();
        AfghanistanADJ.addAll(Arrays.asList(afghanistanList));
        Afghanistan.addAdjacencies(AfghanistanADJ);

        ArrayList<String> ChinaADJ = new ArrayList<String>();
        ChinaADJ.addAll(Arrays.asList(chinaList));
        China.addAdjacencies(ChinaADJ);

        ArrayList<String> IndiaADJ = new ArrayList<String>();
        IndiaADJ.addAll(Arrays.asList(indiaList));
        India.addAdjacencies(IndiaADJ);

        ArrayList<String> IrkutskADJ = new ArrayList<String>();
        IrkutskADJ.addAll(Arrays.asList(irkutskList));
        Irkutsk.addAdjacencies(IrkutskADJ);

        ArrayList<String> JapanADJ = new ArrayList<String>();
        JapanADJ.addAll(Arrays.asList(japanList));
        Japan.addAdjacencies(JapanADJ);

        ArrayList<String> KamchatkaADJ = new ArrayList<String>();
        KamchatkaADJ.addAll(Arrays.asList(kamchatkaList));
        Kamchatka.addAdjacencies(KamchatkaADJ);

        ArrayList<String> MiddleEastADJ = new ArrayList<String>();
        MiddleEastADJ.addAll(Arrays.asList(middleEastList));
        MiddleEast.addAdjacencies(MiddleEastADJ);

        ArrayList<String> MongoliaADJ = new ArrayList<String>();
        MongoliaADJ.addAll(Arrays.asList(mongoliaList));
        Mongolia.addAdjacencies(MongoliaADJ);

        ArrayList<String> SiamADJ = new ArrayList<String>();
        SiamADJ.addAll(Arrays.asList(siamList));
        Siam.addAdjacencies(SiamADJ);

        ArrayList<String> SiberiaADJ = new ArrayList<String>();
        SiberiaADJ.addAll(Arrays.asList(siberiaList));
        Siberia.addAdjacencies(SiberiaADJ);

        ArrayList<String> UralADJ = new ArrayList<String>();
        UralADJ.addAll(Arrays.asList(uralList));
        Ural.addAdjacencies(UralADJ);

        ArrayList<String> YakutskADJ = new ArrayList<String>();
        YakutskADJ.addAll(Arrays.asList(yakutskList));
        Yakutsk.addAdjacencies(YakutskADJ);

        ArrayList<String> EasternAustraliaADJ = new ArrayList<String>();
        EasternAustraliaADJ.addAll(Arrays.asList(easternAustraliaList));
        EasternAustralia.addAdjacencies(EasternAustraliaADJ);

        ArrayList<String> IndonesiaADJ = new ArrayList<String>();
        IndonesiaADJ.addAll(Arrays.asList(indonesiaList));
        Indonesia.addAdjacencies(IndonesiaADJ);

        ArrayList<String> NewGuineaADJ = new ArrayList<String>();
        NewGuineaADJ.addAll(Arrays.asList(newGuineaList));
        NewGuinea.addAdjacencies(NewGuineaADJ);

        ArrayList<String> WesternAustraliaADJ = new ArrayList<String>();
        WesternAustraliaADJ.addAll(Arrays.asList(westernAustraliaList));
        WesternAustralia.addAdjacencies(WesternAustraliaADJ);

        // Testing Adjacencies
        System.out.println(Alaska.getAdjacentTerritories());
        System.out.println(India.getAdjacentTerritories());
        System.out.println(Ukraine.getAdjacentTerritories());


        // Set Starting Army Power Here
        int startingArmyPowerPerPlayer = 0;

        // possible counter since I may automatically distribute 1 army to each territory at setup, per game rules
        int armiesAlreadyDistributedOne = 0; // territories will be split unevenly in some cases, this is the first counter
        int armiesAlreadyDistributedTwo = 0; // second counter
        switch(numPlayers) {
            case 2:
                startingArmyPowerPerPlayer = 40;
                armiesAlreadyDistributedOne = 21;
                break;
            case 3:
                startingArmyPowerPerPlayer = 35;
                armiesAlreadyDistributedOne = 14;
                break;
            case 4:
                startingArmyPowerPerPlayer = 30;
                armiesAlreadyDistributedOne = 11;
                armiesAlreadyDistributedTwo = 10;
                break;
            case 5:
                startingArmyPowerPerPlayer = 25;
                armiesAlreadyDistributedOne = 9;
                armiesAlreadyDistributedTwo = 8;
                break;
            case 6:
                startingArmyPowerPerPlayer = 20;
                armiesAlreadyDistributedOne = 6;
                break;
            default: // throw invalid input error (because nPlayers should already be checked in the calling function)
        }
        
        GameSetup game = new GameSetup(numPlayers, playerNames);
		World world = game.getWorld();
		// game.playGame(); or create another class to actually handle the game

        /*
        for(int i = 0; i < numPlayers; i++) {
            userList[i] = new User(playerNames[i], startingArmyPowerPerPlayer);
        }
        */

        // Creating ArrayLists for Continent Parameters
        ArrayList<String> northAmericaList = new ArrayList<String>();
        northAmericaList.add("Alaska");
        northAmericaList.add("Alberta");
        northAmericaList.add("CentralAmerica");
        northAmericaList.add("EasternUnitedStates");
        northAmericaList.add("Greenland");
        northAmericaList.add("NorthwestTerritory");
        northAmericaList.add("Ontario");
        northAmericaList.add("Quebec");
        northAmericaList.add("WesternUnitedStates");


        ArrayList<String> southAmericaList = new ArrayList<String>();
        southAmericaList.add("Venezuela");
        southAmericaList.add("Peru");
        southAmericaList.add("Brazil");
        southAmericaList.add("Argentina");


        ArrayList<String> europeList = new ArrayList<String>();
        europeList.add("GreatBritain");
        europeList.add("Iceland");
        europeList.add("NorthernEurope");
        europeList.add("Scandinavia");
        europeList.add("SouthernEurope");
        europeList.add("Ukraine");
        europeList.add("WesternEurope");


        ArrayList<String> africaList = new ArrayList<String>();
        africaList.add("Congo");
        africaList.add("EastAfrica");
        africaList.add("Egypt");
        africaList.add("Madagascar");
        africaList.add("NorthAfrica");
        africaList.add("SouthAfrica");


        ArrayList<String> asiaList = new ArrayList<String>();
        asiaList.add("Afghanistan");
        asiaList.add("China");
        asiaList.add("India");
        asiaList.add("Irkutsk");
        asiaList.add("Japan");
        asiaList.add("Kamchatka");
        asiaList.add("MiddleEast");
        asiaList.add("Mongolia");
        asiaList.add("Siam");
        asiaList.add("Siberia");
        asiaList.add("Ural");
        asiaList.add("Yakutsk");


        ArrayList<String> australiaList = new ArrayList<String>();
        australiaList.add("EasternAustralia");
        australiaList.add("Indonesia");
        australiaList.add("NewGuinea");
        australiaList.add("WesternAustralia");


        // Spawn Continents
        Continent NorthAmerica = new Continent("NorthAmerica", 5, northAmericaList);
        Continent SouthAmerica = new Continent("SouthAmerica", 2, southAmericaList);
        Continent Europe = new Continent("Europe", 5, europeList);
        Continent Africa = new Continent("Africa", 3, africaList);
        Continent Asia = new Continent("Asia", 7, asiaList);
        Continent Australia = new Continent("Australia", 2, australiaList);

        // Testing Purposes
        System.out.println(Australia.getName());
        System.out.println(NorthAmerica.getBonusArmyAmount());
        System.out.println(Europe.getTerritoriesOfContinent());


        // If loop to divide up territories based on number of players, will use HashMap for Users
        // Will look into iterating through HashMap to setOccupyingUser for each when spawning
        if(numPlayers == 2)
        {
            // Add player 1's countries to HashMap
            userList[0] = new User(playerNames[0], startingArmyPowerPerPlayer);

            // Setting occupant
            Alaska.setOccupyingUser(userList[0]);
            NorthwestTerritory.setOccupyingUser(userList[0]);
            Greenland.setOccupyingUser(userList[0]);
            Alberta.setOccupyingUser(userList[0]);
            Ontario.setOccupyingUser(userList[0]);
            Venezuela.setOccupyingUser(userList[0]);
            Brazil.setOccupyingUser(userList[0]);
            NorthAfrica.setOccupyingUser(userList[0]);
            Egypt.setOccupyingUser(userList[0]);
            EastAfrica.setOccupyingUser(userList[0]);
            NorthernEurope.setOccupyingUser(userList[0]);
            SouthernEurope.setOccupyingUser(userList[0]);
            WesternEurope.setOccupyingUser(userList[0]);
            Indonesia.setOccupyingUser(userList[0]);
            NewGuinea.setOccupyingUser(userList[0]);
            WesternAustralia.setOccupyingUser(userList[0]);
            Siam.setOccupyingUser(userList[0]);
            India.setOccupyingUser(userList[0]);
            China.setOccupyingUser(userList[0]);
            Mongolia.setOccupyingUser(userList[0]);
            Peru.setOccupyingUser(userList[0]);

            userList[0].addTerritory(Alaska);
            userList[0].addTerritory(NorthwestTerritory);
            userList[0].addTerritory(Greenland);
            userList[0].addTerritory(Alberta);
            userList[0].addTerritory(Ontario);
            userList[0].addTerritory(Venezuela);
            userList[0].addTerritory(Brazil);
            userList[0].addTerritory(NorthAfrica);
            userList[0].addTerritory(Egypt);
            userList[0].addTerritory(EastAfrica);
            userList[0].addTerritory(NorthernEurope);
            userList[0].addTerritory(SouthernEurope);
            userList[0].addTerritory(WesternEurope);
            userList[0].addTerritory(Indonesia);
            userList[0].addTerritory(NewGuinea);
            userList[0].addTerritory(WesternAustralia);
            userList[0].addTerritory(Siam);
            userList[0].addTerritory(India);
            userList[0].addTerritory(China);
            userList[0].addTerritory(Mongolia);
            userList[0].addTerritory(Peru);

            // Add player 2's countries to HashMap
            userList[1] = new User(playerNames[1], startingArmyPowerPerPlayer);

            // Setting occupant
            Quebec.setOccupyingUser(userList[1]);
            WesternUnitedStates.setOccupyingUser(userList[1]);
            EasternUnitedStates.setOccupyingUser(userList[1]);
            CentralAmerica.setOccupyingUser(userList[1]);
            Argentina.setOccupyingUser(userList[1]);
            Congo.setOccupyingUser(userList[1]);
            SouthAfrica.setOccupyingUser(userList[1]);
            Madagascar.setOccupyingUser(userList[1]);
            Iceland.setOccupyingUser(userList[1]);
            Scandinavia.setOccupyingUser(userList[1]);
            Ukraine.setOccupyingUser(userList[1]);
            GreatBritian.setOccupyingUser(userList[1]);
            EasternAustralia.setOccupyingUser(userList[1]);
            Japan.setOccupyingUser(userList[1]);
            Irkutsk.setOccupyingUser(userList[1]);
            Yakutsk.setOccupyingUser(userList[1]);
            Kamchatka.setOccupyingUser(userList[1]);
            Siberia.setOccupyingUser(userList[1]);
            Afghanistan.setOccupyingUser(userList[1]);
            Ural.setOccupyingUser(userList[1]);
            MiddleEast.setOccupyingUser(userList[1]);

            userList[1].addTerritory(Quebec);
            userList[1].addTerritory(WesternUnitedStates);
            userList[1].addTerritory(EasternUnitedStates);
            userList[1].addTerritory(CentralAmerica);
            userList[1].addTerritory(Argentina);
            userList[1].addTerritory(Congo);
            userList[1].addTerritory(SouthAfrica);
            userList[1].addTerritory(Madagascar);
            userList[1].addTerritory(Iceland);
            userList[1].addTerritory(Scandinavia);
            userList[1].addTerritory(Ukraine);
            userList[1].addTerritory(GreatBritian);
            userList[1].addTerritory(EasternAustralia);
            userList[1].addTerritory(Japan);
            userList[1].addTerritory(Irkutsk);
            userList[1].addTerritory(Yakutsk);
            userList[1].addTerritory(Kamchatka);
            userList[1].addTerritory(Siberia);
            userList[1].addTerritory(Afghanistan);
            userList[1].addTerritory(Ural);
            userList[1].addTerritory(MiddleEast);
            userList[1].addTerritory(Quebec);

        }
        else if(numPlayers == 3)
        {
            // Add player 1's countries to HashMap
            userList[0] = new User(playerNames[0], startingArmyPowerPerPlayer);
            userList[0].addTerritory(Alaska);
            userList[0].addTerritory(NorthwestTerritory);
            userList[0].addTerritory(Greenland);
            userList[0].addTerritory(Alberta);
            userList[0].addTerritory(Ontario);
            userList[0].addTerritory(Venezuela);
            userList[0].addTerritory(Brazil);
            userList[0].addTerritory(Irkutsk);
            userList[0].addTerritory(Yakutsk);
            userList[0].addTerritory(Kamchatka);
            userList[0].addTerritory(Siberia);
            userList[0].addTerritory(Afghanistan);
            userList[0].addTerritory(Ural);
            userList[0].addTerritory(MiddleEast);

            // Add player 2's countries to HashMap
            userList[1] = new User(playerNames[1], startingArmyPowerPerPlayer);
            userList[1].addTerritory(Quebec);
            userList[1].addTerritory(WesternUnitedStates);
            userList[1].addTerritory(EasternUnitedStates);
            userList[1].addTerritory(CentralAmerica);
            userList[1].addTerritory(Argentina);
            userList[1].addTerritory(Congo);
            userList[1].addTerritory(SouthAfrica);
            userList[1].addTerritory(Madagascar);
            userList[1].addTerritory(Iceland);
            userList[1].addTerritory(Scandinavia);
            userList[1].addTerritory(Ukraine);
            userList[1].addTerritory(GreatBritian);
            userList[1].addTerritory(EasternAustralia);
            userList[1].addTerritory(Japan);

            // Add player 3's countries to HashMap
            userList[2] = new User(playerNames[2], startingArmyPowerPerPlayer);
            userList[2].addTerritory(NorthAfrica);
            userList[2].addTerritory(Egypt);
            userList[2].addTerritory(EastAfrica);
            userList[2].addTerritory(NorthernEurope);
            userList[2].addTerritory(SouthernEurope);
            userList[2].addTerritory(WesternEurope);
            userList[2].addTerritory(Indonesia);
            userList[2].addTerritory(NewGuinea);
            userList[2].addTerritory(WesternAustralia);
            userList[2].addTerritory(Siam);
            userList[2].addTerritory(India);
            userList[2].addTerritory(China);
            userList[2].addTerritory(Mongolia);
            userList[2].addTerritory(Peru);

        }
        else if(numPlayers == 4)
        {
            // Add player 1's countries to HashMap
            userList[0] = new User(playerNames[0], startingArmyPowerPerPlayer);
            userList[0].addTerritory(Alaska);
            userList[0].addTerritory(NorthwestTerritory);
            userList[0].addTerritory(Greenland);
            userList[0].addTerritory(Alberta);
            userList[0].addTerritory(Madagascar);
            userList[0].addTerritory(Iceland );
            userList[0].addTerritory(Scandinavia);
            userList[0].addTerritory(Ukraine);
            userList[0].addTerritory(Japan);
            userList[0].addTerritory(Irkutsk);
            userList[0].addTerritory(EasternUnitedStates);

            // Add player 2's countries to HashMap
            userList[1] = new User(playerNames[1], startingArmyPowerPerPlayer);
            userList[1].addTerritory(NorthernEurope);
            userList[1].addTerritory(SouthernEurope);
            userList[1].addTerritory(WesternEurope);
            userList[1].addTerritory(Indonesia);
            userList[1].addTerritory(SouthAfrica);
            userList[1].addTerritory(GreatBritian);
            userList[1].addTerritory(EasternAustralia);
            userList[1].addTerritory(Yakutsk);
            userList[1].addTerritory(Afghanistan);
            userList[1].addTerritory(Ural);
            userList[1].addTerritory(MiddleEast);

            // Add player 3's countries to HashMap
            userList[2] = new User(playerNames[2], startingArmyPowerPerPlayer);
            userList[2].addTerritory(Ontario);
            userList[2].addTerritory(Venezuela);
            userList[2].addTerritory(Brazil);
            userList[2].addTerritory(NorthAfrica);
            userList[2].addTerritory(Egypt);
            userList[2].addTerritory(EastAfrica);
            userList[2].addTerritory(Argentina);
            userList[2].addTerritory(Congo);
            userList[2].addTerritory(Kamchatka);
            userList[2].addTerritory(Siberia);

            // Add player 4's countries to HashMap
            userList[3] = new User(playerNames[3], startingArmyPowerPerPlayer);
            userList[3].addTerritory(NewGuinea);
            userList[3].addTerritory(WesternAustralia);
            userList[3].addTerritory(Siam);
            userList[3].addTerritory(India);
            userList[3].addTerritory(China);
            userList[3].addTerritory(Mongolia);
            userList[3].addTerritory(Peru);
            userList[3].addTerritory(Quebec);
            userList[3].addTerritory(WesternUnitedStates);
            userList[3].addTerritory(CentralAmerica);

        }
        else if(numPlayers == 5)
        {
            // Add player 1's countries to HashMap
            userList[0] = new User(playerNames[0], startingArmyPowerPerPlayer);
            userList[0].addTerritory(Alaska);
            userList[0].addTerritory(NorthwestTerritory);
            userList[0].addTerritory(Greenland);
            userList[0].addTerritory(Alberta);
            userList[0].addTerritory(Madagascar);
            userList[0].addTerritory(Iceland);
            userList[0].addTerritory(Scandinavia);
            userList[0].addTerritory(Ukraine);
            userList[0].addTerritory(Japan);

            // Add player 2's countries to HashMap
            userList[1] = new User(playerNames[1], startingArmyPowerPerPlayer);
            userList[1].addTerritory(Irkutsk);
            userList[1].addTerritory(EasternUnitedStates);
            userList[1].addTerritory(NorthernEurope);
            userList[1].addTerritory(SouthernEurope);
            userList[1].addTerritory(WesternEurope);
            userList[1].addTerritory(Indonesia);
            userList[1].addTerritory(SouthAfrica);
            userList[1].addTerritory(GreatBritian);
            userList[1].addTerritory(EasternAustralia);

            // Add player 3's countries to HashMap
            userList[2] = new User(playerNames[2], startingArmyPowerPerPlayer);
            userList[2].addTerritory(Yakutsk);
            userList[2].addTerritory(Afghanistan);
            userList[2].addTerritory(Ural);
            userList[2].addTerritory(MiddleEast);
            userList[2].addTerritory(Ontario);
            userList[2].addTerritory(Venezuela);
            userList[2].addTerritory(Brazil);
            userList[2].addTerritory(NorthAfrica);

            // Add player 4's countries to HashMap
            userList[3] = new User(playerNames[3], startingArmyPowerPerPlayer);
            userList[3].addTerritory(Egypt);
            userList[3].addTerritory(EastAfrica);
            userList[3].addTerritory(Argentina);
            userList[3].addTerritory(Congo);
            userList[3].addTerritory(Kamchatka);
            userList[3].addTerritory(Siberia);
            userList[3].addTerritory(NewGuinea);
            userList[3].addTerritory(WesternAustralia);


            // Add player 5's countries to HashMap
            userList[4] = new User(playerNames[4], startingArmyPowerPerPlayer);
            userList[4].addTerritory(Siam);
            userList[4].addTerritory(India);
            userList[4].addTerritory(China);
            userList[4].addTerritory(Mongolia);
            userList[4].addTerritory(Peru);
            userList[4].addTerritory(Quebec);
            userList[4].addTerritory(WesternUnitedStates);
            userList[4].addTerritory(CentralAmerica);
        }
        else // Number of Players is 6
        {
            // Add player 1's countries to HashMap
            userList[0] = new User(playerNames[0], startingArmyPowerPerPlayer);
            userList[0].addTerritory(Alaska);
            userList[0].addTerritory(NorthwestTerritory);
            userList[0].addTerritory(Greenland);
            userList[0].addTerritory(Alberta);
            userList[0].addTerritory(Ontario);
            userList[0].addTerritory(Venezuela);
            userList[0].addTerritory(Brazil);

            // Add player 2's countries to HashMap
            userList[1] = new User(playerNames[1], startingArmyPowerPerPlayer);
            userList[1].addTerritory(NorthAfrica);
            userList[1].addTerritory(Egypt);
            userList[1].addTerritory(EastAfrica);
            userList[1].addTerritory(NorthernEurope);
            userList[1].addTerritory(SouthernEurope);
            userList[1].addTerritory(WesternEurope);
            userList[1].addTerritory(Indonesia);

            // Add player 3's countries to HashMap
            userList[2] = new User(playerNames[2], startingArmyPowerPerPlayer);
            userList[2].addTerritory(NewGuinea);
            userList[2].addTerritory(WesternAustralia);
            userList[2].addTerritory(Siam);
            userList[2].addTerritory(India);
            userList[2].addTerritory(China);
            userList[2].addTerritory(Mongolia);
            userList[2].addTerritory(Peru);

            // Add player 4's countries to HashMap
            userList[3] = new User(playerNames[3], startingArmyPowerPerPlayer);
            Quebec.setOccupyingUser(userList[3]);
            WesternUnitedStates.setOccupyingUser(userList[3]);
            EasternUnitedStates.setOccupyingUser(userList[3]);
            CentralAmerica.setOccupyingUser(userList[3]);
            Argentina.setOccupyingUser(userList[3]);
            Congo.setOccupyingUser(userList[3]);
            SouthAfrica.setOccupyingUser(userList[3]);
            userList[3].addTerritory(Quebec);
            userList[3].addTerritory(WesternUnitedStates);
            userList[3].addTerritory(EasternUnitedStates);
            userList[3].addTerritory(CentralAmerica);
            userList[3].addTerritory(Argentina);
            userList[3].addTerritory(Congo);
            userList[3].addTerritory(SouthAfrica);

            // Add player 5's countries to HashMap
            userList[4] = new User(playerNames[4], startingArmyPowerPerPlayer);
            userList[4].addTerritory(Madagascar);
            userList[4].addTerritory(Iceland);
            userList[4].addTerritory(Scandinavia);
            userList[4].addTerritory(Ukraine);
            userList[4].addTerritory(GreatBritian);
            userList[4].addTerritory(EasternAustralia);
            userList[4].addTerritory(Japan);

            // Add player 6's countries to HashMap
            userList[5] = new User(playerNames[5], startingArmyPowerPerPlayer);
            userList[5].addTerritory(Irkutsk);
            userList[5].addTerritory(Yakutsk);
            userList[5].addTerritory(Kamchatka);
            userList[5].addTerritory(Siberia);
            userList[5].addTerritory(Afghanistan);
            userList[5].addTerritory(Ural);
            userList[5].addTerritory(MiddleEast);
        }

        // More Testing
        System.out.println(userList[0].getUsername());


        // Game flag. Remove players from array who do not have territories. When one is left, he wins and game ends

        // WHEN TESTING ON INTELLIJ YOU MUST STOP THE PROGRAM MANUALLY AS THIS IS AN INFINITE LOOP RIGHT NOW
        while((userList.length) != 1)
        {
            // Loop through each players turn. They must attack for right now
            for(int i = 0; i < (userList.length); i++)
            {
                // Add card from deck to hand (ignoring for now)
                // Check if User has to turn in cards (ignoring for now)
                // Increment total armies (ignoring Continent Bonus for now)
                // Prompt to see where they want to place them
                // Increment that territory's army count
                // Prompt what territory they want to attack
                // Get that territory's name and player
                // Roll dice for each
                // Based on result, increment/decrement that country's armies
                // If country army total has 0 leftover, remove from defeated player's HashMap
                // Add that country to victor's HashMap
                // Decrement original country by 1 and add it to victor's new country
                // Check if current player's HashMap size is equal to 0
                // If it is equal to 0, remove them from userList
                // Shuffle main card deck
            }
        }

        System.out.println("Congratulations " + userList[0].getUsername() + " on winning the game of Risk!");

        //GameSetup game = new GameSetup(numPlayers, playerNames);
        // game.playGame(); or create another class to actually handle the game
        
    }
}
