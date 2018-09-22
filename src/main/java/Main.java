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
        Territory GreatBritain = new Territory("GreatBritain");
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
        String[] icelandList = new String[] {"Greenland","GreatBritain"};
        String[] northernEuropeList = new String[] {"GreatBritain","Ukraine","SouthernEurope","WesternEurope"};
        String[] scandinaviaList = new String[] {"GreatBritain","Ukraine"};
        String[] southernEuropeList = new String[] {"WesternEurope","NorthernEurope","Ukraine","Egypt","NorthAfrica"};
        String[] ukraineList = new String[] {"Scandinavia","Ural","Afghanistan","MiddleEast","SouthernEurope","NorthernEurope"};
        String[] westernEuropeList = new String[] {"GreatBritain","NorthernEurope","SouthernEurope","NorthAfrica"};
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

        ArrayList<String> GreatBritainADJ = new ArrayList<String>();
        GreatBritainADJ.addAll(Arrays.asList(greatBritianList));
        GreatBritain.addAdjacencies(GreatBritainADJ);

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

        //Testing Adjacencies
        System.out.println(Alaska.getAdjacentTerritories());
        System.out.println(India.getAdjacentTerritories());
        System.out.println(Ukraine.getAdjacentTerritories());


        // Divide territories manually and set staring army total here
        int startingArmyPowerPerPlayer = 0;
        switch(numPlayers) {
            case 2:
                startingArmyPowerPerPlayer = 40;
                // Territory goes here
                break;
            case 3:
                startingArmyPowerPerPlayer = 35;
                break;
            case 4:
                startingArmyPowerPerPlayer = 30;
                break;
            case 5:
                startingArmyPowerPerPlayer = 25;
                break;
            case 6:
                startingArmyPowerPerPlayer = 20;
                break;
            default: // throw invalid input error (because nPlayers should already be checked in the calling function)
        }

        for(int i = 0; i < numPlayers; i++) {
            userList[i] = new User(playerNames[i], startingArmyPowerPerPlayer);
        }
        //GameSetup game = new GameSetup(numPlayers, playerNames);
        // game.playGame(); or create another class to actually handle the game
    }
}
