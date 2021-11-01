/**
 * Represents a two-player board game
 *
 * @author David Furcy
 * @version 10/25/2021
 */
public abstract class Game
{
    protected Board board;    // the board for this game
    protected Player p1;      // the game's first player 
    protected Player p2;      // the game's other player
    protected Player winner;  // the game's winner
    protected int score1;     // p1's score
    protected int score2;     // p2's score
    protected Player currentPlayer;  // the player whose turn it is to play
    
    /**
     * Constructor for objects of class Game
     * 
     * @param board   an empty, game-specific board to play the 
     *                game on
     */
    public Game(Board board)
    {
        this.board = board;
        board.setGame( this );
        score1 = score2 = 0;
    }// constructor
    
    /**
     *  Plays an entire game
     */
    public void play()
    {
        setUp();
        board.display();
        while (! gameOver() )
        {
            p1.playAMove();
            board.display();
            if (gameOver())
                break;
            p2.playAMove(); 
            board.display();
        }// main game loop
        wrapUp();
    }// play method

    /**
     * Sets up the board in its initial configuration as well as
     * the two players of this game
     */
    public abstract void setUp();

    /**
     *  Determines whether or not the game has ended
     */
    public abstract boolean gameOver();

    /**
     * Finishes the game after a draw or a win
     */
    public abstract void wrapUp();

}// Game class
