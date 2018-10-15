import java.util.*;
import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;

/**
 * The TweetPoster class will be used to tweet messages through Twitter. You will need to have the
 * twitter4j.properties file containing the necessary keys in the root directory of the project in
 * order for the messages to successfully post. All methods need to throw TwitterException to catch
 * any errors encountered when the program attempts to push the message to Twitter.
 * Team HAL @hal_team on Twitter
 * @author Aaron Mitchell
 * @version 0.4
 */

public class TweetPoster {

    private int count;

    TweetPoster() {
        this.count = 0; // we can either keep track of the count in the main loop or here
        // main loop seems easier, but this is here in case we use it
    }

    /**
     * Posts status message of User's total amount of conquered territories at the end of the game
     * @param user The User to grab the Twitter Count amount from
     * @throws TwitterException Necessary
     * @see TweetPoster
     */
    public void postFinalStatus(User user) throws TwitterException{
        String message = "Player " + user.getUsername() + " has conquered a total of " + user.getTwitterCount() +
                " territories over the course of the game!";
        Twitter twitter = TwitterFactory.getSingleton();
        Status status = twitter.updateStatus(message);
    }

    /**
     * Posts status message of User's amount of conquered territories at the end of the turn
     * @param user The User to grab the Twitter Count amount from
     * @param count The total count of territories the User has conquered after his turn is over
     * @throws TwitterException Necessary
     * @see TweetPoster
     */
    public void postTurnStatus(User user, int count) throws TwitterException{
        String message = "Player " + user.getUsername() + " has conquered a total of " + count +
                " territories this turn!";
        Twitter twitter = TwitterFactory.getSingleton();
        Status status = twitter.updateStatus(message);
    }

    /**
     * Increment TweetPoster's count of conquered territories this turn. We can either keep track of
     * conquered territories per turn with this, or with a variable inside the main loop
     * @param counter The amount to add to User's conquered total this turn
     * @return User's current win amount
     * @see TweetPoster
     */
    public int incrementCount(int counter){
        count = count + counter;
        return count;
    }

    /**
     * Resets TweetPoster's count for total conquered territories during the turn to 0
     * We will call this at the end of the main loop to reset it to 0 each turn
     * @return Integer counter that holds the total territories conquered during the turn
     * @see TweetPoster
     */
    public int resetCount(){
        count = 0;
        return count;
    }

    /**
     * Grabs the total territories conquered so far during the turn from TweetPoster
     * @return TweetPoster's count
     * @see TweetPoster
     */
    public int getCount(){
        return count;
    }
}
