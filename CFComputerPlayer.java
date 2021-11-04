/**
 * describes a basic ai opponent for a game of CF
 *
 * @author alex rodriguez
 *         michael hulbert
 * @version 11.8.21
 */
import java.util.Random;
import java.util.InputMismatchException;

public class CFComputerPlayer extends CFPlayer // extending CFPlayer instead of Player gives access to tryMove
{
    private Random rand;
    
    /**
     * constructor for objects of type CFComputerPlayer
     * 
     * @param name      name of computer player
     * @param game      game of CF that computer player is in
     * 
     */
    public CFComputerPlayer(String name, Game game)
    {
        super(name, game);
        rand = new Random();
    }// constructor
    
    /**
     * attempts moves until one is played successfully 
     */
    public void playAMove()
    {
        game.currentPlayer = this;
        int x;
        while(!tryMove(x = rand.nextInt(board.board[0].length)));
        System.out.printf("\n X plays: %d\n", x+1);
    }// playAMove method
}// CFComputerPlayer class
