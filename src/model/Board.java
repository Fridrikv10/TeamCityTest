package model;

import java.util.Vector;

/**
 * User:
 * Date: 11/21/12
 */
public class Board
{
    private char[] board = new char[9];
    final int boardSize = 3;

    //Initializes the board by resetting it
    public Board()
    {
        this.ResetBoard();
    }

    public char[] getBoard()
    {
        return board;
    }

    //Checks if a move is valid and if it is: makes the move
    public Vector<Integer> CheckMove(int position, char playerSymbol) throws IllegalMoveException
    {
        //Check if the move is out of bounds
        if(position < 0 || position > 8)
            throw new IllegalMoveException();

        //Check if the move has already been made
        if(board[position] != ' ')
            throw new IllegalMoveException();

        //Makes the move
        board[position] = playerSymbol;

        return CheckWin(position);
    }

    //Resets the characters in the board char array to ' '
    public void ResetBoard()
    {
        for(int i = 0; i < 9; i++)
            board[i] = ' ';
    }

    public Vector<Integer> CheckWin(int position)
    {
        // Returns the number in column"=int column" in the column where position is.
        int column = 0;
        int verticalNum = position+(((position % boardSize)+(column * boardSize)))-position; // Lóðrétt

        // Returns the number in row"=int row" in the column where position is.
        int row = 0;
        int horizontalNum = (position-(position % boardSize))+row; //  Lárétt

        // Column and row of the position.
        int positionRow = position/boardSize;
        int positionCol = position%boardSize;

        // check if there is a win
        boolean check = false;

        // Symbol and Position of winning
        Vector<Integer> winAddress = new Vector<Integer>();

//             i%3
//          0   1   2
//		 0    |   |
//		   -----------
//  i/3	 1    |   |
//		   -----------
//		 2    |   |

        // Check vertical
        if((board[(position+(((position%3))-position))] == board[(position+(((position%3)+3)-position))])&&
                (board[(position+(((position%3)+3)-position))]== board[(position+(((position%3)+6)-position))]))
        {
            check = true;
            for(int i=0;i<3;i++)
            {
                winAddress.add(position+(((position%3)+(i*3))-position));
            }
        }

        // Check horizontal
        if((board[((position-(position%3)))] == board[((position-(position%3))+1)])&&
                (board[((position-(position%3))+1)]== board[((position-(position%3))+2)]))
        {
            check = true;
            for(int i=0;i<3;i++)
            {
                winAddress.add(((position-(position%3))+i));
            }
        }

        // Check diagonal [0,4,8]
        if((position == 0) || (position == 4) || (position == 8))
        {
            if((board[0]== board[4])&&(board[4]== board[8]))
            {
                check = true;
                for(int i=0;i<9;i+=4)
                {
                    winAddress.add(i);
                }
            }
        }

        // check diagonal [2,4,6]
        if((position == 2) || (position == 4) || (position == 6))
        {
            if((board[position+(2-position)]== board[position+(4-position)])&&
                    (board[position+(4-position)]== board[position+(6-position)]))
            {
                check = true;
                for(int i=2;i<7;i+=2)
                {
                    winAddress.add(i);
                }
            }
        }

        if(check)
            return winAddress;
        else
            return null;
    }

    public boolean checkFinish()
    {
        boolean check = true;

        for(int i=0; i<(boardSize*boardSize); i++)
        {
            if(board[i] == ' ')
            {
                check = false;
            }
        }
      return check;
    }

    //TODO: Þurfum að spá í hvað er gert ef það myndast 2 þrennur
    //TODO : Búa til test sem athugar hvort tvær þrennur virkar í wincheck
    //x x x
    //x o o
    //x o o
}
