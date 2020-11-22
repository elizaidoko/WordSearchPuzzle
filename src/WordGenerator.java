import java.util.ArrayList;
import java.util.Random;

public class WordGenerator {
    private ArrayList<String> word  = new ArrayList<>();
    private Random random = new Random();

    public ArrayList<String> getWord() {
        return word;
    }


    public void populate(){
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

    }

    public String generate(){
        if(word.isEmpty())
            populate();

        return word.get(random.nextInt(word.size()));
    }
}
