package Readers;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;

public class Main {
    public static void main(String[] args) {
        try {
            FileInputStream fileInput = new FileInputStream("print.txt");

            InputStreamReader  fileReader = new InputStreamReader(fileInput, Charset.forName("Big5"));
            System.out.println(fileReader.getEncoding());
            int i = fileReader.read();
            while(i != -1){
                System.out.println((char) i);
                i = fileReader.read();
            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
