package CriticalSectionsRaceCondition;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        /*OrderMatic oMatic = new OrderMatic();
        Thread t1 = new Thread(oMatic);
        t1.start();
        t1.join();

        Thread t2 = new Thread(oMatic);
        t2.start();
        t2.join();

        System.out.println(oMatic.getOrderNo());*/

        ExecutorService pool = Executors.newFixedThreadPool(50); // ThreadPooling

        OrderMatic oMatic = new OrderMatic();


        for (int i = 0; i < 100; i++){
            pool.execute(oMatic);
        }

        System.out.println(oMatic.getOrderNo());
    }
}
