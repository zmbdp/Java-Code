package singlelist;

/**
 * 随便删
 */

public class DelControlledSleList {
    public MySingleList.ListNode controlledDeletion(int pos, MySingleList.ListNode head) {
        MySingleList.ListNode phead = head;

        //如果第一个就是空，说明有问题
        if (head == null) {
            System.out.println("传入链表错误!!!");
            return null;
        }
        //没问题的话就找到它
        else {
            while ((phead.next != null) && (pos > 1)) {
                phead = phead.next;
                pos--;
            }
            if ((phead.next == null) && (pos > 1)) {
                System.out.println("输入下标非法!!!");
                return null;
            }
            //如果结点走到最后了，pos == 1;说明是尾删
            if ((phead.next == null) && (pos == 1)) {
                head = new DelTailSleList().delTailSleList(phead);
            }
            //有可能是头删
            if (pos == 0) {
                head = head.next;
            }
            //到这里说明找到了
            else {
                //先把它next->next存起来
                MySingleList.ListNode tmp = phead.next.next;
                //再把它自己的next->next制空
                phead.next.val = 0;
                phead.next.next = null;
                //再把tmp给它下一个节点
                phead.next = tmp;
            }
        }
        return head;
    }
}
