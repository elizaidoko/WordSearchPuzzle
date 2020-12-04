//https://stackoverflow.com/questions/32196327/how-to-get-the-part-of-the-text-from-jlabel-according-mouse-pointer

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class Display extends JFrame implements MouseListener{

    private JLabel[][] jLabels;
    private BoardGenerator board;
    private JPanel grid = new JPanel();
    private Color defaultColour = getBackground();
    private String word = "";
    private ArrayList<String> pickedWord = new ArrayList<>();
    private ArrayList<JLabel> coordinates = new ArrayList<>();

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
        jLabels = new JLabel[board.getSize()][board.getSize()];

        for(int r=0; r<board.getSize(); r++){
            for(int c=0; c<board.getSize(); c++){
                jLabels[r][c] = new JLabel(Character.toString(board.getBoard()[r][c]),SwingConstants.CENTER);
                grid.add(jLabels[r][c]);
                jLabels[r][c].setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
                jLabels[r][c].addMouseListener(this);
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

    public void mouseClicked(MouseEvent e){

        if(pickedWord.size() == board.getListOfWords().size()){
            this.setVisible(false);
            JOptionPane.showMessageDialog(null,"Congratulations you have won","Winner",JOptionPane.INFORMATION_MESSAGE);
        }
        else{
            JLabel jLabel = (JLabel) e.getSource();
            jLabel.setBackground(Color.PINK);

            if(getWord().length() < 7){
                word += jLabel.getText();
                coordinates.add(jLabel);
                //pickedWord.add(jLabel);
            }
            else
            {
                for(int r=0; r<board.getSize(); r++){
                    for(int c=0; c<board.getSize(); c++){

                        if(jLabels[r][c].getBackground() != Color.GREEN)
                            jLabels[r][c].setBackground(Color.WHITE);
                    }
                }

                word = "";
                coordinates = new ArrayList<>();
            }

            for(String l:board.getListOfWords()){
                if(word.equals(l)){
                    for(JLabel j:coordinates){
                        j.setBackground(Color.GREEN);
                    }
                    coordinates = new ArrayList<>();
                    pickedWord.add(word);
                    word = "";
                }
            }

        }

    }

    public static void main(String[] args){
        Display d = new Display();
    }

    public void mousePressed(MouseEvent e) {

    }


    public void mouseReleased(MouseEvent e) {

    }


    public void mouseEntered(MouseEvent e) {
        JLabel label = (JLabel) e.getSource();
        label.setOpaque(true);
        if(label.getBackground() != Color.PINK && label.getBackground() != Color.green)
            label.setBackground(Color.gray);

    }


    public void mouseExited(MouseEvent e) {
        JLabel label = (JLabel) e.getSource();
        if(label.getBackground() != Color.PINK && label.getBackground() != Color.green)
            label.setBackground(defaultColour);

    }


    public JLabel[][] getjLabels() {
        return jLabels;
    }

    public void setjLabels(JLabel[][] jLabels) {
        this.jLabels = jLabels;
    }

    public BoardGenerator getBoard() {
        return board;
    }

    public void setBoard(BoardGenerator board) {
        this.board = board;
    }

    public JPanel getGrid() {
        return grid;
    }

    public void setGrid(JPanel grid) {
        this.grid = grid;
    }

    public Color getDefaultColour() {
        return defaultColour;
    }

    public void setDefaultColour(Color defaultColour) {
        this.defaultColour = defaultColour;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

}
