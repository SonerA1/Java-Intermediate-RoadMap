package PrintStream;

import java.io.FileNotFoundException;
import java.io.PrintStream;

public class Main {
    public static void main(String[] args) {
        System.out.print("Java102");
        System.out.print(true);

        try{
            PrintStream output = new PrintStream("print.txt") ;
            output.print("123" + 123);
            output.close();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }
}
