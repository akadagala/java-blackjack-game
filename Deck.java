
/**
 * Write a description of class Deck here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
import java.util.Random;
import java.util.ArrayList;
public class Deck
{
    ArrayList<Card> deck = new ArrayList<Card>();
    String[] values = new String[]{"2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King", "Ace"};
    String[] suits = new String[]{"Clubs", "Spades", "Diamonds", "Hearts"};
    ArrayList<Card> tempDeck = new ArrayList<Card>();
    
    public Deck(){
        for (int x = 0; x < 4; x++) {
            for (int y = 0; y < 13; y++) {
                deck.add(new Card(suits[x], values[y]));
            }
        }
    }
    
    public void shuffle(){
        int rand;
        for (int x = 0; x < 52; x++) {
            tempDeck.add(deck.get(x));
        }
        
        for (int i = 0; i < 52; i++) {
            rand = (int)(Math.random()*tempDeck.size());
            deck.set(i,tempDeck.get(rand));
            tempDeck.remove(rand);
        }
    }

    public Card draw(){
        int d = (int)Math.random()*(deck.size()-1);
        Card card = deck.get(d);
        deck.remove(d);
        return card;
    }
    
    public void printOut(){
        for (int i = 0; i < deck.size()-1; i++) {
            System.out.println(deck.get(i).toString());
        }
    }
}
