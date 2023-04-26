import java.util.List;

public class Threads implements Runnable {

    List<Integer> sublist;
    List<Integer> evenList;
    List<Integer> oddlist;

    public Threads(List<Integer> sublist, List<Integer> evenList, List<Integer> oddlist) {
        this.sublist = sublist;
        this.evenList = evenList;
        this.oddlist = oddlist;
    }

    @Override
    public void run() {
        for (int i : sublist) {
            synchronized (evenList) {
                if (i % 2 == 0) {
                    System.out.println(Thread.currentThread().getName() + "Add even numbers : " + i);
                    evenList.add(i);
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        System.out.println(e.getMessage());
                    }
                }
            }
            synchronized (oddlist) {
                if (i % 2 != 0) {
                    System.out.println(Thread.currentThread().getName() + " Add odd numbers : " + i);
                    oddlist.add(i);
                }
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    System.out.println(e.getMessage());
                }
            }
        }
    }
}
