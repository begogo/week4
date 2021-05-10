package Unit;

public class Goblin extends Monster {

    public Goblin(){
        setName("고블린");
        setHpMax(500);
        setHp(500);
        setRageMax(100);
        setRage(100);
        setAtk(30);
        setAtkSpeed(1);
        System.out.println("고블린 출현");
    }

    @Override
    public void run(){
        Goblin goblinInstance = new Goblin();
    }

}
