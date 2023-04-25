package Buffers;

import java.io.*;

public class Main {
    public static void main(String[] args) {
        /*try {
            FileInputStream fileInput = new FileInputStream("java.txt") ;
            BufferedInputStream buffer = new BufferedInputStream(fileInput);

            int i =buffer.read();
            while(i != -1){
                System.out.println((char) i);
                i = buffer.read();
            }
        }catch (Exception e) {
            throw new RuntimeException(e);
        }*/

        String data = "Java 102";
        try {
            FileOutputStream file = new FileOutputStream("java.txt");
            BufferedOutputStream buffFile = new BufferedOutputStream(file);

            byte[] byteArray = data.getBytes();

            buffFile.write(byteArray);
            buffFile.close();
            file.close();
        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
