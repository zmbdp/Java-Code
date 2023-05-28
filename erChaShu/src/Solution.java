import binarytree.BinaryTree;

class TreeNode {
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

class Solution {
    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
        return maxDepth(root) >= 0;
    }

    //判断二叉树的高度
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int retleft = maxDepth(root.left);
        int retright = maxDepth(root.right);
        int ret = retleft - retright;
        if (ret > 1 || ret < -1) {
            return -10;
        }
        return Math.max(retleft, retright) + 1;
    }

    public static void main(String[] args) {
        TreeNode binaryTree = new TreeNode();
        TreeNode treeNodeA = new TreeNode('A');
        TreeNode treeNodeB = new TreeNode('B');
        TreeNode treeNodeC = new TreeNode('C');
        TreeNode treeNodeD = new TreeNode('D');
        TreeNode treeNodeE = new TreeNode('E');
        TreeNode treeNodeF = new TreeNode('F');
        TreeNode treeNodeG = new TreeNode('G');
        TreeNode treeNodeH = new TreeNode('H');
        TreeNode treeNodeI = new TreeNode('I');
        treeNodeA.left = treeNodeB;
        treeNodeA.right = treeNodeC;
        treeNodeB.left = treeNodeD;
        treeNodeB.right = treeNodeE;
        treeNodeC.left = treeNodeF;
        treeNodeC.right = treeNodeG;
        treeNodeD.left = treeNodeH;
        treeNodeH.left = treeNodeI;
        Solution solution = new Solution();
        solution.isBalanced(treeNodeA);
    }
}