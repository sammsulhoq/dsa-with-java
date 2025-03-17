package binarytrees;

public class MyBinaryTree {
    private class Node {
        private int value;
        private Node leftChild;
        private Node rightChild;

        public Node(int value) {
            this.value = value;
            this.leftChild = null;
            this.rightChild = null;
        }

        @Override
        public String toString() {
            return "Node=" + value;
        }
    }
    private Node root;

    public void insert(int item) {
        Node newNode = new Node(item);
        if (root == null) {
            root = newNode;
        } else {
            var currentNode = root;
            while (true) {
                if (item < currentNode.value) {
                    if (currentNode.leftChild == null) {
                        currentNode.leftChild = newNode;
                        break;
                    }
                    currentNode = currentNode.leftChild;
                }
                else{
                    if (currentNode.rightChild == null) {
                        currentNode.rightChild = newNode;
                        break;
                    }
                    currentNode = currentNode.rightChild;
                }
            }
        }
    }

    public boolean find(int value) {
        if (root == null)
            return false;

        var currentNode = root;
        while (currentNode != null) {
            if (currentNode.value == value)
                return true;
            else if (currentNode.value < value)
                currentNode = currentNode.leftChild;
            else
                currentNode = currentNode.rightChild;
        }

        return false;
    }

    public void traversePreOrder() {
        traversalPreOrder(root);
    }

    public void traverseInOrder() {
        traversalInOrder(root);
    }

    public void traversePostOrder() {
        traversalPostOrder(root);
    }

    public int height() {
        return height(root);
    }

    public int min() {
        return min(root);
    }

    public boolean equals(MyBinaryTree another) {
        if (another == null)
            return false;

        return equals(root, another.root);
    }

    public boolean isBinarySearchTree() {
        return isBinarySearchTree(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    public void nodeAtKthDistance(int distance) {
        nodeAtKthDistance(root, distance);
    }

    public void traverseLevelOrder() {
        for (int i = 0; i < height(); i++)
            nodeAtKthDistance(i);
    }

    public int countLeaves() {
        return countLeaves(root);
    }

    private int countLeaves(Node node) {
        if (isLeafNode(node))
            return 1;

        return countLeaves(node.leftChild) + countLeaves(node.rightChild);
    }

    private void traversalPreOrder(Node root) {
        if (root == null)
            return;

        System.out.print(root.value);
        traversalPreOrder(root.leftChild);
        traversalPreOrder(root.rightChild);
    }

    private void traversalInOrder(Node root) {
        if (root == null)
            return;

        traversalInOrder(root.leftChild);
        System.out.print(root.value);
        traversalInOrder(root.rightChild);
    }

    private void traversalPostOrder(Node root) {
        if (root == null)
            return;

        traversalPostOrder(root.leftChild);
        traversalPostOrder(root.rightChild);
        System.out.print(root.value);
    }

    private int height(Node root) {
        if (isLeafNode(root))
            return 0;

        return 1 + Math.max(height(root.leftChild), height(root.rightChild));
    }

    private int min(Node root) {
        if (isLeafNode(root))
            return root.value;

        var left = min(root.leftChild);
        var right = min(root.rightChild);

        return Math.min(Math.min(left, right), root.value);
    }

    private boolean isLeafNode(Node root) {
        return root.leftChild == null && root.rightChild == null;
    }

    private boolean equals(Node first, Node second) {
        if (first == null && second == null)
            return true;

        if (first != null && second != null) {
            return first.value == second.value && equals(first.leftChild, second.leftChild) && equals(first.rightChild, second.rightChild);
        }

        return false;
    }

    private boolean isBinarySearchTree(Node root, int min, int max) {
        if (root == null)
            return false;

        if (root.value < min || root.value > max)
            return false;

        return isBinarySearchTree(root.leftChild, min, root.value - 1) && isBinarySearchTree(root.rightChild, root.value + 1, max);
    }

    private void nodeAtKthDistance(Node node, int distance) {
        if (node == null)
            return;

        if (distance == 0)
            System.out.println(node.value);

        nodeAtKthDistance(node.leftChild, distance - 1);
        nodeAtKthDistance(node.rightChild, distance - 1);
    }
}
