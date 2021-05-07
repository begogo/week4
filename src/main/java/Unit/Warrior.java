package Unit;

public class Warrior extends Player {
    private final String name;
    private int hpMax;
    private int hp;
    private int rageMax;
    private int rage;
    private int atk;
    private double atkSpeed;

    public Warrior (){
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

    void bash(){

    }

    void berserk(){

    }

    @Override
    public void run(){
        Warrior warrior = new Warrior();
        Goblin goblin = new Goblin();
        attack(warrior, goblin);
    }

    @Override
    public String toString(){
        return name;
    }

}
