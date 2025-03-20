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
    }
    private AVLNode root;

    public void insert(int value) {
        root = insert(root, value);
    }

    private AVLNode insert(AVLNode root, int value) {
        if (root == null)
            return new AVLNode(value);

        if (value < root.value)
            root.leftChild = insert(root.leftChild, value);
        else
            root.rightChild = insert(root.rightChild, value);

        // calculating height of the current node
        root.height = calculateHeight(root);

        // checking the balance factor to determine the type of rotation to be applied
        return balance(root);
    }

    private int calculateHeight(AVLNode node) {
        return Math.max(heightOfNode(node.leftChild), heightOfNode(node.rightChild)) + 1;
    }

    private AVLNode balance(AVLNode root) {
        if (isLeftHeavy(root)) {
            if (balanceFactor(root.leftChild) < 0)
                root.leftChild = rotateLeft(root.leftChild);

            return rotateRight(root);
        } else if (isRightHeavy(root)) {
            if (balanceFactor(root.rightChild) > 0)
                root.rightChild = rotateRight(root.rightChild);

            return rotateLeft(root);
        }

        return root;
    }

    private AVLNode rotateLeft(AVLNode root) {
        var newRoot = root.rightChild;
        root.rightChild =  newRoot.leftChild;
        newRoot.leftChild = root;

        root.height = calculateHeight(root);
        newRoot.height = calculateHeight(newRoot);

        return newRoot;
    }

    private AVLNode rotateRight(AVLNode root) {
        var newRoot = root.leftChild;
        root.leftChild = newRoot.rightChild;
        newRoot.rightChild = root;

        root.height = calculateHeight(root);
        newRoot.height = calculateHeight(newRoot);

        return newRoot;
    }

    private int heightOfNode(AVLNode node) {
        return node == null ? -1 : node.height;
    }

    private boolean isLeftHeavy(AVLNode node) {
        return balanceFactor(node) > 1;
    }

    private boolean isRightHeavy(AVLNode node) {
        return balanceFactor(node) < -1;
    }

    private int balanceFactor(AVLNode node) {
        return (node == null) ? 0 : heightOfNode(node.leftChild) - heightOfNode(node.rightChild);
    }
}
