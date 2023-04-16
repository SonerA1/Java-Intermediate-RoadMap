public class AgeChechException extends Exception{
    public AgeChechException(String message) {
        super(message);
        System.out.println("Age Error!");
    }
}
