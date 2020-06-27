import java.io.*;
import java.util.ArrayList;

public class main {
    private static Grid[][] grid;
    private static ArrayList<String> disct;

    public static void main(String[] args) {
        long start=System.nanoTime();
        try {
            FileManager file = new FileManager(new BufferedReader(new FileReader("F:/Epic Games/untitled5/src/grid_demo.txt")),
                                            (new BufferedReader(new FileReader("F:/Epic Games/untitled5/src/dict_demo.txt"))));
            grid =file.getGrid();
            disct=file.getList();

        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println((double)(System.nanoTime()-start)/1000000000);
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