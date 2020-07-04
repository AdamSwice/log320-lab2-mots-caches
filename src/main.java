import java.io.*;
import java.util.*;

public class main {
    private static char[][] grid;
    private static ArrayList<String> dictio;

    public static void main(String[] args) {
        long start=System.nanoTime();
        try {
            FileManager file = new FileManager(new BufferedReader(new FileReader("D:/log320-lab2-mots-caches/src/grid.txt")),
                    (new BufferedReader(new FileReader("D:/log320-lab2-mots-caches/src/dict.txt"))));
            grid = file.getGrid();
            dictio = file.getList();
            MotsCaches motsCaches = new MotsCaches(dictio, grid);
            motsCaches.wordFinder();

        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("Temps d'execution: " + (double)(System.nanoTime()-start)/1000000000);
    }

}