package SerializationAndObjectStream;

import java.io.*;

public class Main {
    public static void main(String[] args) {
        Car c1 = new Car("Audi", "A3");

        /*try {
            FileOutputStream outputFile = new FileOutputStream("car.txt");
            ObjectOutputStream output = new ObjectOutputStream(outputFile);
            output.writeObject(c1);
            output.close();
        } catch (IOException e) {
            e.printStackTrace();
        }*/

        try {
            FileInputStream inputFile = new FileInputStream("car.txt");
            ObjectInputStream inputStream = new ObjectInputStream(inputFile);
            Car newCar = (Car) inputStream.readObject();
            System.out.println(newCar.getBrand());
            System.out.println(newCar.getModel());

            inputFile.close();
            inputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
