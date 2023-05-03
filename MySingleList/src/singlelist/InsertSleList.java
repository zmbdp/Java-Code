package singlelist;

/**
 * 随便插
 */

public class InsertSleList {
    public MySingleList.ListNode insertSleList(int pos, int val, MySingleList.ListNode head) {
        MySingleList.ListNode phead = head;
        if ((phead == null) && (pos == 0)) {
            //说明是头插
            MySingleList.ListNode tmp = new MySingleList().new ListNode(val);
            tmp.next = head;
            return tmp;
        }
        //要找的是pos前一个结点，所以pos == 1;就出去
        while ((phead.next != null) && (pos > 1)) {
            phead = phead.next;
            pos--;
        }
        //phead.next == null;说明是最后一个节点
        if ((phead.next == null) && (pos != 1)) {
            System.out.println("输入非法下标!!!");
        }
        //如果phead走到最后了，pos也为0了，说明是尾插
        if ((phead.next == null) && (pos == 1)) {
            head = new AddTailSleList().addTailSleList(val, head);
        }
        else {
            //mallock一个结点
            MySingleList.ListNode nex = new MySingleList().new ListNode(val);
            //拿出下一个变量
            MySingleList.ListNode tmp = phead.next;
            //把nex给这个变量的下一个值
            phead.next = nex;
            //nex的next为原来的下一个节点->tmp
            nex.next = tmp;
        }
        return head;
    }
}
