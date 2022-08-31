/**
 * 
 * @author wendyhsy
 * Define Card with rank and suit
 * Get value of card by rank
 */
public class Card {

	public String rank;
	public String suit;
	public int value;
	public String displayString;
	
	//define card with rank and suit; display it with just rank and suit's initial
	Card(String rank, String suit){
		this.rank = rank;
		this.suit = suit;
		displayString=""+rank.charAt(0) + suit.charAt(0);	
		if (rank=="Ten" || rank=="Jack" || rank=="Queen" || rank=="King" || rank=="T" || rank=="J" || rank=="Q" || rank=="K") {
			this.value = 10;
		}
		else if (rank=="Ace"||rank=="A") {
			this.value = 1;
		}
		else {
			this.value=Integer.parseInt(rank);
			}
	}	

	public String getSuit() {
		return suit;
	}
	public String getRank() {
		return rank;
	}
	public String cardToString() {
		return displayString;
	}
	public int getValue() {
	return value;
	}
	
/**
 * 	Test case:
 * 	public static void main(String[] args) {
	Card cards = new Card("3", "H");
	System.out.println(cards.rank.charAt(0));
	System.out.println(cards.getValue());
 */

}
