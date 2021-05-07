package Unit;

public abstract class Unit implements Runnable {

    public Unit(){
    }

    public void attack (Unit attacker, Unit target){
        for (int i=0; i<10; i++){
            System.out.println(attacker.toString()+"은(는) 기본공격으로 "+target.toString()+"에게 피해를 입혔습니다.");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}

