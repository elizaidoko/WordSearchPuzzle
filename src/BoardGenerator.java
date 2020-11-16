import java.util.ArrayList;
import java.util.Random;

public class BoardGenerator {
    private char board[][];
    private int size;
    private ArrayList<String> listOfWords = new ArrayList<String>();
    private int numberOfWords = 1;
    private int wordsPlaced = 0;

    public int getWordsPlaced() {
        return wordsPlaced;
    }

    public void setWordsPlaced(int wordsPlaced) {
        this.wordsPlaced = wordsPlaced;
    }

    public BoardGenerator(int numberOfWords,int size){
        setSize(size);
        setNumberOfWords(numberOfWords);
    }

    public void display(){
        String output="";

        Random random = new Random();

        board = new char [getSize()][getSize()];

        for (int r = 0; r<board.length;r++){
            for (int c = 0; c <board.length;c++){

                board[r][c] = (char)(random.nextInt(26)+'a');

            }
        }

        boolean vertical;
        String word = "player";
        //if vertical or horizontal
        int n = random.nextInt();

        int row = 2;
        int col = 2;

        //Will be placed on row 3 col 3

        for(int i = 0; i<word.length(); i++){
            board[row+i][col] = word.charAt(i);

        }

        for (int r = 0; r<board.length;r++){
            for (int c = 0; c <board.length;c++){

                System.out.print(board[r][c] + "  ");

            }
            System.out.println();
        }

    }

    private void placewords() {


        while (getNumberOfWords() < getWordsPlaced()) {
            Random random = new Random();
            boolean vertical;
            String word = "player";
            //if vertical or horizontal
            int n = random.nextInt();

            int row = 2;
            int col = 2;

            for(int i = 0; i<word.length(); i++){
                board[row+i][col] = word.charAt(i);

            }


            /*
            if (n % 2 == 0) {
                vertical = true;
            } else {
                vertical = false;
            }



            //give random position
            if (vertical) {
                boolean placed = true;
                while(!placed){
                    int row = random.nextInt(getSize());
                    int col = random.nextInt(getSize());

                    if((getSize() - row) > word.length()){
                        placed = false;
                    }


                }



            }
            else {


            }


          */

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
