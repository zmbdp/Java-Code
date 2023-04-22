package book;

public class BookList {
    private Book[] books = new Book[10];
    private int bookSize;
    public BookList() {
        books[0] = new Book("樱花庄的宠物女孩", "鸭志田一", 29.9, "轻小说");
        books[1] = new Book("约会大作战", "橘公司&Tsunako", 69.9, "轻小说");
        books[2] = new Book("龙王的牢饭", "白鸟士郎", 29.9, "轻小说");
        bookSize = 3;
    }

    public int getBookSize() {
        return bookSize;
    }

    public void setBookSize(int bookSize) {
        this.bookSize = bookSize;
    }

    public Book getBooks(int i) {
        return books[i];
    }

    public void setBooks(int i, Book books) {
        this.books[i] = books;
    }
}
