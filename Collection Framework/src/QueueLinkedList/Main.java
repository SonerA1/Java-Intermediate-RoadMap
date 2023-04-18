package QueueLinkedList;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static void main(String[] args) {
        Queue<String> q = new LinkedList<>();

        q.add("Soner");
        q.add("A1");
        q.offer("SonerA1");
        // q.remove(); // empty remove first element
        //System.out.println(q.remove("A1"));
        //System.out.println(q.element());

        System.out.println(q.poll());
        System.out.println("--------");

        System.out.println(q.peek());
        System.out.println("--------");


        Iterator<String> itr = q.iterator();

        while (itr.hasNext()) {
            System.out.println(itr.next());
        }
    }
}
