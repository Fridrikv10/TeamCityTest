package model;


/**
 * Created with IntelliJ IDEA.
 * User: LENOVO
 * Date: 22.11.2012
 * Time: 17:40
 * To change this template use File | Settings | File Templates.
 */
public class User
{
    private String name;
    private char playerSymbol;

    public User(String name, char playerSymbol)
    {
        this.name = name;
        this.playerSymbol = playerSymbol;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public char getPlayerSymbol() {
        return playerSymbol;
    }

    public void setPlayerSymbol(char playerSymbol) {
        this.playerSymbol = playerSymbol;
    }
}
