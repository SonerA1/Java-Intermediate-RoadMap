package RunnableInterface;

public class Main {
    public static void main(String[] args) {
        Counter c1 = new Counter("c1");
        Counter c2 = new Counter("c2");
        Counter c3 = new Counter("c3");

        Thread t1 = new Thread(c1);
        Thread t2 = new Thread(c2);
        Thread t3 = new Thread(c3);

        t1.start();
        t2.start();
        t3.start();
    }
}
