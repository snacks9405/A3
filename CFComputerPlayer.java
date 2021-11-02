/**
 * Write a description of class CFComputerPlayer here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
import java.util.Random;
import java.util.InputMismatchException;

public class CFComputerPlayer extends CFPlayer // extending CFPlayer instead of Player gives access to tryMove
{
    private Random rand;
    
    public CFComputerPlayer(String name, Game game)
    {
        super(name, game);
        rand = new Random();
    }// constructor

    public void playAMove()
    {
        game.currentPlayer = this;
        int x;
        while(!tryMove(x = rand.nextInt(board.board[0].length)));
        System.out.printf("\n X plays: %d\n", x+1);
    }// playAMove method
}// CFComputerPlayer class
