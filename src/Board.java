//https://www.youtube.com/watch?v=qWjJM9bFZqE reference
import java.util.*;

public class Board {
    public static void main(String[] args){
        String letters = "abcdefghijklmnopqrstuvwxyz";

        Random random = new Random();

        char[][] board = new char [10][10];
        for (int r = 0; r<board.length;r++){
            for (int c = 0; c <board.length;c++){
                board[r][c] = (char)(random.nextInt(26) + 'a');
                System.out.print (board[r][c] + " ");

            }
            System.out.println();
        }

    }
}
