package ByteArrayStreams;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        /*byte[] array = {1, 2, 3, 54, 66, 6, 12, 3};
        ByteArrayInputStream input = new ByteArrayInputStream(array, 2, 66);
        System.out.println("Available byte : " + input.available());
        input.skip(2);
        int i = input.read();
        while (i != -1) {
            System.out.println(i);
            i = input.read();
        }
        try {
            input.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }*/
        String data = "Java 102";
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        byte[] dataByteArray = data.getBytes();
        try {
            output.write(dataByteArray);
            String newData = output.toString();
            System.out.println("Output : " + newData);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
