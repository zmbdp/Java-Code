package singlelist;

public class RemoveAllKey {
    public MySingleList.ListNode removeAllKey(int key, MySingleList.ListNode head){
        if (head == null) {
            System.out.println("该链表为空!!!");
            return null;
        }
        if (head.val == key) {//如果删了第一个key，第二、三······个还是key，不能用phead比较，因为head不会改变，还是会指向key的那个，形参的改变不会影响实参
            MySingleList.ListNode cur = head;
            while ((cur != null) && (cur.val == key)) {
                cur = cur.next;
            }
            head = cur;
        }
        MySingleList.ListNode phead = head;
        while ((phead != null) && (phead.next != null)) {
            if (phead.val == key) {
                phead.next = phead.next.next;
            }
            else if (phead.next.val == key) {//要想想最后两个都是空该怎么办?
                MySingleList.ListNode cur = phead.next;
                while ((cur != null) && (cur.val == key)) {
                    cur = cur.next;
                }
                phead.next = cur;
            }
            phead = phead.next;
        }
        System.out.println("已完成!!!");
        return head;
    }
}
