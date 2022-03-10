
/**
 * Write a description of class WordGuessingGame here.
 *
 * @author 202100296 e 202100984
 * @version 10/03/2022
 */
public class WordGuessingGame
{
    private String hiddenWord;
    private String guessedWord;
    private String usedLetters;
    private int numberOfTries;
    private InputReader reader;
    private WordGenerator wordGenerator;
    
    /**
    * @param hiddenWord Palavra a ser adivinhada 
    */ 
    public WordGuessingGame(/*String hiddenWord*/){
       reader = new InputReader(); 
       wordGenerator = new WordGenerator();
       //this.hiddenWord = hiddenWord.toLowerCase();
       hiddenWord = wordGenerator.addWord();
       this.guessedWord = initializeGuessedWord(); 
       numberOfTries = 0;
       usedLetters = "";
    }
    
    private String initializeGuessedWord(){
        String blank = "_";
        guessedWord = "";
        
        for(int i = 0; i < hiddenWord.length();i++){
            if(hiddenWord.charAt(i) != ' '){
                guessedWord += blank;
            } else { guessedWord += " "; }
        }     
        
        return guessedWord;
    }
    
    public void play(){
        showWelcome();
        
        do{
            guess();
            numberOfTries++;
        }while(guessedWord.contains("_"));
        
        if(guessedWord != "[][]"){
            showResult();    
        } else { System.out.println("Não acertou a palavra e tentou "+getNumberOfTries()+" em tentativas!"); }
    }
    
    private void showWelcome(){
        System.out.println("   ***Bem-vindo ao jogo da forca***\n");
        System.out.println("Introduza '0' se quiser desistir e revelar a palavra\n");
        System.out.println(guessedWord);
    }
    
    private void guess(){
        String newWord = "";
        
        System.out.println("Letras usadas:"+usedLetters);
        char letter = reader.getChar("Apresente uma letra: ");
        letter = Character.toLowerCase(letter);
        usedLetters += " "+letter;
        
        for(int i = 0; i < hiddenWord.length(); i++){
            if(letter != '0'){
                if(hiddenWord.charAt(i) == letter){
                    newWord = guessedWord.substring(0, i) + letter + guessedWord.substring(i+1);
                    guessedWord = newWord;
                }
            } else { showGuessedWord(); return; }
        }
        System.out.println("\n"+guessedWord);
    }
    
    private void showGuessedWord(){
        System.out.println("Palavra a ser adivinhada: "+getHiddenWord());
        guessedWord = "[][]";
    }
    
    private void showResult(){
         System.out.println("Parabéns acertou a palavra em "+getNumberOfTries()+" tentativas!\n");
    }
    
    public void reset(){
        wordGenerator.generateWord();
        hiddenWord = wordGenerator.addWord();
        guessedWord = initializeGuessedWord();
        usedLetters = "";
        numberOfTries = 0;
    }
    
    public String getHiddenWord(){ return hiddenWord; }
    public String getGuessedWord(){ return guessedWord; }
    public int getNumberOfTries(){ return numberOfTries; }
}
