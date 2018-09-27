import java.util.Scanner;
import java.util.*;
import java.util.List;
import java.io.PrintWriter;
import java.io.File;

public class Main {
    public static void main(String[] args) {
        int controlledNum = 0;
        User[] userList;
        Scanner sc = new Scanner(System.in);

        // Grab the number of players
        int numPlayers = 7;
        while(numPlayers > 6 || numPlayers < 2)
        {
            System.out.println("How many people are playing? 2-6 Players are required");
            numPlayers = sc.nextInt();
            sc.nextLine();
        }

        // Grab the players names
        String[] playerNames = new String[numPlayers];
        System.out.println("Players will go in the order in which they enter their name!");
        System.out.println();
        for(int i=0; i<numPlayers; i++) {
            System.out.println("What is Player " + (i+1) + "'s name?");
            playerNames[i] = sc.nextLine();
        }

        // Array that will hold users
        userList = new User[numPlayers];

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

        Board board = new Board();
        board.setupBoard();

        // If loop to divide up territories based on number of players, will use HashMap for Users
        // Will look into iterating through HashMap to setOccupyingUser for each when spawning
        if(numPlayers == 2)
        {
            // Add player 1's countries to HashMap
            userList[0] = new User(playerNames[0], startingArmyPowerPerPlayer);
            userList[0].addTerritory(board.getCountryByName("Alaska"));
            board.setOccupant("Alaska", userList[0]);
            userList[0].addTerritory(board.getCountryByName("NorthwestTerritory"));
            board.setOccupant("NorthwestTerritory", userList[0]);
            userList[0].addTerritory(board.getCountryByName("Greenland"));
            board.setOccupant("Greenland", userList[0]);
            userList[0].addTerritory(board.getCountryByName("Alberta"));
            board.setOccupant("Alberta", userList[0]);
            userList[0].addTerritory(board.getCountryByName("Ontario"));
            board.setOccupant("Ontario", userList[0]);
            userList[0].addTerritory(board.getCountryByName("Venezuela"));
            board.setOccupant("Venezuela", userList[0]);
            userList[0].addTerritory(board.getCountryByName("MiddleEast"));
            board.setOccupant("MiddleEast", userList[0]);
            userList[0].addTerritory(board.getCountryByName("NorthAfrica"));
            board.setOccupant("NorthAfrica", userList[0]);
            userList[0].addTerritory(board.getCountryByName("Egypt"));
            board.setOccupant("Egypt", userList[0]);
            userList[0].addTerritory(board.getCountryByName("EastAfrica"));
            board.setOccupant("EastAfrica", userList[0]);
            userList[0].addTerritory(board.getCountryByName("NorthernEurope"));
            board.setOccupant("NorthernEurope", userList[0]);
            userList[0].addTerritory(board.getCountryByName("SouthernEurope"));
            board.setOccupant("SouthernEurope", userList[0]);
            userList[0].addTerritory(board.getCountryByName("WesternEurope"));
            board.setOccupant("WesternEurope", userList[0]);
            userList[0].addTerritory(board.getCountryByName("Indonesia"));
            board.setOccupant("Indonesia", userList[0]);
            userList[0].addTerritory(board.getCountryByName("NewGuinea"));
            board.setOccupant("NewGuinea", userList[0]);
            userList[0].addTerritory(board.getCountryByName("WesternAustralia"));
            board.setOccupant("WesternAustralia", userList[0]);
            userList[0].addTerritory(board.getCountryByName("Siam"));
            board.setOccupant("Siam", userList[0]);
            userList[0].addTerritory(board.getCountryByName("India"));
            board.setOccupant("India", userList[0]);
            userList[0].addTerritory(board.getCountryByName("China"));
            board.setOccupant("China", userList[0]);
            userList[0].addTerritory(board.getCountryByName("Mongolia"));
            board.setOccupant("Mongolia", userList[0]);
            userList[0].addTerritory(board.getCountryByName("Peru"));
            board.setOccupant("Peru", userList[0]);

            // Add player 2's countries to HashMap
            userList[1] = new User(playerNames[1], startingArmyPowerPerPlayer);
            userList[1].addTerritory(board.getCountryByName("Quebec"));
            board.setOccupant("Quebec", userList[1]);
            userList[1].addTerritory(board.getCountryByName("WesternUnitedStates"));
            board.setOccupant("WesternUnitedStates", userList[1]);
            userList[1].addTerritory(board.getCountryByName("EasternUnitedStates"));
            board.setOccupant("EasternUnitedStates", userList[1]);
            userList[1].addTerritory(board.getCountryByName("CentralAmerica"));
            board.setOccupant("CentralAmerica", userList[1]);
            userList[1].addTerritory(board.getCountryByName("Argentina"));
            board.setOccupant("Argentina", userList[1]);
            userList[1].addTerritory(board.getCountryByName("Congo"));
            board.setOccupant("Congo", userList[1]);
            userList[1].addTerritory(board.getCountryByName("SouthAfrica"));
            board.setOccupant("SouthAfrica", userList[1]);
            userList[1].addTerritory(board.getCountryByName("Madagascar"));
            board.setOccupant("Madagascar", userList[1]);
            userList[1].addTerritory(board.getCountryByName("Iceland"));
            board.setOccupant("Iceland", userList[1]);
            userList[1].addTerritory(board.getCountryByName("Scandinavia"));
            board.setOccupant("Scandinavia", userList[1]);
            userList[1].addTerritory(board.getCountryByName("Ukraine"));
            board.setOccupant("Ukraine", userList[1]);
            userList[1].addTerritory(board.getCountryByName("GreatBritian"));
            board.setOccupant("GreatBritian", userList[1]);
            userList[1].addTerritory(board.getCountryByName("EasternAustralia"));
            board.setOccupant("EasternAustralia", userList[1]);
            userList[1].addTerritory(board.getCountryByName("Japan"));
            board.setOccupant("Japan", userList[1]);
            userList[1].addTerritory(board.getCountryByName("Irkutsk"));
            board.setOccupant("Irkutsk", userList[1]);
            userList[1].addTerritory(board.getCountryByName("Yakutsk"));
            board.setOccupant("Yakutsk", userList[1]);
            userList[1].addTerritory(board.getCountryByName("Kamchatka"));
            board.setOccupant("Kamchatka", userList[1]);
            userList[1].addTerritory(board.getCountryByName("Siberia"));
            board.setOccupant("Siberia", userList[1]);
            userList[1].addTerritory(board.getCountryByName("Afghanistan"));
            board.setOccupant("Afghanistan", userList[1]);
            userList[1].addTerritory(board.getCountryByName("Ural"));
            board.setOccupant("Ural", userList[1]);
            userList[1].addTerritory(board.getCountryByName("Brazil"));
            board.setOccupant("Brazil", userList[1]);

            // Test
            System.out.println(board.getCountryByName("Alaska").getUser());
            System.out.println(board.getCountryByName("Siberia").getUser());
        }
        else if(numPlayers == 3)
        {
            // Add player 1's countries to HashMap
            userList[0] = new User(playerNames[0], startingArmyPowerPerPlayer);

            userList[0].addTerritory(board.getCountryByName("Alaska"));
            board.setOccupant("Alaska", userList[0]);
            userList[0].addTerritory(board.getCountryByName("NorthwestTerritory"));
            board.setOccupant("NorthwestTerritory", userList[0]);
            userList[0].addTerritory(board.getCountryByName("Greenland"));
            board.setOccupant("Greenland", userList[0]);
            userList[0].addTerritory(board.getCountryByName("Alberta"));
            board.setOccupant("Alberta", userList[0]);
            userList[0].addTerritory(board.getCountryByName("Ontario"));
            board.setOccupant("Ontario", userList[0]);
            userList[0].addTerritory(board.getCountryByName("Venezuela"));
            board.setOccupant("Venezuela", userList[0]);
            userList[0].addTerritory(board.getCountryByName("Brazil"));
            board.setOccupant("Brazil", userList[0]);
            userList[0].addTerritory(board.getCountryByName("Irkutsk"));
            board.setOccupant("Irkutsk", userList[0]);
            userList[0].addTerritory(board.getCountryByName("Yakutsk"));
            board.setOccupant("Yakutsk", userList[0]);
            userList[0].addTerritory(board.getCountryByName("Kamchatka"));
            board.setOccupant("Kamchatka", userList[0]);
            userList[0].addTerritory(board.getCountryByName("Siberia"));
            board.setOccupant("Siberia", userList[0]);
            userList[0].addTerritory(board.getCountryByName("Afghanistan"));
            board.setOccupant("Afghanistan", userList[0]);
            userList[0].addTerritory(board.getCountryByName("Ural"));
            board.setOccupant("Ural", userList[0]);
            userList[0].addTerritory(board.getCountryByName("MiddleEast"));
            board.setOccupant("MiddleEast", userList[0]);

            // Add player 2's countries to HashMap
            userList[1] = new User(playerNames[1], startingArmyPowerPerPlayer);
            userList[1].addTerritory(board.getCountryByName("Quebec"));
            board.setOccupant("Quebec", userList[1]);
            userList[1].addTerritory(board.getCountryByName("WesternUnitedStates"));
            board.setOccupant("WesternUnitedStates", userList[1]);
            userList[1].addTerritory(board.getCountryByName("EasternUnitedStates"));
            board.setOccupant("EasternUnitedStates", userList[1]);
            userList[1].addTerritory(board.getCountryByName("CentralAmerica"));
            board.setOccupant("CentralAmerica", userList[1]);
            userList[1].addTerritory(board.getCountryByName("Argentina"));
            board.setOccupant("Argentina", userList[1]);
            userList[1].addTerritory(board.getCountryByName("Congo"));
            board.setOccupant("Congo", userList[1]);
            userList[1].addTerritory(board.getCountryByName("SouthAfrica"));
            board.setOccupant("SouthAfrica", userList[1]);
            userList[1].addTerritory(board.getCountryByName("Madagascar"));
            board.setOccupant("Madagascar", userList[1]);
            userList[1].addTerritory(board.getCountryByName("Iceland "));
            board.setOccupant("Iceland ", userList[1]);
            userList[1].addTerritory(board.getCountryByName("Scandinavia"));
            board.setOccupant("Scandinavia", userList[1]);
            userList[1].addTerritory(board.getCountryByName("Ukraine"));
            board.setOccupant("Ukraine", userList[1]);
            userList[1].addTerritory(board.getCountryByName("GreatBritian"));
            board.setOccupant("GreatBritian", userList[1]);
            userList[1].addTerritory(board.getCountryByName("EasternAustralia"));
            board.setOccupant("EasternAustralia", userList[1]);
            userList[1].addTerritory(board.getCountryByName("Japan"));
            board.setOccupant("Japan", userList[1]);

            // Add player 3's countries to HashMap
            userList[2] = new User(playerNames[2], startingArmyPowerPerPlayer);
            userList[2].addTerritory(board.getCountryByName("NorthAfrica"));
            board.setOccupant("NorthAfrica", userList[2]);
            userList[2].addTerritory(board.getCountryByName("Egypt"));
            board.setOccupant("Egypt", userList[2]);
            userList[2].addTerritory(board.getCountryByName("EastAfrica"));
            board.setOccupant("EastAfrica", userList[2]);
            userList[2].addTerritory(board.getCountryByName("NorthernEurope"));
            board.setOccupant("NorthernEurope", userList[2]);
            userList[2].addTerritory(board.getCountryByName("SouthernEurope"));
            board.setOccupant("SouthernEurope", userList[2]);
            userList[2].addTerritory(board.getCountryByName("Western0Europe"));
            board.setOccupant("WesternEurope", userList[2]);
            userList[2].addTerritory(board.getCountryByName("Indonesia"));
            board.setOccupant("Indonesia", userList[2]);
            userList[2].addTerritory(board.getCountryByName("NewGuinea"));
            board.setOccupant("NewGuinea", userList[2]);
            userList[2].addTerritory(board.getCountryByName("WesternAustralia"));
            board.setOccupant("WesternAustralia", userList[2]);
            userList[2].addTerritory(board.getCountryByName("Siam"));
            board.setOccupant("Siam", userList[2]);
            userList[2].addTerritory(board.getCountryByName("India"));
            board.setOccupant("India", userList[2]);
            userList[2].addTerritory(board.getCountryByName("China"));
            board.setOccupant("China", userList[2]);
            userList[2].addTerritory(board.getCountryByName("Mongolia "));
            board.setOccupant("Mongolia ", userList[2]);
            userList[2].addTerritory(board.getCountryByName("Peru"));
            board.setOccupant("Peru", userList[2]);

        }
        else if(numPlayers == 4)
        {
            // Add player 1's countries to HashMap
            userList[0] = new User(playerNames[0], startingArmyPowerPerPlayer);
            userList[0].addTerritory(board.getCountryByName("Alaska"));
            board.setOccupant("Alaska", userList[0]);
            userList[0].addTerritory(board.getCountryByName("NorthwestTerritory"));
            board.setOccupant("NorthwestTerritory", userList[0]);
            userList[0].addTerritory(board.getCountryByName("Greenland"));
            board.setOccupant("Greenland", userList[0]);
            userList[0].addTerritory(board.getCountryByName("Alberta"));
            board.setOccupant("Alberta", userList[0]);
            userList[0].addTerritory(board.getCountryByName("Madagascar"));
            board.setOccupant("Madagascar", userList[0]);
            userList[0].addTerritory(board.getCountryByName("Iceland"));
            board.setOccupant("Iceland", userList[0]);
            userList[0].addTerritory(board.getCountryByName("Scandinavia"));
            board.setOccupant("Scandinavia", userList[0]);
            userList[0].addTerritory(board.getCountryByName("Ukraine"));
            board.setOccupant("Ukraine", userList[0]);
            userList[0].addTerritory(board.getCountryByName("Japan"));
            board.setOccupant("Japan", userList[0]);
            userList[0].addTerritory(board.getCountryByName("Irkutsk"));
            board.setOccupant("Irkutsk", userList[0]);
            userList[0].addTerritory(board.getCountryByName("EasternUnitedStates"));
            board.setOccupant("EasternUnitedStates", userList[0]);

            // Add player 2's countries to HashMap
            userList[1] = new User(playerNames[1], startingArmyPowerPerPlayer);
            userList[1].addTerritory(board.getCountryByName("NorthernEurope"));
            board.setOccupant("NorthernEurope", userList[1]);
            userList[1].addTerritory(board.getCountryByName("SouthernEurope"));
            board.setOccupant("SouthernEurope", userList[1]);
            userList[1].addTerritory(board.getCountryByName("WesternEurope"));
            board.setOccupant("WesternEurope", userList[1]);
            userList[1].addTerritory(board.getCountryByName("Indonesia"));
            board.setOccupant("Indonesia", userList[1]);
            userList[1].addTerritory(board.getCountryByName("SouthAfrica"));
            board.setOccupant("SouthAfrica", userList[1]);
            userList[1].addTerritory(board.getCountryByName("GreatBritian"));
            board.setOccupant("GreatBritian", userList[1]);
            userList[1].addTerritory(board.getCountryByName("EasternAustralia"));
            board.setOccupant("EasternAustralia", userList[1]);
            userList[1].addTerritory(board.getCountryByName("Yakutsk"));
            board.setOccupant("Yakutsk", userList[1]);
            userList[1].addTerritory(board.getCountryByName("Afghanistan"));
            board.setOccupant("Afghanistan", userList[1]);
            userList[1].addTerritory(board.getCountryByName("Ural"));
            board.setOccupant("Ural", userList[1]);
            userList[1].addTerritory(board.getCountryByName("MiddleEast"));
            board.setOccupant("MiddleEast", userList[1]);

            // Add player 3's countries to HashMap
            userList[2] = new User(playerNames[2], startingArmyPowerPerPlayer);
            userList[2].addTerritory(board.getCountryByName("Ontario"));
            board.setOccupant("Ontario", userList[2]);
            userList[2].addTerritory(board.getCountryByName("Venezuela"));
            board.setOccupant("Venezuela", userList[2]);
            userList[2].addTerritory(board.getCountryByName("Brazil"));
            board.setOccupant("Brazil", userList[2]);
            userList[2].addTerritory(board.getCountryByName("NorthAfrica"));
            board.setOccupant("NorthAfrica", userList[2]);
            userList[2].addTerritory(board.getCountryByName("Egypt"));
            board.setOccupant("Egypt", userList[2]);
            userList[2].addTerritory(board.getCountryByName("EastAfrica"));
            board.setOccupant("EastAfrica", userList[2]);
            userList[2].addTerritory(board.getCountryByName("Argentina"));
            board.setOccupant("Argentina", userList[2]);
            userList[2].addTerritory(board.getCountryByName("Congo"));
            board.setOccupant("Congo", userList[2]);
            userList[2].addTerritory(board.getCountryByName("Kamchatka"));
            board.setOccupant("Kamchatka", userList[2]);
            userList[2].addTerritory(board.getCountryByName("Siberia"));
            board.setOccupant("Siberia", userList[2]);

            // Add player 4's countries to HashMap
            userList[3] = new User(playerNames[3], startingArmyPowerPerPlayer);
            userList[3].addTerritory(board.getCountryByName("NewGuinea"));
            board.setOccupant("NewGuinea", userList[3]);
            userList[3].addTerritory(board.getCountryByName("WesternAustralia"));
            board.setOccupant("WesternAustralia", userList[3]);
            userList[3].addTerritory(board.getCountryByName("Siam"));
            board.setOccupant("Siam", userList[3]);
            userList[3].addTerritory(board.getCountryByName("India"));
            board.setOccupant("India", userList[3]);
            userList[3].addTerritory(board.getCountryByName("China"));
            board.setOccupant("China", userList[3]);
            userList[3].addTerritory(board.getCountryByName("Mongolia"));
            board.setOccupant("Mongolia", userList[3]);
            userList[3].addTerritory(board.getCountryByName("Peru"));
            board.setOccupant("Peru", userList[3]);
            userList[3].addTerritory(board.getCountryByName("Quebec"));
            board.setOccupant("Quebec", userList[3]);
            userList[3].addTerritory(board.getCountryByName("WesternUnitedStates"));
            board.setOccupant("WesternUnitedStates", userList[3]);
            userList[3].addTerritory(board.getCountryByName("CentralAmerica"));
            board.setOccupant("CentralAmerica", userList[3]);
        }
        else if(numPlayers == 5)
        {
            // Add player 1's countries to HashMap
            userList[0] = new User(playerNames[0], startingArmyPowerPerPlayer);
            userList[0].addTerritory(board.getCountryByName("Alaska"));
            board.setOccupant("Alaska", userList[0]);
            userList[0].addTerritory(board.getCountryByName("NorthwestTerritory"));
            board.setOccupant("NorthwestTerritory", userList[0]);
            userList[0].addTerritory(board.getCountryByName("Greenland"));
            board.setOccupant("Greenland", userList[0]);
            userList[0].addTerritory(board.getCountryByName("Alberta"));
            board.setOccupant("Alberta", userList[0]);
            userList[0].addTerritory(board.getCountryByName("Madagascar"));
            board.setOccupant("Madagascar", userList[0]);
            userList[0].addTerritory(board.getCountryByName("Scandinavia"));
            board.setOccupant("Scandinavia", userList[0]);
            userList[0].addTerritory(board.getCountryByName("Iceland"));
            board.setOccupant("Iceland", userList[0]);
            userList[0].addTerritory(board.getCountryByName("Ukraine"));
            board.setOccupant("Ukraine", userList[0]);
            userList[0].addTerritory(board.getCountryByName("Japan"));
            board.setOccupant("Japan", userList[0]);

            // Add player 2's countries to HashMap
            userList[1] = new User(playerNames[1], startingArmyPowerPerPlayer);
            userList[1].addTerritory(board.getCountryByName("Irkutsk"));
            board.setOccupant("Irkutsk", userList[1]);
            userList[1].addTerritory(board.getCountryByName("EasternUnitedStates"));
            board.setOccupant("EasternUnitedStates", userList[1]);
            userList[1].addTerritory(board.getCountryByName("NorthernEurope"));
            board.setOccupant("NorthernEurope", userList[1]);
            userList[1].addTerritory(board.getCountryByName("SouthernEurope"));
            board.setOccupant("SouthernEurope", userList[1]);
            userList[1].addTerritory(board.getCountryByName("WesternEurope"));
            board.setOccupant("WesternEurope", userList[1]);
            userList[1].addTerritory(board.getCountryByName("Indonesia"));
            board.setOccupant("Indonesia", userList[1]);
            userList[1].addTerritory(board.getCountryByName("SouthAfrica"));
            board.setOccupant("SouthAfrica", userList[1]);
            userList[1].addTerritory(board.getCountryByName("GreatBritian"));
            board.setOccupant("GreatBritian", userList[1]);
            userList[1].addTerritory(board.getCountryByName("EasternAustralia"));
            board.setOccupant("EasternAustralia", userList[1]);

            // Add player 3's countries to HashMap
            userList[2] = new User(playerNames[2], startingArmyPowerPerPlayer);
            userList[2].addTerritory(board.getCountryByName("Yakutsk"));
            board.setOccupant("Yakutsk", userList[2]);
            userList[2].addTerritory(board.getCountryByName("Afghanistan"));
            board.setOccupant("Afghanistan", userList[2]);
            userList[2].addTerritory(board.getCountryByName("Ural"));
            board.setOccupant("Ural", userList[2]);
            userList[2].addTerritory(board.getCountryByName("MiddleEast"));
            board.setOccupant("MiddleEast", userList[2]);
            userList[2].addTerritory(board.getCountryByName("Ontario"));
            board.setOccupant("Ontario", userList[2]);
            userList[2].addTerritory(board.getCountryByName("Venezuela"));
            board.setOccupant("Venezuela", userList[2]);
            userList[2].addTerritory(board.getCountryByName("Brazil"));
            board.setOccupant("Brazil", userList[2]);
            userList[2].addTerritory(board.getCountryByName("NorthAfrica"));
            board.setOccupant("NorthAfrica", userList[2]);

            // Add player 4's countries to HashMap
            userList[3] = new User(playerNames[3], startingArmyPowerPerPlayer);
            userList[3].addTerritory(board.getCountryByName("Egypt"));
            board.setOccupant("Egypt", userList[3]);
            userList[3].addTerritory(board.getCountryByName("EastAfrica"));
            board.setOccupant("EastAfrica", userList[3]);
            userList[3].addTerritory(board.getCountryByName("Argentina"));
            board.setOccupant("Argentina", userList[3]);
            userList[3].addTerritory(board.getCountryByName("Congo"));
            board.setOccupant("Congo", userList[3]);
            userList[3].addTerritory(board.getCountryByName("Kamchatka"));
            board.setOccupant("Kamchatka", userList[3]);
            userList[3].addTerritory(board.getCountryByName("Siberia"));
            board.setOccupant("Siberia", userList[3]);
            userList[3].addTerritory(board.getCountryByName("NewGuinea"));
            board.setOccupant("NewGuinea", userList[3]);
            userList[3].addTerritory(board.getCountryByName("WesternAustralia"));
            board.setOccupant("WesternAustralia", userList[3]);

            // Add player 5's countries to HashMap
            userList[4] = new User(playerNames[4], startingArmyPowerPerPlayer);
            userList[4].addTerritory(board.getCountryByName("Siam"));
            board.setOccupant("Siam", userList[4]);
            userList[4].addTerritory(board.getCountryByName("India"));
            board.setOccupant("India", userList[4]);
            userList[4].addTerritory(board.getCountryByName("China"));
            board.setOccupant("China", userList[4]);
            userList[4].addTerritory(board.getCountryByName("Mongolia"));
            board.setOccupant("Mongolia", userList[4]);
            userList[4].addTerritory(board.getCountryByName("Peru"));
            board.setOccupant("Peru", userList[4]);
            userList[4].addTerritory(board.getCountryByName("Quebec"));
            board.setOccupant("Quebec", userList[4]);
            userList[4].addTerritory(board.getCountryByName("WesternUnitedStates"));
            board.setOccupant("WesternUnitedStates", userList[4]);
            userList[4].addTerritory(board.getCountryByName("CentralAmerica"));
            board.setOccupant("CentralAmerica", userList[4]);
        }
        else // Number of Players is 6
        {
            // Add player 1's countries to HashMap
            userList[0] = new User(playerNames[0], startingArmyPowerPerPlayer);
            userList[0].addTerritory(board.getCountryByName("Alaska"));
            board.setOccupant("Alaska", userList[0]);
            userList[0].addTerritory(board.getCountryByName("NorthwestTerritory"));
            board.setOccupant("NorthwestTerritory", userList[0]);
            userList[0].addTerritory(board.getCountryByName("Greenland"));
            board.setOccupant("Greenland", userList[0]);
            userList[0].addTerritory(board.getCountryByName("Alberta"));
            board.setOccupant("Alberta", userList[0]);
            userList[0].addTerritory(board.getCountryByName("Ontario"));
            board.setOccupant("Ontario", userList[0]);
            userList[0].addTerritory(board.getCountryByName("Venezuela"));
            board.setOccupant("Venezuela", userList[0]);
            userList[0].addTerritory(board.getCountryByName("Brazil"));
            board.setOccupant("Brazil", userList[0]);

            // Add player 2's countries to HashMap
            userList[1] = new User(playerNames[1], startingArmyPowerPerPlayer);
            userList[1].addTerritory(board.getCountryByName("NorthAfrica"));
            board.setOccupant("NorthAfrica", userList[1]);
            userList[1].addTerritory(board.getCountryByName("Egypt"));
            board.setOccupant("Egypt", userList[1]);
            userList[1].addTerritory(board.getCountryByName("EastAfrica"));
            board.setOccupant("EastAfrica", userList[1]);
            userList[1].addTerritory(board.getCountryByName("NorthernEurope"));
            board.setOccupant("NorthernEurope", userList[1]);
            userList[1].addTerritory(board.getCountryByName("SouthernEurope"));
            board.setOccupant("SouthernEurope", userList[1]);
            userList[1].addTerritory(board.getCountryByName("WesternEurope"));
            board.setOccupant("WesternEurope", userList[1]);
            userList[1].addTerritory(board.getCountryByName("Indonesia"));
            board.setOccupant("Indonesia", userList[1]);

            // Add player 3's countries to HashMap
            userList[2] = new User(playerNames[2], startingArmyPowerPerPlayer);
            userList[2].addTerritory(board.getCountryByName("NewGuinea"));
            board.setOccupant("NewGuinea", userList[2]);
            userList[2].addTerritory(board.getCountryByName("WesternAustralia"));
            board.setOccupant("WesternAustralia", userList[2]);
            userList[2].addTerritory(board.getCountryByName("Siam"));
            board.setOccupant("Siam", userList[2]);
            userList[2].addTerritory(board.getCountryByName("India"));
            board.setOccupant("India", userList[2]);
            userList[2].addTerritory(board.getCountryByName("China"));
            board.setOccupant("China", userList[2]);
            userList[2].addTerritory(board.getCountryByName("Mongolia"));
            board.setOccupant("Mongolia", userList[2]);
            userList[2].addTerritory(board.getCountryByName("Peru"));
            board.setOccupant("Peru", userList[2]);

            // Add player 4's countries to HashMap
            userList[3] = new User(playerNames[3], startingArmyPowerPerPlayer);
            userList[3].addTerritory(board.getCountryByName("Quebec"));
            board.setOccupant("Quebec", userList[3]);
            userList[3].addTerritory(board.getCountryByName("WesternUnitedStates"));
            board.setOccupant("WesternUnitedStates", userList[3]);
            userList[3].addTerritory(board.getCountryByName("EasternUnitedStates"));
            board.setOccupant("EasternUnitedStates", userList[3]);
            userList[3].addTerritory(board.getCountryByName("CentralAmerica"));
            board.setOccupant("CentralAmerica", userList[3]);
            userList[3].addTerritory(board.getCountryByName("Argentina"));
            board.setOccupant("Argentina", userList[3]);
            userList[3].addTerritory(board.getCountryByName("Congo"));
            board.setOccupant("Congo", userList[3]);
            userList[3].addTerritory(board.getCountryByName("SouthAfrica"));
            board.setOccupant("SouthAfrica", userList[3]);

            // Add player 5's countries to HashMap
            userList[4] = new User(playerNames[4], startingArmyPowerPerPlayer);
            userList[4].addTerritory(board.getCountryByName("Madagascar"));
            board.setOccupant("Madagascar", userList[4]);
            userList[4].addTerritory(board.getCountryByName("Iceland"));
            board.setOccupant("Iceland", userList[4]);
            userList[4].addTerritory(board.getCountryByName("Scandinavia"));
            board.setOccupant("Scandinavia", userList[4]);
            userList[4].addTerritory(board.getCountryByName("Ukraine"));
            board.setOccupant("Ukraine", userList[4]);
            userList[4].addTerritory(board.getCountryByName("GreatBritian"));
            board.setOccupant("GreatBritian", userList[4]);
            userList[4].addTerritory(board.getCountryByName("EasternAustralia"));
            board.setOccupant("EasternAustralia", userList[4]);
            userList[4].addTerritory(board.getCountryByName("Japan"));
            board.setOccupant("Japan", userList[4]);

            // Add player 6's countries to HashMap
            userList[5] = new User(playerNames[5], startingArmyPowerPerPlayer);
            userList[5].addTerritory(board.getCountryByName("Irkutsk"));
            board.setOccupant("Irkutsk", userList[5]);
            userList[5].addTerritory(board.getCountryByName("Yakutsk"));
            board.setOccupant("Yakutsk", userList[5]);
            userList[5].addTerritory(board.getCountryByName("Kamchatka"));
            board.setOccupant("Kamchatka", userList[5]);
            userList[5].addTerritory(board.getCountryByName("Siberia"));
            board.setOccupant("Siberia", userList[5]);
            userList[5].addTerritory(board.getCountryByName("Afghanistan"));
            board.setOccupant("Afghanistan", userList[5]);
            userList[5].addTerritory(board.getCountryByName("Ural"));
            board.setOccupant("Ural", userList[5]);
            userList[5].addTerritory(board.getCountryByName("MiddleEast"));
            board.setOccupant("MiddleEast", userList[5]);
        }

        // More Testing
        System.out.println(userList[0].getUsername());
        board.getCountryByName("Venezuela").setArmyPower(6);
        userList[0].Action(User.Actions.ATTACK, board);


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
                // Increment armies based off number of territories
                // controlledNum = userList[i].FunctionToGrabSizeOfHashMAp
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

                // During actions of the game, per each player, we will also write a line to a text file
                // This text file will be uploaded to our Amazon S3 Bucket so we can see the replays of our game

                /* We will use a prompt to check if a user would like to undo an action, and we will not execute actions
                until user has selected 'No'. If they select 'Yes', we will proceed to ask again if they would
                like to do whatever action they are doing (perhaps sticking each action above in a while loop)
                This will simulate an undo feature */
            }
        }

        System.out.println("Congratulations " + userList[0].getUsername() + " on winning the game of Risk!");
    }
}
