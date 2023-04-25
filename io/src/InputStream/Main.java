package InputStream;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        try {
            //File file = new File("Java102.txt");
            FileInputStream input = new FileInputStream("java.txt");
            //System.out.println(input.read());
            int i = input.read();
            while(i != -1){
                System.out.println((char) i);
                i=input.read();
            }
            input.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());


        }
    }
}
