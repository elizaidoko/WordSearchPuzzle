//https://github.com/dwyl/english-words/blob/master/words_alpha.txt
//reference of where i got the text file from
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
            File file = new File(fileName);
            Scanner in = new Scanner(file);

            while (in.hasNextLine())
            {
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
