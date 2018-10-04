import java.util.*;
import java.io.*;
import java.text.*;


// singleton class that is used to record all game actions
// usage:
// GameRecorder recorder = GameRecorder.INSTANCE;
// recorder.record("player 1 attacks player 2 from <territory> to <territory>"
//     + " with <{1..3}> vs <{1..2}> armies");
public enum GameRecorder {
    INSTANCE;

    ArrayList<String> lines;

    private GameRecorder() {
        lines = new ArrayList<String>();
    }

    public void record(String line) {
        lines.add(line);
    }

    // returns a string of the filename.
    public String writeToFile() throws IOException {
        String fileName = new SimpleDateFormat("'game_'yyyyMMddHHmm'.txt'").format(new Date());

        try (Writer writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(fileName)))) {
            
            for (String line : lines) {
                writer.write(line);
            }
            writer.close();
        }

        return fileName;
    }

    // useful for when a new game is played
    public void clearRecords() {
        lines = new ArrayList<String>();
    }
}
