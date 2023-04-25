package Writer;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;

public class Main {
    public static void main(String[] args) {
        String data = "ĞÜŞİ";
        try {
            FileOutputStream fileOutput = new FileOutputStream("output.txt");

            OutputStreamWriter fileWriter = new OutputStreamWriter(fileOutput);

            fileWriter.write(data);
            fileOutput.write(data.getBytes());
            fileOutput.close();
            fileWriter.close();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
