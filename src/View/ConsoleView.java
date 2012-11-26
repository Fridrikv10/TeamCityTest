package View;

import model.Board;

import java.util.Scanner;

/**
 * User: Gunnar Helgason
 * Date: 25.11.2012
 * Time: 18:40
 */
public class ConsoleView implements View
{
    public void ConsoleView()
    {}

    public void Display(Board b)
    {
        //TODO: endurskíra 'stak'
        int stak = 0;
        System.out.print("\n");
        for (int i = 0; i < 3; i++)
        {
            for (int j = stak; j < stak+3; j++)
            {
                System.out.print("[");
                if(b.getBoard()[j] == ' ')
                    System.out.print(j+1);
                else
                    System.out.print(b.getBoard()[j]);
                System.out.print("]");
            }
            System.out.print("\n");
            stak += 3;
        }
        System.out.print("\n");
    }

    public void DisplayInterface()
    {
        System.out.print("\nexit : exit the game\n");
        System.out.print("play : play a new game\n");
    }

    public String GetInterfaceOption()
    {
        System.out.print(": ");
        Scanner scanner = new Scanner(System.in);

        return scanner.nextLine();
    }

    public String GetPlayerName(int playerNumber)
    {
        System.out.print("Player " + playerNumber + ": ");
        Scanner scanner = new Scanner(System.in);

        return scanner.nextLine();
    }

    public void DisplayVictory(String playerName)
    {
        System.out.print(playerName + " has won the game\n");
    }

    public void DisplayDraw()
    {

        System.out.print("The game was a draw, no one won\n");
    }

    public int GetTurn(String playerName)
    {
        System.out.print(playerName + "s' turn: ");
        Scanner scanner = new Scanner(System.in);

        return (Integer.parseInt(scanner.nextLine())-1);
    }

    public void DisplayIllegalMoveMessage()
    {
        System.out.print("Illegal move, please try again");
    }
}
