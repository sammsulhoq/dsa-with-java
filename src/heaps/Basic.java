package heaps;

public class Basic {
    public static void main(String[] args) {
        MyHeap myHeap = new MyHeap();
        myHeap.insert(10);
        myHeap.insert(5);
        myHeap.insert(17);
        myHeap.insert(4);
        myHeap.insert(22);

        System.out.println(myHeap);

        myHeap.remove();
        System.out.println(myHeap);

        myHeap.remove();
        System.out.println(myHeap);
    }
}
