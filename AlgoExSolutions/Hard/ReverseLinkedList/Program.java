package AlgoExSolutions.Hard.ReverseLinkedList;

// import java.util.*;

/**
 * * Reverse Linked List
 */
class Program {
  public static LinkedList reverseLinkedList(LinkedList head) {
    // Write your code here.
    LinkedList nextNode = head, prevNode = null, currNode = null;

    while (nextNode != null) {
      currNode = nextNode;
      nextNode = nextNode.next;

      currNode.next = prevNode;
      prevNode = currNode;
    }

    return currNode;
  }

  static class LinkedList {
    int value;
    LinkedList next = null;

    public LinkedList(int value) {
      this.value = value;
    }
  }
}
