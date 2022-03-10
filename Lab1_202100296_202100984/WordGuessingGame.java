
/**
 * Write a description of class WordGuessingGame here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class WordGuessingGame
{
    private String hiddenWord;
    private String guessedWord;
    private int numberOfTries;
    private InputReader reader;
    
    public WordGuessingGame()
    {
       hiddenWord = "abc";
       guessedWord = "___"; 
       numberOfTries = 0;
       reader = new InputReader();
    }
    
    /*private void guessedWord(){
        char blank = '_';

        for(int i = 0; i < guessedWord.length();i++){
            hiddenWord += blank;
        }
 
    }
       */ 
    
    
    public void play(){
        showWelcome();
        //guessedWord();
        do{
            guess();
            numberOfTries++;
        }while(guessedWord.contains("_"));
        showResult();
    }
    
    private void showWelcome(){
        System.out.println("   ***Bem-vindo ao jogo da forca***\n");
        System.out.println(guessedWord);
    }
    
    private void guess(){
        char letter = reader.getChar("Apresente uma letra: ");
        String newString = "";
        for(int i = 0; i < hiddenWord.length(); i++){
            if(hiddenWord.charAt(i) == letter){
                newString = guessedWord.substring(0, i) + letter + guessedWord.substring(i+1);
                guessedWord = newString;
            }
        }
        System.out.println(guessedWord);
    }
    
    private void showGuessedWord(){
        System.out.println("Palavra a ser adivinhada: "+hiddenWord);
    }
    
    private void showResult(){
         System.out.println("Parabéns acertou a palavra em "+numberOfTries);
    }
    
    public String getHiddenWord(){ return hiddenWord; }
    public String getGuessedWord(){ return guessedWord; }
    public int getNumberOfTries(){ return numberOfTries; }
}
