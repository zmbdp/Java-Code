package shuanglianbiao;

public class MyLinkedList {
    public static ListNode head;
    static class ListNode {
        public int val;
        public ListNode prev;
        public ListNode next;

        public ListNode(int val) {
            this.val = val;
        }
    }


    /**
     * 头插法
     * @param data
     */
    public void addFirst(int data){
        ListNode node = new ListNode(data);
        if (head == null){
            node.next = head;
            node.prev = null;
        }
        else {
            node.next = head;
            node.prev = null;
            head.prev = node;
        }
        head = node;

    }


    /**
     * 尾插法
     * @param data
     */
    public void addLast(int data){
        ListNode node = new ListNode(data);
        ListNode phead = head;
        if (head == null) {
            node.next = head;
            node.prev = head;
            head = node;
        }
        else {
            while (phead.next != null) {
                phead = phead.next;
            }
            phead.next = node;
            node.prev = phead;
        }
    }


    /**
     * 任意位置插入,第一个数据节点为0号下标
     * @param index
     * @param data
     */
    public void addIndex(int index,int data){
        //假如是头插
        if (index == 0) {
            addFirst(data);
        }
        ListNode node = new ListNode(data);
        if (head == null) {
            System.out.println("链表为空，不可插入!!!");
            return;
        }
        ListNode phead = head;
        while ((phead.next != null) && ((index - 1) > 0)) {
            phead = phead.next;
            index--;
        }
        if (index > 1) {
            System.out.println("输入下标错误!!!");
            return;
        }
        if ((index == 1) && (phead.next == null)) {//这就说明是尾插
            phead.next = node;
            node.prev = phead;
        }
        else if ((index == 1) && (phead.next != null)){//说明不是最后一个节点
            node.next = phead.next;
            phead.next.prev = node;
            phead.next = node;
            node.prev = phead;
        }
    }


    /**
     * 查找是否包含关键字key是否在单链表当中
     * @param key
     * @return
     */
    public boolean contains(int key){
        if (head == null) {
            return false;
        }
        ListNode phead = head;
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
        if (head == null) {
            System.out.println("链表为空!!!");
            return;
        }
        if (head.next == null) {
            //如果只有一个节点，并且该节点的val就是key，如果按照下面去删，操作它的next，就会空指针异常
            if (head.val == key) {
                head = null;
            }
            return;
        }
        ListNode phead = head;
        while (phead != null) {
            //如果是在开头的情况
            if ((phead.prev == null) && (phead.val == key)) {
                ListNode nex = phead.next;
                phead.next = null;
                nex.prev = null;
                head = nex;
                return;
            }
            //如果是在中间的情况
            if ((phead.next != null) && (phead.val == key)) {
                ListNode pre = phead.prev;
                ListNode nex = phead.next;
                phead.next = null;
                phead.prev = null;
                pre.next = nex;
                nex.prev = pre;
                return;
            }
            //如果是在末尾的情况
            if ((phead.next == null) && (phead.val == key)) {
                ListNode pre = phead.prev;
                phead.prev = null;
                pre.next = null;
                return;
            }
            phead = phead.next;
        }
        System.out.println("未找到!!!");
    }


    /**
     * 删除所有值为key的节点
     * @param key
     */
    public void removeAllKey(int key){
        if (head == null) {
            System.out.println("链表为空!!!");
            return;
        }
        ListNode phead = head;
        while (phead != null) {

            //在开头的情况==================
            if ((phead.prev == null) && (phead.val == key)) {
                ListNode cur = phead.next;
                while ((cur != null) && (cur.val == key)) {
                    cur = cur.next;
                }
                //走到中间没走到末尾
                if (cur != null) {
                    cur.prev.next = null;
                    cur.prev = null;
                    head = cur;
                    phead = cur;
                }
                //走到末尾
                if (cur == null) {
                    head = null;
                    return;
                }
            }

            //在中间的情况==================
            if ((phead.next != null) && (phead.val == key)) {
                ListNode cur = phead.next;
                phead = phead.prev;
                while ((cur != null) && (cur.val == key)) {
                    cur = cur.next;
                }
                //开头在中间，结束走到中间没还走到末尾
                if (cur != null) {
                    phead.next.prev = null;
                    cur.prev.next = null;
                    phead.next = cur;
                }
                //走到末尾
                if (cur == null) {
                    phead.next.prev = null;
                    phead.next = cur;
                }
            }

            //在末尾的情况==================
            if ((phead.next == null) && (phead.val == key)) {
                ListNode pre = phead.prev;
                phead.prev = null;
                pre.next = null;
                phead = pre;
            }
            phead = phead.next;
        }
        System.out.println("已完成!!!");
    }


    /**
     * 得到链表的长度
     * @return
     */
    public int size(){
        int count = 0;
        ListNode phead = head;
        while(phead != null) {
            count++;
            phead = phead.next;
        }
        return count;
    }


    /**
     * 打印链表
     */
    public void display(){
        ListNode phead = head;
        while (phead != null) {
            System.out.print(phead.val + "->");
            phead = phead.next;
        }
        System.out.println();
    }


    /**
     * 制空链表
     */
    public void clear(){
        ListNode phead = head;
        while (phead != null) {
            ListNode pheadNext = phead.next;
            phead.prev = null;
            phead.next = null;
            phead.val = 0;
            phead = pheadNext;
        }
        head = phead = null;
    }

}
