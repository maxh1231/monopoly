package monopoly;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Stack;

//Boolean variable to know if its the first time it's being called??
//TEST 1 ALEX

//TEST 2 ALEX


public class CommunityChest {
    public static void main(String[] args) {

        Stack<String> communityChestCardsStack = new Stack<>();
        Stack discardPileStack = new Stack();



        communityChestCardsStack.push("Advance to Go (Collect $200)");
        communityChestCardsStack.push("Bank error in your favor. Collect $200");
        communityChestCardsStack.push("Doctor’s fee. Pay $50");
        communityChestCardsStack.push("From sale of stock you get $50");
        communityChestCardsStack.push("Get Out of Jail Free");
        communityChestCardsStack.push("Go to Jail. Go directly to jail, do not pass Go, do not collect $200");
        communityChestCardsStack.push("Holiday fund matures. Receive $100");
        communityChestCardsStack.push("Income tax refund. Collect $20");
        communityChestCardsStack.push("It is your birthday. Collect $10 from every player");
        communityChestCardsStack.push("Life insurance matures. Collect $100");
        communityChestCardsStack.push("Pay hospital fees of $100");
        communityChestCardsStack.push("Pay school fees of $50");
        communityChestCardsStack.push("Receive $25 consultancy fee");
        communityChestCardsStack.push("You are assessed for street repair. $40 per house. $115 per hotel");
        communityChestCardsStack.push("You have won second prize in a beauty contest. Collect $10");
        communityChestCardsStack.push("You inherit $100");

        // Testing to see cards:
        System.out.println("Un-shuffled cards:");
        System.out.println(communityChestCardsStack);
        System.out.println("");

        // Testing to see shuffled cards:
        Stack shuffledcommunityChestStack = shuffleCards(communityChestCardsStack);
        System.out.println("Shuffled cards");
        System.out.println(shuffledcommunityChestStack + "\n");

        if (shuffledcommunityChestStack.isEmpty()) {
            shuffledcommunityChestStack = shuffleDiscardPileStack(discardPileStack);
            discardPileStack.clear();
        }

        // The function is called and a communitty chest card is taken out of the pile:
        drawCard(shuffledcommunityChestStack, discardPileStack);
        System.out.println("Checking the remaining shuffled cards in the stack: ");
        System.out.println(shuffledcommunityChestStack + "\n");

        // Checking that it got into the discard pile:
        System.out.println("Checking what's been added to the discard pile after the above call: ");
        System.out.println(discardPileStack + "\n");

        // For-loop used to test scenario with empty piles (discard pile needs to be
        // shuffled and becomes the
        // new active pile and discard pile gets emptied)- Comment the whole thing out
        // when no
        // longer needed:
        for (int i = 0; i < 6; i++) {
            if (shuffledcommunityChestStack.isEmpty()) {
                shuffledcommunityChestStack = shuffleDiscardPileStack(discardPileStack);
                discardPileStack.clear();
            }

            // Testing to see shuffled cards:
            System.out.println("Shuffled cards");
            System.out.println(shuffledcommunityChestStack + "\n");

            // The function is called and a community chest card is taken out of the pile:
            drawCard(shuffledcommunityChestStack, discardPileStack);
            System.out.println("Checking the remaining shuffled cards in the stack: ");
            System.out.println(shuffledcommunityChestStack + "\n");

            // Checking that it got into the discard pile:
            System.out.println("Checking what's been added to the discard pile after the above call: ");
            System.out.println(discardPileStack + "\n");

        }
    }

    /**
     * The actual function, which will return the card at the top of the pile
     *
     * @param shuffledcommunityChestStack
     * @param discardPileStack
     * @return
     */
    public static Stack drawCard(Stack<String> shuffledCommunityChestStack, Stack<String> discardPileStack, int currentPosition) {

        String returnedCard = discardPileStack.push(shuffledCommunityChestStack.pop());
        System.out.println("The returned top card is: [" + returnedCard + "] \n");

        if (returnedCard.equals("Advance to Go (Collect $200)")) {
            //set correct position?
            currentPosition = 0;
        }
        else if (returnedCard.equals("Go to Jail. Go directly to jail, do not pass Go, do not collect $200")) {
            currentPosition = 10; // Assuming 10 is the jail position
        }
        else if (returnedCard.equals("Get Out of Jail Free")) {
            getOutofJailFree = true;
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