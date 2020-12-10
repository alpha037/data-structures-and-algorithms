package Trees.MinHeap;

public class MinHeapTest {
  public static void main(String[] args) {
    MinHeap heap1 = new MinHeap(11);

    heap1.insert(3);
    heap1.insert(2);
    heap1.insert(-1);
    heap1.insert(10);
    heap1.insert(15);
    heap1.insert(5);
    heap1.insert(4);
    heap1.insert(45);
    heap1.insert(-125);
    heap1.insert(25);
    heap1.insert(57);

    heap1.display();

    // should be 11
    System.out.println("Current capacity: " + heap1.capacity());

    // should be 11
    System.out.println("Current capacity: " + heap1.size());

    // should be -125
    System.out.println("Min extracted: " + heap1.extractMin());

    // should be -1
    System.out.println("Min value (not extracted): " + heap1.getMin());

    heap1.decreaseKey(2, 1);

    // should be 1
    System.out.println("Min extracted: " + heap1.extractMin());

    heap1.display();

    // should be 11
    System.out.println("Current capacity: " + heap1.capacity());

    // should be 9
    System.out.println("Current capacity: " + heap1.size());

    // should be 5
    System.out.println("Value deleted: " + heap1.delete(5));

    // should be 4
    System.out.println("Value deleted: " + heap1.delete(2));

    // should be 15
    System.out.println("Value deleted: " + heap1.delete(4));

    heap1.display();

    // should be 11
    System.out.println("Current capacity: " + heap1.capacity());

    // should be 6
    System.out.println("Current capacity: " + heap1.size());

    MinHeap heap2 = new MinHeap(11, new int[] {10, 9, 8, 26, -1});

    heap2.display();

    // should be 11
    System.out.println("Current capacity: " + heap2.capacity());

    // should be 5
    System.out.println("Current capacity: " + heap2.size());

    // should be -1
    System.out.println("Min extracted: " + heap2.extractMin());

    heap2.display();

    // should be 10
    System.out.println("Value deleted: " + heap2.delete(2));

    // should be 9
    System.out.println("Value deleted: " + heap2.delete(1));

    heap2.display();

    // should be 11
    System.out.println("Current capacity: " + heap2.capacity());

    // should be 2
    System.out.println("Current capacity: " + heap2.size());

    // should be 8
    System.out.println("Min extracted: " + heap2.extractMin());
  }
}
