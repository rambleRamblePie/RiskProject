import java.lang.Math;

/**
 * A simple Dice class that spawns a die and rolls it
 * @author Alex Miilligan
 * @version 0.4
 */

public class Dice {

	private int faceValue;

	Dice(){}

	/**
	 * Rolls the dice. The result will be a number between 1 and 6
	 * @see Dice
	 */
	public void roll() {
		faceValue = 1 + (int) Math.floor(Math.random() * 6);
	}

	/**
	 * Accesses the face value of the rolled die
	 * @return Returns the value of the die rolled
	 * @see Dice
	 */
	public int getFaceValue() {
		roll();
		return faceValue;
	}
	
}
