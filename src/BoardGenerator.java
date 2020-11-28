import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class BoardGenerator {

    private char[][] board;
    private int size;
    private ArrayList<String> listOfWords = new ArrayList<String>();
    private int numberOfWords;
    private int wordsPlaced;
    private WordGenerator generator;
    private Random random = new Random();
    private String view;

    public int getWordsPlaced() {
        return wordsPlaced;
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
            String word = pickWord();

            placeword(word);

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
                System.out.print(board[r][c] + "");
                output += board[r][c];

            }
            System.out.println();
            output += "\n";
        }

        view = output;

        for(String l:listOfWords){
            System.out.println(l);
        }

    }

    private String pickWord(){
        String word = generator.generate();

        boolean picked = false;
        boolean found;

        while(!picked){
            found = false;
            if(!listOfWords.isEmpty()){
                for(String l:listOfWords){
                    if(word.equals(l))
                        found = true;

                }
                if(!found)
                    picked = true;
                else
                    word = generator.generate();
            }
            else
                picked=true;
            }

        listOfWords.add(word);
        return word;

    }

    private void placeword(String word){
        boolean horizontal = false;

        int n = random.nextInt();

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
                    if (board[nrow][ncol + i] == (char) 0 || board[nrow][ncol] == word.charAt(i)) {
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
                if (board[nrow + i][ncol] != (char) 0) {
                    space = false;
                    break;
                }

            }

            while(!space){
                int count = 0;
                nrow = random.nextInt(getSize());

                while(getSize()-nrow < word.length()){
                    nrow--;
                }

                for(int i=0; i<word.length() ; i++){
                    if (board[nrow + i][ncol] == (char)0 || board[nrow][ncol] == word.charAt(i)) {
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
    }

    //accessors
    //
    //
    //
    //

    public char[][] getBoard() {
        if(board != null)
            return Arrays.copyOf(board,board.length);
        return null;
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

    public String getView() {
        return view;
    }

    public void setView(String view) {
        this.view = view;
    }
}
