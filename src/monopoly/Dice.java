package monopoly;

import java.util.Random;

public class Dice {

	private int _consecutiveDoublesCount = 0;
	private Random _random = new Random();

	public DiceResult RollDice() {
		// Generate a random number between 1 and 6 (inclusive)
		int diceRoll1 = _random.nextInt(6) + 1;
		int diceRoll2 = _random.nextInt(6) + 1;
		if (diceRoll1 == diceRoll2) {
			_consecutiveDoublesCount++;
		} else {
			_consecutiveDoublesCount = 0;
		}
		DiceResult diceResult = new DiceResult(diceRoll1, diceRoll2, _consecutiveDoublesCount);
		return diceResult;
	}

	public static void main(String[] args) {
		Dice dice = new Dice();
		DiceResult diceResult;
		for (int i = 0; i < 1000; i++) {
			diceResult = dice.RollDice();
			System.out.println("1: " + diceResult.getDiceRoll1() + ", 2: " + diceResult.getDiceRoll2() + ", Dubs?: "
					+ diceResult.isDoubles() + ", DC: " + diceResult.getConsecutiveDoublesCount());
		}
	}
}