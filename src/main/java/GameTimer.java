// NOTE: any mention of time is measured in seconds

import java.util.Timer;
import java.util.TimerTask;
import java.io.IOException;
import java.lang.Thread;
import java.util.Scanner;

class GameTimer {
    private String lastInput;
    private int maxTime;
    private Scanner s;

    public GameTimer() {
        this.lastInput = "";
        this.s = new Scanner(System.in);
    }

    // default maxTime is 30
    public boolean getTimedInput() {
        return getTimedInput(30);
    }

    public boolean getTimedInput(int maxTime) {
        int currentTime = 0;
        // get input within time limit
        while (currentTime <= maxTime) {
            try {
                // if '\n' is in input buffer
                if (System.in.available() > 0) {
                    System.out.println();
                    lastInput = s.nextLine();
                    break;
                }
                System.out.println("You have " + (maxTime - currentTime) + " seconds remaining!");
                Thread.sleep(1000);

                currentTime++;
            } catch (Exception e) {
                System.out.println("EXCEPTION REACHED: " + e.getMessage());
            }
            /*
            } catch (IOException e) {
            
            } catch (InterruptedException e) {
            
            }
            */
        }
        
        try {
            if (currentTime > maxTime) {
                System.out.println();
                System.out.println("Time's up!");
                //s.nextLine();
                return false;
            } else {
                return true;
            }
        } catch (Exception e) {
            System.out.println("EXCEPTION CAUGHT: " + e.getMessage());
        }
        return false;
    }

    public String getLastInput() {
        // should return lastInput
        return lastInput;
    }
}