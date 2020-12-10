package StacksAndQueues.Deque;

public class DequeTest {
  public static void main(String[] args) {

    Deque<Integer> deque = new Deque<>();
    System.out.println("Deque created.");

    // should be 0
    System.out.println("\nSize of the deque: " + deque.size());

    System.out.println("\nAdding items...");
    deque.addFront(10);
    deque.addFront(20);
    deque.addFront(30);
    deque.addRear(40);
    deque.addRear(50);
    deque.addRear(60);
    deque.addFront(70);
    deque.addRear(80);

    // should be 70, 30, 20, 10, 40, 50, 60, 80
    System.out.println("\nQueue items: " + deque.toString());

    // should be 8
    System.out.println("\nSize of the deque: " + deque.size());

    System.out.println("\nRemoving items from the front...");
    System.out.println(deque.removeFront()); // should be 70
    System.out.println(deque.removeFront()); // should be 30
    System.out.println(deque.removeFront()); // should be 20

    // should be 5
    System.out.println("\nSize of the deque: " + deque.size());

    System.out.println("\nRemoving items from the rear...");
    System.out.println(deque.removeRear()); // should be 80
    System.out.println(deque.removeRear()); // should be 60
    System.out.println(deque.removeRear()); // should be 50
    System.out.println(deque.removeRear()); // should be 40
    System.out.println(deque.removeRear()); // should be 10

    // should be true
    System.out.println("\nIs the deque empty? " + deque.isEmpty());
  }
}
