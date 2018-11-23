import java.util.Scanner;
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
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.*;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.ApiContextInitializer;


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

        // Telegram Bot call
        ApiContextInitializer.init();

        TelegramBotsApi telegramBotsApi = new TelegramBotsApi();

        try {
            telegramBotsApi.registerBot(new DadBot());
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }

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

        Board board = new Board();
        board.setupBoard();

        TweetPoster tp = new TweetPoster();

        // Spawn deck
        Deck deck = new Deck(board.getBoardTerritories());

        // Game flag. Remove players from array who do not have territories. When one is left, he wins and game ends
        // WHEN TESTING ON INTELLIJ YOU MUST STOP THE PROGRAM MANUALLY AS THIS IS AN INFINITE LOOP RIGHT NOW

        while((userList.length) != 1)
        {

            // Loop through each players turn. They must attack for right now
            for(int i = 0; i < (userList.length); i++)
            {
                // Display credit costs for purchasing features
                System.out.println("Here are the features you can purchase with credits and their amounts: ");
                System.out.println("Undo attack: 5 credits");
                System.out.println("Draw an extra card: 3 credits");
                System.out.println("Transfer credits to another player: 10 credits");
                System.out.println();


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
