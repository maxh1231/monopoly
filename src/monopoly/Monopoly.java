package monopoly;

import java.util.*;


public class Monopoly {
	private int[] board;
	private String[] boardNames;

	private Stack<String> communityChestCards;
	private Stack<String> chanceCards;
	private boolean inJail;
	private boolean getOutOfJailFree;
	private int totalMoves;
	protected int currentPosition;
	private boolean chanceFirstRun;
	private Chance chance = new Chance();

	public Monopoly() {
		this.board = new int[40];
		this.currentPosition = 0;
		this.communityChestCards = new Stack<>();
		Collections.shuffle(this.communityChestCards);
		this.chanceCards = new Stack<>();
		this.inJail = false;
		this.getOutOfJailFree = false;
		this.chanceFirstRun = false;

	}

	public void JailA() {
		if (getOutOfJailFree == true) {
			getOutOfJailFree = false; // use get out of jail free card
			currentPosition = 10;
//	         RollDice();
			// move player
		} else { // pay fine
			currentPosition = 10;
//	         RollDice();
			// move player
		}
	}

	public void JailB() {
		if (getOutOfJailFree == true) {
			getOutOfJailFree = false; // use get out of jail free card
			currentPosition = 10;
//	         RollDice();
			// move player
		} else {
			int count = 1;
			boolean doubles = false;
			for (int x = 1; x <= 3; x++) {
				doubles = RollDice();
				if (doubles == true) {
					// move player
					break;
				}
				count++;// counting number of tries for doubles
			}
			if (count > 3) { // 4th turn, pays fine
//	            RollDice();
				// move player
			}
		}
	}

	
    public void movePlayer(int spacesToMove) {
        int newPosition = (currentPosition + spacesToMove) % 40; 
        
        if (newPosition < currentPosition) {
        	// Go
        }
        
        // Update the current position
        currentPosition = newPosition;
        
        // Jail
        if (newPosition == 30) {
            currentPosition = 10;
            inJail = true;
        } else if (newPosition == 7 || newPosition == 22 || newPosition == 36) {
			if(!chanceFirstRun)
			{
				Monopoly.Chance.initializeChanceCards();
				Monopoly.Chance.shuffleCards();
			}


        } else if (newPosition == 2 || newPosition == 17 || newPosition == 33) {
            //Community Chest
        }
        
        totalMoves++;
        board[newPosition]++;
    }



class Chance {
	Stack<String> chanceCardsStack = new Stack<>();
	Stack discardPileStack = new Stack();
	public static void main(String[] args) {

		int test = Monopoly.
		Stack<String> chanceCardsStack = new Stack<>();
		Stack discardPileStack = new Stack();

//		chanceCardsStack.push("Test1");
//		chanceCardsStack.push("Test2");
//		chanceCardsStack.push("Test3");
//		chanceCardsStack.push("Test4");
//		chanceCardsStack.push("Test5");

		chanceCardsStack.push("Advance to Boardwalk");
		chanceCardsStack.push("Advance to Go (Collect $200)");
		chanceCardsStack.push("Advance to Illinois Avenue. If you pass Go, collect $200");
		chanceCardsStack.push("Advance to St. Charles Place. If you pass Go, collect $200");
		chanceCardsStack.push("Advance to the nearest Railroad. If unowned, you may buy it from the Bank. If owned, pay owner twice the rental to which they are otherwise entitled");
		chanceCardsStack.push("Advance to the nearest Railroad. If unowned, you may buy it from the Bank. If owned, pay owner twice the rental to which they are otherwise entitled");
		chanceCardsStack.push("Advance token to nearest Utility. If unowned, you may buy it from the Bank. If owned, throw dice and pay owner a total ten times amount thrown");
		chanceCardsStack.push("Bank pays you dividend of $50");
		chanceCardsStack.push("Get Out of Jail Free");
		chanceCardsStack.push("Go Back 3 Spaces");
		chanceCardsStack.push("Go to Jail. Go directly to Jail, do not pass Go, do not collect $200");
		chanceCardsStack.push("Make general repairs on all your property. For each house pay $25. For each hotel pay $100");
		chanceCardsStack.push("Speeding fine $15");
		chanceCardsStack.push("Take a trip to Reading Railroad. If you pass Go, collect $200");
		chanceCardsStack.push("You have been elected Chairman of the Board. Pay each player $50");
		chanceCardsStack.push("Your building loan matures. Collect $150");

		// Testing to see cards:
		System.out.println("Un-shuffled cards:");
		System.out.println(chanceCardsStack);
		System.out.println("");

		// Testing to see shuffled cards:
		Stack shuffledChanceStack = shuffleCards(chanceCardsStack);
		System.out.println("Shuffled cards");
		System.out.println(shuffledChanceStack + "\n");

		if (shuffledChanceStack.isEmpty()) {
			shuffledChanceStack = shuffleDiscardPileStack(discardPileStack);
			discardPileStack.clear();
		}

		// The function is called and a chance card is taken out of the pile:
		drawCard(shuffledChanceStack, discardPileStack, currentPosition);
		System.out.println("Checking the remaining shuffled cards in the stack: ");
		System.out.println(shuffledChanceStack + "\n");

		// Checking that it got into the discard pile:
		System.out.println("Checking what's been added to the discard pile after the above call: ");
		System.out.println(discardPileStack + "\n");

		// For-loop used to test scenario with empty piles (discard pile needs to be
		// shuffled and becomes the
		// new active pile and discard pile gets emptied)- Comment the whole thing out
		// when no
		// longer needed:
		for (int i = 0; i < 6; i++) {
			if (shuffledChanceStack.isEmpty()) {
				shuffledChanceStack = shuffleDiscardPileStack(discardPileStack);
				discardPileStack.clear();
			}

			// Testing to see shuffled cards:
			System.out.println("Shuffled cards");
			System.out.println(shuffledChanceStack + "\n");

			// The function is called and a chance card is taken out of the pile:
			drawCard(shuffledChanceStack, discardPileStack, currentPosition);
			System.out.println("Checking the remaining shuffled cards in the stack: ");
			System.out.println(shuffledChanceStack + "\n");

			// Checking that it got into the discard pile:
			System.out.println("Checking what's been added to the discard pile after the above call: ");
			System.out.println(discardPileStack + "\n");

		}
	}


