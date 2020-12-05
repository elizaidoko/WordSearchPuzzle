import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class StartMenu extends JFrame implements ActionListener{
    //private Container container;
    private JButton startButton;
    private JLabel player;
    private JTextField name;
    private Display display;
    Image img = Toolkit.getDefaultToolkit().getImage("image.jpg");

    public StartMenu() throws IOException {
        /*****************************************************
         *    Title: Efforts in iteration - FizzBuzz
         *    Author: Samuel Sam
         *    Site owner/sponsor: tutorialspoint.com
         *    Date: 2019
         *    Code version: edited May 24 2016 at 19:22
         *    Availability: https://www.tutorialspoint.com/how-to-add-background-image-to-jframe-in-java (Accessed 4 December 2020)
         *    Modified: changed image
         *****************************************************/

        this.setContentPane(new JPanel() {
            @Override
            public void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(img, 0, 0, this);
            }
        });

        //Edited code ends here
        setSize(866,500);
        setLocation(300,300);
        setTitle("Word Search");
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(null);
        player = new JLabel("Player ");
        player.setBounds(550,150,50,20);
        add(player);
        name = new JTextField(15);
        name.setBounds(630,150,140,20);
        name.setVisible(true);
        add(name);
        startButton = new JButton("Start");
        startButton.addActionListener(this);
        startButton.setBounds(600,200,130,60);
        add(startButton);

    }

    public static void main(String[] args) throws Exception{
        new StartMenu();
    }

    @Override
    public void actionPerformed(ActionEvent args0){
        if(!name.getText().equals("")){
            display = new Display();
        }
        else
            JOptionPane.showMessageDialog(null,"Please fill in the player name","missing field entry",JOptionPane.ERROR_MESSAGE);
    }
}