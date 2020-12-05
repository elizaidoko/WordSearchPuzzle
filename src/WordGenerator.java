import java.util.ArrayList;
import java.util.Random;
/**
 * An instantiable class which defines a Word
 * @author Elizabeth Ochanya Idoko
 */

public class WordGenerator {
    private ArrayList<String> listOfWords;
    private  WordsArrayList words = new WordsArrayList();
    private Random random = new Random();

    /**
     * WordGenerator no-argument constructor. Calls the word ArrayList to initialize list of words
     *
     */

    public WordGenerator(){
        listOfWords =  words.getWords();
    }

    /**
     * Method to generate a random word
     * @return a String value specifying the word
     */


    public String generate(){

        return listOfWords.get(random.nextInt(listOfWords.size()));
    }
}
