package linkedlist;

public class MyLinkedList {
    private class Node {
        private int value;
        private Node next;

        public Node(int value) {
            this.value = value;
        }
    }
    private Node head;
    private Node tail;

    public MyLinkedList() {
        head = tail = null;
    }

    public void addFirst(int value) {
        var newNode = new Node(value);
        if (isEmpty()) {
            head = tail = newNode;
        } else {
            newNode.next = head;
            head = newNode;
        }
    }

    public void addLast(int value) {
        var newNode = new Node(value);

        if (isEmpty()) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
    }

    public void deleteFirst() {
        if (!isEmpty()) {
            if (head == tail) {
                head = tail = null;
            } else {
                var current = head;
                head = head.next;
                current.next = null;
            }
        }
    }

    public void deleteLast() {
        if (!isEmpty()) {
            if (head == tail) {
                head = tail = null;
            } else {
                var current = head;
                while (current != null) {
                    if (current.next == tail) {
                        tail = current;
                        current.next = null;
                    }

                    current = current.next;
                }
            }
        }
    }

    public boolean contains(int value) {
        return indexOf(value) != -1;
    }

    public int indexOf(int value){
        int index = 0;
        var current = head;
        while (current != null) {
            if (current.value == value)
                return index;

            current = current.next;
            index++;
        }

        return -1;
    }

    public int size() {
        int totalItems = 0;
        var current = head;
        while (current != null) {
            totalItems++;
            current = current.next;
        }

        return totalItems;
    }

    public int[] toArray() {
        int[] array = new int[size()];

        int index = 0;
        var current = head;
        while (current != null) {
            array[index++] = current.value;
            current = current.next;
        }

        return array;
    }

    public void reverse() {
        if (isEmpty()) return;

        var previous = head;
        var current = head.next;
        while (current != null) {
            var next = current.next;
            current.next = previous;
            previous = current;
            current = next;
        }

        tail = head;
        tail.next = null;
        head = previous;
    }

    public int getKthNodeFromEnd(int k) {
        // Using two pointer approach
        if (isEmpty())
            throw new IllegalStateException();

        var a = head;
        var b = head;

        for (int i = 0; i < k - 1; i++) {
            b = b.next;
            if (b == null)
                throw new IllegalArgumentException();
        }

        while (b != tail) {
            a = a.next;
            b = b.next;
        }

        return a.value;
    }

    public void print() {
        var current = head;
        while (current != null) {
            System.out.println(current.value);
            current = current.next;
        }
    }

    private boolean isEmpty() {
        return head == null;
    }
}
