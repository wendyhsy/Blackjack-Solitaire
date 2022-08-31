/**
 * 
 * @author wendyhsy
 *
 */
import java.util.Scanner;
import java.util.*;

public class BlackjackSolitaire {
	//create grid display to initialize the game; and validGrid to check if all location to play card is filled
	
	String[] grid = {"1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16","17","18","19","20"};
	ArrayList<Integer>validGrid =new ArrayList<Integer>(Arrays.asList(1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16)) ;
	
	//to display play grid
	void displayGrid() {

		System.out.print(grid[0]+" "+grid[1]+" "+grid[2]+" "+grid[3]+" "+grid[4]+ "\n" +
				grid[5]+" "+grid[6]+" "+grid[7]+" "+grid[8]+" "+grid[9]+ "\n" +
				" "+ grid[10]+" "+grid[11]+" "+grid[12]+"\n"+
				" "+ grid[13]+" "+grid[14]+" "+grid[15]+"\n");
	}
	
	//to display discard  grid
	void discardGrid() {
		System.out.print(grid[16]+" "+grid[17]+" "+grid[18]+" "+grid[19]+"\n");
	}
	
	//update grid after each card is placed
	void updateGrid(String cardToPlace, int location) {
		grid[location-1]=cardToPlace;
	}
	
	//check if a location has been placed a card; type boolean
	ArrayList<Integer> takenPlace = new ArrayList<Integer>();
	
	boolean checkTaken(int location) {
		if (takenPlace.contains(location)) {
			System.out.println("Sorry, that position is already filled, please try again");
			return false;
		}
		
		else {
			if (1 <= location & location <= 16) {
				validGrid.remove(Integer.valueOf(location));
			}
			takenPlace.add(location);
			System.out.println("taken "+takenPlace);
			System.out.println("validGrid "+validGrid);

				
			return true;
		}
	}
	//check if game is still going on
	boolean continueGame() {
		if (validGrid.size()==0) {
			return true;
		}
		else {
			return false;
		}
	}
	
	//getting score of each card
	int[] points = new int[16];
	void calculate() {
		String r;
		String s;
		for (int i =0; i<17; i++) {
			s = grid[i].substring(1,2);
			r = grid[i].substring(0,1);
			Card card = new Card(r,s);
			int cardPoint = card.getValue();
			points[i]=cardPoint;
		}
		
	}
	//summing score of each row and column
	void sumScore() {
		int[] scores = new int[9];
		int finalScore=0;
		scores[0] = points[0]+points[1]+points[2]+points[3]+points[4];  //row1
		scores[1]  = points[5]+points[6]+points[7]+points[8]+points[9]; //row2
		scores[2]  = points[10]+points[11]+points[12];                  //row3
		scores[3]  = points[13]+points[14]+points[15];                  //row4
		scores[4]  = points[0]+points[5];                               //column1
		scores[5]  = points[1]+points[6]+points[10]+points[13];         //column2 
		scores[6]  = points[2]+points[7]+points[11]+points[14];         //column3 
		scores[7]  = points[3]+points[8]+points[12]+points[15];         //column4
		scores[8]  = points[4]+points[5];                               //column5
		for (int i=0; i<scores.length;i++) {
			if (scores[4] ==11 ||scores[8] ==11) {
				finalScore = finalScore + 10;
			}
			if (scores[i]==21) {
				finalScore = finalScore + 7;
			}
			if (scores[i]==20) {
				finalScore = finalScore + 5;
			}
			if (scores[i]==19) {
				finalScore = finalScore + 4;
			}
			if (scores[i]==18) {
				finalScore = finalScore + 3;
			}
			if (scores[i]==17) {
				finalScore = finalScore + 2;
			}
			if (scores[i]<=16) {
				finalScore = finalScore + 1;
			}
			if (scores[i]>21) {
				finalScore = 0;
			}
		}
		System.out.println(finalScore);
	}
	
	//initializing the game
	void play() {
		BlackjackSolitaire bjs = new BlackjackSolitaire();
		Deck newDeck = new Deck();
		newDeck.buildDeck();
		newDeck.shuffle();
		newDeck.printDeck();
		while(bjs.continueGame()==false) {
				System.out.println("Current Table: ");
				bjs.displayGrid();
				System.out.println("Discards: ");
				bjs.discardGrid();
				System.out.println("Card to play: ");
				newDeck.deal();
				Card dealCard = newDeck.getDeal();
				String cardToPlace = dealCard.cardToString();
				System.out.println(cardToPlace);
				Scanner userInputScanner = new Scanner(System.in);
				System.out.println("\n Where would you like to place the card? (Please enter a position number between 1-20)");
				int destination = userInputScanner.nextInt();
				if (bjs.checkTaken(destination)==false ) {
					Scanner userInputScanner2 = new Scanner(System.in);
					int destination2 = userInputScanner.nextInt();
					bjs.checkTaken(destination2);
					bjs.updateGrid(cardToPlace, destination2);
				};
				bjs.updateGrid(cardToPlace, destination);
			}
		bjs.displayGrid();
		System.out.println("Game is over. Your score is ");
		bjs.sumScore();
		}
	}
	
