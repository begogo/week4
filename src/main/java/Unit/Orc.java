package Unit;

public class Orc extends Monster {
    private final String name;
    private int hpMax;
    private int hp;
    private int rageMax;
    private int rage;
    private int atk;
    private double atkSpeed;

    public Orc(){
        super();
        this.name = "오크";
        this.hpMax = 1000;
        this.hp = 1000;
        this.rageMax = 100;
        this.rage = 100;
        this.atk = 60;
        this.atkSpeed = 1.5;
        System.out.println("오크 출현");
    }

    @Override
    public void run(){
    }

    @Override
    public String toString(){
        return name;
    }

}
