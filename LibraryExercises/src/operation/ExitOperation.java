package operation;

import book.BookList;

public class ExitOperation implements IOperation{
    @Override
    public void shiXian(BookList bookList) {
        System.out.println("退出程序！");
        System.exit(0);
    }
}
