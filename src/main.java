import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;

public class main {
    public static class Grid{
        char letter='-';
        boolean used=false;
        public  Grid(char letter){
            this.letter=letter;
        }
    }

    public static void main(String[] args) {
        long start=System.currentTimeMillis();

        Grid[][] grid=readGrid("F:/Epic Games/untitled5/src/grid_demo.txt");
        LinkedList<String> list =readDisct("F:/Epic Games/untitled5/src/dict_demo.txt");

        System.out.println(System.currentTimeMillis()-start);
    }

    public static Grid[][] readGrid(String fileIn){
        File file=new File(fileIn);
        String line;
        Grid[][] grid=null;
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {

            int gridSize=Integer.parseInt(br.readLine());

            grid=new Grid [gridSize][gridSize];
            int currentLine=0;
            while ((line = br.readLine()) != null) {
                for(int i=0;i<gridSize;i++){

                    grid[currentLine][i]=new Grid(line.charAt(i));
                }
                currentLine++;
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return  grid;
    }
    public static LinkedList readDisct(String fileIn){
        File file=new File(fileIn);
        LinkedList<String> list =new LinkedList<>();
        String line;
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            while ((line = br.readLine()) != null) {
                list.add(line);

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return list;
    }


    public void findprobableWord(LinkedList dict, Grid[][] grid){
        for(int i = 0;i<grid.length;i++){
            for (int j = 0;j<grid.length;j++){
                //if(dict.[i][j];
            }

        }
    }

}