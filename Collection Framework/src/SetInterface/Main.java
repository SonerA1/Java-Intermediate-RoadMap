package SetInterface;

import java.util.HashSet;
import java.util.Iterator;

public class Main {
    public static void main(String[] args) {
        HashSet<Integer> hSet = new HashSet<>();
        hSet.add(10);
        hSet.add(20);
        hSet.add(30);
        hSet.add(null);

        //hSet.remove(10);
        //System.out.println(hSet.isEmpty()); //return boolean
        //hSet.clear();
        //for(Integer number : hSet){
            //System.out.println(number);
        //}
        Iterator<Integer> itr = hSet.iterator();
        while (itr.hasNext()){
            System.out.println(itr.next());
        }
    }
}
