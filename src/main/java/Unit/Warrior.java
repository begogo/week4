package Unit;

public class Warrior extends Player {

    public Warrior (){
        setName("전사");
        setHpMax(1000);
        setHp(1000);
        setRageMax(100);
        setRage(100);
        setStr(20);
        setAtk(110);
        setDmg( (int)(getAtk()*(1+((double)getStr()/10/100))) + getStr() );
        setAtkSpeed(0.1);
        setLevel(1);
        setXpRq(500);
        setXp(0);
        setCoin(1000);
        System.out.println("전사입니다");
    }

    void bash(){
    }

    void berserk(){
    }

}
