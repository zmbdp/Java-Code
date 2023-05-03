package singlelist;

/**
 * 制空链表
 */

public class RetSleList {
    public void retSleList(MySingleList.ListNode head) {
        while (head != null) {
            //调用尾删
            head = new DelTailSleList().delTailSleList(head);
        }
    }
}
