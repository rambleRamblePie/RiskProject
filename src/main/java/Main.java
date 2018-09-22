import java.util.Scanner;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        User[] userList;
        Scanner sc = new Scanner(System.in);
        System.out.println("How many people are playing?");
        int numPlayers = sc.nextInt();
        sc.nextLine();
        //ArrayList<String> playerNames = new ArrayList<String>();
        String[] playerNames = new String[numPlayers];
        for(int i=0; i<numPlayers; i++) {
            System.out.println("What is player " + (i+1) + "'s name? The player who enters their name first will go first and so on");
            playerNames[i] = sc.nextLine();
        }
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
        Territory LotR = new Territory("LotR");
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
        String[] easternAustraliaList = new String[] {"NewGuinea","LotR","WesternAustralia"};
        String[] indonesiaList = new String[] {"Siam","NewGuinea","WesternAustralia"};
        String[] lotrList = new String[] {"EasternAustralia"};
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

        ArrayList<String> LotRADJ = new ArrayList<String>();
        LotRADJ.addAll(Arrays.asList(lotrList));
        LotR.addAdjacencies(LotRADJ);

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

        /*
        for(int i = 0; i < numPlayers; i++) {
            userList[i] = new User(playerNames[i], startingArmyPowerPerPlayer);
        }
        */

        // If loop to divide up territories based on number of players, will use HashMap for Users
        // Will look into iterating through HashMap to setOccupyingUser for each when spawning
        if(numPlayers == 2)
        {
            // Add player 1's countries to HashMap
            userList[0] = new User(playerNames[0], startingArmyPowerPerPlayer);
            userList[0].addCountry(Alaska);
            userList[0].addCountry(NorthwestTerritory);
            userList[0].addCountry(Greenland);
            userList[0].addCountry(Alberta);
            userList[0].addCountry(Ontario);
            userList[0].addCountry(Venezuela);
            userList[0].addCountry(Brazil);
            userList[0].addCountry(NorthAfrica);
            userList[0].addCountry(Egypt);
            userList[0].addCountry(EastAfrica);
            userList[0].addCountry(NorthernEurope);
            userList[0].addCountry(SouthernEurope);
            userList[0].addCountry(WesternEurope);
            userList[0].addCountry(Indonesia);
            userList[0].addCountry(NewGuinea);
            userList[0].addCountry(WesternAustralia);
            userList[0].addCountry(Siam);
            userList[0].addCountry(India);
            userList[0].addCountry(China);
            userList[0].addCountry(Mongolia);
            userList[0].addCountry(LotR);

            // Add player 2's countries to HashMap
            userList[1] = new User(playerNames[1], startingArmyPowerPerPlayer);
            userList[1].addCountry(Quebec);
            userList[1].addCountry(WesternUnitedStates);
            userList[1].addCountry(EasternUnitedStates);
            userList[1].addCountry(CentralAmerica);
            userList[1].addCountry(Argentina);
            userList[1].addCountry(Congo);
            userList[1].addCountry(SouthAfrica);
            userList[1].addCountry(Madagascar);
            userList[1].addCountry(Iceland);
            userList[1].addCountry(Scandinavia);
            userList[1].addCountry(Ukraine);
            userList[1].addCountry(GreatBritian);
            userList[1].addCountry(EasternAustralia);
            userList[1].addCountry(Japan);
            userList[1].addCountry(Irkutsk);
            userList[1].addCountry(Yakutsk);
            userList[1].addCountry(Kamchatka);
            userList[1].addCountry(Siberia);
            userList[1].addCountry(Afghanistan);
            userList[1].addCountry(Ural);
            userList[1].addCountry(MiddleEast);
            userList[1].addCountry(Quebec);

        }
        else if(numPlayers == 3)
        {
            userList[0] = new User(playerNames[0], startingArmyPowerPerPlayer);
            userList[0].addCountry(Alaska);
            userList[0].addCountry(NorthwestTerritory);
            userList[0].addCountry(Greenland);
            userList[0].addCountry(Alberta);
            userList[0].addCountry(Ontario);
            userList[0].addCountry(Venezuela);
            userList[0].addCountry(Brazil);
            userList[0].addCountry(Irkutsk);
            userList[0].addCountry(Yakutsk);
            userList[0].addCountry(Kamchatka);
            userList[0].addCountry(Siberia);
            userList[0].addCountry(Afghanistan);
            userList[0].addCountry(Ural);
            userList[0].addCountry(MiddleEast);

            userList[1] = new User(playerNames[1], startingArmyPowerPerPlayer);
            userList[1].addCountry(Quebec);
            userList[1].addCountry(WesternUnitedStates);
            userList[1].addCountry(EasternUnitedStates);
            userList[1].addCountry(CentralAmerica);
            userList[1].addCountry(Argentina);
            userList[1].addCountry(Congo);
            userList[1].addCountry(SouthAfrica);
            userList[1].addCountry(Madagascar);
            userList[1].addCountry(Iceland);
            userList[1].addCountry(Scandinavia);
            userList[1].addCountry(Ukraine);
            userList[1].addCountry(GreatBritian);
            userList[1].addCountry(EasternAustralia);
            userList[1].addCountry(Japan);

            userList[2] = new User(playerNames[2], startingArmyPowerPerPlayer);
            userList[2].addCountry(NorthAfrica);
            userList[2].addCountry(Egypt);
            userList[2].addCountry(EastAfrica);
            userList[2].addCountry(NorthernEurope);
            userList[2].addCountry(SouthernEurope);
            userList[2].addCountry(WesternEurope);
            userList[2].addCountry(Indonesia);
            userList[2].addCountry(NewGuinea);
            userList[2].addCountry(WesternAustralia);
            userList[2].addCountry(Siam);
            userList[2].addCountry(India);
            userList[2].addCountry(China);
            userList[2].addCountry(Mongolia);
            userList[2].addCountry(LotR);

        }
        else if(numPlayers == 4)
        {
            userList[0] = new User(playerNames[0], startingArmyPowerPerPlayer);
            userList[0].addCountry(Alaska);
            userList[0].addCountry(NorthwestTerritory);
            userList[0].addCountry(Greenland);
            userList[0].addCountry(Alberta);
            userList[0].addCountry(Madagascar);
            userList[0].addCountry(Iceland );
            userList[0].addCountry(Scandinavia);
            userList[0].addCountry(Ukraine);
            userList[0].addCountry(Japan);
            userList[0].addCountry(Irkutsk);
            userList[0].addCountry(EasternUnitedStates);


            userList[1] = new User(playerNames[1], startingArmyPowerPerPlayer);
            userList[1].addCountry(NorthernEurope);
            userList[1].addCountry(SouthernEurope);
            userList[1].addCountry(WesternEurope);
            userList[1].addCountry(Indonesia);
            userList[1].addCountry(SouthAfrica);
            userList[1].addCountry(GreatBritian);
            userList[1].addCountry(EasternAustralia);
            userList[1].addCountry(Yakutsk);
            userList[1].addCountry(Afghanistan);
            userList[1].addCountry(Ural);
            userList[1].addCountry(MiddleEast);


            userList[2] = new User(playerNames[2], startingArmyPowerPerPlayer);
            userList[2].addCountry(Ontario);
            userList[2].addCountry(Venezuela);
            userList[2].addCountry(Brazil);
            userList[2].addCountry(NorthAfrica);
            userList[2].addCountry(Egypt);
            userList[2].addCountry(EastAfrica);
            userList[2].addCountry(Argentina);
            userList[2].addCountry(Congo);
            userList[2].addCountry(Kamchatka);
            userList[2].addCountry(Siberia);


            userList[3] = new User(playerNames[3], startingArmyPowerPerPlayer);
            userList[3].addCountry(NewGuinea);
            userList[3].addCountry(WesternAustralia);
            userList[3].addCountry(Siam);
            userList[3].addCountry(India);
            userList[3].addCountry(China);
            userList[3].addCountry(Mongolia);
            userList[3].addCountry(LotR);
            userList[3].addCountry(Quebec);
            userList[3].addCountry(WesternUnitedStates);
            userList[3].addCountry(CentralAmerica);

        }
        else if(numPlayers == 5)
        {
            userList[0] = new User(playerNames[0], startingArmyPowerPerPlayer);
            userList[0].addCountry(Alaska);
            userList[0].addCountry(NorthwestTerritory);
            userList[0].addCountry(Greenland);
            userList[0].addCountry(Alberta);
            userList[0].addCountry(Madagascar);
            userList[0].addCountry(Iceland);
            userList[0].addCountry(Scandinavia);
            userList[0].addCountry(Ukraine);
            userList[0].addCountry(Japan);

            userList[1] = new User(playerNames[1], startingArmyPowerPerPlayer);
            userList[1].addCountry(Irkutsk);
            userList[1].addCountry(EasternUnitedStates);
            userList[1].addCountry(NorthernEurope);
            userList[1].addCountry(SouthernEurope);
            userList[1].addCountry(WesternEurope);
            userList[1].addCountry(Indonesia);
            userList[1].addCountry(SouthAfrica);
            userList[1].addCountry(GreatBritian);
            userList[1].addCountry(EasternAustralia);


            userList[2] = new User(playerNames[2], startingArmyPowerPerPlayer);
            userList[2].addCountry(Yakutsk);
            userList[2].addCountry(Afghanistan);
            userList[2].addCountry(Ural);
            userList[2].addCountry(MiddleEast);
            userList[2].addCountry(Ontario);
            userList[2].addCountry(Venezuela);
            userList[2].addCountry(Brazil);
            userList[2].addCountry(NorthAfrica);


            userList[3] = new User(playerNames[3], startingArmyPowerPerPlayer);
            userList[3].addCountry(Egypt);
            userList[3].addCountry(EastAfrica);
            userList[3].addCountry(Argentina);
            userList[3].addCountry(Congo);
            userList[3].addCountry(Kamchatka);
            userList[3].addCountry(Siberia);
            userList[3].addCountry(NewGuinea);
            userList[3].addCountry(WesternAustralia);



            userList[4] = new User(playerNames[4], startingArmyPowerPerPlayer);
            userList[4].addCountry(Siam);
            userList[4].addCountry(India);
            userList[4].addCountry(China);
            userList[4].addCountry(Mongolia);
            userList[4].addCountry(LotR);
            userList[4].addCountry(Quebec);
            userList[4].addCountry(WesternUnitedStates);
            userList[4].addCountry(CentralAmerica);
        }
        else // Number of Players is 6
        {
            userList[0] = new User(playerNames[0], startingArmyPowerPerPlayer);
            userList[0].addCountry(Alaska);
            userList[0].addCountry(NorthwestTerritory);
            userList[0].addCountry(Greenland);
            userList[0].addCountry(Alberta);
            userList[0].addCountry(Ontario);
            userList[0].addCountry(Venezuela);
            userList[0].addCountry(Brazil);

            userList[1] = new User(playerNames[1], startingArmyPowerPerPlayer);
            userList[1].addCountry(NorthAfrica);
            userList[1].addCountry(Egypt);
            userList[1].addCountry(EastAfrica);
            userList[1].addCountry(NorthernEurope);
            userList[1].addCountry(SouthernEurope);
            userList[1].addCountry(WesternEurope);
            userList[1].addCountry(Indonesia);

            userList[2] = new User(playerNames[2], startingArmyPowerPerPlayer);
            userList[2].addCountry(NewGuinea);
            userList[2].addCountry(WesternAustralia);
            userList[2].addCountry(Siam);
            userList[2].addCountry(India);
            userList[2].addCountry(China);
            userList[2].addCountry(Mongolia);
            userList[2].addCountry(LotR);

            userList[3] = new User(playerNames[3], startingArmyPowerPerPlayer);
            userList[3].addCountry(Quebec);
            userList[3].addCountry(WesternUnitedStates);
            userList[3].addCountry(EasternUnitedStates);
            userList[3].addCountry(CentralAmerica);
            userList[3].addCountry(Argentina);
            userList[3].addCountry(Congo);
            userList[3].addCountry(SouthAfrica);

            userList[4] = new User(playerNames[4], startingArmyPowerPerPlayer);
            userList[4].addCountry(Madagascar);
            userList[4].addCountry(Iceland);
            userList[4].addCountry(Scandinavia);
            userList[4].addCountry(Ukraine);
            userList[4].addCountry(GreatBritian);
            userList[4].addCountry(EasternAustralia);
            userList[4].addCountry(Japan);

            userList[5] = new User(playerNames[5], startingArmyPowerPerPlayer);
            userList[5].addCountry(Irkutsk);
            userList[5].addCountry(Yakutsk);
            userList[5].addCountry(Kamchatka);
            userList[5].addCountry(Siberia);
            userList[5].addCountry(Afghanistan);
            userList[5].addCountry(Ural);
            userList[5].addCountry(MiddleEast);
        }

        // Game flag. Remove players from array who do not have territories. When one is left, he wins and game ends

        // WHEN TESTING ON INTELLIJ YOU MUST STOP THE PROGRAM MANUALLY AS THIS IS AN INFINITE LOOP RIGHT NOW
        while((userList.length) != 1)
        {
            // Loop through each players turn. They must attack for right now
            for(int i = 0; i < (userList.length); i++)
            {
                // Add card from deck to hand (ignoring for now)
                // Check if User has to turn in cards
                // Increment total armies (ignoring Continent Bonus for now)
                // Prompt to see where they want to place them
                // Increment that territory's army count
                // Prompt what territory they want to attack
                // Get that territory's name and player
                // Roll dice for each
                // Based on result, increment/decrement that country's armies
                // If country army total has 0 leftover, remove from defeated player's HashMap
                // Add that country to victor's HashMap
                // Check if current player's HashMap size is equal to 0
                // If it is equal to 0, remove them from userList

                /* We will use a prompt to check if a user would like to undo an action, and not execute actions
                until user has selected 'No'. If they select 'Yes', we will proceed to ask again if they would
                like to do whatever action they are doing (perhaps sticking each action in a while loop.
                This will simulate an undo feature */
            }
        }

        System.out.println("Congratulations " + userList[0].getUsername() + " on winning the game of Risk!");

        //GameSetup game = new GameSetup(numPlayers, playerNames);
        // game.playGame(); or create another class to actually handle the game
    }
}
