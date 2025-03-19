package avltrees;

public class MyAVLTree {
    private class AVLNode {
        private int value;
        private AVLNode leftChild, rightChild;

        public AVLNode(int value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return "Node=" + this.value;
        }
    }
    private AVLNode root;

    public void insert(int value) {
        root = insert(root, value);
    }

    private AVLNode insert(AVLNode node, int value) {
        if (node == null)
            return new AVLNode(value);

        if (value < node.value)
            node.leftChild = insert(node.leftChild, value);
        else
            node.rightChild = insert(node.rightChild, value);

        return node;
    }
}
