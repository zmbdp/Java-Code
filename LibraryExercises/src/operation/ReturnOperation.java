package operation;

import book.Book;
import book.BookList;

import java.util.Scanner;

public class ReturnOperation implements IOperation{
    @Override
    public void shiXian(BookList bookList) {
        int count = bookList.getBookSize();
        for (int i = 0; i < count; i++) {
            System.out.println(bookList.getBooks(i));
        }
        Scanner sc = new Scanner(System.in);
        System.out.print("请输入你需要借的书->");
        String name = sc.nextLine();
        for (int i = 0; i < count; i++) {
            Book book = bookList.getBooks(i);
            if (book.getName().equals(name)) {
                book.setBorrowed(false);
                return;
            }
        }
        System.out.println("未找到你需要还的书籍！");
    }
}
