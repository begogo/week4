package Unit;

public class Warrior extends Player {
    private static Warrior warriorSingleton = new Warrior();

    private final String name;
    private int hpMax;
    private int hp;
    private int rageMax;
    private int rage;
    private int atk;
    private double atkSpeed;
    private Unit target;

    private Warrior (){
        super();
        this.name = "전사";
        this.hpMax = 1000;
        this.hp = 1000;
        this.rageMax = 100;
        this.rage = 100;
        this.atk = 100;
        this.atkSpeed = 1.5;
        System.out.println("전사입니다");
    }

    public static Warrior getInstance(){
        return warriorSingleton;
    }


    void bash(){

    }

    void berserk(){

    }

    @Override
    public void run(){
        attack(warriorSingleton, target);
    }

    @Override
    public String toString(){
        return name;
    }


    public void setTarget(Unit target) {
        this.target = target;
    }

}
