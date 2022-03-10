
/**
 * Write a description of class FullGame here.
 *
 * @author 202100296 e 202100984
 * @version 10/03/2022
 */
public class FullGame
{
    private InputReader reader;
    private WordGuessingGame wordGuessingGame;
    
    public FullGame()
    {
        wordGuessingGame = new WordGuessingGame();  
        reader = new InputReader();
        play();
    }
    
    public void play(){
        char letter = '_';
        wordGuessingGame.play();
        
        do{
            letter = reader.getChar("Se deseja jogar de novo introduza 'S': ");
            letter = Character.toLowerCase(letter);
        
            if(letter == 's'){
                wordGuessingGame.reset();
                wordGuessingGame.play();
            }    
        }while(letter == 's');
        System.out.println("\nObrigado por ter jogado o nosso jogo!");
        return;
    }
}
