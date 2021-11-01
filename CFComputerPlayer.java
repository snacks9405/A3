/**
 * Write a description of class CFComputerPlayer here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
import java.util.Random;

public class CFComputerPlayer extends Player
{
    public CFComputerPlayer(String name, Game game)
    {
        super(name, game);
    }// constructor

    public void playAMove()
    {
        Random rand = new Random();
        int move = rand.nextInt(7);
        boolean played = false;

        for(int i = 5; i >=0; i--)
        {
            if (board.isEmpty(i, move))
            {
                board.putPiece(new Piece(name, board, i, move),
                    i, move);
                played = true;
                System.out.printf("\n X plays: %d\n", move);
                break;
            }
        }
        
        if (played == false)
        {
            playAMove();
        }
        
    }// playAMove method
}// CFComputerPlayer class
