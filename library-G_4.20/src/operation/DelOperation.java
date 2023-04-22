package operation;
import book.Book;
import book.BookList;
import java.util.Scanner;

public class DelOperation implements IOperation{
    @Override
    public void word(BookList bookList) {
        int count = bookList.getBookSize();
        Scanner sc = new Scanner(System.in);
        System.out.print("请输入你需要删除的书籍->");
        String name = sc.nextLine();
        int i = 0;
        for (i = 0; i < count; i++) {
            Book book = bookList.getBook(i);
            if (book.getName().equals(name)) {
                break;
            }
        }
        if (i >= bookList.getBookSize()) {
            System.out.println("未找到要删除的书籍!");
            return;
        }
        else {
            //利用for循环，i是那本书的位置，把i+1的书给i这里，迭代往后走
            for (int j = i + 1; j < bookList.getBookSize(); j++) {
                Book book = bookList.getBook((j));
                bookList.setBook(i,book);
                i++;
            }
            bookList.setBookSize(bookList.getBookSize() - 1);
            System.out.println("删除成功！");
        }
    }
}
