package user;//用户就用这个包
import book.BookList;
import operation.IOperation;

abstract public class User {
    protected String name;
    public IOperation[] iOperation;//定义一个接口数组，因为不知道new多大，所以放在接口上，让子类引用并初始化
    public User(String name) {
        this.name = name;
    }
    abstract public int menu();
    public void doOperation(int choice, BookList bookList){
        this.iOperation[choice].word(bookList);
    }
}
