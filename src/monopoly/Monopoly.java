package monopoly;

import java.util.Collections;
import java.util.Stack;

public class Monopoly {
    private int[] board = new int[40];
    private int currentPosition = 0;
	private int turnsInJail = 0;
    private boolean inJail = false;
    private boolean getOutOfJailFreeChance = false;
	private boolean getOutOfJailFreeCommunity = false;
    private Dice dice = new Dice();
    private Stack<String> communityChestCards = new Stack<>();
    private Stack<String> chanceCards = new Stack<>();

    public Monopoly() {
        loadCards();
    }

    private void loadCards() {
        communityChestCards.push("Advance to Go");
        communityChestCards.push("Go to Jail");
        // more
        Collections.shuffle(communityChestCards);

        chanceCards.push("Advance to Boardwalk");
        chanceCards.push("Go Back 3 Spaces");
        // more
        Collections.shuffle(chanceCards);
    }

    public void movePlayer() {
        DiceResult diceResult = dice.RollDice();

		if (diceResult.getConsecutiveDoublesCount() == 3){
			goToJail();
			return;
		}

        if (inJail) {
            handleJailA(diceResult);
			if (inJail){
				turnsInJail++;
				return; // Onlly return if player did not get out after handleJail
			}
            diceResult.set_consecutiveDoublesCount(0);
        }

        int spacesToMove = diceResult.getDiceRoll1() + diceResult.getDiceRoll2();
        currentPosition = (currentPosition + spacesToMove) % 40;
        board[currentPosition]++;

        if (currentPosition == 30) {
            goToJail();
        } else {
            checkLandingPosition();
        }
    }

    private void handleJailB(DiceResult diceResult) {
        if (getOutOfJailFreeChance) {
            getOutOfJailFreeChance = false;
            inJail = false;
            return;
        } else if (getOutOfJailFreeCommunity) {
			getOutOfJailFreeCommunity = false;
            inJail = false;
            return;
		}
        if (diceResult.isDoubles()) {
            inJail = false;
        }
		if (turnsInJail == 3){
			turnsInJail = 0;
			inJail = false;
		}
    }

	// player gets out of jail either way for strategy A
	private void handleJailA(DiceResult diceResult) {
        if (getOutOfJailFreeChance) {
            getOutOfJailFreeChance = false;
        } else if (getOutOfJailFreeCommunity) {
			getOutOfJailFreeCommunity = false;
		}
        inJail = false;
    }

    private void goToJail() {
        currentPosition = 10;
        inJail = true;
    }

    private void checkLandingPosition() {
        switch (currentPosition) {
            case 2:
            case 17:
            case 33:
                drawCard(communityChestCards);
                break;
            case 7:
            case 22:
            case 36:
                drawCard(chanceCards);
                break;
        }
    }

    private void drawCard(Stack<String> cards) {
        if (cards.isEmpty()) {
            loadCards(); 
        }
        String card = cards.pop();
        executeCardAction(card);
    }

    private void executeCardAction(String card) {
        //System.out.println("Card drawn: " + card);
        // TODO
    }

    public static void main(String[] args) {
        Monopoly game = new Monopoly();
        for (int i = 0; i < 1000000; i++) {
            game.movePlayer();
        }

        CsvExport.exportToCSV("counts.csv", game.board);
    }
}