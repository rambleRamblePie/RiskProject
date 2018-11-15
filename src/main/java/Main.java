import java.util.Scanner;
import java.util.*;
import java.util.List;
import java.io.PrintWriter;
import java.io.File;
import java.io.*;
import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.model.AmazonS3Exception;
import com.amazonaws.services.s3.model.PutObjectRequest;
import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;

public class Main {
    public static void main(String[] args) throws FileNotFoundException, TwitterException{

        /*
        // Amazon credentials and setup
        AWSCredentials credentials = new BasicAWSCredentials("accesskey", "secretkey");
        AmazonS3 s3client = new AmazonS3Client(credentials);
        */

        // Grabbing correct file
        File currentDir = new File(".");
        File parentDir = currentDir.getAbsoluteFile();
        File myFile = new File(parentDir + "/src/resources/replay.txt");

        // Used to write to file for upload
        PrintWriter writer = new PrintWriter(myFile);

        boolean attackFlag;
        int controlledNum = 0;
        int twitterCounter = 0;
        int addedArmies;
        User[] userList;
        User[] twitterList;
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

        // Array that will hold users. Twitter array will be used for the end of the game
        userList = new User[numPlayers];
        twitterList = new User[numPlayers];

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

        // Spawn board, twitter object for posting
        Board board = new Board();
        board.setupBoard();
        TweetPoster tp = new TweetPoster();

        // Going to manually setup starting armies for right now
        // If loop to divide up territories based on number of players, will use HashMap for Users
        // Will look into iterating through HashMap to setOccupyingUser for each when spawning
        if(numPlayers == 2)
        {
            // Add player 1's countries to HashMap
            userList[0] = new User(playerNames[0], startingArmyPowerPerPlayer);
            userList[0].addTerritory(board.getTerritoryName("Alaska"));
            board.setUserOccupant("Alaska", userList[0]);
            board.getTerritoryName("Alaska").setArmyPower(1);
            userList[0].addTerritory(board.getTerritoryName("NorthwestTerritory"));
            board.setUserOccupant("NorthwestTerritory", userList[0]);
            board.getTerritoryName("NorthwestTerritory").setArmyPower(1);
            userList[0].addTerritory(board.getTerritoryName("Greenland"));
            board.setUserOccupant("Greenland", userList[0]);
            board.getTerritoryName("Greenland").setArmyPower(1);
            userList[0].addTerritory(board.getTerritoryName("Alberta"));
            board.setUserOccupant("Alberta", userList[0]);
            board.getTerritoryName("Alberta").setArmyPower(1);
            userList[0].addTerritory(board.getTerritoryName("Ontario"));
            board.setUserOccupant("Ontario", userList[0]);
            board.getTerritoryName("Ontario").setArmyPower(1);
            userList[0].addTerritory(board.getTerritoryName("Venezuela"));
            board.setUserOccupant("Venezuela", userList[0]);
            board.getTerritoryName("Venezuela").setArmyPower(1);
            userList[0].addTerritory(board.getTerritoryName("Brazil"));
            board.setUserOccupant("Brazil", userList[0]);
            board.getTerritoryName("Brazil").setArmyPower(1);
            userList[0].addTerritory(board.getTerritoryName("NorthAfrica"));
            board.setUserOccupant("NorthAfrica", userList[0]);
            board.getTerritoryName("NorthAfrica").setArmyPower(1);
            userList[0].addTerritory(board.getTerritoryName("Egypt"));
            board.setUserOccupant("Egypt", userList[0]);
            board.getTerritoryName("Egypt").setArmyPower(1);
            userList[0].addTerritory(board.getTerritoryName("EastAfrica"));
            board.setUserOccupant("EastAfrica", userList[0]);
            board.getTerritoryName("EastAfrica").setArmyPower(1);
            userList[0].addTerritory(board.getTerritoryName("NorthernEurope"));
            board.setUserOccupant("NorthernEurope", userList[0]);
            board.getTerritoryName("NorthernEurope").setArmyPower(1);
            userList[0].addTerritory(board.getTerritoryName("SouthernEurope"));
            board.setUserOccupant("SouthernEurope", userList[0]);
            board.getTerritoryName("SouthernEurope").setArmyPower(1);
            userList[0].addTerritory(board.getTerritoryName("WesternEurope"));
            board.setUserOccupant("WesternEurope", userList[0]);
            board.getTerritoryName("WesternEurope").setArmyPower(1);
            userList[0].addTerritory(board.getTerritoryName("Indonesia"));
            board.setUserOccupant("Indonesia", userList[0]);
            board.getTerritoryName("Indonesia").setArmyPower(1);
            userList[0].addTerritory(board.getTerritoryName("NewGuinea"));
            board.setUserOccupant("NewGuinea", userList[0]);
            board.getTerritoryName("NewGuinea").setArmyPower(1);
            userList[0].addTerritory(board.getTerritoryName("WesternAustralia"));
            board.setUserOccupant("WesternAustralia", userList[0]);
            board.getTerritoryName("WesternAustralia").setArmyPower(1);
            userList[0].addTerritory(board.getTerritoryName("Siam"));
            board.setUserOccupant("Siam", userList[0]);
            board.getTerritoryName("Siam").setArmyPower(1);
            userList[0].addTerritory(board.getTerritoryName("India"));
            board.setUserOccupant("India", userList[0]);
            board.getTerritoryName("India").setArmyPower(1);
            userList[0].addTerritory(board.getTerritoryName("China"));
            board.setUserOccupant("China", userList[0]);
            board.getTerritoryName("China").setArmyPower(1);
            userList[0].addTerritory(board.getTerritoryName("Mongolia"));
            board.setUserOccupant("Mongolia", userList[0]);
            board.getTerritoryName("Mongolia").setArmyPower(1);
            userList[0].addTerritory(board.getTerritoryName("Peru"));
            board.setUserOccupant("Peru", userList[0]);
            board.getTerritoryName("Peru").setArmyPower(1);

            // Add player 2's countries to HashMap
            userList[1] = new User(playerNames[1], startingArmyPowerPerPlayer);
            userList[1].addTerritory(board.getTerritoryName("Quebec"));
            board.setUserOccupant("Quebec", userList[1]);
            board.getTerritoryName("Quebec").setArmyPower(1);
            userList[1].addTerritory(board.getTerritoryName("WesternUnitedStates"));
            board.setUserOccupant("WesternUnitedStates", userList[1]);
            board.getTerritoryName("WesternUnitedStates").setArmyPower(1);
            userList[1].addTerritory(board.getTerritoryName("EasternUnitedStates"));
            board.setUserOccupant("EasternUnitedStates", userList[1]);
            board.getTerritoryName("EasternUnitedStates").setArmyPower(1);
            userList[1].addTerritory(board.getTerritoryName("CentralAmerica"));
            board.setUserOccupant("CentralAmerica", userList[1]);
            board.getTerritoryName("CentralAmerica").setArmyPower(1);
            userList[1].addTerritory(board.getTerritoryName("Argentina"));
            board.setUserOccupant("Argentina", userList[1]);
            board.getTerritoryName("Argentina").setArmyPower(1);
            userList[1].addTerritory(board.getTerritoryName("Congo"));
            board.setUserOccupant("Congo", userList[1]);
            board.getTerritoryName("Congo").setArmyPower(1);
            userList[1].addTerritory(board.getTerritoryName("SouthAfrica"));
            board.setUserOccupant("SouthAfrica", userList[1]);
            board.getTerritoryName("SouthAfrica").setArmyPower(1);
            userList[1].addTerritory(board.getTerritoryName("Madagascar"));
            board.setUserOccupant("Madagascar", userList[1]);
            board.getTerritoryName("Madagascar").setArmyPower(1);
            userList[1].addTerritory(board.getTerritoryName("Iceland"));
            board.setUserOccupant("Iceland", userList[1]);
            board.getTerritoryName("Iceland").setArmyPower(1);
            userList[1].addTerritory(board.getTerritoryName("Scandinavia"));
            board.setUserOccupant("Scandinavia", userList[1]);
            board.getTerritoryName("Scandinavia").setArmyPower(1);
            userList[1].addTerritory(board.getTerritoryName("Ukraine"));
            board.setUserOccupant("Ukraine", userList[1]);
            board.getTerritoryName("Ukraine").setArmyPower(1);
            userList[1].addTerritory(board.getTerritoryName("GreatBritian"));
            board.setUserOccupant("GreatBritian", userList[1]);
            board.getTerritoryName("GreatBritian").setArmyPower(1);
            userList[1].addTerritory(board.getTerritoryName("EasternAustralia"));
            board.setUserOccupant("EasternAustralia", userList[1]);
            board.getTerritoryName("EasternAustralia").setArmyPower(1);
            userList[1].addTerritory(board.getTerritoryName("Japan"));
            board.setUserOccupant("Japan", userList[1]);
            board.getTerritoryName("Japan").setArmyPower(1);
            userList[1].addTerritory(board.getTerritoryName("Irkutsk"));
            board.setUserOccupant("Irkutsk", userList[1]);
            board.getTerritoryName("Irkutsk").setArmyPower(1);
            userList[1].addTerritory(board.getTerritoryName("Yakutsk"));
            board.setUserOccupant("Yakutsk", userList[1]);
            board.getTerritoryName("Yakutsk").setArmyPower(1);
            userList[1].addTerritory(board.getTerritoryName("Kamchatka"));
            board.setUserOccupant("Kamchatka", userList[1]);
            board.getTerritoryName("Kamchatka").setArmyPower(1);
            userList[1].addTerritory(board.getTerritoryName("Siberia"));
            board.setUserOccupant("Siberia", userList[1]);
            board.getTerritoryName("Siberia").setArmyPower(1);
            userList[1].addTerritory(board.getTerritoryName("Afghanistan"));
            board.setUserOccupant("Afghanistan", userList[1]);
            board.getTerritoryName("Afghanistan").setArmyPower(1);
            userList[1].addTerritory(board.getTerritoryName("Ural"));
            board.setUserOccupant("Ural", userList[1]);
            board.getTerritoryName("Ural").setArmyPower(1);
            userList[1].addTerritory(board.getTerritoryName("MiddleEast"));
            board.setUserOccupant("MiddleEast", userList[1]);
            board.getTerritoryName("MiddleEast").setArmyPower(1);

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
            board.getTerritoryName("Alaska").setArmyPower(1);
            userList[0].addTerritory(board.getTerritoryName("NorthwestTerritory"));
            board.setUserOccupant("NorthwestTerritory", userList[0]);
            board.getTerritoryName("NorthwestTerritory").setArmyPower(1);
            userList[0].addTerritory(board.getTerritoryName("Greenland"));
            board.setUserOccupant("Greenland", userList[0]);
            board.getTerritoryName("Greenland").setArmyPower(1);
            userList[0].addTerritory(board.getTerritoryName("Alberta"));
            board.setUserOccupant("Alberta", userList[0]);
            board.getTerritoryName("Alberta").setArmyPower(1);
            userList[0].addTerritory(board.getTerritoryName("Ontario"));
            board.setUserOccupant("Ontario", userList[0]);
            board.getTerritoryName("Ontario").setArmyPower(1);
            userList[0].addTerritory(board.getTerritoryName("Venezuela"));
            board.setUserOccupant("Venezuela", userList[0]);
            board.getTerritoryName("Venezuela").setArmyPower(1);
            userList[0].addTerritory(board.getTerritoryName("Brazil"));
            board.setUserOccupant("Brazil", userList[0]);
            board.getTerritoryName("Brazil").setArmyPower(1);
            userList[0].addTerritory(board.getTerritoryName("Irkutsk"));
            board.setUserOccupant("Irkutsk", userList[0]);
            board.getTerritoryName("Irkutsk").setArmyPower(1);
            userList[0].addTerritory(board.getTerritoryName("Yakutsk"));
            board.setUserOccupant("Yakutsk", userList[0]);
            board.getTerritoryName("Yakutsk").setArmyPower(1);
            userList[0].addTerritory(board.getTerritoryName("Kamchatka"));
            board.setUserOccupant("Kamchatka", userList[0]);
            board.getTerritoryName("Kamchatka").setArmyPower(1);
            userList[0].addTerritory(board.getTerritoryName("Siberia"));
            board.setUserOccupant("Siberia", userList[0]);
            board.getTerritoryName("Siberia").setArmyPower(1);
            userList[0].addTerritory(board.getTerritoryName("Afghanistan"));
            board.setUserOccupant("Afghanistan", userList[0]);
            board.getTerritoryName("Afghanistan").setArmyPower(1);
            userList[0].addTerritory(board.getTerritoryName("Ural"));
            board.setUserOccupant("Ural", userList[0]);
            board.getTerritoryName("Ural").setArmyPower(1);
            userList[0].addTerritory(board.getTerritoryName("MiddleEast"));
            board.setUserOccupant("MiddleEast", userList[0]);
            board.getTerritoryName("MiddleEast").setArmyPower(1);

            // Add player 2's countries to HashMap
            userList[1] = new User(playerNames[1], startingArmyPowerPerPlayer);
            userList[1].addTerritory(board.getTerritoryName("Quebec"));
            board.setUserOccupant("Quebec", userList[1]);
            board.getTerritoryName("Quebec").setArmyPower(1);
            userList[1].addTerritory(board.getTerritoryName("WesternUnitedStates"));
            board.setUserOccupant("WesternUnitedStates", userList[1]);
            board.getTerritoryName("WesternUnitedStates").setArmyPower(1);
            userList[1].addTerritory(board.getTerritoryName("EasternUnitedStates"));
            board.setUserOccupant("EasternUnitedStates", userList[1]);
            board.getTerritoryName("EasternUnitedStates").setArmyPower(1);
            userList[1].addTerritory(board.getTerritoryName("CentralAmerica"));
            board.setUserOccupant("CentralAmerica", userList[1]);
            board.getTerritoryName("CentralAmerica").setArmyPower(1);
            userList[1].addTerritory(board.getTerritoryName("Argentina"));
            board.setUserOccupant("Argentina", userList[1]);
            board.getTerritoryName("Argentina").setArmyPower(1);
            userList[1].addTerritory(board.getTerritoryName("Congo"));
            board.setUserOccupant("Congo", userList[1]);
            board.getTerritoryName("Congo").setArmyPower(1);
            userList[1].addTerritory(board.getTerritoryName("SouthAfrica"));
            board.setUserOccupant("SouthAfrica", userList[1]);
            board.getTerritoryName("SouthAfrica").setArmyPower(1);
            userList[1].addTerritory(board.getTerritoryName("Madagascar"));
            board.setUserOccupant("Madagascar", userList[1]);
            board.getTerritoryName("Madagascar").setArmyPower(1);
            userList[1].addTerritory(board.getTerritoryName("Iceland"));
            board.setUserOccupant("Iceland", userList[1]);
            board.getTerritoryName("Iceland").setArmyPower(1);
            userList[1].addTerritory(board.getTerritoryName("Scandinavia"));
            board.setUserOccupant("Scandinavia", userList[1]);
            board.getTerritoryName("Scandinavia").setArmyPower(1);
            userList[1].addTerritory(board.getTerritoryName("Ukraine"));
            board.setUserOccupant("Ukraine", userList[1]);
            board.getTerritoryName("Ukraine").setArmyPower(1);
            userList[1].addTerritory(board.getTerritoryName("GreatBritian"));
            board.setUserOccupant("GreatBritian", userList[1]);
            board.getTerritoryName("GreatBritian").setArmyPower(1);
            userList[1].addTerritory(board.getTerritoryName("EasternAustralia"));
            board.setUserOccupant("EasternAustralia", userList[1]);
            board.getTerritoryName("EasternAustralia").setArmyPower(1);
            userList[1].addTerritory(board.getTerritoryName("Japan"));
            board.setUserOccupant("Japan", userList[1]);
            board.getTerritoryName("Japan").setArmyPower(1);

            // Add player 3's countries to HashMap
            userList[2] = new User(playerNames[2], startingArmyPowerPerPlayer);
            userList[2].addTerritory(board.getTerritoryName("NorthAfrica"));
            board.setUserOccupant("NorthAfrica", userList[2]);
            board.getTerritoryName("NorthAfrica").setArmyPower(1);
            userList[2].addTerritory(board.getTerritoryName("Egypt"));
            board.setUserOccupant("Egypt", userList[2]);
            board.getTerritoryName("Egypt").setArmyPower(1);
            userList[2].addTerritory(board.getTerritoryName("EastAfrica"));
            board.setUserOccupant("EastAfrica", userList[2]);
            board.getTerritoryName("EastAfrica").setArmyPower(1);
            userList[2].addTerritory(board.getTerritoryName("NorthernEurope"));
            board.setUserOccupant("NorthernEurope", userList[2]);
            board.getTerritoryName("NorthernEurope").setArmyPower(1);
            userList[2].addTerritory(board.getTerritoryName("SouthernEurope"));
            board.setUserOccupant("SouthernEurope", userList[2]);
            board.getTerritoryName("SouthernEurope").setArmyPower(1);
            userList[2].addTerritory(board.getTerritoryName("Western0Europe"));
            board.setUserOccupant("WesternEurope", userList[2]);
            board.getTerritoryName("Western0Europe").setArmyPower(1);
            userList[2].addTerritory(board.getTerritoryName("Indonesia"));
            board.setUserOccupant("Indonesia", userList[2]);
            board.getTerritoryName("Indonesia").setArmyPower(1);
            userList[2].addTerritory(board.getTerritoryName("NewGuinea"));
            board.setUserOccupant("NewGuinea", userList[2]);
            board.getTerritoryName("NewGuinea").setArmyPower(1);
            userList[2].addTerritory(board.getTerritoryName("WesternAustralia"));
            board.setUserOccupant("WesternAustralia", userList[2]);
            board.getTerritoryName("WesternAustralia").setArmyPower(1);
            userList[2].addTerritory(board.getTerritoryName("Siam"));
            board.setUserOccupant("Siam", userList[2]);
            board.getTerritoryName("Siam").setArmyPower(1);
            userList[2].addTerritory(board.getTerritoryName("India"));
            board.setUserOccupant("India", userList[2]);
            board.getTerritoryName("India").setArmyPower(1);
            userList[2].addTerritory(board.getTerritoryName("China"));
            board.setUserOccupant("China", userList[2]);
            board.getTerritoryName("China").setArmyPower(1);
            userList[2].addTerritory(board.getTerritoryName("Mongolia"));
            board.setUserOccupant("Mongolia", userList[2]);
            board.getTerritoryName("Mongolia").setArmyPower(1);
            userList[2].addTerritory(board.getTerritoryName("Peru"));
            board.setUserOccupant("Peru", userList[2]);
            board.getTerritoryName("Peru").setArmyPower(1);

        }
        else if(numPlayers == 4)
        {
            // Add player 1's countries to HashMap
            userList[0] = new User(playerNames[0], startingArmyPowerPerPlayer);
            userList[0].addTerritory(board.getTerritoryName("Alaska"));
            board.setUserOccupant("Alaska", userList[0]);
            board.getTerritoryName("Alaska").setArmyPower(1);
            userList[0].addTerritory(board.getTerritoryName("NorthwestTerritory"));
            board.setUserOccupant("NorthwestTerritory", userList[0]);
            board.getTerritoryName("NorthwestTerritory").setArmyPower(1);
            userList[0].addTerritory(board.getTerritoryName("Greenland"));
            board.setUserOccupant("Greenland", userList[0]);
            board.getTerritoryName("Greenland").setArmyPower(1);
            userList[0].addTerritory(board.getTerritoryName("Alberta"));
            board.setUserOccupant("Alberta", userList[0]);
            board.getTerritoryName("Alberta").setArmyPower(1);
            userList[0].addTerritory(board.getTerritoryName("Madagascar"));
            board.setUserOccupant("Madagascar", userList[0]);
            board.getTerritoryName("Madagascar").setArmyPower(1);
            userList[0].addTerritory(board.getTerritoryName("Iceland"));
            board.setUserOccupant("Iceland", userList[0]);
            board.getTerritoryName("Iceland").setArmyPower(1);
            userList[0].addTerritory(board.getTerritoryName("Scandinavia"));
            board.setUserOccupant("Scandinavia", userList[0]);
            board.getTerritoryName("Scandinavia").setArmyPower(1);
            userList[0].addTerritory(board.getTerritoryName("Ukraine"));
            board.setUserOccupant("Ukraine", userList[0]);
            board.getTerritoryName("Ukraine").setArmyPower(1);
            userList[0].addTerritory(board.getTerritoryName("Japan"));
            board.setUserOccupant("Japan", userList[0]);
            board.getTerritoryName("Japan").setArmyPower(1);
            userList[0].addTerritory(board.getTerritoryName("Irkutsk"));
            board.setUserOccupant("Irkutsk", userList[0]);
            board.getTerritoryName("Irkutsk").setArmyPower(1);
            userList[0].addTerritory(board.getTerritoryName("EasternUnitedStates"));
            board.setUserOccupant("EasternUnitedStates", userList[0]);
            board.getTerritoryName("EasternUnitedStates").setArmyPower(1);

            // Add player 2's countries to HashMap
            userList[1] = new User(playerNames[1], startingArmyPowerPerPlayer);
            userList[1].addTerritory(board.getTerritoryName("NorthernEurope"));
            board.setUserOccupant("NorthernEurope", userList[1]);
            board.getTerritoryName("NorthernEurope").setArmyPower(1);
            userList[1].addTerritory(board.getTerritoryName("SouthernEurope"));
            board.setUserOccupant("SouthernEurope", userList[1]);
            board.getTerritoryName("SouthernEurope").setArmyPower(1);
            userList[1].addTerritory(board.getTerritoryName("WesternEurope"));
            board.setUserOccupant("WesternEurope", userList[1]);
            board.getTerritoryName("WesternEurope").setArmyPower(1);
            userList[1].addTerritory(board.getTerritoryName("Indonesia"));
            board.setUserOccupant("Indonesia", userList[1]);
            board.getTerritoryName("Indonesia").setArmyPower(1);
            userList[1].addTerritory(board.getTerritoryName("SouthAfrica"));
            board.setUserOccupant("SouthAfrica", userList[1]);
            board.getTerritoryName("SouthAfrica").setArmyPower(1);
            userList[1].addTerritory(board.getTerritoryName("GreatBritian"));
            board.setUserOccupant("GreatBritian", userList[1]);
            board.getTerritoryName("GreatBritian").setArmyPower(1);
            userList[1].addTerritory(board.getTerritoryName("EasternAustralia"));
            board.setUserOccupant("EasternAustralia", userList[1]);
            board.getTerritoryName("EasternAustralia").setArmyPower(1);
            userList[1].addTerritory(board.getTerritoryName("Yakutsk"));
            board.setUserOccupant("Yakutsk", userList[1]);
            board.getTerritoryName("Yakutsk").setArmyPower(1);
            userList[1].addTerritory(board.getTerritoryName("Afghanistan"));
            board.setUserOccupant("Afghanistan", userList[1]);
            board.getTerritoryName("Afghanistan").setArmyPower(1);
            userList[1].addTerritory(board.getTerritoryName("Ural"));
            board.setUserOccupant("Ural", userList[1]);
            board.getTerritoryName("Ural").setArmyPower(1);
            userList[1].addTerritory(board.getTerritoryName("MiddleEast"));
            board.setUserOccupant("MiddleEast", userList[1]);
            board.getTerritoryName("MiddleEast").setArmyPower(1);

            // Add player 3's countries to HashMap
            userList[2] = new User(playerNames[2], startingArmyPowerPerPlayer);
            userList[2].addTerritory(board.getTerritoryName("Ontario"));
            board.setUserOccupant("Ontario", userList[2]);
            board.getTerritoryName("MiddleEast").setArmyPower(1);
            userList[2].addTerritory(board.getTerritoryName("Venezuela"));
            board.setUserOccupant("Venezuela", userList[2]);
            board.getTerritoryName("MiddleEast").setArmyPower(1);
            userList[2].addTerritory(board.getTerritoryName("Brazil"));
            board.setUserOccupant("Brazil", userList[2]);
            board.getTerritoryName("MiddleEast").setArmyPower(1);
            userList[2].addTerritory(board.getTerritoryName("NorthAfrica"));
            board.setUserOccupant("NorthAfrica", userList[2]);
            board.getTerritoryName("MiddleEast").setArmyPower(1);
            userList[2].addTerritory(board.getTerritoryName("Egypt"));
            board.setUserOccupant("Egypt", userList[2]);
            board.getTerritoryName("MiddleEast").setArmyPower(1);
            userList[2].addTerritory(board.getTerritoryName("EastAfrica"));
            board.setUserOccupant("EastAfrica", userList[2]);
            board.getTerritoryName("MiddleEast").setArmyPower(1);
            userList[2].addTerritory(board.getTerritoryName("Argentina"));
            board.setUserOccupant("Argentina", userList[2]);
            board.getTerritoryName("MiddleEast").setArmyPower(1);
            userList[2].addTerritory(board.getTerritoryName("Congo"));
            board.setUserOccupant("Congo", userList[2]);
            board.getTerritoryName("MiddleEast").setArmyPower(1);
            userList[2].addTerritory(board.getTerritoryName("Kamchatka"));
            board.setUserOccupant("Kamchatka", userList[2]);
            board.getTerritoryName("MiddleEast").setArmyPower(1);
            userList[2].addTerritory(board.getTerritoryName("Siberia"));
            board.setUserOccupant("Siberia", userList[2]);
            board.getTerritoryName("MiddleEast").setArmyPower(1);

            // Add player 4's countries to HashMap
            userList[3] = new User(playerNames[3], startingArmyPowerPerPlayer);
            userList[3].addTerritory(board.getTerritoryName("NewGuinea"));
            board.setUserOccupant("NewGuinea", userList[3]);
            board.getTerritoryName("NewGuinea").setArmyPower(1);
            userList[3].addTerritory(board.getTerritoryName("WesternAustralia"));
            board.setUserOccupant("WesternAustralia", userList[3]);
            board.getTerritoryName("WesternAustralia").setArmyPower(1);
            userList[3].addTerritory(board.getTerritoryName("Siam"));
            board.setUserOccupant("Siam", userList[3]);
            board.getTerritoryName("Siam").setArmyPower(1);
            userList[3].addTerritory(board.getTerritoryName("India"));
            board.setUserOccupant("India", userList[3]);
            board.getTerritoryName("India").setArmyPower(1);
            userList[3].addTerritory(board.getTerritoryName("China"));
            board.setUserOccupant("China", userList[3]);
            board.getTerritoryName("China").setArmyPower(1);
            userList[3].addTerritory(board.getTerritoryName("Mongolia"));
            board.setUserOccupant("Mongolia", userList[3]);
            board.getTerritoryName("Mongolia").setArmyPower(1);
            userList[3].addTerritory(board.getTerritoryName("Peru"));
            board.setUserOccupant("Peru", userList[3]);
            board.getTerritoryName("Peru").setArmyPower(1);
            userList[3].addTerritory(board.getTerritoryName("Quebec"));
            board.setUserOccupant("Quebec", userList[3]);
            board.getTerritoryName("Quebec").setArmyPower(1);
            userList[3].addTerritory(board.getTerritoryName("WesternUnitedStates"));
            board.setUserOccupant("WesternUnitedStates", userList[3]);
            board.getTerritoryName("WesternUnitedStates").setArmyPower(1);
            userList[3].addTerritory(board.getTerritoryName("CentralAmerica"));
            board.setUserOccupant("CentralAmerica", userList[3]);
            board.getTerritoryName("CentralAmerica").setArmyPower(1);
        }
        else if(numPlayers == 5)
        {
            // Add player 1's countries to HashMap
            userList[0] = new User(playerNames[0], startingArmyPowerPerPlayer);
            userList[0].addTerritory(board.getTerritoryName("Alaska"));
            board.setUserOccupant("Alaska", userList[0]);
            board.getTerritoryName("Alaska").setArmyPower(1);
            userList[0].addTerritory(board.getTerritoryName("NorthwestTerritory"));
            board.setUserOccupant("NorthwestTerritory", userList[0]);
            board.getTerritoryName("NorthwestTerritory").setArmyPower(1);
            userList[0].addTerritory(board.getTerritoryName("Greenland"));
            board.setUserOccupant("Greenland", userList[0]);
            board.getTerritoryName("Greenland").setArmyPower(1);
            userList[0].addTerritory(board.getTerritoryName("Alberta"));
            board.setUserOccupant("Alberta", userList[0]);
            board.getTerritoryName("Alberta").setArmyPower(1);
            userList[0].addTerritory(board.getTerritoryName("Madagascar"));
            board.setUserOccupant("Madagascar", userList[0]);
            board.getTerritoryName("Madagascar").setArmyPower(1);
            userList[0].addTerritory(board.getTerritoryName("Scandinavia"));
            board.setUserOccupant("Scandinavia", userList[0]);
            board.getTerritoryName("Scandinavia").setArmyPower(1);
            userList[0].addTerritory(board.getTerritoryName("Iceland"));
            board.setUserOccupant("Iceland", userList[0]);
            board.getTerritoryName("Iceland").setArmyPower(1);
            userList[0].addTerritory(board.getTerritoryName("Ukraine"));
            board.setUserOccupant("Ukraine", userList[0]);
            board.getTerritoryName("Ukraine").setArmyPower(1);
            userList[0].addTerritory(board.getTerritoryName("Japan"));
            board.setUserOccupant("Japan", userList[0]);
            board.getTerritoryName("Japan").setArmyPower(1);

            // Add player 2's countries to HashMap
            userList[1] = new User(playerNames[1], startingArmyPowerPerPlayer);
            userList[1].addTerritory(board.getTerritoryName("Irkutsk"));
            board.setUserOccupant("Irkutsk", userList[1]);
            board.getTerritoryName("Irkutsk").setArmyPower(1);
            userList[1].addTerritory(board.getTerritoryName("EasternUnitedStates"));
            board.setUserOccupant("EasternUnitedStates", userList[1]);
            board.getTerritoryName("EasternUnitedStates").setArmyPower(1);
            userList[1].addTerritory(board.getTerritoryName("NorthernEurope"));
            board.setUserOccupant("NorthernEurope", userList[1]);
            board.getTerritoryName("NorthernEurope").setArmyPower(1);
            userList[1].addTerritory(board.getTerritoryName("SouthernEurope"));
            board.setUserOccupant("SouthernEurope", userList[1]);
            board.getTerritoryName("SouthernEurope").setArmyPower(1);
            userList[1].addTerritory(board.getTerritoryName("WesternEurope"));
            board.setUserOccupant("WesternEurope", userList[1]);
            board.getTerritoryName("WesternEurope").setArmyPower(1);
            userList[1].addTerritory(board.getTerritoryName("Indonesia"));
            board.setUserOccupant("Indonesia", userList[1]);
            board.getTerritoryName("Indonesia").setArmyPower(1);
            userList[1].addTerritory(board.getTerritoryName("SouthAfrica"));
            board.setUserOccupant("SouthAfrica", userList[1]);
            board.getTerritoryName("SouthAfrica").setArmyPower(1);
            userList[1].addTerritory(board.getTerritoryName("GreatBritian"));
            board.setUserOccupant("GreatBritian", userList[1]);
            board.getTerritoryName("GreatBritian").setArmyPower(1);
            userList[1].addTerritory(board.getTerritoryName("EasternAustralia"));
            board.setUserOccupant("EasternAustralia", userList[1]);
            board.getTerritoryName("EasternAustralia").setArmyPower(1);

            // Add player 3's countries to HashMap
            userList[2] = new User(playerNames[2], startingArmyPowerPerPlayer);
            userList[2].addTerritory(board.getTerritoryName("Yakutsk"));
            board.setUserOccupant("Yakutsk", userList[2]);
            board.getTerritoryName("Yakutsk").setArmyPower(1);
            userList[2].addTerritory(board.getTerritoryName("Afghanistan"));
            board.setUserOccupant("Afghanistan", userList[2]);
            board.getTerritoryName("Afghanistan").setArmyPower(1);
            userList[2].addTerritory(board.getTerritoryName("Ural"));
            board.setUserOccupant("Ural", userList[2]);
            board.getTerritoryName("Ural").setArmyPower(1);
            userList[2].addTerritory(board.getTerritoryName("MiddleEast"));
            board.setUserOccupant("MiddleEast", userList[2]);
            board.getTerritoryName("MiddleEast").setArmyPower(1);
            userList[2].addTerritory(board.getTerritoryName("Ontario"));
            board.setUserOccupant("Ontario", userList[2]);
            board.getTerritoryName("Ontario").setArmyPower(1);
            userList[2].addTerritory(board.getTerritoryName("Venezuela"));
            board.setUserOccupant("Venezuela", userList[2]);
            board.getTerritoryName("Venezuela").setArmyPower(1);
            userList[2].addTerritory(board.getTerritoryName("Brazil"));
            board.setUserOccupant("Brazil", userList[2]);
            board.getTerritoryName("Brazil").setArmyPower(1);
            userList[2].addTerritory(board.getTerritoryName("NorthAfrica"));
            board.setUserOccupant("NorthAfrica", userList[2]);
            board.getTerritoryName("NorthAfrica").setArmyPower(1);

            // Add player 4's countries to HashMap
            userList[3] = new User(playerNames[3], startingArmyPowerPerPlayer);
            userList[3].addTerritory(board.getTerritoryName("Egypt"));
            board.setUserOccupant("Egypt", userList[3]);
            board.getTerritoryName("Egypt").setArmyPower(1);
            userList[3].addTerritory(board.getTerritoryName("EastAfrica"));
            board.setUserOccupant("EastAfrica", userList[3]);
            board.getTerritoryName("EastAfrica").setArmyPower(1);
            userList[3].addTerritory(board.getTerritoryName("Argentina"));
            board.setUserOccupant("Argentina", userList[3]);
            board.getTerritoryName("Argentina").setArmyPower(1);
            userList[3].addTerritory(board.getTerritoryName("Congo"));
            board.setUserOccupant("Congo", userList[3]);
            board.getTerritoryName("Congo").setArmyPower(1);
            userList[3].addTerritory(board.getTerritoryName("Kamchatka"));
            board.setUserOccupant("Kamchatka", userList[3]);
            board.getTerritoryName("Kamchatka").setArmyPower(1);
            userList[3].addTerritory(board.getTerritoryName("Siberia"));
            board.setUserOccupant("Siberia", userList[3]);
            board.getTerritoryName("Siberia").setArmyPower(1);
            userList[3].addTerritory(board.getTerritoryName("NewGuinea"));
            board.setUserOccupant("NewGuinea", userList[3]);
            board.getTerritoryName("NewGuinea").setArmyPower(1);
            userList[3].addTerritory(board.getTerritoryName("WesternAustralia"));
            board.setUserOccupant("WesternAustralia", userList[3]);
            board.getTerritoryName("WesternAustralia").setArmyPower(1);

            // Add player 5's countries to HashMap
            userList[4] = new User(playerNames[4], startingArmyPowerPerPlayer);
            userList[4].addTerritory(board.getTerritoryName("Siam"));
            board.setUserOccupant("Siam", userList[4]);
            board.getTerritoryName("Siam").setArmyPower(1);
            userList[4].addTerritory(board.getTerritoryName("India"));
            board.setUserOccupant("India", userList[4]);
            board.getTerritoryName("India").setArmyPower(1);
            userList[4].addTerritory(board.getTerritoryName("China"));
            board.setUserOccupant("China", userList[4]);
            board.getTerritoryName("China").setArmyPower(1);
            userList[4].addTerritory(board.getTerritoryName("Mongolia"));
            board.setUserOccupant("Mongolia", userList[4]);
            board.getTerritoryName("Mongolia").setArmyPower(1);
            userList[4].addTerritory(board.getTerritoryName("Peru"));
            board.setUserOccupant("Peru", userList[4]);
            board.getTerritoryName("Peru").setArmyPower(1);
            userList[4].addTerritory(board.getTerritoryName("Quebec"));
            board.setUserOccupant("Quebec", userList[4]);
            board.getTerritoryName("Quebec").setArmyPower(1);
            userList[4].addTerritory(board.getTerritoryName("WesternUnitedStates"));
            board.setUserOccupant("WesternUnitedStates", userList[4]);
            board.getTerritoryName("WesternUnitedStates").setArmyPower(1);
            userList[4].addTerritory(board.getTerritoryName("CentralAmerica"));
            board.setUserOccupant("CentralAmerica", userList[4]);
            board.getTerritoryName("CentralAmerica").setArmyPower(1);
        }
        else // Number of Players is 6
        {
            // Add player 1's countries to HashMap
            userList[0] = new User(playerNames[0], startingArmyPowerPerPlayer);
            userList[0].addTerritory(board.getTerritoryName("Alaska"));
            board.setUserOccupant("Alaska", userList[0]);
            board.getTerritoryName("Alaska").setArmyPower(1);
            userList[0].addTerritory(board.getTerritoryName("NorthwestTerritory"));
            board.setUserOccupant("NorthwestTerritory", userList[0]);
            board.getTerritoryName("NorthwestTerritory").setArmyPower(1);
            userList[0].addTerritory(board.getTerritoryName("Greenland"));
            board.setUserOccupant("Greenland", userList[0]);
            board.getTerritoryName("Greenland").setArmyPower(1);
            userList[0].addTerritory(board.getTerritoryName("Alberta"));
            board.setUserOccupant("Alberta", userList[0]);
            board.getTerritoryName("Alberta").setArmyPower(1);
            userList[0].addTerritory(board.getTerritoryName("Ontario"));
            board.setUserOccupant("Ontario", userList[0]);
            board.getTerritoryName("Ontario").setArmyPower(1);
            userList[0].addTerritory(board.getTerritoryName("Venezuela"));
            board.setUserOccupant("Venezuela", userList[0]);
            board.getTerritoryName("Venezuela").setArmyPower(1);
            userList[0].addTerritory(board.getTerritoryName("Brazil"));
            board.setUserOccupant("Brazil", userList[0]);
            board.getTerritoryName("Brazil").setArmyPower(1);

            // Add player 2's countries to HashMap
            userList[1] = new User(playerNames[1], startingArmyPowerPerPlayer);
            userList[1].addTerritory(board.getTerritoryName("NorthAfrica"));
            board.setUserOccupant("NorthAfrica", userList[1]);
            board.getTerritoryName("NorthAfrica").setArmyPower(1);
            userList[1].addTerritory(board.getTerritoryName("Egypt"));
            board.setUserOccupant("Egypt", userList[1]);
            board.getTerritoryName("Egypt").setArmyPower(1);
            userList[1].addTerritory(board.getTerritoryName("EastAfrica"));
            board.setUserOccupant("EastAfrica", userList[1]);
            board.getTerritoryName("EastAfrica").setArmyPower(1);
            userList[1].addTerritory(board.getTerritoryName("NorthernEurope"));
            board.setUserOccupant("NorthernEurope", userList[1]);
            board.getTerritoryName("NorthernEurope").setArmyPower(1);
            userList[1].addTerritory(board.getTerritoryName("SouthernEurope"));
            board.setUserOccupant("SouthernEurope", userList[1]);
            board.getTerritoryName("SouthernEurope").setArmyPower(1);
            userList[1].addTerritory(board.getTerritoryName("WesternEurope"));
            board.setUserOccupant("WesternEurope", userList[1]);
            board.getTerritoryName("WesternEurope").setArmyPower(1);
            userList[1].addTerritory(board.getTerritoryName("Indonesia"));
            board.setUserOccupant("Indonesia", userList[1]);
            board.getTerritoryName("Indonesia").setArmyPower(1);

            // Add player 3's countries to HashMap
            userList[2] = new User(playerNames[2], startingArmyPowerPerPlayer);
            userList[2].addTerritory(board.getTerritoryName("NewGuinea"));
            board.setUserOccupant("NewGuinea", userList[2]);
            board.getTerritoryName("NewGuinea").setArmyPower(1);
            userList[2].addTerritory(board.getTerritoryName("WesternAustralia"));
            board.setUserOccupant("WesternAustralia", userList[2]);
            board.getTerritoryName("WesternAustralia").setArmyPower(1);
            userList[2].addTerritory(board.getTerritoryName("Siam"));
            board.setUserOccupant("Siam", userList[2]);
            board.getTerritoryName("Siam").setArmyPower(1);
            userList[2].addTerritory(board.getTerritoryName("India"));
            board.setUserOccupant("India", userList[2]);
            board.getTerritoryName("India").setArmyPower(1);
            userList[2].addTerritory(board.getTerritoryName("China"));
            board.setUserOccupant("China", userList[2]);
            board.getTerritoryName("China").setArmyPower(1);
            userList[2].addTerritory(board.getTerritoryName("Mongolia"));
            board.setUserOccupant("Mongolia", userList[2]);
            board.getTerritoryName("Mongolia").setArmyPower(1);
            userList[2].addTerritory(board.getTerritoryName("Peru"));
            board.setUserOccupant("Peru", userList[2]);
            board.getTerritoryName("Peru").setArmyPower(1);

            // Add player 4's countries to HashMap
            userList[3] = new User(playerNames[3], startingArmyPowerPerPlayer);
            userList[3].addTerritory(board.getTerritoryName("Quebec"));
            board.setUserOccupant("Quebec", userList[3]);
            board.getTerritoryName("Quebec").setArmyPower(1);
            userList[3].addTerritory(board.getTerritoryName("WesternUnitedStates"));
            board.setUserOccupant("WesternUnitedStates", userList[3]);
            board.getTerritoryName("WesternUnitedStates").setArmyPower(1);
            userList[3].addTerritory(board.getTerritoryName("EasternUnitedStates"));
            board.setUserOccupant("EasternUnitedStates", userList[3]);
            board.getTerritoryName("EasternUnitedStates").setArmyPower(1);
            userList[3].addTerritory(board.getTerritoryName("CentralAmerica"));
            board.setUserOccupant("CentralAmerica", userList[3]);
            board.getTerritoryName("CentralAmerica").setArmyPower(1);
            userList[3].addTerritory(board.getTerritoryName("Argentina"));
            board.setUserOccupant("Argentina", userList[3]);
            board.getTerritoryName("Argentina").setArmyPower(1);
            userList[3].addTerritory(board.getTerritoryName("Congo"));
            board.setUserOccupant("Congo", userList[3]);
            board.getTerritoryName("Congo").setArmyPower(1);
            userList[3].addTerritory(board.getTerritoryName("SouthAfrica"));
            board.setUserOccupant("SouthAfrica", userList[3]);
            board.getTerritoryName("SouthAfrica").setArmyPower(1);

            // Add player 5's countries to HashMap
            userList[4] = new User(playerNames[4], startingArmyPowerPerPlayer);
            userList[4].addTerritory(board.getTerritoryName("Madagascar"));
            board.setUserOccupant("Madagascar", userList[4]);
            board.getTerritoryName("Madagascar").setArmyPower(1);
            userList[4].addTerritory(board.getTerritoryName("Iceland"));
            board.setUserOccupant("Iceland", userList[4]);
            board.getTerritoryName("Iceland").setArmyPower(1);
            userList[4].addTerritory(board.getTerritoryName("Scandinavia"));
            board.setUserOccupant("Scandinavia", userList[4]);
            board.getTerritoryName("Scandinavia").setArmyPower(1);
            userList[4].addTerritory(board.getTerritoryName("Ukraine"));
            board.setUserOccupant("Ukraine", userList[4]);
            board.getTerritoryName("Ukraine").setArmyPower(1);
            userList[4].addTerritory(board.getTerritoryName("GreatBritian"));
            board.setUserOccupant("GreatBritian", userList[4]);
            board.getTerritoryName("GreatBritian").setArmyPower(1);
            userList[4].addTerritory(board.getTerritoryName("EasternAustralia"));
            board.setUserOccupant("EasternAustralia", userList[4]);
            board.getTerritoryName("EasternAustralia").setArmyPower(1);
            userList[4].addTerritory(board.getTerritoryName("Japan"));
            board.setUserOccupant("Japan", userList[4]);
            board.getTerritoryName("Japan").setArmyPower(1);

            // Add player 6's countries to HashMap
            userList[5] = new User(playerNames[5], startingArmyPowerPerPlayer);
            userList[5].addTerritory(board.getTerritoryName("Irkutsk"));
            board.setUserOccupant("Irkutsk", userList[5]);
            board.getTerritoryName("Irkutsk").setArmyPower(1);
            userList[5].addTerritory(board.getTerritoryName("Yakutsk"));
            board.setUserOccupant("Yakutsk", userList[5]);
            board.getTerritoryName("Yakutsk").setArmyPower(1);
            userList[5].addTerritory(board.getTerritoryName("Kamchatka"));
            board.setUserOccupant("Kamchatka", userList[5]);
            board.getTerritoryName("Kamchatka").setArmyPower(1);
            userList[5].addTerritory(board.getTerritoryName("Siberia"));
            board.setUserOccupant("Siberia", userList[5]);
            board.getTerritoryName("Siberia").setArmyPower(1);
            userList[5].addTerritory(board.getTerritoryName("Afghanistan"));
            board.setUserOccupant("Afghanistan", userList[5]);
            board.getTerritoryName("Afghanistan").setArmyPower(1);
            userList[5].addTerritory(board.getTerritoryName("Ural"));
            board.setUserOccupant("Ural", userList[5]);
            board.getTerritoryName("Ural").setArmyPower(1);
            userList[5].addTerritory(board.getTerritoryName("MiddleEast"));
            board.setUserOccupant("MiddleEast", userList[5]);
            board.getTerritoryName("MiddleEast").setArmyPower(1);
        }

        // Spawn deck
        Deck deck = new Deck(board.getBoardTerritories());

        // More Testing
        System.out.println(userList[0].getUsername());

        Scanner attack = new Scanner(System.in);
        Scanner attackRedo = new Scanner(System.in);
        Scanner attackAmt = new Scanner(System.in);
        Scanner fortifyChoice = new Scanner(System.in);
        Scanner attackerLocation = new Scanner(System.in);
        Scanner attackAdjCheck = new Scanner(System.in);
        Scanner finalAttackChoice = new Scanner(System.in);

        // Testing for now
        board.getTerritoryName("Alaska").setArmyPower(20);
        board.getTerritoryName("NorthwestTerritory").setArmyPower(20);

        // Game flag. Remove players from array who do not have territories. When one is left, he wins and game ends
        // WHEN TESTING ON INTELLIJ YOU MUST STOP THE PROGRAM MANUALLY AS THIS IS AN INFINITE LOOP RIGHT NOW

        while((userList.length) != 1)
        {

            // Loop through each players turn. They must attack for right now
            userloop:
            for(int i = 0; i < (userList.length); i++)
            {
                // Display credit costs for purchasing features
                System.out.println("Here are the features you can purchase with credits and their amounts: ");
                System.out.println("Undo attack: 5 credits");
                System.out.println("Draw an extra card: 3 credits");
                System.out.println("Transfer credits to another player: 10 credits");
                System.out.println();

                // Have the User draw a card
                Card drawnCard = deck.card_draw();
                System.out.println(drawnCard.getName());
                userList[i].addCard(drawnCard);

                //Test drawn card
                System.out.println(userList[i].getHand());

                // Each player gets 1 new credit at the beginning of the turn
                userList[i].incrementCredit();
                System.out.println(userList[i].getUsername() + " , you have gained 1 credit this turn");
                /*
                    Update Twitter counts with:
                    tp.incrementCount(1);
                    userList[i].incrementTwitterCount(1);
                    when they conquer a territory
                */

                // Check if User has to turn in cards (ignoring for now)

                // Increment total armies (ignoring Continent Bonus for now)
                // Increment armies based off number of territories, userList[i].numArmiesAdd();
                addedArmies = userList[i].numArmiesAdded();
                userList[i].numArmiesAdded();

                // Will add while loop later to allow them to place at different territories
                // Prompt to see where they want to place them
                boolean fortifyFlag = true;
                while(fortifyFlag) {
                    System.out.println("Player " + userList[i].getUsername() + " you have gained " + addedArmies + " armies, " +
                            "wheat Territory would you like to place them at?");

                    // Store their territories in a variable
                    ArrayList<Territory> userTerritories = userList[i].getUserTerritories();

                    // Iterate through that variable to display string
                    for (int j = 0; j < userTerritories.size(); j++) {
                        System.out.println(userTerritories.get(j).getName());
                    }

                    // Store their choice
                    String fortify = "";
                    GameTimer turnTimer = new GameTimer();
                        if(turnTimer.getTimedInput()) {
                           fortify = turnTimer.getLastInput();
                        } else{
                            System.out.println("You ran out of time! Skipping your turn...");
                            continue;
                        }
                    //String fortify = fortifyChoice.nextLine();

                    if(board.getTerritoryName(fortify).getUser() == userList[i]) {
                        // Query the board and update the chosen territory's army power
                        board.getTerritoryName(fortify).incrementArmies(addedArmies);
                        System.out.println(fortify + " now has " + board.getTerritoryName(fortify).getArmyPower() + " armies");
                        writer.println(userList[i].getUsername() + " is fortifying the territory of: " + fortify);
                        fortifyFlag = false;
                    }
                    else {
                        System.out.println("That territory is not under your control, please try again");
                    }
                }
                // Based on result, increment/decrement that country's armies
                // If country army total has 0 leftover, remove from defeated player's HashMap
                // Add that country to victor's HashMap
                // Call function to increment twitter count by 1
                // Decrement original country by 1 and add it to victor's new country
                // Check if defeated player's HashMap size is equal to 0
                // If it is equal to 0, remove them from userList
                attackFlag = true;
                int conqueredCount = 0;
                while(attackFlag)
                {
                    // put timer thread here.
                    // rest of this code in a try block

                    boolean adjacentFlag = true;
                    while(adjacentFlag) {
                        //prompt user for country they are attacking from
                        System.out.println(userList[i].getUsername() + ", what territory would you like to attack from?");


                        String attackPlace = "";
                        GameTimer turnTimer = new GameTimer();
                        if(turnTimer.getTimedInput()) {
                            attackPlace = turnTimer.getLastInput();
                        } else{
                            System.out.println("You ran out of time! Skipping your turn...");
                            continue userloop;
                        }

                        ArrayList<Territory> listAdjacencies = board.getAdjacencies(attackPlace);
                        /*
                        System.out.println(listAdjacencies.get(0).getTerritory());
                        System.out.println(listAdjacencies.get(1).getTerritory());
                        */
                        for(int j = 0; j < listAdjacencies.size(); j++)
                        {
                            System.out.println(listAdjacencies.get(j).getTerritory());
                        }

                        //prompt user for country to attack
                        System.out.println(userList[i].getUsername() + ", what territory would you like to attack?");
                        String attackTarget = "";
                        //GameTimer turnTimer = new GameTimer();
                        if(turnTimer.getTimedInput()) {
                            attackTarget = turnTimer.getLastInput();
                        } else{
                            System.out.println("You ran out of time! Skipping your turn...");
                            continue userloop;
                        }
                        boolean isAdj = board.checkAdjacencies(attackPlace, attackTarget);

                        if(isAdj){
                            adjacentFlag = false;
                        }
                        else{
                            System.out.println("That territory is not an adjacency");
                        }
                    }
                    System.out.println("Please confirm the territory you are attacking from");
                    String finalChoice = finalAttackChoice.nextLine();

                    System.out.println("Please confirm the territory you wish to attack: ");
                    String attackChoice = attack.nextLine();

                    User user1 = userList[i];
                    User user2 = board.getTerritoryName(attackChoice).getUser();

                    // Display alert to user, per Demo 0.4 requirements
                    System.out.println("Player " + user2.getUsername() + " your territory is under attack!");

                    System.out.println("Enter the number of armies attacking: ");
                    int amount;
                    GameTimer turnTimer = new GameTimer();
                    if(turnTimer.getTimedInput()) {
                        amount = Integer.parseInt(turnTimer.getLastInput());
                    } else{
                        System.out.println("You ran out of time! Skipping your turn...");
                        continue userloop;
                    }

                    // Write to file
                    writer.println(user1 + " is attacking with " + amount + " of armies");

                    Dice d1 = new Dice();
                    Dice d2 = new Dice();

                    int user1Die = d1.getFaceValue();
                    int user2Die = d2.getFaceValue();

                    if(user1Die > user2Die) {
                        System.out.println("Attacking player has won the duel \n");
                        user2.removeArmyPower(amount);
                        board.getTerritoryName(attackChoice).decrementArmies(amount);
                        System.out.println("Territory " + board.getTerritoryName(attackChoice).getTerritory() + " now has " +
                                board.getTerritoryName(attackChoice).getArmyPower() + " armies remaining");

                        writer.println(user2 + " has lost " + amount + " of armies in " + board.getTerritoryName(attackChoice).getTerritory());

                        // Check if they would like to undo
                        System.out.println("Would you like to undo this action?");
                        String attackUndoCheck = attackRedo.nextLine();

                        if (attackUndoCheck.equals("Yes")) {
                            writer.println(user1 + " is undoing there actions, resetting armies to previous");
                            user2.addArmyPower(amount);
                            System.out.println("User 2's army power: " + user2.getArmyPower());

                            board.getTerritoryName(attackChoice).incrementArmies(amount);
                            System.out.println(board.getTerritoryName(attackChoice).getTerritory() + "'s army power has increased to " +
                                    board.getTerritoryName(attackChoice).getArmyPower());
                        } else if (attackUndoCheck.equals("No")) {
                            attackFlag = false;
                        }
                    }

                    else if(user1Die <= user2Die){
                        System.out.println("Defending player has successfully defended! \n");
                        user1.removeArmyPower(amount);
                        board.getTerritoryName(finalChoice).decrementArmies(amount);

                        System.out.println("Territory " + board.getTerritoryName(finalChoice).getTerritory() + " now has " +
                                board.getTerritoryName(finalChoice).getArmyPower() + " armies remaining");

                        writer.println(user1 + " has lost " + amount + " of armies in " + board.getTerritoryName(finalChoice).getTerritory());

                        // Check if they would like to undo
                        System.out.println("Would you like to undo this action?");
                        String attackUndoCheck = attackRedo.nextLine();

                        if (attackUndoCheck.equals("Yes")) {
                            writer.println(user1 + " is undoing there actions, resetting armies to previous");
                            user1.addArmyPower(amount);
                            System.out.println("User 1's army power: " + user1.getArmyPower());

                            board.getTerritoryName(finalChoice).incrementArmies(amount);
                            System.out.println(board.getTerritoryName(finalChoice).getTerritory() + "'s army power has increased to " +
                                    board.getTerritoryName(finalChoice).getArmyPower());
                        } else if (attackUndoCheck.equals("No")) {
                            attackFlag = false;
                        }

                    }
                }

                tp.postTurnStatus(userList[i], tp.getCount());

                /*
                Twitter twitter = TwitterFactory.getSingleton();
                String message = "Player " + userList[i].getUsername() + " has conquered " + conqueredCount + " territories";
                Status status = twitter.updateStatus(message);
                */

                /*
                // Post amount of territories conquered by player this turn
                tp.postTurnStatus(userList[i], tp.getCount());

                // Reset turn count to 0 to keep track of next player in loop
                tp.resetCount();
                */


                // Shuffle deck
                deck.shuffle();

            }
        }

        // Pushing to Amazon
        //s3client.putObject(new PutObjectRequest("risk-game4353", "Replay", new File(parentDir + "/src/resources/replay.txt")));

        // Begin posting final twitter status messages
        for(int i = 0; i < numPlayers; i++){
            tp.postFinalStatus(twitterList[i]);
        }

        System.out.println("Congratulations " + userList[0].getUsername() + " on winning the game of Risk!");
    }
}
