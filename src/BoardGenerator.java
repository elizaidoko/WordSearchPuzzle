import java.util.ArrayList;
import java.util.Random;

public class BoardGenerator {
    private String board[][];
    private int size;
    private ArrayList<String> listOfWords = new ArrayList<String>();
    private int numberOfWords;

    public BoardGenerator(int numberOfWords,int size){
        setSize(size);
        setNumberOfWords(numberOfWords);
    }

    public void display(){

        Random random = new Random();

        board = new String [getSize()][getSize()];

        for (int r = 0; r<board.length;r++){
            for (int c = 0; c <board.length;c++){
                System.out.print (board[r][c] + "  ");
            }

            System.out.println();
        }
    }

    public String[][] getBoard() {
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
