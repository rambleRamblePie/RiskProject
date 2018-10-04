import java.util.*;
import java.io.*;
import java.text.*;


// singleton class that is used to record all game actions
// usage:
// GameRecorder recorder = GameRecorder.INSTANCE;
// recorder.outputAndRecord("player 1 attacks player 2 from <territory> to <territory>"
//     + " with <{1..3}> vs <{1..2}> armies");
// String recordFileName = recorder.writeToFile();
// ... after each turn, save to file:
// recorder.writeToFile(recordFileName);
public enum GameRecorder {
    INSTANCE;

    ArrayList<String> lines;

    private GameRecorder() {
        lines = new ArrayList<String>();
    }

    public void record(String line) {
        lines.add(line);
    }

    public void outputAndRecord(String line) {
        lines.add(line);
        System.out.println(line);
    }

    // writes all lines to a file
    // returns a string of the filename
    public String writeToFile() throws IOException {
        String fileName = new SimpleDateFormat("'riskgame_'yyyyMMddHHmm'.txt'").format(new Date());

        try (BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(fileName)))) {
            for (String line : lines) {
                writer.write(line);
                writer.newLine();
            }
            writer.close();
            clearRecords();
        }

        return fileName;
    }

    // appends data to the end of the file
    public void writeToFile(String fileName) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(fileName, true)))) {
            for (String line : lines) {
                writer.write(line);
                writer.newLine();
            }
            writer.close();
            clearRecords();
        }
    }

    // useful for when a new game is played
    public void clearRecords() {
        lines = new ArrayList<String>();
    }
}
