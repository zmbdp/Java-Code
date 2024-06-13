package erChaSouSuoShu;

import java.lang.reflect.Array;
import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        BinarySearchTree binarySearchTree = new BinarySearchTree();
        binarySearchTree.insert(9);
        binarySearchTree.insert(5);
        binarySearchTree.insert(3);
        binarySearchTree.insert(2);
        binarySearchTree.insert(0);
        binarySearchTree.insert(12);
        binarySearchTree.insert(1);
        binarySearchTree.insert(4);
        binarySearchTree.insert(11);
        binarySearchTree.insert(6);
        binarySearchTree.insert(7);
        binarySearchTree.insert(8);
        binarySearchTree.removeNode(9);
        System.out.println(binarySearchTree.toString(binarySearchTree.search(14)));
        System.out.println("====");
        Scanner sc = new Scanner(System.in);
        System.out.println(sc.nextLine());// 读一整行
        System.out.println(sc.nextInt());
        System.out.println(sc.next());// 读空格前
    }
}
























