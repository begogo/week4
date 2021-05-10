package Unit;

public abstract class Unit implements Runnable {
    private String name;
    private int hpMax;
    private int hp;
    private int rageMax;
    private int rage;
    private int atk;
    private double atkSpeed;
    private Unit target;


    //getter&setter
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHpMax() {
        return hpMax;
    }

    public void setHpMax(int hpMax) {
        this.hpMax = hpMax;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public int getRageMax() {
        return rageMax;
    }

    public void setRageMax(int rageMax) {
        this.rageMax = rageMax;
    }

    public int getRage() {
        return rage;
    }

    public void setRage(int rage) {
        this.rage = rage;
    }

    public int getAtk() {
        return atk;
    }

    public void setAtk(int atk) {
        this.atk = atk;
    }

    public double getAtkSpeed() {
        return atkSpeed;
    }

    public void setAtkSpeed(double atkSpeed) {
        this.atkSpeed = atkSpeed;
    }

    public Unit getTarget() {
        return target;
    }

    public void setTarget(Unit target) {
        this.target = target;
    }
}

