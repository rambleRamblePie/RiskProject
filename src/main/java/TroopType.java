public interface TroopType {
	// int power; java interfaces do not allow this
	public int getPower();
}

class Infantry implements TroopType {
	final static int power = 1;
	public int getPower() { return power; }
}

class Cavalry implements TroopType {
	final static int power = 5;
	public int getPower() { return power; }
}

class Artillery implements TroopType {
	final static int power = 10;
	public int getPower() { return power; }
}