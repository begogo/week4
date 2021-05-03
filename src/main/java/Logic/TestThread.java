package Logic;

public class TestThread implements Runnable {
    String str;

    public TestThread(String str){
        this.str = str;
    }

    @Override
    public void run(){
        System.out.println();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
