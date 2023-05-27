import javax.xml.ws.soap.Addressing;

class Solution {
    public class ListNode {
        int val;
        ListNode next;

        ListNode() {}

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Solution solution = new Solution();
        ListNode p1 = l1;
        ListNode p2 = l2;
        int num1 = 0;
        int num2 = 0;
        ListNode retHead = new ListNode();
        ListNode pr = retHead;
        while (p1 != null || p2 != null) {
            //直接反着加，有进位往后面进
            num1 += p1 == null ?  0 : p1.val;
            num2 += p2 == null ?  0 : p2.val;
            int sum = num1 + num2;
            ListNode tmp = new ListNode(sum % 10);
            pr.next = tmp;
            if (sum >= 10) {
                num1 = (sum / 10);
                num2 = 0;
            }
            else {
                num1 = 0;
                num2 = 0;
            }
            p1 = p1.next;
            p2 = p2.next;
            pr = pr.next;
        }
        if (num1 > 0) {
            pr.next = new ListNode(num1);
        }
        return retHead.next;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        Solution.ListNode n1 = new Solution().new ListNode(9);
        Solution.ListNode n2 = new Solution().new ListNode(9);
        Solution.ListNode n3 = new Solution().new ListNode(9);
        Solution.ListNode n4 = new Solution().new ListNode(9);
        Solution.ListNode n5 = new Solution().new ListNode(9);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        n5.next = null;//023451
        Solution.ListNode p1 = new Solution().new ListNode(1);
        Solution.ListNode p2 = new Solution().new ListNode(2);
        Solution.ListNode p3 = new Solution().new ListNode(3);
        Solution.ListNode p4 = new Solution().new ListNode(4);
        Solution.ListNode p5 = new Solution().new ListNode(5);
        p1.next = p2;
        p2.next = p3;
        p3.next = p4;
        p4.next = p5;
        p5.next = null;
        ListNode head = solution.addTwoNumbers(n1,p1);
        System.out.println("==================");
    }
}