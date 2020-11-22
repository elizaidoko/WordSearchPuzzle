import java.util.ArrayList;
import java.util.Random;

public class WordGenerator {
    private ArrayList<String> word  = new ArrayList<>();
    private Random random = new Random();

    public ArrayList<String> getWord() {
        return word;
    }


    public String generate(){
        word.add("host");
        word.add("party");
        word.add("game");
        word.add("among");
        word.add("trail");
        word.add("pass");
        word.add("river");
        word.add("team");
        word.add("corpse");
        word.add("husband");
        word.add("tea");
        word.add("paint");
        word.add("anime");

        return word.get(random.nextInt(word.size()));
    }
}
