package Trees.MaxHeap;

public class MaxHeapTest {
  public static void main(String[] args) {
    MaxHeap heap1 = new MaxHeap(11);

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

    // should be 57
    System.out.println("Max extracted: " + heap1.extractMax());

    // should be 45
    System.out.println("Max value (not extracted): " + heap1.getMax());

    heap1.decreaseKey(2, 1);

    // should be 45
    System.out.println("Max extracted: " + heap1.extractMax());

    heap1.display();

    // should be 11
    System.out.println("Current capacity: " + heap1.capacity());

    // should be 9
    System.out.println("Current capacity: " + heap1.size());

    // should be -1
    System.out.println("Value deleted: " + heap1.delete(5));

    // should be 4
    System.out.println("Value deleted: " + heap1.delete(2));

    // should be 3
    System.out.println("Value deleted: " + heap1.delete(4));

    heap1.display();

    // should be 11
    System.out.println("Current capacity: " + heap1.capacity());

    // should be 6
    System.out.println("Current capacity: " + heap1.size());

    MaxHeap heap2 = new MaxHeap(11, new int[] {10, 9, 8, 26, -1});

    heap2.display();

    // should be 11
    System.out.println("Current capacity: " + heap2.capacity());

    // should be 5
    System.out.println("Current capacity: " + heap2.size());

    // should be 26
    System.out.println("Max extracted: " + heap2.extractMax());

    heap2.display();

    // should be 8
    System.out.println("Value deleted: " + heap2.delete(2));

    // should be 9
    System.out.println("Value deleted: " + heap2.delete(1));

    heap2.display();

    // should be 11
    System.out.println("Current capacity: " + heap2.capacity());

    // should be 2
    System.out.println("Current capacity: " + heap2.size());

    // should be 10
    System.out.println("Max extracted: " + heap2.extractMax());
  }
}
