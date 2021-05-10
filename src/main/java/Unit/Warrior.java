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

}
