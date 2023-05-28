package binarytree;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        BinaryTree binaryTree = new BinaryTree();
        BinaryTree.TreeNode treeNodeA = new BinaryTree.TreeNode('A');
        BinaryTree.TreeNode treeNodeB = new BinaryTree.TreeNode('B');
        BinaryTree.TreeNode treeNodeC = new BinaryTree.TreeNode('C');
        BinaryTree.TreeNode treeNodeD = new BinaryTree.TreeNode('D');
        BinaryTree.TreeNode treeNodeE = new BinaryTree.TreeNode('E');
        BinaryTree.TreeNode treeNodeF = new BinaryTree.TreeNode('F');
        BinaryTree.TreeNode treeNodeG = new BinaryTree.TreeNode('G');
        BinaryTree.TreeNode treeNodeH = new BinaryTree.TreeNode('H');
        BinaryTree.TreeNode treeNodeI = new BinaryTree.TreeNode('I');
        treeNodeA.left = treeNodeB;
        treeNodeA.right = treeNodeC;
        treeNodeB.left = treeNodeD;
        treeNodeB.right = treeNodeE;
        treeNodeC.left = treeNodeF;
        treeNodeC.right = treeNodeG;
        treeNodeD.left = treeNodeH;
        treeNodeH.right = treeNodeI;
        //
        System.out.println("=========前序遍历=========");
        binaryTree.preOrder(treeNodeA);
        System.out.println();
        //
        System.out.println("=========中序遍历=========");
        binaryTree.inOrder(treeNodeA);
        System.out.println();
        //
        System.out.println("=========后序遍历=========");
        binaryTree.postOrder(treeNodeA);
        System.out.println();
        //
        System.out.println("=========获取有多少个元素=========");
        System.out.println(binaryTree.size(treeNodeA));
        //
        System.out.println("=========获取有多少个叶子节点=========");
        System.out.println(binaryTree.getLeafNodeCount(treeNodeA));
        //
        System.out.println("=========获取k层节点的个数=========");
        System.out.println(binaryTree.getKLevelNodeCount(treeNodeA,3));
        //
        System.out.println("=========返回查找元素=========");
        System.out.println(treeNodeA);
        System.out.println(treeNodeB);
        System.out.println(treeNodeC);
        System.out.println(treeNodeD);
        System.out.println(treeNodeE);
        System.out.println(treeNodeF);
        System.out.println(treeNodeG);
        System.out.println(treeNodeH);
        System.out.println(treeNodeI);
        System.out.println("->");
        System.out.println(binaryTree.find(treeNodeA,'A'));
        System.out.println(binaryTree.find(treeNodeA,'B'));
        System.out.println(binaryTree.find(treeNodeA,'C'));
        System.out.println(binaryTree.find(treeNodeA,'D'));
        System.out.println(binaryTree.find(treeNodeA,'E'));
        System.out.println(binaryTree.find(treeNodeA,'F'));
        System.out.println(binaryTree.find(treeNodeA,'G'));
        System.out.println(binaryTree.find(treeNodeA,'H'));
        System.out.println(binaryTree.find(treeNodeA,'I'));
        //
        System.out.println("=========判断树的深度=========");
        System.out.println(binaryTree.getHeight(treeNodeA));
        //
        System.out.println("=========层序遍历=========");
        List<List<Character>> ret = binaryTree.levelOrder(treeNodeA);
        System.out.println(ret);
        System.out.println("=========判断是否是完全二叉树=========");
        System.out.println(binaryTree.isCompleteTree(treeNodeA));//应该输出false
    }
}





















