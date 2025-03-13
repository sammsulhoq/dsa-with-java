package queues;

import java.util.ArrayDeque;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;

public class Basic {
    public static void main(String[] args) {
        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(10);
        queue.add(20);
        queue.add(30);
        queue.add(40);
        queue.remove();
        System.out.println(queue);

        System.out.println(reverse(queue));

        // Testing Queue implemented with Array
        ArrayQueue myQueue = new ArrayQueue(5);
        myQueue.enqueue(1);
        myQueue.enqueue(2);
        myQueue.enqueue(3);
        myQueue.dequeue();
        myQueue.enqueue(4);
        myQueue.enqueue(5);
        myQueue.enqueue(6);
        System.out.println(myQueue);

        // Testing Queue implementation with two stacks
        QueueWithTwoStacks queueStack = new QueueWithTwoStacks();
        queueStack.enqueue(11);
        queueStack.enqueue(22);
        queueStack.enqueue(33);
        queueStack.dequeue();
        System.out.println(queueStack);

        // Priority Queue
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        priorityQueue.add(5);
        priorityQueue.add(1);
        priorityQueue.add(3);
        priorityQueue.add(2);
        while (!priorityQueue.isEmpty())
            System.out.println(priorityQueue.remove());

        // Testing my priority queue
        MyPriorityQueue myPriorityQueue = new MyPriorityQueue();
        myPriorityQueue.insert(5);
        myPriorityQueue.insert(1);
        myPriorityQueue.insert(3);
        myPriorityQueue.insert(2);
        myPriorityQueue.insert(4);
        myPriorityQueue.insert(-1);
        myPriorityQueue.insert(-2);
        System.out.println(myPriorityQueue);
        System.out.println(myPriorityQueue.remove());
        System.out.println(myPriorityQueue.remove());
        System.out.println(myPriorityQueue);

        // Testing Queue implementation with LinkedList
        QueueWithLinkedList<Integer> queueList = new QueueWithLinkedList<>();
        queueList.enqueue(5);
        queueList.enqueue(9);
        queueList.enqueue(11);
        System.out.println(queueList);
        System.out.println(queueList.dequeue());
        System.out.println(queueList);
    }

    public static Queue<Integer> reverse(Queue<Integer> queue) {
        Stack<Integer> stack = new Stack<>();
        while (!queue.isEmpty())
        {
            stack.push(queue.remove());
        }

        while (!stack.isEmpty()) {
            queue.add(stack.pop());
        }

        return queue;
    }
}
