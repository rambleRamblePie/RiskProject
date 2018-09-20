import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("How many people are playing?");
        int numPlayers = sc.nextInt();
	sc.nextLine();
        String[] playerNames = new String[6];
        for(int i=0; i<numPlayers; i++) {
            System.out.println("What is player " + (i+1) + "'s name?");
            playerNames[i] = sc.nextLine();
        }

        GameSetup game = new GameSetup(numPlayers, playerNames);
    }
}
