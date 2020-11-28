import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class WordsArrayList {
    public ArrayList<String> words;
    
    public WordsArrayList(){
        load("words_alpha.txt");
    }

    public void load(String fileName) {
        words = new ArrayList<>();
        try 
        {
            // Prepare to read from the file, using a Scanner
            File file = new File(fileName);
            Scanner in = new Scanner(file);

            // Read each word until end of file is reached
            while (in.hasNextLine())
            {
                // Read one word from the file
                String word = in.nextLine();
                if(word.length() > 4 && word.length() < 8)
                    words.add(word);
            }
        }

        catch (FileNotFoundException e)
        {
            System.out.println("File not found");

        }   
    }

    ArrayList<String> getWords(){
        return  words;

    }

}
