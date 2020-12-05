import java.util.ArrayList;
import java.util.Random;

public class WordGenerator {
    private ArrayList<String> listOfWords;
    private  WordsArrayList words = new WordsArrayList();
    private Random random = new Random();

    public WordGenerator(){
        listOfWords =  words.getWords();
    }

    public String generate(){

        return listOfWords.get(random.nextInt(listOfWords.size()));
    }
}
