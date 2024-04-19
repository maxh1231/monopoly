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

	public Monopoly() {
		this.board = new int[40];
		this.currentPosition = 0;
		this.communityChestCards = new Stack<>();
		Collections.shuffle(this.communityChestCards);
		this.chanceCards = new Stack<>();
		this.inJail = false;
		this.getOutOfJailFree = false;

	}

}
