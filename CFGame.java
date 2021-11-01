/**
 * Write a description of class CFGame here.
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
        return false;
    }// gameOver method
    
    @Override
    public void wrapUp()
    {
        
    }// wrapUp method
}// CFGame class
