package AlgoExSolutions.Medium.RemoveKthNodeFromTheEnd;

// import java.util.*;

/**
 * * Remove Kth Node From The End
 */
class Program {
  public static void removeKthNodeFromEnd(LinkedList head, int k) {
    // Write your code here.
    LinkedList fastTracker = head, slowTracker = head;
    int currentPos = 0;

    while (currentPos++ < k) fastTracker = fastTracker.next;

    if (fastTracker == null) {
      head.value = head.next.value;
      head.next = head.next.next;
      return;
    }

    while (fastTracker.next != null) {
      slowTracker = slowTracker.next;
      fastTracker = fastTracker.next;
    }

    slowTracker.next = slowTracker.next.next;
  }

  static class LinkedList {
    int value;
    LinkedList next = null;

    public LinkedList(int value) {
      this.value = value;
    }
  }
}
