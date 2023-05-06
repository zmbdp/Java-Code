package singlelist;

public class Test {
    public static void main(String[] args) {
        MySingleList mySingleList = new MySingleList();
        //在里面写的单链表
        //mySingleList.createList();

        //头插
        mySingleList.addFirst(1);
        mySingleList.addFirst(2);
        mySingleList.addFirst(3);
        mySingleList.addFirst(4);
        mySingleList.addFirst(5);
        mySingleList.addFirst(6);
        mySingleList.addFirst(7);

        //打印单链表
        mySingleList.show();

        //查找数字
        System.out.println(mySingleList.size());
        System.out.println(mySingleList.contains(12));
        System.out.println(mySingleList.contains(34));
        System.out.println(mySingleList.contains(56));
        System.out.println(mySingleList.contains(156));
        mySingleList.show();

        //随便插
        mySingleList.addIndex(7,19);//末尾
        mySingleList.addIndex(8,19);//末尾
        mySingleList.addIndex(9,19);//末尾
        mySingleList.addIndex(9,19);//末尾
        mySingleList.addIndex(9,19);//末尾

        mySingleList.addIndex(2,19);//中间
        mySingleList.addIndex(2,19);//中间
        mySingleList.addIndex(2,19);//中间
        mySingleList.addIndex(6,19);//中间
        mySingleList.addIndex(12,19);//中间
        mySingleList.addIndex(15,19);//中间

        mySingleList.addIndex(0,19);//头节点
        mySingleList.addIndex(0,19);//头节点
        mySingleList.addIndex(0,19);//头节点
        mySingleList.addIndex(0,19);//头节点
        mySingleList.addIndex(0,19);//头节点
        mySingleList.show();

        //删除一个值
        mySingleList.remove(19);
        mySingleList.show();

        //删除所有值
        mySingleList.removeAllKey(19);
        mySingleList.show();

        //制空函数
        mySingleList.clear();

    }
}
