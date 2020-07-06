import java.io.*;
import java.util.*;

public class main {
    private static char[][] grid;
    private static ArrayList<String> dictio;

    public static void main(String[] args) {

        try {
            FileManager file = new FileManager(new BufferedReader(new FileReader(args[0])),
                    (new BufferedReader(new FileReader(args[1]))));
            grid = file.getGrid();
            dictio = file.getList();
            MotsCaches motsCaches = new MotsCaches(dictio, grid);
            motsCaches.wordFinder();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}