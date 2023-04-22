package book;//这个包当书架

import java.util.Arrays;
import java.util.Queue;

public class BookList {//书架

    private Book[] book = new Book[10];

    private int bookSize;
    public BookList() {
        book[0] = new Book("三国演义", "罗贯中", 29.9, "小说");
        book[1] = new Book("水浒传", "施耐庵", 29.9, "小说");
        book[2] = new Book("西游记", "吴承恩", 39.9, "小说");
        bookSize = 3;
    }
    public void setBookSize(int bookSize) {
        this.bookSize = bookSize;
    }
    public int getBookSize() {
        return bookSize;
    }

    public Book getBook(int i) {
        return book[i];
    }

    public void setBook(int i, Book book) {//传下标方便很多，加在具体位置上，加一本book类型的书
        this.book[i] = book;
    }
}
