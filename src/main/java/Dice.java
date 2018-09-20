import java.lang.Math;

class Dice {
	
	private int faceValue;
	
	public void roll() {
		faceValue = 1 + (int) Math.floor(Math.random() * 6);
	}
	
	public int getFaceValue() {
		roll();
		return faceValue;
	}
	
	
	
}


// javac Dice.java
// java *.class
/*
class test {
	public static void main (String args[]) {
		Dice d = new Dice();
		
		for (int i = 0; i < 30; i++) {
			d.roll();
			System.out.println("value: " + d.getFaceValue());
		}
	}
}
*/