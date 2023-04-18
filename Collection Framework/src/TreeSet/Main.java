package TreeSet;

import java.util.TreeSet;

public class Main {
    public static void main(String[] args) {

        //TreeSet<Student> std = new TreeSet<>(new OrderNoteComparator()); + .reversed
        TreeSet<Student> std = new TreeSet<>(new OrderNoteComparator2()); // alphabetic // + .reversed
        std.add(new Student("X", 20));
        std.add(new Student("Y", 100));
        std.add(new Student("Z", 45));
        std.add(new Student("A", 60));
        std.add(new Student("D", 60));
        std.add(new Student("D", 60));

        for (Student sty : std) {
            System.out.println(sty.getName());
        }

    }
}
