import model.Board;
import junit.framework.TestCase;
import model.IllegalMoveException;

/**
 * User: Kristinn Svansson
 * Date: 11/22/12
 * Package: test
 */
public class TestBoard extends TestCase
{
    private Board board = new Board();

    public void testCheckMoveOutOfBoundsLow()
    {
        board.ResetBoard();

        try{
            board.CheckMove(-1, 'X');
        }
        catch(IllegalMoveException ime){
            return;
        }

        assertTrue("IllegalMoveException was not caught", false);
    }

    public void testCheckMoveOutOfBoundsHigh()
    {
        board.ResetBoard();

        try{
            board.CheckMove(9, 'X');
        }
        catch(IllegalMoveException ime){
            return;
        }

        assertTrue("IllegalMoveException was not caught", false);
    }

    public void testCheckMoveAllLegalMoves()
    {
        board.ResetBoard();
        for(int i = 0; i < 8; i++)
        {
            try{
                board.CheckMove(i, 'X');
            }
            catch(IllegalMoveException ime){
                assertTrue("An IllegalMoveException was caught", false);
            }
        }
    }

    public void testCheckMoveSameMove()
    {
        board.ResetBoard();

        try{
            board.CheckMove(0, 'X');
        }
        catch(IllegalMoveException ime){
            assertTrue("IllegalMoveException was caught", false);
        }

        try{
            board.CheckMove(0, 'X');
        }
        catch(IllegalMoveException ime){
            return;
        }

        assertTrue("IllegalMoveException was not caught", false);
    }

    //TODO: Breyta horizontal í vertical og vice versa í Board checkWin comments
    public void testHorizontalWin()
    {
        //Check all the possible horizontal winning combinations for a 3x3 game
        for(int i = 0; i < 6; i += 3)
        {
            board.ResetBoard();
            try{
                board.CheckMove(i, 'X');
                board.CheckMove(i+1, 'X');
                board.CheckMove(i+2, 'X');

            }
            catch(IllegalMoveException ime){
                assertTrue("An IllegalMoveException was caught", false);
            }

            //if the CheckWin function returns null, then it did not detect the victory
            if(board.CheckWin(i) == null)
                assertTrue("CheckWin returned null", false);

            if(   !((board.CheckWin(i).elementAt(0) == i) &&
                    (board.CheckWin(i).elementAt(1) == i+1) &&
                    (board.CheckWin(i).elementAt(2) == i+2)))
                assertTrue("The CheckWin return vector did not have the correct element", false);
        }
    }

    public void testVerticalWin()
    {
        //Check all the possible vertical winning combinations for a 3x3 game
        for(int i = 0; i < 3; i++)
        {
            board.ResetBoard();
            try{
                board.CheckMove(i, 'X');
                board.CheckMove(i+3, 'X');
                board.CheckMove(i+6, 'X');
            }
            catch(IllegalMoveException ime){
                assertTrue("An IllegalMoveException was caught", false);
            }

            //if the CheckWin function returns null, then it did not detect the victory
            if(board.CheckWin(i) == null)
                assertTrue("CheckWin returned null", false);

            if(   !((board.CheckWin(i).elementAt(0) == i) &&
                    (board.CheckWin(i).elementAt(1) == i+3) &&
                    (board.CheckWin(i).elementAt(2) == i+6)))
                assertTrue("The CheckWin return vector did not have the correct element", false);
        }
    }

    public void testDiagonalWinOne()
    {
        //Check a possible diagonal winning combinations for a 3x3 game, 0-4-8

        board.ResetBoard();
        try{
            board.CheckMove(0, 'X');
            board.CheckMove(4, 'X');
            board.CheckMove(8, 'X');
        }
        catch(IllegalMoveException ime){
            assertTrue("An IllegalMoveException was caught", false);
        }

        //if the CheckWin function returns null, then it did not detect the victory
        if(board.CheckWin(0) == null)
            assertTrue("CheckWin returned null", false);

        if(   !((board.CheckWin(0).elementAt(0) == 0) &&
                (board.CheckWin(0).elementAt(1) == 4) &&
                (board.CheckWin(0).elementAt(2) == 8)))
            assertTrue("The CheckWin return vector did not have the correct element", false);
    }

    public void testDiagonalWinTwo()
    {
        //Check a possible diagonal winning combinations for a 3x3 game, 2-4-6

        board.ResetBoard();
        try{
            board.CheckMove(2, 'X');
            board.CheckMove(4, 'X');
            board.CheckMove(6, 'X');
        }
        catch(IllegalMoveException ime){
            assertTrue("An IllegalMoveException was caught", false);
        }

        //if the CheckWin function returns null, then it did not detect the victory
        if(board.CheckWin(2) == null)
            assertTrue("CheckWin returned null", false);

        if(   !((board.CheckWin(2).elementAt(0) == 2) &&
                (board.CheckWin(2).elementAt(1) == 4) &&
                (board.CheckWin(2).elementAt(2) == 6)))
            assertTrue("The CheckWin return vector did not have the correct element", false);
    }

}