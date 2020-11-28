import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Display extends JFrame{

    private JLabel jLabels[];
    private BoardGenerator board;
    private JPanel grid = new JPanel();

    public Display(){
        board = new BoardGenerator(5,20);
        board.display();
        setTitle("Grid");
        setSize(600,600);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        buildGrid();
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

    public static void main(String[] args){
        Display d = new Display();
    }
}
