package LinkedLists.CycleChecker;

public class CycleChecker {
  public static boolean hasCycles(Node head) {

    Node fastPointer = head;
    Node slowPointer = head;

    /**
     * * Floyd's Cycle-Finding Algorithm
     */

    // If there's a cycle, then the fastPointer and the slowPointer
    // has to be at the same node at least once
    while (fastPointer.next != null) {
      fastPointer = fastPointer.next.next;
      slowPointer = slowPointer.next;

      if (fastPointer == slowPointer) return true;
    }

    return false;
  }
}
