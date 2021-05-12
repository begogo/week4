package Unit;

public class Goblin extends Monster {

    public Goblin(){
        setName("고블린");
        setHpMax(500);
        setHp(500);
        setRageMax(100);
        setRage(100);
        setStr(5);
        setAtk(30);
        setDmg(getAtk()*(1+getStr()/10/100) + getStr());
        setAtkSpeed(0);
        setMonsterXp(90);
        setCoinDrop(300);
        System.out.println("고블린 출현");
    }

}
