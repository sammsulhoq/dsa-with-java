package linkedlist;

import java.util.Arrays;
import java.util.LinkedList;

public class Basic {
    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        list.add(10);
        list.add(20);
        list.add(30);
        list.addFirst(5);
        list.addLast(7);
        System.out.println(list);
        System.out.println(list.size());
        System.out.println(list.contains(20));
        System.out.println(list.indexOf(30));

        // Testing my custom LinkedList class
        MyLinkedList myList = new MyLinkedList();
        System.out.println(myList.size());
        myList.addFirst(10);
        myList.addFirst(20);
        myList.addFirst(30);
        myList.addLast(-10);
        myList.addLast(-20);
        myList.addLast(-30);
        myList.print();
        System.out.println(myList.size());
        System.out.println(myList.indexOf(10));
        System.out.println(myList.indexOf(40));
        System.out.println(myList.contains(10));
        System.out.println(myList.contains(-20));
        System.out.println(myList.contains(50));
        System.out.println(myList.getKthNodeFromEnd(3));

        var myArray = myList.toArray();
        System.out.println(Arrays.toString(myArray));

        myList.deleteFirst();
        myList.deleteLast();
        myList.deleteFirst();
        myList.deleteLast();
        myList.print();

        System.out.println(myList.size());
    }
}
