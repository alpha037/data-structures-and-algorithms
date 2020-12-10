package StacksAndQueues.Queue;

public class QueueTest {
  public static void main(String[] args) {

    Queue<Integer> queue = new Queue<>();
    System.out.println("Queue created.");

    // should be 0
    System.out.println("\nSize of the queue: " + queue.size());

    System.out.println("\nEnqueueing items...");
    queue.enqueue(10);
    queue.enqueue(20);
    queue.enqueue(30);
    queue.enqueue(40);
    queue.enqueue(50);
    queue.enqueue(60);
    queue.enqueue(70);
    queue.enqueue(80);

    // should be 10, 20, 30, 40, 50, 60, 70, 80
    System.out.println("\nQueue items: " + queue.toString());

    // should be 8
    System.out.println("\nSize of the queue: " + queue.size());

    System.out.println("\nDequeueing items...");
    System.out.println(queue.dequeue()); // should be 10
    System.out.println(queue.dequeue()); // should be 20
    System.out.println(queue.dequeue()); // should be 30

    // should be 5
    System.out.println("\nSize of the queue: " + queue.size());

    System.out.println("\nDequeueing some more items...");
    System.out.println(queue.dequeue()); // should be 40
    System.out.println(queue.dequeue()); // should be 50
    System.out.println(queue.dequeue()); // should be 60
    System.out.println(queue.dequeue()); // should be 70
    System.out.println(queue.dequeue()); // should be 80

    // should be true
    System.out.println("\nIs the queue empty? " + queue.isEmpty());
  }
}
