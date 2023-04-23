package operation;

import book.Book;
import book.BookList;

import java.util.Scanner;

public class BorrowOperation implements IOperation{
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
                if (book.isBorrowed()) {
                    System.out.println("该书已经被借出！");
                }
                book.setBorrowed(true);
                return;
            }
        }
        System.out.println("未找到你需要借的书书籍！");
    }
}
