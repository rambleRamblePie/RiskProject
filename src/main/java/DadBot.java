import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.*;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
//import org.telegram.telegrambots.ApiContextInitializer;
import java.util.*;

public class DadBot extends TelegramLongPollingBot{

    Random rand = new Random();
    String gameID = Integer.toString((rand.nextInt(5000) + 1000));
    ArrayList<User> userList = new ArrayList<User>();
    ArrayList<String> container = new ArrayList<String>();
    int counter = 0;

    Board board = new Board();

    ArrayList<Territory> territoryHolder = new ArrayList<Territory>();

    @Override
    public void onUpdateReceived(Update update) {

        if (update.hasMessage() && update.getMessage().hasText()) {

            container.clear();

            // Set variables
            String message_text = update.getMessage().getText();
            long chat_id = update.getMessage().getChatId();
            String username = update.getMessage().getFrom().getFirstName();

            String[] tokens = message_text.split(":");
            for (String t : tokens) {
                container.add(t);
                System.out.println(t);
            }

            message_text = container.get(0);

            if(container.size() == 2){
                System.out.println(container.get(1));
            }




            // Start the game. Sets up the board, deck and Twitter functionality
            if(message_text.equals("/start@TeamHALBot")){
                SendMessage message = new SendMessage().setChatId(chat_id).setText(
                        "Welcome to the game of Risk, please enter /join@TeamHALBot " +
                        "to join. 3 players must be present to begin game! The first player will be player 1 and " +
                        "the next player will be player 2, while the final player will be player 3.");

                // Spawn board, deck and Twitter
                board.setupBoard();
                //Deck deck = new Deck(board.getBoardTerritories());
                //TweetPoster tp = new TweetPoster();

                try {
                    execute(message); // Sending our message object to user
                } catch (TelegramApiException e) {
                    e.printStackTrace();
                }
                container.clear();
            }

            else if(message_text.equals("/join@TeamHALBot")) {

                // If user list is not 1 less than size, add the user to the list
                if (userList.size() != 2) {
                    userList.add(new User(username, 35));
                    SendMessage message = new SendMessage().setChatId(chat_id).setText(username + " you have joined the game");
                    try {
                        execute(message); // Sending our message object to user
                    } catch (TelegramApiException e) {
                        e.printStackTrace();
                    }

                    container.clear();
                }

                // If user list is 1 less than required size, add user and begin the game
                else if (userList.size() == 2) {
                    userList.add(new User(username, 35));
                    SendMessage message = new SendMessage().setChatId(chat_id).setText(username + " you have joined the game." +
                            " The game of Risk will now begin!");

                    setupTelegramTerritories();

                        try {
                            execute(message); // Sending our message object to user
                        } catch (TelegramApiException e) {
                            e.printStackTrace();
                        }
                    }

                container.clear();
            }

            // Attack the specified territory
            else if(message_text.equals("/attack@TeamHALBot")){
                SendMessage attack = new SendMessage().setChatId(chat_id).setText("Attacking your territory of choice");


                board.getTerritoryName(container.get(1)).decrementArmies(1);
                //board.getTerritoryName("NorthwestTerritory").getUser().removeArmyPower(5);
                //System.out.println( board.getTerritoryName(container.get(1)).getArmyPower());

                try {
                    execute(attack); // Sending our message object to user
                } catch (TelegramApiException e) {
                    e.printStackTrace();
                }

                container.clear();
            }

            // Fortify specified territory
            else if(message_text.equals("/fortify@TeamHALBot")){

                SendMessage message = new SendMessage().setChatId(chat_id).setText("Player 1, fortifying your territory! You've" +
                        " gained 1 new army!");

                board.getTerritoryName(container.get(1)).incrementArmies(1);
                board.getTerritoryName(container.get(1)).getUser().addArmyPower(4);
                try {
                    execute(message); // Sending our message object to user
                } catch (TelegramApiException e) {
                    e.printStackTrace();
                }

                container.clear();
            }

            // List territories for requesting player
            else if(message_text.equals("/list@TeamHALBot")){

                territoryHolder = board.getBoardTerritories();
                String usernameForTerritory = update.getMessage().getFrom().getFirstName();

                    for(int j = 0; j < 42; j++)
                    {
                        if(territoryHolder.get(j).getUser().getUsername().equals(usernameForTerritory))
                        {
                            SendMessage message = new SendMessage().setChatId(chat_id).setText(
                                    "Username: " + usernameForTerritory + "\n" +
                                    "Territory: " + territoryHolder.get(j).getTerritory() + "\n" +
                                    "Army Power: " + territoryHolder.get(j).getArmyPower() + "\n");

                            try {
                                execute(message); // Sending our message object to user
                            } catch (TelegramApiException e) {
                                e.printStackTrace();
                            }
                        }
                    }

                container.clear();
            }

            // Otherwise copy the message and return it
            else {
                SendMessage message = new SendMessage() // Create a message object object
                        .setChatId(chat_id)
                        .setText(message_text);
                try {
                    execute(message); // Sending our message object to user
                } catch (TelegramApiException e) {
                    e.printStackTrace();
                }

                container.clear();
            }
        }
    }

    @Override
    public String getBotUsername() {
        return "TeamHALBot";
    }

    @Override
    // Not the correct key
    public String getBotToken() {
        return "token";
    }

    // Function for setting up territories
    public void setupTelegramTerritories(){

        // Add player 1's countries to HashMap
        userList.get(0).addTerritory(board.getTerritoryName("Alaska"));
        board.setUserOccupant("Alaska", userList.get(0));
        board.getTerritoryName("Alaska").setArmyPower(1);
        userList.get(0).addTerritory(board.getTerritoryName("NorthwestTerritory"));
        board.setUserOccupant("NorthwestTerritory", userList.get(0));
        board.getTerritoryName("NorthwestTerritory").setArmyPower(1);

        // Add player 2's countries to HashMap
        userList.get(1).addTerritory(board.getTerritoryName("Quebec"));
        board.setUserOccupant("Quebec", userList.get(1));
        board.getTerritoryName("Quebec").setArmyPower(1);
        userList.get(1).addTerritory(board.getTerritoryName("WesternUnitedStates"));
        board.setUserOccupant("WesternUnitedStates", userList.get(1));
        board.getTerritoryName("WesternUnitedStates").setArmyPower(1);
        
        // Add player 3's countries to HashMap  
        userList.get(2).addTerritory(board.getTerritoryName("NorthAfrica"));
        board.setUserOccupant("NorthAfrica", userList.get(2));
        board.getTerritoryName("NorthAfrica").setArmyPower(1);
        userList.get(2).addTerritory(board.getTerritoryName("Egypt"));
        board.setUserOccupant("Egypt", userList.get(2));
        board.getTerritoryName("Egypt").setArmyPower(1);
    }
}
