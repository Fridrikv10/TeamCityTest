package View;

import model.Board;

/**
 * Created with IntelliJ IDEA.
 * User: LENOVO
 * Date: 25.11.2012
 * Time: 20:19
 * To change this template use File | Settings | File Templates.
 */
public interface View
{
    public void Display(Board b);
    public void DisplayInterface();
    public String GetInterfaceOption();
    public String GetPlayerName(int playerNumber);
    public int GetTurn(String playerName);
    public void DisplayIllegalMoveMessage();
    public void DisplayVictory(String playerName);
    public void DisplayDraw();
}
