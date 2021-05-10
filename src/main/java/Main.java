import Unit.*;

public class Main {
    public static void main(String[] args) {
        Warrior warrior = new Warrior();
        Goblin goblin = new Goblin();

        Thread t1 = new Thread(warrior);
        Thread t2 = new Thread(goblin);

        warrior.setTarget(goblin);
        goblin.setTarget(warrior);

        t1.start();
        t2.start();

    }
}
