/**
 * Represents a game of Connect Four
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class CFGame extends Game
{
    public CFGame(Board board)
    {
        super(board);
    }// constructor

    public CFGame()
    {
        this(new CFBoard(null, 6, 7));
        board.game = this;
    }// constructor

    /**
     * Starts a new Connect Four game
     */
    public static void newGame()
    {
        new CFGame().play();
    }//newGame method
    
    @Override
    public void setUp()
    {
        p1 = new CFPlayer("O", this);
        p2 = new CFComputerPlayer("X", this);
        
    }// setUp method
    
    @Override
    public boolean gameOver()
    {
        int length = 4; // min range for counting
        boolean isFull = true;
        for(int y=0; y<board.board.length; y++)
        {
            for(int x=0; x<board.board[y].length; x++)
            {
                Piece p = board.getPiece(y, x);
                if(p == null)
                {
                    isFull = false;
                    continue;
                }
                boolean horiz = validCheck(p, length, y, x, 0, 1); // is there a horizantal match
                boolean verti = validCheck(p, length, y, x, 1, 0); // ...
                boolean diagn = validCheck(p, length, y, x, 1, 1); // ...
                if(horiz || verti || diagn)
                {
                    winner = currentPlayer;
                    return true;
                }
            }
        }
        return isFull;
    }// gameOver method
    
    @Override
    public void wrapUp()
    {
        if(winner == null)
            System.out.println("\nIt's a draw.");
        else
            System.out.printf("\nPlayer %s wins.\n", winner.name);
    }// wrapUp method
    
    /*
     * Checks a row, column, or diagnol for a match with the given piece
     * 
     * @param compare    the peice to compare against
     * @param length     the length the check must be
     * @param y          the inital y position
     * @param x          the inital x position
     * @param dx         delta x : how far to translate x on check
     * @param dy         delta y : how far to translate y on check
     * 
     * @return is there a valid line
     */
    private boolean validCheck(Piece compare, int length, int y, int x, int dy, int dx)
    {
        try
        {
            for(int i=0; i<length; i++)
            {
                Piece p = board.getPiece(y + i * dy, x + i * dx);
                if(p == null || !p.equals(compare))
                    return false;
            }
        } catch(InvalidBoardPositionException ibpe)
        {
            return false; // out of range. can't be valid.
        }
        
        return true;
    }
    
    
}// CFGame class
