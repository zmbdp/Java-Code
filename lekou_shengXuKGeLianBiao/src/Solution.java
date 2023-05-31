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
    public static ListNode mergeKLists(ListNode[] lists) {
        //思路：
        //先让第一个链表的第一个数字进去
        //然后判断后面这些链表的0下标的数字，
        //从头开始找，一直找到大于它的数字，放到这个数字的前面，就是phead.next.val
        //如果是插入第一个，插入中间，插入最后要分开写，情况不一样
        //所以要定义一个变量，i记录到了第几个链表
        //如果中间某个ListNode[i] == null 了，那就直接i++跳到下一个链表，并且i不能大于lists.length
        ListNode head = new ListNode(0);
        if (lists.length == 0) {
            return head;
        }
        int i = 0;

        head.next = lists[i];
        lists[i] = lists[i].next;
        while (i < lists.length) {
            //每次都重新开始
            //从开始一个一个走
            ListNode phead = head;
            boolean flag = true;
            //每次拿出i下标的链表插入;
            while (phead.next != null) {
                ListNode pNext = phead.next;
                //如果头节点比它还大
                if (head.next.val > lists[i].val) {
                    //进来改变布尔值
                    flag = false;
                    //然后把[i]这个下标的链表的节点拿出来
                    ListNode top = lists[i];
                    //让这个节点往后走
                    lists[i] = lists[i].next;
                    //然后头下一个给这个节点
                    head.next = top;
                    top.next = null;
                }
                //如果中间的比他大
                if (pNext.val > lists[i].val) {
                    //进来改变布尔值
                    flag = false;
                    //先定义一个节点存好这个头
                    ListNode top = lists[i];
                    lists[i] = lists[i].next;
                    phead.next = top;
                    top.next = null;
                }
                if (phead.next != null){
                    phead = phead.next;
                }
                //如果走到最后都是比lists【i】的小的，就尾插，写一个布尔值判断
            }
            //出来了说明还差最后一个节点，如果还没插入就尾插
            if (flag) {
                phead.next = lists[i];
            }
            i++;
        }
        return head.next;
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
        ListNode head = mergeKLists(lists);
        int i = 7;
        while (head != null) {
            System.out.print(head.val + "->");
            head = head.next;
        }
    }

}