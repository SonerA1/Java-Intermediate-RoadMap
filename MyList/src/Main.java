public class Main {
    public static void main(String[] args) {
        MyList<Integer> list = new MyList<>();
        System.out.println("List of : " + (list.isEmpty() ? "Empty" : "Full"));
        list.add(10);
        list.add(20);
        list.add(30);
        list.add(40);
        list.add(50);
        list.add(60);
        list.add(70);

        System.out.println("List of : " + (list.isEmpty() ? "Empty" : "Empty"));
        System.out.println("Indeks : " + list.indexOf(20));
        System.out.println("Indeks : " + list.indexOf(100));
        System.out.println("Indeks : " + list.lastIndexOf(20));
        Object[] dizi = list.toArray();
        System.out.println("Object arrays first element : " + dizi[0]);
        MyList<Integer> altListem = list.subList(0, 3);
        System.out.println(altListem.toString());
        System.out.println("value 20 in the list : " + list.contains(20));
        System.out.println("value 120 in the list : " + list.contains(120));
        list.clear();
        System.out.print("List emptied : ");
        System.out.println(list.toString());
    }

}