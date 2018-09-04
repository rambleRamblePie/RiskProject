import java.lang.Math;

class Dice {
	
	private int faceValue;
	
	public void roll() {
		faceValue = (int) 1 + Math.floor(Math.random() * 6);
		if (faceValue)
	}
	
	public int getFaceValue() {
		return faceValue;
	}
	
	
	/*
	public static void main (String args[]) {
		Dice d = new Dice();
		
		for (int i = 0; i < 30; i++) {
			d.roll();
			System.out.println("value: " + d.getFaceValue());
		}
		
		return;
	}
	*/
}