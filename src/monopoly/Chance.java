package monopoly;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Stack;

//Boolean variable to know if its the first time it's being called??
//TEST 1 ALEX

//TEST 2 ALEX


public class Chance {
	public static void main(String[] args) {

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
		chanceFunction(shuffledChanceStack, discardPileStack);
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
			chanceFunction(shuffledChanceStack, discardPileStack);
			System.out.println("Checking the remaining shuffled cards in the stack: ");
			System.out.println(shuffledChanceStack + "\n");

			// Checking that it got into the discard pile:
			System.out.println("Checking what's been added to the discard pile after the above call: ");
			System.out.println(discardPileStack + "\n");

		}
	}

	/**
	 * The actual chance function, which will return the card at the top of the
	 * chance pile
	 * 
	 * @param shuffledChanceStack
	 * @param discardPileStack
	 * @return
	 */
	public static Stack chanceFunction(Stack<String> shuffledChanceStack, Stack<String> discardPileStack) {

		String returnedCard = discardPileStack.push(shuffledChanceStack.pop());
		System.out.println("The returned top card is: [" + returnedCard + "] \n");

		if(returnedCard == "\"Advance to Boardwalk\"")
		{
			//position is updated
			//needs current position though
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