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
        loadCommunityCards();
		loadChanceCards();
    }

	private void loadChanceCards() {
		if (!getOutOfJailFreeChance){
			chanceCards.push("Get Out of Jail Free");
		}
        chanceCards.push("Advance to Boardwalk");
		chanceCards.push("Advance to Go");
		chanceCards.push("Advance to Illinois Avenue");
		chanceCards.push("Advance to St. Charles Place");
		chanceCards.push("Advance to nearest Railroad");
		chanceCards.push("Advance to nearest Railroad");
		chanceCards.push("Advance to nearest Utility");
		chanceCards.push("Go Back 3 Spaces");
		chanceCards.push("Go to Jail");
		chanceCards.push("Take a trip to Reading Railroad");
		for (int i = 0; i < 5; i++){
			chanceCards.push("NA");
		}

        Collections.shuffle(chanceCards);
	}

    private void loadCommunityCards() {
		if (!getOutOfJailFreeCommunity){
			communityChestCards.push("Get out of Jail Free");
		}
		communityChestCards.push("Advance to Go");
		communityChestCards.push("Go to Jail");
		for (int i = 0; i < 13; i++) {
			communityChestCards.push("NA");
		}

        Collections.shuffle(communityChestCards);
    }

    public void movePlayer() {
		DiceResult diceResult;
		boolean releasedFromJail = false;
		do {
        	diceResult = dice.RollDice();

			if (diceResult.getConsecutiveDoublesCount() == 3){
				diceResult.set_consecutiveDoublesCount(0);
				goToJail();
				return;
			}

       	 	if (inJail) {
            	releasedFromJail = handleJailA(diceResult);
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

		 	if (releasedFromJail) {
		 		return;
			}	
		 	
		} while (diceResult.isDoubles());
    }

    private boolean handleJailB(DiceResult diceResult) {
        if (getOutOfJailFreeChance) {
            getOutOfJailFreeChance = false;
            inJail = false;
            return true;
        } else if (getOutOfJailFreeCommunity) {
			getOutOfJailFreeCommunity = false;
            inJail = false;
            return true;
		}
        if (diceResult.isDoubles()) {
            inJail = false;
			return true;
        }
		if (turnsInJail == 3){
			inJail = false;
			return true;
		}
		return false;
    }

	// player gets out of jail either way for strategy A
	private boolean handleJailA(DiceResult diceResult) {
        if (getOutOfJailFreeChance) {
            getOutOfJailFreeChance = false;
        } else if (getOutOfJailFreeCommunity) {
			getOutOfJailFreeCommunity = false;

		}
        inJail = false;
		return true;
    }

    private void goToJail() {
		turnsInJail = 0;
        currentPosition = 10;
        inJail = true;
    }

    private void checkLandingPosition() {
        switch (currentPosition) {
            case 2:
            case 17:
            case 33:
                drawCommunityCard(communityChestCards);
                break;
            case 7:
            case 22:
            case 36:
                drawChanceCard(chanceCards);
                break;
        }
    }

    private void drawCommunityCard(Stack<String> cards) {
        if (cards.isEmpty()) {
            loadCommunityCards(); 
        }
        String card = cards.pop();
        executeCommunityCardAction(card);
    }

    private void executeCommunityCardAction(String card) {
		switch (card) {
			case "Advance to Go":
				currentPosition = 0;
				break;
			case "Go to Jail":
				goToJail();
				break;
			case "Get Out of Jail Free":
				getOutOfJailFreeCommunity = true;
				break;
		}
    }

	private void drawChanceCard(Stack<String> cards) {
        if (cards.isEmpty()) {
            loadChanceCards(); 
        }
        String card = cards.pop();
        executeChanceCardAction(card);
    }

	private void executeChanceCardAction(String card) {
		switch (card) {
			case "Advance to Go":
				currentPosition = 0;
				break;
			case "Go to Jail":
				goToJail();
				break;
			case "Get Out of Jail Free":
				getOutOfJailFreeChance = true;
				break;
			case "Advance to Boardwalk":
				currentPosition = 39;
				break;
			case "Advance to Illinois Avenue":
				currentPosition = 24;
				break;
			case "Advance to St. Charles Place":
				currentPosition = 11;
				break;
			case "Advance to nearest Railroad":
				switch (currentPosition) {
					case 7:
						currentPosition = 15;
						break;
					case 22:
						currentPosition = 25;
						break;
					case 36:
						currentPosition = 5;
						break;
				}
				break;
			case "Take a trip to Reading Railroad":
				currentPosition = 5;
				break;
			case "Advance to nearest Utility":
				switch (currentPosition) {
					case 7:
					case 36:
						currentPosition = 12;
						break;
					case 22:
						currentPosition = 28;
						break;
				}
				break;
			case "Go Back 3 Spaces":
				currentPosition -= 3;
				break;
		}
	}

    public static void main(String[] args) {
        Monopoly game = new Monopoly();
		Monopoly game2 = new Monopoly();
		Monopoly game3 = new Monopoly();
		Monopoly game4 = new Monopoly();

        for (int i = 0; i < 1000; i++) {
            game.movePlayer();
        }
		for (int i = 0; i < 10000; i++) {
            game2.movePlayer();
        }
		for (int i = 0; i < 100000; i++) {
            game3.movePlayer();
        }
		for (int i = 0; i < 1000000; i++) {
            game4.movePlayer();
        }

        CsvExport.exportToCSV("counts.csv", game.board, game2.board, game3.board, game4.board);
    }
}