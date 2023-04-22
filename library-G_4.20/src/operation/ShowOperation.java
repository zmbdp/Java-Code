package operation;
import book.Book;
import book.BookList;

public class ShowOperation implements IOperation{
    @Override
    public void word(BookList bookList) {
        System.out.println("显示图书！");
        int counbt = bookList.getBookSize();
        for (int i = 0; i < counbt; i++) {
            Book book = bookList.getBook(i);
            System.out.println(book);
        }
    }
}
