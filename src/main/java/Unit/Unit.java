package Unit;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

public abstract class Unit implements Runnable {
    Scanner scan = new Scanner(System.in);
    private int id; //실제 쓰진 않음
    private String name;
    private int hpMax;
    private int hp;
    private int rageMax;
    private int rage;
    private int str;
    private int atk;
    private int dmg; // str과 atk 이용해 계산
    private double atkSpeed;
    private Unit target;
    private int level;
    private int xpRq;
    private int xp;
    private int monsterXp;
    private int coin; // 플레이어 보유 골드
    private int coinDrop; // 몬스터가 드랍하는 골드

    @Override
    public void run(){
        try {
            attack(getTarget());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    /* this의 공격 로직 */
    public void attack (Unit target) throws InterruptedException {
        /* 스킬 스레드 로직 */
        Thread skill = new Thread(()->{
            while (!Thread.currentThread().isInterrupted() && target.getHp() > 0){
                int input = 0;
                while (true) {
                    try{
                        input = scan.nextInt();
                        break;
                    } catch (InputMismatchException ime){
                        System.out.println(">>>>>> 스킬은 정수만 입력 가능합니다.");
                        scan = new Scanner(System.in);
                    }
                }
                if (target.getHp()==0) {
                    System.out.println("대상이 없습니다.");
                } else if (input==1 && target.getHp()>0) {
                    target.setHp(Math.max( 0, target.getHp() - getDmg()*2 ));
                    System.out.println(getName() + "이(가) **분쇄** 스킬로 " + target.getName() + "에게 "
                            + getDmg()*2 + " 피해를 입혔습니다. ("+target.getName()+"의 현재체력: "+target.getHp()+")\n" +
                            "!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
                } else {
                    System.out.println(">>>>>> 발동 가능한 스킬 입력이 아닙니다.");
                }
            }
        });
        /* 플레이어/몬스터 구분 */
        if(target instanceof Monster){
            System.out.println();
            System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
            System.out.println("@@@@@@@@@@@@@ "+target.getName()+" 출현!! @@@@@@@@@@@@@@");
        }
        /* 전투 loop */
        while (getHp() > 0 && target.getHp() > 0){
            target.setHp(Math.max( 0, target.getHp() - getDmg() ));
            if(this instanceof Player) callStatus();
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(getName() + "이(가) **기본공격** 으로 " + target.getName() + "에게 "
                    + getDmg() + " 피해를 입혔습니다. ("+target.getName()+"의 현재체력: "+target.getHp()+")\n" +
                    "----------------------------!!! 숫자 입력으로 스킬 사용 가능 !!!------------------------");
            /* 스킬 스레드 실행 조건: this==Player && 스킬 스레드 호출 안된 상태 */
            if(this instanceof Player && skill.getState() == Thread.State.NEW) {
                skill.setDaemon(true);
                skill.start();
            }
            /* 공격속도 */
            try {
                Thread.sleep((long) (3000*(1-getAtkSpeed())));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } //while loop
        /* 스킬 스레드 종료 */
        skill.interrupt(); // 전투종료 시 스킬 스레드 종료
        /* interrupt로 종료가 안돼서 join 사용 */
        if (skill.getState() == Thread.State.RUNNABLE){
            System.out.println("정상적인 전투종료를 위해 스킬을 입력하세요.");
            skill.join();
        }
        /* 전투결과 */
        if (getHp() == 0 && this instanceof Player) {
            System.out.println("플레이어 사망, 전투종료");
            gameOver();
        } else if (target.getHp() == 0 && target instanceof Monster) {
            monsterDeath(target);
        }
    }
    /* 몬스터 처치: 경험치 상승, 전리품 획득 */
    public void monsterDeath(Unit target) {
        System.out.println("########################몬스터 처치#####################");
        System.out.println("##   "+target.getName() + "을(를) 해치웠습니다. " + "경험치 " + target.getMonsterXp() + ", 코인 " + target.getCoinDrop() + "획득   ##");
        System.out.println("######################################################");
        xpGet(target);
        loot(target);
    }
    /* 경험치 상승: 요구치 채울 시 레벨업 */
    public void xpGet(Unit target){
        setXp(getXp()+target.getMonsterXp());
        if(getXp() >= getXpRq()) levelUp();
    }
    /* 레벨업: 레벨상승, xp리셋, 힘상승, 최대체력상승, 체력전체회복 */
    public void levelUp(){
        int strGain = 5;
        int hpMaxGain = 200;
        System.out.println();
        System.out.println();
        System.out.println("레벨 업!! 레벨 "+(getLevel()+1)+":  힘 "+strGain+" 상승 + 최대체력 "+hpMaxGain+" 상승 및 체력회복");
        System.out.println();
        setLevel(getLevel()+1);
        setXp(getXp() - getXpRq());
        setXpRq((int) (1000*getLevel()*0.5));
        setStr(getStr() + strGain);
        setDmg( (int)(getAtk()*(1+((double)getStr()/10/100))) + getStr() );
        setHpMax(getHpMax() + hpMaxGain);
        setHp(getHpMax());
    }
    /* 전리품 획득 */
    public void loot(Unit target){
        setCoin(getCoin() + target.getCoinDrop());
    }
    /* 상태 출력 */
    public void callStatus(){
        System.out.println();
        System.out.println("******************플레이어 정보*******************");
        System.out.print("직업:"+getName());
        System.out.print("   레벨:"+getLevel());
        System.out.print("   경험치: "+getXp()+" / "+getXpRq());
        System.out.println("   코인:"+getCoin());
        System.out.println("체력: "+getHp()+" / "+getHpMax());
        System.out.println("분노: "+getRage()+" / "+getRageMax());
        System.out.print("힘:"+getStr());
        System.out.print("   공격력:"+getAtk());
        System.out.print("   피해량:"+getDmg());
        System.out.println("   공격속도:"+getAtkSpeed());
        System.out.println("************************************************");
    }
    /* 게임오버 */
    public void gameOver() {
        System.out.println("게임종료");
        System.exit(0);
    }


    //getter&setter
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

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

    synchronized public int getHp() {
        return hp;
    }

    synchronized public void setHp(int hp) {
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

    public int getDmg() {
        return dmg;
    }

    public void setDmg(int dmg) {
        this.dmg = dmg;
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

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getStr() {
        return str;
    }

    public void setStr(int str) {
        this.str = str;
    }

    public int getXpRq() {
        return xpRq;
    }

    public void setXpRq(int xpRq) {
        this.xpRq = xpRq;
    }

    public int getXp() {
        return xp;
    }

    public void setXp(int xp) {
        this.xp = xp;
    }

    public int getMonsterXp() {
        return monsterXp;
    }

    public void setMonsterXp(int monsterXp) {
        this.monsterXp = monsterXp;
    }

    public int getCoin() {
        return coin;
    }

    public void setCoin(int coin) {
        this.coin = coin;
    }

    public int getCoinDrop() {
        return coinDrop;
    }

    public void setCoinDrop(int coinDrop) {
        this.coinDrop = coinDrop;
    }
}

