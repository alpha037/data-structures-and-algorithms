package AlgoExSolutions.Easy.RemoveDuplicatesFromLinkedList;

// import java.util.*;

/**
 * * Remove Duplicates From Linked List
 */
class Program {
  // This is an input class. Do not edit.
  public static class LinkedList {
    public int value;
    public LinkedList next;

    public LinkedList(int value) {
      this.value = value;
      this.next = null;
    }
  }

  public LinkedList removeDuplicatesFromLinkedList(LinkedList linkedList) {
    // Write your code here.
    if (linkedList == null || linkedList.next == null) return linkedList;

    LinkedList dummy = new LinkedList(-1);
    dummy.next = linkedList;
    LinkedList head = linkedList;

    while (head.next != null) {
      if (head.value == head.next.value) head.next = head.next.next;
      else head = head.next;
    }

    return dummy.next;
  }
}
