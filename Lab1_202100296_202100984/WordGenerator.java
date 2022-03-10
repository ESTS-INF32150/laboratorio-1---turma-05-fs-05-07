import java.util.ArrayList;
import java.util.Random;
/**
 * Write a description of class WordGenerator here.
 *
 * @author 202100296 e 202100984
 * @version 10/03/2022
 */
public class WordGenerator
{
    private ArrayList<String> words;
    private Random rand;
    private int word;
     
    public WordGenerator(){
        words = new ArrayList<String>();
        fillArrayList();
        generateWord();
    }
    
    public void fillArrayList(){
        words.add("boolean");
        words.add("break");
        words.add("byte");
        words.add("case");
        words.add("char");
        words.add("class");
        words.add("continue");
        words.add("do");
        words.add("double");
        words.add("else");
        words.add("enum");
        words.add("for");
        words.add("if");
        words.add("import");
        words.add("int");
    }
    
    public void generateWord(){
        Random rand = new Random();
        word = rand.nextInt(15);
    }
    
    public String addWord(){
        return words.get(word);
    }
}
