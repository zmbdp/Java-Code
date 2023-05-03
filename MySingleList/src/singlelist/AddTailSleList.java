package singlelist;

/**
 * 尾插单链表
 */

public class AddTailSleList {
    MySingleList.ListNode addTailSleList(int val, MySingleList.ListNode head) {
        MySingleList.ListNode phead = head;

        //如果第一个就是空，说明是头节点
        if (head == null) {
            MySingleList.ListNode nex = new MySingleList().new ListNode(val);
            head = nex;
        }
        //先找尾巴
        else {
            while (phead.next != null) {
                phead = phead.next;
            }
            MySingleList.ListNode nex = new MySingleList().new ListNode(val);
            phead.next = nex;
        }

        return head;
    }
}
