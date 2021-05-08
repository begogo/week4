package Unit;

public class Goblin extends Monster {
    private final String name;
    private int hpMax;
    private int hp;
    private int rageMax;
    private int rage;
    private int atk;
    private double atkSpeed;
    private Unit target;

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
        Goblin goblinInstance = new Goblin();
        attack(goblinInstance, target);
    }

    @Override
    public String toString(){
        return name;
    }


    public void setTarget(Unit target) {
        this.target = target;
    }

}
