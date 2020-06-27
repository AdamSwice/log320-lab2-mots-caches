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


    private Set<String> wordFinder(){
        HashSet<String> wordsFound = new HashSet<>();
        HashSet<String> possibleWords = findPossibleWords();

        int minimumWordLength = Integer.MAX_VALUE;
        for(String words : dictio) {
            if(words.length() < minimumWordLength)
                minimumWordLength = words.length();
        }

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

    private HashSet<String> findPossibleWords(){
        int gridSize = grid.length;
        Set<String> words = new HashSet<>();

        //Chaque ligne
        for (int i = 0; i < gridSize; i++){
            words.add(new String(this.grid[i]));
        }

        //Chaque colonne
        for (int i = 0; i < gridSize; i++){
            StringBuffer stringBuilder = new StringBuffer();
            for (int j = 0; j < gridSize;)

        }

        return null;
    }

}
