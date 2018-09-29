import java.util.Scanner;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Arrays;

public class Board {

    private boolean checkAdjacent;
    private HashMap<String, Territory> territoryContainer;
    private HashMap<String, Continent> continentsContainer;

    public Board() {
        // May add things here later
    }

    public void setupBoard() {
        territoryContainer = new HashMap<String, Territory>();
        continentsContainer = new HashMap<String, Continent>();

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
        territoryContainer.put(Alberta.getName(), Alberta);
        territoryContainer.put(CentralAmerica.getName(), CentralAmerica);
        territoryContainer.put(EasternUnitedStates.getName(), EasternUnitedStates);
        territoryContainer.put(Greenland.getName(), Greenland);
        territoryContainer.put(NorthwestTerritory.getName(), NorthwestTerritory);
        territoryContainer.put(Ontario.getName(), Ontario);
        territoryContainer.put(Quebec.getName(), Quebec);
        territoryContainer.put(WesternUnitedStates.getName(), WesternUnitedStates);
        territoryContainer.put(Argentina.getName(), Argentina);
        territoryContainer.put(Brazil.getName(), Brazil);
        territoryContainer.put(Peru.getName(), Peru);
        territoryContainer.put(Venezuela.getName(), Venezuela);
        territoryContainer.put(GreatBritian.getName(), GreatBritian);
        territoryContainer.put(Iceland.getName(), Iceland);
        territoryContainer.put(NorthernEurope.getName(), NorthernEurope);
        territoryContainer.put(Scandinavia.getName(), Scandinavia);
        territoryContainer.put(SouthernEurope.getName(), SouthernEurope);
        territoryContainer.put(Ukraine.getName(), Ukraine);
        territoryContainer.put(WesternEurope.getName(), WesternEurope);
        territoryContainer.put(Congo.getName(), Congo);
        territoryContainer.put(EastAfrica.getName(), EastAfrica);
        territoryContainer.put(Egypt.getName(), Egypt);
        territoryContainer.put(Madagascar.getName(), Madagascar);
        territoryContainer.put(NorthAfrica.getName(), NorthAfrica);
        territoryContainer.put(SouthAfrica.getName(), SouthAfrica);
        territoryContainer.put(Afghanistan.getName(), Afghanistan);
        territoryContainer.put(China.getName(), China);
        territoryContainer.put(India.getName(), India);
        territoryContainer.put(Irkutsk.getName(), Irkutsk);
        territoryContainer.put(Japan.getName(), Japan);
        territoryContainer.put(Kamchatka.getName(), Kamchatka);
        territoryContainer.put(MiddleEast.getName(), MiddleEast);
        territoryContainer.put(Mongolia.getName(), Mongolia);
        territoryContainer.put(Siam.getName(), Siam);
        territoryContainer.put(Siberia.getName(), Siberia);
        territoryContainer.put(Ural.getName(), Ural);
        territoryContainer.put(Yakutsk.getName(), Yakutsk);
        territoryContainer.put(EasternAustralia.getName(), EasternAustralia);
        territoryContainer.put(Indonesia.getName(), Indonesia);
        territoryContainer.put(NewGuinea.getName(), NewGuinea);
        territoryContainer.put(WesternAustralia.getName(), WesternAustralia);


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

    public ArrayList<Continent> getContinents() {
        return new ArrayList<Continent>(continentsContainer.values());
    }


    // Returns the continent specified
    public Continent getContinentByName(String continentName) {
        return continentsContainer.get(continentName);
    }


    // Returns bonus army amount of continent
    public int getBonusArmies(String continentName) {
        return continentsContainer.get(continentName).getBonusArmyAmount();
    }



    // Returns a list of territories in continent
    public ArrayList<Territory> getContainedCountries(String continentName) {
        return continentsContainer.get(continentName).getTerritoriesOfContinent();
    }

    // Sets number of armies to specified territory to the integer provided
    public void setNumArmies(String territoryName, int numberArmies) {
        territoryContainer.get(territoryName).setNumArmies(numberArmies);
    }

    // Returns territory requested
    public Territory getCountryName(String territoryName) {
        return territoryContainer.get(territoryName);
    }


    // Sets the territory provided's occupant to the user provided
    public void setUserOccupant(String territoryName, User occupant) {
        territoryContainer.get(territoryName).setOccupyingUser(occupant);
    }


    // Returns controller of current territory
    public User getOccupant(String territoryName) {
        return territoryContainer.get(territoryName).getUser();
    }


    // Returns the number of armies in the requested territory
    public int getNumArmies(String territoryName) {
        return territoryContainer.get(territoryName).getArmyPower();
    }

    // Returns a list of adjacent territories
    public ArrayList<Territory> getAdjacencies(String territoryName) {
        return territoryContainer.get(territoryName).getAdjacentTerritories();
    }


     // Returns a list of adjacencies and checks it with the attacking country
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