	/**
	 * Set up the chance cards (unshuffled)
	 */
	public static initializeChanceCards()
	{


//		chanceCardsStack.push("Test1");
//		chanceCardsStack.push("Test2");
//		chanceCardsStack.push("Test3");
//		chanceCardsStack.push("Test4");
//		chanceCardsStack.push("Test5");

		chanceCardsStack.push("Advance to Boardwalk");
		chanceCardsStack.push("Advance to Go (Collect $200)");
		chanceCardsStack.push("Advance to Illinois Avenue. If you pass Go, collect $200");
		chanceCardsStack.push("Advance to St. Charles Place. If you pass Go, collect $200");
		chanceCardsStack.push("Advance to the nearest Railroad. If unowned, you may buy it from the Bank. If owned, pay owner twice the rental to which they are otherwise entitled");
		chanceCardsStack.push("Advance to the nearest Railroad. If unowned, you may buy it from the Bank. If owned, pay owner twice the rental to which they are otherwise entitled");
		chanceCardsStack.push("Advance token to nearest Utility. If unowned, you may buy it from the Bank. If owned, throw dice and pay owner a total ten times amount thrown");
		chanceCardsStack.push("Bank pays you dividend of $50");
		chanceCardsStack.push("Get Out of Jail Free");
		chanceCardsStack.push("Go Back 3 Spaces");
		chanceCardsStack.push("Go to Jail. Go directly to Jail, do not pass Go, do not collect $200");
		chanceCardsStack.push("Make general repairs on all your property. For each house pay $25. For each hotel pay $100");
		chanceCardsStack.push("Speeding fine $15");
		chanceCardsStack.push("Take a trip to Reading Railroad. If you pass Go, collect $200");
		chanceCardsStack.push("You have been elected Chairman of the Board. Pay each player $50");
		chanceCardsStack.push("Your building loan matures. Collect $150");

	}

	/**
	 * The actual chance function, which will return the card at the top of the
	 * chance pile
	 *
	 * @param shuffledChanceStack
	 * @param discardPileStack
	 * @return
	 */
	public static Stack drawCard(Stack<String> shuffledChanceStack, Stack<String> discardPileStack, int currentPosition) {


		if (shuffledChanceStack.isEmpty())
		{
			shuffledChanceStack = shuffleDiscardPileStack(discardPileStack);
			discardPileStack.clear();
		}

		String returnedCard = discardPileStack.push(shuffledChanceStack.pop());
		System.out.println("The returned top card is: [" + returnedCard + "] \n");

		if(returnedCard == "\"Advance to Boardwalk\"")
		{
			//set correct position?
			currentPosition = 0;
		}

		else if (returnedCard == "Advance to Go (Collect $200)") {
			currentPosition = 0;
		}

		else if (returnedCard == "Advance to Illinois Avenue. If you pass Go, collect $200" ) {
			//set correct position?
			currentPosition = 0;
		}

		else if (returnedCard == "Advance to St. Charles Place. If you pass Go, collect $200" ) {
			//set correct position?
			currentPosition = 0;
		}

		else if (returnedCard.contains("\"Advance to the nearest Railroad") ) {
			//set correct position?
			currentPosition = 0;
		}


		else if (returnedCard.contains("Advance token to nearest Utility") ) {
			//set correct position?
			currentPosition = 0;
		}


		else if (returnedCard == "Get Out of Jail Free" ) {
			getOutofJailFree = true;
		}


		else if (returnedCard == "Go Back 3 Spaces") {
			currentPosition = currentPosition - 3;
		}


		else if (returnedCard == "Go to Jail. Go directly to Jail, do not pass Go, do not collect $200") {
			currentPosition = 10;
		}


		else if (returnedCard == "Take a trip to Reading Railroad. If you pass Go, collect $200" {
			currentPosition = 10;
		}

		return discardPileStack;

	}

	/**
	 * The method to shuffle the cards
	 *
	 * @param cardsStack
	 * @return
	 */
	public static Stack shuffleCards(Stack<String> cardsStack) {

		Stack newShuffledStack = new Stack();

		// Arraylists and Stacks are part of the Collections framework.
		// Create an ArrayList to use the Collections' shuffle
		ArrayList<String> tempList = new ArrayList<>(cardsStack);

		Collections.shuffle(tempList);

		// adding the shuffled elements into a stack again
		for (String card : tempList) {
			newShuffledStack.push(card);
		}

		return newShuffledStack;
	}

	/**
	 * Will shuffle the discard pile when needed (meaning, when regular pile is
	 * empty)
	 *
	 * @param discardPileStack
	 * @return
	 */
	public static Stack shuffleDiscardPileStack(Stack<String> discardPileStack) {
		Stack newShuffledStack = new Stack();

		// Arraylists and Stacks are part of the Collections framework.
		// Create an ArrayList to use the Collections' shuffle
		ArrayList<String> tempList = new ArrayList<>(discardPileStack);

		Collections.shuffle(tempList);

		// adding the shuffled elements into a stack again
		for (String card : tempList) {
			newShuffledStack.push(card);
		}

		return newShuffledStack;
	}

}

//didn't work (?) lol
	public int getCurrentPosition() {
		return currentPosition;
	}

}