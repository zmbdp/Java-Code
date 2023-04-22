package operation;

import book.Book;
import book.BookList;

import java.util.Scanner;

public class AddOperaiton implements IOperation{
    @Override
    public void shiXian(BookList bookList) {
        int count = bookList.getBookSize();
        Scanner sc = new Scanner(System.in);
        System.out.print("书名->");
        String name = sc.nextLine();

        System.out.print("作者->");
        String author = sc.nextLine();//作者

        System.out.print("类型->");
        String type = sc.nextLine();//类型

        System.out.print("价格->");
        double price = sc.nextDouble();//价格

        Book book = new Book(name,author,price,type);//传给书，让他再初始化一本，然后传给Book这个结构体
        bookList.setBooks(bookList.getBookSize(), book);//更改Book
        bookList.setBookSize(bookList.getBookSize() + 1);//再传给setSize让他+1
    }
}
