package operation;
import book.Book;
import book.BookList;
import java.util.Scanner;

public class BorrowOperation implements IOperation{
    @Override
    public void word(BookList bookList) {
        int count = bookList.getBookSize();
        for (int i = 0; i < count; i++) {
            System.out.println(bookList.getBook(i));
        }
        Scanner sc = new Scanner(System.in);
        System.out.print("请输入你需要借的书->");
        String name = sc.nextLine();
        for (int i = 0; i < count; i++) {
            Book book = bookList.getBook(i);
            if (book.getName().equals(name)) {
                book.setBorrowed(true);
            }
        }
    }
}
