public interface TroopType {
    int power;
    int getPower();
}

class Infantry {
    final static int power = 1;
}

class Cavalry {
    final static int power = 5;
}

class Artillery {
    final static int power = 10;

}