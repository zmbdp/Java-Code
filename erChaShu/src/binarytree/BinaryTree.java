package binarytree;
import java.util.*;

public class BinaryTree {
    public static class TreeNode {
        private char val;
        public TreeNode left;
        public TreeNode right;

        public TreeNode(char val) {
            this.val = val;
        }
    }

    // 前序遍历
    public void preOrder(TreeNode root) {
        if (root != null) {
            System.out.print(root.val + "->");
        }
        if (root != null && root.left != null) {
            preOrder(root.left);
        }
        if (root != null && root.right != null) {
            preOrder(root.right);
        }
    }
    // 中序遍历
    public void inOrder(TreeNode root) {
        if (root != null && root.left != null) {
            inOrder(root.left);
        }
        if (root != null) {
            System.out.print(root.val + "->");
        }
        if (root != null && root.right != null) {
            inOrder(root.right);
        }
    }

    // 后序遍历
    public void postOrder(TreeNode root) {
        if (root != null && root.left != null) {
            postOrder(root.left);
        }
        if (root != null && root.right != null) {
            postOrder(root.right);
        }
        if (root != null) {
            System.out.print(root.val + "->");
        }
    }



    // 获取树中节点的个数
    public int size(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return size(root.left) + size(root.right) + 1;
    }


    // 获取叶子节点的个数
    public int getLeafNodeCount(TreeNode root) {
        if (root == null) {
            return 0;
        }
        // 判断是叶子节点才+1
        if (root.left == null && root.right == null) {
            return getLeafNodeCount(root.left) + getLeafNodeCount(root.right) + 1;
        }
        return getLeafNodeCount(root.left) + getLeafNodeCount(root.right);
    }


    // 子问题思路-求叶子结点个数
    // 获取第K层节点的个数
    public int getKLevelNodeCount(TreeNode root,int k) {
        int ret = 0;
        if (k > 1 && root.left != null) {
            ret += getKLevelNodeCount(root.left, k - 1);
        }
        if (k > 1 && root.right != null) {
            ret += getKLevelNodeCount(root.right, k - 1);
        }
        if (k == 1 && root != null) {
            return ret + 1;
        }
        else {
            return ret;
        }
    }


    // 获取二叉树的高度
    public int getHeight(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(getHeight(root.left), getHeight(root.right)) + 1;
    }


    // 检测值为value的元素是否存在并返回
    public TreeNode find(TreeNode root, int val) {
        // 为空证明这边找完了，没找到，返回空
        if (root == null) {
            return null;
        }
        // 如果找到了就返回
        if (root.val == val) {
            return root;
        }
        TreeNode leftret = find(root.left, val);
        // 如果左边为空，表示左边没找到，去右边找，找到了返回右边，不然就返回空，反之也是如此
        if (leftret == null) {
            return find(root.right, val);
        }
        else {
            return leftret;
        }
    }


    //层序遍历
    public void levelOrder2(TreeNode root) {
        Queue<TreeNode> queue = new ArrayDeque<>();
        //先入队列
        if (root != null) {
            queue.offer(root);
        }
        //队列不是空再往下走
        while (!queue.isEmpty()) {
            //刚弹进去的节点拿出来，然后打印这个节点的数值
            TreeNode tmp = queue.poll();
            System.out.print(tmp.val + "->");
            //如果左右不是空继续入队
            if (tmp.left != null) {
                queue.offer(tmp.left);
            }
            if (tmp.right != null) {
                queue.offer(tmp.right);
            }
        }

    }

    public List<List<Character>> levelOrder(TreeNode root) {
        List<List<Character>> ret = new ArrayList<>();
        if (root == null) {
            return ret;
        }
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Character> list = new ArrayList<>();
            while (size != 0) {
                TreeNode top = queue.poll();
                list.add(top.val);
                if (top.left != null) {
                    queue.offer(top.left);
                }
                if (top.right != null) {
                    queue.offer(top.right);
                }
                size--;
            }
            ret.add(list);
        }
        return ret;
    }


    // 判断一棵树是不是完全二叉树
    public boolean isCompleteTree(TreeNode root) {
        if (root == null) {
            return true;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        //Queue<TreeNode> queue = new ArrayDeque<>();//顺序表的队列不能装null节点
        queue.offer(root);
        //运用队列的思想，层序遍历，如果不是空就全部入队列，找到空就出来，如果空格的后面还有元素就不是完全二叉树
        while (!queue.isEmpty()) {
            TreeNode top = queue.poll();
            if (top != null) {
                queue.offer(top.left);
                queue.offer(top.right);
            }
            else {
                break;
            }
        }
        //出来说明已经找到一个空了，但是队列没有空
        int size = queue.size();
        while (size != 0) {
            if (queue.peek() == null) {
                return false;
            }
            queue.poll();
            size--;
        }
        List<Integer> list = new LinkedList<>();
        System.out.println(list.size());
        return true;
    }










}
