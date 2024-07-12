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
        TreeNode cur = root;
        TreeNode curParent = null;
        while (cur != null) {
            // 如果比它小就往左边走
            if (key < cur.val) {
                curParent = cur;
                cur = cur.left;
            }
            // 如果比它大就往右边走
            else if (key > cur.val) {
                curParent = cur;
                cur = cur.right;
            }
            // 如果相等就提醒用户已存在，然后返回 false
            else {
                System.out.println("该值得节点已存在!!!");
                return false;
            }
        }
        // 出来判断到底是大还是小
        if (key < curParent.val) {
            curParent.left = node;
        }
        else {
            curParent.right = node;
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
            else if (val > phead.val) {
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
        // 先找到节点
        TreeNode cur = root;
        TreeNode parent = null;
        while (cur != null) {
            if (key < cur.val) {
                parent = cur;
                cur = cur.left;
            }
            else if (key > cur.val) {
                parent = cur;
                cur = cur.right;
            }
            else {
                remove(cur, parent);
                break;
            }
        }
        System.out.println("未找到该节点!!!");
    }

    /**
     * 删除cur这个节点的内部实现方法
     * @param cur 子节点
     * @param parent 父节点
     */
    private void remove(TreeNode cur, TreeNode parent) {
        // 左边是空
        if (cur.left == null) {
            // 判断是不是头
            if (cur == root) {
                root = root.right;
            }
            // 如果不是头
            else {
                // 判断是左还是右
                if (cur == parent.left) {
                    parent.left = cur.right;
                }
                else {
                    parent.right = cur.right;
                }
            }
        }
        // 右边是空
        else if (cur.right == null) {
            // 判断是不是头
            if (cur == root) {
                root = root.left;
            }
            // 如果不是头
            else {
                // 判断是左还是右
                if (cur == parent.left) {
                    parent.left = cur.left;
                }
                else {
                    parent.right = cur.left;
                }
            }
        }
        // 左右都不是空
        else {
            // 先找到右边的最小值
            TreeNode pcur = cur.right;
            TreeNode pparent = cur;
            while (pcur.left != null) {
                pparent = pcur;
                pcur = pcur.left;
            }
            cur.val = pcur.val;
            // 然后删除这个替罪的节点
            // 又到了待删除的节点左边是空的情况了
            if (pcur == pparent.left) {
                pparent.left = pcur.right;
            }
            else {
                pparent.right = pcur.right;
            }
        }
    }
}




































