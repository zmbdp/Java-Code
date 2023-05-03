package singlelist;
import java.util.Scanner;


public class SingleList {

    /**
     * 单链表尾插函数
     * @return head
     */
    public MySingleList.ListNode addSingleList() {
        MySingleList.ListNode head = null;
        Scanner sc = new Scanner(System.in);

        int val = sc.nextInt();
        head = new AddTailSleList().addTailSleList(val, head);

        while (sc.hasNextInt()) {
            val = sc.nextInt();
            head = new AddTailSleList().addTailSleList(val, head);
        }
        return head;
    }


    /*==========================================================================================*/
    /**
     * 单链表尾删函数
     * @param phead
     * @return head
     */
    public MySingleList.ListNode delTailSleList(MySingleList.ListNode phead) {
        MySingleList.ListNode head = new DelTailSleList().delTailSleList(phead);
        return head;
    }


    /*==========================================================================================*/
    /**
     * 单链表随便插函数
     * @param head
     * @return head
     */
    public MySingleList.ListNode insertSleList(MySingleList.ListNode head) {
        MySingleList.ListNode phead = head;
        Scanner sc = new Scanner(System.in);
        System.out.print("请输入需要插入的下标->");
        int pos = sc.nextInt();
        System.out.print("请输入需要插入的数字->");
        int val = sc.nextInt();
        head = new InsertSleList().insertSleList(pos, val, phead);
        return head;
    }


    /*==========================================================================================*/
    /**
     * 单链表随便删
     * @param phead
     * @return head
     */
    public MySingleList.ListNode controlledDeletion(MySingleList.ListNode phead) {

        Scanner sc = new Scanner(System.in);
        System.out.print("请输入需要删除的下标->");
        int pos = sc.nextInt();
        MySingleList.ListNode head = new DelControlledSleList().controlledDeletion(pos, phead);
        return head;
    }


    /*==========================================================================================*/
    /**
     * 单链表打印函数
     * @param head
     */
    public void printSingleList(MySingleList.ListNode head) {
        new PrintSleList(head);
    }


    /*==========================================================================================*/
    /**
     * 单链表制空函数
     * @param head
     */
    public void retSleList(MySingleList.ListNode head) {
        new RetSleList().retSleList(head);
    }


    /*==========================================================================================*/
    /**
     * 菜单函数
     */
    public void menu() {
        System.out.println("*********************************");
        System.out.println("***** 1、插入        2、删除 *****");
        System.out.println("************ 0、退出 ************");
    }


    /**
     * 主函数
     * @param args
     */
    /*==========================================================================================*/
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        new SingleList().menu();
        System.out.print("请选择->");
        int choose = sc.nextInt();

        if (choose == 0) {
            System.out.println("退出成功!!!");
            return;
        }

        //尾插
        System.out.print("请先插入数据(使用空格隔开，停止请输入字母)->");
        MySingleList.ListNode head = new SingleList().addSingleList();
        new SingleList().printSingleList(head);
        while (choose != 0) {
            if (choose > 0) {
                switch (choose) {
                    case 1:
                        //乱插
                        head = new SingleList().insertSleList(head);
                        new SingleList().printSingleList(head);
                        break;
                    case 2:
                        //乱删
                        head = new SingleList().controlledDeletion(head);
                        new SingleList().printSingleList(head);
                        break;
                }
            }
            if (choose < 0){
                System.out.println("输入错误!!!");
            }
            new SingleList().menu();
            System.out.println("请选择->");
            choose = sc.nextInt();
        }
        System.out.println("退出成功!!!");
        new SingleList().retSleList(head);


        //尾删
        //head = new SingleList().delTailSleList(head);
        //new SingleList().printSingleList(head);


    }
}
