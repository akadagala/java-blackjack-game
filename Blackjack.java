
/**
 * Write a description of class Blackjack here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
import java.util.Scanner;
import java.util.ArrayList;
public class Blackjack
{
    Scanner sc;
    Deck deck;
    ArrayList<Card> playerHand;
    ArrayList<Card> dealerHand;
    Player player;
    int account, bet, total;
    String play, choice; 
    Card card;
    boolean game;
    
    public Blackjack() {
        sc = new Scanner (System.in); 
        
        deck = new Deck();
        deck.shuffle();
        
        player = new Player("You", 500);
        
        playerHand = new ArrayList<Card>();
        playerHand.add(deck.draw());
        playerHand.add(deck.draw());
        
        dealerHand = new ArrayList<Card>();
        dealerHand.add(deck.draw());
        dealerHand.add(deck.draw());
        
        game = true;
    }
    
    public int value(ArrayList<Card> a) {
        total = 0;
        for (int i = 0; i < a.size(); i++) {
            total += a.get(i).value();
        }
        return total;
    }

    public void dealerPlay() {
        System.out.println("Dealer has: " +dealerHand);
        if (value(dealerHand) > 21) {
            System.out.println("Dealer busts! You keep your bet!");
            player.add(bet);
        }
        else {
            System.out.println("Dealer stands! You lose your bet!");
        }
    }
    
    public void game() {
        //game
        while (game == true) {
            player.printOut();
        
            //place bet
            System.out.println("Place your bet: ");
            bet = sc.nextInt();
            player.subtract(bet);
        
            //deal cards (display values)
            System.out.println("Your hand: " +playerHand);
            if (value(playerHand) > 21) {
                System.out.println("You bust!");
                game = false;
                dealerPlay();
                break;
            }
        
            //show 1 dealer's card
            System.out.println("Dealer has: " +dealerHand.get(0).toString());
        
            //ask if player wants to hit or stand
            System.out.println("Hit (h) or stand (s)?");
            play = sc.next();
        
            while(play.equalsIgnoreCase("h")) {
                //if hit, deal another card, display hand
                playerHand.add(deck.draw());
                System.out.println("Your hand: " +playerHand);

                //if player's hand exceeds 21, they bust
                if (value(playerHand) > 21) {
                    System.out.println("You bust!");
                    dealerPlay();
                    break;
                }
                System.out.println("Hit (h) or stand (s)?");
                play = sc.next();
            }
        
            dealerPlay();
            
            System.out.println("New game (Y or N)?");
            choice = sc.nextLine();
            if (choice.equalsIgnoreCase("N")){
                game = false;
            }
        
        } 
        
    }
    
}