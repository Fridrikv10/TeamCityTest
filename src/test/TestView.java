import View.ConsoleView;
import junit.framework.TestCase;
import model.Board;
import model.IllegalMoveException;



/**
 * User: Gunnar Helgason
 * Date: 25.11.2012
 * Time: 18:40
 */
public class TestView extends TestCase
{
    Board board = new Board();

    public void testDisplayTest()
    {


        {
            board.ResetBoard();
            //try
            //{
                /*
                board.CheckMove(0, 'X');
                board.CheckMove(1, 'O');
                board.CheckMove(2, 'X');
                //board.CheckMove(3, 'X');
                board.CheckMove(4, 'X');
                board.CheckMove(5, 'X');
                board.CheckMove(6, 'X');
                board.CheckMove(7, 'X');
                board.CheckMove(8, 'x');
                */

                ConsoleView s = new ConsoleView();
                s.Display(board);

            //} catch (IllegalMoveException ime)

            //{
              //  assertTrue("An IllegalMoveException was caught", false);
            //}

        }
    }
}
