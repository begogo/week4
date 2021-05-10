package Unit;

public class Warrior extends Player {

    public Warrior (){
        setName("전사");
        setHpMax(1000);
        setHp(1000);
        setRageMax(100);
        setRage(100);
        setAtk(100);
        setAtkSpeed(0.1);
        System.out.println("전사입니다");
    }

    void bash(){
    }

    void berserk(){
    }

}
