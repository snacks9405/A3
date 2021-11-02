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
        game.currentPlayer = this;
        Scanner scan = new Scanner(System.in);
        System.out.printf("\n%s plays: ", name);
        while(!tryMove(scan.nextInt() - 1))
            System.out.print("\n Invalid move. Try again!");

    }// playAMove method
    
    
    /*
     * Trys to play a move, executes move if successfull
     * 
     * @param the x position to try
     * 
     * @return if the move was successfull
     */
    boolean tryMove(int x)
    {
        try
        {
            int y = getMovePosition(x);
            placePiece(y, x);
            return true;
            
        }catch(InputMismatchException e)
        {
            return false;
        }
    }
    /*
     * Places a piece at given location
     * 
     * @param y  the y position of new piece
     * @param x  the x position of new piece
     */
    void placePiece(int y, int x)
    {
        board.putPiece(new Piece(name, board, y, x), y, x);
    }
    /*
     * Checks a move and gets the y position of said move
     * 
     * @param move   the x position of the move
     * 
     * @return the y position of the move
     */
    int getMovePosition(int x) throws InputMismatchException
    {
        if(x < 0 || x >= board.board[0].length)
            throw new InputMismatchException();
        for(int i=game.board.board.length-1; i>=0; i--)
        {
            if(board.isEmpty(i, x))
                return i;
        }
        throw new InputMismatchException();
    }
    
}// CFPlayer class
