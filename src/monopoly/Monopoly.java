package monopoly;

import java.util.*;

public class Monopoly {
	private int[] board;
	private String[] boardNames;
	private int currentPosition;
	private Stack<String> communityChestCards;
	private Stack<String> chanceCards;
	private boolean inJail;
	private boolean getOutOfJailFree;
	private int totalMoves;

	public Monopoly() {
		this.board = new int[40];
		this.currentPosition = 0;
		this.communityChestCards = new Stack<>();
		Collections.shuffle(this.communityChestCards);
		this.chanceCards = new Stack<>();
		this.inJail = false;
		this.getOutOfJailFree = false;

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
            // Chance
        } else if (newPosition == 2 || newPosition == 17 || newPosition == 33) {
            //Community Chest
        }
        
        totalMoves++;
        board[newPosition]++;
    }
}
