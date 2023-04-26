import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        // Create a list of books
        ArrayList<Book> books = new ArrayList<>();
        books.add(new Book("Book 1", 150, "Author 1", "01-01-2020"));
        books.add(new Book("Book 2", 200, "Author 2", "01-01-2018"));
        books.add(new Book("Book 3", 80, "Author 3", "01-01-2015"));
        books.add(new Book("Book 4", 250, "Author 4", "01-01-2017"));
        books.add(new Book("Book 5", 120, "Author 5", "01-01-2019"));
        books.add(new Book("Book 6", 180, "Author 6", "01-01-2021"));
        books.add(new Book("Book 7", 300, "Author 7", "01-01-2016"));
        books.add(new Book("Book 8", 90, "Author 8", "01-01-2014"));
        books.add(new Book("Book 9", 220, "Author 9", "01-01-2013"));
        books.add(new Book("Book 10", 100, "Author 10", "01-01-2022"));

        // Create a Map with title as key and author as value
        Map<String, String> map = new TreeMap<>();
        books.forEach(book ->map.put(book.getName(),book.getAuthorName()));
        map.forEach((name, author) -> System.out.println("Book Name : " + name + ", Author : " + author));

        List<Book> books100 = books.stream().filter(book -> book.getPageCount() > 100).toList();
        System.out.println("\nBooks with more than 100 pages:");
        books100.forEach(book -> System.out.println("Book Name: " + book.getName() + ", Page Count: " + book.getPageCount()));

    }
}
