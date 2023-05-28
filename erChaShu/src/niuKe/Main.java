package niuKe;
import java.util.*;
class TreeNode {
    char val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(char val) {
        this.val = val;
    }
    TreeNode(char val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
// 注意类名必须为 Main, 不要有任何 package xxx 信息
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNextLine()) { // 注意 while 处理多个 case
            String str = in.nextLine();
            //先创建一个二叉树
            TreeNode root = chuangJian(str);
            //好了之后开始遍历
            inOrder(root);
        }
    }

    public static int i = 0;
    public static TreeNode chuangJian(String str) {
        TreeNode root = null;
        if (str.charAt(i) != '#') {
            root = new TreeNode(str.charAt(i));
            i++;
            root.left = chuangJian(str);
            root.right = chuangJian(str);
        } else {
            i++;
        }
        return root;
    }

    public static void inOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        inOrder(root.left);
        System.out.print(root.val + " ");
        inOrder(root.right);
    }



}






