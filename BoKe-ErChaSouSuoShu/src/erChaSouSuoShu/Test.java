package erChaSouSuoShu;

public class Test {
    public static void main(String[] args) {
        BinarySearchTree binarySearchTree = new BinarySearchTree();
        binarySearchTree.insert(6);
        binarySearchTree.insert(2);
        binarySearchTree.insert(4);
        binarySearchTree.insert(8);
        binarySearchTree.insert(3);
        binarySearchTree.insert(1);
        binarySearchTree.insert(7);
        binarySearchTree.insert(9);
        System.out.println(binarySearchTree.search(9));
        System.out.println("==================");
        System.out.println(binarySearchTree.search(8));
        System.out.println("==================");
        System.out.println(binarySearchTree.search(5));
        binarySearchTree.removeNode(8);
    }
}
