package singlelist;

/**
 * 打印链表
 */

public class PrintSleList {
    public PrintSleList(MySingleList.ListNode head) {
        System.out.print("已完成：");
        MySingleList.ListNode p2 = head;
        while (p2 != null) {
            System.out.print(p2.val + "->");
            p2 = p2.next;
        }
        System.out.println();
    }
}
