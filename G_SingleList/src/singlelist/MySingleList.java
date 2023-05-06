package singlelist;

public class MySingleList {
    public MySingleList.ListNode head;
    class ListNode {
        public int val;
        public ListNode next;

        public ListNode(int val) {
            this.val = val;
        }
    }

    /**
     * 头插法
     */
    public void addFirst(int data){
        ListNode node = new ListNode(data);
        node.next = head;
        head = node;
    }


    /**
     * 尾插法
     * @param data
     */
    public void addLast(int data){
        ListNode phead = this.head;
        ListNode node = new ListNode(data);
        if (this.head == null) {
            this.head = node;
        }
        else {
            while (phead.next != null) {
                phead = phead.next;
            }
            phead.next = node;
        }
    }


    /**
     * 任意位置插入,第一个数据节点为0号下标
     * @param index
     * @param data
     */
    public void addIndex(int index,int data){
        if (index == 0) {
            addFirst(data);
            return;
        }
        if (index < 0) {
            System.out.println("输入错误!!!");
            return;
        }
        ListNode node = new ListNode(data);
        ListNode phead = this.head;
        while ((phead != null) && ((index - 1) > 0)) {
            phead = phead.next;
            index--;
        }
        if (index == 1) {
            node.next = phead.next;
            phead.next = node;
        }
        if ((phead == null) && (index >= 0)) {
            System.out.println("输入下标错误!!!");
            return;
        }
    }


    /**
     * 查找是否包含关键字key是否在单链表当中
     * @param key
     * @return
     */
    public boolean contains(int key){
        MySingleList.ListNode phead = this.head;
        while (phead != null) {
            if (phead.val == key) {
                return true;
            }
            phead = phead.next;
        }
        return false;
    }


    /**
     * 删除第一次出现关键字为key的节点
     * @param key
     */
    public void remove(int key){
        ListNode phead = this.head;
        if (head == null) {
            System.out.println("当前链表为空!!!");
            return;
        }
        if (this.head.val == key) {
            this.head = this.head.next;
            return;
        }
        while (phead.next != null) {
            if (phead.next.val == key) {
                ListNode node = phead.next.next;
                phead.next.next = null;
                phead.next = node;
                return;
            }
            phead = phead.next;
        }
    }


    /**
     * 删除所有值为key的节点，要求只遍历一遍
     * @param key
     */
    public void removeAllKey(int key){
        if (this.head == null) {
            System.out.println("该链表为空!!!");
            return;
        }
        if (head.val == key) {//如果删了第一个key，第二、三······个还是key，不能用phead比较，因为head不会改变，还是会指向key的那个，形参的改变不会影响实参
            ListNode cur = head;
            while ((cur != null) && (cur.val == key)) {
                cur = cur.next;
            }
            head = cur;
        }
        ListNode phead = this.head;
        while ((phead != null) && (phead.next != null)) {
            if (phead.val == key) {
                phead.next = phead.next.next;
            }
            else if (phead.next.val == key) {//要想想最后两个都是空该怎么办?
                ListNode cur = phead.next;
                while ((cur != null) && (cur.val == key)) {
                    cur = cur.next;
                }
                phead.next = cur;
            }
            phead = phead.next;
        }
        System.out.println("已完成!!!");
    }


    /**
     * 得到单链表的长度
     * @return count
     */
    public int size(){
        ListNode pehad = this.head;
        int count = 0;
        while (pehad != null) {
            count++;
            pehad = pehad.next;
        }
        return count;
    }


    public void clear() {
        this.head = null;
    }


    /**
     * 打印遍历单链表
     */
    public void show() {
        //这里不是定义了一个节点 这里只是一个引用
        ListNode cur = head;
        while (cur != null) {
            System.out.print(cur.val+" ");
            cur = cur.next;
        }
        System.out.println();
    }



    public void createList() {
        ListNode node1 = new ListNode(12);
        ListNode node2 = new ListNode(23);
        ListNode node3 = new ListNode(34);
        ListNode node4 = new ListNode(45);
        ListNode node5 = new ListNode(56);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;

        this.head = node1;
    }
}