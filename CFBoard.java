/**
 * Write a description of class CFBoard here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class CFBoard extends Board
{
    public CFBoard(Game game, int numRows, int numColumns)
    {
        super(game, numRows, numColumns);
    }// constructor

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