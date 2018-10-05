import java.util.Scanner;
import java.util.*;
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
        
        GameSetup game = new GameSetup(numPlayers, playerNames);
		World world = game.getWorld();
		// game.playGame(); or create another class to actually handle the game

        Board board = new Board();
        board.setupBoard();

        // If loop to divide up territories based on number of players, will use HashMap for Users
        // Will look into iterating through HashMap to setOccupyingUser for each when spawning
        if(numPlayers == 2)
        {
            // Add player 1's countries to HashMap
            userList[0] = new User(playerNames[0], startingArmyPowerPerPlayer);
            userList[0].addTerritory(board.getTerritoryName("Alaska"));
            board.setUserOccupant("Alaska", userList[0]);
            userList[0].addTerritory(board.getTerritoryName("NorthwestTerritory"));
            board.setUserOccupant("NorthwestTerritory", userList[0]);
            userList[0].addTerritory(board.getTerritoryName("Greenland"));
            board.setUserOccupant("Greenland", userList[0]);
            userList[0].addTerritory(board.getTerritoryName("Alberta"));
            board.setUserOccupant("Alberta", userList[0]);
            userList[0].addTerritory(board.getTerritoryName("Ontario"));
            board.setUserOccupant("Ontario", userList[0]);
            userList[0].addTerritory(board.getTerritoryName("Venezuela"));
            board.setUserOccupant("Venezuela", userList[0]);
            userList[0].addTerritory(board.getTerritoryName("Brazil"));
            board.setUserOccupant("Brazil", userList[0]);
            userList[0].addTerritory(board.getTerritoryName("NorthAfrica"));
            board.setUserOccupant("NorthAfrica", userList[0]);
            userList[0].addTerritory(board.getTerritoryName("Egypt"));
            board.setUserOccupant("Egypt", userList[0]);
            userList[0].addTerritory(board.getTerritoryName("EastAfrica"));
            board.setUserOccupant("EastAfrica", userList[0]);
            userList[0].addTerritory(board.getTerritoryName("NorthernEurope"));
            board.setUserOccupant("NorthernEurope", userList[0]);
            userList[0].addTerritory(board.getTerritoryName("SouthernEurope"));
            board.setUserOccupant("SouthernEurope", userList[0]);
            userList[0].addTerritory(board.getTerritoryName("WesternEurope"));
            board.setUserOccupant("WesternEurope", userList[0]);
            userList[0].addTerritory(board.getTerritoryName("Indonesia"));
            board.setUserOccupant("Indonesia", userList[0]);
            userList[0].addTerritory(board.getTerritoryName("NewGuinea"));
            board.setUserOccupant("NewGuinea", userList[0]);
            userList[0].addTerritory(board.getTerritoryName("WesternAustralia"));
            board.setUserOccupant("WesternAustralia", userList[0]);
            userList[0].addTerritory(board.getTerritoryName("Siam"));
            board.setUserOccupant("Siam", userList[0]);
            userList[0].addTerritory(board.getTerritoryName("India"));
            board.setUserOccupant("India", userList[0]);
            userList[0].addTerritory(board.getTerritoryName("China"));
            board.setUserOccupant("China", userList[0]);
            userList[0].addTerritory(board.getTerritoryName("Mongolia"));
            board.setUserOccupant("Mongolia", userList[0]);
            userList[0].addTerritory(board.getTerritoryName("Peru"));
            board.setUserOccupant("Peru", userList[0]);

            // Add player 2's countries to HashMap
            userList[1] = new User(playerNames[1], startingArmyPowerPerPlayer);
            userList[1].addTerritory(board.getTerritoryName("Quebec"));
            board.setUserOccupant("Quebec", userList[1]);
            userList[1].addTerritory(board.getTerritoryName("WesternUnitedStates"));
            board.setUserOccupant("WesternUnitedStates", userList[1]);
            userList[1].addTerritory(board.getTerritoryName("EasternUnitedStates"));
            board.setUserOccupant("EasternUnitedStates", userList[1]);
            userList[1].addTerritory(board.getTerritoryName("CentralAmerica"));
            board.setUserOccupant("CentralAmerica", userList[1]);
            userList[1].addTerritory(board.getTerritoryName("Argentina"));
            board.setUserOccupant("Argentina", userList[1]);
            userList[1].addTerritory(board.getTerritoryName("Congo"));
            board.setUserOccupant("Congo", userList[1]);
            userList[1].addTerritory(board.getTerritoryName("SouthAfrica"));
            board.setUserOccupant("SouthAfrica", userList[1]);
            userList[1].addTerritory(board.getTerritoryName("Madagascar"));
            board.setUserOccupant("Madagascar", userList[1]);
            userList[1].addTerritory(board.getTerritoryName("Iceland"));
            board.setUserOccupant("Iceland", userList[1]);
            userList[1].addTerritory(board.getTerritoryName("Scandinavia"));
            board.setUserOccupant("Scandinavia", userList[1]);
            userList[1].addTerritory(board.getTerritoryName("Ukraine"));
            board.setUserOccupant("Ukraine", userList[1]);
            userList[1].addTerritory(board.getTerritoryName("GreatBritian"));
            board.setUserOccupant("GreatBritian", userList[1]);
            userList[1].addTerritory(board.getTerritoryName("EasternAustralia"));
            board.setUserOccupant("EasternAustralia", userList[1]);
            userList[1].addTerritory(board.getTerritoryName("Japan"));
            board.setUserOccupant("Japan", userList[1]);
            userList[1].addTerritory(board.getTerritoryName("Irkutsk"));
            board.setUserOccupant("Irkutsk", userList[1]);
            userList[1].addTerritory(board.getTerritoryName("Yakutsk"));
            board.setUserOccupant("Yakutsk", userList[1]);
            userList[1].addTerritory(board.getTerritoryName("Kamchatka"));
            board.setUserOccupant("Kamchatka", userList[1]);
            userList[1].addTerritory(board.getTerritoryName("Siberia"));
            board.setUserOccupant("Siberia", userList[1]);
            userList[1].addTerritory(board.getTerritoryName("Afghanistan"));
            board.setUserOccupant("Afghanistan", userList[1]);
            userList[1].addTerritory(board.getTerritoryName("Ural"));
            board.setUserOccupant("Ural", userList[1]);
            userList[1].addTerritory(board.getTerritoryName("MiddleEast"));
            board.setUserOccupant("MiddleEast", userList[1]);

            // Test
            System.out.println(board.getTerritoryName("Alaska").getUser());
            System.out.println(board.getTerritoryName("Siberia").getUser());
        }
        else if(numPlayers == 3)
        {
            // Add player 1's countries to HashMap
            userList[0] = new User(playerNames[0], startingArmyPowerPerPlayer);

            userList[0].addTerritory(board.getTerritoryName("Alaska"));
            board.setUserOccupant("Alaska", userList[0]);
            userList[0].addTerritory(board.getTerritoryName("NorthwestTerritory"));
            board.setUserOccupant("NorthwestTerritory", userList[0]);
            userList[0].addTerritory(board.getTerritoryName("Greenland"));
            board.setUserOccupant("Greenland", userList[0]);
            userList[0].addTerritory(board.getTerritoryName("Alberta"));
            board.setUserOccupant("Alberta", userList[0]);
            userList[0].addTerritory(board.getTerritoryName("Ontario"));
            board.setUserOccupant("Ontario", userList[0]);
            userList[0].addTerritory(board.getTerritoryName("Venezuela"));
            board.setUserOccupant("Venezuela", userList[0]);
            userList[0].addTerritory(board.getTerritoryName("Brazil"));
            board.setUserOccupant("Brazil", userList[0]);
            userList[0].addTerritory(board.getTerritoryName("Irkutsk"));
            board.setUserOccupant("Irkutsk", userList[0]);
            userList[0].addTerritory(board.getTerritoryName("Yakutsk"));
            board.setUserOccupant("Yakutsk", userList[0]);
            userList[0].addTerritory(board.getTerritoryName("Kamchatka"));
            board.setUserOccupant("Kamchatka", userList[0]);
            userList[0].addTerritory(board.getTerritoryName("Siberia"));
            board.setUserOccupant("Siberia", userList[0]);
            userList[0].addTerritory(board.getTerritoryName("Afghanistan"));
            board.setUserOccupant("Afghanistan", userList[0]);
            userList[0].addTerritory(board.getTerritoryName("Ural"));
            board.setUserOccupant("Ural", userList[0]);
            userList[0].addTerritory(board.getTerritoryName("MiddleEast"));
            board.setUserOccupant("MiddleEast", userList[0]);

            // Add player 2's countries to HashMap
            userList[1] = new User(playerNames[1], startingArmyPowerPerPlayer);
            userList[1].addTerritory(board.getTerritoryName("Quebec"));
            board.setUserOccupant("Quebec", userList[1]);
            userList[1].addTerritory(board.getTerritoryName("WesternUnitedStates"));
            board.setUserOccupant("WesternUnitedStates", userList[1]);
            userList[1].addTerritory(board.getTerritoryName("EasternUnitedStates"));
            board.setUserOccupant("EasternUnitedStates", userList[1]);
            userList[1].addTerritory(board.getTerritoryName("CentralAmerica"));
            board.setUserOccupant("CentralAmerica", userList[1]);
            userList[1].addTerritory(board.getTerritoryName("Argentina"));
            board.setUserOccupant("Argentina", userList[1]);
            userList[1].addTerritory(board.getTerritoryName("Congo"));
            board.setUserOccupant("Congo", userList[1]);
            userList[1].addTerritory(board.getTerritoryName("SouthAfrica"));
            board.setUserOccupant("SouthAfrica", userList[1]);
            userList[1].addTerritory(board.getTerritoryName("Madagascar"));
            board.setUserOccupant("Madagascar", userList[1]);
            userList[1].addTerritory(board.getTerritoryName("Iceland "));
            board.setUserOccupant("Iceland ", userList[1]);
            userList[1].addTerritory(board.getTerritoryName("Scandinavia"));
            board.setUserOccupant("Scandinavia", userList[1]);
            userList[1].addTerritory(board.getTerritoryName("Ukraine"));
            board.setUserOccupant("Ukraine", userList[1]);
            userList[1].addTerritory(board.getTerritoryName("GreatBritian"));
            board.setUserOccupant("GreatBritian", userList[1]);
            userList[1].addTerritory(board.getTerritoryName("EasternAustralia"));
            board.setUserOccupant("EasternAustralia", userList[1]);
            userList[1].addTerritory(board.getTerritoryName("Japan"));
            board.setUserOccupant("Japan", userList[1]);

            // Add player 3's countries to HashMap
            userList[2] = new User(playerNames[2], startingArmyPowerPerPlayer);
            userList[2].addTerritory(board.getTerritoryName("NorthAfrica"));
            board.setUserOccupant("NorthAfrica", userList[2]);
            userList[2].addTerritory(board.getTerritoryName("Egypt"));
            board.setUserOccupant("Egypt", userList[2]);
            userList[2].addTerritory(board.getTerritoryName("EastAfrica"));
            board.setUserOccupant("EastAfrica", userList[2]);
            userList[2].addTerritory(board.getTerritoryName("NorthernEurope"));
            board.setUserOccupant("NorthernEurope", userList[2]);
            userList[2].addTerritory(board.getTerritoryName("SouthernEurope"));
            board.setUserOccupant("SouthernEurope", userList[2]);
            userList[2].addTerritory(board.getTerritoryName("Western0Europe"));
            board.setUserOccupant("WesternEurope", userList[2]);
            userList[2].addTerritory(board.getTerritoryName("Indonesia"));
            board.setUserOccupant("Indonesia", userList[2]);
            userList[2].addTerritory(board.getTerritoryName("NewGuinea"));
            board.setUserOccupant("NewGuinea", userList[2]);
            userList[2].addTerritory(board.getTerritoryName("WesternAustralia"));
            board.setUserOccupant("WesternAustralia", userList[2]);
            userList[2].addTerritory(board.getTerritoryName("Siam"));
            board.setUserOccupant("Siam", userList[2]);
            userList[2].addTerritory(board.getTerritoryName("India"));
            board.setUserOccupant("India", userList[2]);
            userList[2].addTerritory(board.getTerritoryName("China"));
            board.setUserOccupant("China", userList[2]);
            userList[2].addTerritory(board.getTerritoryName("Mongolia "));
            board.setUserOccupant("Mongolia ", userList[2]);
            userList[2].addTerritory(board.getTerritoryName("Peru"));
            board.setUserOccupant("Peru", userList[2]);

        }
        else if(numPlayers == 4)
        {
            // Add player 1's countries to HashMap
            userList[0] = new User(playerNames[0], startingArmyPowerPerPlayer);
            userList[0].addTerritory(board.getTerritoryName("Alaska"));
            board.setUserOccupant("Alaska", userList[0]);
            userList[0].addTerritory(board.getTerritoryName("NorthwestTerritory"));
            board.setUserOccupant("NorthwestTerritory", userList[0]);
            userList[0].addTerritory(board.getTerritoryName("Greenland"));
            board.setUserOccupant("Greenland", userList[0]);
            userList[0].addTerritory(board.getTerritoryName("Alberta"));
            board.setUserOccupant("Alberta", userList[0]);
            userList[0].addTerritory(board.getTerritoryName("Madagascar"));
            board.setUserOccupant("Madagascar", userList[0]);
            userList[0].addTerritory(board.getTerritoryName("Iceland"));
            board.setUserOccupant("Iceland", userList[0]);
            userList[0].addTerritory(board.getTerritoryName("Scandinavia"));
            board.setUserOccupant("Scandinavia", userList[0]);
            userList[0].addTerritory(board.getTerritoryName("Ukraine"));
            board.setUserOccupant("Ukraine", userList[0]);
            userList[0].addTerritory(board.getTerritoryName("Japan"));
            board.setUserOccupant("Japan", userList[0]);
            userList[0].addTerritory(board.getTerritoryName("Irkutsk"));
            board.setUserOccupant("Irkutsk", userList[0]);
            userList[0].addTerritory(board.getTerritoryName("EasternUnitedStates"));
            board.setUserOccupant("EasternUnitedStates", userList[0]);

            // Add player 2's countries to HashMap
            userList[1] = new User(playerNames[1], startingArmyPowerPerPlayer);
            userList[1].addTerritory(board.getTerritoryName("NorthernEurope"));
            board.setUserOccupant("NorthernEurope", userList[1]);
            userList[1].addTerritory(board.getTerritoryName("SouthernEurope"));
            board.setUserOccupant("SouthernEurope", userList[1]);
            userList[1].addTerritory(board.getTerritoryName("WesternEurope"));
            board.setUserOccupant("WesternEurope", userList[1]);
            userList[1].addTerritory(board.getTerritoryName("Indonesia"));
            board.setUserOccupant("Indonesia", userList[1]);
            userList[1].addTerritory(board.getTerritoryName("SouthAfrica"));
            board.setUserOccupant("SouthAfrica", userList[1]);
            userList[1].addTerritory(board.getTerritoryName("GreatBritian"));
            board.setUserOccupant("GreatBritian", userList[1]);
            userList[1].addTerritory(board.getTerritoryName("EasternAustralia"));
            board.setUserOccupant("EasternAustralia", userList[1]);
            userList[1].addTerritory(board.getTerritoryName("Yakutsk"));
            board.setUserOccupant("Yakutsk", userList[1]);
            userList[1].addTerritory(board.getTerritoryName("Afghanistan"));
            board.setUserOccupant("Afghanistan", userList[1]);
            userList[1].addTerritory(board.getTerritoryName("Ural"));
            board.setUserOccupant("Ural", userList[1]);
            userList[1].addTerritory(board.getTerritoryName("MiddleEast"));
            board.setUserOccupant("MiddleEast", userList[1]);

            // Add player 3's countries to HashMap
            userList[2] = new User(playerNames[2], startingArmyPowerPerPlayer);
            userList[2].addTerritory(board.getTerritoryName("Ontario"));
            board.setUserOccupant("Ontario", userList[2]);
            userList[2].addTerritory(board.getTerritoryName("Venezuela"));
            board.setUserOccupant("Venezuela", userList[2]);
            userList[2].addTerritory(board.getTerritoryName("Brazil"));
            board.setUserOccupant("Brazil", userList[2]);
            userList[2].addTerritory(board.getTerritoryName("NorthAfrica"));
            board.setUserOccupant("NorthAfrica", userList[2]);
            userList[2].addTerritory(board.getTerritoryName("Egypt"));
            board.setUserOccupant("Egypt", userList[2]);
            userList[2].addTerritory(board.getTerritoryName("EastAfrica"));
            board.setUserOccupant("EastAfrica", userList[2]);
            userList[2].addTerritory(board.getTerritoryName("Argentina"));
            board.setUserOccupant("Argentina", userList[2]);
            userList[2].addTerritory(board.getTerritoryName("Congo"));
            board.setUserOccupant("Congo", userList[2]);
            userList[2].addTerritory(board.getTerritoryName("Kamchatka"));
            board.setUserOccupant("Kamchatka", userList[2]);
            userList[2].addTerritory(board.getTerritoryName("Siberia"));
            board.setUserOccupant("Siberia", userList[2]);

            // Add player 4's countries to HashMap
            userList[3] = new User(playerNames[3], startingArmyPowerPerPlayer);
            userList[3].addTerritory(board.getTerritoryName("NewGuinea"));
            board.setUserOccupant("NewGuinea", userList[3]);
            userList[3].addTerritory(board.getTerritoryName("WesternAustralia"));
            board.setUserOccupant("WesternAustralia", userList[3]);
            userList[3].addTerritory(board.getTerritoryName("Siam"));
            board.setUserOccupant("Siam", userList[3]);
            userList[3].addTerritory(board.getTerritoryName("India"));
            board.setUserOccupant("India", userList[3]);
            userList[3].addTerritory(board.getTerritoryName("China"));
            board.setUserOccupant("China", userList[3]);
            userList[3].addTerritory(board.getTerritoryName("Mongolia"));
            board.setUserOccupant("Mongolia", userList[3]);
            userList[3].addTerritory(board.getTerritoryName("Peru"));
            board.setUserOccupant("Peru", userList[3]);
            userList[3].addTerritory(board.getTerritoryName("Quebec"));
            board.setUserOccupant("Quebec", userList[3]);
            userList[3].addTerritory(board.getTerritoryName("WesternUnitedStates"));
            board.setUserOccupant("WesternUnitedStates", userList[3]);
            userList[3].addTerritory(board.getTerritoryName("CentralAmerica"));
            board.setUserOccupant("CentralAmerica", userList[3]);
        }
        else if(numPlayers == 5)
        {
            // Add player 1's countries to HashMap
            userList[0] = new User(playerNames[0], startingArmyPowerPerPlayer);
            userList[0].addTerritory(board.getTerritoryName("Alaska"));
            board.setUserOccupant("Alaska", userList[0]);
            userList[0].addTerritory(board.getTerritoryName("NorthwestTerritory"));
            board.setUserOccupant("NorthwestTerritory", userList[0]);
            userList[0].addTerritory(board.getTerritoryName("Greenland"));
            board.setUserOccupant("Greenland", userList[0]);
            userList[0].addTerritory(board.getTerritoryName("Alberta"));
            board.setUserOccupant("Alberta", userList[0]);
            userList[0].addTerritory(board.getTerritoryName("Madagascar"));
            board.setUserOccupant("Madagascar", userList[0]);
            userList[0].addTerritory(board.getTerritoryName("Scandinavia"));
            board.setUserOccupant("Scandinavia", userList[0]);
            userList[0].addTerritory(board.getTerritoryName("Iceland"));
            board.setUserOccupant("Iceland", userList[0]);
            userList[0].addTerritory(board.getTerritoryName("Ukraine"));
            board.setUserOccupant("Ukraine", userList[0]);
            userList[0].addTerritory(board.getTerritoryName("Japan"));
            board.setUserOccupant("Japan", userList[0]);

            // Add player 2's countries to HashMap
            userList[1] = new User(playerNames[1], startingArmyPowerPerPlayer);
            userList[1].addTerritory(board.getTerritoryName("Irkutsk"));
            board.setUserOccupant("Irkutsk", userList[1]);
            userList[1].addTerritory(board.getTerritoryName("EasternUnitedStates"));
            board.setUserOccupant("EasternUnitedStates", userList[1]);
            userList[1].addTerritory(board.getTerritoryName("NorthernEurope"));
            board.setUserOccupant("NorthernEurope", userList[1]);
            userList[1].addTerritory(board.getTerritoryName("SouthernEurope"));
            board.setUserOccupant("SouthernEurope", userList[1]);
            userList[1].addTerritory(board.getTerritoryName("WesternEurope"));
            board.setUserOccupant("WesternEurope", userList[1]);
            userList[1].addTerritory(board.getTerritoryName("Indonesia"));
            board.setUserOccupant("Indonesia", userList[1]);
            userList[1].addTerritory(board.getTerritoryName("SouthAfrica"));
            board.setUserOccupant("SouthAfrica", userList[1]);
            userList[1].addTerritory(board.getTerritoryName("GreatBritian"));
            board.setUserOccupant("GreatBritian", userList[1]);
            userList[1].addTerritory(board.getTerritoryName("EasternAustralia"));
            board.setUserOccupant("EasternAustralia", userList[1]);

            // Add player 3's countries to HashMap
            userList[2] = new User(playerNames[2], startingArmyPowerPerPlayer);
            userList[2].addTerritory(board.getTerritoryName("Yakutsk"));
            board.setUserOccupant("Yakutsk", userList[2]);
            userList[2].addTerritory(board.getTerritoryName("Afghanistan"));
            board.setUserOccupant("Afghanistan", userList[2]);
            userList[2].addTerritory(board.getTerritoryName("Ural"));
            board.setUserOccupant("Ural", userList[2]);
            userList[2].addTerritory(board.getTerritoryName("MiddleEast"));
            board.setUserOccupant("MiddleEast", userList[2]);
            userList[2].addTerritory(board.getTerritoryName("Ontario"));
            board.setUserOccupant("Ontario", userList[2]);
            userList[2].addTerritory(board.getTerritoryName("Venezuela"));
            board.setUserOccupant("Venezuela", userList[2]);
            userList[2].addTerritory(board.getTerritoryName("Brazil"));
            board.setUserOccupant("Brazil", userList[2]);
            userList[2].addTerritory(board.getTerritoryName("NorthAfrica"));
            board.setUserOccupant("NorthAfrica", userList[2]);

            // Add player 4's countries to HashMap
            userList[3] = new User(playerNames[3], startingArmyPowerPerPlayer);
            userList[3].addTerritory(board.getTerritoryName("Egypt"));
            board.setUserOccupant("Egypt", userList[3]);
            userList[3].addTerritory(board.getTerritoryName("EastAfrica"));
            board.setUserOccupant("EastAfrica", userList[3]);
            userList[3].addTerritory(board.getTerritoryName("Argentina"));
            board.setUserOccupant("Argentina", userList[3]);
            userList[3].addTerritory(board.getTerritoryName("Congo"));
            board.setUserOccupant("Congo", userList[3]);
            userList[3].addTerritory(board.getTerritoryName("Kamchatka"));
            board.setUserOccupant("Kamchatka", userList[3]);
            userList[3].addTerritory(board.getTerritoryName("Siberia"));
            board.setUserOccupant("Siberia", userList[3]);
            userList[3].addTerritory(board.getTerritoryName("NewGuinea"));
            board.setUserOccupant("NewGuinea", userList[3]);
            userList[3].addTerritory(board.getTerritoryName("WesternAustralia"));
            board.setUserOccupant("WesternAustralia", userList[3]);

            // Add player 5's countries to HashMap
            userList[4] = new User(playerNames[4], startingArmyPowerPerPlayer);
            userList[4].addTerritory(board.getTerritoryName("Siam"));
            board.setUserOccupant("Siam", userList[4]);
            userList[4].addTerritory(board.getTerritoryName("India"));
            board.setUserOccupant("India", userList[4]);
            userList[4].addTerritory(board.getTerritoryName("China"));
            board.setUserOccupant("China", userList[4]);
            userList[4].addTerritory(board.getTerritoryName("Mongolia"));
            board.setUserOccupant("Mongolia", userList[4]);
            userList[4].addTerritory(board.getTerritoryName("Peru"));
            board.setUserOccupant("Peru", userList[4]);
            userList[4].addTerritory(board.getTerritoryName("Quebec"));
            board.setUserOccupant("Quebec", userList[4]);
            userList[4].addTerritory(board.getTerritoryName("WesternUnitedStates"));
            board.setUserOccupant("WesternUnitedStates", userList[4]);
            userList[4].addTerritory(board.getTerritoryName("CentralAmerica"));
            board.setUserOccupant("CentralAmerica", userList[4]);
        }
        else // Number of Players is 6
        {
            // Add player 1's countries to HashMap
            userList[0] = new User(playerNames[0], startingArmyPowerPerPlayer);
            userList[0].addTerritory(board.getTerritoryName("Alaska"));
            board.setUserOccupant("Alaska", userList[0]);
            userList[0].addTerritory(board.getTerritoryName("NorthwestTerritory"));
            board.setUserOccupant("NorthwestTerritory", userList[0]);
            userList[0].addTerritory(board.getTerritoryName("Greenland"));
            board.setUserOccupant("Greenland", userList[0]);
            userList[0].addTerritory(board.getTerritoryName("Alberta"));
            board.setUserOccupant("Alberta", userList[0]);
            userList[0].addTerritory(board.getTerritoryName("Ontario"));
            board.setUserOccupant("Ontario", userList[0]);
            userList[0].addTerritory(board.getTerritoryName("Venezuela"));
            board.setUserOccupant("Venezuela", userList[0]);
            userList[0].addTerritory(board.getTerritoryName("Brazil"));
            board.setUserOccupant("Brazil", userList[0]);

            // Add player 2's countries to HashMap
            userList[1] = new User(playerNames[1], startingArmyPowerPerPlayer);
            userList[1].addTerritory(board.getTerritoryName("NorthAfrica"));
            board.setUserOccupant("NorthAfrica", userList[1]);
            userList[1].addTerritory(board.getTerritoryName("Egypt"));
            board.setUserOccupant("Egypt", userList[1]);
            userList[1].addTerritory(board.getTerritoryName("EastAfrica"));
            board.setUserOccupant("EastAfrica", userList[1]);
            userList[1].addTerritory(board.getTerritoryName("NorthernEurope"));
            board.setUserOccupant("NorthernEurope", userList[1]);
            userList[1].addTerritory(board.getTerritoryName("SouthernEurope"));
            board.setUserOccupant("SouthernEurope", userList[1]);
            userList[1].addTerritory(board.getTerritoryName("WesternEurope"));
            board.setUserOccupant("WesternEurope", userList[1]);
            userList[1].addTerritory(board.getTerritoryName("Indonesia"));
            board.setUserOccupant("Indonesia", userList[1]);

            // Add player 3's countries to HashMap
            userList[2] = new User(playerNames[2], startingArmyPowerPerPlayer);
            userList[2].addTerritory(board.getTerritoryName("NewGuinea"));
            board.setUserOccupant("NewGuinea", userList[2]);
            userList[2].addTerritory(board.getTerritoryName("WesternAustralia"));
            board.setUserOccupant("WesternAustralia", userList[2]);
            userList[2].addTerritory(board.getTerritoryName("Siam"));
            board.setUserOccupant("Siam", userList[2]);
            userList[2].addTerritory(board.getTerritoryName("India"));
            board.setUserOccupant("India", userList[2]);
            userList[2].addTerritory(board.getTerritoryName("China"));
            board.setUserOccupant("China", userList[2]);
            userList[2].addTerritory(board.getTerritoryName("Mongolia"));
            board.setUserOccupant("Mongolia", userList[2]);
            userList[2].addTerritory(board.getTerritoryName("Peru"));
            board.setUserOccupant("Peru", userList[2]);

            // Add player 4's countries to HashMap
            userList[3] = new User(playerNames[3], startingArmyPowerPerPlayer);
            userList[3].addTerritory(board.getTerritoryName("Quebec"));
            board.setUserOccupant("Quebec", userList[3]);
            userList[3].addTerritory(board.getTerritoryName("WesternUnitedStates"));
            board.setUserOccupant("WesternUnitedStates", userList[3]);
            userList[3].addTerritory(board.getTerritoryName("EasternUnitedStates"));
            board.setUserOccupant("EasternUnitedStates", userList[3]);
            userList[3].addTerritory(board.getTerritoryName("CentralAmerica"));
            board.setUserOccupant("CentralAmerica", userList[3]);
            userList[3].addTerritory(board.getTerritoryName("Argentina"));
            board.setUserOccupant("Argentina", userList[3]);
            userList[3].addTerritory(board.getTerritoryName("Congo"));
            board.setUserOccupant("Congo", userList[3]);
            userList[3].addTerritory(board.getTerritoryName("SouthAfrica"));
            board.setUserOccupant("SouthAfrica", userList[3]);

            // Add player 5's countries to HashMap
            userList[4] = new User(playerNames[4], startingArmyPowerPerPlayer);
            userList[4].addTerritory(board.getTerritoryName("Madagascar"));
            board.setUserOccupant("Madagascar", userList[4]);
            userList[4].addTerritory(board.getTerritoryName("Iceland"));
            board.setUserOccupant("Iceland", userList[4]);
            userList[4].addTerritory(board.getTerritoryName("Scandinavia"));
            board.setUserOccupant("Scandinavia", userList[4]);
            userList[4].addTerritory(board.getTerritoryName("Ukraine"));
            board.setUserOccupant("Ukraine", userList[4]);
            userList[4].addTerritory(board.getTerritoryName("GreatBritian"));
            board.setUserOccupant("GreatBritian", userList[4]);
            userList[4].addTerritory(board.getTerritoryName("EasternAustralia"));
            board.setUserOccupant("EasternAustralia", userList[4]);
            userList[4].addTerritory(board.getTerritoryName("Japan"));
            board.setUserOccupant("Japan", userList[4]);

            // Add player 6's countries to HashMap
            userList[5] = new User(playerNames[5], startingArmyPowerPerPlayer);
            userList[5].addTerritory(board.getTerritoryName("Irkutsk"));
            board.setUserOccupant("Irkutsk", userList[5]);
            userList[5].addTerritory(board.getTerritoryName("Yakutsk"));
            board.setUserOccupant("Yakutsk", userList[5]);
            userList[5].addTerritory(board.getTerritoryName("Kamchatka"));
            board.setUserOccupant("Kamchatka", userList[5]);
            userList[5].addTerritory(board.getTerritoryName("Siberia"));
            board.setUserOccupant("Siberia", userList[5]);
            userList[5].addTerritory(board.getTerritoryName("Afghanistan"));
            board.setUserOccupant("Afghanistan", userList[5]);
            userList[5].addTerritory(board.getTerritoryName("Ural"));
            board.setUserOccupant("Ural", userList[5]);
            userList[5].addTerritory(board.getTerritoryName("MiddleEast"));
            board.setUserOccupant("MiddleEast", userList[5]);
        }

        // More Testing
        System.out.println(userList[0].getUsername());

        // Game flag. Remove players from array who do not have territories. When one is left, he wins and game ends

        // WHEN TESTING ON INTELLIJ YOU MUST STOP THE PROGRAM MANUALLY AS THIS IS AN INFINITE LOOP RIGHT NOW
        while((userList.length) != 1)
        {
            if (userList.length != 1) break; // remove this line when the loop is implemented

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
