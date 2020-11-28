import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Display extends JFrame{

    private JLabel jLabels[];
    private BoardGenerator board;
    private JPanel grid = new JPanel();

    public Display(){
        board = new BoardGenerator(10,20);
        board.display();
        setTitle("Grid");
        setSize(1000,1000);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout(3,3));

        buildGrid();
        WordList();

    }

    public void buildGrid(){
        grid.setLayout(new GridLayout(board.getSize(),board.getSize()));
        jLabels = new JLabel[board.getSize()*board.getSize()];

        for(int r=0; r<board.getSize(); r++){
            for(int c=0; c<board.getSize(); c++){
                jLabels[r+c] = new JLabel(Character.toString(board.getBoard()[r][c]),SwingConstants.CENTER);
                grid.add(jLabels[r+c]);
                jLabels[r+c].setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
            }
        }

        add(grid,BorderLayout.CENTER);
    }

    public void WordList(){
        JPanel wordList = new JPanel(new GridLayout(board.getListOfWords().size(),1));
        JLabel[] word = new JLabel[board.getListOfWords().size()];

        for(int i=0;i<board.getListOfWords().size();i++){
            word[i] = new JLabel(board.getListOfWords().get(i));
            wordList.add(word[i]);
        }

        add(wordList,BorderLayout.EAST);

    }

    public static void main(String[] args){
        Display d = new Display();
    }
}
