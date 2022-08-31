/**
 * 
 * @author wendyhsy
 *
 */
import java.util.*;

public class Deck {
	//create a deck of cards call newDeck; building the deck by looping through suits and ranks
	public ArrayList<Card> newDeck = new ArrayList<Card>();

    String[] suits = {"Spade", "Hearts", "Clubs", "Diamonds"};
    String[] ranks = {"Ace","2","3","4","5","6","7","8","9","Ten","Jack","Queen","King"};
	
	void buildDeck() {
		for(String s : suits){
			for(String r : ranks) {
		        	Card  c = new Card(r,s);   
		        	newDeck.add(c);
		        }
		    }
	}
	public void printDeck() {
		for(int i=0;i<newDeck.size();i++) {
			System.out.print(newDeck.get(i).displayString+" ");
		}
	}
	//shuffle deck to random order
	public void shuffle() {
	    Collections.shuffle(newDeck); 
    	printDeck();
	}

	//dealing card by drawing the first card of the deck
	public Card deal() {
		Card cardToPlace = newDeck.get(0);
		newDeck.remove(0);
		return cardToPlace;
	}
	
	public Card getDeal() {
		return deal();
	}
/** test case:
 * //	public static void main(String[] args) {
//		Deck newDeck = new Deck();
//		newDeck.buildDeck();
//		newDeck.shuffle();
//		newDeck.printDeck();
//	}
	
 */
}
