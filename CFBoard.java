/**
 * describes a board of CF
 *
 * @author alex rodriguez
 *         michael hulbert
 * @version 11.8.21
 */
public class CFBoard extends Board
{
    /**
     * Constructor for objects of class CFBoard
     * 
     * @param game              the CF game this board is for
     * @param numRows           the number of rows on this board
     * @param numColumns        the number of columns on this board
     */
    public CFBoard(Game game, int numRows, int numColumns)
    {
        super(game, numRows, numColumns);
    }// constructor
    
    /**
     * Displays the board on the terminal windows
     */
    @Override
    public void display()
    {
        for(int row = 0; row < board.length; row++)
        {
            if (row == 0)
                System.out.print("|");
            else
                System.out.print("\n|");
            for (int col = 0; col < board[0].length; col++)
            {
                if (isEmpty(row, col))
                    System.out.print(" |");
                else
                    System.out.printf("%s|", game.board.getPiece(row, col));
            }
        }
        System.out.print("\n+-+-+-+-+-+-+-+");
        System.out.print("\n 1 2 3 4 5 6 7\n");
    }// display method

}// CFBoard class