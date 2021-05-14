import Unit.*;

import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Scanner scan = new Scanner(System.in);

        HashMap<Integer,Unit> monsterList = new HashMap<>();
        monsterList.put(0,new Goblin());
        monsterList.put(1,new Orc());

        Warrior warrior = new Warrior();

        while(true) {
            System.out.print("행동을 선택하세요. ");
            System.out.println("1)몬스터 탐색   2)상점 방문");
            int input;
            while (true) {
                try{
                    input = scan.nextInt();
                    break;
                } catch (InputMismatchException ime){
                    System.out.println("메뉴는 정수만 입력 가능");
                    scan = new Scanner(System.in);
                }
            }

            switch (input){
                case 1:
                    Unit monster1 = monsterList.get((int)(Math.random()*2));
                    Thread t1 = new Thread(warrior);
                    Thread t2 = new Thread(monster1);

                    warrior.setTarget(monster1);
                    monster1.setTarget(warrior);
                    monster1.setHp(monster1.getHpMax());

                    t1.start();
                    t2.start();

                    t1.join();
                    t2.join();

                    warrior.callStatus();

            }

        }



    }




}
