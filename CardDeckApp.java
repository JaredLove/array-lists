     // import the ArrayList class
import java.util.ArrayList;
     //CardDeckApp class
public class CardDeckApp {
        // main method
    public static void main(String[] args) {
        System.out.println("DECK");
            //storing what is returned from the getDeck method in an arrayList called deck.
        ArrayList<String> deck = getDeck();
        displayCards(deck);

        System.out.println("SHUFFLED DECK");
        shuffleDeck(deck);
        displayCards(deck);
        int count = 2;
        int hands = 4;
            //using a for loop to display multiple nads instead of a single one.
        for(int i = 0; i < hands; i++){
            System.out.println("HAND " + (i + 1) + " OF " + count + " CARDS");
            ArrayList<String> hand = dealCards(deck, count);
            displayCards(hand);  
        }
            //printing out the remaining cards left in the deck.
        System.out.println("Cards left: " + deck.size());
    }
        //getDeck Method that will return an arrayList of strings for the deck
    private static ArrayList<String> getDeck() {
        String[] suits = {"Spades", "Hearts", "Diamonds", "Clubs"};
        String[] ranks = {"Ace", "2", "3", "4", "5", "6", "7", 
            "8", "9", "10", "Jack", "Queen", "King"};        
            //store cards in an arrayList named deck with an amount of 52
        ArrayList<String> deck = new ArrayList<String>(52);
            //for every suit in suits
        for (String suit : suits) {
                //for every rank in ranks
            for (String rank : ranks) {
                    // using the add method to add strings to the deck arrayList using the current rank and suit.
                deck.add( rank + " of " + suit);
            }
        }
        return deck;
    }
        // displayCards method that accepts an ArrayList and returns nothing
    private static void displayCards(ArrayList<String> cards) {
        System.out.print("|");        
        for (String card : cards) {
            System.out.print(card + "|");
        }
        System.out.println();        
    }
        // shuffleDeck method that accepts an ArrayList and returns nothing
    private static void shuffleDeck(ArrayList<String> deck) {
            //a for loop using the size method on the deck ArrayList .
        for (int i = 0; i < deck.size(); i++) {
                //store the current index card on the varaiable savedCard.
            String savedCard = deck.get(i);
                //random number stored on the variable randomIndex.
            int randomIndex = (int) (Math.random() * deck.size());
                //using the set method to replace the card at index i with the card from randomIndex.
            deck.set(i, deck.get(randomIndex));
                //using the set method to replace the card at randomIndex with the original card from savedCard.
            deck.set(randomIndex, savedCard);
        }
    }
        //dealCards method that accepts and returns an arrayList
    private static ArrayList<String> dealCards(ArrayList<String> deck, int count) {
        ArrayList<String> hand = new ArrayList<>();

        // for loop up to the count of cards from the top of the deck and checks to make sure the deck is not empty.
        for (int i = 0; i < count && !deck.isEmpty(); i++) {
                // removes from deck and adds to hand at index 0
            hand.add(deck.remove(0));
        }

        return hand;
    }

}