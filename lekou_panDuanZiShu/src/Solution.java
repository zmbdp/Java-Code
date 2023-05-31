import javax.swing.tree.TreeNode;

class Solution {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public boolean isSameTree(TreeNode p, TreeNode q) {
        if ((p == null) && (q != null)) {
            return false;
        }
        if ((p != null) && (q == null)) {
            return false;
        }
        if ((p == null) && (q == null)) {
            return true;
        }
        if (p.val != q.val) {
            return false;
        }
        return (isSameTree(p.left, q.left) && isSameTree(p.right, q.right));
    }

    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        //先判断是否相同
        boolean head = isSameTree(root, subRoot);
        if (head) {
            return true;
        }
        return (isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot));
    }
}