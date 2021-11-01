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
        boolean played = true;
        while (!played)
        {
            for(int i = board.board.length-1; i >=0; i--)
            {
                if (!board.isEmpty(i, move)) continue;
                board.putPiece(new Piece(name, board, i, move),
                    i, move);
                System.out.printf("\n X plays: %d\n", move);
                played = true;
                break;
            }
        }
        
    }// playAMove method
}// CFComputerPlayer class
