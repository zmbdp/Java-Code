package operation;

import book.Book;
import book.BookList;

public class ShowOperation implements IOperation{
    @Override
    public void shiXian(BookList bookList) {
        int count = bookList.getBookSize();
        for (int i = 0; i < count; i++) {
            Book book = bookList.getBooks(i);
            System.out.println(book);
        }
    }
}
