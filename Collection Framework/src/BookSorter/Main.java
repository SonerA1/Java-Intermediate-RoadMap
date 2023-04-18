package BookSorter;

import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) {


        Book b1 = new Book("Yabancı",220,"Albert Camus","1942");
        Book b2 = new Book("Kayıp Zamanın İzinde",200,"Marcel Prousts","1913");
        Book b3 = new Book("Küçük Prens",380,"Antoine de Saint-Exupéry","1943");
        Book b4 = new Book("Insanlık Durumu",190,"André Malraux","1933");
        Book b5 = new Book("Gecenin Sonuna Yolculuk",520,"Louis-Ferdinand Céline","1932");

        TreeSet<Book> setBook  = new TreeSet<>();
        setBook.add(b1);
        setBook.add(b2);
        setBook.add(b3);
        setBook.add(b4);
        setBook.add(b5);

        System.out.println("Sorted By Book Name :");
        for (Book book : setBook){
            System.out.println(book);
        }


        TreeSet<Book> setBookP = new TreeSet<>(new Comparator<Book>() {
            @Override
            public int compare(Book o1, Book o2) {
                return o1.getPageNumber() - o2.getPageNumber();
            }
        });

        setBookP.add(b1);
        setBookP.add(b2);
        setBookP.add(b3);
        setBookP.add(b4);
        setBookP.add(b5);

        System.out.println("Sorted By Page Number :");
        for (Book book : setBookP){
            System.out.println(book);
        }
    }









}
