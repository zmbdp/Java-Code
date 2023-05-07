package shuanglianbiao;

public class Test {
    public static void main(String[] args) {
        MyLinkedList myLinkedList = new MyLinkedList();
        //头插
        System.out.println("头插->");
        myLinkedList.addFirst(1);
        myLinkedList.display();
        myLinkedList.addFirst(2);
        myLinkedList.display();
        myLinkedList.addFirst(3);
        myLinkedList.display();
        myLinkedList.addFirst(4);
        myLinkedList.display();
        System.out.println("==================================");

        //尾插
        System.out.println("尾插->");
        myLinkedList.addLast(129);
        myLinkedList.display();
        myLinkedList.addLast(122);
        myLinkedList.display();
        myLinkedList.addLast(12);
        myLinkedList.display();
        myLinkedList.addLast(175);
        myLinkedList.display();
        System.out.println("==================================");

        //是否存在
        System.out.println("是否存在->?");
        System.out.println(myLinkedList.contains(4));
        System.out.println(myLinkedList.contains(175));
        System.out.println(myLinkedList.contains(122));
        System.out.println(myLinkedList.contains(22));
        System.out.println("==================================");

        //随便插
        System.out.println("随便插->");
        myLinkedList.addIndex(5,10);
        myLinkedList.display();
        myLinkedList.addIndex(0,10);
        myLinkedList.display();
        myLinkedList.addIndex(10,10);
        myLinkedList.display();
        System.out.println("==================================");

        //删除第一次
        System.out.println("删除第一次->");

        myLinkedList.remove(10);
        System.out.print(10 + "：");
        myLinkedList.display();

        myLinkedList.remove(175);
        System.out.print(175 + "：");
        myLinkedList.display();

        myLinkedList.remove(122);
        System.out.print(122 + "：");
        myLinkedList.display();

        myLinkedList.remove(999);
        System.out.print(999 + ":");
        myLinkedList.display();
        System.out.println("==================================");

        //删除全部
        myLinkedList.addFirst(4);
        myLinkedList.addFirst(4);
        myLinkedList.addFirst(4);
        myLinkedList.addFirst(4);
        myLinkedList.addFirst(4);
        myLinkedList.addIndex(7,4);
        myLinkedList.addIndex(7,4);
        myLinkedList.addIndex(8,4);
        myLinkedList.addIndex(9,4);
        myLinkedList.addIndex(10,4);
        myLinkedList.addLast(4);
        myLinkedList.addLast(4);
        myLinkedList.addLast(4);
        myLinkedList.addLast(4);
        myLinkedList.addLast(4);
        myLinkedList.addLast(4);
        myLinkedList.display();
        myLinkedList.removeAllKey(4);
        myLinkedList.display();

        //制空
        myLinkedList.clear();
    }
}
