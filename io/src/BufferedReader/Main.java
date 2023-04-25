package BufferedReader;

import java.io.*;

public class Main {
    public static void main(String[] args) {
        /*try {
           FileReader readFile = new FileReader("print.txt");
            BufferedReader readBuff = new BufferedReader(readFile);
            //String line = readBuff.readLine();

            while(line != null){
                System.out.println(line);
                line = readBuff.readLine()
            }//
            String line ;
            while((line = readBuff.readLine()) !=null){
                System.out.println(line + "#######");
            }
        } catch (Exception e) {
            throw new RuntimeException(e);

        }*/

        String data = "JAVALEARNING";
        File file = new File("output1.txt");
        try {

            FileWriter writeFile = new FileWriter(file);
            BufferedWriter writeBuff = new BufferedWriter(writeFile);

            writeBuff.close();
            writeBuff.close();

        } catch (Exception e) {
            throw new RuntimeException(e);
        }


    }
}
