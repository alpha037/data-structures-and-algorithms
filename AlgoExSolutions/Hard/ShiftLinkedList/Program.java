package AlgoExSolutions.Hard.ShiftLinkedList;

// import java.util.*;

/**
 * * Shift Linked List
 */
class Program {
  public static LinkedList shiftLinkedList(LinkedList head, int k) {
    // Write your code here.
    if (k == 0) return head;

    LinkedList tail = head, newTail = head;
    int length = 1;

    while (tail.next != null) {
      tail = tail.next;
      ++length;
    }

    int offset = Math.abs(k) % length;

    if (offset == 0) return head;

    int position = isNegative(k) ? offset : length - offset;

    while (position-- > 1) newTail = newTail.next;

    tail.next = head;
    head = newTail.next;
    newTail.next = null;

    return head;
  }

  private static boolean isNegative(int k) {
    return k < 0;
  }

  static class LinkedList {
    public int value;
    public LinkedList next;

    public LinkedList(int value) {
      this.value = value;
      next = null;
    }
  }
}
