import java.io.*;
import java.util.*;

public class main {
    private static char[][] grid;
    private static ArrayList<String> dictio;

    public static void main(String[] args) {
        long start=System.nanoTime();
        try {
            FileManager file = new FileManager(new BufferedReader(new FileReader("D:/log320-lab2-mots-caches/src/grid_demo.txt")),
                    (new BufferedReader(new FileReader("D:/log320-lab2-mots-caches/src/dict_demo.txt"))));
            grid = file.getGrid();
            dictio = file.getList();
            MotsCaches motsCaches = new MotsCaches(dictio, grid);
            PriorityQueue<String> wordsFound = motsCaches.wordFinder();

//            List<String> sortedWordList = new ArrayList<>(wordsFound);
//            Collections.sort(sortedWordList);

            for (String word : wordsFound){
                System.out.println(word);
            }

            System.out.println("Nombre de mots trouvés dans la grille: " + wordsFound.size());


        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("Temps d'execution: " + (double)(System.nanoTime()-start)/1000000000);
    }


//    public void findprobableWord(LinkedList dict, Grid[][] grid){
//        for(int i = 0;i<grid.length;i++){
//            for (int j = 0;j<grid.length;j++){
//                //if(dict.[i][j];
//            }
//
//        }
//    }

}