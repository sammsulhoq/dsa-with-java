package avltrees;

public class MyAVLTree {
    private class AVLNode {
        private int value;
        private AVLNode leftChild;
        private AVLNode rightChild;

        public AVLNode(int item) {
            this.value = item;
        }

        @Override
        public String toString() {
            return "Node=" + value;
        }
    }
    private AVLNode root;

    public void insert(int newItem) {
        root = insert(root, newItem);
    }

    private AVLNode insert(AVLNode node, int newItem) {
        var newNode = new AVLNode(newItem);
        if (node == null)
            return newNode;

        if (newItem < node.value) {
            node.leftChild = insert(node.leftChild, newItem);
        } else {
            node.rightChild = insert(node.rightChild, newItem);
        }

        return root;
    }

    private boolean isEmpty(AVLNode node) {
        return node.leftChild == null && node.rightChild == null;
    }
}
