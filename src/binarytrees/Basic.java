package binarytrees;

public class Basic {
    public static void main(String[] args) {
        MyBinaryTree binaryTree = new MyBinaryTree();
        binaryTree.insert(7);
        binaryTree.insert(4);
        binaryTree.insert(9);
        binaryTree.insert(1);
        binaryTree.insert(6);
        binaryTree.insert(8);
        binaryTree.insert(10);

        binaryTree.traversePreOrder();
        System.out.println();
        binaryTree.traverseInOrder();
        System.out.println();
        binaryTree.traversePostOrder();
        System.out.println("\nHeight of tree: " + binaryTree.height());
        System.out.println("Min value in tree: " + binaryTree.min());
        System.out.println(binaryTree.isBinarySearchTree());
        System.out.println();
        binaryTree.nodeAtKthDistance(1);
        binaryTree.traverseLevelOrder();
        System.out.println("Total leaves count: " + binaryTree.countLeaves());
    }

    public static int factorial (int n) {
        if (n == 0)
            return 1;
        return n * factorial(n - 1);
    }
}
