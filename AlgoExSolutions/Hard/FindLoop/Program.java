package AlgoExSolutions.Hard.FindLoop;

// import java.util.*;

/**
 * * Find Loop
 */
class Program {
  public static LinkedList findLoop(LinkedList head) {
    // Write your code here.
    LinkedList fastTracker = head, slowTracker = head;

    do {
      slowTracker = slowTracker.next;
      fastTracker = fastTracker.next.next;

    } while (fastTracker != slowTracker);

    slowTracker = head;

    while (fastTracker != slowTracker) {
      slowTracker = slowTracker.next;
      fastTracker = fastTracker.next;
    }

    return slowTracker;
  }

  static class LinkedList {
    int value;
    LinkedList next = null;

    public LinkedList(int value) {
      this.value = value;
    }
  }
}
