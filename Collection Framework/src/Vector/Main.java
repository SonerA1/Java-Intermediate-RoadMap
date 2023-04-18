package Vector;

import java.util.Iterator;
import java.util.Vector;

public class Main {
    public static void main(String[] args) {
        Vector<String> vectorr = new Vector<>();
        vectorr.add("Ankara");
        vectorr.add("Ankara");
        vectorr.add("İstanbul");
        vectorr.add("İzmir");

        vectorr.add(2, "Bolu");
        System.out.println(vectorr.contains("Ankara"));


        //Iterator<String> itr = vectorr.iterator();
        // while(itr.hasNext()){
        //System.out.println(itr.next());
        //}
        for (String str : vectorr) {
            System.out.println(str);
        }
    }
}
