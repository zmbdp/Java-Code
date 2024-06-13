package erChaSouSuoShu;

public class BinarySearchTree {
    static class TreeNode {
        private int val;
        private TreeNode left;
        private TreeNode right;
        public TreeNode( int val) {
            this.val = val;
        }
    }
    private TreeNode root;

    /**
     * 构造搜索树
     * @param key 寻找的值
     * @return 找到还是没找到
     */
    public boolean insert(int key) {
        TreeNode node = new TreeNode(key);
        if (root == null) {
            root = node;
            return true;
        }
        TreeNode phead = null;
        TreeNode cur = root;
        while (cur != null) {
            if (key < cur.val) {
                phead = cur;
                cur = cur.left;
            }
            else if (key > cur.val) {
                phead = cur;
                cur = cur.right;
            }
            else {
                return false;
            }
        }
        if (key < phead.val) {
            phead.left = node;
        }
        else {
            phead.right = node;
        }
        return true;
    }

    /**
     * 寻找 val 节点
     * @param val 需要寻找的值
     * @return 找到的节点或者没找到返回空
     */
    public TreeNode search(int val) {
        TreeNode phead = root;
        while (phead != null) {
            if (val < phead.val) {
                phead = phead.left;
            }
            else if (val > phead.val){
                phead = phead.right;
            }
            else {
                break;
            }
        }
        return phead;
    }

    /**
     * 删除key节点
     * @param key 需要删除的节点
     */
    public void removeNode(int key) {
        TreeNode cur = root;
        TreeNode parent = null;
        while (cur != null) {
            if (key < cur.val) {
                parent = cur;
                cur = cur.left;
            }
            else if (key > cur.val){
                parent = cur;
                cur = cur.right;
            }
            else {
                remove(cur, parent);
                return;
            }
        }
    }

    /**
     * 删除cur这个节点
     * @param cur 子节点
     * @param parent 父节点
     */
    private void remove(TreeNode cur, TreeNode parent) {
        // 画图确定如何删，
        // 如果 cur.left == null 或者 cur.right == null 或者 cur.left && cur.right != null
        // 一共分三个情况
        // 先看 cur.left == null 的情况
        // 每种又分两种情况：如果 cur == root 和 cur ！= root；
        /*===============================================================================================*/

        // 先来 cur.left == null 的情况
        if (cur.left == null){
            //当 cur.left == null && cur == root 时，直接让 root = cur.right 就可以了；
            if (cur == root) {
                root = root.right;
            }
            // 当 cur != root
            else {
                // 这个就代表cur在父亲节点的左边，直接让父亲节点的left = cur.right
                if (parent.left == cur) {
                    parent.left = cur.right;
                }
                // 证明在右边，让父亲节点的 right = cur.right
                else {
                    parent.right = cur.right;
                }
            }
        }
        // 右边是空
        else if (cur.right == null) {
            if (root == cur) {
                root = root.left;
            }
            // 如果 cur 在父亲的左边
            else if (parent.left == cur) {
                parent.left = cur.left;
            }
            // 如果在右边
            else {
                parent.right = cur.left;
            }
        }
        // 左右都不是空
        // 两种方法，找左树的最大值，或者找右树的最小值
        else {
            // 如果等于头
            if (cur == root) {
                TreeNode rRight = root.right;
                TreeNode pRight = root.right;
                TreeNode pRightParent = pRight;
                while (pRight != null) {
                    pRightParent = pRight;
                    pRight = pRight.left;
                }
                pRightParent.left = root.left;
                root.left = null;
                root.right = null;
                root = rRight;
            }
            // 如果不等于头
            else {
                TreeNode pcur = cur.right;
                TreeNode ppcurparent = pcur;
                TreeNode pleft = cur.left;
                TreeNode pright = cur.right;
                while (pcur.left != null) {
                    ppcurparent = pcur;
                    pcur = pcur.left;
                }
                // 此时出来 pcur.left 就是为空的，直接和 cur 交换
                // 判断 pcur.right 有没有数字
                if (pcur.right != null) {
                    ppcurparent.left = pcur.right;
                }
                if (cur.left != pcur) {
                    pcur.left = pleft;
                }
                if (cur.right != pcur) {
                    pcur.right = pright;
                }
                cur.left = null;
                cur.right = null;
                // 如果是等于头
                // 如果 cur 在父亲的左边
                if (parent.left == cur) {
                    parent.left = pcur;
                }
                // 如果在右边
                if (parent.right == cur) {
                    parent.right = pcur;
                }
            }
        }
    }
    public String toString(TreeNode node) {
        if (node == null) {
            return null;
        }
        return "BinarySearchTree{" +
                "root=" + node.val +
                '}';
    }
}




































