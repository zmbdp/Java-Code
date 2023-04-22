package user;

import book.BookList;
import operation.IOperation;

abstract public class User {
    public String name;
    abstract public int menu();
    IOperation[] iOperation;

    public User(String name) {
        this.name = name;
    }
    public void chuanLian(int i, BookList bookList) {
        this.iOperation[i].shiXian(bookList);
    }
}
