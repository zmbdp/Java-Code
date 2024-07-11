import java.util.HashMap;
import java.util.Map;

class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
public class Solution2 {
    public Node copyRandomList(Node head) {
        Map<Node, Node> map = new HashMap<>();
        Node cur = head;
        // 先插入
        while(cur != null) {
            Node newNode = new Node(cur.val);
            map.put(cur, newNode);
            cur = cur.next;
        }
        cur = head;
        while(cur != null) {
            map.get(cur).next = map.get(cur.next);
            cur = cur.next;
        }
        cur = head;
        while(cur != null) {
            map.get(cur).random = map.get(cur.random);
            cur = cur.next;
        }
        return map.get(head);
    }

    public static void main(String[] args) {
        Node node1 = new Node(7);
        node1.random = null;
        Node node2 = new Node(13);
        node2.random = new Node(0);
        Node node3 = new Node(11);
        node3.random = new Node(4);
        Node node4 = new Node(10);
        node4.random = new Node(2);
        Node node5 = new Node(1);
        node4.random = new Node(0);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        Solution2 solution = new Solution2();
        solution.copyRandomList(node1);
    }
}