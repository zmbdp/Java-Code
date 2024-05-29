import java.util.Stack;

class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

public class Solution {
    public static ListNode rotateRight(ListNode head, int k) {
        if (head == null || k == 0) {
            return head;
        }
        /*
        思想：
        先使用栈全部存起来
        然后再放出来k + 1个
        把放出来的这个节点的下一个存好，设置成newHead
        再把这个节点制空，防止成为循环链表
        再使用指针pNewHead走到底->pNewHead.next == null
        就把他制成head
         */
        ListNode phead = head;
        Stack<ListNode> stack = new Stack<>();
        while (phead != null) {
            stack.push(phead);
            phead = phead.next;
        }
        ListNode newHeadprive = null;
        // 找到空了出来
        while ((!stack.isEmpty()) && k-- >= 0) {
            newHeadprive = stack.pop();
        }
        ListNode newHead = newHeadprive.next;
        newHeadprive.next = null;
        ListNode pNewHead = newHead;
        while (pNewHead.next != null) {
            pNewHead = pNewHead.next;
        }
        pNewHead.next = head;
        return newHead;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        int k = 1;
        rotateRight(l1, k);
    }
}