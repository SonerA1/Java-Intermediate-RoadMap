package PrintWriter;

import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class Main {
    public static void main(String[] args) {
        String data = "Java 102 !!!";

        try {
            PrintWriter writer = new PrintWriter("output1.txt");
            writer.println(data);
            writer.close();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
