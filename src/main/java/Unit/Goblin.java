package Unit;

public class Goblin extends Monster {
    private final String name;
    private int hpMax;
    private int hp;
    private int rageMax;
    private int rage;
    private int atk;
    private double atkSpeed;

    public Goblin(){
        super();
        this.name = "고블린";
        this.hpMax = 500;
        this.hp = 500;
        this.rageMax = 100;
        this.rage = 100;
        this.atk = 30;
        this.atkSpeed = 1.5;
        System.out.println("고블린 출현");
    }

    @Override
    public void run(){
        Warrior warrior = new Warrior();
        Goblin goblin = new Goblin();
        attack(goblin, warrior);
    }

    @Override
    public String toString(){
        return name;
    }

}
