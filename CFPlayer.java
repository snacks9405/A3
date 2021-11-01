/**
 * Write a description of class CFPlayer here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
import java.util.Scanner;
import java.util.InputMismatchException;
public class CFPlayer extends Player
{
    public CFPlayer(String name, Game game)
    {
        super(name, game);
    }// constructor

    public void playAMove()
    {
        Scanner scan = new Scanner(System.in);
        int play = 0;
        System.out.printf("\n%s plays: ", name);
        try
        {
            play = scan.nextInt() - 1;
            if (play < 0 || play > 6)
                throw new InputMismatchException();
            for(int i = 5; i >= -1; i--)
            {
                if (i == -1)
                {
                    throw new InputMismatchException();
                }
                if (board.isEmpty(i, play))
                {
                    board.putPiece(
                        new Piece(name, board, i, play), i, play);
                    break;
                }
            }
        }catch(InputMismatchException e)
        {
            System.out.print("\n Invalid move. Try again!");
            playAMove();
        }

    }// playAMove method
}// CFPlayer class
