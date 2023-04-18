package BookSorter;

import java.util.Locale;

public class Book implements Comparable<Book> {

    private String bookName;
    private int pageNumber;
    private String author;
    private String date;

    public Book(String bookName, int pageNumber, String author, String date) {
        this.bookName = bookName;
        this.pageNumber = pageNumber;
        this.author = author;
        this.date = date;
    }

    public String getBookName(){
        return bookName;
    }
    public int getPageNumber(){
        return pageNumber;
    }

    @Override
    public int compareTo(Book o) {
        return this.getBookName().compareTo(o.getBookName());
    }

    @Override
    public String toString() {
        return "Book : " + bookName +
                " ,Page Number : " + pageNumber +
                ", Author : " + author +
                ", Book Date : " + date;
    }
}
