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

    @Override
    public String toString() {
        return  val + "," + next;
    }
}

public class Solution {
    public static ListNode mergeKLists(ListNode[] lists) {

        /**
         * 思路：
         * 把第一个链表放过去，
         * 然后之后的链表一个一个插入
         */
        if (lists.length == 1) {
            return lists[0];
        }
        ListNode head = new ListNode(0);
        if (lists.length == 0) {
            return head.next;
        }
        int i = 0;
        // 如果有节点是空的，那就走到不是空的再出来
        while ((i < lists.length) && (lists[i] == null)) {
            i++;
        }
        if (i >= lists.length) {
            return head.next;
        }
        head = lists[i];
        i++;

        while (i < lists.length) {
            // 升序
            ListNode pli = lists[i]; // 链表指针
            ListNode phead = head;// head指针
            while (pli != null) {
                phead = head;
                // 如果是头插
                if (head.val > pli.val) {
                    ListNode tmp = pli.next;
                    pli.next = head;
                    head = pli;
                    pli = tmp;
                }
                // 如果是其他地方插
                else {
                    while ((phead != null) && (phead.next != null) && (phead.next.val < pli.val)) {
                        phead = phead.next;
                    }
                    // 出来就两个，一个是head.next的值大于 pli的值了
                    // 一个就是head走到头了
                    // 如果是中间插
                    if ((phead.next != null) && (phead.next.val >= pli.val)) {
                        ListNode tmp = pli;
                        pli = pli.next;
                        tmp.next = phead.next;
                        phead.next = tmp;
                    }
                    // 如果是尾插
                    if (phead.next == null && phead.val <= pli.val) {
                        phead.next = pli;
                        pli = pli.next;
                        phead = phead.next;
                        phead.next = null;
                    }
                }
            }
            i++;
        }
        return head;
    }

    public static void main(String[] args) {
        ListNode list1 = new ListNode(1);
        ListNode list2 = new ListNode(4);
        ListNode list3 = new ListNode(5);
        list1.next = list2;
        list2.next = list3;

        ListNode list4 = new ListNode(1);
        ListNode list5 = new ListNode(3);
        ListNode list6 = new ListNode(4);
        list4.next = list5;
        list5.next = list6;

        ListNode list7 = new ListNode(2);
        ListNode list8 = new ListNode(6);
        list7.next = list8;

        ListNode[] lists = new ListNode[3];
        lists[0] = list1;
        lists[1] = list4;
        lists[2] = list7;

        ListNode list9 = null;
        ListNode[] lists1 = {list9};
        ListNode list10 = new ListNode(0);
        ListNode list11 = new ListNode(2);
        ListNode list12 = new ListNode(5);
        list10.next = list11;
        list11.next = list12;
        ListNode[] lists2 = {list10};
        ListNode[] lists3 = {list10, list1};
        ListNode list13 = new ListNode(1);
        ListNode list14 = new ListNode(0);
        ListNode[] lists4 = {list13, list14};

        ListNode list15 = new ListNode(-2);

        ListNode list16 = new ListNode(-3);
        ListNode list17 = new ListNode(-2);
        ListNode list18 = new ListNode(1);
        list16.next = list17;
        list17.next = list18;
        ListNode[] lists5 = {null, list15, list16};

        ListNode list19 = new ListNode(1);
        ListNode list20 = new ListNode(3);
        ListNode list21 = new ListNode(4);
        ListNode list22 = new ListNode(6);
        ListNode list23 = new ListNode(8);
        ListNode list24 = new ListNode(9);
        ListNode list25 = new ListNode(12);
        list19.next = list20;
        list20.next = list21;
        list21.next = list22;
        list22.next = list23;
        list23.next = list24;
        list24.next = list25;

        ListNode list26 = new ListNode(1);
        ListNode list27 = new ListNode(2);
        ListNode list28 = new ListNode(5);
        ListNode list29 = new ListNode(7);
        ListNode list30 = new ListNode(11);
        ListNode list31 = new ListNode(21);
        ListNode list32 = new ListNode(24);
        list26.next = list27;
        list27.next = list28;
        list28.next = list29;
        list29.next = list30;
        list30.next = list31;
        list31.next = list32;

        ListNode list33 = new ListNode(-4);
        ListNode list34 = new ListNode(0);
        ListNode list35 = new ListNode(4);
        ListNode list36 = new ListNode(7);
        ListNode list37 = new ListNode(10);
        ListNode list38 = new ListNode(14);
        ListNode list39 = new ListNode(22);
        ListNode list40 = new ListNode(29);
        list33.next = list34;
        list34.next = list35;
        list35.next = list36;
        list36.next = list37;
        list37.next = list38;
        list38.next = list39;
        list39.next = list40;
        ListNode[] lists6 = {list19, list26, list33};
        ListNode head = mergeKLists(lists6);
        if (head != null){
            System.out.print(head.toString());
        }
    }

}