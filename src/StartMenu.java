//code reference
//http://www.java2s.com/Tutorial/Java/0240__Swing/NoLayoutManagerAbsolutepositioning.htm
//https://www.tutorialspoint.com/how-to-add-background-image-to-jframe-in-java
//image reference
//https://www.google.com/search?q=word+search+game+background&tbm=isch&ved=2ahUKEwiXvbHLjbPtAhXFS8AKHUHiBZIQ2-cCegQIABAA&oq=word+search+game+background&gs_lcp=CgNpbWcQAzoECCMQJzoGCAAQCBAeOgQIABAYOgIIAFCmhQJYpM8CYJfTAmgBcAB4AIAB6QGIAbsHkgEGMTQuMC4xmAEAoAEBqgELZ3dzLXdpei1pbWfAAQE&sclient=img&ei=mofJX5eIO8WXgQbBxJeQCQ&safe=active#imgrc=PJCX-NPjEdBoWM&imgdii=qAgNuRki1e1ofM
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
        this.setContentPane(new JPanel() {
            @Override
            public void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(img, 0, 0, null);
            }
        });
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