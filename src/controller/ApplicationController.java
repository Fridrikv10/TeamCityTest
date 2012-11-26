package controller;

import View.View;
import View.ConsoleView;

import model.Board;
import model.IllegalMoveException;
import model.User;


import java.util.Vector;

/**
 * Created with IntelliJ IDEA.
 * User: LENOVO
 * Date: 24.11.2012
 * Time: 18:48
 * To change this template use File | Settings | File Templates.
 */
public class ApplicationController
{
    public static void main(String[] args)
    {
        boolean exit = false;
        while(exit == false)
        {
            //Create the view
            View view = new ConsoleView();

            //Display the interface
            view.DisplayInterface();

            //Get the players picked option
            String interfaceQuery = view.GetInterfaceOption();

            if(interfaceQuery.equals("exit"))
            {
                exit = true;
            }
            else if(interfaceQuery.equals("play"))
            {
                Board board = new Board();
                Vector<User> players = new Vector<User>();

                players.add(new User(view.GetPlayerName(1), 'X'));
                players.add(new User(view.GetPlayerName(2), 'O'));

                int activePlayer = 0;
                boolean hasWon = false;
                while(hasWon == false)
                {
                    view.Display(board);

                    //Player move
                    boolean legalMove = false;
                    while(legalMove == false)
                    {
                        //Get the active players move
                        int move = view.GetTurn(players.elementAt(activePlayer).getName());

                        try{
                            if(board.CheckMove(move, players.elementAt(activePlayer).getPlayerSymbol()) != null)
                            {
                                view.Display(board);
                                view.DisplayVictory(players.elementAt(activePlayer).getName());
                                hasWon = true;
                            }
                            else if(board.checkFinish() == true)
                            {
                                view.Display(board);
                                view.DisplayDraw();
                                hasWon = true;
                            }
                            legalMove = true;
                        }
                        catch(IllegalMoveException ime){
                            view.DisplayIllegalMoveMessage();
                        }
                    }

                    //Change to the next player
                    if(activePlayer == (players.size()-1))
                        activePlayer = 0;
                    else
                        activePlayer++;
                }
            }
        }
    }
}
