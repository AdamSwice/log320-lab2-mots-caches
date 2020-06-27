import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class MotsCaches {
    private char[][] grid;
    private ArrayList<String> dictio;

    public MotsCaches(ArrayList<String> dictio, char[][] grid){
        this.grid = grid;
        this.dictio = dictio;
    }


    public Set<String> wordFinder(){
        int minimumWordLength = Integer.MAX_VALUE;
        for(String words : dictio) {
            if(words.length() < minimumWordLength)
                minimumWordLength = words.length();
        }

        HashSet<String> wordsFound = new HashSet<>();
        HashSet<String> possibleWords = findPossibleWords(minimumWordLength);

        

        for (String word : dictio){
            for (String possibleWord : possibleWords){
                String reversedWord = new StringBuffer(word).reverse().toString();
                if (possibleWord.contains(word) || possibleWord.contains(reversedWord)){
                    wordsFound.add(word);
                }
            }
        }
        return wordsFound;
    }

    private HashSet<String> findPossibleWords(int minimumWordLength){
        int gridSize = grid.length;
        HashSet<String> words = new HashSet<>();

        //Chaque ligne
        for (int i = 0; i < gridSize; i++){
            words.add(new String(this.grid[i]));
        }

        //Chaque colonne
        for (int i = 0; i < gridSize; i++){
            StringBuffer stringBuilder = new StringBuffer();
            for (int j = 0; j < gridSize; j++){
                stringBuilder.append(grid[j][i]);
            }
            words.add(stringBuilder.toString());
        }

        //Diagonales principale \
        StringBuffer diagonalStringBuilder1 = new StringBuffer();
        StringBuffer diagonalStringBuilder2 = new StringBuffer();

        for (int i = 0; i < gridSize; i++){
            diagonalStringBuilder1  = diagonalStringBuilder1.append(grid[i][i]);
            diagonalStringBuilder2 = diagonalStringBuilder2.append(grid[i][gridSize-i-1]);
        }
        words.add(diagonalStringBuilder1.toString());
        words.add(diagonalStringBuilder2.toString());

        //Diagonale principale inverse /
        for (int i = 0; i < gridSize - minimumWordLength; i++){
            StringBuffer tempStringBuffer1 = new StringBuffer();
            StringBuffer tempStringBuffer2 = new StringBuffer();
            StringBuffer tempStringBuffer3 = new StringBuffer();
            StringBuffer tempStringBuffer4 = new StringBuffer();

            for (int j = i, k = 0; j < gridSize && k < gridSize; j++, k++){
                tempStringBuffer1.append(grid[j][k]);
                tempStringBuffer2.append(grid[k][j]);
                tempStringBuffer3.append(grid[gridSize - j - 1][k]);
                tempStringBuffer4.append(grid[gridSize - k - 1][j]);
            }
            words.add(tempStringBuffer1.toString());
            words.add(tempStringBuffer2.toString());
            words.add(tempStringBuffer3.toString());
            words.add(tempStringBuffer4.toString());
        }

        return words;
    }

}
