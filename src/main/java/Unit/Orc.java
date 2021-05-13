package Unit;

public class Orc extends Monster {

    public Orc() {
        setId(1);
        setName("오크");
        setHpMax(700);
        setHp(700);
        setRageMax(100);
        setRage(100);
        setStr(5);
        setAtk(40);
        setDmg(getAtk()*(1+getStr()/10/100) + getStr());
        setAtkSpeed(0);
        setMonsterXp(160);
        setCoinDrop(550);
    }
}
