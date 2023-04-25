package File;

import java.io.FileNotFoundException;
import java.io.FileReader;

public class Main {
    public static void main(String[] args) {

        try {
            FileReader readFile = new FileReader("java.txt");
            int i = readFile.read();
            while(i != -1){
                System.out.print((char) i);
                i = readFile.read();
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
