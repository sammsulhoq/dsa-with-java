package arrays;

import java.util.ArrayList;
import java.util.Arrays;

public class Basic {
    public static void main(String[] args) {
        int[] numbers = new int[3];
        numbers[0] = 10;
        numbers[1] = 20;
        numbers[2] = 30;
        System.out.println(numbers);                            // prints address - [I@4f3f5b24
        System.out.println(Arrays.toString(numbers));           // prints values - [0, 0, 0]

        int[] anotherNumbers = { 40, 50, 60 };                  // Alternative way of initializing an array
        System.out.println(Arrays.toString(anotherNumbers));

        // Dynamic Arrays In Java
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        System.out.println(list.toString());
        list.remove(2);
        var isPresent = list.contains(3);
        System.out.println(isPresent);
        System.out.println(list.size());
        var listToArray = list.toArray();
        System.out.println(Arrays.toString(listToArray));

        // Testing MyArray class
        MyArray array = new MyArray(5);
        array.insert(10);
        array.insert(20);
        array.insert(30);
        array.insert(40);
        array.insert(50);
        array.insert(60);
        array.insert(70);
        array.print();
        array.removeAt(3);
        array.removeAt(5);
        array.print();
        System.out.println(array.indexOf(50));
        System.out.println(array.indexOf(100));
        System.out.println("Largest number: " + array.max());
        array.reverse();
    }
}
