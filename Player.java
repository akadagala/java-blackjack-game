
/**
 * Write a description of class Player here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Player
{
    int account;
    String name;
    
    public Player(String n, int a)
    {
        name = n;
        account = a;
    }

    public void subtract(int x)
    {
        account -= x;
    }
    
    public void add(int x) {
        account += x;
    }
    
    public int getValue() {
        return account;
    }
    
    public void printOut() {
        System.out.println(name + " have $" + account + " in your account.");
    }
}
