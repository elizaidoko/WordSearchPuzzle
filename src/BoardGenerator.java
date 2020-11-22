import java.util.ArrayList;
import java.util.Random;

public class BoardGenerator {
    private char[][] board;
    private int size;
    private ArrayList<String> listOfWords = new ArrayList<String>();
    private int numberOfWords;
    private int wordsPlaced;
    private WordGenerator generator;
    private Random random = new Random();

    public int getWordsPlaced() {
        return wordsPlaced;
    }

    public void setWordsPlaced(int wordsPlaced) {
        this.wordsPlaced = wordsPlaced;
    }

    public BoardGenerator(int numberOfWords,int size){
        generator = new WordGenerator();
        setSize(size);
        setNumberOfWords(numberOfWords);
    }

    public void display(){
        String output="";

        Random random = new Random();

        board = new char [getSize()][getSize()];


        while(getWordsPlaced()< getNumberOfWords()){
            String word = generator.generate();
            boolean picked = false;

            while(!picked)
            {
                int counter = 0;
                if(wordsPlaced == 0)
                    break;
                for(String l:listOfWords){
                    if (word.equals(l)) {
                        picked = true;

                        break;
                    }
                    counter++;
                }
                if(picked)
                    word = generator.generate();
                else if(counter == listOfWords.size())
                    break;
            }
            listOfWords.add(word);

            boolean horizontal = false;

            int n = random.nextInt(20);

            if(n % 2==0)
                horizontal = true;

            if(horizontal){
                //placed horizontally

                int ncol = random.nextInt(getSize());
                int nrow = random.nextInt(getSize());


                while(getSize()-ncol < word.length()){
                    ncol--;
                }

                boolean space = true;

                for(int i=0; i<word.length() ; i++){
                    if (board[nrow][ncol + i] != (char) 0) {
                        space = false;
                        break;
                    }

                }

               while(!space){
                    int count = 0;
                    nrow = random.nextInt(getSize());
                    for(int i=0; i<word.length() ; i++){
                        if (board[nrow][ncol + i] == (char) 0) {
                            count++;
                        }
                    }
                    if(count == word.length()){
                        space = true;
                    }
                }

                for(int i=0; i<word.length() ; i++){
                    board[nrow][ncol+i] = word.charAt(i);
                }

            }
            else
            {
                //placed vertically
                int ncol = random.nextInt(getSize());
                int nrow = random.nextInt(getSize());


                while(getSize()-nrow < word.length()){
                    nrow--;
                }

                boolean space = true;

                for(int i=0; i<word.length() ; i++){
                    if (board[nrow+ i][ncol] != (char) 0) {
                        space = false;
                        break;
                    }

                }

               while(!space){
                    int count = 0;
                    nrow = random.nextInt(getSize());
                    for(int i=0; i<word.length() ; i++){
                        if (board[nrow + i][ncol] == (char) 0) {
                            count++;
                        }
                    }
                    if(count == word.length()){
                        break;
                    }
                }

                for(int i=0; i<word.length() ; i++){
                    board[nrow+i][ncol] = word.charAt(i);
                }
            }

            wordsPlaced++;

        }

        for (int r = 0; r<board.length;r++){
            for (int c = 0; c <board.length;c++){
                if(board[r][c] == (char)0){
                    board[r][c] = (char)(random.nextInt(26)+'A');
                }
            }
        }



        for (int r = 0; r<board.length;r++){
            for (int c = 0; c <board.length;c++){
                System.out.print(board[r][c] + "  ");

            }
            System.out.println();
        }

        for(String l:listOfWords){
            System.out.println(l);
        }

    }

    //accessors
    //
    //
    //
    //

    public char[][] getBoard() {
        return board;
    }


    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public ArrayList<String> getListOfWords() {
        return listOfWords;
    }


    public int getNumberOfWords() {
        return numberOfWords;
    }

    public void setNumberOfWords(int numberOfWords) {
        this.numberOfWords = numberOfWords;
    }
}
