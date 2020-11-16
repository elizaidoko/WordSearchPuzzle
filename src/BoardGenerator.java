import java.util.ArrayList;
import java.util.Random;

public class BoardGenerator {
    private char board[][];
    private int size;
    private ArrayList<String> listOfWords = new ArrayList<String>();
    private int numberOfWords;

    public BoardGenerator(int numberOfWords,int size){
        setSize(size);
        setNumberOfWords(numberOfWords);
    }

    public void display(){

        Random random = new Random();

        board = new char [getSize()][getSize()];

        //User defined method placeWords()

        for (int r = 0; r<board.length;r++){
            for (int c = 0; c <board.length;c++){
                board[r][c] = (char)(random.nextInt(26)+'a');
                System.out.print (board[r][c] + "  ");
            }

            System.out.println();
        }
    }

    private void placewords(){
        Random random = new Random();
        String word = "player";
        //give random position
        boolean placed = false;
        while(placed){
            int row = random.nextInt(getSize()),column = random.nextInt(getSize());

            //check if theres space


        }
    }

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
