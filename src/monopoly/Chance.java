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

		chanceCardsStack.push("Test1");
		chanceCardsStack.push("Test2");
		chanceCardsStack.push("Test3");
		chanceCardsStack.push("Test4");
		chanceCardsStack.push("Test5");

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

		System.out.println("The returned top card is: [" + discardPileStack.push(shuffledChanceStack.pop()) + "] \n");

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