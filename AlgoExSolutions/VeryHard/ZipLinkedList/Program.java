package AlgoExSolutions.VeryHard.ZipLinkedList;

// import java.util.*;

/**
 * * Zip Linked List
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

  /**
   * * TC: O(n)
   * * SC: O(1)
   */
  public LinkedList zipLinkedList(LinkedList linkedList) {
    // Write your code here.
    LinkedList start = linkedList, end = reverse(split(linkedList));
    return join(start, end);
  }

  private LinkedList split(LinkedList head) {
    LinkedList slow = head, fast = head;
    while (fast != null && fast.next != null) {
      slow = slow.next;
      fast = fast.next.next;
    }
    return slow;
  }

  private LinkedList reverse(LinkedList head) {
    LinkedList prevNode = null, nextNode = null;
    while (head != null) {
      nextNode = head.next;
      head.next = prevNode;

      prevNode = head;
      head = nextNode;
    }
    return prevNode;
  }

  private LinkedList join(LinkedList linkedListIterator1, LinkedList linkedListIterator2) {
    LinkedList head = linkedListIterator1;
    while (linkedListIterator2.next != null) {
      LinkedList iter1Next = linkedListIterator1.next;
      LinkedList iter2Next = linkedListIterator2.next;

      linkedListIterator1.next = linkedListIterator2;
      linkedListIterator2.next = iter1Next;

      linkedListIterator1 = iter1Next;
      linkedListIterator2 = iter2Next;
    }
    return head;
  }
}
