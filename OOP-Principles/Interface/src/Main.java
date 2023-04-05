import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.print("Enter a amount : ");
        double price = scan.nextDouble();

        System.out.print("Card Number : ");
        String cardNumber = scan.next();

        System.out.print("Expriy Date :");
        String expriyDate = scan.next();

        System.out.print("CVC :");
        String cvc = scan.next();

        System.out.println("1. ABank");
        System.out.println("2. BBank");
        System.out.println("3. CBank");
        System.out.print("Choose Bank : ");
        int selectBank = scan.nextInt();

        switch (selectBank){
            case 1:
                ABank aPos = new ABank("A Bank","111","123");
                aPos.connect("127.1.1.1");
                aPos.payment(price,cardNumber,expriyDate,cvc);
                break;
            case 2:
                BBank bPos = new BBank("BBank","112","1234");
                bPos.connect("127.1.1.1");
                bPos.payment(price,cardNumber,expriyDate,cvc);
            default:
                System.out.println("Enter selectable bank");

        }
    }
}