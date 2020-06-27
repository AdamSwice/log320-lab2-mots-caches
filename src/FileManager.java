import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;

public class FileManager {
    private static char[][] grid;
    private static ArrayList<String> list= new ArrayList<>();

    public FileManager(BufferedReader gridReader, BufferedReader dictioReader) throws Exception{
        readGrid(gridReader);
        readDisct(dictioReader);
    }

    public static void readGrid(BufferedReader gridReader){

        String line;

        try (BufferedReader br = gridReader) {

            int gridSize=Integer.parseInt(br.readLine());

            grid=new char[gridSize][gridSize];
            int currentLine=0;
            while ((line = br.readLine()) != null) {
                for(int i=0;i<gridSize;i++){

                    grid[currentLine][i]=line.charAt(i);
                }
                currentLine++;
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    public static void readDisct(BufferedReader dictioReader){


        String line;
        BufferedReader br = dictioReader;
        try {
            while ((line = br.readLine()) != null) {
                list.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public ArrayList<String> getList() {
        return list;
    }

    public void setList(ArrayList<String> list) {
        FileManager.list = list;
    }

    public static char[][] getGrid() {
        return grid;
    }

    public static void setGrid(char[][] grid) {
        FileManager.grid = grid;
    }
}
