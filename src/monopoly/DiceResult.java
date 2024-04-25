package monopoly;

public class DiceResult {
	private int _diceRoll1;
	private int _diceRoll2;
	private int _consecutiveDoublesCount;

	public int getDiceRoll1() {
		return _diceRoll1;
	}

	public int getDiceRoll2() {
		return _diceRoll2;
	}

	public boolean isDoubles() {
		return getDiceRoll1() == getDiceRoll2();
	}

	public int getConsecutiveDoublesCount() {
		return _consecutiveDoublesCount;
	}

	public DiceResult(int diceRoll1, int diceRoll2, int consecutiveDoublesCount) {
		_diceRoll1 = diceRoll1;
		_diceRoll2 = diceRoll2;
		_consecutiveDoublesCount = consecutiveDoublesCount;
	}
}