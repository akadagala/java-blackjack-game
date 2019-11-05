
/**
 * Write a description of class Card here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Card
{
    // instance variables - replace the example below with your own
    String suit;
    String value;

    public Card(String s, String v) {
        suit = s;
        value = v;
    }

    public int value(){
        if (value.equals("King") || value.equals("Queen") || value.equals("Jack")) {
            value = "10";
        }
        else if (value.equals("Ace")) {
            value = "11";
        }
        return Integer.parseInt(value); 
    }
    
    public String suit(){
        return suit;
    }
    
    public String toString(){
        return value+" of "+suit;
    }
}
