//https://www.youtube.com/watch?v=qWjJM9bFZqE reference
import java.util.*;

public class Board {
    public static void main(String[] args){
        String letters = "abcdefghijklmnopqrstuvwxyz";
        String word = "play";
        int size = 10;

        Random random = new Random();

        String[][] board = new String [size][size];

        for (int r = 0; r<board.length;r++){
            for (int c = 0; c <board.length;c++){
                System.out.print (board[r][c] + " ");
            }

            System.out.println();
        }

    }
}
