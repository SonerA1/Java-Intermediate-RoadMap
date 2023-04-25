package OutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {


        String text = "\nOutputStream learning.\nJava";
        try {
            File file = new File("java.txt");
            FileOutputStream output = new FileOutputStream("java.txt",true);
            byte[] textByte = text.getBytes();
            output.write(textByte);
            output.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
