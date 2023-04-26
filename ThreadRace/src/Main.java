import java.util.ArrayList;

public class Main {
    static ArrayList<Integer> mainList = new ArrayList<Integer>();
    static ArrayList<Integer> evenList = new ArrayList<Integer>();
    static ArrayList<Integer> oddList = new ArrayList<Integer>();
    public static void main(String[] args) {


        for (int i = 1; i < 10000; i++) {
            mainList.add(i);
        }
        ArrayList<ArrayList<Integer>> subLists = new ArrayList<ArrayList<Integer>>();
        for (int i = 0; i < 4; i++) {
            subLists.add(new ArrayList<Integer>());
        }
        for (int i = 0; i<mainList.size(); i++){
            subLists.get(i % 4).add(mainList.get(i));
        }
        for (int i = 0; i < 4; i++){
            Thread thread = new Thread (new Threads(subLists.get(i), evenList,oddList));
            thread.start();
        }
        System.out.println("Even Numbers : " + evenList);


        System.out.println("Odd Numbers : " + oddList);
    }
}
