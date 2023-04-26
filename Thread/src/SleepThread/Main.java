package SleepThread;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Counter c1 = new Counter("c1",1);
        Thread t1 = new Thread(c1);

        t1.start();
        Thread.sleep(2000);
        c1.stop();

        /*Counter c2 = new Counter("c2",2);
        Thread t2 = new Thread(c2);
        t2.start();
        Thread.sleep(3000);
        c2.stop();*/
    }
}
