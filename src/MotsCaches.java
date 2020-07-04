import java.util.*;

public class MotsCaches {
    private char[][] grid;
    private ArrayList<String> dictio;

    public MotsCaches(ArrayList<String> dictio, char[][] grid){
        this.grid = grid;
        this.dictio = dictio;
    }


    public void wordFinder(){
        int minimumWordLength = Integer.MAX_VALUE;
        int totalCount=0;
        for(String words : dictio) {
            if(words.length() < minimumWordLength)
                minimumWordLength = words.length();
        }
        Collections.sort(dictio,String.CASE_INSENSITIVE_ORDER);
        HashSet<String> possibleWords = findPossibleWords(minimumWordLength);

        for (String word : dictio){
            for (String possibleWord : possibleWords){
                String reversedWord = new StringBuilder(word).reverse().toString();
                    if (possibleWord.contains(word) || possibleWord.contains(reversedWord)){
                        int count = ( possibleWord.split(word, -1).length ) - 1;
                        count+=( possibleWord.split(reversedWord, -1).length ) - 1;
                        for(int i=0 ; i<count ; i++){
                            System.out.println(word);
                            totalCount++;
                        }

                    }

            }
        }
        System.out.println("Nombre de mots trouvés dans la grille: " + totalCount);

    }

    private HashSet<String> findPossibleWords(int minimumWordLength){
        int gridSize = grid.length;
        HashSet<String> words = new HashSet<>();

        //Chaque ligne
        rowWordMaker(words, gridSize);

        //Chaque colonne
        columnWordMaker(words, gridSize);

        //Diagonales principale
        //TODO: Utiliter a valider
        mainDiagonalWordMaker(words, gridSize);

        //Diagonale principale inverse /
        reverseDiagonalWordMaker(words, gridSize, minimumWordLength);

        return words;
    }


    private void rowWordMaker(HashSet<String> words, int gridSize){
        for (int i = 0; i < gridSize; i++){
            words.add(new String(this.grid[i]));
        }
    }

    private void columnWordMaker(HashSet<String> words, int gridSize){
        for (int i = 0; i < gridSize; i++){
            StringBuilder stringBuilder = new StringBuilder();
            for (int j = 0; j < gridSize; j++){
                stringBuilder.append(grid[j][i]);
            }
            words.add(stringBuilder.toString());
        }
    }

    private void mainDiagonalWordMaker(HashSet<String> words, int gridSize){
        StringBuilder diagonalStringBuilder1 = new StringBuilder();
        StringBuilder diagonalStringBuilder2 = new StringBuilder();

        for (int i = 0; i < gridSize; i++){
            diagonalStringBuilder1  = diagonalStringBuilder1.append(grid[i][i]);
            diagonalStringBuilder2 = diagonalStringBuilder2.append(grid[i][gridSize-i-1]);
        }
        words.add(diagonalStringBuilder1.toString());
        words.add(diagonalStringBuilder2.toString());
    }

    private void reverseDiagonalWordMaker(HashSet<String> words, int gridSize, int minimumWordLength){
        for (int i = 0; i < gridSize - minimumWordLength; i++){
            StringBuilder tempStringBuilder1 = new StringBuilder();
            StringBuilder tempStringBuilder2 = new StringBuilder();
            StringBuilder tempStringBuilder3 = new StringBuilder();
            StringBuilder tempStringBuilder4 = new StringBuilder();

            for (int j = i, k = 0; j < gridSize && k < gridSize; j++, k++){
                tempStringBuilder1.append(grid[j][k]);
                tempStringBuilder2.append(grid[k][j]);
                tempStringBuilder3.append(grid[gridSize - j - 1][k]);
                tempStringBuilder4.append(grid[gridSize - k - 1][j]);
            }
            if(!words.contains(tempStringBuilder1.reverse()))
                words.add(tempStringBuilder1.toString());
            if(!words.contains(tempStringBuilder2.reverse()))
                words.add(tempStringBuilder2.toString());
            if(!words.contains(tempStringBuilder3.reverse()))
                words.add(tempStringBuilder3.toString());
            if(!words.contains(tempStringBuilder4.reverse()))
                words.add(tempStringBuilder4.toString());
        }
    }
}
