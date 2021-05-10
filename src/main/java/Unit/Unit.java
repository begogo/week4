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

    @Override
    public void run(){
        attack(getTarget());
    }

    public void attack (Unit target) {
        while (getHp() > 0 && target.getHp() > 0){
            target.setHp(Math.max( 0, target.getHp() - getAtk() ));
            System.out.println(getName() + "이(가) 기본공격으로 " + target.getName() + "에게 " + getAtk() + " 피해를 입혔습니다.");
            System.out.println(target.getName() + " 체력: " + target.getHp());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }



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

