package ArrayList;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(10);
        list.add(1);
        list.add(null);
        list.add(4);
        list.add(1);
        list.add(1);
        list.add(1);
        list.add(5);

        //System.out.println(list);
        //System.out.println(list.size());
        //System.out.println(list.get(3));
        //System.out.println(list.indexOf(1));
        //System.out.println(list.lastIndexOf(1));
        //list.set(2,15);
        //System.out.println(list.contains(123123));
        //System.out.println(list.remove((1));
        //list.addAll(list); //for string arrayList

        Iterator<Integer> itr = list.iterator();
        while(itr.hasNext()){
            //System.out.println(itr.next());
        }
        /*for (Integer element : list){
            System.out.println(element);
        }*/

    }
}
