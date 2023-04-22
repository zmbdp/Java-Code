package operation;
import book.Book;
import book.BookList;
import java.util.Scanner;

public class FindOperation implements IOperation{
    @Override
    public void word(BookList bookList) {
        System.out.println("查找图书！");
        int count = bookList.getBookSize();
        Scanner sc = new Scanner(System.in);
        System.out.print("请输入你需要查找的书籍->");
        String name = sc.nextLine();
        for (int i = 0; i < count; i++) {
            Book book = bookList.getBook(i);
            if (book.getName().equals(name)) {
                System.out.println(book);
                return;
            }
        }
        System.out.println("未找到");
    }
}
