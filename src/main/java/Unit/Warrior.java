package Unit;

public class Warrior extends Player {
    private static Warrior warriorSingleton = new Warrior();

    private Warrior (){
        setName("전사");
        setHpMax(1000);
        setHp(1000);
        setRageMax(100);
        setRage(100);
        setAtk(100);
        setAtkSpeed(1.5);
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
        attack(warriorSingleton, getTarget());
    }

    public void attack (Warrior attacker, Unit target) {
        while (attacker.getHp() > 0 && target.getHp() > 0){
            target.setHp(target.getHp() - attacker.getAtk());
            System.out.println(attacker.getName() + "은(는) 기본공격으로 " + target.getName() + "에게 피해를 입혔습니다.");
            System.out.println(target.getName() + " 체력: " + target.getHp());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
