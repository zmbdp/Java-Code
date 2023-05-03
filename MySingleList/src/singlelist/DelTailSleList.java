package singlelist;

/**
 * 尾删
 */

public class DelTailSleList {
    public MySingleList.ListNode delTailSleList(MySingleList.ListNode head) {
        MySingleList.ListNode phead = head;
        if (phead == null) {
            System.out.println("当前链表为空!!!");
            return null;
        }
        else if (phead.next == null) {
            head.val = 0;
            head = null;
        }
        else {
            //找到倒数第二个节点
            while (phead.next.next != null) {
                phead = phead.next;
            }
            //出来说明phead.next == null;了，说明phead是最后一个节点
            phead.next.val = 0;
            phead.next = null;
            //phead = null;
        }
        return head;
    }
}
