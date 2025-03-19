package avltrees;

public class MyAVLTree {
    private class AVLNode {
        private int value;
        private AVLNode leftChild, rightChild;
        private int height;

        public AVLNode(int value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return "Node=" + this.value + ", Height=" + this.height;
        }

        public void setHeight(int height) {
            this.height = height;
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

        node.height = Math.max(heightOfNode(node.leftChild), heightOfNode(node.rightChild)) + 1;
        return node;
    }

    private int heightOfNode(AVLNode node) {
        return node == null ? -1 : node.height;
    }
}
