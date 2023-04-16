import java.util.Scanner;

public class Main {

    public static void checkAge(int age) throws AgeChechException /*Exception*/ {
        if (age < 18) {
            throw new  AgeChechException("Throw Exception:");
           //throw new Exception("You are under the 18 years old");
            //2)throw new ArithmeticException("You are under the 18 years old");
            //3)throw new IndexOutOfBoundsException();
        }
        System.out.println("You are older than 18");
    }

    public static void main(String[] args) throws AgeChechException/*Exception*/{
        Scanner scan = new Scanner(System.in);
        System.out.print("Your age : ");
        int age = scan.nextInt();

        /*try{
        checkAge(age);
        }catch (Exception e){
            System.out.println("Its not your 18!");
            System.out.println(e.toString());
        }*/

       checkAge(age);

        System.out.println("Program over");
    }
}